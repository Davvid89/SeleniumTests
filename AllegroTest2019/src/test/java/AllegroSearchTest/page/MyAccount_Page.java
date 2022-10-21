package AllegroSearchTest.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.PageFactory;

public class MyAccount_Page {

    public MyAccount_Page(WebDriver driver){ PageFactory.initElements(driver, this); }

    @FindBy(xpath = "//div[@class='p1ge4'] //a[@href='/moje-allegro/moje-konto/logowanie-i-haslo']")
    private WebElement changePassword;

    public void ChangePassword() {
        changePassword.click();
    }
}
