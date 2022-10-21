package POP.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void loginAs(String email, String pass) {
        WebElement emailField = driver.findElement(By.name("email"));
        emailField.click();
        emailField.sendKeys(email);

        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.click();
        passwordField.sendKeys(pass);

        driver.findElement(By.id("submit-login")).click();
    }

    public String getLoggedUserName(){
        return driver.findElement(By.cssSelector(".account")).getText();
    }

    public void clickUserButton() {
        driver.findElement(By.cssSelector(".account")).click();
    }
}
