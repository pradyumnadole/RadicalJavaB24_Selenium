package basic;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class B24MyUtility {
	public void takescreenshot(WebDriver driver) throws IOException {
		
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File Fi = screenshot.getScreenshotAs(OutputType.FILE);
		File FiNew = new File ("D:\\RadicalSelenium\\Screenshot\\"+Math.random()+".png");
		FileUtils.copyFile(Fi, FiNew);
	}	
}
