package com.tivix.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:target/cucumber-report.html",
                "rerun:target/rerun.txt",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber"
        },
        glue = "com/tivix/step_definitions",
        features = "src/test/resources/features",
        tags = "@tivix",
        publish = false,
        dryRun = false




)
//check selenium Grid Hub for available instances to run tests
//to run Selenium/Cucumber - Binaries (Browsers should be installed) and annotations are used to run the test
public class CukeRunner {
}
