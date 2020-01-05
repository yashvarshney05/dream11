package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.steps.ScenarioSteps;
import pages.CricketPage;
import pages.FootBallPage;

import static org.assertj.core.api.Assertions.assertThat;

public class CricketPageSteps extends ScenarioSteps {

     CricketPage cricketPageObj;
     FootBallPage footBallPageObj;

    @Step("Verify Right team name")
    public void verify_left_team_name_is_displayed()
    {
        assertThat(cricketPageObj.printLeftTeamName()).overridingErrorMessage("Left team name is not displayed").isTrue();
    }

    @Step("Verify Right team name")
    public void verify_time_displayed()
    {
        assertThat(cricketPageObj.printTimeLeft()).overridingErrorMessage("time left is not displayed").isTrue();
    }

    @Step("Verify Right team name")
    public void verify_right_team_name_is_displayed()
    {
        assertThat(cricketPageObj.printRightTeam()).overridingErrorMessage("Right team name is not displayed").isTrue();
    }

    @Step("Click on first upcoming match")
    public void click_on_first_upcoming_match()
    {
        assertThat(cricketPageObj.clickOnFirstUpcomingMatch()).overridingErrorMessage("first upcoming match is not enabled").isTrue();
    }

    @Step("User click on foot label")
    public void click_on_football_lbl()
    {
        assertThat(footBallPageObj.clickOnFootBall()).overridingErrorMessage("football label is not clickable").isTrue();
    }

}
