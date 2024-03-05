package stepdefinitions.api;

import baseurl.Medunna_BaseUrl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GetRequestStepDefs extends Medunna_BaseUrl {

    Response response;

    @Given("Admin sends GET request for all rooms")
    public void admin_sends_get_request_for_all_rooms() {

        //Set the url
        spec.
                pathParams("first","api","second","rooms").
                queryParam("sort","CreatedDate,desc");

        //Set the expected data
        //Send request and get response
        response = given(spec).when().get("{first}/{second}");
        response.prettyPrint();


    }
    @Then("verify the room is created")
    public void verify_the_room_is_created() {
        //Do assertions
        response.then().statusCode(200);
    }

}
