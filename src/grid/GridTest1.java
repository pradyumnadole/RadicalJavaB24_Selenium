package grid;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class GridTest1 {
	
	/* This is an example of Selenium GRID
	 * Before executing, please start a HUB and atleast 1 NODE/.
	 * By default, a Selenium node will run 5 sessions of Firefox, 
	 * 5 sessions of Chrome 
	 * and 	 1 session of IE, 
	 * but it can only run a total of 5 sessions in parallel.
	 * 
	 * HUB and NODE needs to be started before xml suite file is executed.
	 * To Start HUB: Go to the folder where Selenium Standalone Jar is present
	 * and type the following command
	 * 
	 * java -jar selenium-server-4.10.0.jar hub   ----use this  for 4.10
	 * java -jar selenium-server-4.10.0.jar standalone
	 * 
	 * console URL : http://172.21.176.1:4444
	 * 
	 * To Start NODE: Go to the folder where Selenium Standalone Jar is present
	 * and type the following command
	 * 
	 * Option1- (selenium 3.0)
	 * Node URL (ff+chrome)
	 * java -Dwebdriver.chrome.driver="D:\Training\TrainingContent\SeleniumJars_Software\chromedriver_win32_B39\chromedriver.exe" -Dwebdriver.gecko.driver="D:\Training\TrainingContent\SeleniumJars_Software\geckodriver_64\geckodriver.exe" -jar selenium-server-standalone-3.141.59.jar -role node -hub http://192.168.1.126:4444/grid/register/ -browser "browserName=firefox,version=ANY,platform=WINDOWS,maxInstances=5" -browser "browserName=chrome,version=ANY,platform=WINDOWS,maxInstances=5" -maxSession 5
	 * java -Dwebdriver.gecko.driver="D:\machineB\geckodriver.exe" -jar selenium-server-standalone-4.10.0.jar node --browserName=firefox

	 * Option2 
	 * Node URL (chrome)
	 * java -Dwebdriver.chrome.driver="C:\Users\admin\Downloads\chromedriver_win32\chromedriver.exe" -jar selenium-server-standalone-3.5.2.jar -role node -hub http://192.168.1.150:4444/grid/register -browser "browserName=chrome,version=ANY,platform=WINDOWS,maxInstances=5" -maxSession 5
	 * java -jar selenium-server-4.10.0.jar node --enable-managed-downloads true        ----use this  for 4.10
	 * 
	 * Here, we are starting the node on the same machine as the HUB, hence 'localhost' above.
	 */
	
	@Parameters({ "browser" })
	@Test
	public void test1(String browserName) throws MalformedURLException, InterruptedException{
		String hubURL = "http://localhost:4444";
		//String hubURL = "http://172.21.176.1:4444";
		WebDriver driver = null;
		if(browserName.equals("firefox")){
			System.setProperty("webdriver.gecko.driver", "D:\\machineB\\geckodriver.exe");
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("marionette", true);
			capabilities.setBrowserName(browserName);
			capabilities.setPlatform(Platform.ANY);
			FirefoxOptions browserOptions = new FirefoxOptions(capabilities);
			browserOptions.merge(capabilities);
			driver = new RemoteWebDriver(new URL(hubURL), browserOptions);
		}
		if(browserName.equals("chrome")){
			ChromeOptions chromeOptions = new ChromeOptions();
			driver = new RemoteWebDriver(new URL(hubURL), chromeOptions);
		}
		driver.get("https://www.google.com");
		Thread.sleep(14000);
		System.out.println("test1: Google: ");
//		driver.quit();
	}
	
	@Parameters({ "browser" })
	@Test
	public void test2(String browserName) throws MalformedURLException, InterruptedException{
		//String hubURL = "http://localhost:4444";
		String hubURL = "http://172.21.176.1:4444";
		
		WebDriver driver = null;
		if(browserName.equals("firefox")){
			System.setProperty("webdriver.gecko.driver", "D:\\machineB\\geckodriver.exe");
			FirefoxOptions browserOptions = new FirefoxOptions();
			driver = new RemoteWebDriver(new URL(hubURL), browserOptions);
		}
		if(browserName.equals("chrome")){
			ChromeOptions chromeOptions = new ChromeOptions();
			driver = new RemoteWebDriver(new URL(hubURL), chromeOptions);
		}
		driver.get("https://www.google.com");
		Thread.sleep(9000);
		System.out.println("test2: Google: ");
		//driver.quit();
	}
	
	@Parameters({ "browser"})
	@Test
	public void test3(String browserName) throws MalformedURLException, InterruptedException{
		//String hubURL = "http://localhost:4444";
		String hubURL = "http://172.21.176.1:4444";
		WebDriver driver = null;
		if(browserName.equals("firefox")){
			System.setProperty("webdriver.gecko.driver", "D:\\machineB\\geckodriver.exe");
			FirefoxOptions browserOptions = new FirefoxOptions();
			driver = new RemoteWebDriver(new URL(hubURL), browserOptions);
		}
		if(browserName.equals("chrome")){
			ChromeOptions chromeOptions = new ChromeOptions();
			driver = new RemoteWebDriver(new URL(hubURL), chromeOptions);
		}
		driver.get("https://www.google.com");
		Thread.sleep(10000);
		System.out.println("test3: Google: ");
		//driver.quit();
	}
	
}
