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
        if(getName(teamOnLeft).equalsIgnoreCase("invalid"))
            return  false;
        System.out.println(getName(teamOnLeft));
        return true;
    }

    public boolean printTimeLeft()
    {
        if(getName(timeLeft).equalsIgnoreCase("invalid"))
            return  false;
        System.out.println(getName(timeLeft));
        return true;
    }

    public boolean printRightTeam()
    {
        if(getName(teamOnRight).equalsIgnoreCase("invalid"))
            return  false;
        System.out.println(getName(teamOnRight));
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

    public String getName(WebElementFacade webElementFacade)
    {
        String text=webElementFacade.getText();
        if(text==null || text.isEmpty())
            return "invalid";
        return text;
    }

}
