package POM;

import POM.base.BasePage;
import locators.SearchResultPageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchResultPage extends BasePage {
    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public void clickPriceHighToLow() {
        WebElement hightToLow = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(SearchResultPageLocators.HIGH_TO_LOW)));
        hightToLow.click();
    }

    public String getFirstProductPrice() {
        WebElement price = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(SearchResultPageLocators.FIRST_PRODUCT_PRICE)));
        return price.getText();
    }

    public String getSecondProductPrice() {
        WebElement price = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(SearchResultPageLocators.SECOND_PRODUCT_PRICE)));
        return price.getText();
    }

    public long parseToNumber(String price) {
        String numericString = price.replaceAll("[₹,]", "");
        long number = Long.parseLong(numericString);
        return number;
    }

    public void scrollToAvailabilityFilter() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(SearchResultPageLocators.SELECTED_FILTER)));
        WebElement filter = driver.findElement(By.xpath(SearchResultPageLocators.AVAILABILITY_FILTER));
        Actions a = new Actions(driver);
        a.moveToElement(filter).perform();
        wait.until(ExpectedConditions.elementToBeClickable(filter)).click();
    }

    public void filterAvailableProducts() {
        scrollToAvailabilityFilter();
        WebElement checkbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SearchResultPageLocators.AVAILABILITY_CHECKBOX)));
        checkbox.click();
    }

    public void clickFirstProduct() {
        WebElement product = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(SearchResultPageLocators.FIRST_PRODUCT)));
        product.click();
    }

    public ProductDetailsPage goToProduct() {
        clickFirstProduct();
        return new ProductDetailsPage(driver);
    }


}
