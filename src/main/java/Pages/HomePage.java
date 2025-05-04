package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    //Locators
    private By signUpLink = By.id("signin2");
    private By loginLink = By.id("login2");
    private By laptopsCatLink = By.xpath("//a[@onclick = \"byCat('notebook')\"]");
    private By monitorsCatLink = By.xpath("//a[@onclick = \"byCat('monitor')\"]");
    private By cartLink = By.id("cartur");
    private By logoutLink = By.id("logout2");


    //Actions
    public void onClickSignUpLink() throws InterruptedException {
        driver.findElement(signUpLink).click();
        Thread.sleep(1500);
    }
    public void onClickLoginLink() throws InterruptedException {
        driver.findElement(loginLink).click();
        Thread.sleep(2000);
    }
    public LaptopPage onClickLaptopCat() {
        driver.findElement(laptopsCatLink).click();
        return new LaptopPage(driver);
    }

    public MonitorPage onClickMonitorCat() {
        driver.findElement(monitorsCatLink).click();
        return new MonitorPage(driver);
    }
    public CartPage onClickCartLink() throws InterruptedException {
        driver.findElement(cartLink).click();
        Thread.sleep(1000);
        return new CartPage(driver);
    }
    public void onClickLogOutLink() {
        driver.findElement(logoutLink).click();
    }

}
