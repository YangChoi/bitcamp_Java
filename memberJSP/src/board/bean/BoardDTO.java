package board.bean;

import lombok.Data;

@Data
public class BoardDTO {
	private int seq;
	private String id;
	private String name; 
	private String email;
	private String subject;
	private String content;
	private int ref;
	private int lev;
	private int step;
	private int pesq;
	private int reply;
	private int hit;
	private String logtime;
	
	
}