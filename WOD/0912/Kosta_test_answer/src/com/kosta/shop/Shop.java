package com.kosta.shop;

import java.util.List;
import java.util.Map;

import com.kosta.dao.GoodsDAO;
import com.kosta.dao.OrderDAO;
import com.kosta.order.Order;
import com.kosta.product.Goods;

public class Shop {

	private GoodsDAO goodsDAO;
	private OrderDAO orderDAO;

	public Shop() { // 1. 1. Shop 객체 생성 및 변수 초기화
		goodsDAO = new GoodsDAO();
		orderDAO = new OrderDAO();
	}

	// 2. 상품 추가 서비스
	public void addProduct(Goods goods) {
		goodsDAO.insertGoods(goods); //
	}

	// 3. 주문 추가 서비스
	public Integer order(Order order) {
		// 주문 번호로 주문을 찾기 위해 객체의 주문 번호를 가져와서 반환
		Integer ordrNo = orderDAO.insertOrder(order);

		// 주문 테이블에 데이터 입력
		goodsDAO.updateProductStock(order.getProductCode(), -order.getAmount());
		// 상품 테이블의 상품 정보를 업데이트 주문 테이블의 상품 코드와, 주문 수량의 값을 가져와서 넘겨줌
		// -order.getAmount() 앞에 - 한 이유는 주문을 했기에 상품의 재고가 차감되어야 하므로 -를 붙여(음수값) 넘겨줌
		return ordrNo;
	}

	// 4. 상품 정보 조회 서비스
	public Goods findGoodsByCode(String pCode) {
		Goods goods = goodsDAO.selectGoods(pCode);
		return goods;
	}

	// 상품 전체 정보 출력 서비스
	public void printAllGoodsInfo() {
		List<Goods> goodsList = goodsDAO.selectGoodList();
		// 여러개의 상품을 한번에 for문 돌려서 출력하기 위해 list로 담아서 가져오기
		for (Goods goods : goodsList) {
			System.out.println(goods);
		}
	}

	// 전체 주문 정보 출력 서비스
	public void printAllOrderInfo() {
		List<Order> orderList = orderDAO.selectOrderList();
		// 여러개의 상품을 한번에 for문 돌려서 출력하기 위하여 list로 담아온다
		for (Order order : orderList) {
			System.out.println(order);
		}
	}
	
	// 주문 정보 조회 서비스
	public Order findOrderByNo(Integer orderNo) {
		// 주문 정보 하나 여서 객체를 반환
		// 위에서 주문시 받아온 주문 번호를 파라미터로 사용
		return orderDAO.selectOrder(orderNo);
	}

	// 주문 취소 서비스
	public Order cancelOrder(Integer orderNo) {
		// 주문 번호로 주문 정보 확인하여 주문 취소 
		Order order = orderDAO.updateOrderCancel(orderNo);
		goodsDAO.updateProductStock(order.getProductCode(), order.getAmount());
		// 주문 취소가 이뤄졌을 경우 상품의 재고수량도 변했기에 업데이트를 해줘야함
		// 여기서는 취소여서 상품의 재고가 늘어나므로 주문정보중 order.getAmount() 주문량을 양수 값으로 넘겨줌
		return order;
	}

	// 주문 내역 조회 서비스
	public void printOrderDetailsByCustomerAndIsCanceled(String customer, String cancelYN) {
		Map<String, Integer> result = null;
		//테이블을 조인컬어 컬럼명을 키값으로 선언후 컬럼의 해당 값을 벨류로 지정하여
		// 반환 값에 담아준다
		Boolean isCanceled = false;
		if (cancelYN.equals("취소")) {
			isCanceled = true;
		}
		result = orderDAO.selectOrderByCustomerAndIsCanceled(customer, isCanceled);
		System.out.println(String.format("%s님의 %s주문 건수는: %d건이고,%s주문합계금액은: %d원 입니다", customer, cancelYN,
				result.get("count"), cancelYN, result.get("amount")));
	}
}
