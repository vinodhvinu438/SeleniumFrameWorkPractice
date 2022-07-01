package stepdefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.*;
import pageobjects.OmayoHomePage;
import resources.Base;

public class OmayoLogin extends Base {
	WebDriver driver;
	OmayoHomePage homePage = null;
	@Given("^Navigate to url of omayo application$")
    public void navigate_to_url_of_omayo_application() throws IOException {
       driver = initializeBrowser();
       driver.get(prop.getProperty("OmayoURL"));
       homePage = new OmayoHomePage(driver);
    }

    @When("^Enter username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
    public void enter_username_as_something_and_password_as_something(String username, String password)  {
      homePage.enterUsername(username);
      homePage.enterPassword(password);
    }

    @Then("^Click on omayoLogin button$")
    public void click_on_omayologin_button() throws Throwable {
       homePage.clickOnLogin();
    }

    @And("^Verify User able to login based on expected \"([^\"]*)\" status$")
    public void verify_user_able_to_login_based_on_expected_something_status(String loginstatus) {
       Assert.assertEquals(homePage.isUserLoggedIn(), loginstatus);
       driver.quit();
    }

}
