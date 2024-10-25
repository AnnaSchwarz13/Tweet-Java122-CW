package service;

import Entity.User;

public interface TwitterService {
    void Login(User user);

    void tweet(String text);
    void displayAllTweet();
}
