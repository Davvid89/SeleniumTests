package First_Step;

import cucumber.api.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class First_Step {
    private WebDriver driver;
    private List<String> myListOfData = new ArrayList<>();

    @Given("The user goes to the login page.")
    public void theUserGoesToTheLoginPage() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=authentication&back=my-account");
    }

    @When("Complete your login details.")
    public void completeYourLoginDetails() {
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("hereYourEmail");
        WebElement name = driver.findElement(By.name("password"));
        name.sendKeys("HereYourPassword");
        driver.findElement(By.id("submit-login")).click();
    }

    @And("Proceed to creating the address.")
    public void proceedToCreatingTheAddress() {
        driver.findElement(By.id("addresses-link")).click();
    }

    @And("Create new addres")
    public void createNewAddres() {
        driver.findElement(By.cssSelector("div.addresses-footer i.material-icons")).click();
    }

    @And("Specify (.*)")
    public void specifyAlias(String alias) {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name("alias")));
        WebElement alias1 = driver.findElement(By.name("alias"));
        alias1.sendKeys(alias);
        this.myListOfData.add(alias);
    }

    @And("enter (.*)")
    public void enterAddress(String address) {
        WebElement address1 = driver.findElement(By.name("address1"));
        address1.sendKeys(address);
        this.myListOfData.add(address);
    }


    @And("User fill (.*)")
    public void userFillZipOrPostalCode(String code) {
        WebElement postcode = driver.findElement(By.name("postcode"));
        postcode.sendKeys(code);
        this.myListOfData.add(code);
    }

    @And("He will give his (.*)")
    public void giveCity(String city) {
        WebElement city1 = driver.findElement(By.name("city"));
        city1.sendKeys(city);
        this.myListOfData.add(city);
    }

    @And("Choose (.*)")
    public void chooseNationality(String nationality) {
        WebElement id_country = driver.findElement(By.name("id_country"));
        id_country.click();
        id_country.sendKeys(nationality);
        this.myListOfData.add(nationality);
    }

    @And("Fill (.*) and submit")
    public void fillPhoneNumber(String phoneNumber) {
        WebElement phone = driver.findElement(By.name("phone"));
        phone.sendKeys(phoneNumber);
        myListOfData.add(phoneNumber);
        phone.submit();
    }

    @And("Check if the given data is correct")
    public void checkIfTheGivenDataIsCorrect() {

        List<WebElement> elements = driver.findElements(By.cssSelector(".address-body"));

        int size = elements.size();
        WebElement webElement = elements.get(size - 1);
        String text = webElement.getText();
        text.split("\n");
        String[] splitted = text.split("\n");

        Assert.assertEquals(myListOfData.get(0), splitted[0]);
        Assert.assertEquals(myListOfData.get(1), splitted[2]);
        Assert.assertEquals(myListOfData.get(2), splitted[4]);
        Assert.assertEquals(myListOfData.get(3), splitted[3]);
        Assert.assertEquals(myListOfData.get(4), splitted[5]);
        Assert.assertEquals(myListOfData.get(5), splitted[6]);
    }

    @Then("Close the site.")
    public void closeTheSite() {
        driver.quit();
    }
}