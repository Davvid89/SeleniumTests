package Steps;

import Page.Homepage;
import Page.Second_Page;
import cucumber.api.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class randomOrder_step extends Base_Step {

    private List<String> yourChooseList = new ArrayList<>();

    @Given("accepts the policy of cookies")
    public void acceptsThePolicyOfCookies() {
        new Homepage(driver).CookiesButton();

    }

    @When("Choose an (.*)")
    public void chooseAnAddress(String address) throws InterruptedException {
        new Homepage(driver).RandomCity(address);
        List<WebElement> thisAddress = new Homepage(driver).getCorrectAddress();
        Thread.sleep(2000);
        thisAddress.get(1).click();
    }

    @And("the user selects a random kitchen")
    public void theUserSelectsARandomKitchen() {
        List<WebElement> oneOfRestaurant = new Second_Page(driver).getRandomRestaurant();
        Random oneRestaurant = new Random();
        int properRestaurant = oneRestaurant.nextInt(oneOfRestaurant.size());
        oneOfRestaurant.get(properRestaurant).click();
        String oneOfKitchen = oneOfRestaurant.get(properRestaurant).getText();
        yourChooseList.add(oneOfKitchen);

    }

    @And("Sort the result")
    public void sortTheResult() throws InterruptedException {
        new Second_Page(driver).buttonSort();
        Thread.sleep(1000);
        List<WebElement> sort = new Second_Page(driver).getRndSort();
        Random chooseSort = new Random();
        int resSort = chooseSort.nextInt(9);
        sort.get(resSort).click();
    }

    @And("Choose the minimum order amount")
    public void chooseTheMinimumOrderAmount() {
        List<WebElement> orderPrice = new Second_Page(driver).getMinimumOrder();
        Random minimumPrice = new Random();
        int oneOfPrice = minimumPrice.nextInt(orderPrice.size());
        orderPrice.get(oneOfPrice).click();
        String minimumOrderPrice = orderPrice.get(oneOfPrice).getText();
        yourChooseList.add(minimumOrderPrice);
    }

    @And("Will choose the cos of delivery")
    public void willChooseTheCosOfDelivery() {
        List<WebElement> allCostOfDelivery = new Second_Page(driver).getDeliverPrice();
        Random randomDelivery = new Random();
        int randDelivery = randomDelivery.nextInt(allCostOfDelivery.size());
        allCostOfDelivery.get(randDelivery).click();
        String minimumDeliveryCost = allCostOfDelivery.get(randDelivery).getText();
        yourChooseList.add(minimumDeliveryCost);
    }

    @Then("compares the search results on the page")
    public void comparesTheSearchResultsOnThePage() {
        List<WebElement> kitchenName = new Second_Page(driver).getKitchenListCheck();
        String oneOfKitchen = yourChooseList.get(0);
        for (int i = 0; i < kitchenName.size() - 1; i++) {
            if (kitchenName.get(i).isDisplayed()) {
                Assert.assertTrue(kitchenName.get(i).getText().contains(oneOfKitchen));
            }
        }




//
//
//
//
//        } else if (minimumOrderPrice.equals("15,00 zł lub mniej")) {
//            for (int i = 0; i < orderCostList.size(); i++) {
//                if (orderCostList.get(i).isDisplayed()) {
//                    String price = orderCostList.get(i).getText();
//                    String[] priceArray = price.split(" ");
//                    String[] splittedPriceArray = priceArray[1].split(",");
//                    String priceGr = "0.0" + splittedPriceArray[0];
//                    double priceGRDouble = Double.parseDouble(priceGr);
//                    double priceZlDouble = Double.parseDouble(splittedPriceArray[0]);
//                    double priceDouble = priceZlDouble + priceGRDouble;
//                    Assert.assertTrue(priceDouble <= 15);
//                }
//            }
//        } else if (minimumOrderPrice.equals("30,00 zł lub mniej")) {
//            for (int i = 0; i < orderCostList.size(); i++) {
//                if (orderCostList.get(i).isDisplayed()) {
//                    String price = orderCostList.get(i).getText();
//                    String[] priceArray = price.split(" ");
//                    String[] splittedPriceArray = priceArray[1].split(",");
//                    String priceGr = "0.0" + splittedPriceArray[0];
//                    double priceGRDouble = Double.parseDouble(priceGr);
//                    double priceZlDouble = Double.parseDouble(splittedPriceArray[0]);
//                    double priceDouble = priceZlDouble + priceGRDouble;
//                    Assert.assertTrue(priceDouble <= 30);
//                }
//            }
//        }

//        List<WebElement> deliverCostList = new Second_Page(driver).getDeliveryListCheck();
//        String minimumDeliveryCost = yourChooseList.get(2);
//        if (minimumDeliveryCost.equals("Za darmo")) {
//            for (WebElement webElement : deliverCostList) {
//                if (webElement.isDisplayed()) {
//                    Assert.assertEquals("GRATIS", webElement.getText());
//                }
//            }
//        } else if (minimumDeliveryCost.equals("Nie gra roli")) {
//        } else if (minimumDeliveryCost.equals("5,00 zł lub mniej")) {
//            for (int i = 0; i < deliverCostList.size(); i++) {
//                if (deliverCostList.get(i).isDisplayed() || !deliverCostList.get(i).getText().equals("GRATIS")) {
//                    String price = deliverCostList.get(i).getText();
//                    String[] priceArray = price.split(" ");
//                    String[] priceGrArray = priceArray[1].split(",");
//                    String priceGr = ".0" + priceGrArray[0];
//                    double priceZlDouble = Double.parseDouble(priceArray[0]);
//                    double priceGrDouble = Double.parseDouble(priceGr);
//                    double priceDouble = priceZlDouble + priceGrDouble;
//                    Assert.assertTrue(priceDouble <= 5.00);
//                }
//            }
//        } else if (minimumDeliveryCost.equals("10,00 zł lub mniej")) {
//            for (int i = 0; i < deliverCostList.size(); i++) {
//                if (deliverCostList.get(i).isDisplayed() || !deliverCostList.get(i).getText().equals("GRATIS")) {
//                    String price = deliverCostList.get(i).getText();
//                    String[] priceArray = price.split(" ");
//                    String[] priceGrArray = priceArray[1].split(",");
//                    String priceGr = ".0" + priceGrArray[0];
//                    double priceZlDouble = Double.parseDouble(priceArray[0]);
//                    double priceGrDouble = Double.parseDouble(priceGr);
//                    double priceDouble = priceZlDouble + priceGrDouble;
//                    Assert.assertTrue(priceDouble <= 10.00);
//                }
//            }
//        }
    }
}}

