package com.tivix.step_definitions;

import com.tivix.utilities.ConfigurationReader;
import com.tivix.utilities.Driver;
import org.junit.Test;

public class TestRun {
    @Test
    public void test() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
    }
}
