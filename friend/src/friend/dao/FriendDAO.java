package friend.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import friend.bean.FriendDTO;

// Bean : �Ѱ��� �ϸ� �ϴ� Ŭ���� ( ex. DTO)
public class FriendDAO {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "c##java";
	private String password = "bit";

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	// ���߿��� �� �������� xml�� ������.
	// xml�� ���� �״� �ص� �״�� �ֱ� ������

	public FriendDAO() {
		try {
			Class.forName(driver); // ����
			// driver ��� Ŭ���� ������ ����ü �������̽����� ���� �𸣱� ������
			// Class.�� ���� Ŭ���� ���Ϸ� ���� ��Ű�� ��
			System.out.println("����̹� �ε� ����");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void getConnection() {
		try {
			conn = DriverManager.getConnection(url, username, password); // ���� �õ�
			System.out.println("���� ����");
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public int getSeq() {
		// getSeq() > ������ ��ü���� ���� �߻��� ���� ������
		// ��Ϲ�ư ������ sysout(seq);
		int seq = 0;
		getConnection();

		String sql = "select seq_friend.nextval from dual";

		try {
			pstmt = conn.prepareStatement(sql);
			// ? ������ �ٷ� ����
			rs = pstmt.executeQuery(); // �ᱡ���� resultSet���� ����(executeQuery)

			// ������ ���� ��쿣 �� ���̱� ������ rs.next �� �ѹ��̸� �ȴ� >> while�� ���ʿ�
			rs.next(); // ���� ��ġ�� ���ڵ尡 �ֳ�?

			seq = rs.getInt(1); // ù��° �÷��� ���� �츮�� ���ϴ� seq ���̴�.
			// 1�� ���� ������.
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

	// ������ �Է�
	public int friendWrite(FriendDTO friendDTO) {
		int su = 0;

		getConnection();

		String sql = "insert into friend values(?,?,?,?,?,?,?,?,?,?,?)";

		try {
			pstmt = conn.prepareStatement(sql);
			// ������ ����
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

	// ����
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
			System.out.println(su + "���� �����Ǿ����ϴ�. ");

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

	// ���ڵ� �� �� ���� FriendDTO�� ����� LIST
	public List<FriendDTO> getFriendList() {
		List<FriendDTO> list = new ArrayList<FriendDTO>();
		// �ڽ��� arraylist�� �����ؾ��Ѵ�.
		getConnection();
		String sql = "select * from friend";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(); // ����

			// �������� �𸣹Ƿ� while���� ������.
			while (rs.next()) {
				FriendDTO friendDTO = new FriendDTO(); // �� �ٴ� DTO�� ������ش�.
				friendDTO.setSeq(rs.getInt("seq")); // seq�� �־��ش�.
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

				list.add(friendDTO); // dto�� list�� ����ش�.
			}
		} catch (SQLException e) {
			e.printStackTrace();
			list = null;
			// ������ �߸� list�� null�� �ʱ�ȭ ��������Ѵ�.
			// list�� ������ ���� ���ܰ� ���ܵ� �� �޼���� �ݵ�� list�� ���� ��Ű�� ������
			// ������ �־ list�� ���Ͻ��� ������.
			// �׷��� ������ null�� ������ FriendManger���� nullPointException�� �߻�����
			// ������ ������ �˸���.
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
