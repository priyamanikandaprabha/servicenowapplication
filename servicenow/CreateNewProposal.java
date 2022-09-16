package servicenow;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class CreateNewProposal {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://dev72275.service-now.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("Kavinaya146@");
		driver.findElement(By.xpath("//button[@id='sysverb_login']")).click();

		Shadow shadow = new Shadow(driver);
		shadow.setImplicitWait(20);
		shadow.findElementByXPath("//div[@id='all']").click();
		shadow.findElementByXPath("//input[@id='filter']").sendKeys("Proposal", Keys.ENTER);
		//shadow.findElementByXPath("//input[@id='filter']").sendKeys("Proposal", Keys.ENTER);
		WebElement Frame = shadow.findElementByXPath("//iframe[@title='Main Content']");
		driver.switchTo().frame(Frame);
		driver.findElement(By.xpath("//button[@id='sysverb_new']")).click();
		driver.findElement(By.xpath("//input[@id='std_change_proposal.short_description']")).sendKeys("Creating New Proposals", Keys.ENTER);
		driver.findElement(By.xpath("//button[@id='sysverb_insert_bottom']")).click();	
		Thread.sleep(3000);
		driver.close();
	}

}
	
	
	