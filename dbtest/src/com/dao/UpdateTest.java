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

	private String name;
	private int age;
	private double height;

	// 1. 설치
	public UpdateTest() {
		try {
			Class.forName(driver);
			System.out.println("드라이버 로딩 성공 ");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	// 2. 접속
	public void getConnection() {
		try {
			Class.forName(driver);

			System.out.println("접속 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public void updateArticle() {
		Scanner scan = new Scanner(System.in);

		this.getConnection();
		String sql = "update into dbtest set age = ?, height = ? where %name% = ?";

		try {
			conn = DriverManager.getConnection(url, username, password);

			pstmt = conn.prepareStatement(sql);

			System.out.print("수정할 이름을 입력하세요 :");
			String name = scan.next();
			int updateAge = age + 1;
			double updateHeight = height + 1;
			
			pstmt.setInt(1, updateAge);
			pstmt.setDouble(2, updateHeight);
			pstmt.setString(3, name);

			int su = pstmt.executeUpdate();
			System.out.println(su + "개의 행 수정 성공했습니다");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}
	}

	public static void main(String[] args) {
		UpdateTest updateTest = new UpdateTest();
		updateTest.updateArticle();

	}

}

/*
 * 1. 드라이버 로딩 2. 접속 3. update
 * 
 * 수정 할 이름 입력 : 홍이 들어가는 이름은 나이도 1증가 , 키도 1증가
 */