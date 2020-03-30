package day04;

public class StarPrinter {
	// 접근 제한자를 활용해보자
	// 다른 곳에서 사용되는 메소드가 아니라면
	// 무조건 private으로 만들어주는게 옳다.
	public void selectNumber(int choice, int lineNumber) {
		// 외부에서는 얘만 호출을 하고
		// 얘는 내부에 private으로 되어 있는 메소드를 호출함
		switch (choice) {
		case 1:
			starPrint1(lineNumber);
			break;
		case 2:
			starPrint2(lineNumber);
			break;
		case 3:
			starPrint3(lineNumber);
			break;
		case 4:
			starPrint4(lineNumber);
			break;
		case 5:
			starPrint5(lineNumber);
			break;
		case 6:
			starPrint6(lineNumber);
			break;
		case 7:
			starPrint7(lineNumber);
			break;
		case 8:
			starPrint8(lineNumber);
			break;
		case 9:
			starPrint9(lineNumber);
			break;
		case 10:
			starPrint10(lineNumber);
			break;

		}
	}

	// 별찍기 1번
	// private : 이 클래스 내에서만 쓰겠다.
	private void starPrint1(int lineNumber) {
		// 별찍기 1번 코드를 여기에 적어준다
		for (int i = 1; i <= lineNumber; i++) {
			String stars = "";
			for (int k = 1; k <= i; k++) {
				stars += "*";
			}
			System.out.println(stars);
		}
	}

	// 5분 동안 별찍기 2~5번
	// 별찍기 2번
	private void starPrint2(int lineNumber) {
		for (int i = 1; i <= lineNumber; i++) {
			String stars = "";
			for (int k = i; k <= lineNumber; k++) {
				stars += "*";
			}
			System.out.println(stars);
		}
	}

	// 별찍기 3번
	private void starPrint3(int lineNumber) {
		for (int i = 1; i <= lineNumber; i++) {
			String stars = "";
			// 3번 처럼 왼쪽에 공백이 있는 경우엔
			// width for문 (k)이 height for문(i) 안에 2번 나온다.
			// 먼저 공백을 넣는 for 문 하나
			// 그 다음 별을 넣는 for 문 하나
			for (int k = 1; k <= lineNumber - i; k++) {
				stars += " ";
			}
			for (int k = 1; k <= i; k++) {
				stars += "*";
			}
			System.out.println(stars);
		}
	}

	// 별찍기 4번
	private void starPrint4(int lineNumber) {
		for (int i = 1; i <= lineNumber; i++) {
			String stars = "";
			for (int k = 1; k <= i - 1; k++) {
				stars += " ";
			}
			for (int k = i; k <= lineNumber; k++) {
				stars += "*";
			}
			System.out.println(stars);
		}

	}

	// 별찍기 5번
	private void starPrint5(int lineNumber) {
		for (int height = 1; height <= lineNumber; height++) {
			String stars = "";
			for (int width = 1; width <= lineNumber - height; width++) {
				stars += " ";
			}
			for (int width = 1; width <= 2 * height - 1; width++) {
				stars += "*";
			}
			System.out.println(stars);

		}
	}

	// 별찍기 6번
	private void starPrint6(int lineNumber) {
		for (int height = lineNumber; height >= 1; height--) {
			String stars = "";
			for (int width = 1; width <= lineNumber - height; width++) {
				stars += " ";
			}
			for (int width = 1; width <= 2 * height - 1; width++) {
				stars += "*";
			}
			System.out.println(stars);

		}
	}

	// 별찍기 7번
	private void starPrint7(int lineNumber) {
		// 강사님 코드
		for (int height = 1; height <= 2 * lineNumber - 1; height++) {
			String stars = "";
			if (height < lineNumber) {// 윗부분
				for (int width = 1; width <= height; width++) {
					stars += "*";
				}
			} else { // 아랫부분
				// height이 얼마면 여기에 들어오는가? lineNumber보다 크거나 같을 경우
				// number~2*number-1일 동안 들어오므로
				// 아래의 for문은 딱 1번만 반복이 된다.

				// 그럼 내가 선택할 수 있는 것
				// 1. 아래의 for문을 number~2*number-1에 맞춰서 다 바꿔주는 것
				// 2. 새로운 변수를 만들어서 number~2*number-1을 1~number로 바꿔주기
				int lowerHeight = height - lineNumber + 1;

				for (int width = lowerHeight; width <= lineNumber; width++) {
					stars += "*";
				}
			}
			System.out.println(stars);

		}
	}

	// 별찍기 8번
	private void starPrint8(int lineNumber) {
		// lineNumber가 아닌 number-1이 되는 메소드가 제대로 나오지 않기 때문에
		// 둘 중 하나를 lineNumber 메소드를 선택하고
		// 다른 하나는 여기에 적어주자
		for (int i = 1; i <= lineNumber; i++) {
			String stars = "";
			if (i < lineNumber) {
				for (int width = 1; width <= lineNumber - i; width++) {
					stars += " ";
				}
				for (int width = 1; width <= i; width++) {
					stars += "*";
				}
				System.out.println(stars);
			}
		}
		starPrint4(lineNumber);
	}

	// 별찍기 9번
	private void starPrint9(int lineNumber) {
		for (int height = 1; height < lineNumber; height++) {
			String stars = "";
			for (int width = 1; width <= lineNumber - height; width++) {
				stars += " ";
			}
			for (int width = 1; width <= 2 * height - 1; width++) {
				stars += "*";
			}
			System.out.println(stars);

		}
		starPrint6(lineNumber);
	}

	private void starPrint10(int lineNumber) {
		for (int height = 1; height <= 2 * lineNumber - 1; height++) {
			String stars = "";
			// 줄 번호가 1이거나 혹은 2*number -1일 때
			// 별을 2*number-1개 찍어준다
			if (height == 1 || height == 2 * lineNumber - 1) {
				for (int width = 1; width <= 2 * lineNumber - 1; width++) {
					stars += "*";
				}// 맨 첫줄과 마지막 줄의 별 
			}else if(height < lineNumber) {
				int upperHeight = height -1; // 2, 3, 4 하는 것을 1, 2, 3하기 위해선 -1을 해준다. 
				for(int width = upperHeight; width <= lineNumber-1; width++) {
					stars +="*";
				}
				for(int width = 1; width <= 2*upperHeight-1; width++) {
					stars += " ";
				} // 위 왼쪽 부분
				for(int width = upperHeight; width <= lineNumber-1; width++) {
					stars +="*";
				}// 위 오른쪽 부분
			}else { // 아랫부분
				int lowerHeight = height - lineNumber + 1;
				for(int width = 1; width <= lowerHeight; width++) {
					stars += "*";
				}
				// 가운데 공백의 갯수는..
				// 7, 5, 3, 1...
				// 그런데 총 너비는 고정이니까 
				// 그 줄의 별의 갯수들만 빼주면 나머지는 다 공백이다. 
				// 그렇다면 별의 갯수는 얼마인가? 
				// lowerHeight * 2
				// 즉 2*lineNumber -1 -2*lowerHeight
				// =2(lineNumber -lowerHeight) -1
				for(int width = 1; width <= 2*(lineNumber-lowerHeight)-1; width++) {
					stars += " ";
				}
				for(int width = 1; width <= lowerHeight; width++) {
					stars += "*";
				}
			}
			System.out.println(stars);
		}
	}
}
