package com.tivix.pages_POM;

import com.github.javafaker.Faker;
import com.tivix.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class LandingPage {
    public LandingPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//select[@id='country']")
    public WebElement countryDropDown;

    /**
     * method to select country from list by visible text
     * France, Poland, "Germainy"
     */
    public void selectCountry(String countryName) {
        Select countriesList = new Select(this.countryDropDown);
        if (countryName.equalsIgnoreCase("france")) {
            countriesList.selectByVisibleText("France");
        } else if (countryName.equalsIgnoreCase("poland")) {
            countriesList.selectByVisibleText("Poland");
        } else if (countryName.equalsIgnoreCase("germainy")) {
            countriesList.selectByVisibleText("Germainy");
        } else {
            throw new InputMismatchException("Incorrect country");
        }
    }

    /**
     *
     */
    @FindBy(xpath = "//select[@id='city']")
    public WebElement cityDropDown;

    /**
     * method to select city from list by visible text
     * Berlin, Cracow, Paris, Wroclaw
     */
    public void selectCity(String cityName) {
        Select countriesList = new Select(this.cityDropDown);
        if (cityName.equalsIgnoreCase("berlin")) {
            countriesList.selectByVisibleText("Berlin");
        } else if (cityName.equalsIgnoreCase("cracow")) {
            countriesList.selectByVisibleText("Cracow");
        } else if (cityName.equalsIgnoreCase("paris")) {
            countriesList.selectByVisibleText("Paris");
        } else if (cityName.equalsIgnoreCase("wroclaw")) {
            countriesList.selectByVisibleText("Wroclaw");
        } else {
            throw new InputMismatchException("Incorrect city");
        }
    }

    @FindBy(xpath = "//input[@id='model']")
    public WebElement modelTextInput;
    @FindBy(xpath = "//input[@id='pickup']")
    public WebElement pickUpInput;

    /**
     * select random valid date with Java Faker
     * format mm/dd/yyyy
     */



    @FindBy(xpath = "//input[@id='dropoff']")
    public WebElement dropOffInput;


    @FindBy(xpath = "//button[.='Search']")
    public WebElement searchButton;

    /**
     * method for return specific row info or Rent Click
     *
     * @param rowNum
     */
    public void clickOnRowRent(int rowNum) {
        String locator = "//tbody/tr[" + rowNum + "]/td[6]/a[.='Rent']";
        WebElement rowRentButton = Driver.getDriver().findElement(By.xpath(locator));
        rowRentButton.click();
    }


    @FindBy(xpath = "//tbody/tr[1]/td[6]/a[.='Rent']")
    public WebElement rentButtonFromList;

    // company name
    @FindBy(xpath = "//tbody/tr[1]/td[1]")
    public WebElement companyNameColumn;

    // model
    @FindBy(xpath = "//tbody/tr[1]/td[2]")
    public WebElement modelNameColumn;

    // license plate
    @FindBy(xpath = "//tbody/tr[1]/td[3]")
    public WebElement licensePlateColumn;
    // price per day
    @FindBy(xpath = "//tbody/tr[1]/td[5]")
    public WebElement pricePerDayColumn;


    // Summary of order page info
    // Price per day: 63$
    @FindBy(xpath = "//p[contains(text(),'Price per day')]")
    public WebElement pricePerDaySummaryInfo;

    //Location: Poland, Cracow
    @FindBy(xpath = "//p[contains(text(),'Location')]")
    public WebElement locationSummaryInfo;


    // license plate text: License plate: LCE3493
    @FindBy(xpath = "//p[contains(text(),'License')]")
    public WebElement licensePlateSummaryInfo;

    //pick up date :  Pickup date: 2022-06-20

    @FindBy(xpath = "//h6[contains(text(),'Pickup')]")
    public WebElement pickupDateSummaryInfo;


    // dropoff date: Dropoff date: 2022-06-20
    @FindBy(xpath = "//h6[contains(text(),'Dropoff')]")
    public WebElement dropOffDateSummaryInfo;

    //rent summary button
    @FindBy(xpath = "//a[.='Rent!']")
    public WebElement rentButtonSummaryInfo;

    //SUMMARY customer info

    @FindBy(xpath = "//input[@id='name']")
    public WebElement customerName;

    @FindBy(xpath = "//input[@id='last_name']")
    public WebElement customerLastName;


    @FindBy(xpath = "//input[@id='card_number']")
    public WebElement customerCardNumber;

    @FindBy(xpath = "//input[@id='email']")
    public WebElement customerEmail;

    // rent button in summary page


    @FindBy(xpath = "//button[.='Rent']")
    public WebElement rentSummaryPage;

}
