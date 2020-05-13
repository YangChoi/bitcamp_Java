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
		// 드라이버 로딩
		try {
			Class.forName(driver); // 생성
			// driver 라는 클래스 파일이 도대체 인터페이스인지 뭔지 모르기 때문에
			// Class.를 통해 클래스 파일로 통일 시키는 것
			// System.out.println("드라이버 로딩 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public void getConnection() {
		try {
			conn = DriverManager.getConnection(url, username, password); // 접속 시도
			// System.out.println("접속 성공");
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
	// 자바에서 들어갈 때는 자동 commit이다.
	public void insertArticle() {

		int choice;
		String name = null, value = null;
		int code = 0;

		while (true) {
			System.out.println();
			System.out.println("******************");
			System.out.println("1. 학생");
			System.out.println("2. 교수");
			System.out.println("3. 관리자");
			System.out.println("4. 이전메뉴");
			System.out.println("******************");
			System.out.print("번호 선택 : ");

			choice = scan.nextInt();
			if (choice == 4)
				break;

			// 이름은 공통 영역이므로 밖으로 뺀다.
			System.out.print("이름 입력 : ");
			name = scan.next();

			if (choice == 1) {
				// 학생

				System.out.print("학번 입력 : ");
				value = scan.next();
				code = 1;

			} else if (choice == 2) {
				// 교수

				System.out.print("과목 입력 : ");
				value = scan.next();
				code = 2;

			} else if (choice == 3) {
				// 관리자

				System.out.print("부서 입력 : ");
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
			System.out.println("1. 이름 검색 ");
			System.out.println("2. 전체 검색 ");
			System.out.println("3. 이전메뉴");
			System.out.println("******************");
			System.out.print("번호 선택 : ");
			choice = scan.nextInt();

			if (choice == 3)
				return;

			if (choice == 1) {
				// 검색할 이름 입력
				System.out.println();
				System.out.print("검색할 이름을 입력하세요 : ");
				name = scan.next();

			} else if (choice == 2) {
				// 이름 전체 검색

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
					System.out.print("이름 = " + rs.getString("name") + "\t");
					if (rs.getInt("code") == 1) {
						System.out.println("학번 = " + rs.getString("value"));
					} else if (rs.getInt("code") == 2) {
						System.out.println("과목 = " + rs.getString("value"));

					} else if (rs.getInt("code") == 3) {
						System.out.println("부서 = " + rs.getString("value"));
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
		System.out.print("삭제할 이름을 입력하세요 : ");
		name = scan.next();

		// db
		getConnection();
		String sql = "delete student where name =?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);

			int su = pstmt.executeUpdate();
			System.out.println(su + "행이 삭제되었습니다. ");

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
		System.out.println("프로그램 종료합니다.");
	}
}
