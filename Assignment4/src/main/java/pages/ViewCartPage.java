package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class ViewCartPage extends BasePage{
    public ViewCartPage(WebDriver driver) {
        super(driver);
    }

    private By productButton = By.xpath("(//li/a)[2]");
    private By productTextList = By.xpath("//h4/a");
    private By productPriceTextList =  By.xpath("//td[@class=\"cart_price\"]/p");
    private By quantityOfProductsInCart = By.xpath("//button[@class=\"disabled\"]");
    private By deleteButtons = By.xpath("//a[@class=\"cart_quantity_delete\"]");
    private By quantityList = By.xpath("//td[@class=\"cart_quantity\"]/button");
    private By totalPriceList = By.xpath("//p[@class=\"cart_total_price\"]");

    public ProductsPage resetCart ()
    {
        try {
            for (int i=0  ;i<(locateListOfElements(deleteButtons).size()); i++)
                {locateListOfElements(deleteButtons).get(i).click();}
            }
        catch (Exception e)
            {/*cart is empty -> go to products page*/}
        clickElement(productButton);
        return new ProductsPage(driver);
    }
    public List<String> getTextOfProductsInCart() {return getTextOfElementsList(productTextList);}
    public List<String> getTextOfProductsPriceInCart() {return getTextOfElementsList(productPriceTextList);}
    public List<String> getTextOfQuantitiesInCart() {return getTextOfElementsList(quantityList);}
    public List<String> displayedTotalPrice(){return getTextOfElementsList(totalPriceList);}

    public int[] getNumericPricesInCart() {return getIntListFromStrList(productPriceTextList,getTextOfElementsList(productPriceTextList).size());}
    public int[] getNumericQuantitiesInCart () {return getIntListFromStrList(quantityOfProductsInCart,getTextOfElementsList(quantityOfProductsInCart).size());}
    public int[] getNumericDisplayedTotalPrice() {return getIntListFromStrList(totalPriceList ,getTextOfElementsList(totalPriceList).size());}
    public int[] calculateTotalProductPricesInCart() {return multiply2Lists(getNumericPricesInCart(),getNumericQuantitiesInCart(),getNumericQuantitiesInCart().length);}



}

