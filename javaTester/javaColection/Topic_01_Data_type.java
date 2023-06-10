package javaColection;

public class Topic_01_Data_type {
	static int number;
	// biến toàn cục
	// khi khai báo bất kì 1 biến ở ngoài class ( biến toàn cục ) thì mở đầu sẽ là static.
		
	String address = "ho chi minh";
	public static void main(String[] args) {
		// biến cục bộ
		// khi khai báo trong 1 biến cục bộ ( 1 class ) sẽ không cần khai báo thêm kiểu dữ liệu static
		// khi khai báo sẽ thêm value/ không thể thiếu giá trị của biến.
		int studentNumber = 0;
		System.out.println(number);
		System.out.println(studentNumber);
		
		// cách khai báo biến thông qua class bằng cách khởi tạo 1 class vào trong 1 class
		
		Topic_01_Data_type topic = new Topic_01_Data_type ();
		System.out.println(topic.address);
	
	}
}
