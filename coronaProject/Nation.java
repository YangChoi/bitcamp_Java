package coronaProject;
/*
 * 세계 현황에서 쓸 데이터타입을 미리 구현해놓은 구조체 클래스
 * id : 디비에서의 primary key (거의 int다) >> int id
 * 나라이름 : String >> String name
 * 확진자 수 : int >> int confirmed
 * 사망자 수 : int >> int death
 * 완치자 수 : int >> int cured 
 * 총 인구  : int >> int population
 * 
 * 이름을 지을 때 굳이 필드 이름에 우리가 nation_id 혹은 nationId 이런 식으로 적을 필요가 없다. 
 * 왜냐하면 nation 안에는 id가 하나밖에 없고, 
 * 또 다른데서 호출 할 떄에는 nationId로 접근하는게 아니라 
 * Nation의 변수 안의 id 이런 식으로 접근하기 때문에 
 * 우리가 굳이 필요이름에 nation 같은 별도의 설명을 적어줄 필요가 없다. 
 * 
 * 
 */
public class Nation {
//	public int id; // 국가번호
	public String name; // 나라이름
	public int confirmed; // 확진자
	public int death; // 사망자
	public int cured; // 완치자
	public int population; // 인구수


}
