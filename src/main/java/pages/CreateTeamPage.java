package pages;

import core.BasePageObject;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.event.KeyEvent;
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

    public void addWicketKeeper(int playerCount) {
        points.click();
        points.click();
        addPlayers(playerCount);

    }

    public boolean clickONBatsLabel() {
        if (batsManLabel.isDisplayed()) {
            batsManLabel.click();
            return true;
        }
        return false;
    }

    public void clickOnBatsManlbl() {
        batsManLabel.click();
    }

    public void addBatsMan(int playerCount) {
        addPlayers(playerCount);
    }

    public void clickOnARLbl() {
        allRounderLbl.click();
    }

    public void addAllRounders(int playerCount) {
        addPlayers(playerCount);
    }

    public void clickOnBowLbl() {
        bowlerLbl.click();
    }

    public void addBowlers(int playerCount) {
        addPlayers(playerCount);
    }

    public void clickOnContinue() {
        continueBtn.click();
    }

    public void selectCaption() {
        caption.click();
    }

    public void selectViceCaption() {
        viceCaption.click();
    }


    public void addPlayers(int playerCount) {
        scrollToTopOfPage();
        int count = 0, enable_count = 0;
        boolean result = false;
        do {
            try {
                String finalXpath = getFormattedLocator(wicketKeeper, String.valueOf(count));
                System.out.println("finalXpath from bowlers" + finalXpath);
                WebElement webElement = getDriver().findElement(By.xpath(finalXpath));
                result = true;
                if (result == true && webElement.isDisplayed() && webElement.isEnabled()) {
                    System.out.println("inside this..");
                    Actions action = new Actions(getDriver());
                    action.moveToElement(webElement).click().perform();
                    ++enable_count;
                    ++count;
                    if(enable_count>=3)
                        scrollingToBottomofAPage();
                    System.out.println("enable_count==" + enable_count);
                    continue;
                }
            } catch (NoSuchElementException nse) {
                ++count;
                scrollingToBottomofAPage();
                continue;
            } catch (StaleElementReferenceException sle) {
                System.out.println("inside this..stale");
                continue;
            }
        } while (enable_count != playerCount);
    }

}
