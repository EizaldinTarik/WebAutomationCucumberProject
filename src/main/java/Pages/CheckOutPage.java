package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckOutPage {
    WebDriver driver;
    WebDriverWait wait;
    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
    }
    //Locators
    private By checkOutName = By.id("name");
    private By checkOutCountry = By.id("country");
    private By checkOutCity = By.id("city");
    private By checkOutCard = By.id("card");
    private By checkOutMonth = By.id("month");
    private By checkOutYear = By.id("year");
    private By purchase = By.xpath("//button[@onclick = \"purchaseOrder()\"]");
    private By verifyPurchaseMessage = By.xpath("//h2[contains(text(), \"Thank you for your purchase!\")]");
    private By acceptVerifyMessage = By.xpath("//button[@class = \"confirm btn btn-lg btn-primary\"]");
    //Actions
    public void setCheckOutName(String name) {
        driver.findElement(checkOutName).sendKeys(name);
    }
    public void setCheckOutCountry(String country) {
        driver.findElement(checkOutCountry).sendKeys(country);
    }
    public void setCheckOutCity(String city) {
        driver.findElement(checkOutCity).sendKeys(city);
    }
    public void setCheckOutCard(String card) {
        driver.findElement(checkOutCard).sendKeys(card);
    }
    public void setCheckOutMonth(String month) {
        driver.findElement(checkOutMonth).sendKeys(month);
    }
    public void setCheckOutYear(String year) {
        driver.findElement(checkOutYear).sendKeys(year);
    }
    public void onClickPurchaseButton() throws InterruptedException {
        Thread.sleep(2000);
        //wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        //wait.until(ExpectedConditions.invisibilityOf(driver.findElement(purchase)));
        driver.findElement(purchase).click();
    }
    public String VerifyPurchaseMessage() throws InterruptedException {
        Thread.sleep(2000);
        return driver.findElement(verifyPurchaseMessage).getText();
    }
    public void onClickAcceptVerifyMessage() {
        driver.findElement(acceptVerifyMessage).click();
    }
}
