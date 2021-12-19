package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DevicesPage extends BasePage {

    @FindBy(id = "device_type_name_4")
    private WebElement tapletsButton;

    @FindBy(xpath = "//*[@href='/ustroystva/tableti/apple/ipad-pro-129-5th-gen.5462']")
    private WebElement tabletIpadPro;

    @FindBy(xpath = "//*[@itemprop='name']")
    private WebElement selectedTablet;

    public DevicesPage(WebDriver driver) {
        super(driver);
    }

    public String checkUstroystvaLoaded() {
        waitForElement(10, tapletsButton);
        return tapletsButton.getText();
    }

    public void clickTapletsButton() {
        tapletsButton.click();
    }

    public void clickOnSelectedTablet() {
        tabletIpadPro.click();
    }

    public String checkTheTabletSelected() {
        return selectedTablet.getText();
    }

}
