package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }

    private By signInSignUpButton = By.xpath("(//ul[@class =\"nav navbar-nav\"]//a)[4]");
    public LoginPage clickSignInSignUpButton ()
    {
        clickElement(signInSignUpButton);
        return new LoginPage (driver);
    }

}
