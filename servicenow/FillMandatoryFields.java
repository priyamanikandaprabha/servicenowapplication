package servicenow;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class FillMandatoryFields {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://dev72275.service-now.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("Kavinaya146@");
		driver.findElement(By.xpath("//button[@id='sysverb_login']")).click();
		
		//Shadow dom->for encrption purpose hiding the dom page
		Shadow shadow = new Shadow(driver);
		shadow.setImplicitWait(20);
		shadow.findElementByXPath("//div[@id='all']").click();
		shadow.findElementByXPath("//span[text()='label']").click();
		//shadow.findElementByXPath("//input[@id='filter']").sendKeys("Callers", Keys.ENTER);
		WebElement Frame1 = shadow.findElementByXPath("//iframe[@title='Main Content']");
		driver.switchTo().frame(Frame1);
		driver.findElement(By.xpath("//span[text()='btn-text']")).click();
		driver.findElement(By.xpath("//span[@class='icon icon-search']")).click();
		//windowhandling
		Set<String>windowHandles=driver.getWindowHandles();
		List<String>swi=new ArrayList<String>(windowHandles);
		driver.switchTo().window(swi.get(1));
		driver.findElement(By.linkText("IT")).click();
		driver.switchTo().window(swi.get(0));
		WebElement Frame2=shadow.findElementByXPath(("//iframe[@title='Main Content']"));
        driver.switchTo().frame(Frame2);
        driver.findElement(By.xpath("//button[@class='btn btn-default']")).click(); 
        driver.findElement(By.xpath("//div[@class='list-item arrow colview-active']")).click();
        driver.findElement(By.xpath("//table[@id='window.kb_categories_dialog']//tbody//tr[2]//td//span[text()='IT']")).click();
        driver.findElement(By.xpath("//button[@id='ok_button']")).click(); 
        WebElement Frame3=shadow.findElementByXPath(("//iframe[@title='Main Content']"));
        driver.switchTo().frame(Frame3);
        
        
        
        WebElement ShortDesc = driver.findElement(By.id("kb_knowledge.short_description"));
		ShortDesc.clear();
		ShortDesc.sendKeys("Edited Via Automation");
		driver.findElement(By.id("sysverb_insert_bottom")).click();

	}

}
