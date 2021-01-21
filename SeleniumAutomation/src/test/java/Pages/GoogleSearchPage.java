package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleSearchPage {

	WebDriver driver = null;
	By textbox  = By.name("q");//here we can have different locators at one place and we can use them in our program whenever needed
	By button   = By.name("q");
	By loginBox = By.name("txtUsername");
	By loginPass = By.name("txtPassword");
	By btn_login= By.name("Submit");

	public GoogleSearchPage(WebDriver driver) {
		this.driver = driver;
	}
	//here pom will allow us to take the input from the test case directly 
	public void textbox_search(String text){

		driver.findElement(textbox).sendKeys(text);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void button_search() {
		driver.findElement(button).sendKeys(Keys.RETURN);//what we are doing here is that we are pressing the enter key using sendKeys(Keys.Return)) we could have searched for the search button on the google form by using .click() function
	}
	public void loginUsername(String text) {
		driver.findElement(loginBox).sendKeys(text);
	}
	public void loginPassword(String text) {
		driver.findElement(loginPass).sendKeys(text);
	}
	public void button_login() {
		driver.findElement(btn_login).sendKeys(Keys.RETURN);
	}

}


