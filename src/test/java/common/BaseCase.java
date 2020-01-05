package common;

import listeners.TestRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.StepEventBus;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.CommonUtils;


import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

@RunWith(TestRunner.class)
public class BaseCase
{
    private static final Logger logger = LoggerFactory.getLogger(BaseCase.class);

    @Managed(uniqueSession = true)
    protected WebDriver driver;

    @ManagedPages(defaultUrl = "https://www.dream11.com/leagues")
    protected Pages pages;

    @Before
    public void initializationBeforeTest()
    {
        dumpBrowserInfo();

        logger.info("Clearing ALL Cookies ...");

        driver.manage().deleteAllCookies();

        //Additional check to make sure to delete all the cookies
        driver.manage().getCookies().clear();

        String testName = StepEventBus.getEventBus().getBaseStepListener().getTestOutcomes().get(0).getName();
        logger.info("Starting test : {}", testName);

        driver.manage().timeouts().implicitlyWait(CommonUtils.getImplicitTimeoutInSecs(), TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(CommonUtils.getExplicitTimeoutInSecs(), TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(CommonUtils.getExplicitTimeoutInSecs(), TimeUnit.SECONDS);
    }

    @After
    public void dumpTestState()

    {
        WebDriver driverInstance = driver;
        if (driver instanceof WebDriverFacade)
        {
            WebDriverFacade driverFacade = (WebDriverFacade) driver;
            driverInstance = driverFacade.getProxiedDriver();
        }
        logger.info("########## DUMP BROWSER STATE : {} #########", StepEventBus.getEventBus().getBaseStepListener().getTestOutcomes().get(0).getName());
        logger.info("Current URL : {}", driverInstance.getCurrentUrl());

        StepEventBus stepEventBus = StepEventBus.getEventBus();
        if (driverInstance instanceof JavascriptExecutor) {
            if (stepEventBus.aStepInTheCurrentTestHasFailed())
            {
                logger.error("Test failed with following console errors : ");
                List<LogEntry> logEntries = driverInstance.manage().logs().get("browser").getAll();
                for (LogEntry logEntry : logEntries)
                {
                    if (logEntry.getLevel() == Level.SEVERE)
                    {
                        logger.error("--> {}", logEntry.getMessage());
                    }
                }
            }

            dumpCookies();
        }
    }

    private void dumpBrowserInfo()
    {
        if (driver instanceof RemoteWebDriver)
        {
            RemoteWebDriver remoteWebDriver = (RemoteWebDriver) driver;
            Capabilities capabilities = remoteWebDriver.getCapabilities();
            logger.info("Browser details : Name - {}, Version - {}, Platform - {}",
                    capabilities.getBrowserName(), capabilities.getVersion(), capabilities.getPlatform());
            logger.info("GRID Hub UUID : {}", capabilities.getCapability("uuid"));
        }
        else
        {
            String s = (String) ((JavascriptExecutor) driver).executeScript("return navigator.userAgent;");
            logger.info("Browser details : {}", s);
        }
    }

    protected void dumpCookies()
    {
        logger.info("Printing cookies : ");
        Set<Cookie> cookies = driver.manage().getCookies();
        for (Cookie cookie : cookies)
        {
            logger.info(cookie.toString());
        }
    }


}


