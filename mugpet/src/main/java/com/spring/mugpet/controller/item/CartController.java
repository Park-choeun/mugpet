package com.spring.mugpet.controller.item;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.mugpet.domain.Cart;
import com.spring.mugpet.domain.Item;
import com.spring.mugpet.service.CartService;

@Controller
//@SessionAttributes("sessionCart")
public class CartController {

	@Autowired
	private CartService cartService;
	
	public void setCartService(CartService cartService) {
		this.cartService = cartService;
	}
	
	//Cart(장바구니)에 담긴 아이템 조회 -> 장바구니 버튼 누르면 /cart/myCartList로 연결되는 방식
	@RequestMapping(value="/cart/myCartList", method=RequestMethod.GET)
	public ModelAndView getCart() throws Exception{
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
	public ModelAndView cartToOrder(HttpServletRequest request) throws Exception{
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

		ModelAndView mav = new ModelAndView("/cart/order");
		
		System.out.println("카트 아이템 개수" + cartItemSize);
		mav.addObject("cartItemsInfo", cartItemsInfo);
		mav.addObject("cartItemSize", cartItemSize);
		mav.addObject("cartItemsPrice", cartItemsPrice);
		mav.addObject("cartItemsQty", cartItemsQty);
		mav.addObject("totalPrice", totalPrice);
		return mav;
	}	
}
