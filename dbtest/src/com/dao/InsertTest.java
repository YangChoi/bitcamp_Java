package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertTest {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe"; 
	private String username = "c##java";
	private String password = "bit";
	
	private Connection conn;
	private PreparedStatement pstmt;
	
	// 1. ��ġ driverloading
	public InsertTest() {
		// new �� �� ����Ǵ� ������

		// Ŭ������ ��Ÿ�� ���� (���ϸ� �ۿ� �𸣴� class�� �ҷ����� ���)
		try {
			Class.forName(driver); // "OracleDriver.class" ����
			// "OracleDriver.class" �� �޸𸮿� ����
			// �� Ǯ���� �������� �����ش� (��� ��Ű���� �ִ������� �� ������Ѵ�)
			System.out.println("����̹� �ε� ����");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// �����ڿ��� ���ӽ� �ѹ� �ۿ� ������ �Ұ�
		// �α��� �α׾ƿ��� ���÷� �̷������ϱ� ������ �����ڿ� ���� ����
	}

	// 2. ���� connection
	public void getConnection() {
		// interface �ҷ����� ���
		// 1. implements : ���� �߻�޼��� Override
		// 2. �͸�
		// 3. ��� �߻� �޼��� Override ���ִ� Ŭ����
		// 4. �޼ҵ� : DriverManager
		try {
			conn = DriverManager.getConnection(url, username, password);
			// url (this: ����Ŭ�� ����̹� �̸�) / ���̵� / ���
			// �׷��� ����̹�
			// ������
			// connection ���� �Ѱ��ش� 
			System.out.println("���� ����");
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
	
	public void insertArticle() {
		
		// getConnection()�� ���� ����Ŭ ���� 
		// ������ �ޱ� 
		// sqlDeveloper ���� �ߵ��� insert ��¼�� �ϸ� �ȸԴ´�. 
		Scanner scan = new Scanner(System.in);
		System.out.print("�̸� �Է� : ");
		String name = scan.next();
		System.out.print("���� �Է� : ");
		int age = scan.nextInt();
		System.out.print("Ű �Է� : ");
		double height = scan.nextDouble();
		
		this.getConnection();
		//String sql = "insert into dbtest values(name, age, height)";
		// �� �ȿ� + �� ���� �и���Ű�� �����ȿ� �ɸ���. 
		// ������ �������� �ؼ� ������ �� ���� �ִ�. 
		String sql = "insert into dbtest values(?, ?, ?, sysdate)";
		// �����Ͱ� �� �ڸ��� ? �� ��ü�Ѵ�. �׷� �����Ұ� 
		
		try {
			pstmt = conn.prepareStatement(sql); // ����
			// �����͸� ? �� ����
			// oracle�� �ε����� 1���� ���� 
			pstmt.setString(1, name);
			pstmt.setInt(2, age);
			pstmt.setDouble(3, height);
			
			// oracle �� ���� 
			int su = pstmt.executeUpdate();
			System.out.println(su + "���� ���� ����������ϴ�. ");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// ������ �ְ� ���� ������ ����
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
				// ������ �� �ݴ�� �����ֱ� 
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		
	}

	public static void main(String[] args) {
		// �ڹٿ��� ������ �� �ѹ� �ۿ� ���� ���ϴ� �� : ������
		InsertTest insertTest = new InsertTest();
		insertTest.insertArticle(); // insertArticle�� getConnection�� �θ��� ������ insertTest�� ���⿡ �θ���. 
	}
}

// �ڹ��� ��� ���� new �����־���Ѵ� >> �������־���Ѵ�. 
// ����Ŭ�� �ڹٸ� ��������ִ� OracleDriver.class >> new ��������Ѵ�. 
// �׷��� �� Ŭ������ ��ü�� �츮�� �𸥴�. (�׳� Ŭ�������� �߻�Ŭ�������� �������̽�����..)
// ���ϸ� �˰� �ֱ� ������ ������ new ���� �� ����. 
// �׷� �� class�� ���� ��Ÿ�ָ� ����. 
