package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Second_Page {

    public Second_Page(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".topbar__title-container")
    private WebElement titleBar;

    @FindBy(xpath = "//span[contains(text(),'Pokaż więcej')]")
    private WebElement showMoreButton;

    @FindAll({@FindBy(css = ".tv-chip__inner-content")})
    private List<WebElement> kitchenList;

    @FindAll({@FindBy(css = ".filter-label.subcatlink.swiper-slide.kitchen-types__category")})
    private List<WebElement> randomRestaurant;

    @FindBy(css = ".btn-text-active.btn-sorting-text.select-sort")
    private WebElement sortButton;

    @FindAll({@FindBy(css = ".js-sorting-item")})
    private List<WebElement> rndSort;

    @FindBy(xpath = "//a[@data-type='MinimumOrderCosts']")
    private List<WebElement> minimumOrder;

    @FindAll({@FindBy(css = "a[data-type='DeliveryCosts']")})
    private List<WebElement> deliverPrice;

    @FindAll({@FindBy (css = "div[class='js-restaurant-list-open'] div[class='kitchens']")})
    private List<WebElement> kitchenListCheck;

    @FindBy (xpath ="//div[@class='detailswrapper'] //div[@class='delivery js-delivery-container']")
    private WebElement minimumOrderListCheck;

    @FindAll({@FindBy (xpath = "//div[@class='js-restaurant restaurant restaurant__open'] //div[@class='delivery-cost js-delivery-cost']")})
    private List<WebElement> deliveryListCheck;

    @FindAll({@FindBy(xpath = "//a[@data-type='MinimumOrderCosts']")})
    private List<WebElement> sampleOrder;

    public List<WebElement> getSampleOrder() { return sampleOrder; }

    public String TitleSearch() { return titleBar.getText(); }

    public void ShowMoreButton() { showMoreButton.click(); }

    public List<WebElement> getKitchenList() { return kitchenList; }

    public List<WebElement> getRandomRestaurant(){ return randomRestaurant; }

    public void buttonSort(){ sortButton.click(); }

    public List<WebElement> getRndSort(){ return rndSort; }

    public List<WebElement> getMinimumOrder(){ return minimumOrder; }

    public List<WebElement> getDeliverPrice(){ return deliverPrice; }

    public List<WebElement> getKitchenListCheck(){ return kitchenListCheck; }

    public String getMinimumOrderListCheck(){ return minimumOrderListCheck.getText(); }

    public List<WebElement> getDeliveryListCheck(){ return deliveryListCheck; }


}

