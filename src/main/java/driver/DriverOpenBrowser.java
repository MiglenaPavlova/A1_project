package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class DriverOpenBrowser {
    private static final String IGNORE_CERTIFICATE = "--IGNORE-CERTIFICATE-ERRORS";

    public static WebDriver getChromeDriver(int wait) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments(IGNORE_CERTIFICATE);

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(wait, TimeUnit.SECONDS);
        return driver;

    }

}
