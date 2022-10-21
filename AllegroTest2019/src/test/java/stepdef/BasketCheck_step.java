package stepdef;

import AllegroSearchTest.page.AllegroMainPage;
import AllegroSearchTest.page.SearchWithSets_Page;
import cucumber.api.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BasketCheck_step extends Base_Step {

    @Given("Agree to the terms of the privacy policy")
    public void agreeToTheTermsOfThePrivacyPolicy() {
        AllegroMainPage allegroMainSide = new AllegroMainPage(driver);
        allegroMainSide.clickButton();
    }

    @When("The user click, search for many")
    public void theUserClickSearchForMany() {
        new AllegroMainPage(driver).MultiSearchButton();
    }

    @And("Complete the fields with the goods you are looking for")
    public void completeTheFieldsWithTheGoodsYouAreLookingFor() {
        AllegroMainPage AMP = new AllegroMainPage(driver);
        AMP.FirstFieldsWithElement();
        AMP.FirstSearchResult();
        AMP.SecondFieldsWithElement();
        AMP.SecondSearchResult();
        AMP.NextFieldAdd();
        AMP.ThirdFieldsWithElement();
    }

    @And("Choose one of sets")
    public void getChooseOneOfSets() {
        List<WebElement> searchWithSets_page = new SearchWithSets_Page(driver).getChooseOneOfSet();
        Random randomSet = new Random();
        int randSet = randomSet.nextInt(searchWithSets_page.size());
        searchWithSets_page.get(randSet).click();
    }

    @Then("Will check the correctness of the sum of the basket")
    public void willCheckTheCorrectnessOfTheSumOfTheBasket() throws InterruptedException {
        Thread.sleep(500); // Problem with page loading;
        String firstPosition = new SearchWithSets_Page(driver).FirstPositionOnList().replace(",", ".");
        double basketFirst = Double.parseDouble(firstPosition);
        String secondPosition = new SearchWithSets_Page(driver).SecondPositionOnList().replace(",", ".").replace(" ", "");
        double basketSecond = Double.parseDouble(secondPosition);
        String thirdPosition = new SearchWithSets_Page(driver).ThirdPositionOnList().replace(",", ".");
        double basketThird = Double.parseDouble(thirdPosition);
        String[] basketSum = new SearchWithSets_Page(driver).BasketItemSum().replace("," , ".").replace(" ", "").split("zł");
        double sumBasket = Double.parseDouble(basketSum[0]);
        double sumAllItem = basketFirst + basketSecond + basketThird;
        Assert.assertNotSame("The price is not the same ", sumAllItem, sumBasket);
    }

    @And("Click button go to basket")
    public void clickButtonGoToBasket() {
        new SearchWithSets_Page(driver).ButtonBasket();
    }


    @Then("Close browser")
    public void closeBrowser() {
        driver.quit();
    }
}
