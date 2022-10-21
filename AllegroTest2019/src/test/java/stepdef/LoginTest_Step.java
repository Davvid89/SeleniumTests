package stepdef;

import AllegroSearchTest.page.AllegroMainPage;
import AllegroSearchTest.page.LoginPage;
import cucumber.api.java.en.*;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class LoginTest_Step extends Base_Step {

    private List<String> email = new ArrayList<>();
    private String emailPage = "*****";

    @Given("User is on login page.")
    public void userIsOnLoginPage() {
        driver.get("https://allegro.pl/login/form?authorization_uri=https:%2F%2Fallegro.pl%2Fauth%2Foauth%2Fauthorize%3Fclient_id%3Dtb5SFf3cRxEyspDN%26redirect_uri%3Dhttps:%2F%2Fallegro.pl%2Flogin%2Fauth%3Forigin_url%253D%25252F%26response_type%3Dcode%26state%3D63LuOe&oauth=true");

    }

    @When("Accept cookie policy.")
    public void acceptCookiePolicy() {
        AllegroMainPage allegroMainSide = new AllegroMainPage(driver);
        allegroMainSide.clickButton();
    }

    @And("Will enter the wrong login")
    public void willEnterTheWrongLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.incorrectUserName();
    }

    @And("Will enter the wrong password")
    public void willEnterTheWrongPassword() {
        new LoginPage(driver).incorrectPassword();
    }

    @And("Click login button")
    public void clickLoginButton() {
        new LoginPage(driver).loginButton();
    }

    @Then("You get a message that the password or login is incorrect")
    public void youGetAMessageThatThePasswordOrLoginIsIncorrect() {
        LoginPage loginPage = new LoginPage(driver);
        System.out.println(loginPage.getWrongTitle());
    }

    @And("Close the browser")
    public void closeTheBrowser() {
        driver.quit();
    }

    @And("Will enter the login")
    public void willEnterTheLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.correctUserName(emailPage);
        email.add(emailPage);
    }

    @And("Will enter the password")
    public void willEnterThePassword() {
        new LoginPage(driver).correctPassword();
    }

    @And("Click login")
    public void clickLogin() {
        new LoginPage(driver).loginButton();
    }

    @Then("Compare the login with the login of the logged in user")
    public void compareTheLoginWithTheLoginOfTheLoggedInUser() throws InterruptedException {
        Thread.sleep(2000); // Problem with page loading
        LoginPage loginPage = new LoginPage(driver);
        String nameUser = loginPage.getLoginUserName();
        Assert.assertEquals(nameUser, email.get(0));
    }
}
