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

	

		System.out.println("찾는 방식 : ");
		System.out.println("1. 아이디 ");
		System.out.println("2. 이름 ");
		System.out.print(">> ");

		String choice = scan.next();
		
		System.out.println();
		String searchValue = null;
		String searchType = null;
		// 아이디
		if (choice.equals("1")) {
			System.out.print("아이디를 입력해주세요 : ");
			searchValue = scan.next();
			searchType = "id";
			
			// 이름
		} else if (choice.equals("2")) {
			System.out.print("이름을 입력해주세요 : ");
			searchValue = scan.next();
			searchType = "name";

			
		}
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("searchType", searchType);
		map.put("searchValue", searchValue);
		
		UserDAO userDAO = UserDAO.getInstance();
		List<UserDTO> list = userDAO.search(map);
		
		for(UserDTO userDTO : list) {
			System.out.println(userDTO.getName()+"\t"
							  +userDTO.getId()+"\t"
							  +userDTO.getPwd());
			System.out.println();
		}

	}

}
