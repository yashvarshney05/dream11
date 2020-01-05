package pages;

import core.BasePageObject;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class CricketPage extends BasePageObject {

    @FindBy(xpath = "//a[@class='js--match-card matchCard_868db'][1]//div[@class='matchCardMain_954a1']")
    private WebElementFacade firstUpcomingMatch;

    @FindBy(xpath = "//a[@class='js--match-card matchCard_868db'][1]//div[@class='squadShortName_a116b squadShortNameLeft_db179']")
    private WebElementFacade teamOnLeft;

    @FindBy(xpath = "//a[@class='js--match-card matchCard_868db'][1]//div[@class='matchCardTimer_a5620 matchCardTimerDesktop_48a55']")
    private WebElementFacade timeLeft;

    @FindBy(xpath = "//a[@class='js--match-card matchCard_868db'][1]//div[@class='squadShortName_a116b squadShortNameRight_42ab0']")
    private WebElementFacade teamOnRight;

    public boolean printLeftTeamName()
    {
        String leftTeamName=teamOnLeft.getText();
        if(leftTeamName==null || leftTeamName.isEmpty())
            return false;
        else
            System.out.println("Left team name=="+leftTeamName);
            return true;
    }

    public boolean printTimeLeft()
    {
        String timeDisplayed=timeLeft.getText();
        if(null==timeDisplayed || timeDisplayed.isEmpty())
            return false;
        else
            System.out.println("time displayed =="+timeDisplayed);
        return true;
    }

    public boolean printRightTeam()
    {
        String rightTeamName=teamOnRight.getText();
        if(null==rightTeamName|| rightTeamName.isEmpty())
            return false;
        else
            System.out.println("rightTeamName=="+rightTeamName);
        return true;
    }

    public boolean clickOnFirstUpcomingMatch()
    {
        if(firstUpcomingMatch.isEnabled()) {
            firstUpcomingMatch.click();
            return true;
        }
        return false;
    }

}
