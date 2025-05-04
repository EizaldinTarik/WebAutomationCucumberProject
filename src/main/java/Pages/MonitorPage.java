package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MonitorPage {
    WebDriver driver;
    public MonitorPage(WebDriver driver) {
        this.driver = driver;
    }
    //Locators
    private By monitorItem = By.xpath("//a[contains(text(),\"Apple monitor 24\")]");
    private By addToCart = By.xpath("//a[contains(text(), \"Add to cart\")]");
    private By homePageLink = By.xpath("//a[contains(text(), \"Home \")]");
    //Actions
    public void onClickMonitorItem() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(monitorItem).click();
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
