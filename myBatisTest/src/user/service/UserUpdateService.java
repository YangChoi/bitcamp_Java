package user.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserUpdateService implements UserService {

	@Override
	public void execute() {
		Scanner scan = new Scanner(System.in);

		System.out.print("수정할 아이디 입력 : ");
		String id = scan.next();


		UserDAO userDAO = UserDAO.getInstance();
		UserDTO userDTO = userDAO.getUser(id);

		if (userDTO == null) {
			System.out.println("찾고자하는 아이디가 없습니다. ");
			return;
		}

		System.out.println(userDTO.getName() + "\t"+
							userDTO.getId() + "\t" +
							userDTO.getPwd());
		
		System.out.println();
		System.out.print("수정할 이름 입력 : ");
		String name = scan.next();
		
		System.out.print("수정할 비밀번호 입력 : ");
		String pwd = scan.next();
		
		// map에 담아도 dto에 담아도 괜찮음. 
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", name);
		map.put("id", id);
		map.put("pwd", pwd);
		
		userDAO.modify(map);
		
	}

}
