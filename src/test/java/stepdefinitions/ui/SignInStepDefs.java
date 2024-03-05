package stepdefinitions.ui;

import io.cucumber.java.en.*;
import pages.Homepage;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;

public class SignInStepDefs {
    Homepage homepage = new Homepage();
    LoginPage loginPage = new LoginPage();

    @Given("admin goes to {string} homepage")
    public void admin_goes_to_homepage(String url) {
        Driver.getDriver().get(url);
    }
    @Given("clicks on userIcon")
    public void clicks_on_user_icon() {
        homepage.userIcon.click();
    }
    @Given("clicks on signIn option")
    public void clicks_on_sign_in_option() {
        homepage.signInOption.click();
    }
    @Given("enters username in the Username input field")
    public void enters_username_in_the_username_input_field() {
        loginPage.usernameInput.sendKeys(ConfigReader.getProperty("medunna_username"));
    }
    @Given("enters password in the password input field")
    public void enters_password_in_the_password_input_field() {
        loginPage.passwordInput.sendKeys(ConfigReader.getProperty("medunna_password"));
    }
    @Given("clicks on submit button")
    public void clicks_on_submit_button() {
        loginPage.signInSubmitButton.click();
    }
}