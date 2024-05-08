import POM.ProductDetailsPage;
import POM.SearchResultPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AllPomTests extends BaseTest {
    @Test
    public void testAll() {
//        in some cases the banner is appearing, in some it's not, when its appearing
//        the method invocation below should be uncommented
//        homePage.closeBanner();
        SearchResultPage searchPage = homePage.searchForProduct("iPhone 15");
        searchPage.clickPriceHighToLow();
//        searchPage.filterAvailableProducts();

        Assert.assertTrue(searchPage.getLowToHighButton().getText().contains(AssertionMessages.LOW_TO_HIGH), AssertionMessages.LOW_TO_HIGH);

        ProductDetailsPage productDetailsPage = searchPage.goToProduct();
        String mainWindowHandle = driver.getWindowHandle();

        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(mainWindowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        productDetailsPage.getBuyNowButton().click();
    }
}
