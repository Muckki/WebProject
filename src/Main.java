import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("==========프로그램 시작==========");
		
		Scanner sc = new Scanner(System.in);
		
		int command = sc.nextInt();
		
		if ( command == 1 ) {
			System.out.println("자유게시판입니다.");
		}
		int nextCommand = sc.nextInt();
		if( nextCommand == 2) {
			System.out.println("퇴장하십니다.");
		}
		
		System.out.println("==========프로그램 끝==========");
		sc.close();
	}
}
