package user.service;

import java.util.List;
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
		
		int choice = scan.nextInt();
	
		// 아이디 
		if(choice == 1) {
			String keyword = scan.next();
			
			List<UserDTO> list = userDAO.search(id, keyword);
		// 이름 
		}else if(choice == 2) {
			String keyword = scan.next();
		
			List<UserDTO> list = userDAO.search(name, keyword);
		}

	}

}
