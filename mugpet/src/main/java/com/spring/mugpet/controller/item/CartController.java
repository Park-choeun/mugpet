package com.spring.mugpet.controller.item;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.mugpet.domain.Cart;
import com.spring.mugpet.domain.Item;
import com.spring.mugpet.domain.MemberInfo;
import com.spring.mugpet.domain.OrderItem;
import com.spring.mugpet.service.CartService;
import com.spring.mugpet.service.MemberService;
import com.spring.mugpet.service.OrderItemService;

@Controller
//@SessionAttributes("sessionCart")
public class CartController {

	@Autowired
	private CartService cartService;
	@Autowired
	private MemberService memberService;
	@Autowired
	private OrderItemService orderItemService;
	private int resetPoint;
	
	public void setCartService(CartService cartService) {
		this.cartService = cartService;
	}
	
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	public void addCart(Item item) throws Exception{
		cartService.addCart(item);
	}
	
	//Cart(장바구니)에 담긴 아이템 조회 -> 장바구니 버튼 누르면 /cart/myCartList로 연결되는 방식
	@RequestMapping(value="/cart/myCartList", method=RequestMethod.GET)
	public ModelAndView getCart() throws Exception{
		List<Cart> cartItems = cartService.getMyCartList(1);	//장바구니에 담긴 아이템 조회
		System.out.println("카트 정보 : " + cartItems.get(0));
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
		ModelAndView mav = getCart();
		return mav;
	}
	
	//각각의 물품 삭제할 수 있는 메소드 =>-버튼 클릭시 사라짐
	@RequestMapping(value="/cart/removeItemFromCart", method=RequestMethod.GET)
	public ModelAndView handleRequest(@RequestParam("item_id") int item_id) throws Exception{
		cartService.removeCart(item_id);
		ModelAndView mav = getCart();
		
		return mav;
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
		ModelAndView mav = new ModelAndView("/cart/order");
		
		System.out.println("카트 아이템 개수" + cartItemSize);
		mav.addObject("cartItemsInfo", cartItemsInfo);
		mav.addObject("cartItemSize", cartItemSize);
		mav.addObject("cartItemsPrice", cartItemsPrice);
		mav.addObject("cartItemsQty", cartItemsQty);
		mav.addObject("totalPrice", totalPrice);
		mav.addObject("memberInfo", memberInfo);
		mav.addObject("applyPoints", applyPoints);
		//mav.addObject("resetPoint", resetPoint);
		return mav;
	}
	
	
//	@RequestMapping(value="/cart/updatePoints.jsp")
//	public ModelAndView applyPoint(HttpServletRequest request) throws Exception {
//		ModelAndView mav = new ModelAndView();
//		MemberInfo memberInfo = memberService.getMemberInfoByEmailandPwd("som@naver.com", "123456");
//		int allPoints = memberInfo.getPoint();
//		int applyPoints = Integer.parseInt(request.getParameter("point"));
//		try {
//			if(allPoints > 0 && allPoints > applyPoints) {
//				resetPoint = allPoints - applyPoints;
//			}
//			else {
//				applyPoints = 0;
//				resetPoint = allPoints;
//			}
//		}catch(Exception ex) {
//			
//		}
//		
//		mav.addObject("applyPoints", applyPoints);
//		mav.setViewName("/cart/order");
//		
//		List<Cart> cartItems = cartService.getMyCartList(1);	//장바구니에 담긴 아이템 조회
//		List<Item> cartItemsInfo = new ArrayList<Item>();		//Item 객체를 담을 list 생성
//		List<Integer> cartItemsPrice = new ArrayList<Integer>();		//cartItem들의 각 가격을 담은 list 생성
//		List<Integer> cartItemsQty = new ArrayList<Integer>();		//cartItem들의 각 개수를 담은 list 생성
//		int cartItemSize = cartItems.size();	//장바구니에 담긴 아이템의 개수
//		int cartItemQty = 0;
//		int totalPrice = 0;
//		int idx = 0;
//		for(Cart items : cartItems) {
//			int item_id = items.getItem_id();
//			Item info = cartService.getCartItemInfo(item_id);
//			cartItemQty = cartService.getMyCartItemQty(item_id);
//			System.out.println("카트 첫번째 아이템 이름: " + info.getItemName());
//			cartItemsInfo.add(info);
//			cartItemQty = items.getCartQty();
//			cartItemsQty.add(cartItemQty);
//			cartItemsPrice.add(cartItemQty * info.getPrice());
//			totalPrice += cartItemsPrice.get(idx);
//			idx++;
//		}		
//		System.out.println("카트 아이템 개수" + cartItemSize);
//		mav.addObject("cartItemsInfo", cartItemsInfo);
//		mav.addObject("cartItemSize", cartItemSize);
//		mav.addObject("cartItemsPrice", cartItemsPrice);
//		mav.addObject("cartItemsQty", cartItemsQty);
//		mav.addObject("totalPrice", totalPrice);
//		mav.addObject("memberInfo", memberInfo);
//		mav.addObject("resetPoint", resetPoint);
//		return mav;
//	}
	
