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
			// 처리 속도가 빠르기 때문에 동기화는 굳이 해주지 않아도 괜찮다.
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

	public void writeGuestbook(GuestbookDTO guestbookDTO) {

		String sql = "insert into guestbook values(seq_guestbook.nextval,?,?,?,?,?, to_char(sysdate, 'YYYY.MM.DD'))";

		getConnection();
		// 시퀀스는 db에서 따로 create 해주어야한다.
		// 또 하나씩 증가하는 시퀀스 값을 얻고자 한다면 .nextval을 사용한다.
		// 아니면 따로 해주지 않고 여기 sql 문에 직접 써도 된다.

		try {
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, guestbookDTO.getName());
			pstmt.setString(2, guestbookDTO.getEmail());
			pstmt.setString(3, guestbookDTO.getHomepage());
			pstmt.setString(4, guestbookDTO.getSubject());
			pstmt.setString(5, guestbookDTO.getContent());

			pstmt.executeUpdate(); // sql문 실행

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

	public List<GuestbookDTO> getGuestbookList(int startNum, int endNum) {
		List<GuestbookDTO> list = new ArrayList<GuestbookDTO>();
		// 자식인 ArrayList가 부모인 list가 참조하는 것

		getConnection();
		String sql = "select * from (select rownum rn, tt.* from (select seq, name, email, homepage, subject, content, to_char(logtime, 'YYYY.MM.DD') as logtime "
				+ "from guestbook order by seq desc)tt)" + "where rn >= ? and rn <=?";

		try {
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, startNum);
			pstmt.setInt(2, endNum);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				GuestbookDTO guestbookDTO = new GuestbookDTO();
				// 한 행을 돌 때 마다 dto가 새로 생성되게 해야한다.

				guestbookDTO.setSeq(rs.getInt("seq"));
				guestbookDTO.setName(rs.getString("name"));
				guestbookDTO.setEmail(rs.getString("email"));
				guestbookDTO.setHomepage(rs.getString("homepage"));
				guestbookDTO.setSubject(rs.getString("subject"));
				guestbookDTO.setContent(rs.getString("content"));
				guestbookDTO.setLogtime(rs.getString("logtime"));
				// seq부터 logtime까지 다 가져와야한다

				list.add(guestbookDTO);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			list = null;
			// list를 위에서 이미 생성을 했기 때문에
			// 혹시 잘 못됐다면 list를 빨리 버린다 (null로 만들어준다)

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

	// 총 글 수 가져오기
	public int getTotalA() {
		int totalA = 0;

		getConnection();
		String sql = "select count(*) from guestbook";

		try {
			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery(); // select 는 무조건 executeQuery
			
			rs.next();
			
			totalA = rs.getInt(1); // 1번 컬럼을 꺼내서 totalA로

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
		return totalA;
	}

}
