package member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import member.bean.MemberDTO;
import member.bean.ZipcodeDTO;

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
		// LoginServlet 에서 두개의 데이터가 온다. (id, pwd)

		String name = null; // return 값으로 name을 준다

		MemberDTO memberDTO = new MemberDTO();

		String sql = "select * from member where id=? and pwd=?";
		getConnection();

		try {
			pstmt = con.prepareStatement(sql); // sql 처리

			pstmt.setString(1, id);
			pstmt.setString(2, pwd);

			rs = pstmt.executeQuery(); // select이기 때문에 executeQuery
			// rs 값은 딱 한 줄 나온다.
			// 만약 틀리면 아예 안나온다.
			// 반복문을 돌리기 보다는 if문으로 맞는지 아닌지 본다.
			if (rs.next()) {
				// 우리는 그런데 위의 12개의 항목이 다 필요하지 않다.
				// name 만 가져가면 된다.
				name = rs.getString("name");
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
		return name;

	}

	public boolean isExistId(String id) {
		boolean exist = false;

		String sql = "select * from member where id=?";
		getConnection();

		try {
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
		getConnection();

		try {
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

	public int updateMember(MemberDTO memberDTO) {
		
	}

}
