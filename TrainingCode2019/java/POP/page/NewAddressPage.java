package POP.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class NewAddressPage {

    public NewAddressPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "address1")
    private WebElement addressInput;

    @FindBy(name = "city")
    private WebElement cityInput;

    @FindBy(name = "postcode")
    private WebElement postcodeInput;

    @FindBy(name = "id_country")
    private WebElement countryInput;

    @FindBy(css = ".btn.btn-primary.float-xs-right")
    private WebElement submitButton;

    public NewAddressPage fillAdressInput() {
        addressInput.sendKeys("Mocherów Wyzwolonych");
    return this;
    }

    public NewAddressPage fillCityInput() {
        cityInput.sendKeys("Częstochowa");
        return this;
    }

    public NewAddressPage fillPostcodeInput() {
        postcodeInput.sendKeys("54-200");
        return this;
    }

    public void clickSubmitButton() {
        submitButton.click();
    }
}
