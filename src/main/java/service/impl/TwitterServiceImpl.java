package service.impl;

import Entity.Tweet;
import database.Database;
import service.TweetService;
import service.TwitterService;

import static database.Database.loggedInUser;
import static database.Database.tweetList;

public class TwitterServiceImpl implements TwitterService {
    TweetService tweetService = new TweetService();

    @Override
    public void displayAllTweet() {
        if(tweetList.getIndex()>0) {
            //show likes
            //show author of tweet
            for (int i = 0; i < tweetList.getIndex(); i++) {
                tweetService.showTweet(tweetList.getTweets(i));
                System.out.println("-------");
            }
            return;
        }
        System.out.println("There's no tweets");
    }

    @Override
    public void likeTweet(Tweet tweet) {
        if (tweetService.isUserLiked(tweet, loggedInUser)) {
            System.out.println("You already like this tweet");
            return;
        }
        tweet.getLikedUsers().add(loggedInUser);
    }
}
