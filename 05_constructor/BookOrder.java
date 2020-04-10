import java.util.Scanner;

class BookDTO {
	private String title; 
	private String author;
	private int price; 
	private int qty; // 갯수 
	private int total; 

	//생성자를 통해서 책 제목, 저자, 단가, 갯수 입력받기 
	
	// 생성자로 데이터 받기 
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
		
		// 입력 
		BookDTO[] dto = new BookDTO[]{new BookDTO("어쩌고", "저쩌고", 25000, 10),
									 new BookDTO("어ㅇㅇ", "저ㄹㄹ", 25340, 11),
								     new BookDTO("어dㄹ", "저ㅈㄷ", 11110, 1)};

		System.out.println("책제목"+"\t\t"+"저자"+"\t\t"+"단가"+"\t"+"개수"+"\t"+"합계");
		
		for(BookDTO a : dto){
			a.calc();
			System.out.println(a.getTitle()+"\t\t"+a.getAuthor()+"\t\t"+a.getPrice()+"\t"+a.getQty()+"\t"+a.getTotal());
	
		}
	}
}
