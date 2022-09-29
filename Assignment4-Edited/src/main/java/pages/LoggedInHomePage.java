package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoggedInHomePage extends BasePage{
    public LoggedInHomePage(WebDriver driver) {
        super(driver);
    }
    //private By homePageVerificationText = By.cssSelector(".features_items >h2");

    private By viewCartButton = By.xpath("(//ul[@class=\"nav navbar-nav\"]//a)[3]");


  /*  public boolean verifyHomePageIsVisible ()
    {
        return checkElementIsDisplayed(homePageVerificationText);
    }*/

    public ViewCartPage clickCartButton()
    {
        clickElement(viewCartButton);
        return new ViewCartPage(driver);
    }
}
