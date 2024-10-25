package Repository;

import Entity.Tweet;
import lombok.Getter;
import lombok.NoArgsConstructor;


import java.util.ArrayList;
import java.util.List;
@Getter

public class TweetRepository {
    private List<Tweet> tweets;

    public TweetRepository() {
        this.tweets = new ArrayList<>();
    }
    public void save(Tweet tweet) {
        this.tweets.add(tweet);
    }
}
