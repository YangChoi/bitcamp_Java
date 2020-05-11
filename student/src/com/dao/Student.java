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
			System.out.println("����̹� �ε� ����");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public void getConnection() {
		try {
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("���� ����");
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public void menu() {

		while (true) {
			System.out.println("************************");
			System.out.println("����");
			System.out.println("************************");
			System.out.println("1. �Է�");
			System.out.println("2. �˻�");
			System.out.println("3. ����");
			System.out.println("4. ����");
			System.out.print("��ȣ ���� : ");

			int choice = scan.nextInt();

			if (choice == 4) {
				// ����
				System.out.println("���α׷� �����մϴ�.");
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
		System.out.println("1. �л�");
		System.out.println("2. ����");
		System.out.println("3. ������");
		System.out.println("4. �����޴�");
		System.out.println("******************");
		System.out.print("��ȣ ���� : ");

		int code = scan.nextInt();

		if (code == 4)
			return;
		if (code == 1) {
			// �л�
			System.out.print("�̸� �Է� : ");
			String name = scan.next();
			System.out.print("�й� �Է� : ");
			int num = scan.nextInt();

			this.getConnection();

			String sql = "insert into student values(?, ?, ?) ";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, name);
				pstmt.setInt(2, num);
				pstmt.setInt(3, code);

				int count = pstmt.executeUpdate();
				System.out.println(count + "���� ���� ����������ϴ�. ");
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
