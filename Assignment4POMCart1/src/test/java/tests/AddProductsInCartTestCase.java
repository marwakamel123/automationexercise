package tests;

import org.json.simple.JSONArray;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ProductsPage;
import pages.ViewCartPage;

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
    public void checkUserLoggedInToHomepageSuccessfullyTest()
    {
        String username = (String) getJsonValueByKey(testDataJsonFile, "expectedUserNameKey");
        Assert.assertEquals(loggedInHomePage.checkIfUserNameIsDisplayedCorrectly(),username,usernameEMSG);
    }

    @Test (priority = 1)
    public void addToCartTests()
    {
        productPage = loggedInHomePage.clickCartButton().resetCart();
        productPage.addFirstProductToCart();
        productPage.addSecondProductToCart();
        viewCartPage = productPage.clickViewCartButton();
        assertEqualsLoop(viewCartPage.getTextOfProductsInCart(),productTextTextData, productsEMSG);
        assertEqualsLoop(viewCartPage.getTextOfProductsPriceInCart(),ProductPriceTextData, priceEMSG);
        assertEqualsLoop(viewCartPage.getTextOfQuantitiesInCart(),quantityTextData, quantityEMSG );
        assertEqualsLoop(viewCartPage.displayedTotalPrice(),totalPricesTextData,displayedTotalPriceEMSG);
        assertEqualsLoop(viewCartPage.calculateTotalProductPricesInCart(),viewCartPage.getNumericDisplayedTotalPrice(),calculatedTotalPriceEMSG);

    }

}
