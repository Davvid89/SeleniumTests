package AllegroSearchTest.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "username")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(id = "wrong-password-error-title")
    private WebElement wrongTitle;

    @FindBy(xpath = "//span[@data-role='header-username']")
    private WebElement loginUserName;


    public void incorrectUserName() {
        username.click();
        username.sendKeys("non-existentlogin@gmail.com");
    }

    public void correctUserName(String emailPage){
        username.click();
        username.sendKeys(emailPage);
    }

    public void incorrectPassword() {
        password.click();
        password.sendKeys("Nonexistent password");
    }

    public void correctPassword() {
        password.click();
        password.sendKeys("*************");
    }

    public void loginButton() {
        loginButton.click();
    }

    public WebElement getWrongTitle() {
       wrongTitle.getText();
       return wrongTitle;
    }

    public String getLoginUserName() {
        return loginUserName.getText();
    }
}
