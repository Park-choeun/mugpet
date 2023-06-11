package com.spring.mugpet.controller.item;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import com.spring.mugpet.controller.member.UserSession;
import com.spring.mugpet.domain.Cart;
import com.spring.mugpet.domain.Item;
import com.spring.mugpet.domain.MemberInfo;
import com.spring.mugpet.domain.OrderItem;
import com.spring.mugpet.service.CartService;
import com.spring.mugpet.service.MemberService;
import com.spring.mugpet.service.OrderItemService;

@Controller
@SessionAttributes("userSession")
public class CartController {

	@Autowired
	private CartService cartService;
	@Autowired
	private MemberService memberService;
	@Autowired
	private OrderItemService orderItemService;
	private int resetPoints;
	
	public void setCartService(CartService cartService) {
		this.cartService = cartService;
	}
	
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
//	@ModelAttribute("sessionCart")
//	public Cart createCart(HttpSession session) {
//		Cart cart = (Cart)session.getAttribute("sessionCart");
//		if (cart == null) cart = new Cart();
//		return cart;
//	}
	
//	@ModelAttribute("userSession")
//	public MemberInfo userSession(HttpServletRequest request) {
//		MemberInfo userSession = (MemberInfo) WebUtils.getSessionAttribute(request, "userSession");
//		if ( userSession == null) {
//			return new MemberInfo();
//		}
//		else return userSession;
//		
//	} 
	
	public void addCart(Cart cart) throws Exception{
		cartService.addCart(cart);
	}
	
	//Cart(장바구니)에 담긴 아이템 조회 -> 장바구니 버튼 누르면 /cart/myCartList로 연결되는 방식
	@RequestMapping(value="/cart/myCartList", method=RequestMethod.GET)
	public ModelAndView getCart(@ModelAttribute("userSession") MemberInfo userSession) throws Exception{
	
		int u_id = userSession.getU_id();
		System.out.println("u_id: " + u_id);
		
		
		List<Cart> cartItems = cartService.getMyCartList(1);	//장바구니에 담긴 아이템 조회
		
		//System.out.println("카트 정보 : " + cartItems.get(0).getItem_id() +", " + cartItems.get(1).getItem_id() +", " +cartItems.get(2).getItem_id());
		List<Item> cartItemsInfo = new ArrayList<Item>();		//Item 객체를 담을 list 생성
		List<Integer> cartItemsPrice = new ArrayList<Integer>();		//cartItem들의 각 가격을 담은 list 생성
		List<Integer> cartItemsQty = new ArrayList<Integer>();		//cartItem들의 각 개수를 담은 list 생성
		int cartItemSize = cartItems.size();	//장바구니에 담긴 아이템의 개수
		int cartItemQty = 0;
		int totalPrice = 0;
		int idx = 0;
		for(Cart items : cartItems) {
			int item_id = items.getItem_id();
			System.out.println("아이템 아이디: " + item_id);
			Item info = cartService.getCartItemInfo(item_id);
			cartItemQty = cartService.getMyCartItemQty(item_id);
			System.out.println("카트 첫번째 아이템 이름: " + info.getItemName());
			cartItemsInfo.add(info);
			cartItemQty = items.getCartQty();
			cartItemsQty.add(cartItemQty);
			cartItemsPrice.add(cartItemQty * info.getPrice());
			totalPrice += cartItemsPrice.get(idx);
			idx++;
		}
		
		ModelAndView mav = new ModelAndView("/cart/myCartList");
		
		System.out.println("카트 아이템 개수" + cartItemSize);
		mav.addObject("cartItemsInfo", cartItemsInfo);
		mav.addObject("cartItemSize", cartItemSize);
		mav.addObject("cartItemsPrice", cartItemsPrice);
		mav.addObject("cartItemsQty", cartItemsQty);
		mav.addObject("totalPrice", totalPrice);
		
		return mav;
	}
	
	//카트에 있는 아이템 하나 클릭 시 그 아이템 상세페이지로 이동하는 url을 반환하는 메소드
	@RequestMapping("/myCartList/{item_id}")
	public String cartItemDetail(int item_id) {
		return "item/itemDetail";
	}
	
	//각 물품의 개수를 수정할 수 있는 메소드
	@RequestMapping(value="/cart/updateCartQuantities", method=RequestMethod.POST)
	public ModelAndView cartItemUpdate(HttpServletRequest request) throws Exception{
		List<Cart> cartItems = cartService.getMyCartList(1); 
		int num = 0;
		for(Cart cartItem : cartItems){
			int item_id = cartItem.getItem_id(); //아이템의 item_id를 가지고 옴
			try {
					int quantity = Integer.parseInt(request.getParameter(Integer.toString(num))); //각 아이템의 변경된 값을 가지고 옴
					cartItem.setCartQty(quantity); //cart의 개수 필드 변경 cartItem은 가져온 각 아이템
					cartService.updateCart(quantity, item_id);
				
					if(quantity < 1) {
						cartService.removeCart(item_id);
					}
			}catch(NumberFormatException ex) {
				
			}
			num++;
		}
//		ModelAndView mav = getCart(userSession(null));
//		return mav;
		return new ModelAndView("redirect:/cart/myCartList");
	}
	
