package AllegroSearchTest.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Occasion_Page {

    public Occasion_Page(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@data-prototype-id='allegro.carousel'] //span[@class='_bsvj8 _8ozz4 _1jusk _07bcb_1daUG']")
    private List<WebElement> smartOccasionWord;

    @FindBy(xpath = "//div[@data-prototype-id='allegro.carousel'] //span[@class='_swyoj _07bcb_1sAFC']")
    private List<WebElement> crossedPrice;

    @FindBy(xpath = "//div[@class='_1yyhi _07bcb_1p4TL'] //li[@class='_4lbi0']")
    private List<WebElement> weekendPrice;

    @FindBy(xpath = "//div[@data-box-id='xg8uiV2ZR8uYyrRqMbom2A=='] //span[@class='_swyoj _07bcb_1sAFC']")
    private List<WebElement> deliverCategoryCrossedPrice;

    @FindBy(xpath = "//div[@data-box-id='xg8uiV2ZR8uYyrRqMbom2A=='] //span[@class='_1svub _lf05o']")
    private List<WebElement> freeDeliverCategoryPrice;

    @FindBy(xpath = "//div[@class='_1w8vu'] //span[@class='_e6lot _1vx3o msa3_z4 _4b3d3_1VL_5']")
    private List<WebElement> categoryMostPopular;

    @FindBy(xpath = "//div[@class='mg9e_16 mvrt_0 mh36_0 mj7a_0 _9plbd _4b3d3_3La74 _4b3d3_33iQD _152v3'] //span[@class='_swyoj _07bcb_SkkFm']")
    private List<WebElement> listMostPopularItemCrossed;

    @FindBy(xpath = "//div[@class='mg9e_16 mvrt_0 mh36_0 mj7a_0 _9plbd _4b3d3_3La74 _4b3d3_33iQD _152v3'] //span[@class='_1svub _lf05o']")
    private List<WebElement> listMostPopularItem;

    @FindBy(xpath = "//div[@data-box-id='ExRxoWLuQ6GAlpBave73xA=='] //span[@class='_swyoj _07bcb_SkkFm']")
    private List<WebElement> superOffersCrossedPrice;

    @FindBy(xpath = "//div[@data-box-id='ExRxoWLuQ6GAlpBave73xA=='] //span[@class='_1svub _lf05o']")
    private List<WebElement> superOffersPrice;

    @FindBy(xpath = "//div[@data-box-name='Oferty_1'] //span[@class='_swyoj _07bcb_SkkFm']")
    private List<WebElement> allOccasionCrossedPrice;

    @FindBy(xpath = "//div[@data-box-name='Oferty_1'] //span[@class='_1svub _lf05o']")
    private List<WebElement> allOccasionPrice;

    public List<WebElement> SmartOccasionWord() {
        return smartOccasionWord;
    }

    public List<WebElement> CrossedPrice() {
        return crossedPrice;
    }

    public List<WebElement> WeekendPrice() {
        return weekendPrice;
    }

    public List<WebElement> DeliverCategoryCrossedPrice() {
        return deliverCategoryCrossedPrice;
    }

    public List<WebElement> FreeDeliverCategoryPrice() {
        return freeDeliverCategoryPrice;
    }

    public List<WebElement> CategoryMostPopular() {
        return categoryMostPopular;
    }

    public List<WebElement> ListMostPopularItemsCrossed(){
        return listMostPopularItemCrossed;
    }

    public List<WebElement> ListMostPopularItem() {
        return listMostPopularItem;
    }

    public List<WebElement> SuperOffersCrossedPrice() {
        return superOffersCrossedPrice;
    }

    public List<WebElement> SuperOffersPrice() {
        return superOffersPrice;
    }

    public List<WebElement> AllOccasionCrossedPrice() {
         return allOccasionCrossedPrice;
    }

    public List<WebElement> AllOccasionPrice() {
        return allOccasionPrice;
    }
}
