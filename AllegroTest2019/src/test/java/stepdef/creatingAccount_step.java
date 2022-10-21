package stepdef;

import AllegroSearchTest.page.AccountCreationForm_Page;
import AllegroSearchTest.page.AllegroMainPage;
import cucumber.api.java.en.*;

public class creatingAccount_step extends Base_Step {

    @Given("Acceptance of the privacy policy")
    public void acceptanceOfThePrivacyPolicy() {
        AllegroMainPage allegroMainSide = new AllegroMainPage(driver);
        allegroMainSide.clickButton();
    }

    @When("the user goes to the registration form")
    public void theUserGoesToTheRegistrationForm() {
        AllegroMainPage allegroMainPage = new AllegroMainPage(driver);
        allegroMainPage.clickDrop();
        allegroMainPage.accountCreate();
    }

    @And("the user provides his (.*)")
    public void theUserProvidesHisEmail(String emailWord) throws InterruptedException {
        Thread.sleep(1500);
        new AccountCreationForm_Page(driver).EmailField(emailWord);
    }

    @And("User provides his (.*)")
    public void userProvidesHisPass(String pass) {
        new AccountCreationForm_Page(driver).PasswordField(pass);
    }

    @And("User give (.*), (.*) and (.*) of birth")
    public void userGiveDayMonthAndYearOfBirth(String day, String month, String year) {
        new AccountCreationForm_Page(driver).BirthDay(day);
        new AccountCreationForm_Page(driver).BirthMonth(month);
        new AccountCreationForm_Page(driver).BirthYear(year);
    }

    @And("The user accepts the permission")
    public void theUserAcceptsThePermission() {
        new AccountCreationForm_Page(driver).RegulationConfirm();
        new AccountCreationForm_Page(driver).DataPersonal();
        new AccountCreationForm_Page(driver).MarketingGoals();
    }

    @And("Click create an account button")
    public void clickCreateAnAccountButton() {
        new AccountCreationForm_Page(driver).CreateButton();
    }

    @And("the user gets confirmation of the account creation")
    public void theUserGetsConfirmationOfTheAccountCreation() {
        AccountCreationForm_Page accountCreationForm_page = new AccountCreationForm_Page(driver);
        String verification = accountCreationForm_page.AccountConfirm();
        System.out.println(verification);
    }
}
