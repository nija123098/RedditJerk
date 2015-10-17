package ga.dryco.JerkTest;

import ga.dryco.redditJerk.Reddit;
import ga.dryco.redditJerk.RedditApi;
import ga.dryco.redditJerk.controllers.Link;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mekoneko on 8/11/2015.
 */
public class TestBot {
    public static void main(String[] args){

        List<String> done = new ArrayList<>();
        List<String> keywords = new ArrayList<>();
        Integer submsLastRun = 0;

        keywords.add("Linux");
        keywords.add("Cisco");
        keywords.add("Java");
        keywords.add("Windows");
        keywords.add("Fl Studio");
        keywords.add("Ahsoka");
        Reddit red = RedditApi.getRedditInstance("TestClient34");
        try {
            red.login("RedditJerkTest", "jerkjerkjerk", "WoXLiKdjulE09Q", "QoG2unmpgAum-IQ92NDhhNy-UKs");
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true){
            List<Link> all = null;
            Integer sbmCount = 0;
            try {
                all = red.getSubredditPage("all", submsLastRun + 50, "new");
            } catch (IOException e) {
                e.printStackTrace();
            }
            assert all != null;
            for(Link sbm: all){
                if(!done.contains(sbm.getName())){
                    sbmCount++;
                    keywords.stream().filter(str -> sbm.getTitle().toLowerCase().contains(str.toLowerCase())).forEach(str -> System.out.println("Keyword Matched: " + str + ", " + sbm.getName()));
                    done.add(sbm.getName());
                }

            }System.out.println("Already done:" + done.size() + "\nThis run:" + sbmCount);
            submsLastRun = sbmCount;
            try {
                System.out.println("Sleeping");
                Thread.sleep(60000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}