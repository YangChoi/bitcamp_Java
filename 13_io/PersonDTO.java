class PersonDTO implements java.io.Serializable{
	//Serializable 는 추상메서드 없다 
	private static final long serialVersionUID = 1L;
	private String name; 
	private int age; 
	private double height;
	

	public PersonDTO(String name, int age, double height){
		this.name = name;
		this.age = age;
		this.height = height;
	}

	//getter
	public String getName(){
		return name;
	}
	public int getAge(){
		return age;
	}
	public double getHeight(){
		return height;
	}
}
