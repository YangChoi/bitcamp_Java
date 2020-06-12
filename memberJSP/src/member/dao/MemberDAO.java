package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import member.bean.MemberDTO;
import member.bean.ZipcodeDTO;

public class MemberDAO {
	private static MemberDAO instance;
	// 싱글톤을 위해 memberDAO 객체를 생성할 때는 객체명을 싱글톤의 티가 나도록 instance로 지정해준다.
	
	/*
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "c##java";
	private String password = "bit";
	*/

	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private DataSource ds;
	
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
		/*
		try {
			Class.forName(driver);
			System.out.println("OracleDriver.class 생성, 드라이버 로딩 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		*/
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/oracle"); // jdbc/oracle에 있는 것을 꺼내달라
			// ds 에게 전달한다. 
			// Tomcat의 경우 java:comp/env/를 꼭 넣어줘야한다. 다른 곳은 없어도 된다고 하심
			
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	
	
	/*
	public void getConnection() {
		try {
			con = DriverManager.getConnection(url, username, password);

			System.out.println("접속 성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	 */
	
	
	// 데이터 insert
	public int writeMember(MemberDTO memberDTO) {
		int su = 0;

		String sql = "insert into member values(?,?,?,?,?,?,?,?,?,?,?,?, sysdate)";
		

		try {
			// DataSource로 부터 connection을 얻어온다
			con = ds.getConnection(); // 접속
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

	public MemberDTO loginMember(String id, String pwd) {
		

		MemberDTO memberDTO = null;
		
		
		String sql = "select * from member where id=? and pwd=?";

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql); // sql 처리

			pstmt.setString(1, id);
			pstmt.setString(2, pwd);

			rs = pstmt.executeQuery(); // select이기 때문에 executeQuery
			// rs 값은 딱 한 줄 나온다.
			// 만약 틀리면 아예 안나온다.
			// 반복문을 돌리기 보다는 if문으로 맞는지 아닌지 본다.
			if (rs.next()) {
				memberDTO = new MemberDTO();
				memberDTO.setName(rs.getString("name"));
				memberDTO.setId(rs.getString("id"));
				memberDTO.setPwd(rs.getString("pwd"));
				memberDTO.setGender(rs.getString("gender"));
				memberDTO.setEmail1(rs.getString("email1"));
				memberDTO.setEmail2(rs.getString("email2"));
				memberDTO.setTel1(rs.getString("tel1"));
				memberDTO.setTel2(rs.getString("tel2"));
				memberDTO.setTel3(rs.getString("tel3"));
				memberDTO.setZipcode(rs.getString("zipcode"));
				memberDTO.setAddr1(rs.getString("addr1"));
				memberDTO.setAddr2(rs.getString("addr2"));
				
				// 해당되는 애가 없다면 null 값인 name이 갈 것 이다.
			}

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
		return memberDTO;

	}

	public boolean isExistId(String id) {
		boolean exist = false;

		String sql = "select * from member where id=?";

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql); // sql 처리
			pstmt.setString(1, id);

			rs = pstmt.executeQuery(); // 실행

			if (rs.next())
				exist = true;

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
		return exist;

	}
	



	public List<ZipcodeDTO> getZipcodeList(String sido, String sigungu, String roadname) {
		List<ZipcodeDTO> list = new ArrayList<ZipcodeDTO>();

		// sigungu 중 없는 값은 문자열 아무 거나로 채우도록 한다 (nvl)
		String sql = "select * from newzipcode " + "where sido like ? and nvl(sigungu, '0') like ? and roadname like ?";

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, "%" + sido + "%");
			pstmt.setString(2, "%" + sigungu + "%");
			pstmt.setString(3, "%" + roadname + "%");

			rs = pstmt.executeQuery();

			while (rs.next()) {
				ZipcodeDTO zipcodeDTO = new ZipcodeDTO();

				zipcodeDTO.setZipcode(rs.getString("zipcode"));
				zipcodeDTO.setSido(rs.getString("sido"));
				zipcodeDTO.setSigungu(rs.getString("sigungu") == null ? "" : rs.getString("sigungu"));
				zipcodeDTO.setYubmyundong(rs.getString("yubmyundong"));

				zipcodeDTO.setRi(rs.getString("ri") == null ? "" : rs.getString("ri"));

				zipcodeDTO.setRoadname(rs.getString("roadname"));
				zipcodeDTO.setBuildingname(rs.getString("buildingname") == null ? "" : rs.getString("buildingname"));

				list.add(zipcodeDTO);

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

	public MemberDTO getMember(String id) {
		MemberDTO memberDTO = null;
		
		
		String sql = "select * from member where id = ?";
		

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, id);

			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				memberDTO = new MemberDTO();
				
				memberDTO.setName(rs.getString("name"));
				memberDTO.setId(rs.getString("id"));
				memberDTO.setPwd(rs.getString("pwd"));
				memberDTO.setGender(rs.getString("gender"));
				memberDTO.setEmail1(rs.getString("email1"));
				memberDTO.setEmail2(rs.getString("email2"));
				memberDTO.setTel1(rs.getString("tel1"));
				memberDTO.setTel2(rs.getString("tel2"));
				memberDTO.setTel3(rs.getString("tel3"));
				memberDTO.setZipcode(rs.getString("zipcode"));
				memberDTO.setAddr1(rs.getString("addr1"));
				memberDTO.setAddr2(rs.getString("addr2"));
				
			}
			
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
		
		
		return memberDTO; 
	}
	
	public void modifyMember(MemberDTO memberDTO) {
		  String sql = "update member set name=?,"
                  + " pwd=?,"
                  + " gender=?,"
                  + " email1=?,"
                  + " email2=?,"
                  + " tel1=?,"
                  + " tel2=?,"
                  + " tel3=?,"
                  + " zipcode=?,"
                  + " addr1=?,"
                  + " addr2=?,"
                  + " logtime=sysdate"
                  + " where id=?";
		
		try {
			con = ds.getConnection();
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberDTO.getName());
			pstmt.setString(2, memberDTO.getPwd());
			pstmt.setString(3, memberDTO.getGender());
			pstmt.setString(4, memberDTO.getEmail1());
			pstmt.setString(5, memberDTO.getEmail2());
			pstmt.setString(6, memberDTO.getTel1());
			pstmt.setString(7, memberDTO.getTel2());
			pstmt.setString(8, memberDTO.getTel3());
			pstmt.setString(9, memberDTO.getZipcode());
			pstmt.setString(10, memberDTO.getAddr1());
			pstmt.setString(11, memberDTO.getAddr2());
			pstmt.setString(12, memberDTO.getId());
			
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
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
	
	public void InsertMember(MemberDTO memberDTO) {
		String sql = "Insert into member name=?,"
										+ "id=?"
										+ "pwd=?,"
										+ "gender=?,"
										+ "email1=?,"
										+ "email2=?,"
										+ "tel1=?,"
										+ "tel2=?,"
										+ "tel2=?,"
										+ "zipcode=?,"
										+ "addr1=?,"
										+ "addr2=?,"
										+ "logtime=sysdate";
		
		try {
			con = ds.getConnection();
			
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

			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
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
