package pages;

import core.BasePageObject;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.StaleElementReferenceException;

import java.util.List;

public class CreateTeamPage extends BasePageObject {
    String wicketKeeper = "//div[@class='js--create-team__team-selector__player-card onboarding--player-card-%s playerCard_42b9d']//div[@class='bold playerCardIconContainer_65be8']";

    @FindBy(xpath = "//a[@class='shepherd-button ']")
    private WebElementFacade nextBtn;

    @FindBy(xpath = "//a[contains(text(),'NEXT')]")
    private WebElementFacade balanceTeamNext;

    @FindBy(xpath = "//a[contains(text(),'GOT IT')]")
    private WebElementFacade gotIt;

    @FindBy(xpath = "//div[contains(text(),'BAT')]")
    private WebElementFacade batsManLabel;

    @FindBy(xpath = "//div[contains(text(),'AR')]")
    private WebElementFacade allRounderLbl;

    @FindBy(xpath = "//div[contains(text(),'BOWL')]")
    private WebElementFacade bowlerLbl;

    @FindBy(xpath = "//span[contains(text(),'POINTS')]")
    private WebElementFacade points;

    @FindBy(xpath = "//button[contains(text(),'CONTINUE')]")
    private WebElementFacade continueBtn;

    @FindBy(xpath = "(//div[@class='roleIcon_b2caf'])[1]")
     private WebElementFacade caption;

    @FindBy(xpath = "(//div[@class='roleIcon_b2caf'])[3]")
    private WebElementFacade viceCaption;

    @FindBy(xpath = "//button[contains(text(),'SAVE TEAM')]")
    private WebElementFacade saveTeamBtn;

    @FindBy(xpath = "//div[contains(text(),'Contests')]")
    private List<WebElementFacade> list;

    public boolean clickOnNext() {
        if (nextBtn.isEnabled()) {
            nextBtn.click();
            balanceTeamNext.click();
            gotIt.click();
            return true;
        }
        return false;
    }

    private String getFormattedLocator(String locator, String value) {
        return String.format(locator, value);
    }

    public void addWicketKeeper() {
        points.click();
        points.click();
        for (int i = 0; i < 2; i++) {

            String finalXpath = getFormattedLocator(wicketKeeper, String.valueOf(i));
            System.out.println("finalXpath from wicket" + finalXpath);
            getDriver().findElement(By.xpath(finalXpath)).click();

        }

    }

    public boolean clickONBatsLabel() {
        if (batsManLabel.isDisplayed()) {
            batsManLabel.click();
            return true;
        }
        return false;
    }

    public void addBatsMan() {
        int batsManCount = 0, count = 0;
        while (batsManCount < 4) {
            try {
                String finalXpath = getFormattedLocator(wicketKeeper, String.valueOf(batsManCount));
                System.out.println("finalXpath==" + finalXpath);
                getDriver().findElement(By.xpath(finalXpath)).click();
                ++batsManCount;
                if (batsManCount == 3)
                    break;
            } catch (ElementClickInterceptedException | StaleElementReferenceException se) {
                scrollToTopOfPage();
                System.out.println("inside catch block" + count);
                continue;
            }
        }


    }

    public void addAllRounders() {
        allRounderLbl.click();
        for (int i = 0; i < 3; i++) {

            String finalXpath = getFormattedLocator(wicketKeeper, String.valueOf(i));
            System.out.println("finalXpath from all rounders" + finalXpath);
            getDriver().findElement(By.xpath(finalXpath)).click();

        }
    }

    public void addBowlers()
    {
        bowlerLbl.click();
        for (int i = 0; i < 3; i++) {

            String finalXpath = getFormattedLocator(wicketKeeper, String.valueOf(i));
            System.out.println("finalXpath from bowler" + finalXpath);
            getDriver().findElement(By.xpath(finalXpath)).click();

        }
    }

    public void clickOnContinue()
    {
        continueBtn.click();
    }
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

}
