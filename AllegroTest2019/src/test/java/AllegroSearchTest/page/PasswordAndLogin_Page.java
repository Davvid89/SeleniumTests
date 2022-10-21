package AllegroSearchTest.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.PageFactory;

public class PasswordAndLogin_Page {

    public PasswordAndLogin_Page(WebDriver driver){ PageFactory.initElements(driver, this); }

    @FindBy(xpath = "//a[@data-testid='changePasswordLink']")
    private WebElement changePassword;

    @FindBy(id = "oldPassword")
    private WebElement oldPassword;

    @FindBy(id = "newPassword")
    private WebElement newPassword;

    @FindBy(id = "confirmedNewPassword")
    private WebElement confirmedPassword;

    @FindBy(xpath = "//button[@data-testid='modalButtonConfirm']")
    private WebElement changeButton;

    @FindBy(xpath = "//div[@class='_6x7yn _1nwmc']")
    private WebElement warningTitle;

    @FindBy(xpath = "//*[@data-testid='message-paragraph']")
    private WebElement correctChangePassword;

    public void ChangePassword() {
        changePassword.click();
    }

    public void OldPassword() {
        oldPassword.click();
        oldPassword.sendKeys("IncorrectPassword1");
    }

    public void NewPassword() {
        newPassword.click();
        newPassword.sendKeys("MyNewPassword123");
    }

    public void ConfirmedNewPassword() {
        confirmedPassword.click();
        confirmedPassword.sendKeys("MyNewPassword123");
    }

    public void ChangeButton() {
        changeButton.click();
    }

    public String WarningTitle() {
        return warningTitle.getText();
    }

    public void CorrectOldPassword() {
        oldPassword.click();
        oldPassword.sendKeys("****************");
    }

    public void CorrectNewPassword() {
        newPassword.click();
        newPassword.sendKeys("*************");
    }

    public void CorrectConfirmedPassword() {
        confirmedPassword.click();
        confirmedPassword.sendKeys("******************");
    }

    public String CorrectChangePassword() {
        return correctChangePassword.getText();
    }
}

