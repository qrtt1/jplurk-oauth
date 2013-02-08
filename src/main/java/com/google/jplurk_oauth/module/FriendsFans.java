package com.google.jplurk_oauth.module;

import org.json.JSONObject;

import com.google.jplurk_oauth.skeleton.AbstractModule;
import com.google.jplurk_oauth.skeleton.Args;
import com.google.jplurk_oauth.skeleton.HttpMethod;
import com.google.jplurk_oauth.skeleton.RequestException;

public class FriendsFans extends AbstractModule {
    
	public JSONObject getFriendsByOffset(Long user_id) throws RequestException {
        return getFriendsByOffset(user_id.toString());
    }
	
	public JSONObject getFriendsByOffset(String user_id) throws RequestException {
        return getFriendsByOffset(user_id, null);
    }
	
    public JSONObject getFriendsByOffset(String user_id, Args optional) throws RequestException {
        return requestBy("getFriendsByOffset")
            .with(new Args().add("user_id", user_id).add(optional))
            .in(HttpMethod.GET).thenJsonObject();
    }
    
    
    public JSONObject getFansByOffset(Long user_id) throws RequestException {
        return getFansByOffset(user_id.toString());
    }
	
	public JSONObject getFansByOffset(String user_id) throws RequestException {
        return getFansByOffset(user_id, null);
    }
	
    public JSONObject getFansByOffset(String user_id, Args optional) throws RequestException {
        return requestBy("getFansByOffset")
            .with(new Args().add("user_id", user_id).add(optional))
            .in(HttpMethod.GET).thenJsonObject();
    }
    
    
    public JSONObject getFollowingByOffset() throws RequestException {
        return getFollowingByOffset(null);
    }
	
    public JSONObject getFollowingByOffset(Args optional) throws RequestException {
        return requestBy("getFollowingByOffset")
            .with(new Args().add(optional))
            .in(HttpMethod.GET).thenJsonObject();
    }
    
    
    public JSONObject becomeFriend(Long friend_id) throws RequestException {
        return becomeFriend(friend_id.toString());
    }
    
    public JSONObject becomeFriend(String friend_id) throws RequestException {
        return requestBy("becomeFriend")
            .with(new Args().add("friend_id", friend_id))
            .in(HttpMethod.GET).thenJsonObject();
    }
    
    
    public JSONObject removeAsFriend(Long friend_id) throws RequestException {
        return removeAsFriend(friend_id.toString());
    }
    
    public JSONObject removeAsFriend(String friend_id) throws RequestException {
        return requestBy("removeAsFriend")
            .with(new Args().add("friend_id", friend_id))
            .in(HttpMethod.GET).thenJsonObject();
    }
    
    
    public JSONObject becomeFan(Long fan_id) throws RequestException {
        return becomeFan(fan_id.toString());
    }
    
    public JSONObject becomeFan(String fan_id) throws RequestException {
        return requestBy("becomeFan")
            .with(new Args().add("fan_id", fan_id))
            .in(HttpMethod.GET).thenJsonObject();
    }
    
    
    public JSONObject setFollowing(Long user_id, boolean follow) throws RequestException {
        return setFollowing(user_id.toString(), follow);
    }
    
    public JSONObject setFollowing(String user_id, boolean follow) throws RequestException {
        return requestBy("setFollowing")
            .with(new Args().add("user_id", user_id).add("follow", follow))
            .in(HttpMethod.GET).thenJsonObject();
    }
    
    
    public JSONObject getCompletion() throws RequestException {
        return requestBy("getCompletion")
            .withoutArgs().in(HttpMethod.GET).thenJsonObject();
    }
    
    @Override
    protected String getModulePath() {
        return "/APP/FriendsFans";
    }

}
