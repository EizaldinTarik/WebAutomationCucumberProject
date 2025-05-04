package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    WebDriver driver;
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }
    //Locators
    private By checkItemName1 = By.cssSelector("tr.success:nth-child(1) td:nth-child(2)");
    private By checkItemPrice1 = By.cssSelector("tr.success:nth-child(1) td:nth-child(3)");
    private By checkItemName2 = By.cssSelector("tr.success:nth-child(2) td:nth-child(2)");
    private By checkItemPrice2 = By.cssSelector("tr.success:nth-child(2) td:nth-child(3)");
    private By totalPrice = By.id("totalp");
    private By placeOrder = By.xpath("//button[@class='btn btn-success']");
    //Actions
    public String setCheckItemName1() {
        return driver.findElement(checkItemName1).getText();
    }
    public String setCheckItemName2() {
        return driver.findElement(checkItemName2).getText();
    }
    public String setCheckItemPrice1() {
        return driver.findElement(checkItemPrice1).getText();
    }
    public String setCheckItemPrice2() {
        return driver.findElement(checkItemPrice2).getText();
    }
    public String setTotalPrice() {
        return driver.findElement(totalPrice).getText();
    }
    public CheckOutPage onClickPlaceOrder() throws InterruptedException {
        driver.findElement(placeOrder).click();
        Thread.sleep(2000);
        return new CheckOutPage(driver);
    }
}
