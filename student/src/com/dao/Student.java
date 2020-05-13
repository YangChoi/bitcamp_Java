package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	private ResultSet rs;

	public Student() {
		// ����̹� �ε�
		try {
			Class.forName(driver); // ����
			// driver ��� Ŭ���� ������ ����ü �������̽����� ���� �𸣱� ������
			// Class.�� ���� Ŭ���� ���Ϸ� ���� ��Ű�� ��
			// System.out.println("����̹� �ε� ����");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public void getConnection() {
		try {
			conn = DriverManager.getConnection(url, username, password); // ���� �õ�
			// System.out.println("���� ����");
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
				break;
			} else if (choice == 1) {
				insertArticle();
			} else if (choice == 2) {
				selectArticle();
			} else if (choice == 3) {
				deleteArticle();
			}
		} // while()

	}// menu()

	// insert
	// �ڹٿ��� �� ���� �ڵ� commit�̴�.
	public void insertArticle() {

		int choice;
		String name = null, value = null;
		int code = 0;

		while (true) {
			System.out.println();
			System.out.println("******************");
			System.out.println("1. �л�");
			System.out.println("2. ����");
			System.out.println("3. ������");
			System.out.println("4. �����޴�");
			System.out.println("******************");
			System.out.print("��ȣ ���� : ");

			choice = scan.nextInt();
			if (choice == 4)
				break;

			// �̸��� ���� �����̹Ƿ� ������ ����.
			System.out.print("�̸� �Է� : ");
			name = scan.next();

			if (choice == 1) {
				// �л�

				System.out.print("�й� �Է� : ");
				value = scan.next();
				code = 1;

			} else if (choice == 2) {
				// ����

				System.out.print("���� �Է� : ");
				value = scan.next();
				code = 2;

			} else if (choice == 3) {
				// ������

				System.out.print("�μ� �Է� : ");
				value = scan.next();
				code = 3;

				// db
				getConnection();
				String sql = "insert into student values(?, ?, ?)";
				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, name);
					pstmt.setString(1, value);
					pstmt.setInt(3, code);

					int su = pstmt.executeUpdate();

				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					try {
						if (pstmt != null)
							pstmt.close();
						if (conn != null)
							conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}

		} // while();
	}// insert()

	// select
	public void selectArticle() {
		int choice;
		String name = null;
		while (true) {
			System.out.println();
			System.out.println("******************");
			System.out.println("1. �̸� �˻� ");
			System.out.println("2. ��ü �˻� ");
			System.out.println("3. �����޴�");
			System.out.println("******************");
			System.out.print("��ȣ ���� : ");
			choice = scan.nextInt();

			if (choice == 3)
				return;

			if (choice == 1) {
				// �˻��� �̸� �Է�
				System.out.println();
				System.out.print("�˻��� �̸��� �Է��ϼ��� : ");
				name = scan.next();

			} else if (choice == 2) {
				// �̸� ��ü �˻�

			}

			getConnection();
			String sql = null;

			if (choice == 1) {
				sql = "select * from student where name like ? ";

			} else if (choice == 2) {
				sql = "select * from student";
			}

			try {
				pstmt = conn.prepareStatement(sql);
				if (choice == 1)
					pstmt.setString(1, "%" + name + "%");

				rs = pstmt.executeQuery();

				while (rs.next()) {
					System.out.print("�̸� = " + rs.getString("name") + "\t");
					if (rs.getInt("code") == 1) {
						System.out.println("�й� = " + rs.getString("value"));
					} else if (rs.getInt("code") == 2) {
						System.out.println("���� = " + rs.getString("value"));

					} else if (rs.getInt("code") == 3) {
						System.out.println("�μ� = " + rs.getString("value"));
					}
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (pstmt != null)
						pstmt.close();
					if (conn != null)
						conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	} // select()

	// delete
	public void deleteArticle() {
		String name = null;

		System.out.println();
		System.out.print("������ �̸��� �Է��ϼ��� : ");
		name = scan.next();

		// db
		getConnection();
		String sql = "delete student where name =?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);

			int su = pstmt.executeUpdate();
			System.out.println(su + "���� �����Ǿ����ϴ�. ");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}// delete()

	// db

	public static void main(String[] args) {
		new Student().menu();
		System.out.println("���α׷� �����մϴ�.");
	}
}
