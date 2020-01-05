package com.other.finalproject.bean;

/**
 * author: hedianbo.
 * date: 2019-12-30
 * desc:
 */
public class FollowBena {

    private boolean followed;
    private String responseCode;
    private String follower;
    private String following;

    public String getFollowing() {
        return following == null ? "" : following;
    }

    public void setFollowing(String following) {
        this.following = following;
    }

    public String getFollower() {
        return follower == null ? "" : follower;
    }

    public void setFollower(String follower) {
        this.follower = follower;
    }

    public boolean isFollowed() {
        return followed;
    }

    public void setFollowed(boolean followed) {
        this.followed = followed;
    }

    public String getResponseCode() {
        return responseCode == null ? "" : responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }
}
