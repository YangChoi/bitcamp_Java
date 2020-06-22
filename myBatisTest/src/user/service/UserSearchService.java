package user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserSearchService implements UserService {

	@Override
	public void execute() {

		Scanner scan = new Scanner(System.in);

		UserDAO userDAO = UserDAO.getInstance();

		System.out.print("찾는 방식 : ");
		System.out.println("1. 아이디 ");
		System.out.println("2. 이름 ");

		String choice = scan.next();

		// 아이디
		if (choice.equals("1")) {
			String id = scan.next();

			Map<String, String> map = new HashMap<String, String>();
			map.put("id", id);
			userDAO.search(map);
			// 이름
		} else if (choice.equals("2")) {
			String name = scan.next();

			Map<String, String> map = new HashMap<String, String>();
			map.put("name", name);
			userDAO.search(map);
		}
		

	}

}
