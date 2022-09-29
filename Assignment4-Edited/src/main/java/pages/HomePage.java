package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }

    private By signInSignUpButton = By.xpath("(//ul[@class =\"nav navbar-nav\"]//a)[4]");
    private By homePageVerificationText = By.cssSelector(".features_items >h2");
    private By productsButton = By.xpath("(//ul[@class=\"nav navbar-nav\"]//a)[2]");

    public LoginPage clickSignInSignUpButton ()
    {
        clickElement(signInSignUpButton);
        return new LoginPage (driver);
    }

    public boolean verifyHomePageIsVisible ()
    {
        return checkElementIsDisplayed(homePageVerificationText);
    }
    public ProductsPage clickProductButton()
    {
        clickElement(productsButton);
        return new ProductsPage(driver);
    }
}
