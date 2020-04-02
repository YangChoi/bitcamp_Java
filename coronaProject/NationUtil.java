package coronaProject;

import java.text.DecimalFormat;
import java.util.Scanner;

import util.MyScanner;

/*
 * Nation[] start(Nation[] world) 라는 메소드를 만들어서 
 * 그 안에 웹사이트의 값 중 
 * 상위 10개나라의 데이터를 자동으로 입력해서 메소드로 반환해주는 메소드 
 */
public class NationUtil {

	// 배열에 데이터를 넣는 start() 메소드
	public static Nation[] start(Scanner scan) {

		// 입력할 나라 수 사용자로부터 입력받기
		System.out.print("입력할 국가의 수 : ");
		int size = MyScanner.nextInt(scan);
		Nation[] world = new Nation[size];
		// 만약 위의 Nation 타입의 배열을 만들 수 없었다면 
		// String name에 대한 배열 1개 
		// int population에 대한 배열 1개 등등...
		// 귀찮게 각 용도에 따른 배열을들 많이 만들어야겠지. 
		// 배열은 그저 정보가 들어 있는 틀이다. 
		// 그래서 이 많은 배열들을 같은 Nation이라는 목적으로 묶어서 관리할 수 있는 것이다. 
		// 그리고 그 Nation은 우리가 입력한 값을 갖고 있다. 
		
		for (int i = 0; i < world.length; i++) {
			world[i] = new Nation();
		}
		// 만약 디비 연결이 되어 있었으면 이렇게 일일이 넣어줄 필요가 없을텐데 ..
		Nation n1 = new Nation();
		world[0].name = "미국";
		world[0].confirmed = 214836;
		world[0].death = 5099;
		world[0].cured = 8878;
		world[0].population = 331002651;

		for (int i = 1; i < world.length; i++) {
			
			System.out.print("국가의 이름 : ");
			world[i].name = scan.nextLine();
			System.out.print("확진자 수 : ");
			world[i].confirmed = MyScanner.nextInt(scan);
			System.out.print("사망자 수 : ");
			world[i].death = MyScanner.nextInt(scan);
			System.out.print("완치자 수 : ");
			world[i].cured = MyScanner.nextInt(scan);
			System.out.print("총인구수 : ");
			world[i].population = MyScanner.nextInt(scan);
			System.out.println("--------------------------");
			//world[i] = n; 애써 넣어놓은 데이터 갈아엎는 코드 
		}
		return world;
	}

	// 출력하는 print 메소드
	public static void print(Nation[] world) {
		System.out.println("======================================================");
		for (int i = 0; i < world.length; i++) {
			System.out.print((i + 1));
			System.out.print("\t" + world[i].name);
			System.out.print("\t" + world[i].confirmed);
			System.out.print("\t" + world[i].death);
			System.out.print("\t" + world[i].cured);
			System.out.print(showStat(world[i]));
			System.out.println("\t" + world[i].population);
			
		}
		System.out.println("======================================================");
	}
	
	// 사망률, 완치율, 인구당 발생률을 각각 계산하는 메소드 
	// 결과값을 String으로 묶어준다. 
	public static String showStat(Nation n) {
		// 여기서 사망률, 완치율, 인구당 발생률을 각각 계산한 다음
		// 한개의 커다른 스트링을 묶어주자 
		
		// 사망률 : 사망자수 / 총 확진자수 > 결과값 : double 
		
		// 완치율 : 완치자수 / 총 확진자수 > 결과값 : double
		
		// 인구당 발생률 : 총 확진자 수 / 총 인구 *1000000 > 결과값 : int
		
		// 근데 100만명 인구당 발생률 -> 총 확진자 수 / 총인구 하면 
		// 0 이 나올 테고 0은 뭘 곱해도 0
		// 따라서 총 확진자수 * 1000000 / 총인구로 한다. 
		
		// 위의 과정대로 하니까.. 오버플로우가 발생해버린다. 
		// 따라서 소수점을 좀 버린다. 
		double deathRate = (double)n.death/n.confirmed * 100; //퍼센트니까 * 100
		double cureRate = (double)n.cured/n.confirmed * 100;
		int ppp = (int) (((double)n.confirmed / n.population) * 1000000);
		// 소수점을 좀 정리해야겠다.. 
		// 어떤 숫자가 있으면 ##.## 형태로 해준다. 
		String result =
				"\t" + new DecimalFormat("##.##").format(deathRate) + 
				"%\t" + new DecimalFormat("##.##").format(cureRate) + 
				"%\t" + ppp + "%";
		
		return result;
		
	}

	// 수정하는 update 메소드
	public static Nation[] update(Nation[] world, int index, Scanner scan) {

		Nation n = new Nation();
		System.out.print("국가의 이름 : ");
		n.name = scan.nextLine();
		System.out.print("확진자 수 : ");
		n.confirmed = MyScanner.nextInt(scan);
		System.out.print("사망자 수 : ");
		n.death = MyScanner.nextInt(scan);
		System.out.print("완치자 수 : ");
		n.cured = MyScanner.nextInt(scan);
		System.out.print("총인구수 : ");
		n.population = MyScanner.nextInt(scan);

		world[index] = n;
		
		return world;
	}

	
}
