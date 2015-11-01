package ga.dryco.JerkTest;

import ga.dryco.redditJerk.Reddit;
import ga.dryco.redditJerk.RedditApi;
import ga.dryco.redditJerk.controllers.Comment;
import ga.dryco.redditJerk.controllers.RedditThread;
import ga.dryco.redditJerk.controllers.User;

import java.io.IOException;
import java.net.MalformedURLException;

/**
 * Created by mekoneko on 8/11/2015.
 */
public class clientTest {
    public static void main(String[] args){
        Reddit rApi = RedditApi.getRedditInstance("Test clv1");


            User myUser = rApi.login("RedditJerkTest", "jerkjerkjerk", "WoXLiKdjulE09Q", "QoG2unmpgAum-IQ92NDhhNy-UKs");

        //System.out.println(rApi.authData.getAccessTokenJson());
        //User myuser = rApi.me();
        //System.out.println(myuser.getName());
        RedditThread tp = null;

        try {
            tp = rApi.getRedditThread("https://www.reddit.com/r/biggomno/comments/3h881b/test/");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


        assert tp != null;
        Comment comm = tp.getFlatComments().get(1);


            System.out.println("REPLYING");
            Comment replcomm = comm.reply("1YapaYapa22");
            System.out.println(replcomm.getBody());
            System.out.println(replcomm.getName());

            Comment edittedComment = replcomm.edit("WORKS FINALLY ???");
            System.out.println(edittedComment.getBody());



    }
}
