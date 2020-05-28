package member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import member.bean.MemberDTO;

public class MemberDAO {
	private static MemberDAO instance;
	// 싱글톤을 위해 memberDAO 객체를 생성할 때는 객체명을 싱글톤의 티가 나도록 instance로 지정해준다.

	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "c##java";
	private String password = "bit";

	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;

	// static으로 접근하는 singleTon 메서드
	// instance가 null 인 경우에는 처음에 딱 한 번이다
	public static MemberDAO getInstance() {
		if (instance == null) {
			// 스레드 동기화 (여기 안에 들어오는 스레드는 한 번에 한 번 만 통과 시킨다 )
			synchronized (MemberDAO.class) {
				// memberDAO 라는 이름의 클래스만 통과하므로 MemberDAO.class
				instance = new MemberDAO(); // MemberDAO는 이제 메모리에 한 번 만 생성된다

			}
		}
		return instance;
	}

	public MemberDAO() {
		try {
			Class.forName(driver);
			System.out.println("OracleDriver.class 생성, 드라이버 로딩 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void getConnection() {
		try {
			con = DriverManager.getConnection(url, username, password);

			System.out.println("접속 성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 데이터 insert
	public int writeMember(MemberDTO memberDTO) {
		int su = 0;

		String sql = "insert into member values(?,?,?,?,?,?,?,?,?,?,?,?, sysdate)";

		getConnection(); // 접속

		try {
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, memberDTO.getName());
			pstmt.setString(2, memberDTO.getId());
			pstmt.setString(3, memberDTO.getPwd());
			pstmt.setString(4, memberDTO.getGender());
			pstmt.setString(5, memberDTO.getEmail1());
			pstmt.setString(6, memberDTO.getEmail2());
			pstmt.setString(7, memberDTO.getTel1());
			pstmt.setString(8, memberDTO.getTel2());
			pstmt.setString(9, memberDTO.getTel3());
			pstmt.setString(10, memberDTO.getZipcode());
			pstmt.setString(11, memberDTO.getAddr1());
			pstmt.setString(12, memberDTO.getAddr2());
			// logTime은 시스템 날짜 얻어오는 것이라 직접 입력받을 필요 없음

			su = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					pstmt.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return su;
	}
	
	public String loginMember(String id, String pwd) {
		MemberDTO memberDTO = new MemberDTO();

		String sql = "select id=?, pwd=? from employees";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				memberDTO.setId(rs.getString("id"));
				memberDTO.setPwd(rs.getString("pwd"));
			}
			
			pstmt.setString(1, memberDTO.getId());
			pstmt.setString(2, memberDTO.getPwd());
			
	
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	
}
