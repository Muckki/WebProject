import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
				
				LocalDateTime now = LocalDateTime.now();
				
				String date = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

				Article article = new Article(articleNum,title,body,date);
				articles.add(article);
				
				articleNum++;
			}else if(command.equals("article detail")) {
				while(true) {
					System.out.println("�� ��° ���� ��ȸ�Ͻðڽ��ϱ�?");
					System.out.println("��ɾ�) (�Խñ��� ���ڸ� �Է�. ����� return �Է�)");
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
							System.out.println(detailNum + "��° ���Դϴ�.");
							System.out.println("��ȣ : " + detailNum);
							System.out.println("��¥ : " + article.date);
							System.out.println("���� : " + article.title);
							System.out.println("���� : " + article.body);
						}else if(check == "false") {
							System.out.println(detailNum + "�� �Խù��� �������� �ʽ��ϴ�.");
						}
					}catch (NumberFormatException e) {
						if(cmd.equals("return")) {
							break;
						}else {
							System.out.println("�������� �ʴ� ��ɾ� �Դϴ�.");
						}
					}
					
				}
			}else if(command.equals("article delete")) {
				if(articles.size() != 0) {
					while(true) {
						System.out.println("�� ��° ���� �����Ͻðڽ��ϱ�?");
						System.out.println("��ɾ�) (�Խñ��� ���ڸ� �Է�. ����� return �Է�)");
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
								System.out.println(deleteNum + "��° �Խñ��� �����߽��ϴ�.");
							}else if(check == "false") {
								System.out.println(deleteNum + "��° �Խñ��� �������� �ʽ��ϴ�.");
							}
						}catch (NumberFormatException e) {
							if(cmd.equals("return")) {
								break;
							}else {
								System.out.println("�������� �ʴ� ��ɾ� �Դϴ�.");
							}
						}						
					}
				}else {
					System.out.println("�Խñ��� �������� �ʽ��ϴ�.");
				}
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
	String date;
	Article(int articleNum, String title, String body, String date){
		this.articleNum = articleNum;
		this.title = title;
		this.body = body;
		this.date = date;
	}
}
