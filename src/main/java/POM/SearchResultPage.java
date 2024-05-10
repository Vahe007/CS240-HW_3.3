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
        WebElement highToLow = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SearchResultPageLocators.HIGH_TO_LOW)));
        highToLow.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SearchResultPageLocators.SELECTED_HIGH_TO_LOW)));
        return this;
    }

    public String getFirstProductPrice() {
        WebElement price = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SearchResultPageLocators.FIRST_PRODUCT_PRICE)));
        return price.getText();
    }

    public String getSecondProductPrice() {
        WebElement price = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SearchResultPageLocators.SECOND_PRODUCT_PRICE)));
        return price.getText();
    }

    public long parseToNumber(String price) {
        String numericString = price.replaceAll("[₹,]", "");
        long number = Long.parseLong(numericString);
        return number;
    }

    public WebElement scrollToElement(By locator) {
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center', behavior: 'smooth'});", element);
        return element;
    }

    public void filterAvailableProducts() {
        By filter_locator = By.xpath(SearchResultPageLocators.AVAILABILITY_FILTER);
        WebElement availability_filter = scrollToElement(filter_locator);
        availability_filter.click();
        WebElement checkbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SearchResultPageLocators.AVAILABILITY_CHECKBOX)));
        checkbox.click();
    }


    public WebElement getLowToHighButton() {
        WebElement lowToHigh = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SearchResultPageLocators.LOW_TO_HIGH)));
        return lowToHigh;
    }


    public void clickFirstProduct() {
        WebElement product = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(SearchResultPageLocators.FIRST_PRODUCT)));
        product.click();
    }

    public ProductDetailsPage goToProduct() {
        clickFirstProduct();
        return new ProductDetailsPage(driver);
    }

    public WebElement findElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement noResultFound() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(SearchResultPageLocators.NO_RESULT)));
        return element;
    }

}
