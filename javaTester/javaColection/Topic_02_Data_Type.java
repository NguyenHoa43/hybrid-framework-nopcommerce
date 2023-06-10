package javaColection;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Topic_02_Data_Type {
	
	// Primitive type => kiểu dữ liệu nguyên thủy
	// byte - short - int - long : sẽ biểu diện hệ không có dấu => số nguyên
	byte bNumber;
	short sNumber;
	int iNumber;
	long lNumber;
	
	// float - double : sẽ biểu diễn hệ có dấu => thập phân
	float fNumber;
	double dNumber;
	
	// Reference type : kiểu tham chiếu
	
	// array ký hiệu là dấu ngoạc vuông : []
	String[] studentAddress = {" ha noi", "ho chi minh", "vinh"};
	Integer[] studentNumber = {12, 67,9};
	// String : khai báo kiểu chuỗi bao gồm ký tự không có số
	String[] studentAdd = {" ha noi", "ho chi minh", "vinh"};
	String Name = "ha noi";
	// class
	Topic_02_Data_Type topic = new Topic_02_Data_Type();
	// Interface
	WebDriver driver;
	
	// object
	Object aObject;
	// Collection
	// List/ Set/ Queue / Map
	List<WebElement> homePageLink = driver.findElements(By.tagName("s"));
 	Set<String> AllWindow = driver.getWindowHandles();
	List<String> productName = new ArrayList<String>();
	
	public static void main(String[] args) {
		//
	}
	
}
