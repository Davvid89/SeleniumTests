package POP.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourAccountPage {

    public YourAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "identity-link")
    private WebElement informationButton;

    @FindBy(id = "addresses-link")
    private WebElement addressButton;

    public void clickInfoButton() {
        informationButton.click();
    }

    public void clickAddressButton(){
        addressButton.click();
    }
}
