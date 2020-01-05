package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.SelectCAndVCPage;

import static org.assertj.core.api.Assertions.assertThat;

public class SelectCAndVCSteps extends ScenarioSteps {
    private SelectCAndVCPage selectCAndVCPageObj;

    @Step("Verify Right team name")
    public void verify_caption_is_selected()
    {
        selectCAndVCPageObj.selectCaption();
    }
    @Step("Verify Right team name")
    public void verify_vice_caption_is_selected()
    {
        selectCAndVCPageObj.selectViceCaption();
    }

    @Step("User click on save team button")
    public void user_click_on_save_button()
    {
        selectCAndVCPageObj.saveTeamBtn();
    }

    @Step("User click on got it label")
    public void click_on_got_it_lbl()
    {
        assertThat(selectCAndVCPageObj.clickOnGotIt()).overridingErrorMessage("got it button is not enabled").isTrue();
    }

    @Step("Verify contest count")
    public void verify_contest_count()
    {
        assertThat(selectCAndVCPageObj.verifyContestCount()).overridingErrorMessage("contest count is less than 5").isTrue();
    }

}
