package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment3 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://timesofindia.indiatimes.com/poll.cms");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement expr = driver.findElement(By.xpath("//*[@id=\"mathq2\"]"));
		
		/*char a= expr.getText().charAt(0);
		
		char b = expr.getText().charAt(2);
		
		char c = expr.getText().charAt(4);
		WebElement field = driver.findElement(By.xpath("//*[@id=\"mathuserans2\"]"));
		int a1 = Character.getNumericValue(a);
		int c1 = Character.getNumericValue(c);
		
		System.out.println(a+" "+b+" "+c);
		switch(b) {
		
		case '+' :
			
			Integer t= a1+c1;
			field.sendKeys(t.toString());
			break;
			
		case '-':
			
			Integer s = a1-c1;
			field.sendKeys(s.toString());
			break;
		
		case '*':
			
			Integer h = a1*c1;
			field.sendKeys(h.toString());
			break;
			

		}*/
		
		String s=expr.getText().replace(" ", "");

		s=s.replace("=", "");

		String[] c=new String[2];

		c=s.split("[+ - * / ]");

		String operator=s.replace(c[0], "");

		operator=operator.replace(c[1], "");

		int i=Integer.parseInt(c[0]);

		int j=Integer.parseInt(c[1]);

		int result=0;

		if(operator.equals("+")){

		result=i+j;

		}

		else if (operator.equals("-")) {

		result=i-j;

		}else if (operator.equals("*")) {

		result=i*j;

		}else if (operator.equals("/")) {

		result=i/j;

		}

		else

		{


		}

		driver.findElement(By.name("mathuserans2")).sendKeys(String.valueOf(result));

	}
	}

