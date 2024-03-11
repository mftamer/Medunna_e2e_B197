package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;

import static baseurl.Medunna_BaseUrl.setUp;

public class Hooks {

    @Before ("@api")
    public void beforeApi(){
        setUp();

    }

    @After
    public void tearDown(Scenario scenario){
       // System.out.println("After hooks");
        if (scenario.isFailed()){
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshot of failed step");
            Driver.closeDriver();
        }

    }


}