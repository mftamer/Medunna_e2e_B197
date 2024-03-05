package stepdefinitions.ui;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import org.openqa.selenium.support.ui.Select;
import pages.LoginPage;
import pages.RoomPage;
import utilities.BrowserUtils;
import utilities.WaitUtils;

public class RoomCreationStepDefs {

    public static int roomNumber;
    public static String roomIdStr;
    LoginPage loginPage = new LoginPage();
    RoomPage roomPage = new RoomPage();


    @When("admin clicks on Items&Titles button")
    public void admin_clicks_on_items_titles_button() {
        loginPage.itemsdAndTitles.click();
    }
    @When("clicks on Room option")
    public void clicks_on_room_option() {
        loginPage.roomOption.click();
    }
    @When("clicks on Create A New Room button")
    public void clicks_on_create_a_new_room_button() {
        loginPage.createANewRoom.click();
    }
    @When("enters roomNumber into Rooom Number field")
    public void enters_room_number_into_rooom_number_field() {
        roomNumber = Faker.instance().number().numberBetween(10000,100000);
        roomPage.roomNumberInput.sendKeys(roomNumber+""); //add concatenation because sendKeys is the string
    }
    @When("chooses {string} from the dropdown")
    public void chooses_from_the_dropdown(String string) {
        Select select = new Select(roomPage.roomTypeDropDown);
        select.selectByIndex(1);
    }
    @When("clicks on Status box")
    public void clicks_on_status_box() {
        roomPage.statusCheckbox.click();
    }
    @When("enters {string} into Price field")
    public void enters_into_price_field(String price) {
        roomPage.priceInput.sendKeys(price);
    }
    @When("enters {string} into Description field")
    public void enters_into_description_field(String description) {
        roomPage.descriptionInput.sendKeys(description);
    }
    @When("clicks on Save button")
    public void clicks_on_save_button() {
        roomPage.saveSubmitButton.click();
    }
    @Then("verify the new room is created")
    public void verify_the_new_room_is_created() {
        WaitUtils.waitForVisibility(roomPage.alertMessage,5);
        BrowserUtils.verifyElementDisplayed(roomPage.alertMessage);

        roomIdStr = roomPage.alertMessage.getText().replaceAll("[^0-9]", "");


    }

}