package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    //Locators
    private By loginUsernameBox = By.id("loginusername");
    private By loginPasswordBox = By.id("loginpassword");
    private By loginButton = By.xpath("//button[@onclick = \"logIn()\"]");
    private By verifyLogin = By.id("nameofuser");
    private By closeButton = By.cssSelector(".btn.btn-secondary");
    //Actions
    public void insertLoginUsername(String username) {
        driver.findElement(loginUsernameBox).sendKeys(username);
    }
    public void insertLoginPassword(String password) {
        driver.findElement(loginPasswordBox).sendKeys(password);
    }
    public void onClickLoginButton() throws InterruptedException {
        driver.findElement(loginButton).click();
        Thread.sleep(2000);
    }
    public String verifyLogin() {
        String text = driver.findElement(verifyLogin).getText();
        return text;
    }

    public String getLoginAlertMessage() {
        String text = driver.switchTo().alert().getText();
        return text;
    }

    public void acceptLoginAlertMessage() throws InterruptedException {
        driver.switchTo().alert().dismiss();
    }

    public void onclickCloseButton() {
        driver.findElement(closeButton).click();
    }

}
