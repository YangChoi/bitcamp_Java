package user.service;

import java.util.Scanner;

import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserInsertService implements UserService {

	@Override
	public void execute() {
		// 이름, 아이디, 비밀번호 입력 
		Scanner scan = new Scanner(System.in);
		
		System.out.print("이름 : ");
		String name = scan.next();
		
		System.out.print("아이디 : ");
		String id = scan.next();
		
		System.out.print("비밀 번호 : ");
		String pwd = scan.next();
		
		UserDTO userDTO = new UserDTO();
		
		// dto에 데이터 담기 
		userDTO.setName(name);
		userDTO.setId(id);
		userDTO.setPwd(pwd);
		
		// userDAO 접근
		UserDAO userDAO = UserDAO.getInstance();
		int su = userDAO.write(userDTO); 
		
		System.out.println(su + "개 저장 완료");
	}

}
