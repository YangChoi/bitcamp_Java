package gameProject;


// 캐릭터 구조체 
public class Character {
	// 이름 
	// 직업 
	// hp 
	public String name; 
	public int job;
	public int hp;
	
	
	// 직업에는 전사, 마법사, 궁수
	// 전사는 궁수에게 100프로 확률로 데미지가 들어간다. 
	// 마법사한테는 50프로 확률로 데미지가 들어간다. 
	
	// 마법사는 전사한테 100프로 확률데미지 
	// 궁수한테는 50프로 확률데미지
	
	// 같은 직업끼리는 75% 확률로 데미지 들어간다. 
	
	// 궁수는 마법사한테 100프로 확률데미지 
	// 전사한테는 50프로 확률데미지
	
	// hp는 다 10 
	// 데미지는 다 1
	// 컴퓨터가 랜덤하게 만드는 적이랑 싸운다. 
	// 내 턴일 때 -> 적이 등장
	// 주사위를 굴려주세요 -> y누르기 
	// 앗 얼마가 나와서 공격이 성공 or 상대 직업이 요거라 공격이 무조건 들어갑니다. 
	// 메세지 출력 후 컴퓨터 공격 턴 
	// 앗 컴퓨터가 얼마가 나와서 공격이 성공 or 내 직업이 이거라 공격이 무조건 들어갑니다 
	// 내 피가 다 달면? game over -> 다시하기 
	// 컴퓨터 피가 다 달면? 내 피를 회복하고 새로운 적을 만날지 결정 
	// 점수 기준 : 컴퓨터를 몇이나 잡았나 

	
}
