package com.yavlena.app.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrokersPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    By _BrokerFullName = By.xpath("/html/body/div[3]/div[1]/div[3]/div/div[2]/a[1]/h6");
    By _KeyWord = By.id("broker-keyword");
    By _AcceptCookies = By.xpath("/html/body/div[5]/button");
    By _BrokerAddress = By.xpath("/html/body/div[3]/div/div/div/div[2]/div/div/div/div/div[1]/span");
    By _PhoneNumber = By.xpath("/html/body/div[3]/div/div/div/div[2]/div/div/div/div/div[2]/a");
    By _ExpandContactDetails = By.className("body > div.MuiBox-root.mui-style-5tuxm3 > div > div > div > div.MuiCardContent-root.mui-style-q8glis > div > button");

    String StoreBrokerName = null;

    // Constructor
    public BrokersPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    @Step("Open Yavlena app")
    public void OpenYavlena(){
        driver.get("https://www.yavlena.com/en/broker?city=Sofia");
    }

    @Step("Accept Cookies")
    public void AcceptCookies() {
        wait.until(ExpectedConditions.elementToBeClickable(_AcceptCookies)).click();
    }

    @Step("Select Broker Full Name")
    public void SelectBrokerName() {
        StoreBrokerName = wait.until(ExpectedConditions.elementToBeClickable(_BrokerFullName)).getText();
    }

    @Step("Search Broker")
    public void FindBroker() {
        wait.until(ExpectedConditions.elementToBeClickable(_KeyWord)).sendKeys(StoreBrokerName);
    }

    @Step("Verify a broker address is displayed")
    public boolean IsBrokerAddressDisplayed() {
        return wait.until(ExpectedConditions.elementToBeClickable(_BrokerAddress)).isDisplayed();
    }

    @Step("Verify a broker phone is displayed")
    public boolean IsBrokerPhoneDisplayed() {
        return wait.until(ExpectedConditions.elementToBeClickable(_PhoneNumber)).isDisplayed();
    }

    @Step("Expand broker details ")
    public void ExpandBrokerDetails() {
        wait.until(ExpectedConditions.elementToBeClickable(_ExpandContactDetails)).click();
    }


}
