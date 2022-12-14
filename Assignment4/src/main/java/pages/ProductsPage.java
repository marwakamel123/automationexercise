package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class ProductsPage extends BasePage {
    public ProductsPage(WebDriver driver) {
        super(driver);
    }
    private By allProductsDispalyedText = By.xpath("//h2[@class=\"title text-center\"]");
    private By productSreachTextField = By.id("search_product");
    private By submitSearchButton = By.id("submit_search");
    private By firstProduct = By.xpath("(//a[@class=\"btn btn-default add-to-cart\"])[1]");
    private By secondProduct = By.xpath("(//a[@class=\"btn btn-default add-to-cart\"])[3]");
    private By clickContinueShoppingButton = By.className("btn-success");
    private By viewCartButton = By.xpath("(//ul[@class=\"nav navbar-nav\"]//a)[3]");



    public String getAllProductsHeaderText() {
        return getTextOfElement(allProductsDispalyedText);
    }
    public ProductSearchResultPage searchProduct(String searchText) {
        scrollToElement(productSreachTextField);
        typeOnInputField(productSreachTextField, searchText);
        clickElement(submitSearchButton);
        return new ProductSearchResultPage(driver);
    }
    public void addFirstProductToCart() {
        scrollToElement(productSreachTextField);
        hoverAndClick( this.driver, locateElement(firstProduct),firstProduct);
        clickElement(clickContinueShoppingButton);
    }
    public void addSecondProductToCart() {
        scrollToElement(productSreachTextField);
        hoverAndClick( this.driver, locateElement(secondProduct),secondProduct);
        clickElement(clickContinueShoppingButton);
        }
    public ViewCartPage clickViewCartButton()
    {
        clickElement(viewCartButton);
        return new ViewCartPage(driver);
    }

}


