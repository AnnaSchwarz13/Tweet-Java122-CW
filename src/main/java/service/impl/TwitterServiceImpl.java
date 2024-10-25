package service.impl;

import service.TweetService;
import service.TwitterService;
import static database.Database.tweetList;

public class TwitterServiceImpl implements TwitterService {
    TweetService tweetService = new TweetService();
    @Override
    public void displayAllTweet() {
        //show likes
        //show author of tweet
        for(int i=0; i< tweetList.getIndex();i++){
            tweetService.showTweet(tweetList.getTweets(i));
            System.out.println("-------");
        }
    }
}
