import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("==========���α׷� ����==========");
		
		Scanner sc = new Scanner(System.in);
		
		int command = sc.nextInt();
		
		if ( command == 1 ) {
			System.out.println("�����Խ����Դϴ�.");
		}
		int nextCommand = sc.nextInt();
		if( nextCommand == 2) {
			System.out.println("�����Ͻʴϴ�.");
		}
		
		System.out.println("==========���α׷� ��==========");
		sc.close();
	}
}
