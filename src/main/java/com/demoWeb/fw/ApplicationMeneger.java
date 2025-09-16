package com.demoWeb.fw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class ApplicationMeneger {

    WebDriver driver;
    UserRegisterHelper userRegister;
    LoginHelper userLogin;
    AddToCardHelper add;
    HomePageHelper home;
    String browser;

    public ApplicationMeneger(String browser) {
        this.browser = browser;
    }


    public void init() {
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", "C:/Users/belit/Downloads/edgedriver_win64/msedgedriver.exe");
            driver = new EdgeDriver();
        }

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
