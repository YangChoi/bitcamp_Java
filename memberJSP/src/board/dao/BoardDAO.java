package board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
	
	public List<BoardDTO> getBoardList(int startNum, int endNum){
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		
		getConnection();
		String sql = "select * from (select rownum rn, tt.* "
				+ "from (select * from board order by ref desc, step asc)tt)"
				+ "where rn >=? and rn <= ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, startNum);
			pstmt.setInt(2, endNum);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardDTO boardDTO = new BoardDTO();
						
				boardDTO.setSeq(rs.getInt("seq"));
				boardDTO.setId(rs.getString("id"));
				boardDTO.setName(rs.getString("name"));
				boardDTO.setEmail(rs.getString("email"));
				boardDTO.setSubject(rs.getString("subject"));
				boardDTO.setContent(rs.getString("content"));
				boardDTO.setRef(rs.getInt("ref"));
				boardDTO.setLev(rs.getInt("lev"));
				boardDTO.setStep(rs.getInt("step"));
				boardDTO.setPseq(rs.getInt("pseq"));
				boardDTO.setReply(rs.getInt("reply"));
				boardDTO.setHit(rs.getInt("hit"));
				boardDTO.setLogtime(rs.getDate("logtime"));
				
				list.add(boardDTO);
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
			list = null;
		}finally {
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
	public int getTotalA(List<BoardDTO> list) {
		int totalA = 0;
		
		getConnection();
		String sql = "select count(*) from board";
		
		try {
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery(); 
			rs.next();
			
			totalA = rs.getInt(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
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
	
	
	// seq로 글 찾는 메서드
	public BoardDTO boardView(int seq) {
		BoardDTO boardDTO = null;

		getConnection();
		
		String sql = "select * from board where seq=?";
		
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, seq);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				boardDTO = new BoardDTO();
				
				boardDTO.setSeq(rs.getInt("seq"));
				boardDTO.setId(rs.getString("id"));
				boardDTO.setName(rs.getString("name"));
				boardDTO.setEmail(rs.getString("email"));
				boardDTO.setSubject(rs.getString("subject"));
				boardDTO.setContent(rs.getString("content"));
				boardDTO.setRef(rs.getInt("ref"));
				boardDTO.setLev(rs.getInt("lev"));
				boardDTO.setStep(rs.getInt("step"));
				boardDTO.setPseq(rs.getInt("pseq"));
				boardDTO.setReply(rs.getInt("reply"));
				boardDTO.setHit(rs.getInt("hit"));
				boardDTO.setLogtime(rs.getDate("logtime"));	
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
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
		
		
		return boardDTO;
		
	}
	
	public void boardModify(int seq, String subject, String content) {
		BoardDTO boardDTO = new BoardDTO();
		
		getConnection();
		
		String sql = "update board set subject=?, content=?, logtime=sysdate where seq=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, boardDTO.getSubject());
			pstmt.setString(2, boardDTO.getContent());
			pstmt.setInt(3, boardDTO.getSeq());
			
			pstmt.executeQuery();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}

	

