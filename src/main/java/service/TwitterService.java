package service;

import Entity.Tweet;

public interface TwitterService {
    void displayAllTweet();

    void likeTweet(Tweet tweet);
}
