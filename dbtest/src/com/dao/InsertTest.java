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
	
	// 1. 설치 driverloading
	public InsertTest() {
		// new 할 때 실행되는 생성자

		// 클래스의 몽타주 따기 (파일명 밖에 모르는 class를 불러오는 방법)
		try {
			Class.forName(driver); // "OracleDriver.class" 생성
			// "OracleDriver.class" 를 메모리에 생성
			// 단 풀쿼리 네임으로 적어준다 (어느 패키지에 있는지까지 다 적어야한다)
			System.out.println("드라이버 로딩 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// 생성자에서 접속시 한번 밖에 접속이 불가
		// 로그인 로그아웃은 수시로 이뤄져야하기 때문에 생성자에 하지 말것
	}

	// 2. 접속 connection
	public void getConnection() {
		// interface 불러오는 방법
		// 1. implements : 무든 추상메서드 Override
		// 2. 익명
		// 3. 모든 추상 메서드 Override 해주는 클래스
		// 4. 메소드 : DriverManager
		try {
			conn = DriverManager.getConnection(url, username, password);
			// url (this: 오라클의 드라이버 이름) / 아이디 / 비번
			// 그래픽 드라이버
			// 지포스
			// connection 값을 넘겨준다 
			System.out.println("접속 성공");
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
	
	public void insertArticle() {
		
		// getConnection()를 통해 오라클 접속 
		// 데이터 받기 
		// sqlDeveloper 에서 했듯이 insert 어쩌고 하면 안먹는다. 
		Scanner scan = new Scanner(System.in);
		System.out.print("이름 입력 : ");
		String name = scan.next();
		System.out.print("나이 입력 : ");
		int age = scan.nextInt();
		System.out.print("키 입력 : ");
		double height = scan.nextDouble();
		
		this.getConnection();
		//String sql = "insert into dbtest values(name, age, height)";
		// 저 안에 + 로 따로 분리시키면 웹보안에 걸린다. 
		// 웹에서 역컴파일 해서 정보를 볼 수도 있다. 
		String sql = "insert into dbtest values(?, ?, ?, sysdate)";
		// 데이터가 들어갈 자리를 ? 료 대체한다. 그럼 추적불가 
		
		try {
			pstmt = conn.prepareStatement(sql); // 생성
			// 데이터를 ? 에 주입
			// oracle의 인덱스는 1부터 시작 
			pstmt.setString(1, name);
			pstmt.setInt(2, age);
			pstmt.setDouble(3, height);
			
			// oracle 문 실행 
			int su = pstmt.executeUpdate();
			System.out.println(su + "개의 행이 만들어졌습니다. ");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 에러가 있건 없건 무조건 실행
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
				// 끊어줄 땐 반대로 끊어주기 
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		
	}

	public static void main(String[] args) {
		// 자바에서 수행을 딱 한번 밖에 수행 못하는 것 : 생성자
		InsertTest insertTest = new InsertTest();
		insertTest.insertArticle(); // insertArticle이 getConnection을 부르기 때문에 insertTest를 여기에 부른다. 
	}
}

// 자바의 모든 것은 new 시켜주어야한다 >> 생성해주어야한다. 
// 오라클과 자바를 연결시켜주는 OracleDriver.class >> new 시켜줘야한다. 
// 그런데 이 클래스의 실체를 우리는 모른다. (그냥 클래스인지 추상클래스인지 인터페이스인지..)
// 파일명만 알고 있기 떄문에 무조건 new 해줄 수 없다. 
// 그럴 땐 class에 대한 몽타주를 딴다. 
