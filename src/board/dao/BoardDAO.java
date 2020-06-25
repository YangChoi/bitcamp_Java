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
	// 글 리스트
	public List<BoardDTO> getBoardList(int startNum, int endNum) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);

		List<BoardDTO> list = sqlSession.selectList("boardSQL.getBoardList", map);
		sqlSession.close();
		return list;
	}

	// 총 글 수 가져오기
	public int getTotalA() {

		SqlSession sqlSession = sqlSessionFactory.openSession();
		int totalA = sqlSession.selectOne("boardSQL.getTotalA"); // selectOne 하면 sql에서 나오는 결과에 따라 결과값이 달라지만
		// 무조건 dto만 받는거 아니다

		return totalA;
	}
	
	// 한사람의 글 가져오기 
	public BoardDTO getBoard(int seq) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		BoardDTO boardDTO = sqlSession.selectOne("boardSQL.getBoard", seq);
		sqlSession.close();

		return boardDTO;

	}
	// 글 수정
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

	// 찾는 글 리스트
	public List<BoardDTO> getBoardSearchList(Map<String, Object> map) {
		SqlSession sqlSession = sqlSessionFactory.openSession();	
		List<BoardDTO> list = sqlSession.selectList("boardSQL.getBoardSearchList", map);
		sqlSession.close();
		return list;
	}

	// 글 보기 
	public BoardDTO boardView(int seq) {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		return null;
	}
	// 찾는 글 전체 
	public int getSearchTotalA(Map<String, Object> map) {
		SqlSession sqlSession = sqlSessionFactory.openSession();	
		int totalA = sqlSession.selectOne("boardSQL.getSearchTotalA", map);
		sqlSession.close();
		
		return totalA;
	}
	// 답글
	public void boardReply(Map<String, String> map) {
		// 원글 
		BoardDTO pDTO = this.getBoard(Integer.parseInt(map.get("pseq"))); // 현재 내 클래스 안에 있는 getBoard를 호출하므로 this
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// step : 글 순서 
		sqlSession.selectOne("boardSQL.boardReply1", pDTO); // 여러개가 가야하므로 하나만 찝어가지 않는다. 
		// update board step=step+1 where ref=원글ref and step>원글step
		
		
		// insert
		map.put("ref", pDTO.getRef()+"");// 원글의 ref를 넣으므로 pDTO.getRef()
		map.put("lev", pDTO.getLev()+1+""); // 원글 lev+1
		map.put("step", pDTO.getStep()+1+""); // 원글 step+1
		
		sqlSession.update("boardSQL.boardReply2", map);
		
		// 답글 수 증가 (reply) update
		sqlSession.update("boardSQL.boardReply3", pDTO.getSeq()); // 원글번호만 있으면 된다. (map.get("pseq") 로 해도됨)
		//update board set reply=reply+1 where seq=원글번호
		sqlSession.commit();
		sqlSession.close();
		
	}

	public void boardDelete() {
		
		
	}

}
