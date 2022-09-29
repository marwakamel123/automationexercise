package tests;

import org.json.simple.JSONArray;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductsPage;
import pages.ViewCartPage;

import java.util.List;

import static fileReaderManager.ReadFromFiles.getJsonArrValueByKey;
import static fileReaderManager.ReadFromFiles.getJsonValueByKey;

public class AddProductsInCartTestCase extends BaseTests{
    ProductsPage productPage;
    ViewCartPage viewCartPage;
    public static String testDataJsonFile = "addProductsinCartTestData.json" ;

    JSONArray productTextTextData;
    JSONArray ProductPriceTextData;
    JSONArray quantityTextData;
    JSONArray totalPricesTextData;
    String usernameEMSG;
    String productsEMSG;
    String priceEMSG;
    String quantityEMSG;
    String displayedTotalPriceEMSG;
    String calculatedTotalPriceEMSG;


    @BeforeClass
    public void loadTestData() {
        productTextTextData =   getJsonArrValueByKey(testDataJsonFile, "prodTextDataKey");
        ProductPriceTextData =   getJsonArrValueByKey(testDataJsonFile, "ProdPriceTextDataKey");
        quantityTextData =  getJsonArrValueByKey(testDataJsonFile, "quantTextDataKey");
        totalPricesTextData = getJsonArrValueByKey(testDataJsonFile, "totalPriceTextDataKey");
        usernameEMSG = (String) getJsonValueByKey(testDataJsonFile, "userNameEMSGKey");
        productsEMSG = (String) getJsonValueByKey(testDataJsonFile, "productsEMSGKey");
        priceEMSG = (String) getJsonValueByKey(testDataJsonFile, "priceEMSGKey");
        quantityEMSG = (String) getJsonValueByKey(testDataJsonFile, "quantityEMSGKey");
        displayedTotalPriceEMSG = (String) getJsonValueByKey(testDataJsonFile, "displayedTotalPriceEMSGKey");
        calculatedTotalPriceEMSG =  (String) getJsonValueByKey(testDataJsonFile, "calculatedTotalPriceEMSGKey");

    }


    @Test(priority = 0)
    public void homepageIsVisibleSuccessfully()
    {
        HomePage homePage = new HomePage(driver);
        //3. Verify that home page is visible successfully
        Assert.assertTrue(homePage.verifyHomePageIsVisible(),"Home Page Should show : FEATURES ITEMS");
    }

    @Test (priority = 1)
    public void addToCartTests()
    {
        HomePage homePage = new HomePage(driver);
        productPage = homePage.clickProductButton();
        productPage.addFirstProductToCart();
        productPage.clickContinueShopping();
        productPage.addSecondProductToCart();
        viewCartPage = productPage.clickViewCart();

        //9. Verify both products are added to Cart
       List<String> productsInCart=  viewCartPage.getTextOfProductsInCart();
       Assert.assertEquals(productsInCart.size(),2,"Two Products should be in cart");

        //10. Verify their prices, quantity and total price
       List<String> productPrices = viewCartPage.getTextOfProductsPriceInCart();
       List<String> productsQuantity=viewCartPage.getTextOfQuantitiesInCart() ;
       List<String> productsTotalPrice= viewCartPage.displayedTotalPrice();

        for (int i = 1; i < productsInCart.size(); i++) {
            Assert.assertEquals(productPrices.get(i), ProductPriceTextData.get(i), "price");
            Assert.assertEquals(productsQuantity.get(i),quantityTextData.get(i), "quant");
            Assert.assertEquals(productsTotalPrice.get(i),totalPricesTextData.get(i),"total");
        }

    }

}
