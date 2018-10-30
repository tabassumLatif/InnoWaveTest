package com.innowave.assessment.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class User implements Serializable{

    private String login;
    @SerializedName("avatar_url")
    private String avatarUrl;
    @SerializedName("followers_url")
    private String followersUrl;
    @SerializedName("following_url")
    private String followingUrl;
    @SerializedName("bio")
    private String bio;
    private String name;
    private String email;
    private Integer followers;

    public String getLogin() {
        return login;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public String getFollowersUrl() {
        return followersUrl;
    }

    public String getFollowingUrl() {
        return followingUrl;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Integer getFollowers() {
        return followers;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

}

