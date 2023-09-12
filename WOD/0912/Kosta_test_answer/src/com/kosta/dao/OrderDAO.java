package com.kosta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kosta.order.Order;

public class OrderDAO {
	
	// 주문 추가
	public Integer insertOrder(Order order) {
		Connection conn = DBConnect.getConnection();
		PreparedStatement pstmt = null;
		String sql = "insert into `order` values(?,?,?,?,?)";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, order.getNo());
			pstmt.setString(2, order.getCustomer());
			pstmt.setString(3, order.getProductCode());
			pstmt.setInt(4, order.getAmount());
			pstmt.setBoolean(5, order.isCanceled());
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		DBConnect.close(conn);
		return order.getNo();
		// 주문 번호로 주문을 찾기 위해 주문 번호를 가져와서 반환
	}
	
	// 주문 정보 조회 메서드
	public Order selectOrder(Integer orderNo) {
		Connection conn = DBConnect.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Order order = null;
		String sql = "select * from `order` where no=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, orderNo);
			rs=pstmt.executeQuery();
			if(rs!=null && rs.next()) {
				order=new Order(rs.getInt("no"),
						rs.getString("customer"),
						rs.getString("productCode"),
						rs.getInt("amount"),
						rs.getBoolean("isCanceled"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		DBConnect.close(conn);
		return order;
	}
	
	public List<Order> selectOrderList() {
		Connection conn = DBConnect.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		List<Order> orderList = new ArrayList<>();
		String sql = "select * from `order`";
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			if(rs!=null) {
				while(rs.next()) {
					orderList.add(new Order(rs.getInt("no"),
						rs.getString("customer"),
						rs.getString("productCode"),
						rs.getInt("amount"),
						rs.getBoolean("isCanceled")));
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		DBConnect.close(conn);
		return orderList;
	}
	
	public Order updateOrderCancel(Integer orderNo) {
		Connection conn = DBConnect.getConnection();
		PreparedStatement pstmt = null;
		String sql = "update `order` set isCanceled=? where no=?";
		int cnt = 0;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setBoolean(1, true);
			pstmt.setInt(2, orderNo);
			cnt = pstmt.executeUpdate();
			// pstmt.executeUpdate(); 과정이 정상 처리 되다면 적어도 1개가 업데이트 된거여서
			// cnt의 값은 1로 될 것이다
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		DBConnect.close(conn);
		if(cnt>0) return selectOrder(orderNo); // 정상 취소 처리 되었으므로 해당 번호로 주문 정보를 조회하여 반환 
		return null; // 업데이트가 되지 않았다면 잘못된 번호로 조회한거여서 정보를 찾지 못하여 null 값 반환
	}
	
	public Map<String,Integer> selectOrderByCustomerAndIsCanceled(String customer, Boolean isCanceled) {
		Connection conn = DBConnect.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Map<String,Integer> result = new HashMap<>();
		String sql="select count(*), sum(o.amount*g.price) "
				+ "from `order` o join goods g on o.productCode=g.code "
				+ "where customer=? and isCanceled=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, customer);
			pstmt.setBoolean(2, isCanceled);
			rs=pstmt.executeQuery();
			if(rs!=null && rs.next()) {
				result.put("count", rs.getInt(1));
				result.put("amount", rs.getInt(2));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		DBConnect.close(conn);
		return result;
	}
}
