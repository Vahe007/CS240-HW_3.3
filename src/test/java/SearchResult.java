import POM.ProductDetailsPage;
import POM.SearchResultPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class SearchResult extends BaseTest {

    @Test
    public void verifySortByPrice() {
        SearchResultPage searchPage = homePage.searchForProduct("iPhone 15");

        WebElement priceSort = searchPage.getLowToHighButton();
        priceSort.click();

        long firstPrice = searchPage.parseToNumber(searchPage.getFirstProductPrice());
        long secondPrice = searchPage.parseToNumber(searchPage.getSecondProductPrice());

        Assert.assertTrue(firstPrice < secondPrice, AssertionMessages.SEARCH_ERROR_MESSAGE);

    }

    @Test
    public void noResultFound() {
        SearchResultPage searchPage = homePage.searchForProduct("aaaaaaaaaaaaaaaaaccccccccccccc");
        Assert.assertTrue(searchPage.noResultFound().isDisplayed(), "Results were found");
        Assert.assertEquals(searchPage.noResultFound().getText(), AssertionMessages.NO_RESULT_FOUND);
    }

    @Test
    public void verifyProductImageClickable() {
        SearchResultPage searchPage = homePage.searchForProduct("iPhone");
        ProductDetailsPage productDetails = searchPage.goToProduct();
        String mainWindowHandle = driver.getWindowHandle();

        //changes the tab
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(mainWindowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        Assert.assertTrue(productDetails.getAddToCartButton().isDisplayed(), "Add to cart buttin is not displayed");
        Assert.assertTrue(productDetails.getBuyNowButton().isDisplayed(), "Buy now button is not displayed");
    }
}
