package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.FootBallPage;

public class FootBallSteps extends ScenarioSteps {
    FootBallPage footBallPageObj;

    @Step("User click on def")
    public void click_on_def()
    {
        footBallPageObj.clickOnDef();
    }

    @Step("user click on mid")
    public void click_on_mid()
    {
        footBallPageObj.clickOnMid();
    }
    @Step("user clicks on st")
    public void click_on_st()
    {
        footBallPageObj.clickOnSt();
    }
}
