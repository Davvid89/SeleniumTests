package stepdef;

import AllegroSearchTest.page.AllegroMainPage;
import AllegroSearchTest.page.Occasion_Page;
import cucumber.api.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class SmartOpportunities_Step extends Base_Step {

    @Given("I'm on the home page")
    public void iMOnTheHomePage() {
        AllegroMainPage allegroMainSide = new AllegroMainPage(driver);
        allegroMainSide.clickButton();
    }

    @When("select the tab benefit and the smart opportunities section")
    public void selectTheTabBenefitAndTheSmartOpportunitiesSection() {
        new AllegroMainPage(driver).BenefitClick();
        new AllegroMainPage(driver).SmartOccasion();
    }

    @And("will check on weekend occasions that the items contain the word")
    public void willCheckOnWeekendOccasionsThatTheItemsContainTheWord() {
        String word = "Smart! okazja";
        List<WebElement> keyWord = new Occasion_Page(driver).SmartOccasionWord();
        for (int i = 0; i < keyWord.size(); i++) {
            Assert.assertTrue(keyWord.get(i).getText().toLowerCase().contains(word.toLowerCase()));
        }
    }

    @Then("check that the main price is lower than the crossed out price")
    public void checkThatTheMainPriceIsLowerThanTheCrossedOutPrice() {
        List<WebElement> weekendCrossedPrice = new Occasion_Page(driver).CrossedPrice();
        List<WebElement> weekendPrice = new Occasion_Page(driver).WeekendPrice();
        for (int i = 0; i < weekendCrossedPrice.size(); i++) {
            String[] getWeekendPrice = weekendPrice.get(i).getText().replace(",", ".").split(" ");
            double priceWeekend = Double.parseDouble(getWeekendPrice[0]);
            String[] crossedPrice = weekendCrossedPrice.get(i).getText().replace(",", ".").split(" ");
            double crossPrice = Double.parseDouble(crossedPrice[0]);
            Assert.assertTrue(priceWeekend <= crossPrice);
        }
    }

    @And("close browser")
    public void closeBrowser() {
        driver.quit();
    }

    @And("checks prices in the bestseller category with free delivery")
    public void checksPricesInTheBestsellerCategoryWithFreeDelivery() {
        List<WebElement> crossedPriceDeliverList = new Occasion_Page(driver).DeliverCategoryCrossedPrice();
        List<WebElement> freeDeliverList = new Occasion_Page(driver).FreeDeliverCategoryPrice();
        for (int i = 0; i < crossedPriceDeliverList.size(); i++) {
            String[] crossedPrice = crossedPriceDeliverList.get(i).getText().replace(",", ".").split(" ");
            double crossPrice = Double.parseDouble(crossedPrice[0]);
            String[] discountRate = freeDeliverList.get(i).getText().replace(",", ".").split(" ");
            double discRate = Double.parseDouble(discountRate[0]);
            Assert.assertTrue(discRate <= crossPrice);
        }


    }

    @And("will choose one of category in most popular opportunities")
    public void willChooseOneOfCategoryInMostPopularOpportunities() {
        List<WebElement> opportunitiesCategory = new Occasion_Page(driver).CategoryMostPopular();
        Random oneOfCategoryList = new Random();
        int chooseOneCategory = oneOfCategoryList.nextInt(opportunitiesCategory.size());
        opportunitiesCategory.get(chooseOneCategory).click();
    }

    @And("check that the prices are below the crossed out prices in the category concerned")
    public void checkThatThePricesAreBelowTheCrossedOutPricesInTheCategoryConcerned() {
        List<WebElement> listMostPopularItemsCrossed = new Occasion_Page(driver).ListMostPopularItemsCrossed();
        List<WebElement> listMostPopularItem = new Occasion_Page(driver).ListMostPopularItem();
        for (int i = 0; i < listMostPopularItemsCrossed.size(); i++) {
            String[] crossedPrice = listMostPopularItemsCrossed.get(i).getText().replace(",", ".").split(" ");
            double crossPrice = Double.parseDouble(crossedPrice[0]);
            String[] occasionPrice = listMostPopularItem.get(i).getText().replace(",", ".").split(" ");
            double priceOccasion = Double.parseDouble(occasionPrice[0]);
            Assert.assertTrue(priceOccasion <= crossPrice);

        }
    }

    @And("check price in the tab: Take advantage of super offers and free delivery")
    public void checkPriceInTheTabTakeAdvantageOfSuperOffersAndFreeDelivery() {
        List<WebElement> superOfferCrossedPrice = new Occasion_Page(driver).SuperOffersCrossedPrice();
        List<WebElement> superOfferPrice = new Occasion_Page(driver).SuperOffersPrice();
        for (int i = 0; i < superOfferCrossedPrice.size(); i++) {
            String[] crossedPrice = superOfferCrossedPrice.get(i).getText().replace(",",".").split(" ");
            double crossPrice = Double.parseDouble(crossedPrice[0]);
            String[] superPrice = superOfferPrice.get(i).getText().replace(",", ".").split(" ");
            double priceSuper = Double.parseDouble(superPrice[0]);
            Assert.assertTrue(priceSuper <= crossPrice);
        }

    }

    @Then("check price in section: Check out all the unique Smart! opportunities")
    public void checkPriceInSectionCheckOutAllTheUniqueSmartOpportunities() {
        List<WebElement> uniqueCrossedPrice = new Occasion_Page(driver).AllOccasionCrossedPrice();
        List<WebElement> uniquePrice = new Occasion_Page(driver).AllOccasionPrice();
        for (int i = 0; i < uniqueCrossedPrice.size(); i++) {
            String[] crossedPrice = uniqueCrossedPrice.get(i).getText().replace(",",".").split(" zł");
            double crossPrice = Double.parseDouble(crossedPrice[0]);
            String[] priceUniqueOpportunities = uniquePrice.get(i).getText().replace(",",".").split(" zł");
            double priceUnique = Double.parseDouble(priceUniqueOpportunities[0]);
            Assert.assertTrue(priceUnique <= crossPrice);
        }
    }
}
