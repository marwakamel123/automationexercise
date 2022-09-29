package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
    private By viewCartButton = By.cssSelector(".text-center>a");
    //private By viewCartBtn = By.xpath("//div[@class=\"modal-body\"]//a");




    public boolean checkAllProductsHeaderTextIsVisible() {
        return checkElementIsDisplayed(allProductsDispalyedText);
    }
    public ProductSearchResultPage searchProduct(String searchText) {
        scrollToElement(productSreachTextField);
        typeOnInputField(productSreachTextField, searchText);
        clickElement(submitSearchButton);
        return new ProductSearchResultPage(driver);
    }
    public void addFirstProductToCart() {
        scrollToElement(productSreachTextField);
        hover( this.driver, locateElement(firstProduct),firstProduct);
        forceClickOnElement(firstProduct);
    }
    public void clickContinueShopping()
    {
        clickElement(clickContinueShoppingButton);
    }
    public void addSecondProductToCart() {
        scrollToElement(productSreachTextField);
        hover( this.driver, locateElement(secondProduct),secondProduct);
        forceClickOnElement(secondProduct);
        //clickElement(clickContinueShoppingButton);
        }

        public ViewCartPage clickViewCart()
        {
            clickElement(viewCartButton);
            return new ViewCartPage(driver);
        }


    public ViewCartPage clickViewCartButton()
    {
        clickElement(viewCartButton);
        return new ViewCartPage(driver);
    }

}


