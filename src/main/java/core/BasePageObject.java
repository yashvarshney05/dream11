package core;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasePageObject extends PageObject {

    private static final Logger logger = LoggerFactory.getLogger(BasePageObject.class);

    public void openPageUrl(String url)
    {
        try {
            getDriver().get(url);
        }catch(Exception e)
        {
           logger.debug("Not able to launch driver ");
        }

    }
    public void scrollingToBottomofAPage()
    {
        boolean reachedBottom = isBottomReachedNativeJSCheck();
        getJavascriptExecutorFacade().executeScript("window.scrollBy(0,100)", "");

    }
    private boolean isBottomReachedNativeJSCheck()
    {
        return Boolean.parseBoolean(getJavascriptExecutorFacade()
                .executeScript("var body = document.body, html = document.documentElement;" +
                        "var documentHeight = Math.max(body.scrollHeight, body.offsetHeight,  html.clientHeight, html.scrollHeight, html.offsetHeight );" +
                        "var windowHeight = Math.max(html.clientHeight, window.innerHeight || 0);" +
                        "var yOffset = window.pageYOffset || document.documentElement.scrollTop;" +
                        "return documentHeight == (windowHeight + yOffset);").toString());
    }

    public void scrollToTopOfPage()
    {
        getJavascriptExecutorFacade().executeScript("window.scrollTo(Math.max(document.documentElement.scrollHeight,"
                + "document.body.scrollHeight,document.documentElement.clientHeight), 0);");
    }

    public boolean isTopOfPage()
    {
        Object topPageCoordinate = getJavascriptExecutorFacade().executeScript("return window.scrollY;");
        if (topPageCoordinate instanceof Long) {
            Long value=(Long)topPageCoordinate;
            if(value.longValue()==0)
            {
                return true;
            }
        }
        return false;
    }
    public void switchToFrame()
    {
        getDriver().switchTo().frame(0);
    }

    public void switchToFrame(WebElementFacade frameName)
    {
        getDriver().switchTo().frame(frameName);
    }

}
