import POM.ProductDetailsPage;
import POM.SearchResultPage;
import org.testng.annotations.Test;

public class AllPomTests extends BaseTest {
    @Test
    public void testAll() {
//        in some cases the banner is appearing, in some it's not, when its appearing
//        the method invocation below should be uncommented

//        homePage.closeBanner();
        SearchResultPage searchPage = homePage.searchForProduct("iPhone 15");
        searchPage.clickPriceHighToLow();
        searchPage.filterAvailableProducts();
        ProductDetailsPage productDetailsPage = searchPage.goToProduct();
    }
}
