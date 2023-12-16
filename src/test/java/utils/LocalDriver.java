package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LocalDriver {
    private WebDriver driver;

    public LocalDriver() {
        this.driver = new FirefoxDriver();
//        System.setProperty("webdriver.gecko.driver", "C:/Program Files/Mozilla Firefox/geckodriver-v0.8.0-win32/geckodriver.exe");
//        String path = "/home/imolero/drivers/chromedriver/chromedriver";
//        System.setProperty("webDriver.chrome.driver", path);
//        this.driver = new ChromeDriver();
//        this.driver.manage().window().maximize();
    }

    public WebDriver getDriver() {
        return driver;
    }
}