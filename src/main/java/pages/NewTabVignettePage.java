package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewTabVignettePage extends BasePage {

    @FindBy(id = "ico1")
    private WebElement selectCarButton;

    public NewTabVignettePage(WebDriver driver) {
        super(driver);
    }

    public void clickSelectCarButton() {
        selectCarButton.click();
    }


}
