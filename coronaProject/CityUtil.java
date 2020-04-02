package coronaProject;

import java.text.DecimalFormat;
import java.util.Scanner;

import util.MyScanner;

public class CityUtil {

	// 입력
	public static City[] start(Scanner scan) {

		System.out.print("입력할 지역 수 : ");
		int size = MyScanner.nextInt(scan);
		City[] cities = new City[size];

		for (int i = 1; i < cities.length; i++) {
			City c = new City();

			System.out.print("지역명 : ");
			c.name = scan.nextLine();
			System.out.print("확진자 수 : ");
			c.confirmed = MyScanner.nextInt(scan);
			System.out.print("사망자 수 : ");
			c.death = MyScanner.nextInt(scan);
			System.out.print("완치자 수 : ");
			c.cleared = MyScanner.nextInt(scan);
			System.out.print("격리해제자 수 : ");
			c.endQuarantine = MyScanner.nextInt(scan);
			System.out.print("총인구수 : ");
			c.population = MyScanner.nextInt(scan);
			System.out.println("--------------------------");
			cities[i] = c;
			// 위와 같이 하면 이미 만들어진 것을 덮어씌운다.
		}
		return cities;
	}

	// 출력
	public static void print(City[] cities) {
		if (cities == null) {
			System.out.println("아직 입력된 정보가 없습니다");
		} else {
			System.out.println("======================================================");
			for (int i = 0; i < cities.length; i++) {
				System.out.print((i + 1));
				System.out.print("\t" + cities[i].name);
				System.out.print("\t" + cities[i].confirmed);
				System.out.print("\t" + cities[i].death);
				System.out.print("\t" + cities[i].cleared);
				System.out.print("\t" + cities[i].endQuarantine);
				System.out.print(showStat(cities[i]));
				System.out.println("\t" + cities[i].population);

			}
			System.out.println("======================================================");
		}

	}

	// 계산
	public static String showStat(City c) {

		double deathRate = (double) c.death / c.confirmed * 100; // 퍼센트니까 * 100
		double cureRate = (double) c.cleared / c.confirmed * 100;
		int ppp = (int) (((double) c.confirmed / c.population) * 1000000);
		// 소수점을 좀 정리해야겠다..
		// 어떤 숫자가 있으면 ##.## 형태로 해준다.
		String result = "\t" + new DecimalFormat("##.##").format(deathRate) + "%\t"
				+ new DecimalFormat("##.##").format(cureRate) + "%\t" + ppp + "%";

		return result;

	}

	// 수정
	public static City[] update(int index, Scanner scan, City[] cities) {

		City c = new City();
		System.out.print("지역 이름 : ");
		c.name = scan.nextLine();
		System.out.print("확진자 수 : ");
		c.confirmed = MyScanner.nextInt(scan);
		System.out.print("사망자 수 : ");
		c.death = MyScanner.nextInt(scan);
		System.out.print("완치자 수 : ");
		c.cleared = MyScanner.nextInt(scan);
		System.out.print("격리해제자 수 : ");
		c.endQuarantine = MyScanner.nextInt(scan);
		System.out.print("총인구수 : ");
		c.population = MyScanner.nextInt(scan);
		cities[index] = c;

		return cities;
	}

	public static City[] addDate(Scanner scan, City[] cities) {
		if (cities == null) {
			cities = start(scan);
		} else {
			System.out.println("1. 전체 다시 입력  2. 개별수정 ");
			int choice = MyScanner.nextInt(scan);
			switch (choice) {
			case 1:
				cities = start(scan);
				break;
			case 2:
				print(cities);
				int index = CoronaEx.validateIndex(scan, cities.length);
				cities = update(index, scan, cities);
				break;
			}
		}
		return cities;
	}

}
