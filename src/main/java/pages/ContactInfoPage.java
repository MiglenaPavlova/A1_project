package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactInfoPage extends BasePage {

    @FindBy(xpath = "//*[@id='email']")
    private WebElement inputEmail;

    @FindBy(xpath = "//*[@class='checkbox']")
    private WebElement checkBox;

    @FindBy(xpath = "//*[@class='button arrowright']")
    private WebElement confirmButton;

    public ContactInfoPage(WebDriver driver) {
        super(driver);
    }

    public void enterEmailAddress(String emailAddress) {
        inputEmail.sendKeys(emailAddress);
    }

    public void selectCheckBoxAccept() {
        ((JavascriptExecutor) driver).executeScript("scroll(0,400)");
        checkBox.click();
    }

    public void clickConfirmButton() {

        confirmButton.click();
    }

}