	@ModelAttribute("orderInfo")
	@RequestMapping(value="/cart/ordering", method=RequestMethod.POST)
	public ModelAndView submit(HttpServletRequest request) throws Exception{ //매개변수 설정해야 함
		//System.out.println("결과: " + request.getParameter("point"));
		if(request.getParameter("point").isEmpty() == false) {
			ModelAndView mav = new ModelAndView("/cart/order");
			MemberInfo memberInfo = memberService.getMemberInfoByEmailandPwd("som@naver.com", "123456");
			int allPoints = memberInfo.getPoint();
			int applyPoints = Integer.parseInt(request.getParameter("point"));
			try {
				if(allPoints > 0 && allPoints > applyPoints) {
					resetPoint = allPoints - applyPoints;
				}
				else {
					applyPoints = 0;
					resetPoint = allPoints;
				}
			}catch(Exception ex) {
				
			}
			
			mav.addObject("applyPoints", applyPoints);
			mav.setViewName("/cart/order");
			
			List<Cart> cartItems = cartService.getMyCartList(1);	//장바구니에 담긴 아이템 조회
			List<Item> cartItemsInfo = new ArrayList<Item>();		//Item 객체를 담을 list 생성
			List<Integer> cartItemsPrice = new ArrayList<Integer>();		//cartItem들의 각 가격을 담은 list 생성
			List<Integer> cartItemsQty = new ArrayList<Integer>();		//cartItem들의 각 개수를 담은 list 생성
			int cartItemSize = cartItems.size();	//장바구니에 담긴 아이템의 개수
			int cartItemQty = 0;
			int totalPrice = 0;
			int idx = 0;
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
			System.out.println("카트 아이템 개수" + cartItemSize);
			mav.addObject("cartItemsInfo", cartItemsInfo);
			mav.addObject("cartItemSize", cartItemSize);
			mav.addObject("cartItemsPrice", cartItemsPrice);
			mav.addObject("cartItemsQty", cartItemsQty);
			mav.addObject("totalPrice", totalPrice);
			mav.addObject("memberInfo", memberInfo);
			mav.addObject("resetPoint", resetPoint);
			return mav;
		}
		else {
			ModelAndView mav = new ModelAndView("/cart/orderCompleted");
			MemberInfo memberInfo = memberService.getMemberInfoByEmailandPwd("som@naver.com", "123456");				
			memberService.updatePoints(resetPoint,"som@naver.com", "123456");
			
			//	orderItem에 item_id 넣는것도.
			OrderItem orderItem = new OrderItem();
			String DEFAULT = "DEFAULT";
			List<Cart> cartItems = cartService.getMyCartList(1);
			for(Cart items : cartItems) {
				orderItem.setItem_id(items.getItem_id());
				orderItem.setOrderQty(items.getCartQty());
				orderItem.setOrderAddr(memberInfo.getAddress() + request.getParameter("addressDetail"));
				orderItem.setOrderPhoneNum(memberInfo.getPhoneNum());
				orderItem.setU_id(1);
				orderItemService.insertOrderItem(orderItem);
			}
			return mav;
		}

	}
}

