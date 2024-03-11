package stepdefinitions.db;

import RoomPojo.RoomPojo;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.sql.*;

import static org.junit.Assert.assertEquals;
import static stepdefinitions.ui.RoomCreationStepDefs.roomIdStr;
import static stepdefinitions.ui.RoomCreationStepDefs.roomNumber;

public class DbStepDefs {

    Connection connection;
    ResultSet resultSet;
    RoomPojo expectedData;

    @Given("Admin connects to the database")
    public void admin_connects_to_the_database() throws SQLException {

        connection = DriverManager.getConnection("jdbc:postgresql://medunna.com:5432/medunna_db_v2","select_user","Medunna_pass_@6");

    }
    @When("admin executes query for the room")
    public void admin_executes_query_for_the_room() throws SQLException {

        Statement statement = connection.createStatement();

        String query = "SELECT * FROM room WHERE id = "+roomIdStr;
        resultSet = statement.executeQuery(query);

    }
    @Then("validate created room from the resultset")
    public void validate_created_room_from_the_resultset() throws SQLException {

        resultSet.next();
        String actualRoomNum = resultSet.getString("room_number");
        System.out.println("actualRoomNum = " + actualRoomNum);

        String actualRoomType = resultSet.getString("room_type");
        String actualStatus = resultSet.getString("status");
        String actualPrice = resultSet.getString("price");
        String actualDescription = resultSet.getString("description");

        //De-Serialization
        expectedData = new RoomPojo(roomNumber, "DELUXE", true, 1400,"SeaView");

        assertEquals(expectedData.getRoomNumber()+"",actualRoomNum+"");
        assertEquals(expectedData.getRoomType(),actualRoomType);
        assertEquals(expectedData.isStatus()+"",actualStatus+"rue");
        assertEquals(expectedData.getPrice()+".00",actualPrice);
        assertEquals(expectedData.getDescription(),actualDescription);

    }


}
