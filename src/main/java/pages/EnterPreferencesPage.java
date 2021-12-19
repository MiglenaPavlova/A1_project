package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.JavascriptExecutor;

public class EnterPreferencesPage extends BasePage {

    @FindBy(id = "priceTag-2")
    private WebElement PriceButton;

    @FindBy(id = "plate")
    private WebElement inputCarNumber;


    @FindBy(xpath = "//*[@id='startFrom']")
    private WebElement inputDate;

    @FindBy(xpath = "//*[@class=' ui-datepicker-week-end ui-datepicker-days-cell-over  ui-datepicker-today']")
    private WebElement todayDate;

    @FindBy(xpath = "//*[@class='button arrowright']")
    private WebElement nextButton;


    public EnterPreferencesPage(WebDriver driver) {
        super(driver);
    }

    public void clickPriceButton() {
        PriceButton.click();
    }

    public void enterCarNumber(String carNumber) {
        inputCarNumber.sendKeys(carNumber);
    }

    public void enterDate() {
        ((JavascriptExecutor) driver).executeScript("scroll(0,400)");
        inputDate.click();
        todayDate.click();

    }


    public void clickNextButton() {
        nextButton.click();
    }


}

