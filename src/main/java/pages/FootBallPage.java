package pages;
import core.BasePageObject;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;

public class FootBallPage extends BasePageObject {
    @FindBy(xpath = "//div[contains(text(),'football')]")
    private WebElementFacade footBallLbl;
    @FindBy(xpath = "//div[contains(text(),'DEF')]")
    private WebElementFacade  defLbl;
    @FindBy(xpath = "//div[contains(text(),'MID')]")
    private  WebElementFacade midLbl;
    @FindBy(xpath = "//div[contains(text(),'ST')]")
    private  WebElementFacade stLbl;

    public boolean clickOnFootBall()
    {
        if(footBallLbl.isDisplayed())
        {
            footBallLbl.click();
            return true;
        }
        return false;
    }

    public void clickOnDef()
    {
        defLbl.click();
    }
    public void clickOnMid()
    {
        midLbl.click();
    }
    public void clickOnSt()
    {
        stLbl.click();
    }

}
