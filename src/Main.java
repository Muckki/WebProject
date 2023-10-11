import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
				
				LocalDateTime now = LocalDateTime.now();
				
				String date = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

				Article article = new Article(articleNum,title,body,date);
				articles.add(article);
				
				articleNum++;
			}else if(command.equals("article detail")) {
				while(true) {
					System.out.println("몇 번째 글을 조회하시겠습니까?");
					System.out.println("명령어) (게시글은 숫자만 입력. 퇴장시 return 입력)");
					String cmd = scanner.nextLine();
					
					Article article = articles.get(0);
					try {
						int detailNum = Integer.parseInt(cmd);
						String check = "true";
						for (int i = articles.size()-1; i >= 0; i--) {
							Article detailArticle = articles.get(i);
							if (detailArticle.articleNum == detailNum) {
				            	check = "true";
				            	article = detailArticle;
				            	break;
				            }else if(detailArticle.articleNum !=detailNum || detailNum == 0) {
								check = "false";
							}
				        }
						if(check == "true") {
							System.out.println(detailNum + "번째 글입니다.");
							System.out.println("번호 : " + detailNum);
							System.out.println("날짜 : " + article.date);
							System.out.println("제목 : " + article.title);
							System.out.println("내용 : " + article.body);
						}else if(check == "false") {
							System.out.println(detailNum + "번 게시물은 존재하지 않습니다.");
						}
					}catch (NumberFormatException e) {
						if(cmd.equals("return")) {
							break;
						}else {
							System.out.println("존재하지 않는 명령어 입니다.");
						}
					}
					
				}
			}else if(command.equals("article delete")) {
				if(articles.size() != 0) {
					while(true) {
						System.out.println("몇 번째 글을 삭제하시겠습니까?");
						System.out.println("명령어) (게시글은 숫자만 입력. 퇴장시 return 입력)");
						String cmd = scanner.nextLine();
						try {
							int deleteNum = Integer.parseInt(cmd);
							String check = "true";
							for (int i = articles.size()-1; i >= 0; i--) {
								Article article = articles.get(i);
								if (article.articleNum == deleteNum) {
					            	articles.remove(i);
					            	check = "true";
					            	break;
					            }else if(article.articleNum !=deleteNum || deleteNum == 0) {
									check = "false";
								}
					        }
							if(check == "true") {
								System.out.println(deleteNum + "번째 게시글을 삭제했습니다.");
							}else if(check == "false") {
								System.out.println(deleteNum + "번째 게시글은 존재하지 않습니다.");
							}
						}catch (NumberFormatException e) {
							if(cmd.equals("return")) {
								break;
							}else {
								System.out.println("존재하지 않는 명령어 입니다.");
							}
						}						
					}
				}else {
					System.out.println("게시글이 존재하지 않습니다.");
				}
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
	String date;
	Article(int articleNum, String title, String body, String date){
		this.articleNum = articleNum;
		this.title = title;
		this.body = body;
		this.date = date;
	}
}
