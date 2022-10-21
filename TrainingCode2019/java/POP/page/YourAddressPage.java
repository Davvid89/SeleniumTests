package POP.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourAddressPage {

    public YourAddressPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@data-link-action='add-address']")
    private WebElement addNewAddressButton;

    public void clickNewAddressButton(){
         addNewAddressButton.click();
    }
}
