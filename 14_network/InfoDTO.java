import java.io.Serializable;

enum Info{
	// ��������
	JOIN, EXIT, SEND, SECRET 
}

class InfoDTO implements Serializable{
	// �ѻ�� ���� ������ 
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
// ���ڿ��� �ƴ� ��ü�� ������.
//��� �����͸� String�� �ƴ� InfoDTO�� ������ �ޱ� 
//>> ObjectInputStream
//>> ObjectOut
//putStream
//BufferedReader >  
//PrintWriter > 
