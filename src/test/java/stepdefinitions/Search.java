package stepdefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageobjects.HomePage;
import pageobjects.SearchResultsPage;
import resources.Base;

public class Search extends Base {
	WebDriver driver = null;
	HomePage homePage = null;
	SearchResultsPage searchResultsPage=null;
	@Given("^Open url of application$")
    public void open_url_of_application() throws IOException {
		driver = initializeBrowser();
		driver.get(prop.getProperty("url"));
    }
	
    @Then("^Enter product name to search$")
    public void enter_product_name_to_search() {
    	homePage = new HomePage(driver);
		homePage.enterProuductIntoSearchBoxField(prop.getProperty("validproduct"));
    }

    @And("^Click on search icon$")
    public void click_on_search_icon() {
    	searchResultsPage = homePage.clickOnSearchButton();
    }

    @And("^Verify the product displayed correctly$")
    public void verify_the_product_displayed_correctly() {
    	Assert.assertTrue(searchResultsPage.isHPProductDisplayed());
    	driver.quit();
    }
    @Then("^Enter the non existing product$")
    public void enter_the_non_existing_product() {
    	homePage = new HomePage(driver);
    	homePage.enterProuductIntoSearchBoxField(prop.getProperty("invalidproduct"));
    }

    @Then("^Verify that the product is not exist$")
    public void verify_that_the_product_is_not_exist(){
    	Assert.assertEquals(searchResultsPage.getSearchResultsMessage(),prop.getProperty("noproductinsearchresultsmessage"));
    	driver.quit();
    }
    @Then("^Do not enter any product$")
    public void do_not_enter_any_product() throws Throwable {
    	homePage = new HomePage(driver);
    	homePage.enterProuductIntoSearchBoxField("");
    
    }



}
