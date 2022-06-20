package com.tivix.step_definitions;

import com.github.javafaker.Faker;
import com.tivix.pages_POM.LandingPage;
import com.tivix.utilities.ConfigurationReader;
import com.tivix.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class test_step_defs {
    LandingPage lp = new LandingPage();

    @And("user is landing page")
    public void userIsLandingPage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
    }
    String expectedCountry;
    @When("user selects country {string}")
    public void user_selects_country(String countryName) {
        lp.selectCountry(countryName);
        expectedCountry = countryName;
    }
    String expectedCity;
    @When("user selects city {string}")
    public void user_selects_city(String cityName) {
        lp.selectCity(cityName);
        expectedCity = cityName;
    }

    @When("user selects valid future date for pick-up")
    public void user_selects_valid_future_date_for_pick_up() {
        lp.pickUpInput.sendKeys("06292022");
    }

    @When("user selects valid future date for drop-off")
    public void user_selects_valid_future_date_for_drop_off() {
       lp.dropOffInput.sendKeys("07302022");
    }


    @And("user selects any car and click Search")
    public void userSelectsAnyCarAndClickSearch() {
        lp.searchButton.click();
    }



    String selectedCompanyName;
    String selectedLicensePlate;
    String selectedPricePerDay;

    @When("user clicks on row {int} to rent")
    public void user_clicks_on_row_to_rent(int rowNum) {
        selectedCompanyName = lp.companyNameColumn.getText();
        selectedLicensePlate = lp.licensePlateColumn.getText();
        selectedPricePerDay = lp.pricePerDayColumn.getText();

        lp.clickOnRowRent(rowNum);


    }

    String summaryPricePerDay;
    String summaryLocation;
    String summaryLicensePlate;

    @When("user can see Summary of rental")
    public void user_can_see_summary_of_rental() {
        summaryPricePerDay = lp.pricePerDaySummaryInfo.getText();
        Assert.assertTrue(summaryPricePerDay.contains(selectedPricePerDay));
        summaryLocation = lp.locationSummaryInfo.getText();
        Assert.assertTrue(summaryLocation.contains(expectedCity));
        Assert.assertTrue(summaryLocation.contains(expectedCountry));
        summaryLicensePlate = lp.licensePlateSummaryInfo.getText();
        Assert.assertTrue(summaryLicensePlate.contains(selectedLicensePlate));
        lp.rentButtonSummaryInfo.click();

    }

    @When("user enters first name, last name, card number, email")
    public void user_enters_first_name_last_name_card_number_email() {
        Faker faker = new Faker();
        lp.customerName.sendKeys(faker.name().firstName());
        lp.customerLastName.sendKeys(faker.name().lastName());
        lp.customerCardNumber.sendKeys(faker.finance().creditCard());
        lp.customerEmail.sendKeys(faker.internet().emailAddress());
    }

    @Then("user clicks Rent")
    public void user_clicks_rent() {
        lp.rentSummaryPage.click();
    }


    @And("user can see invalid Summary of rental")
    public void userCanSeeInvalidSummaryOfRental() {
       // summaryPricePerDay = lp.pricePerDaySummaryInfo.getText();
       // Assert.assertTrue(summaryPricePerDay.contains(selectedPricePerDay));
        summaryLocation = lp.locationSummaryInfo.getText();
        Assert.assertTrue(summaryLocation.contains(expectedCity));
        Assert.assertFalse(summaryLocation.contains(expectedCountry));
        summaryLicensePlate = lp.licensePlateSummaryInfo.getText();
        Assert.assertTrue(summaryLicensePlate.contains(selectedLicensePlate));
        lp.rentButtonSummaryInfo.click();
    }

    @And("user selects invalid date for pick-up")
    public void userSelectsInvalidDateForPickUp() {
        lp.pickUpInput.sendKeys("06152022");
    }

    @And("user selects invalid date for drop-off")
    public void userSelectsInvalidDateForDropOff() {
        lp.dropOffInput.sendKeys("06162022");
    }
}
