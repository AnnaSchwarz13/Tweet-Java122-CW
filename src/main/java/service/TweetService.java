package service;

import Entity.Tweet;
import Entity.TweetList;
import Entity.User;
import database.Database;

import static database.Database.loggedInUser;
import static database.Database.tweetList;

public class TweetService {
    public void showTweet(Tweet tweet) {
        int likes = tweet.getLikedUsers().getIndex();
        String authorName = tweet.getUser().getFirstName() + " " + tweet.getUser().getLastName();
        System.out.println("tweet's id: " + tweet.getId() + "\n"
                + tweet.getText() + "\n" + authorName + "\n Likes: " + likes);

    }

    public boolean isUserLiked(Tweet tweet, User user) {
        for (int i = 0; i < tweet.getLikedUsers().getIndex(); i++) {
            User likedUser = tweet.getLikedUsers().getUsers(i);
            if (likedUser.equals(user)) {
                return true;
            }
        }
        return false;
    }

    public Tweet getTweetById(int id) {
        for (int i = 0; i < Database.tweetList.getIndex(); i++) {
            Tweet tweet = Database.tweetList.getTweets(i);
            if (tweet.getId() == id) {
                return tweet;
            }
        }
        System.out.println("Tweet not found");
        return null;
    }
    public TweetList getLoggedInUserTweets(){
        TweetList userTweetList = new TweetList();
        for(int i=0; i<tweetList.getIndex(); i++){
            Tweet tweet=tweetList.getTweets(i);
            if(tweet.getUser().getUsername() .equals(loggedInUser.getUsername()) ){
                userTweetList.add(tweet);
            }

        }
        return userTweetList;
    }

}
