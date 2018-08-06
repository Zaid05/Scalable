package automation;



import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;



public class WikiTestCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver;
		System.setProperty("webdrive.gecko.driver", "geckodriver.exe");	
		driver = new FirefoxDriver();
		
		String url = "https://www.wikipedia.org/";
		//Navigate to http://wikipedia.org/
		driver.get(url);
		//Search for ‘Taylor Swift’
		driver.findElement(By.id("searchInput")).sendKeys("Taylor Swift");
		//Select English language 
		driver.findElement(By.id("searchLanguage")).click();
		Select dropdownLangs = new Select(driver.findElement(By.id("searchLanguage")));
		dropdownLangs.selectByVisibleText("English");
		//Click on Search button
		driver.findElement(By.xpath("//button[@class=\"pure-button pure-button-primary-progressive\"]")).click();
		//Go to External Links 
		driver.findElement(By.partialLinkText("External links")).click();
		//Validate the ‘Studio albums’row
		WebElement tableRow = driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/div[17]/table/tbody/tr[3]"));
		String rowText = tableRow.getText();
		String[] section = {"Taylor Swift","Fearless","Speak Now","Red","1989","Reputation"};
		System.out.println("Studio albums’row results:");
		for (int i = 0; i < section.length-1; i++) {
			boolean section_cont = rowText.contains(section[i]);
			if (section_cont) {
				System.out.println(section[i] + "is contained on 'Studio albums' row");
			} else {
				System.out.println(section[i] + "is not contained on 'Studio albums' row");
			}
		}
		//Hover message in 'Reputation' link
		Actions build = new Actions(driver);
		WebElement reputation = driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/div[17]/table/tbody/tr[3]/td/div/ul/li[6]/i/a"));
		build.moveToElement(reputation).build().perform();
		
	}

}
