package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoggedInHomePage extends BasePage{
    public LoggedInHomePage(WebDriver driver) {
        super(driver);
    }
    private By signInVerificationText = By.xpath("//li//b");
    private By productsButton = By.xpath("(//ul[@class=\"nav navbar-nav\"]//a)[2]");
    private By viewCartButton = By.xpath("(//ul[@class=\"nav navbar-nav\"]//a)[3]");

    public String checkIfUserNameIsDisplayedCorrectly()
    {
        return getTextOfElement(signInVerificationText);
    }
    public ProductsPage clickProductButton()
    {
        clickElement(productsButton);
        return new ProductsPage(driver);
    }
    public ViewCartPage clickCartButton()
    {
        clickElement(viewCartButton);
        return new ViewCartPage(driver);
    }
}
