package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.PageFactory;

public class Homepage {

    public Homepage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".cookie-close-button.js_cookie-monster-close-accept.js_gtm_button")
    private WebElement cokiesButton;

    @FindBy(name = "search-query")
    private WebElement searchField;

    @FindBy(css = ".search-icon")
    private WebElement searchButton;

    @FindBy(css = ".my-account")
    private WebElement loginButton;

    @FindBy(css = ".dotted-link.js_preserve-hash")
    private WebElement registration;

    public void cookiesButton() {
        cokiesButton.click();
    }

    public void searchWord(String word) {
        searchField.click();
        searchField.sendKeys(word);
    }

    public void clickSearch() {
        searchButton.click();
    }

    public void ButtonLogin() {
        loginButton.click();
    }

    public void RegistrationButton() {
        registration.click();
    }
}
