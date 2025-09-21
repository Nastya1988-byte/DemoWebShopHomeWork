package com.demoWeb.fw;

import com.demoWeb.utils.MyListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class ApplicationManager {

    WebDriver driver;
    String browser;
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);

    UserRegisterHelper userRegister;
    LoginHelper userLogin;
    AddToCardHelper add;
    HomePageHelper home;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }


    public void init() {
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
            logger.info("Tests start in Chrome browser");
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
            logger.info("Tests start in Firefox browser");

        } else if (browser.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", "C:/Users/belit/Downloads/edgedriver_win64/msedgedriver.exe");
            driver = new EdgeDriver();
            logger.info("Tests start in Edge browser");
        }
        WebDriverListener listener = new MyListener();
        driver = new EventFiringDecorator<>(listener).decorate(driver);

        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        userRegister = new UserRegisterHelper(driver);
        userLogin = new LoginHelper(driver);
        add = new AddToCardHelper(driver);
        home = new HomePageHelper(driver);
    }

    public void stop() {
        driver.quit();
    }

    public UserRegisterHelper getUserRegister() {
        return userRegister;
    }

    public LoginHelper getUserLogin() {
        return userLogin;
    }

    public AddToCardHelper getAdd() {
        return add;
    }

    public HomePageHelper getHome() {
        return home;
    }
}
