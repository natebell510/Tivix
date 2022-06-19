package com.tivix.step_definitions;

import com.tivix.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {
    // Hooks class manages conditions before and after test runs
    // If test failed - @After screenshot will be taken
    // @Before - option to set browser with tags in feature file (scenario)

    @Before
    public void setup(Scenario scenario){
        if(scenario.getSourceTagNames().contains("@firefox")){
            Driver.setDriver("firefox");
        }else if(scenario.getSourceTagNames().contains("@chrome")){
            Driver.setDriver("chrome");
        } else if(scenario.getSourceTagNames().contains("@opera")){
            Driver.setDriver("opera");
        }else if(scenario.getSourceTagNames().contains("@edge")) {
            Driver.setDriver("edge");
        }

    }



    @After
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            byte [] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png", scenario.getName());
        }
        Driver.closeDriver();
    }
}
