package stepdef;

import AllegroSearchTest.page.AllegroMainPage;
import AllegroSearchTest.page.LoginPage;
import AllegroSearchTest.page.MyAccount_Page;
import AllegroSearchTest.page.PasswordAndLogin_Page;
import cucumber.api.java.en.*;
import org.junit.Assert;

public class ChangePassword_step extends Base_Step {

    @Given("User is on login page and accept cookie policy.")
    public void userIsOnLoginPageAndAcceptCookiePolicy() {
        driver.get("https://allegro.pl/login/form?authorization_uri=https:%2F%2Fallegro.pl%2Fauth%2Foauth%2Fauthorize%3Fclient_id%3Dtb5SFf3cRxEyspDN%26redirect_uri%3Dhttps:%2F%2Fallegro.pl%2Flogin%2Fauth%3Forigin_url%253D%25252F%26response_type%3Dcode%26state%3D63LuOe&oauth=true");
        AllegroMainPage allegroMainSide = new AllegroMainPage(driver);
        allegroMainSide.clickButton();

    }

    @When("Fills out login details and click login")
    public void fillsOutLoginDetails() {
        String emailPage = "**********";
        new LoginPage(driver).correctUserName(emailPage);
        new LoginPage(driver).correctPassword();
    }

    @And("Click login.")
    public void clickLogin() {
        new LoginPage(driver).loginButton();
    }

    @And("Goes to the password change settings")
    public void goesToThePasswordChangeSettings() throws InterruptedException {
        Thread.sleep(1000); // Problem with loading page;
        new AllegroMainPage(driver).clickDrop();
        new AllegroMainPage(driver).MyAccountButton();
        new MyAccount_Page(driver).ChangePassword();
    }

    @And("Click change password")
    public void clickChangePassword() {
        new PasswordAndLogin_Page(driver).ChangePassword();
    }

    @And("Fill in the field with the incorrect current password")
    public void fillInTheFieldWithTheIncorrectCurrentPassword() {
        new PasswordAndLogin_Page(driver).OldPassword();
    }

    @And("Fill in the field with the new password")
    public void fillInTheFieldWithTheNewPassword() {
        new PasswordAndLogin_Page(driver).NewPassword();
    }

    @And("Fill out the confirmation box for the new password")
    public void fillOutTheConfirmationBoxForTheNewPassword() {
        new PasswordAndLogin_Page(driver).ConfirmedNewPassword();
    }

    @And("Click change")
    public void clickChange() {
        new PasswordAndLogin_Page(driver).ChangeButton();
    }


    @Then("An error message appears")
    public void anErrorMessageAppears() throws InterruptedException {
        Thread.sleep(500);
        String warningTitle = new PasswordAndLogin_Page(driver).WarningTitle();
        Assert.assertEquals("Aktualne hasło jest nieprawidłowe.", warningTitle);
    }

    @And("User close browser")
    public void userCloseBrowser() {
        driver.quit();
    }


    @And("Fill the field with the current password")
    public void fillTheFieldWithTheCurrentPassword() {
        new PasswordAndLogin_Page(driver).CorrectOldPassword();
    }

    @And("Fill the field with new password")
    public void fillTheFieldWithNewPassword() {
        new PasswordAndLogin_Page(driver).CorrectNewPassword();
    }

    @And("Fill the field with confirm new password")
    public void fillTheFieldWithConfirmNewPassword() {
        new PasswordAndLogin_Page(driver).CorrectConfirmedPassword();
    }

    @Then("Validates the correct password change message")
    public void validatesTheCorrectPasswordChangeMessage() {
        String correctPasswordChange = new PasswordAndLogin_Page(driver).CorrectChangePassword();
        Assert.assertEquals("Twoje hasło zostało zmienione. Za chwilę zostaniesz wylogowany... 5", correctPasswordChange);
    }

    @And("Close the browser page")
    public void closeTheBrowserPage() {
        driver.quit();
    }
}
