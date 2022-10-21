package step_definitions;

import POP.page.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChangeUserInfoPage {

    private WebDriver driver;

    @Given("User is logged in to CodersLab shop")
    public void userIsLoggedInToCodersLabShop() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=authentication&back=my-account");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("hereYourEmail", "HereYourPassword");
    }

    @When("User goes to UserInformationPage")
    public void userGoesToUserInformationPage() {
        new LoginPage(driver).clickUserButton();
        YourAccountPage yourAccountPage = new YourAccountPage(driver);
        yourAccountPage.clickInfoButton();
    }

    @And("User signs up for our newsletter")
    public void userSignsUpForOurNewsletter() {
        new UserInfoPage(driver).clickNewsletterCheckbox();
    }

    @And("User saves information")
    public void userSavesInformation() {
        new UserInfoPage(driver).clickSaveButton();

    }

    @Then("User sees {string}")
    public void userSees(String expectedInfo) {
        String succerssInfo = new UserInfoPage(driver).getSuccerssInfo();
        Assert.assertEquals(expectedInfo, succerssInfo);

    }

    @When("User goes to UserAddressPage")
    public void userGoesToUserAddressPage() {
        new YourAccountPage(driver).clickAddressButton();
    }

    @And("User click add new address")
    public void userClickAddNewAddress() {
        new YourAddressPage(driver).clickNewAddressButton();
    }

    @And("User fills all requierd fields and submits")
    public void userFillsAllRequierdFieldsAndSubmits() {
        new NewAddressPage(driver).fillAdressInput().fillCityInput().fillPostcodeInput().clickSubmitButton();
    }
}
