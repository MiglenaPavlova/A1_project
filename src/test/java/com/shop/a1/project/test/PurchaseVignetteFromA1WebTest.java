package com.shop.a1.project.test;

import com.opencsv.exceptions.CsvException;
import com.shop.a1.project.base.TestUtil;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.*;
import utils.CsvReader;

import java.io.IOException;
import java.util.ArrayList;

public class PurchaseVignetteFromA1WebTest extends TestUtil {

    @DataProvider(name = "vignette-data-file")
    public static Object[][] dataProviderFromCsvFile() throws IOException, CsvException {
        return CsvReader.readCsvFile("src/test/resources/vignetteData.csv");
    }


    @Test(dataProvider = "vignette-data-file")
    public void buyVignette(String carNumber, String emailAddress, String vignettePrice) throws InterruptedException {

        String vignetteType = "Лек автомобил до 3,5 тона";

        //1. Go to https://www.a1.bg/bg
        HomePage homePage = new HomePage(driver);
        //2. Click on button "е-Винетка"
        homePage.clickVignetteButton();

        VignettePage vignettePage = new VignettePage(driver);
        //3. Click on button "Купи тук"
        vignettePage.clickBuyHereButton();

        //Navigate to the new tab
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        //4. Choose vehicle "Категория 3 - лек автомобил"
        NewTabVignettePage newTabVignettePage = new NewTabVignettePage(driver);
        newTabVignettePage.clickSelectCarButton();

        EnterPreferencesPage enterPreferencesPage = new EnterPreferencesPage(driver);
        //5. Choose period – 10 лв. уикенд
        enterPreferencesPage.clickPriceButton();

        //6. Fill in registration number "CA1234BТ"
        enterPreferencesPage.enterCarNumber(carNumber);
        Thread.sleep(4000);//not te best solution, but I couldn't not make explicitwait working

        //7. Choose Today's date.
        enterPreferencesPage.enterDate();
        Thread.sleep(4000);//not te best solution, but I couldn't make explicitwait working

        //8. Click button "Продължи"
        enterPreferencesPage.clickNextButton();

        ContactInfoPage contactInfoPage = new ContactInfoPage(driver);

        //9. Enter email address (compulsory, might not be a real address), do not enter mobile number
        contactInfoPage.enterEmailAddress(emailAddress);

        //10. Mark "Съгласен съм с Общите условия" checkbox
        contactInfoPage.selectCheckBoxAccept();

        //11. Click button "Продължи"
        contactInfoPage.clickConfirmButton();
        Thread.sleep(5000);//not te best solution, but I couldn't make explicitwait working

        //12. Verify the data on the screen: correct registration number and vignette type
        ConfirmationOfTheDataPage confirmInformationPage = new ConfirmationOfTheDataPage(driver);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(confirmInformationPage.getCarNumber(), carNumber);
        Reporter.log("The car number is correct" + carNumber);
        softAssert.assertEquals(confirmInformationPage.getVignetteType(), vignetteType);
        Reporter.log("Type is checked " + vignetteType);

        //13. Click button "Продължи
        confirmInformationPage.clickPayButton();

        Thread.sleep(5000);//not te best solution, but I couldn't make explicitwait working

        //14. Verify that the Borica page - "Покупка на винетка" is opened
        String strUrl = driver.getCurrentUrl();
        softAssert.assertEquals(strUrl, "https://3dsgate.borica.bg/cgi-bin/cgi_link");
        System.out.println("Current Url is:"+ strUrl);
        softAssert.assertAll();



/* Взима автоматично датата от системата в зададен формат
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.YYYY");
        //get current date time with Date()
        Date date = new Date();
        // Now format the date
        String date1= dateFormat.format(date);
        // Print the Date
        //System.out.println(date1);

 */

    }
}
