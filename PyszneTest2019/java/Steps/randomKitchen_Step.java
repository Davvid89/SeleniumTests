package Steps;

import Page.Homepage;
import Page.Second_Page;
import cucumber.api.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class randomKitchen_Step extends Base_Step {

    private List<String> yourChooseList = new ArrayList<>();


    @Given("The user accepts the privacy policy")
    public void theUserAcceptsThePrivacyPolicy() {
        new Homepage(driver).CookiesButton();
    }

    @And("Selects the given (.*)")
    public void selectsTheGivenAddress(String address) throws InterruptedException {
        new Homepage(driver).RandomCity(address);
        List<WebElement> thisAddress = new Homepage(driver).getCorrectAddress();
        Thread.sleep(2000); // problem with loading page
        thisAddress.get(1).click();
        yourChooseList.add(address);
    }


    @Then("It will check if the given city matches the title on the search page")
    public void itWillCheckIfTheGivenCityMatchesTheTitleOnTheSearchPage() throws InterruptedException {
        Thread.sleep(2000); // problem with loading page
        Second_Page second_page = new Second_Page(driver);
        if (second_page.TitleSearch().equals(yourChooseList.get(0))) {
            System.out.println("Tytuł zgadza się z wynikiem wyszukiwania");
        } else System.out.println("Wynik wyszukiania jest inny niz tytuł");
    }


    @And("Click show more at the end of the kitchen line")
    public void clickShowMoreAtTheEndOfTheKitchenLine() {
        new Second_Page(driver).ShowMoreButton();
    }

    @When("Choose one of random kitchen")
    public void chooseOneOfRandomKitchen() {
        List<WebElement> kitchenList = new Second_Page(driver).getKitchenList();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfAllElements(kitchenList));

        Random oneOfKitchen = new Random();
        int chooseKitchen = oneOfKitchen.nextInt(kitchenList.size());
        kitchenList.get(chooseKitchen).click();
        String saveOneOfKitchenName = kitchenList.get(chooseKitchen).getText();
        yourChooseList.add(saveOneOfKitchenName);
    }

    @Then("Check if all the results on the page have this kitchen")
    public void checkIfAllTheResultsOnThePageHaveThisKitchen() {
        List<WebElement> kitchenName = new Second_Page(driver).getKitchenListCheck();
        String oneOfKitchen = yourChooseList.get(1);
        for (int i = 0; i < kitchenName.size() - 1; i++) {
            if (kitchenName.get(i).isDisplayed()) {
                Assert.assertTrue(kitchenName.get(i).getText().contains(oneOfKitchen));
            }
        }
    }
}
