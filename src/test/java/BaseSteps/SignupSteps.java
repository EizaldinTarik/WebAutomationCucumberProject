package BaseSteps;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.SignUpPage;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SignupSteps {
    Faker faker = new Faker();
    String fakeUsername = faker.name().username() + faker.number().digits(3);
    String fakePassword = faker.internet().password(8, 12, true, true, true);
    WebDriver driver = Hooks.getDriver();
    HomePage homePage = new HomePage(driver);
    SignUpPage signUpPage = new SignUpPage(driver);

    @Given("user enter homepage and Click on the Sign up button in the Header")
    public void user_enter_homepage_and_click_on_the_Sign_up_button_in_the_header() throws InterruptedException {
        homePage.onClickSignUpLink();
    }

    @When("user fill in the username {string} and password {string} and press register")
    public void user_fill_in_the_username_and_password_and_press_register(String username, String password) throws InterruptedException {
        signUpPage.insertUsername(fakeUsername);
        signUpPage.insertPassword(fakePassword);
        signUpPage.onClickRegisterButton();
    }

    @Then("a success message should be displayed")
    public void aSuccessMessageShouldBeDisplayed() throws InterruptedException {
        String expectedResult = signUpPage.getSignUpAlertMessage();
        String actualResult = "Sign up successful.";
        Assert.assertTrue(expectedResult.contains(actualResult));
        signUpPage.acceptSignUpAlertMessage();
    }

    @When("user fill in the invalidUsername {string} and invalidPassword {string} and press register")
    public void userFillInTheInvalidUsernameAndInvalidPasswordAndPressRegister(String invalidUsername, String invalidPassword) throws InterruptedException {
        signUpPage.insertUsername(invalidUsername);
        signUpPage.insertPassword(invalidPassword);
        signUpPage.onClickRegisterButton();
    }

    @Then("error message appear")
    public void errorMessageAppear() throws InterruptedException {
        String expectedResult = signUpPage.getSignUpAlertMessage();
        String actualResult = "This user already exist.";
        Assert.assertTrue(expectedResult.contains(actualResult));
        signUpPage.acceptSignUpAlertMessage();
    }
}
