package com.tivix.step_definitions;

import com.github.javafaker.Faker;
import com.tivix.pages_POM.LandingPage;
import com.tivix.utilities.ConfigurationReader;
import com.tivix.utilities.Driver;
import io.restassured.RestAssured;
import org.junit.Test;

import java.util.Date;

public class TestRun {
    @Test
    public void test() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        Faker faker = new Faker();
        LandingPage lp = new LandingPage();
        lp.pickUpInput.sendKeys("06252022");
        lp.dropOffInput.sendKeys("07302022");
    }
}
