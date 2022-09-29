package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

import java.util.List;

import static fileReaderManager.ReadFromFiles.*;

public class SearchProductTestCase extends BaseTests {

    ProductsPage productPage;
    ProductSearchResultPage productSearchResultPage;
    private String searchText;// = "Sleeveless";
    private int  numberOfProductsText;

    public static String testDataJsonFile = "searchProductTestData.json" ;
    public List<WebElement> allProductsList;



    @BeforeClass
    public void loadTestData() {
        searchText = (String) getJsonObjByKey(testDataJsonFile, "searchTextKey");
        numberOfProductsText=  Integer.parseInt( (String) getJsonObjByKey(testDataJsonFile, "numOfprodKey" ));// Integer.parseInt(getJsonValueByKey(testDataJsonFile, "numOfprodKey"));
    }

    @Test(priority = 0)
    public void homepageIsVisibleSuccessfully() {
        //3. Verify that home page is visible successfully
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.verifyHomePageIsVisible(),"Home Page Should show : FEATURES ITEMS");
        }

    @Test(priority = 1)
    void verifyNavigationAddSearchTests() {
        HomePage homePage = new HomePage(driver);
        productPage = homePage.clickProductButton();
        //5. Verify user is navigated to ALL PRODUCTS page successfully
        Assert.assertTrue(productPage.checkAllProductsHeaderTextIsVisible(), "ALL PRODUCTS text should be visible");
        productSearchResultPage = productPage.searchProduct(searchText);

        //7. Verify 'SEARCHED PRODUCTS' is visible
        Assert.assertTrue(productSearchResultPage.verifySearchedProductsTextIsVisible(),"text should be visible");

        allProductsList = productSearchResultPage.getListOfDisplayedProducts();
        //8. Verify all the products related to search are visible
        Assert.assertEquals(allProductsList.size(), numberOfProductsText, "Tree Products Should be Displayed");
        for (int i = 1; i < allProductsList.size(); i++) {
            Assert.assertTrue(allProductsList.get(i).getText().contains(searchText), "Products should contains the search text Sleevless");
        }

        }

}
