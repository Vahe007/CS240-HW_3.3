package POM;

import POM.base.BasePage;
import locators.SearchResultPageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultPage extends BasePage {
    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public SearchResultPage clickPriceHighToLow() {
        WebElement hightToLow = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SearchResultPageLocators.HIGH_TO_LOW)));
        hightToLow.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SearchResultPageLocators.SELECTED_HIGH_TO_LOW)));
        return this;
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

//    public void scrollToAvailabilityFilter() {
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(SearchResultPageLocators.SELECTED_FILTER)));
//        WebElement filter = driver.findElement(By.xpath(SearchResultPageLocators.AVAILABILITY_FILTER));
//        Actions a = new Actions(driver);
//        a.moveToElement(filter).perform();
//        wait.until(ExpectedConditions.elementToBeClickable(filter)).click();
//    }
//
//    public void filterAvailableProducts() {
//        scrollToAvailabilityFilter();
//        WebElement checkbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SearchResultPageLocators.AVAILABILITY_CHECKBOX)));
//        checkbox.click();
//    }




    // Method to scroll to element
    public static void scrollToElement(WebDriver driver, WebDriverWait wait, By locator) {
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public void scrollToAvailabilityFilter() {
        scrollToElement(driver, wait, By.className(SearchResultPageLocators.AVAILABILITY_FILTER));
        WebElement filter = driver.findElement(By.className(SearchResultPageLocators.AVAILABILITY_FILTER));
        filter.click();
    }

    public void filterAvailableProducts() {
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SearchResultPageLocators.HIGH_TO_LOW)));
        scrollToAvailabilityFilter();
        WebElement checkbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SearchResultPageLocators.AVAILABILITY_CHECKBOX)));
        checkbox.click();
    }


    public WebElement getLowToHighButton() {
        WebElement lowToHight = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SearchResultPageLocators.LOW_TO_HIGH)));
        return lowToHight;
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
