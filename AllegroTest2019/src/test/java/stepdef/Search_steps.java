package stepdef;

import AllegroSearchTest.page.AllegroMainPage;
import AllegroSearchTest.page.SearchResultPage;
import cucumber.api.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Search_steps extends Base_Step {

    private List<String> categoryList = new ArrayList<>();
    private List<Integer> goodResult = new ArrayList<>();
    private List<Integer> badResult = new ArrayList<>();

    @Given("User is on main page and acceptance of the cookies policy")
    public void userIsOnMainPageAndAcceptanceOfTheCookiesPolicy() {
        AllegroMainPage allegroMainSide = new AllegroMainPage(driver);
        allegroMainSide.clickButton();
    }


    @When("the user enters the (.*) of interest")
    public void theUserEnterThePasswordOfInterest(String password) {
        new AllegroMainPage(driver).fillSearch(password);
        categoryList.add(password);
    }

    @And("click search")
    public void clickSearch() {
        new AllegroMainPage(driver).clickButtonSearch();
    }

    @And("Check result title")
    public void checkResultTitle() {
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        String keyWord = searchResultPage.getTitleSearch();
        Assert.assertEquals(categoryList.get(0), keyWord);
    }

    @And("Results should contains searched word")
    public void resultsShouldContainsSearchedWord() {
        List<WebElement> resultList = new SearchResultPage(driver).getSearchResultList();

        for (int i = 0; i < resultList.size(); i++) {
            if (resultList.get(i).getText().toLowerCase().contains(categoryList.get(0))) {
                goodResult.add(i);
            } else badResult.add(i);
        }
        System.out.println("Ogłoszeń, które posiadaja poprawne słowo kluczowe jest: " + goodResult.size());
        System.out.println("Ogłoszeń, które posiadaja złe słowo kluczowe jest: " + badResult.size());
    }
}