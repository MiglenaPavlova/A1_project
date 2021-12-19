package com.shop.a1.project.test;

import com.opencsv.exceptions.CsvException;
import com.shop.a1.project.base.TestUtil;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.DevicesPage;
import utils.CsvReader;

import java.io.IOException;

public class ChooseTabletEshop extends TestUtil {

    @DataProvider(name = "device-data-file")
    public static Object[][] dataProviderFromCsvFile() throws IOException, CsvException {
        return CsvReader.readCsvFile("src/test/resources/deviceTabletData.csv");
    }

    @Test(dataProvider = "device-data-file")
    public void chooseTabletTest(String brand, String model) {

        //1. Go to https://www.a1.bg/bg
        HomePage homePage = new HomePage(driver);

        //2. Click on button "Устройства". Verify that the correct page is loaded
        homePage.clickUstroystvaButton();
        DevicesPage devicesPage = new DevicesPage(driver);
        SoftAssert softAssert = new SoftAssert();
        //softAssert.assertEquals(ustroystvaPage.checkUstroystvaLoaded(), "Таблети");
        //Reporter.log("The page Устройства is loaded");
        String strUrl = driver.getCurrentUrl();
        softAssert.assertEquals(strUrl, "https://www.a1.bg/ustroystva");
        Reporter.log("The page Устройства is loaded");
        System.out.println("The correct page for devices is loaded:"+ strUrl);

        //3. Click on "Таблети"
        devicesPage.clickTapletsButton();

        //4. Click on "Apple iPad Pro 12,9'' (5th Gen)"
        devicesPage.clickOnSelectedTablet();

        //5. Verify that the correct device is displayed.
        softAssert.assertEquals(devicesPage.checkTheTabletSelected(), "iPad Pro 12,9'' (5th Gen)");
        Reporter.log("The correct device is opened");

        softAssert.assertAll();

    }

}
