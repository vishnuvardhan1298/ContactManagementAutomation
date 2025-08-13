package com.cm.tests.base;

import com.cm.framework.utils.TestData;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class BaseTest {
    protected WebDriver driver;
    protected String baseUrl;

    @BeforeClass(alwaysRun = true)   // runs once before all tests in the class
    @Parameters({"browser"})
    public void setup(@Optional("chrome") String browser) {
        baseUrl = TestData.get("base.url");
        if (baseUrl == null || baseUrl.trim().isEmpty()) {
            throw new RuntimeException("x base.url not found in testdata.properties");
        }

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @AfterClass(alwaysRun = true)   // runs once after all tests in the class
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
