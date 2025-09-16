package com.demo.tests;

import com.demoWeb.fw.ApplicationMeneger;
import org.openqa.selenium.remote.Browser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class TestBase {

    Logger logger = LoggerFactory.getLogger(TestBase.class);

    protected ApplicationMeneger app = new ApplicationMeneger(System
            .getProperty("browser", Browser.CHROME.browserName()));

    @BeforeMethod
    public void setUP(){
        app.init();
    }

    @AfterMethod(enabled = false)
    public void tearDown(){
        if (app != null) {
            app.stop();
        }
    }

    @BeforeMethod
    public void startTest(Method method){
        logger.info("Start test" + method.getName());
    }

    @AfterMethod
    public void stopTest(ITestResult result){

        if(result.isSuccess()){
            logger.info("PASSED: "+ result.getMethod().getMethodName());
        }else {
            logger.error("FAILED: "+ result.getMethod()
                    .getMethodName()+" Screenshot path: "+ app.getUserLogin()
                    .takeScreenshot());
        }
        logger.info("Stop test");
        logger.info("*********************************************************");
    }
}
