package com.yavlena.app.tests;

import com.yavlena.app.utils.Configuration;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

public class BrokersTest extends Configuration {
    @Test(description = "Search for broker")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Searching for broker")
    @Description("Display the broker profile")
    public void FindBroker() {
        brokersPage.OpenYavlena();
        brokersPage.AcceptCookies();
        brokersPage.SelectBrokerName();
        brokersPage.FindBroker();
    }

    @Test(dependsOnMethods = "FindBroker", description = "Validate the broker profile")
    @Severity(SeverityLevel.NORMAL)
    @Story("Checking broker profile parameters")
    @Description("Broker Profile validation")
    public void ValidateBroker() {
        brokersPage.ExpandBrokerDetails();
        brokersPage.IsBrokerAddressDisplayed();
        brokersPage.IsBrokerPhoneDisplayed();
    }
}
