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

	// 1. ��ġ (��ġ�� �����ڿ�)
	public UpdateTest() {
		try {
			Class.forName(driver);
			// System.out.println("����̹� �ε� ���� ");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	// 2. ����
	public void getConnection() {
		try {
			conn = DriverManager.getConnection(url, username, password);
			// System.out.println("���� ����");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
				// ������ �� �ݴ�� �����ֱ�
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

	}

	public void updateArticle() {
		Scanner scan = new Scanner(System.in);
		System.out.print("������ �̸��� �Է��ϼ��� :");
		String name = scan.next();

		// ����
		getConnection();
		String sql = "update dbtest set age = age+1, height = height+1 where name like ?";
		// ? �� % �� ���� �� ������ %?% �ȵ� : �׳� ? �� ��

		try {
			pstmt = conn.prepareStatement(sql); // ������(���̵� ����)
			// ������ ����
			pstmt.setString(1, "%" + name + "%");

			int su = pstmt.executeUpdate(); // ���� (��������!!)
			System.out.println(su + "���� �� ���� �����߽��ϴ�");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// �ȴݾ��ָ� �޸� ������ ���´�.
				// �� �ݾ��� ��
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
 * 1. ����̹� �ε� 2. ���� 3. update
 * 
 * ���� �� �̸� �Է� : ȫ�� ���� �̸��� ���̵� 1���� , Ű�� 1����
 */