	//각각의 물품 삭제할 수 있는 메소드 =>-버튼 클릭시 사라짐
	@RequestMapping(value="/cart/removeItemFromCart", method=RequestMethod.GET)
	public ModelAndView handleRequest(@RequestParam("item_id") int item_id) throws Exception{
		cartService.removeCart(item_id);
//		ModelAndView mav = getCart(userSession(null));
//		
//		return mav;
		
		return new ModelAndView("redirect:/cart/myCartList");
	}
	
	//주문하기누르면 계산 페이지로 이동하는 메소드
	@RequestMapping(value="/cart/order", method=RequestMethod.GET)
	public ModelAndView cartToOrder() throws Exception{
		List<Cart> cartItems = cartService.getMyCartList(1);	//장바구니에 담긴 아이템 조회
		List<Item> cartItemsInfo = new ArrayList<Item>();		//Item 객체를 담을 list 생성
		List<Integer> cartItemsPrice = new ArrayList<Integer>();		//cartItem들의 각 가격을 담은 list 생성
		List<Integer> cartItemsQty = new ArrayList<Integer>();		//cartItem들의 각 개수를 담은 list 생성
		int cartItemSize = cartItems.size();	//장바구니에 담긴 아이템의 개수
		int cartItemQty = 0;
		int totalPrice = 0;
		int idx = 0;
		int applyPoints = 0;
		for(Cart items : cartItems) {
			int item_id = items.getItem_id();
			Item info = cartService.getCartItemInfo(item_id);
			cartItemQty = cartService.getMyCartItemQty(item_id);
			System.out.println("카트 첫번째 아이템 이름: " + info.getItemName());
			cartItemsInfo.add(info);
			cartItemQty = items.getCartQty();
			cartItemsQty.add(cartItemQty);
			cartItemsPrice.add(cartItemQty * info.getPrice());
			totalPrice += cartItemsPrice.get(idx);
			idx++;
		}
		
		MemberInfo memberInfo = memberService.getMemberInfoByEmailandPwd("som@naver.com", "123456");
		resetPoints = memberInfo.getPoint();
		
		ModelAndView mav = new ModelAndView("/cart/order");
		
		System.out.println("카트 아이템 개수" + cartItemSize);
		mav.addObject("cartItemsInfo", cartItemsInfo);
		mav.addObject("cartItemSize", cartItemSize);
		mav.addObject("cartItemsPrice", cartItemsPrice);
		mav.addObject("cartItemsQty", cartItemsQty);
		mav.addObject("totalPrice", totalPrice);
		mav.addObject("memberInfo", memberInfo);
		mav.addObject("applyPoints", applyPoints);
		mav.addObject("resetPoints", resetPoints);
		
		return mav;
	}
	
	
	@RequestMapping(value="/cart/order", method=RequestMethod.POST)
	public ModelAndView pointUpdate(HttpServletRequest request, @ModelAttribute("command") CartCommand command) throws Exception{ //매개변수 설정해야 함
		//System.out.println("결과: " + request.getParameter("point"));
			ModelAndView mav = cartToOrder();
			MemberInfo memberInfo = memberService.getMemberInfoByEmailandPwd("som@naver.com", "123456");		
			
			int allPoints = memberInfo.getPoint();
			int applyPoints;
			if(request.getParameter("point") == "" || request.getParameter("point") == "0") { //숫자가 아니라면은 어떻게?
				return mav;
			}
			else {
				applyPoints = Integer.parseInt(request.getParameter("point"));
				try {
					if(allPoints > 0 && allPoints > applyPoints) {
						resetPoints = allPoints - applyPoints;
					}
					else {
						applyPoints = 0;
						resetPoints = allPoints;
					}
				}catch(Exception ex) {
					
				}
				
				mav.addObject("applyPoints", applyPoints);
				mav.addObject("resetPoints", resetPoints);
				
			}
			return mav;
	}
	

	@RequestMapping(value="/cart/ordering", method=RequestMethod.POST)
	public ModelAndView submit(HttpServletRequest request, @ModelAttribute("command") CartCommand command) throws Exception{ //매개변수 설정해야 함
			ModelAndView mav = new ModelAndView("/cart/orderCompleted");
			MemberInfo memberInfo = memberService.getMemberInfoByEmailandPwd("som@naver.com", "123456");
//			//멤버의 전화번호, 주소 얻어옴
//			String phoneNum = memberInfo.getPhoneNum();
//			String addr = memberInfo.getAddress() + " " + request.getParameter("addrDetail");
//			String req = request.getParameter("req");
//			System.out.println("phoneNum : " + phoneNum);
//			System.out.println("addr : " + addr);
//			System.out.println("req : " + req);
//			memberService.updatePoints(resetPoints,"som@naver.com", "123456");
//			
//			//	orderItem에 item_id 넣는것도.
			OrderItem order = new OrderItem();
			List<Cart> cartItems = cartService.getMyCartList(1);
			order.setCartItemList(cartItems);
			List<Cart> orderItems = order.getCartItemList();
			for(Cart items : orderItems) {
//				orderItem.setItem_id(items.getItem_id());
//				orderItem.setOrderQty(items.getCartQty());
//				orderItem.setOrderAddr(memberInfo.getAddress() + request.getParameter("addressDetail"));
//				orderItem.setOrderPhoneNum(memberInfo.getPhoneNum());
//				orderItem.setU_id(1);
				System.out.println(items.getItem_id());
				
			}
			return mav;
		}

	}
