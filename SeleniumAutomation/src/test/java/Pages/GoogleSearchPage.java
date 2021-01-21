package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleSearchPage {

	WebDriver driver = null;
	By textbox  = By.name("q");//here we can have different locators at one place and we can use them in our program whenever needed
	By button   = By.name("q");//to get the search button from the google page 
	By loginBox = By.name("txtUsername");// to get the Username box from the login website
	By loginPass = By.name("txtPassword");//to get Password box from login website
	By btn_login= By.name("Submit");// to press login button

	public GoogleSearchPage(WebDriver driver) {
		this.driver = driver;
	}
	//here pom will allow us to take the input from the test case directly 
	public void textbox_search(String text){// to send text to google search box 

		driver.findElement(textbox).sendKeys(text);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void button_search() {//to press enter at google page
		driver.findElement(button).sendKeys(Keys.RETURN);
	}
	public void loginUsername(String text) {// to get the username textbox on login website
		driver.findElement(loginBox).sendKeys(text);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void loginPassword(String text) {//to get password on login website 
		driver.findElement(loginPass).sendKeys(text);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void button_login() {//to press the login button on login website 
		driver.findElement(btn_login).sendKeys(Keys.RETURN);
	}

}


