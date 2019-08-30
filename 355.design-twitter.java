import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/*
 * @lc app=leetcode id=355 lang=java
 *
 * [355] Design Twitter
 *
 * https://leetcode.com/problems/design-twitter/description/
 *
 * algorithms
 * Medium (27.79%)
 * Likes:    545
 * Dislikes: 142
 * Total Accepted:    37.5K
 * Total Submissions: 134.1K
 * Testcase Example:  '["Twitter","postTweet","getNewsFeed","follow","postTweet","getNewsFeed","unfollow","getNewsFeed"]\n[[],[1,5],[1],[1,2],[2,6],[1],[1,2],[1]]'
 *
 * Design a simplified version of Twitter where users can post tweets,
 * follow/unfollow another user and is able to see the 10 most recent tweets in
 * the user's news feed. Your design should support the following methods:
 * 
 * 
 * 
 * postTweet(userId, tweetId): Compose a new tweet.
 * getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's
 * news feed. Each item in the news feed must be posted by users who the user
 * followed or by the user herself. Tweets must be ordered from most recent to
 * least recent.
 * follow(followerId, followeeId): Follower follows a followee.
 * unfollow(followerId, followeeId): Follower unfollows a followee.
 * 
 * 
 * 
 * Example:
 * 
 * Twitter twitter = new Twitter();
 * 
 * // User 1 posts a new tweet (id = 5).
 * twitter.postTweet(1, 5);
 * 
 * // User 1's news feed should return a list with 1 tweet id -> [5].
 * twitter.getNewsFeed(1);
 * 
 * // User 1 follows user 2.
 * twitter.follow(1, 2);
 * 
 * // User 2 posts a new tweet (id = 6).
 * twitter.postTweet(2, 6);
 * 
 * // User 1's news feed should return a list with 2 tweet ids -> [6, 5].
 * // Tweet id 6 should precede tweet id 5 because it is posted after tweet id
 * 5.
 * twitter.getNewsFeed(1);
 * 
 * // User 1 unfollows user 2.
 * twitter.unfollow(1, 2);
 * 
 * // User 1's news feed should return a list with 1 tweet id -> [5],
 * // since user 1 is no longer following user 2.
 * twitter.getNewsFeed(1);
 * 
 * 
 */
class Twitter {
//TODO: not accepted

    private Map<Integer, List<Integer>> feedMap;
    private Map<Integer, List<Integer>> postMap;
    private Map<Integer, List<Integer>> followerMap;
    private Map<Integer, List<Integer>> followeeMap;

    /** Initialize your data structure here. */
    public Twitter() {
        feedMap = new ConcurrentHashMap<>();
        postMap = new ConcurrentHashMap<>();
        followerMap = new ConcurrentHashMap<>();
        followeeMap = new ConcurrentHashMap<>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        List<Integer> posts = postMap.getOrDefault(userId, new LinkedList<>());
        synchronized (posts) {
            posts.add(0, tweetId);
            if (posts.size() > 10) {
                posts.remove(posts.size() - 1);
            }
        }

        List<Integer> followers = followeeMap.getOrDefault(userId, new LinkedList<>());
        synchronized (followers) {
            for (Integer follower : followers) {
                List<Integer> feed = feedMap.getOrDefault(follower, new LinkedList<>());
                feed.add(0, tweetId);
                if (feed.size() > 10) {
                    feed.remove(feed.size() - 1);
                }
            }
        }

        List<Integer> selfFeed = feedMap.getOrDefault(userId, new LinkedList<>());
        selfFeed.add(0, tweetId);
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in
     * the news feed must be posted by users who the user followed or by the user
     * herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        return feedMap.getOrDefault(userId, new LinkedList<>());
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a
     * no-op.
     */
    public void follow(int followerId, int followeeId) {
        List<Integer> followees = followerMap.getOrDefault(followerId, new LinkedList<>());

        synchronized (followees) {
            followees.add(0, followeeId);
        }

        List<Integer> followers = followeeMap.getOrDefault(followeeId, new LinkedList<>());
        synchronized (followers) {
            followers.add(0, followerId);
        }
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a
     * no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        if (!followerMap.containsKey(followerId)) {
            return;
        }

        List<Integer> followees = followerMap.get(followerId);
        synchronized (followees) {
            followees.remove(followeeId);
        }

        List<Integer> followers = followeeMap.get(followeeId);
        synchronized (followers) {
            followers.remove(followerId);
        }

        List<Integer> posts = postMap.get(followeeId);
        List<Integer> feed = feedMap.get(followerId);

        synchronized (feed) {
            for (Integer fd : feed) {
                if (posts.contains(fd))
                    feed.remove(fd);
            }
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such: Twitter obj =
 * new Twitter(); obj.postTweet(userId,tweetId); List<Integer> param_2 =
 * obj.getNewsFeed(userId); obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
