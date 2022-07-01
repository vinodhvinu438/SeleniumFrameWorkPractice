package pageobjects;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OmayoHomePage {
	WebDriver driver;
     public OmayoHomePage(WebDriver driver)
     {
    	 this.driver = driver;
    	 PageFactory.initElements(driver, this);
     }
     @FindBy(xpath="//input[@name=\"userid\"]")
     private WebElement usernameField;
     public void enterUsername(String username) 
     {
    	 usernameField.sendKeys(username);
    }
     @FindBy(xpath="//input[@name=\"pswrd\"]")
     private WebElement passwordField;
     public void enterPassword(String password) 
     {
    	 passwordField.sendKeys(password);
    }
     @FindBy(xpath="//input[@value=\"Login\"]")
     private WebElement buttonField;
     public void clickOnLogin()
     {
    	 buttonField.click();
     }
     public String isUserLoggedIn()
     {
    	 try
    	 {
    	 driver.switchTo().alert();
    	 }
    	 catch(NoAlertPresentException e)
    	 {
    		 return "success";
    	 }
    	 return "failure";
    	 
     }
     
}
