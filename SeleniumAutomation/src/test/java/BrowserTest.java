import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import Pages.GoogleSearchPage;

public class BrowserTest {
	
	static WebDriver driver=null;
	
	public static void main(String[] args) {
		
		GoogleSearch();

	}
	public static void GoogleSearch() {

		String projectPath = System.getProperty("user.dir");

		System.setProperty("webdriver.chrome.driver",projectPath+"\\drivers\\chromedriver\\chromedriver.exe");// so that the webdriver can be identified by the system even if the migrate it to some other machine 
		driver = new ChromeDriver();//we have used old method here we can also use driver manager instead
		driver.get("https://google.com");
		//data type for storing web element //WebElement textBox = driver.findElement(By.name("q"));
		// to send input to selected element// textBox.sendKeys("kunal");
		//If we want to refer different methods of the web page //GoogleSearchPage.textbox_search(driver);
		//GoogleSearchPage.button_search(driver);
		GoogleSearchPage SearchPageobj = new GoogleSearchPage(driver);//This is the object of the class googlesarchpage this object ask for a argument becuase the constructor on googlesearch page as for the argument everytime a object of that page is created
		
		SearchPageobj.textbox_search("kunal");
		SearchPageobj.button_search();
		/*if we want to store multiple values then we can do the following
		 * List<webelement>ListofInputElements = driver.getElements(By.xpath("//input")
		 * System.out.print(ListofInputElements.size()); This will give the size of list
		 * also xpath is the type of a locater which helps to identify the elements on the basis of their tags */
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.close();
		System.out.println("Test completed successfully");
	}

}
