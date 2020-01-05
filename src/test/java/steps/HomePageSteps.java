package steps;

import core.BasePageObject;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class HomePageSteps extends ScenarioSteps {

    private BasePageObject basePageObj;



    @Step("Open home page")
    public void open_home_page(String url)
    {
        basePageObj.openPageUrl(url);
    }


}
