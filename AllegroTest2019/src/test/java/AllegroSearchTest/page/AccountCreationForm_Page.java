package AllegroSearchTest.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreationForm_Page {

    public AccountCreationForm_Page(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "day")
    private WebElement dayBirth;

    @FindBy(xpath = "//select[@name='month']")
    private WebElement monthBirth;

    @FindBy(id = "year")
    private WebElement yearBirth;

    @FindBy(css = ".m-label.ng-scope")
    private WebElement regulation;

    @FindBy(css = "ng-include label.m-label.ng-binding.ng-scope")
    private WebElement personalData;

    @FindBy(xpath = "//ng-include[@class='ng-scope'] //label[@for='thirdPartyMarketing']")
    private WebElement marketing;

    @FindBy(xpath = "//button[@class='m-button m-button--primary m-width-fluid m-width-auto@sm m-right-float ng-binding']")
    private WebElement createAnAccountButton;

    @FindBy(css = ".m-display-block")
    private WebElement confirmationAccount;


    public void EmailField(String emailWord) {
        email.click();
        email.sendKeys(emailWord);
    }

    public void PasswordField(String pass) {
        password.click();
        password.sendKeys(pass);
    }

    public void BirthDay(String day) {
        dayBirth.click();
        dayBirth.sendKeys(day);
    }

    public void BirthMonth(String month) {
        monthBirth.click();
        monthBirth.sendKeys(month);
    }

    public void BirthYear(String year) {
        yearBirth.click();
        yearBirth.sendKeys(year);
    }

    public void RegulationConfirm() {
        regulation.click();
    }

    public void DataPersonal() {
        personalData.click();
    }

    public void MarketingGoals() {
        marketing.click();
    }

    public void CreateButton() {
        createAnAccountButton.click();
    }

    public String AccountConfirm(){
        String text = confirmationAccount.getText();
        return text;
    }
}
