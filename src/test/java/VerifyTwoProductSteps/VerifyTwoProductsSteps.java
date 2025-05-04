package VerifyTwoProductSteps;

import BaseSteps.Hooks;
import Pages.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Objects;

public class VerifyTwoProductsSteps {

    WebDriver driver = Hooks.getDriver();
    HomePage homePage = new HomePage(driver);
    LoginPage loginPage = new LoginPage(driver);
    LaptopPage laptopPage = new LaptopPage(driver);
    MonitorPage monitorPage = new MonitorPage(driver);
    CartPage cartPage = new CartPage(driver);
    CheckOutPage checkOutPage = new CheckOutPage(driver);


    @Given("user enter homepage and login with valid username {string} and valid password {string} and wait for successful message")
    public void user_enter_homepage_and_login_with_valid_username_and_valid_password_and_wait_for_successful_message(String username, String password) throws InterruptedException {
        homePage.onClickLoginLink();
        loginPage.insertLoginUsername(username);
        loginPage.insertLoginPassword(password);
        loginPage.onClickLoginButton();
        String expectedResult = loginPage.verifyLogin();
        String actualResult = "Welcome Eizaldint";
        Assert.assertTrue(expectedResult.contains(actualResult));
    }

    @When("user enter laptop categories and add item to cart and then enter monitor categories and add item to cart")
    public void user_enter_laptop_categories_and_add_item_to_cart_and_then_enter_monitor_categories_and_add_item_to_cart() throws InterruptedException {
        homePage.onClickLaptopCat();
        laptopPage.onClickLaptopItem();
        laptopPage.AddToCart();
        String expectedResult = laptopPage.verifyAlertMessageAdded();
        String actualResults = "Product added.";
        Assert.assertTrue(expectedResult.contains(actualResults));
        laptopPage.acceptAlertMessage();
        laptopPage.navToHomePage();
        homePage.onClickMonitorCat();
        monitorPage.onClickMonitorItem();
        monitorPage.AddToCart();
        expectedResult = monitorPage.verifyAlertMessageAdded();
        actualResults = "Product added.";
        Assert.assertTrue(expectedResult.contains(actualResults));
        monitorPage.acceptAlertMessage();
        monitorPage.navToHomePage();
    }

    @Then("user enter cart and compare prices with total and press purchase and user enter info to proceed")
    public void user_enter_cart_and_compare_prices_with_total_and_press_purchase_and_user_enter_info_to_proceed() throws InterruptedException {
        homePage.onClickCartLink();
        cartPage.setCheckItemName1();
        cartPage.setCheckItemPrice1();
        cartPage.setCheckItemName2();
        cartPage.setCheckItemPrice2();
        String expectedResult = cartPage.setTotalPrice();
        String actualResult = "1190";
        Assert.assertTrue(expectedResult.contains(actualResult));
        cartPage.onClickPlaceOrder();
        checkOutPage.setCheckOutName("Eizaldin");
        checkOutPage.setCheckOutCity("Cairo");
        checkOutPage.setCheckOutCountry("Egypt");
        checkOutPage.setCheckOutYear("1999");
        checkOutPage.setCheckOutCard("1234");
        checkOutPage.setCheckOutMonth("April");
        checkOutPage.onClickPurchaseButton();

        expectedResult = checkOutPage.VerifyPurchaseMessage();
        actualResult = "Thank you for your purchase!";
        Assert.assertTrue(expectedResult.contains(actualResult));
        checkOutPage.onClickAcceptVerifyMessage();
    }

    @Given("user enter homepage and click on login")
    public void user_enter_homepage_and_click_on_login() throws InterruptedException {
        homePage.onClickLoginLink();
    }

    @When("user enter invalid username {string} and invalid password {string} and press login")
    public void user_enter_invalid_username_and_invalid_password_and_press_login(String invalidUsername, String invalidPassword) throws InterruptedException {
        loginPage.insertLoginUsername(invalidUsername);
        loginPage.insertLoginPassword(invalidPassword);
        loginPage.onClickLoginButton();
    }

    @Then("an error message is displayed")
    public void an_error_message_is_displayed() throws InterruptedException {
        String expectedResult = loginPage.getLoginAlertMessage();
        String actualResult = "User does not exist.";
        Assert.assertTrue(expectedResult.contains(actualResult));
        loginPage.acceptLoginAlertMessage();
    }

    @When("user enter laptop categories and add item twice to cart")
    public void user_enter_laptop_categories_and_add_item_twice_to_cart() throws InterruptedException {
        homePage.onClickLaptopCat();
        laptopPage.onClickLaptopItem();
        laptopPage.AddToCart();
        String expectedResult = laptopPage.verifyAlertMessageAdded();
        String actualResult = "Product added.";
        Assert.assertTrue(expectedResult.contains(actualResult));
        laptopPage.acceptAlertMessage();
        laptopPage.AddToCart();
        expectedResult = laptopPage.verifyAlertMessageAdded();
        actualResult = "Product added.";
        Assert.assertTrue(expectedResult.contains(actualResult));
        laptopPage.acceptAlertMessage();
        laptopPage.navToHomePage();
    }

    @Then("user click on cart and item added twice")
    public void user_click_on_cart_and_item_added_twice() throws InterruptedException {
        homePage.onClickCartLink();
        String expectedResults1 = cartPage.setCheckItemName1();
        String expectedResults2 = cartPage.setCheckItemName2();
        if (Objects.equals(expectedResults1, expectedResults2)) {
            Assert.assertEquals(expectedResults1, expectedResults2);
        }
    }
}
