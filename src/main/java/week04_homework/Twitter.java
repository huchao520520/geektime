package week04_homework;


import java.util.*;

/**
 * 第二题 leetcode 355. 设计推特
 *
 * @author HuChao
 * @date 2022/3/20/0020 14:25
 */
public class Twitter {

    class Tweet{
        int id;
        int userId;
        long time;
        public Tweet(int id, int userId, long time) {
            this.id = id;
            this.userId = userId;
            this.time = time;
        }
    }

    PriorityQueue<Tweet> queue;
    Map<Integer, Set<Integer>> userFollows; // key：用户 value：用户关注的人
    Map<Integer, Set<Integer>> userFollowed; // key：用户 value：关注用户的人
    long time = 1L;

    public Twitter() {
        queue = new PriorityQueue<>((o1, o2) -> (int) (o2.time - o1.time));
        userFollows = new HashMap<>();
        userFollowed = new HashMap<>();
    }

    long curTime() {
        return ++time;
    }

    public void postTweet(int userId, int tweetId) {
        Tweet tweet = new Tweet(tweetId, userId, curTime());
        queue.add(tweet);
    }

    public List<Integer> getNewsFeed(int userId) {
        if(queue == null || queue.size() == 0) return new ArrayList<>();
        Set<Integer> follows = userFollows.get(userId);
        List<Integer> newsIds = new ArrayList<>();
        List<Tweet> news = new ArrayList<>();
        while (!queue.isEmpty() && newsIds.size() < 10) {
            Tweet tweet = queue.poll();
            news.add(tweet);
            if(tweet.userId == userId) newsIds.add(tweet.id);
            if(follows != null && follows.contains(tweet.userId)) newsIds.add(tweet.id);
        }
        if(news.size() != 0) {
            queue.addAll(news);
        }
        return newsIds;
    }

    public void follow(int followerId, int followeeId) {
        add(userFollows, followerId, followeeId);
        add(userFollowed, followeeId, followerId);
    }

    public void unfollow(int followerId, int followeeId) {
        remove(userFollows, followerId, followeeId);
        remove(userFollowed, followeeId, followerId);
    }

    void add(Map<Integer, Set<Integer>> map, int key, int value) {
        if(map.containsKey(key)) {
            map.get(key).add(value);
        } else {
            Set<Integer> v = new HashSet<>();
            v.add(value);
            map.put(key, v);
        }
    }

    void remove(Map<Integer, Set<Integer>> map, int key, int value) {
        Set<Integer> v = map.get(key);
        if(v == null) return;
        v.remove(value);
    }
}
