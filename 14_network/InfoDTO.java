import java.io.Serializable;

enum Info{
	// 프로토콜
	JOIN, EXIT, SEND, SECRET 
}

class InfoDTO implements Serializable{
	// 한사람 분의 데이터 
	private String nickName;
	private String message; 
	private Info command; 
	
	// setter
	public void setNickName(String nickName){
		this.nickName = nickName;
	}
	public void setMessage(String message){
		this.message = message;
	}
	public void setCommand(Info command){
		this.command = command;
	}

	// getter
	public String getNickName(){
		return nickName;
	}
	public String getMessage(){
		return message;
	}
	public Info getCommand(){
		return command;
	}

}

//ChatClient.java >> ChatClientObject
//ChatServer.java >> ChatSeverObject
//ChatHandler.java >> ChatHandlerObject
// 문자열이 아닌 객체를 보낸다.
//모든 데이터를 String이 아닌 InfoDTO로 보내고 받기 
//>> ObjectInputStream
//>> ObjectOut
//putStream
//BufferedReader >  
//PrintWriter > 
