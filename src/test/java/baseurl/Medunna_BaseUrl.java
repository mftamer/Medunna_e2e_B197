package baseurl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

import static utilities.MedunnaAuthentication.generateToken;

public class Medunna_BaseUrl {

    protected RequestSpecification spec;

    @Before
    public void setUp(){

        String baseUrl = "https://medunna.com";
        spec = new RequestSpecBuilder().
                addHeader("Authorization","Bearer"+generateToken()).
                setBaseUri(baseUrl).
                setContentType(ContentType.JSON).
                build();
    }
}
