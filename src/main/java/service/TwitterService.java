package service;

import Entity.Tweet;
import Entity.User;

public interface TwitterService {
    void displayAllTweet();
    void likeTweet(Tweet tweet);
}
