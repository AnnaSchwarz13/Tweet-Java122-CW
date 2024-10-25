package Entity;

import java.util.Arrays;

public class TweetList {


    private Tweet[] tweets;
    private int index;

    public TweetList() {
        this.tweets = new Tweet[10];
        this.index = 0;
    }

    public void add(Tweet tweet) {
        tweets[index] = tweet;
        index++;

        if (index >= tweets.length)
            tweets = Arrays.copyOf(tweets, tweets.length * 2);
    }

    public int getIndex() {
        return index;
    }

    public Tweet getTweets(int index) {
        return tweets[index];

    }

}




