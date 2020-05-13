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
	private ResultSet rs; // select 시 반드시 필요(결과값들어감)

	// 테이블의 경우앤 크기를 알 수 없기 때문에 for문을 돌릴 수는 없고
	// 각 행의 위치에 초점을 맞춘다 : rs.next()
	// 현재 위치에 레코드 있으면 true/ 아니면 false
	// rs.getString("name"); 또는 rs.getString(1);
	// 포지션이 이동하며 꺼내진다
	// rs.getInt("age"); 또는 rs.getInt(2)
	// rs.getDouble("height") 또는 rs.getDouble(3)
	// 날짜의 경우
	// 오늘부터 3일 두면 오늘 + 3
	// 오늘 날짜만 꺼낼 시엔
	// 날짜로 가져올 땐 계산이 필요한 경우이다. 아니면 그냥 문자열로 가져와도 된다.
	// rs.getDate()/ rs.getString("logtime")/ rs.getString(4)
	public SelectTest() {

		try {
			Class.forName(driver); // 생성
			// driver 라는 클래스 파일이 도대체 인터페이스인지 뭔지 모르기 때문에
			// Class.를 통해 클래스 파일로 통일 시키는 것
			System.out.println("드라이버 로딩 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public void getConnection() {
		try {
			conn = DriverManager.getConnection(url, username, password); // 접속 시도
			System.out.println("접속 성공");
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	// select 는 작동된 행 갯수가 아닌
	// 결과값을 보여줘야한다
	public void selectArticle() {
		getConnection();
		String sql = "select name, age, height, to_char(logtime, 'yyyy.mm.dd') as logtime from dbtest";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(); // ResultSet을 return 함

			while (rs.next()) {
				// 데이터가 없을 때까지 while문을 돌린다.
				// 데이터가 있으면 T
				System.out.println(rs.getString("name") + "\t" + rs.getInt("age") + "\t" + rs.getDouble("height") + "\t"
						+ rs.getString("logtime") + "\t");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 에러가 있건 없건 무조건 실행
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

	public static void main(String[] args) {
		new SelectTest().selectArticle();
	}

}
