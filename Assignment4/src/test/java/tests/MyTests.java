package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.ProductsPage;
import pages.ViewCartPage;

import java.util.List;

public class MyTests extends BaseTests{
/*
    ViewCartPage viewCP ;
    BasePage basePage;
    AddProductsInCartTestCase a;
    List<WebElement> cartList;*/
    ProductsPage pp;
    By product = By.xpath("//h2[@class=\"title text-center\"]");
    By button = By.xpath("(//button[@class='btn btn-success close-modal btn-block'])");
    @Test
    public void test ()
    {
        pp= loggedInHomePage.clickProductButton();
        pp.scrollToElement(product);
        //pp.locateElement(product);
        //WebDriver p =  pp.hoverAndClick( driver,pp.locateElement(product),product );
        //pp.clickElement(button);
        //p.findElement(button).click();
        //pp.addFirstProductToCart();
        //viewCP = loggedInHomePage.clickCartButton();
        //viewCP.getNumericQuantitiesInCart();

        //System.out.println(viewCP.getNumericQuantitiesInCart().length);

        //viewCP.resetCart();




    }
}
