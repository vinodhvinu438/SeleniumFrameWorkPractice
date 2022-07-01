package stepdefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageobjects.AccountSuccessPage;
import pageobjects.HomePage;
import pageobjects.RegisterPage;
import resources.Base;

public class Register extends Base {
	WebDriver driver = null;
	HomePage homePage = null;
	RegisterPage registerPage = null;
	AccountSuccessPage accountSuccessPage = null;
	@Given("^Enter url of application$")
    public void enter_url_of_application() throws IOException  {
		driver = initializeBrowser();
		driver.get(prop.getProperty("url"));
    
    }

    @Then("^Select register button$")
    public void select_register_button() {
    	registerPage = homePage.selectRegisterOption();
    }

    @Then("^Click on continue button$")
    public void click_on_continue_button() {
       accountSuccessPage = registerPage.clickOnContinueButton();
    }

    @And("^Click on account dropdown$")
    public void click_on_account_dropdown()  {
    	homePage = new HomePage(driver);
    	homePage.clickOnMyAccountDropMenu();
    }

    @And("^Enter the required fields$")
    public void enter_the_required_fields()  {
    	registerPage.enterFirstName(prop.getProperty("firstname"));
		registerPage.enterLastName(prop.getProperty("lastname"));
		registerPage.enterEmailAddress("amotooricap"+generateTimeStamp()+"@gmail.com");
		registerPage.enterTelephone(prop.getProperty("telephone"));
		registerPage.enterPassword(prop.getProperty("validpassword"));
		registerPage.enterPasswordConfirm(prop.getProperty("validpassword"));
		registerPage.selectAgreeCheckBoxField();
    }

    @And("^Enter All the fields$")
    public void enter_all_the_fields()  {
    	registerPage.enterFirstName(prop.getProperty("firstname"));
		registerPage.enterLastName(prop.getProperty("lastname"));
		registerPage.enterEmailAddress("amotooricap"+generateTimeStamp()+"@gmail.com");
		registerPage.enterTelephone(prop.getProperty("telephone"));
		registerPage.enterPassword(prop.getProperty("validpassword"));
		registerPage.enterPasswordConfirm(prop.getProperty("validpassword"));
		registerPage.selectYesOption();
		registerPage.selectAgreeCheckBoxField();
    }

    @And("^Enter the required Fields and  email field with already existing mail$")
    public void enter_the_required_fields_and_email_field_with_already_existing_mail() throws Throwable {
    	registerPage.enterFirstName(prop.getProperty("firstname"));
		registerPage.enterLastName(prop.getProperty("lastname"));
		registerPage.enterEmailAddress(prop.getProperty("validemail"));
		registerPage.enterTelephone(prop.getProperty("telephone"));
		registerPage.enterPassword(prop.getProperty("validpassword"));
		registerPage.enterPasswordConfirm(prop.getProperty("validpassword"));
		registerPage.selectAgreeCheckBoxField();
		registerPage.clickOnContinueButton();
    }
    @And("^Verify that account created or not$")
    public void verify_that_account_created_or_not(){
    	Assert.assertEquals(accountSuccessPage.getAccountCreatedMessage(),prop.getProperty("accountcreatedmessage"));
    	driver.quit();
    }
    @And("^Verify that account not created with warning message$")
    public void verify_that_account_not_created_with_warning_message() throws Throwable {
    	Assert.assertTrue(registerPage.isAccountNotWarningMessageIsDisplayed());
    	driver.quit();
    }


}
