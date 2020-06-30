package imageBoard.dao;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import imageBoard.bean.ImageBoardDTO;
import member.dao.MemberDAO;

public class ImageBoardDAO {
	private static ImageBoardDAO instance;
	private SqlSessionFactory sqlSessionFactory;

	public static ImageBoardDAO getInstance() {
		if (instance == null) {
			synchronized (MemberDAO.class) {
				instance = new ImageBoardDAO();
			}
		}

		return instance;
	}

	public ImageBoardDAO() {

		Reader reader;
		try {
			InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
	
	// 이미지 넣기 
	public void imageBoardWrite(ImageBoardDTO imageBoardDTO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.insert("imageBoardSQL.imageBoardWrite", imageBoardDTO);
		sqlSession.commit();
		sqlSession.close();
		
		
	}
	// 이미지 리스트 
	public List<ImageBoardDAO> imageBoardList(Map<String, Integer> map) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<ImageBoardDAO> list = sqlSession.selectList("imageBoardSQL.imageBoardList", map);
		sqlSession.close();
		return list;
	}
	
	// 총글수
	public int getToTalA() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int totalA = sqlSession.selectOne("imageBoardSQL.getTotalA");
		sqlSession.close();
		return totalA;
	}
	
	// 선택 삭제 
	public void imageBoardChoiceDelete(String seq) {
		// 삭제
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.delete("imageBoardSQL.imageBoardChoiceDelete", seq);
		sqlSession.commit();
		sqlSession.close();
		
	}
	
}
