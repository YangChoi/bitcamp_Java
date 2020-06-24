package board.dao;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import board.bean.BoardDTO;
import member.dao.MemberDAO;

public class BoardDAO {
	private static BoardDAO instance;
	private SqlSessionFactory sqlSessionFactory;

	public static BoardDAO getInstance() {
		if (instance == null) {
			synchronized (MemberDAO.class) {
				instance = new BoardDAO();
			}
		}

		return instance;
	}

	public BoardDAO() {

		Reader reader;
		try {
			InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {

			e.printStackTrace();
		}

	}


	// insert
	public void boardWrite(Map<String, String> map) {
		// ref : 그룹번호 (seq와 같은 번호이므로 seq를 바로 ref로 받아주자)
		// String sql = "insert into boardvalues(seq_board.nextval,
		// ?,?,?,?,?,seq_board.currval,?,?,?,?,?,sysdate)";
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.insert("boardSQL.boardWrite", map);
		sqlSession.commit();
		sqlSession.close();

	}

	public List<BoardDTO> getBoardList(int startNum, int endNum) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);

		List<BoardDTO> list = sqlSession.selectList("boardSQL.getBoardList", map);
		return list;
	}

	// 총 글 수 가져오기
	public int getTotalA() {

		SqlSession sqlSession = sqlSessionFactory.openSession();
		int totalA = sqlSession.selectOne("boardSQL.getTotalA"); // selectOne 하면 sql에서 나오는 결과에 따라 결과값이 달라지만
		// 무조건 dto만 받는거 아니다

		return totalA;
	}

	public BoardDTO getBoard(int seq) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		BoardDTO boardDTO = sqlSession.selectOne("boardSQL.getBoard", seq);
		sqlSession.close();

		return boardDTO;

	}

	public void boardModify(int seq, String subject, String content) {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		Map<String, String> map = new HashMap<String, String>();
		map.put("seq", seq + "");
		map.put("subject", subject);
		map.put("content", content);

		sqlSession.update("boardSQL.boardModify", map);
		sqlSession.close();

	}

	// 조회수
	public void hitUpdate(int seq) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.update("boardSQL.hitUpdate", seq);
		sqlSession.commit();
		sqlSession.close();

	}

	public List<BoardDTO> getBoardSearchList(Map<String, Object> map) {
		SqlSession sqlSession = sqlSessionFactory.openSession();	
		List<BoardDTO> list = sqlSession.selectList("boardSQL.getBoardSearchList", map);
		sqlSession.close();
		return list;
	}

	public BoardDTO boardView(int seq) {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		return null;
	}

}
