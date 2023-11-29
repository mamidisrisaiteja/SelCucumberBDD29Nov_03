package stepDefinition;


import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
public class StepDefinition {
	
WebDriver driver;
	
	
	
	
	@Given("^user is already on Login Page$")
	public void user_is_already_on_Login_Page() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\mamid\\\\OneDrive\\\\Desktop\\\\sw\\\\SaiTeja19Nov23\\\\chrome-win32 (1)\\\\chromedriver-win64\\\\chromedriver.exe");
		driver=new ChromeDriver();  //driver will interact to the chromedriver
		driver.get("https://ui.cogmento.com/"); //
	    
	}
	
	@When("^user enters the username \\\"([^\\\"]*)\\\" and password \\\"([^\\\"]*)\\\"$")
	public void user_enters_and(String username, String password) throws Throwable {
	   driver.findElement(By.name("email")).sendKeys(username);
	   driver.findElement(By.name("password")).sendKeys(password);
	   
	  Thread.sleep(5000);
	   
	}

	
	
	
	@Then("^user should click on  Login Page$")
	public void user_should_click_on_Login_Page() throws Throwable {
		//xpath            //tagname[@attribute=;value']
		
		WebElement loginBtn =
		 driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[3]"));
			 JavascriptExecutor js = (JavascriptExecutor)driver;
			 js.executeScript("arguments[0].click();", loginBtn);
			 
			 
//driver.findElement(By.xpath("/body[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[3]")).click();
	
			 //here javascript executor is used for click this click is not working using webdriver interface
	                       
	   
	}
	//invalid credentials

@Then("^user should remain in LoginPage$")
public void user_should_remain_in_LoginPage() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	String title=driver.getTitle();
	System.out.println(title);
    Assert.assertEquals("CogmentoCRM", title);              //expected,actual
}

@Then("^user should close the browser$")
public void user_should_close_the_browser()  {
   driver.close();
    
}
@Given("^user is already on homepage$")
public void user_is_already_on_homepage()  {
   String title=driver.getTitle();
   System.out.println(title);
   Assert.assertEquals("Cogmento CRM", title);
    
}

@When("^user clicked on contacts link$")
public void user_clicked_on_contacts_link() throws InterruptedException {

//according to the code only browser will be loaded but here the issue is browser is slow so thats why we kept wait 
//not to go for next command
//here the issue is when iam clicking on login immediately in the console the code is saying i am not able to findout home page 
//irrespective of homepage which means the browser is slow and the code is fast so that we are pausing our code until the homepage gets loaded
//saying that please wait code that is called explicit wait	

WebDriverWait wait=new WebDriverWait(driver, 20);
WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='home icon']")));
//here the explicit is used to find out this element with the specified time that is the condition here	

Actions actions=new Actions(driver);       //for mousehover on contacts
actions.moveToElement(element).build().perform();
//	//implement impicit wait here
driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS) ;
//Once we set the time,web driver will wait for the element for that time before throwing an exception.
driver.findElement(By.xpath("//a[@href='/contacts']")).click();
             //how to write xpath using contains
//driver.findElement(By.xpath("//a[contains(text(),'New Contact')]")).click();
    
}

@Then("^user clicked on Create button$")
public void user_clicked_on_Create_button()  {
	driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/a[1]/button[1]"))
	.click();
   
   
}

//\"([^\"]*,\"([^\"]*)\"$" Regular expressions

@Then("^user enters the firstname \"([^\"]*)\"and the lastname \"([^\"]*)\"$")
public void user_enters_the_firstname_and_the_lastname(String firstname, String lastname)  {
	driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys(firstname);
	 driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys(lastname);
   
}
@Then("^user clicks on save button$")
public void user_clicks_on_save_button() {
  
    driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/button[2]/i[1]"))
    .click();
}

@Then("^verify new contact created$")
public void verify_new_contact_created() {
   driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/span[1]")); 
   driver.quit();
    
}



	

}
