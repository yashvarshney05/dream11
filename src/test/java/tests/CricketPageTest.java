package tests;

import common.BaseCase;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import steps.CreateTeamSteps;
import steps.CricketPageSteps;
import steps.HomePageSteps;
import steps.SelectCAndVCSteps;
import utils.CommonUtils;

public class CricketPageTest  extends BaseCase {

    @Steps
    CricketPageSteps cricketPageStepsObj;
    @Steps
    HomePageSteps homePageStepsObj;
    @Steps
    CreateTeamSteps createTeamStepsObj;
    @Steps
    SelectCAndVCSteps selectCAndVCStepsObj;

    @Test
     public void VerifyCricketPage()
     {
         String home_page_url = CommonUtils.getBaseUrl();
         homePageStepsObj.open_home_page(home_page_url);
         cricketPageStepsObj.verify_left_team_name_is_displayed();
         cricketPageStepsObj.verify_time_displayed();
         cricketPageStepsObj.verify_right_team_name_is_displayed();
         cricketPageStepsObj.click_on_first_upcoming_match();
         createTeamStepsObj.click_on_next_button();
         createTeamStepsObj.add_wicket_keeper();
         createTeamStepsObj.click_on_batsman_lbl();
         createTeamStepsObj.add_four_batsMan();
         createTeamStepsObj.add_all_rounders();
         createTeamStepsObj.add_bowlers();
         createTeamStepsObj.click_on_continue_button();
         selectCAndVCStepsObj.verify_caption_is_selected();
         selectCAndVCStepsObj.verify_vice_caption_is_selected();
         selectCAndVCStepsObj.user_click_on_save_button();
         selectCAndVCStepsObj.click_on_got_it_lbl();
         selectCAndVCStepsObj.verify_contest_count();
;     }
}
