package service;

import Entity.Tweet;
import Entity.User;
import database.Database;

public class TweetService {
    public void showTweet(Tweet tweet) {
        int likes = tweet.getLikedUsers().getIndex();
        String authorName = tweet.getUser().getFirstName() +" "+ tweet.getUser().getLastName();
        System.out.println("tweet's id: "+tweet.getId() +"\n"
                +tweet.getText()+"\n"+authorName+"\n"+likes );

    }

    public boolean isUserLiked(Tweet tweet, User user) {
        for(int i=0; i<tweet.getLikedUsers().getIndex(); i++) {
            User likedUser = tweet.getLikedUsers().getUsers(i);
            if(likedUser.equals(user)) {
                return true;
            }
        }
        return false;
    }

    public Tweet getTweetById(int id) {
        for(int i=0; i< Database.tweetList.getIndex();i++){
            Tweet tweet = Database.tweetList.getTweets(i);
            if(tweet.getId() == id){
                return tweet;
            }
        }
        return null;
    }

}