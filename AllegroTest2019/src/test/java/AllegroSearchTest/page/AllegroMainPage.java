package AllegroSearchTest.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.PageFactory;


public class AllegroMainPage {

    public AllegroMainPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "._13q9y._8hkto._11eg6._7qjq4._ey68j")
    private WebElement cookiButton;

    @FindBy(css = "._d25db_3K7x6._14uqc")
    private WebElement searchInput;

    @FindBy(css = "._d25db_1t06j._13q9y._8tsq7._1q2ua")
    private WebElement searchButton;

    @FindBy(xpath = "//div[@data-dropdown-id='user_dropdown']")
    private WebElement dropDown;

    @FindBy(xpath = "//a[@data-role='register-button']")
    private WebElement createAccountButton;

    @FindBy(xpath = "//a[@title='moje konto']")
    private WebElement myAccountButton;

    @FindBy(css = "._w7z6o._ypulx._1rj80")
    private WebElement multiSearch;

    @FindBy(id = "input0")
    private WebElement firstElement;

    @FindBy(xpath = "//div[@data-role='suggestion']")
    private WebElement firstSearchResult;

    @FindBy(id = "input1")
    private WebElement secondElement;

    @FindBy(xpath = "//div[@data-role='suggestion']")
    private WebElement secondSearchResult;

    @FindBy(xpath = "//button[@data-role='add-next-input-btn']")
    private WebElement takeNextElement;

    @FindBy(id = "input2")
    private WebElement thirdElement;

    @FindBy(xpath = "//a[@href='#korzysci']")
    private WebElement benefit;

    @FindBy(xpath = "//*[contains(text(),'Smart! okazje')]")
    private WebElement smartOccasion;

    public void clickButton() {
        cookiButton.click();
    }

    public void fillSearch(String password) {
        searchInput.click();
        searchInput.sendKeys(password);
    }

    public void clickButtonSearch() {
        searchButton.click();
    }

    public void clickDrop() {
        dropDown.click();
    }

    public void accountCreate() {
        createAccountButton.click();
    }

    public void MultiSearchButton() {
        multiSearch.click();
    }

    public void MyAccountButton() {
        myAccountButton.click();
    }

    public void FirstFieldsWithElement() {
        firstElement.sendKeys("Pamieć Ram");
    }

    public void FirstSearchResult() {
        firstSearchResult.click();
    }

    public void SecondFieldsWithElement() {
        secondElement.click();
        secondElement.sendKeys("Monitory 34");
    }

    public void SecondSearchResult() {
        secondSearchResult.click();
    }

    public void NextFieldAdd() {
        takeNextElement.click();
    }

    public void ThirdFieldsWithElement() {
        thirdElement.click();
        thirdElement.sendKeys("Zasilacze do komputera");
        thirdElement.submit();
    }

    public void BenefitClick() {
        benefit.click();
    }

    public void SmartOccasion() {
        smartOccasion.click();
    }


}

