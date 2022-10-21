package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchResult_page {

    public SearchResult_page(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".cat-view__list")
    private WebElement listView;

    @FindAll({@FindBy( css = ".cat-prod-row__name")})
    private List<WebElement> categoryProduct;

    @FindAll({@FindBy (css = ".cat-view")})
    private List<WebElement> checkHowLookList;

    public void ChangeView() {
        listView.click();
    }

    public List<WebElement> getCategoryProduct(){
        return categoryProduct;
    }

    public List<WebElement> getCheckHowLookList(){
        return checkHowLookList;
    }
}
