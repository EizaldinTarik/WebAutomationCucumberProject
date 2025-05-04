package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {
    WebDriver driver;
    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }
    //Locators
    private By usernameBox = By.id("sign-username");
    private By passwordBox = By.id("sign-password");
    private By registerButton = By.xpath("//button[@onclick = \"register()\"]");
    //Actions
    public void insertUsername(String username) {
        driver.findElement(usernameBox).sendKeys(username);
    }
    public void insertPassword(String password) {
        driver.findElement(passwordBox).sendKeys(password);
    }
    public void onClickRegisterButton() throws InterruptedException {
        driver.findElement(registerButton).click();
        Thread.sleep(2000);
    }
    public String getSignUpAlertMessage() {
        String text = driver.switchTo().alert().getText();
        return text;
    }
    public void acceptSignUpAlertMessage() throws InterruptedException {
        driver.switchTo().alert().dismiss();
    }

}
