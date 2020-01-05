package tests;

import common.BaseCase;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import steps.*;
import utils.CommonUtils;

public class FootballTest extends BaseCase {
    @Steps
    CricketPageSteps cricketPageStepsObj;
    @Steps
    HomePageSteps homePageStepsObj;
    @Steps
    CreateTeamSteps createTeamStepsObj;
    @Steps
    SelectCAndVCSteps selectCAndVCStepsObj;
    @Steps
    FootBallSteps footBallStepsObj;

    @Test
    public void VerifyFootBallPage()
    {
        int gk_count=1, def_count=4, mid_count=3, st_count=3;
        String home_page_url = CommonUtils.getBaseUrl();
        homePageStepsObj.open_home_page(home_page_url);
        cricketPageStepsObj.click_on_football_lbl();
        cricketPageStepsObj.verify_left_team_name_is_displayed();
        cricketPageStepsObj.verify_time_displayed();
        cricketPageStepsObj.verify_right_team_name_is_displayed();
        cricketPageStepsObj.click_on_first_upcoming_match();
        createTeamStepsObj.click_on_next_button();
        createTeamStepsObj.add_wicket_keeper(gk_count);
        footBallStepsObj.click_on_def();
        createTeamStepsObj.add_four_batsMan(def_count);
        footBallStepsObj.click_on_mid();
        createTeamStepsObj.add_all_rounders(mid_count);
        footBallStepsObj.click_on_st();
        createTeamStepsObj.add_bowlers(st_count);
        createTeamStepsObj.click_on_continue_button();
        selectCAndVCStepsObj.verify_caption_is_selected();
        selectCAndVCStepsObj.verify_vice_caption_is_selected();
        selectCAndVCStepsObj.user_click_on_save_button();
        selectCAndVCStepsObj.click_on_got_it_lbl();
        selectCAndVCStepsObj.verify_contest_count();
    }
}
