package friend.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import friend.bean.FriendDTO;

// Bean : 한가지 일만 하는 클래스 ( ex. DTO)
public class FriendDAO {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "c##java";
	private String password = "bit";

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	// 나중에는 이 정보들을 xml로 보낸다.
	// xml은 껐다 켰다 해도 그대로 있기 때문에

	public FriendDAO() {
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

	public int getSeq() {
		// getSeq() > 시퀀스 객체에서 숫자 발생해 값을 얻어오기
		// 등록버튼 누르면 sysout(seq);
		int seq = 0;
		getConnection();

		String sql = "select seq_friend.nextval from dual";

		try {
			pstmt = conn.prepareStatement(sql);
			// ? 없으니 바로 시작
			rs = pstmt.executeQuery(); // 결괌루이 resultSet으로 들어옴(executeQuery)

			// 시퀀스 같은 경우엔 한 줄이기 때문에 rs.next 가 한번이면 된다 >> while문 불필요
			rs.next(); // 현재 위치에 레코드가 있나?

			seq = rs.getInt(1); // 첫번째 컬럼의 값이 우리가 원하는 seq 값이다.
			// 1번 값을 꺼낸다.
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();

			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

		return seq;
	} // getSeq()

	// 데이터 입력
	public int friendWrite(FriendDTO friendDTO) {
		int su = 0;

		getConnection();

		String sql = "insert into friend values(?,?,?,?,?,?,?,?,?,?,?)";

		try {
			pstmt = conn.prepareStatement(sql);
			// 데이터 주입
			pstmt.setInt(1, friendDTO.getSeq());
			pstmt.setString(2, friendDTO.getName());
			pstmt.setString(3, friendDTO.getTel1());
			pstmt.setString(4, friendDTO.getTel2());
			pstmt.setString(5, friendDTO.getTel3());
			pstmt.setInt(6, friendDTO.getGender());
			pstmt.setInt(7, friendDTO.getRead());
			pstmt.setInt(8, friendDTO.getMovie());
			pstmt.setInt(9, friendDTO.getMusic());
			pstmt.setInt(10, friendDTO.getGame());
			pstmt.setInt(11, friendDTO.getShopping());

			su = pstmt.executeUpdate();
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

		return su;

	}

	// 수정
	public int friendUpdate(FriendDTO selectedDTO) {

		int su = 0;

		getConnection();
		String sql = "update friend set name = ?, tel1 = ?, tel2 = ?, tel3 = ?, gender = ?, read = ?, "
				+ "movie = ?, music = ?, game = ?, shopping = ? where seq = ?";

		try {

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, selectedDTO.getName());
			pstmt.setString(2, selectedDTO.getTel1());
			pstmt.setString(3, selectedDTO.getTel2());
			pstmt.setString(4, selectedDTO.getTel3());
			pstmt.setInt(5, selectedDTO.getGender());
			pstmt.setInt(6, selectedDTO.getRead());
			pstmt.setInt(7, selectedDTO.getMovie());
			pstmt.setInt(8, selectedDTO.getMusic());
			pstmt.setInt(9, selectedDTO.getGame());
			pstmt.setInt(10, selectedDTO.getShopping());
			pstmt.setInt(11, selectedDTO.getSeq());

			su = pstmt.executeUpdate();

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

		return su;
	}

	public int friendDelete(FriendDTO selectedDTO) {
		int su = 0;
		getConnection();
		String sql = "delete friend where seq = ?";

		try {

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, selectedDTO.getSeq());

			su = pstmt.executeUpdate();
			System.out.println(su + "행이 삭제되었습니다. ");

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

		return su;
	}

	// 레코드 한 줄 값인 FriendDTO를 담아줄 LIST
	public List<FriendDTO> getFriendList() {
		List<FriendDTO> list = new ArrayList<FriendDTO>();
		// 자식인 arraylist를 참조해야한다.
		getConnection();
		String sql = "select * from friend";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(); // 실행

			// 몇줄인지 모르므로 while문을 돌린다.
			while (rs.next()) {
				FriendDTO friendDTO = new FriendDTO(); // 한 줄당 DTO를 만들어준다.
				friendDTO.setSeq(rs.getInt("seq")); // seq도 넣어준다.
				friendDTO.setName(rs.getString("name"));
				friendDTO.setTel1(rs.getString("tel1"));
				friendDTO.setTel2(rs.getString("tel2"));
				friendDTO.setTel3(rs.getString("tel3"));
				friendDTO.setGender(rs.getInt("gender"));
				friendDTO.setRead(rs.getInt("read"));
				friendDTO.setMovie(rs.getInt("movie"));
				friendDTO.setMusic(rs.getInt("music"));
				friendDTO.setGame(rs.getInt("game"));
				friendDTO.setShopping(rs.getInt("shopping"));

				list.add(friendDTO); // dto를 list에 담아준다.
			}
		} catch (SQLException e) {
			e.printStackTrace();
			list = null;
			// 에러가 뜨면 list를 null로 초기화 시켜줘야한다.
			// list에 문제가 생겨 예외가 생겨도 이 메서드는 반드시 list를 리턴 시키기 때문에
			// 문제가 있어도 list를 리턴시켜 버린다.
			// 그렇기 떄문에 null로 보내서 FriendManger에서 nullPointException을 발생시켜
			// 문제가 있음을 알린다.
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

		return list;
	}

}
