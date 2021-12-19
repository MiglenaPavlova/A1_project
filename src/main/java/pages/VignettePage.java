package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class VignettePage extends BasePage {

    @FindBy(xpath = "//*[@href='https://www.a1.bg/e-vignette-bg/mc/index/ma/index/mo/1/']")
    private WebElement BuyHereButton;

    public VignettePage(WebDriver driver) {
        super(driver);
    }

    public void clickBuyHereButton() {
        BuyHereButton.click();
    }


}
