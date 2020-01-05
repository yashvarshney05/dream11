package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.CreateTeamPage;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateTeamSteps extends ScenarioSteps {

     CreateTeamPage createTeamPageObj;

    @Step("Click on Next button")
    public void click_on_next_button()
    {
        assertThat(createTeamPageObj.clickOnNext()).overridingErrorMessage("next button is not enabled").isTrue();

    }
    @Step("Add a wicket keeper")
    public void add_wicket_keeper(int playerCount)
    {
        createTeamPageObj.addWicketKeeper(playerCount);
    }
    @Step("click on batsman tab")
    public void click_on_batsman_lbl()
    {
        assertThat(createTeamPageObj.clickONBatsLabel()).overridingErrorMessage("batsman label disabled").isTrue();
    }
    @Step("add 3 batsman")
    public void add_four_batsMan(int playerCount)
    {
        createTeamPageObj.addBatsMan(playerCount);
    }
    @Step("click on all rounder label")
    public void click_on_all_round_label()
    {
        createTeamPageObj.clickOnARLbl();
    }
    @Step("add 3 all rounder")
    public void add_all_rounders(int playerCount)
    {
        createTeamPageObj.addAllRounders(playerCount);
    }
    @Step("click on bowler label")
    public void click_on_bowler_lbl()
    {
        createTeamPageObj.clickOnBowLbl();
    }
    @Step("add 3 bowlers")
    public void add_bowlers(int playerCount)
    {
        createTeamPageObj.addBowlers(playerCount);
    }
    @Step("Click on continue button")
    public void click_on_continue_button()
    {
        createTeamPageObj.clickOnContinue();
    }
    @Step("Click on caption")
    public void click_on_caption()
    {
        createTeamPageObj.selectCaption();
    }
    @Step("click on vice caption")
    public void click_on_vice_caption()
    {
        createTeamPageObj.selectViceCaption();
    }

}
