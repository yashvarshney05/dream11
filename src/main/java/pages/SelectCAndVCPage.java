package pages;

import core.BasePageObject;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.List;

public class SelectCAndVCPage extends BasePageObject {

    @FindBy(xpath = "(//div[@class='roleIcon_b2caf'])[1]")
    private WebElementFacade caption;

    @FindBy(xpath = "(//div[@class='roleIcon_b2caf'])[3]")
    private WebElementFacade viceCaption;

    @FindBy(xpath = "//button[contains(text(),'SAVE TEAM')]")
    private WebElementFacade saveTeamBtn;

    @FindBy(xpath = "//a[contains(text(),'GOT IT')]")
    private WebElementFacade gotItLbl;

    @FindBy(xpath = "//div[contains(text(),'Contests')]")
    private List<WebElementFacade> list;

    public void selectCaption()
    {
        caption.click();
    }
    public void selectViceCaption()
    {
        viceCaption.click();
    }

    public void saveTeamBtn()
    {
        saveTeamBtn.click();
    }

    public boolean clickOnGotIt()
    {
        if(gotItLbl.isDisplayed()) {
            gotItLbl.click();
            return true;
        }
        return false;
    }

    public boolean verifyContestCount()
    {
        if(list.size()>5)
            return true;
        return false;
    }
}
