package guestbook.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import guestbook.bean.GuestbookDTO;

public class GuestbookDAO {
	private static GuestbookDAO instance;

	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "c##java";
	private String password = "bit";

	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public static GuestbookDAO getInstance() {
		if (instance == null) {
			synchronized (GuestbookDAO.class) {
				instance = new GuestbookDAO();
			}
		}
		return instance;
	}

	public GuestbookDAO() {
		try {
			Class.forName(driver);
			System.out.println("OracleDriver.class 생성, 드라이버 로딩 성공 ");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void getConnection() {
		try {
			con = DriverManager.getConnection(url, username, password);

			System.out.println("접속 성공 ");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int getSeq() {
		int seq = 0;
		getConnection();

		String sql = "select seq_guestbook.nextval from dual";

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			rs.next();

			seq = rs.getInt(1); // 첫번째 칼럼 꺼낸다

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();

			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return seq;
	}

	
	public int writeGuestbook(GuestbookDTO guestbookDTO) {
		int su = 0;

		String sql = "insert into guestbook values (?,?,?,?,?,?, to_char(sysdate, 'YYYY.MM.DD'))";

		getConnection();

		try {
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, guestbookDTO.getSeq());
			pstmt.setString(2, guestbookDTO.getName());
			pstmt.setString(3, guestbookDTO.getEmail());
			pstmt.setString(4, guestbookDTO.getHomepage());
			pstmt.setString(5, guestbookDTO.getSubject());
			pstmt.setString(6, guestbookDTO.getContent());
			

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

	public List<GuestbookDTO> getGuestbook() {
		List<GuestbookDTO> list = new ArrayList<GuestbookDTO>();
		
		getConnection();
		String sql = "select * from guestbook order by 7 desc";
	
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				GuestbookDTO guestbookDTO = new GuestbookDTO();
				guestbookDTO.setSeq(rs.getInt("seq"));
				guestbookDTO.setName(rs.getString("name"));
				guestbookDTO.setEmail(rs.getString("email"));
				guestbookDTO.setHomepage(rs.getString("homepage"));
				guestbookDTO.setSubject(rs.getString("subject"));
				guestbookDTO.setContent(rs.getString("content"));
				guestbookDTO.setLogtime(rs.getString("logtime"));
				
				list.add(guestbookDTO);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			list = null;
			
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return list;
	}
}
