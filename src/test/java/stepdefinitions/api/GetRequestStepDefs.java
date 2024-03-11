package stepdefinitions.api;

import RoomPojo.RoomPojo;
import baseurl.Medunna_BaseUrl;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pages.RoomPage;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static stepdefinitions.ui.RoomCreationStepDefs.roomIdStr;
import static stepdefinitions.ui.RoomCreationStepDefs.roomNumber;
import static utilities.ObjectMapperUtils.convertJsonToJava;

public class GetRequestStepDefs extends Medunna_BaseUrl {

    Response response;
    RoomPojo expectedData;

    @Given("Admin sends GET request for all rooms")
    public void admin_sends_get_request_for_all_rooms() {

        //Set the url
        spec.
                pathParams("first","api","second","rooms").
                queryParam("sort","CreatedDate,desc");

        //Set the expected data
        //Send request and get response
        response = given(spec).when().get("{first}/{second}");
        //response.prettyPrint();


    }
    @Then("verify the room is created")
    public void verify_the_room_is_created() {
        //Do assertions
        response.then().statusCode(200);

        JsonPath json = response.jsonPath();
        System.out.println(json.getList("findAll{it.roomNumber == "+roomNumber+"}.id ").get(0));
    }

    @Given("Admin sends GET request for a room by its id")
    public void admin_sends_get_request_for_a_room_by_its_id() {
        //https://medunna.com/api/rooms/113633
        //Set the url
        spec.pathParams("first","api","second","rooms","third",Integer.valueOf(roomIdStr));
        //roomIdStr is a string; therefore, we need to parse it

        //Set the expected data
        expectedData = new RoomPojo(roomNumber,"DELUXE", true, 1400,"SeaView");
        System.out.println("expectedData = " + expectedData);

        //Send request and get response
        response = given(spec).when().get("{first}/{second}/{third}");
        response.prettyPrint();

    }
    @Then("verify response body of the created room")
    public void verify_response_body_of_the_created_room() {
        //Do assertion
        response.then().statusCode(200);

        //De-Serialization
        //Not recommended
        //RoomPojo expectedData = new ObjectMapper().readValue(response.asString(), RoomPojo.class);
        //BEST PRACTICE = ObjectMapper + Pojo
        RoomPojo actualData = convertJsonToJava(response.asString(), RoomPojo.class);

        assertEquals(expectedData.getRoomNumber(),actualData.getRoomNumber());
        assertEquals(expectedData.getRoomType(),actualData.getRoomType());
        assertEquals(expectedData.getDescription(),actualData.getDescription());
        assertEquals(expectedData.getPrice()+".0",actualData.getPrice()+""); //quick solution
        assertEquals(expectedData.isStatus(),actualData.isStatus());



    }


}
