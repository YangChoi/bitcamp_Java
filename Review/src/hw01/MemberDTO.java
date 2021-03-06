package hw01;

public class MemberDTO {
	private String name; 
	private int age; 
	private String phone, address; 
	
	public MemberDTO() {}
	
	public MemberDTO(String name, int age, String phone, String address) {
		this.name = name; 
		this.age = age; 
		this.phone = phone;
		this.address = address;
	}
	
	// setter
	
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	// getter
	
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String getPhone() {
		return phone;
	}
	public String getAddress() {
		return address;
	}
	

}
