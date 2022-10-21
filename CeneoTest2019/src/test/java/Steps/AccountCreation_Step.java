package Steps;

import Page.Homepage;
import Page.Registration_page;
import cucumber.api.java.en.*;

public class AccountCreation_Step extends Base_Step {

    @Given("accepting the privacy policy")
    public void acceptingThePrivacyPolicy() {
        Homepage homepage = new Homepage(driver);
        homepage.cookiesButton();
    }

    @And("Go to registration form")
    public void goToRegistrationForm() {
        new Homepage(driver).ButtonLogin();
        new Homepage(driver).RegistrationButton();
    }


    @And("Will provide his (.*)")
    public void willProvideHisEmail(String email) {
        new Registration_page(driver).EmailField(email);
    }

    @And("Provide your (.*)")
    public void provideYourUsername(String username) {
        new Registration_page(driver).NicknameField(username);
    }

    @And("He will give his (.*)")
    public void heWillGiveHisPassword(String password) {
        new Registration_page(driver).PasswordField(password);
    }

    @And("Acceptance of the website's regulations")
    public void acceptanceOfTheWebsiteSRegulations() {
        String winHandleBefore = driver.getWindowHandle();
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
            new Registration_page(driver).WebsiteRegulations();
            driver.switchTo().window(winHandleBefore);
    }

    @And("Clicks the create account button")
    public void clicksTheCreateAccountButton() {
        new Registration_page(driver).CreateAccountButton();
    }
}