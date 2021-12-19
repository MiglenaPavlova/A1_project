package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfirmationOfTheDataPage extends BasePage {

    @FindBy(xpath = "//table/tbody/tr[1]/td[2]")
    private WebElement carNumber;

    @FindBy(xpath = "//table/tbody/tr[4]/td[2]")
    private WebElement vignetteType;

    @FindBy(xpath = "//table/tbody/tr[8]/td[2]")
    private WebElement vignettePrice;

    @FindBy(xpath = "//*[@onclick='vignettePay();']")
    private WebElement payButton;

    public ConfirmationOfTheDataPage(WebDriver driver) {
        super(driver);
    }

    public String getCarNumber() {
        return carNumber.getText();
    }

    public String getVignetteType() {
        return vignetteType.getText();
    }

    public void clickPayButton() {
        payButton.click();
    }

}
