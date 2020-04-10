import java.util.Scanner;

class BookDTO {
	private String title; 
	private String author;
	private int price; 
	private int qty; // ���� 
	private int total; 

	//�����ڸ� ���ؼ� å ����, ����, �ܰ�, ���� �Է¹ޱ� 
	
	// �����ڷ� ������ �ޱ� 
	public BookDTO(String title, String author, int price, int qty){
		this.title = title;
		this.author = author;
		this.price = price; 
		this.qty = qty; 
	}
	

	public void calc(){
		total = price * qty;
	}

	//getter
	public String getTitle(){
		return title; 
	}
	public String getAuthor(){
		return author; 
	}
	public int getPrice(){
		return price; 
	}
	public int getQty(){
		return qty; 
	}
	public int getTotal(){
		return total; 
	}
}

class BookOrder {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
//		BookDTO[] dto = new BookDTO[3];
		
		// �Է� 
		BookDTO[] dto = new BookDTO[]{new BookDTO("��¼��", "��¼��", 25000, 10),
									 new BookDTO("���", "������", 25340, 11),
								     new BookDTO("��d��", "������", 11110, 1)};

		System.out.println("å����"+"\t\t"+"����"+"\t\t"+"�ܰ�"+"\t"+"����"+"\t"+"�հ�");
		
		for(BookDTO a : dto){
			a.calc();
			System.out.println(a.getTitle()+"\t\t"+a.getAuthor()+"\t\t"+a.getPrice()+"\t"+a.getQty()+"\t"+a.getTotal());
	
		}
	}
}
