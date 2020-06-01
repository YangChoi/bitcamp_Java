package guestbook.bean;

import lombok.Data;

@Data
public class GuestbookDTO {
	private int seq; 
	private String name; 
	private	String email;
	private String homepage; 
	private String subject;
	private String content;
	private String logtime;
	
	//lombok 세팅 (롬복에게 getter setter를 시킨다)
	
	// @Data - setter/getter, 기본생성자, toString(), equals(), hashCode() 다 만들어줌 
	
}
