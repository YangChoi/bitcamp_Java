package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SelectTest {
	Scanner scan = new Scanner(System.in);

	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "c##java";
	private String password = "bit";

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs; // select �� �ݵ�� �ʿ�(�������)

	// ���̺��� ���� ũ�⸦ �� �� ���� ������ for���� ���� ���� ����
	// �� ���� ��ġ�� ������ ����� : rs.next()
	// ���� ��ġ�� ���ڵ� ������ true/ �ƴϸ� false
	// rs.getString("name"); �Ǵ� rs.getString(1);
	// �������� �̵��ϸ� ��������
	// rs.getInt("age"); �Ǵ� rs.getInt(2)
	// rs.getDouble("height") �Ǵ� rs.getDouble(3)
	// ��¥�� ���
	// ���ú��� 3�� �θ� ���� + 3
	// ���� ��¥�� ���� �ÿ�
	// ��¥�� ������ �� ����� �ʿ��� ����̴�. �ƴϸ� �׳� ���ڿ��� �����͵� �ȴ�.
	// rs.getDate()/ rs.getString("logtime")/ rs.getString(4)
	public SelectTest() {

		try {
			Class.forName(driver); // ����
			// driver ��� Ŭ���� ������ ����ü �������̽����� ���� �𸣱� ������
			// Class.�� ���� Ŭ���� ���Ϸ� ���� ��Ű�� ��
			System.out.println("����̹� �ε� ����");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public void getConnection() {
		try {
			conn = DriverManager.getConnection(url, username, password); // ���� �õ�
			System.out.println("���� ����");
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	// select �� �۵��� �� ������ �ƴ�
	// ������� ��������Ѵ�
	public void selectArticle() {
		getConnection();
		String sql = "select name, age, height, to_char(logtime, 'yyyy.mm.dd') as logtime from dbtest";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(); // ResultSet�� return ��

			while (rs.next()) {
				// �����Ͱ� ���� ������ while���� ������.
				// �����Ͱ� ������ T
				System.out.println(rs.getString("name") + "\t" + rs.getInt("age") + "\t" + rs.getDouble("height") + "\t"
						+ rs.getString("logtime") + "\t");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// ������ �ְ� ���� ������ ����
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

	public static void main(String[] args) {
		new SelectTest().selectArticle();
	}

}
