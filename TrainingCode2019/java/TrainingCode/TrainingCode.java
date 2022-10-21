package TrainingCode;

import cucumber.api.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TrainingCode {

    WebDriver driver;

    @Given("User open browser on authentication site.")
    public void userOpenBrowserOnAuthenticationsSite() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qloapps.coderslab.pl/pl/logowanie?back=my-account");
    }

    @When("Entering an (.*) and going to the registration form.")
    public void enteringAnEmailAndGoingToTheRegistrationForm(String email) {
        WebElement email_create = driver.findElement(By.id("email_create"));
        email_create.sendKeys(email);
        email_create.submit();
    }

    @Then("Choose gender.")
    public void chooseGender() {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("id_gender1")));
        driver.findElement(By.id("id_gender1")).click();
    }

    @And("Complete the field with (.*)")
    public void completeTheFieldWith(String firstName) {
        WebElement customer_firstname = driver.findElement(By.id("customer_firstname"));
        customer_firstname.sendKeys(firstName);
    }

    @And("Enter (.*)")
    public void enterLastName(String lastName) {
        WebElement customerLastName = driver.findElement(By.id("customer_lastname"));
        customerLastName.sendKeys(lastName);
    }

    @And("Specify the (.*)")
    public void specifyThePassword(String password) {
        WebElement passwd = driver.findElement(By.id("passwd"));
        passwd.sendKeys(password);
    }

    @And("Fill out the fields with date of birth.")
    public void fillOutTheFieldsWithDateOfBirth() {
        WebElement days = driver.findElement(By.id("days"));
        days.sendKeys("12");

        WebElement months = driver.findElement(By.id("months"));
        months.click();
        months.sendKeys("October");
        months.click();

        WebElement years = driver.findElement(By.id("years"));
        years.sendKeys("1969");
    }

    @And("Accept the newsletter and become our partner and press the registration button.")
    public void acceptTheNewsletterAndBecomeOurPartnerAndPressTheRegistrationButton() {
        driver.findElement(By.id("newsletter")).click();
        driver.findElement(By.id("optin")).click();
        driver.findElement(By.id("submitAccount")).click();
    }

    @Then("You have been transferred to your account.")
    public void youHaveBeenTransferredToYourAccount() {
        WebElement submitMsg = driver.findElement(By.cssSelector(".alert.alert-success"));
        String text = submitMsg.getText();
        Assert.assertEquals("Your account has been created.", text);
        driver.quit();
    }
}
