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
         int wk_count=2,bt_count=3,ar_count=3,bow_count=3;
         String home_page_url = CommonUtils.getBaseUrl();
         homePageStepsObj.open_home_page(home_page_url);
         cricketPageStepsObj.verify_left_team_name_is_displayed();
         cricketPageStepsObj.verify_time_displayed();
         cricketPageStepsObj.verify_right_team_name_is_displayed();
         cricketPageStepsObj.click_on_first_upcoming_match();
         createTeamStepsObj.click_on_next_button();
         createTeamStepsObj.add_wicket_keeper(wk_count);
         createTeamStepsObj.click_on_batsman_lbl();
         createTeamStepsObj.add_four_batsMan(bt_count);
         createTeamStepsObj.click_on_all_round_label();
         createTeamStepsObj.add_all_rounders(ar_count);
         createTeamStepsObj.click_on_bowler_lbl();
         createTeamStepsObj.add_bowlers(bow_count);
         createTeamStepsObj.click_on_continue_button();
         selectCAndVCStepsObj.verify_caption_is_selected();
         selectCAndVCStepsObj.verify_vice_caption_is_selected();
         selectCAndVCStepsObj.user_click_on_save_button();
         selectCAndVCStepsObj.click_on_got_it_lbl();
         selectCAndVCStepsObj.verify_contest_count();
     }
}
