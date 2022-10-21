package GoogleSearch;

import cucumber.api.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class googleSearch_step {

    WebDriver driver;

    @Given("An open browser with google.")
    public void anOpenBrowserWithGoogle() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://google.com");
    }

    @When("(.*) word has been written into the input field and submitted")
    public void seleniumWordHasBeenWrittenIntoTheInputFieldAndSubmitted(String keyWord) {
        WebElement inputField = driver.findElement(By.name("q"));
        inputField.sendKeys(keyWord);
        inputField.submit();
    }

    @Then("First result contains (.*) word")
    public void firstResultContainsSeleniumWord(String keyWord) {
        String text = driver.findElement(By.cssSelector(".rc")).getText();
        Assert.assertTrue(text.contains(keyWord));
    }

    @And("Close the browser")
    public void closeTheBrowser() {
        driver.quit();
    }
}
