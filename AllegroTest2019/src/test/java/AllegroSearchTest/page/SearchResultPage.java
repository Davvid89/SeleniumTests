package AllegroSearchTest.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchResultPage {

    public SearchResultPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindAll({@FindBy(css = "._9c44d_1V-js")})
    private List<WebElement> category;

    @FindBy(css = "._11fdd_1KRNF")
    private WebElement searchingTitle;

    public List<WebElement> getSearchResultList() {
        return category;
    }

    public String getTitleSearch() {
        return searchingTitle.getText();
    }
}
