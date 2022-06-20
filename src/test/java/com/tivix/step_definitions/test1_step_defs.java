package com.tivix.step_definitions;

import com.tivix.utilities.ConfigurationReader;
import com.tivix.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class test1_step_defs {
    @When("user goes on {string}")
    public void userGoesOn(String env) {
        env = ConfigurationReader.getProperty("env");
        Driver.getDriver().get(env);
    }

    @Then("title is {string}")
    public void titleIs(String expectedTitle) {
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    }
}
