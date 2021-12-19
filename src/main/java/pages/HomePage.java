package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {



   @FindBy(xpath = "//*[@class='drop']")
   private  WebElement ustroystvaButton;

    @FindBy(xpath = "//*[@href='/e-vinetki']")
    private  WebElement vignetteButton;

       public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickUstroystvaButton() {
        ustroystvaButton.click();
    }

    public void clickVignetteButton() {
        vignetteButton.click();
    }

}
