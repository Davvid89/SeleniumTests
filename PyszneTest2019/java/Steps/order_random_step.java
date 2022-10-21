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

public class order_random_step extends Base_Step {

    private List<String> yourChooseList = new ArrayList<>();

    @Given("User accepts the privacy policy")
    public void userAcceptsThePrivacyPolicy() {
        new Homepage(driver).CookiesButton();
    }

    @And("Complete the (.*) field")
    public void completeTheAddressField(String address) throws InterruptedException {
        new Homepage(driver).RandomCity(address);
        List<WebElement> thisAddress = new Homepage(driver).getCorrectAddress();
        Thread.sleep(1000);
        thisAddress.get(1).click();
    }

    @And("Will choose one of the order amounts")
    public void willChooseOneOfTheOrderAmounts() {
        List<WebElement> orderPrice = new Second_Page(driver).getMinimumOrder();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfAllElements(orderPrice));
        Random minimumPrice = new Random();
        int oneOfPrice = minimumPrice.nextInt(orderPrice.size());
        orderPrice.get(oneOfPrice).click();
        String minimumOrderPrice = orderPrice.get(oneOfPrice).getText();
        yourChooseList.add(minimumOrderPrice);
    }

    @Then("Check if all the result on the page have this amounts")
    public void checkIfAllTheResultOnThePageHaveThisAmounts() {
        List<WebElement> orderCostList = new Second_Page(driver).getMinimumOrderListCheck();
        String minimumOrderPrice = yourChooseList.get(0);
        if (minimumOrderPrice.equals("Nie gra roli")) {
        } else if (minimumOrderPrice.equals("15,00 zł lub mniej")) {
            for (int i = 0; i < orderCostList.size() - 1; i++) {
                String price = orderCostList.get(i).getText();
                String[] priceArray = price.split(" ");
                String[] splittedPriceArray = priceArray[1].split(",");
                String priceGr = "0." + splittedPriceArray[1];
                double priceGRDouble = Double.parseDouble(priceGr);
                double priceZlDouble = Double.parseDouble(splittedPriceArray[0]);
                double priceDouble = priceZlDouble + priceGRDouble;
                Assert.assertTrue(priceDouble <= 15.00);
            }
        } else if (minimumOrderPrice.equals("30,00 zł lub mniej")) {
            for (int i = 0; i < orderCostList.size() - 1; i++) {
                String price = orderCostList.get(i).getText();
                String[] priceArray = price.split(" ");
                String[] splittedPriceArray = priceArray[1].split(",");
                String priceGr = "0." + splittedPriceArray[1];
                double priceGRDouble = Double.parseDouble(priceGr);
                double priceZlDouble = Double.parseDouble(splittedPriceArray[0]);
                double priceDouble = priceZlDouble + priceGRDouble;
                Assert.assertTrue(priceDouble <= 30.00);
            }
        }

    }
}