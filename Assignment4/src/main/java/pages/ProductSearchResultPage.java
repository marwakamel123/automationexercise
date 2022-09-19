package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class ProductSearchResultPage extends BasePage{
      public ProductSearchResultPage(WebDriver driver) {
        super(driver);
    }
      private By productSreachTextField = By.id("search_product");
      By overLaySearchResultText = By.xpath("//div[@class=\"productinfo text-center\"]/p") ;
      public List<String> getTextOfDisplayedProducts()
        {
            scrollToElement(productSreachTextField);
            return getTextOfElementsList(overLaySearchResultText);
        }

}
