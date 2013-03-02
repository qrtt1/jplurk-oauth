package com.google.jplurk_oauth.module;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.jplurk_oauth.skeleton.AbstractModule;
import com.google.jplurk_oauth.skeleton.Args;
import com.google.jplurk_oauth.skeleton.HttpMethod;
import com.google.jplurk_oauth.skeleton.RequestException;

public class Alerts extends AbstractModule {
    
    public JSONArray getActive() throws RequestException {
        return requestBy("getActive")
            .withoutArgs().in(HttpMethod.GET).thenJsonArray();
    }

    public JSONArray getHistory() throws RequestException {
        return requestBy("getHistory")
            .withoutArgs().in(HttpMethod.GET).thenJsonArray();
    }
    
    public JSONObject addAsFan(Long user_id) throws RequestException {
        return addAsFan(user_id.toString());
    }
	
	public JSONObject addAsFan(String user_id) throws RequestException {
		return requestBy("addAsFan")
	            .with(new Args().add("user_id", user_id))
	            .in(HttpMethod.GET).thenJsonObject();
    }
	
	public JSONArray addAllAsFan() throws RequestException {
        return requestBy("addAllAsFan")
            .withoutArgs().in(HttpMethod.GET).thenJsonArray();
    }
	
	public JSONArray addAllAsFriends() throws RequestException {
        return requestBy("addAllAsFriends")
            .withoutArgs().in(HttpMethod.GET).thenJsonArray();
    }
    
	public JSONObject addAsFriend(Long user_id) throws RequestException {
        return addAsFriend(user_id.toString());
    }
	
	public JSONObject addAsFriend(String user_id) throws RequestException {
		return requestBy("addAsFriend")
	            .with(new Args().add("user_id", user_id))
	            .in(HttpMethod.GET).thenJsonObject();
    }
	
	public JSONObject denyFriendship(Long user_id) throws RequestException {
        return denyFriendship(user_id.toString());
    }
	
	public JSONObject denyFriendship(String user_id) throws RequestException {
		return requestBy("denyFriendship")
	            .with(new Args().add("user_id", user_id))
	            .in(HttpMethod.GET).thenJsonObject();
    }
	
	public JSONObject removeNotification(Long user_id) throws RequestException {
        return removeNotification(user_id.toString());
    }
	
	public JSONObject removeNotification(String user_id) throws RequestException {
		return requestBy("removeNotification")
	            .with(new Args().add("user_id", user_id))
	            .in(HttpMethod.GET).thenJsonObject();
    }
	
    @Override
    protected String getModulePath() {
        return "/APP/Alerts";
    }

}
