package Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


import Pages.GoogleSearchPage;
import utils.ExcelDataProvider;

public class BrowserTest {

	WebDriver driver=null;
	ExtentSparkReporter htmlReporter;
	ExtentReports extent;
	ExtentTest test1;
	ExtentTest test2;

	@BeforeSuite
	public void setUpTest() {

		htmlReporter = new ExtentSparkReporter("extentreport.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",projectPath+"\\drivers\\chromedriver\\chromedriver.exe");// so that the webdriver can be identified by the system even if the migrate it to some other machine 
		driver = new ChromeDriver();//we have used old method here we can also use driver manager instead
	}
	@Test(dataProvider="test1data" ,dataProviderClass = ExcelDataProvider.class)
	public void GoogleSearch(String Username) {
		test1 = extent.createTest("Google Search test" , "To check the functionality of google search");
		test1.log(Status.INFO,"strating test case");
		driver.get("https://google.com");
		test1.pass("navigated to google.com");
		
		//data type for storing web element //WebElement textBox = driver.findElement(By.name("q"));
		// to send input to selected element// textBox.sendKeys("kunal");
		//If we want to refer different methods of the web page //GoogleSearchPage.textbox_search(driver);
		//GoogleSearchPage.button_search(driver);
		GoogleSearchPage SearchPageobj = new GoogleSearchPage(driver);//This is the object of the class googlesarchpage this object ask for a argument becuase the constructor on googlesearch page as for the argument everytime a object of that page is created

		SearchPageobj.textbox_search(Username);
		test1.pass("enter text in google search bar");
		SearchPageobj.button_search();
		test1.pass("pressed enter key");
		
		/*if we want to store multiple values then we can do the following
		 * List<webelement>ListofInputElements = driver.getElements(By.xpath("//input")
		 * System.out.print(ListofInputElements.size()); This will give the size of list
		 * also xpath is the type of a locater which helps to identify the elements on the basis of their links */
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test(dataProvider="test2data" ,dataProviderClass = ExcelDataProvider.class)
	public void loginTest(String Username, String Password){
		test2 = extent.createTest("Login Test" , "To check the login functionality");
		test2.log(Status.INFO,"strating test case");
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		test2.pass("navigated to orangelogin demo");
		
		GoogleSearchPage SearchPageobj = new GoogleSearchPage(driver);
		SearchPageobj.loginUsername(Username);
		SearchPageobj.loginPassword(Password);
		SearchPageobj.button_login();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@AfterSuite
	public void tearDownTest() {
		driver.close();
		driver.quit();
		test1.pass("close the bowser");
		test1.info("test completed");
		extent.flush();
		System.out.println("Test completed successfully");

	}

}
