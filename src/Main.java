import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("==���α׷� ����==");
		
		Scanner scanner = new Scanner(System.in);
		int articleNum = 1;
		
		List<Article> articles = new ArrayList<>();

		while (true) {
			System.out.println("��ɾ� ) ");
			String command = scanner.nextLine();
			if(command.equals("article list")) {
				if(articles.size() != 0) {
					System.out.println("��ȣ   /  ����");
					for(int i = articles.size(); i>0; i--) {
						Article article = articles.get(i-1);
						System.out.println(article.articleNum + "   /   " + article.title);						
					}
				}else {
					System.out.println("�Խñ��� �����ϴ�.");					
				}
			}else if (command.equals("article write")) {
				System.out.println("���� : ");
				String title = scanner.nextLine();
				System.out.println("���� : ");
				String body = scanner.nextLine();
				System.out.println(articleNum + "������ �����Ǿ����ϴ�.");
				
				Article article = new Article(articleNum, title,body);
				articles.add(article);
				
				articleNum += 1;
			}else if( command.equals("exit")) {
				break;
			}else if( command.length() < 1) {
				System.out.println("��ɾ �Է����ּ���");
			}
			else {
				System.out.println("�������� �ʴ� ��ɾ� �Դϴ�.");
			}
		}
		
		
		scanner.close();
		System.out.println("==���α׷� ��==");
	}
}

class Article {
	int articleNum;
	String title;
	String body;
	
	Article(int articleNum, String title, String body){
		this.articleNum = articleNum;
		this.title = title;
		this.body = body;
	}
}
