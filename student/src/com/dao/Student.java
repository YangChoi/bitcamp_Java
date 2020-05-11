package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Student {
	Scanner scan = new Scanner(System.in);

	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "c##java";
	private String password = "bit";

	private Connection conn;
	private PreparedStatement pstmt;

	public Student() {

		try {
			Class.forName(driver);
			System.out.println("드라이버 로딩 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public void getConnection() {
		try {
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("접속 성공");
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public void menu() {

		while (true) {
			System.out.println("************************");
			System.out.println("관리");
			System.out.println("************************");
			System.out.println("1. 입력");
			System.out.println("2. 검색");
			System.out.println("3. 삭제");
			System.out.println("4. 종료");
			System.out.print("번호 선택 : ");

			int choice = scan.nextInt();

			if (choice == 4) {
				// 종료
				System.out.println("프로그램 종료합니다.");
				break;
			} else if (choice == 1) {
				insertArticle();
			} else if (choice == 2) {
				selectArticle();
			} else if (choice == 3) {
				deleteArticle();
			}
		}

	}



	// insert
	public void insertArticle() {
		System.out.println();
		System.out.println("******************");
		System.out.println("1. 학생");
		System.out.println("2. 교수");
		System.out.println("3. 관리자");
		System.out.println("4. 이전메뉴");
		System.out.println("******************");
		System.out.print("번호 선택 : ");

		int code = scan.nextInt();

		if (code == 4)
			return;
		if (code == 1) {
			// 학생
			System.out.print("이름 입력 : ");
			String name = scan.next();
			System.out.print("학번 입력 : ");
			int num = scan.nextInt();

			this.getConnection();

			String sql = "insert into student values(?, ?, ?) ";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, name);
				pstmt.setInt(2, num);
				pstmt.setInt(3, code);

				int count = pstmt.executeUpdate();
				System.out.println(count + "개의 행이 만들어졌습니다. ");
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if(pstmt != null) pstmt.close();
					if(conn != null) pstmt.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}

		}

	}
	
	// select 
	public void selectArticle() {
	
		
	}
	
	
	// delete
	public void deleteArticle() {
	
		
	}

	public static void main(String[] args) {
		new Student().menu();
	}
}
