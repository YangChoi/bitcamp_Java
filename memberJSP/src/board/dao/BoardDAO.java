package board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import board.bean.BoardDTO;
import member.dao.MemberDAO;

public class BoardDAO {
	private static BoardDAO instance;

	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "c##java";
	private String password = "bit";

	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public static BoardDAO getInstance() {
		if (instance == null) {
			synchronized (MemberDAO.class) {
				instance = new BoardDAO();
			}
		}

		return instance;
	}

	public BoardDAO() {
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
	
	public int getSeq() {
		int seq=0;
		getConnection();
		String sql = "select seq_board.nextval from dual";
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			rs.next();
			seq = rs.getInt(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
		
		return seq;
	}
	

	// insert
	public void writeBoard(Map<String, String> map) {
		// ref : 그룹번호 (seq와 같은 번호이므로 seq를 바로 ref로 받아주자)
		//String sql = "insert into boardvalues(seq_board.nextval, ?,?,?,?,?,seq_board.currval,?,?,?,?,?,sysdate)";
		String sql = "insert into board(seq, id, name, email, subject, content, ref) values(seq_board.nextval, ?,?,?,?,?,seq_board.currval)";
		getConnection();
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, map.get("id"));
			pstmt.setString(2, map.get("name"));
			pstmt.setString(3, map.get("email"));
			pstmt.setString(4, map.get("subject"));
			pstmt.setString(5, map.get("content"));
		
			
			pstmt.executeUpdate();
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

	}
}

	

