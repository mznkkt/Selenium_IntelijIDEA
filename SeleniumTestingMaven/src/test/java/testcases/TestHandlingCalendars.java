package testcases;

import java.time.Duration;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestHandlingCalendars {

	static int targetDay = 0,
			targetMonth = 0,
			targetYear = 0;
	
	static int currentDay = 0,
			currentMonth = 0,
			currentYear = 0;
	
	static int jumpMonthBy = 0;

	static boolean increment = true;
	public static void main(String[] args) throws InterruptedException {
		
		String dayToSet = "17/12/2025";
		
		//get current date
		GetCurrentDateMonthAndYear();
		System.out.println(currentDay+" "+currentMonth+" "+currentYear);
		
		//get target date
		GetTargetDateMonthAndYear(dayToSet);
		System.out.println(targetDay+" "+targetMonth+" "+targetYear);
		
		//get Jump Month
		CalculateHowManyMonthsToJump();
		System.out.println(jumpMonthBy);
		System.out.println(increment);
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.switchTo().frame(0); 
		
		driver.findElement(By.xpath("//*[@id=\"datepicker\"]")).click();
		
		for(int i=0; i<jumpMonthBy; i ++) {
			 
			if(increment) {
				driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[2]")).click();
			}else {
				
				driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[1]")).click();
			}
			
			Thread.sleep(1000);
		}
		
		driver.findElement(By.linkText(Integer.toString(targetDay))).click();
		
	}
	
	public static void GetCurrentDateMonthAndYear() {
		
		Calendar cal = Calendar.getInstance();
		
		currentDay = cal.get(Calendar.DAY_OF_MONTH);
		currentMonth = cal.get(Calendar.MONTH)+1;
		currentYear = cal.get(Calendar.YEAR);
		
	}
	
	public static void GetTargetDateMonthAndYear(String dateString) {
		
		int firstIndex = dateString.indexOf("/");
		int lastIndex = dateString.lastIndexOf("/");
		
		String day = dateString.substring(0, firstIndex);
		targetDay = Integer.parseInt(day);
		
		String month = dateString.substring(firstIndex+1, lastIndex);
		targetMonth = Integer.parseInt(month);
		
		String year = dateString.substring(lastIndex+1, dateString.length());
		targetYear = Integer.parseInt(year);
		
		
	}
	
	
	public static void CalculateHowManyMonthsToJump() {
		
		if((targetMonth-currentMonth)>0) {
			
			jumpMonthBy = targetMonth-currentMonth;
			
		}else {
			
			jumpMonthBy = (currentMonth-targetMonth);
			increment = false;
		}
			
		
		
	}

}
