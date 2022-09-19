package tests;

import org.json.simple.JSONArray;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

import java.util.List;

import static fileReaderManager.ReadFromFiles.getJsonArrValueByKey;
import static fileReaderManager.ReadFromFiles.getJsonValueByKey;

public class SearchProductTestCase extends BaseTests {

    ProductsPage productPage;
    ProductSearchResultPage productSearchResultPage;
    private String expectedUserName;// = "marwa kamel";
    private String allProductsVerificationText;//  = "ALL PRODUCTS";
    private String searchText;// = "Sleeveless";
    private String  numberOfProductsText;
    private String allProductsVerificationEMSG;
    private String numOfProductsVerificationEMSG;
    private String searchResultsVerificationEMSG;
    private String usernameEMSG;

    public static String testDataJsonFile = "searchProductTestData.json" ;


    @BeforeClass
    public void loadTestData() {
        expectedUserName = (String) getJsonValueByKey(testDataJsonFile, "expectedUserNameKey");
        allProductsVerificationText = (String) getJsonValueByKey(testDataJsonFile, "allProdVerifKey");
        searchText = (String) getJsonValueByKey(testDataJsonFile, "searchTextKey");
        numberOfProductsText= (String)getJsonValueByKey(testDataJsonFile, "numOfprodKey") ;// Integer.parseInt(getJsonValueByKey(testDataJsonFile, "numOfprodKey"));
        allProductsVerificationEMSG = (String) getJsonValueByKey(testDataJsonFile, "allProdEMSGKey");
        numOfProductsVerificationEMSG = (String) getJsonValueByKey(testDataJsonFile, "numOfProdEMSGKey");
        searchResultsVerificationEMSG = (String) getJsonValueByKey(testDataJsonFile, "searchResulEMSGKey");
        usernameEMSG = (String) getJsonValueByKey(testDataJsonFile, "userNameEMSGKey");


    }

    @Test(priority = 0)
    public void homepageIsVisibleSuccessfullyAfterLoginTest() {
        Assert.assertEquals(loggedInHomePage.checkIfUserNameIsDisplayedCorrectly(), expectedUserName, usernameEMSG);
        }

    @Test(priority = 1)
    void verifyNavigationAddSearchTests() {
        productPage = loggedInHomePage.clickProductButton();
        Assert.assertEquals(productPage.getAllProductsHeaderText(), allProductsVerificationText, allProductsVerificationEMSG);
        productSearchResultPage = productPage.searchProduct(searchText);
        Assert.assertEquals(productSearchResultPage.getTextOfDisplayedProducts().size(),Integer.parseInt(numberOfProductsText),numOfProductsVerificationEMSG);
        assertContainsLoop(productSearchResultPage.getTextOfDisplayedProducts(),searchText,searchResultsVerificationEMSG);
        }


}
