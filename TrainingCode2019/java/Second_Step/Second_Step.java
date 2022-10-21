package Second_Step;


import cucumber.api.java.en.*;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Second_Step {

    private WebDriver driver;


    @Given("the user goes to the store's website")
    public void theUserGoesToTheStoreSWebsite() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=authentication&back=my-account");
    }

    @When("Log in to the site")
    public void logInToTheSite() {
        WebDriverWait wait = new WebDriverWait(driver, 4);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("hereYourEmail");
        WebElement name = driver.findElement(By.name("password"));
        name.sendKeys("HereYourPassword");
        driver.findElement(By.id("submit-login")).click();
    }

    @And("Search and choose Hummingbird Printed Sweater")
    public void searchAndChooseHummingbirdPrintedSweater() {
        WebElement search = driver.findElement(By.name("s"));
        search.sendKeys("Hummingbird Printed Sweater");
        search.submit();
        WebElement productName = driver.findElement(By.cssSelector(".h3.product-title"));
        if (productName.getText().contains("Hummingbird Printed Sweater")) {
            productName.click();
        }
    }

    @And("Check the discount and choose the (.*)")
    public void checkTheDiscountAndChooseTheSize(String size) {
        String discount = driver.findElement(By.cssSelector(".discount.discount-percentage")).getText();
        Assert.assertEquals("SAVE 20%", discount);

        WebElement itemSize = driver.findElement(By.cssSelector(".form-control.form-control-select"));
        itemSize.sendKeys(size);
        itemSize.click();
    }

    @And("choose (.*)")
    public void chooseQuantity(String quantity) {
        WebElement quantityItems = driver.findElement(By.id("quantity_wanted"));
        quantityItems.click();
        quantityItems.clear();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.attributeToBe(By.id("quantity_wanted"), "value", ""));
        quantityItems.sendKeys(quantity);
    }

    @And("add product to cart and click checkout")
    public void addProductToCartAndClickCheckout() {
        driver.findElement(By.cssSelector(".btn.btn-primary.add-to-cart")).click();
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.cart-content-btn a.btn.btn-primary")));
        driver.findElement(By.cssSelector("div.cart-content-btn a.btn.btn-primary")).click();
    }

    @And("Proceed to checkout")
    public void proceedToCheckout() {
        WebElement checkout = driver.findElement(By.cssSelector("div.card.cart-summary a.btn.btn-primary"));
        checkout.click();
    }

    @And("Confirm the address and select a delivery method")
    public void confirmTheAddressAndSelectADeliveryMethod() {
        driver.findElement(By.cssSelector("button[name='confirm-addresses']")).click();
        WebElement shippingMethodButton = driver.findElement(By.id("delivery_option_1"));
        if (!shippingMethodButton.isSelected()) {
            shippingMethodButton.click();
        }
        driver.findElement(By.cssSelector("button[name='confirmDeliveryOption']")).click();
    }

    @And("Method of payment choose and agree to the terms of service")
    public void methodOfPaymentChoose() {
        driver.findElement(By.id("payment-option-1")).click();
        driver.findElement(By.id("conditions_to_approve[terms-and-conditions]")).click();
    }

    @And("submit your order")
    public void submitYourOrder() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement order = driver.findElement(By.id("payment-confirmation"));
        order.click();
    }

    @Then("Do a screenshot")
    public void doAScreenshot() throws IOException {
        WebDriverWait wait = new WebDriverWait(driver, 4);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".h1.card-title")));
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("/home/oem/Obrazy/obraz.png"));
    }
}