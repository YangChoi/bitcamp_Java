package user.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import user.bean.UserDTO;

public class UserDAO {
	public static UserDAO instance;
	private SqlSessionFactory sqlSessionFactory;

	public static UserDAO getInstance() {
		if (instance == null) {
			synchronized (UserDAO.class) {
				instance = new UserDAO();
			}
		}
		return instance;
	}

	public UserDAO() {
		/*
		 * IO Stream 1. byte 단위 - InputStream, OutputStream 2. 문자 단위 - Reader, Writer
		 * 
		 */
		try {
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			// build를 통해 초기값을 부여한다 (생성자 대신에)
			// 환경설정 완성
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public int write(UserDTO userDTO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int su = sqlSession.insert("userSQL.write", userDTO);
		// 여기에 쓴 write가 userMapper.xml 의 mapper 안 insert id 로 연결된다. 
		// userSQL 은 이름 구분자이다(namespace) 
		// 데이터 전달시엔 (name ,id ,pwd ) 이렇게 여러개 전달할 수 없고 
		// DTO나 COLLECTION으로 한꺼번에 묶어서 보내주어야한다. 
		sqlSession.commit(); // 자동커밋 안되므로 커밋해줘야함 
		sqlSession.close(); // 반환
		
		return su; 
	}
	public List<UserDTO> getUserList() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<UserDTO> list = sqlSession.selectList("userSQL.getUserList");
		sqlSession.close();
		return list;
	}
	
	public UserDTO getUser(String id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserDTO userDTO = sqlSession.selectOne("userSQL.getUser", id);
		sqlSession.close();
		return userDTO;
	}

	public void modify(Map<String, String> map) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 담아둔 map을 가져온다. 
		sqlSession.update("userSQL.modify", map);
		sqlSession.commit();
		sqlSession.close();
		
	}

	public void delete(String id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.delete("userSQL.delete", id);
		sqlSession.commit();
		sqlSession.close();
		
	}

	public List<UserDTO> search(Map map) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<UserDTO> list = sqlSession.selectList("userSQL.search", map);
		
		sqlSession.close();
		
		return list;
		
	
	}


}
