package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateTest {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "c##java";
	private String password = "bit";

	private Connection conn;
	private PreparedStatement pstmt;

	// 1. 설치 (설치는 생성자에)
	public UpdateTest() {
		try {
			Class.forName(driver);
			// System.out.println("드라이버 로딩 성공 ");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	// 2. 접속
	public void getConnection() {
		try {
			conn = DriverManager.getConnection(url, username, password);
			// System.out.println("접속 성공");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
				// 끊어줄 땐 반대로 끊어주기
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

	}

	public void updateArticle() {
		Scanner scan = new Scanner(System.in);
		System.out.print("수정할 이름을 입력하세요 :");
		String name = scan.next();

		// 접속
		getConnection();
		String sql = "update dbtest set age = age+1, height = height+1 where name like ?";
		// ? 와 % 는 같이 안 먹힌다 %?% 안됨 : 그냥 ? 할 것

		try {
			pstmt = conn.prepareStatement(sql); // 생성자(가이드 역할)
			// 데이터 주입
			pstmt.setString(1, "%" + name + "%");

			int su = pstmt.executeUpdate(); // 실행 (잊지말것!!)
			System.out.println(su + "개의 행 수정 성공했습니다");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// 안닫아주면 메모리 떄문에 뻗는다.
				// 꼭 닫아줄 것
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					pstmt.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}
	}

	public static void main(String[] args) {
		new UpdateTest().updateArticle();

	}

}

/*
 * 1. 드라이버 로딩 2. 접속 3. update
 * 
 * 수정 할 이름 입력 : 홍이 들어가는 이름은 나이도 1증가 , 키도 1증가
 */