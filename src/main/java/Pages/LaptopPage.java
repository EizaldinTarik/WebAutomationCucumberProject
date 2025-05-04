package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LaptopPage {
    WebDriver driver;
    public LaptopPage(WebDriver driver) {
        this.driver = driver;
    }
    //Locators
    private By laptopItem = By.xpath("//a[contains(text(), \"Sony vaio i5\")]");
    private By addToCart = By.xpath("//a[contains(@onclick,'addToCart')]");
    private By homePageLink = By.xpath("//a[contains(text(), \"Home \")]");
    //Actions
    public void onClickLaptopItem() throws InterruptedException {
        driver.findElement(laptopItem).click();
        Thread.sleep(1000);
    }
    public void AddToCart() throws InterruptedException {
        driver.findElement(addToCart).click();
        Thread.sleep(2000);
    }
    public String verifyAlertMessageAdded() {
        return driver.switchTo().alert().getText();
    }
    public void acceptAlertMessage() {
        driver.switchTo().alert().accept();
    }
    public HomePage navToHomePage() {
        driver.findElement(homePageLink).click();
        return new HomePage(driver);
    }
}
