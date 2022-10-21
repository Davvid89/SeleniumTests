package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.PageFactory;

public class Registration_page {

    public Registration_page(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "Email")
    private WebElement userEmail;

    @FindBy(id = "Nickname")
    private WebElement userNickname;

    @FindBy(id = "Password")
    private WebElement pass;

    @FindBy(xpath = "//label[@for='PersonalDataProcessingConsent']")
    private WebElement regulations;

    @FindBy(css = "btn.btn-info.btn-m.uppercase")
    private WebElement acceptButton;

    public void EmailField(String email){
        userEmail.sendKeys(email);
    }

    public void NicknameField(String username){
        userNickname.sendKeys(username);
    }

    public void PasswordField(String password){
        pass.sendKeys(password);
    }

    public void WebsiteRegulations(){
        regulations.click();
    }

    public void CreateAccountButton(){
        acceptButton.click();
    }
}