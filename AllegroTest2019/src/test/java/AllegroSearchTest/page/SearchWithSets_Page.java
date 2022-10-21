package AllegroSearchTest.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchWithSets_Page {

    public SearchWithSets_Page(WebDriver driver) { PageFactory.initElements(driver, this); }

    @FindBy(xpath = "//button[@class='_7qjq4 b1l04 bp58a']")
    private List<WebElement> oneOfSets;

    @FindBy(xpath = "//div[@class='modal-precart-title-row']/b")
    private List<WebElement> checkBasketPrice;

    @FindBy(xpath = "//div[@class='modal-precart-title-row'][1]//following::b")
    private WebElement firstPosition;

    @FindBy(xpath = "//div[@class='modal-precart-title-row'][2]//following::b")
    private WebElement secondPosition;


    @FindBy(xpath = "//div[@class='modal-precart-title-row'][3]//following::b")
    private WebElement thirdPosition;

    @FindBy(xpath = "//span[@class='modal-precart-standard-price']")
    private WebElement basketSum;

    @FindBy(id = "add-to-cart-si-precart")
    private WebElement buttonBasket;

    public List<WebElement> getChooseOneOfSet() {
        return oneOfSets;
    }

    public String FirstPositionOnList() {
        return firstPosition.getText();
    }

    public String SecondPositionOnList() {
        return secondPosition.getText();
    }

    public String ThirdPositionOnList() {
        return thirdPosition.getText();
    }

    public String BasketItemSum() {
        return basketSum.getText();
    }

    public void ButtonBasket() {
        buttonBasket.click();
    }
}
