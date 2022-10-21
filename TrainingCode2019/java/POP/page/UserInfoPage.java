package POP.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserInfoPage {

    public UserInfoPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(name = "newsletter")
    private WebElement newsletterCheckbox;

    @FindBy(css = ".btn.btn-primary.form-control-submit.float-xs-right")
    private WebElement saveButton;

    @FindBy(name = "password")
        private WebElement passwordInputField;

    @FindBy(css = ".alert.alert-success")
    private WebElement successInfo;

    public void clickNewsletterCheckbox(){
        if (!newsletterCheckbox.isSelected()) {
            newsletterCheckbox.click();
        }
    }

    public void clickSaveButton() {
    passwordInputField.sendKeys();
        saveButton.click();
    }

    public String getSuccerssInfo(){
        return successInfo.getText();
    }
}
