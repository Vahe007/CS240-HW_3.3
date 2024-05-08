package POM;

import POM.base.BasePage;
import locators.HomePageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage closeBanner() {
        By.className(HomePageLocators.CLOSE_BUTTON);
        WebElement closeButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(HomePageLocators.CLOSE_BUTTON)));
        closeButton.click();
        return this;
    }

    public void inputSearch(String product) {
        WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(HomePageLocators.SEARCH)));
        searchField.click();
        searchField.sendKeys(product);
        searchField.sendKeys(Keys.ENTER);
    }

    public SearchResultPage searchForProduct(String product) {
        inputSearch(product);
        return new SearchResultPage(driver);
    }
}
