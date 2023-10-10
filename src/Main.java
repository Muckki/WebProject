import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("==프로그램 시작==");
		
		Scanner scanner = new Scanner(System.in);
		int articleNum = 1;
		
		List<Article> articles = new ArrayList<>();

		while (true) {
			System.out.println("명령어 ) ");
			String command = scanner.nextLine();
			if(command.equals("article list")) {
				if(articles.size() != 0) {
					System.out.println("번호   /  제목");
					for(int i = articles.size(); i>0; i--) {
						Article article = articles.get(i-1);
						System.out.println(article.articleNum + "   /   " + article.title);						
					}
				}else {
					System.out.println("게시글이 없습니다.");					
				}
			}else if (command.equals("article write")) {
				System.out.println("제목 : ");
				String title = scanner.nextLine();
				System.out.println("내용 : ");
				String body = scanner.nextLine();
				System.out.println(articleNum + "번글이 생성되었습니다.");
				
				Article article = new Article(articleNum, title,body);
				articles.add(article);
				
				articleNum += 1;
			}else if( command.equals("exit")) {
				break;
			}else if( command.length() < 1) {
				System.out.println("명령어를 입력해주세요");
			}
			else {
				System.out.println("존재하지 않는 명령어 입니다.");
			}
		}
		
		
		scanner.close();
		System.out.println("==프로그램 끝==");
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
