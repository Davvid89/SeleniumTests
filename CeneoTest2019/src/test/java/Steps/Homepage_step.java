package Steps;

import Page.Homepage;
import Page.SearchResult_page;
import cucumber.api.java.en.*;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Homepage_step extends Base_Step {

    private List<String> categoryList = new ArrayList<>();
    private List<Integer> goodResult = new ArrayList<>();
    private List<Integer> badResult = new ArrayList<>();

    @Given("accepts the policy of cookies")
    public void acceptsThePolicyOfCookies() {
        Homepage homepage = new Homepage(driver);
        homepage.cookiesButton();
    }

    @And("He will type the (.*) he is interested in")
    public void heWillTypeTheWordHeIsInterestedIn(String word) {
        new Homepage(driver).searchWord(word);
        categoryList.add(word);
    }

    @And("Click search button")
    public void clickSearchButton() {
        new Homepage(driver).clickSearch();
    }

    @And("Change page view to list")
    public void changePageViewToList() throws InterruptedException {
        Thread.sleep(2000);
        SearchResult_page searchResult_page = new SearchResult_page(driver);
        List<WebElement> viewLook = new SearchResult_page(driver).getCheckHowLookList();
        if (viewLook.equals("Widok boksowy")) {
            searchResult_page.ChangeView();
        } else System.out.println("The page contained a list view");
    }

    @Then("Check search result")
    public void checkSearchResult() {
        List<WebElement> resultList = new SearchResult_page(driver).getCategoryProduct();
        for (int i = 0; i < resultList.size(); i++) {
            if (resultList.get(i).getText().toLowerCase().contains(categoryList.get(0))) {
                goodResult.add(i);
            } else badResult.add(i);
        }
        System.out.println("Listings that had the keyword: " + goodResult.size());
        System.out.println("Ads that did not have a keyword: " + badResult.size());
    }
}
