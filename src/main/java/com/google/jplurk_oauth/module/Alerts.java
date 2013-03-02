package com.google.jplurk_oauth.module;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.jplurk_oauth.skeleton.AbstractModule;
import com.google.jplurk_oauth.skeleton.Args;
import com.google.jplurk_oauth.skeleton.HttpMethod;
import com.google.jplurk_oauth.skeleton.RequestException;

public class Alerts extends AbstractModule {
    
    /**
     * Return a JSON list of current active alerts.
     * @return <code>[{"id": 42, "nick_name": "frodo_b", ...}, ...]</code> JSON object of all the active alerts
     * @throws RequestException
     */
    public JSONArray getActive() throws RequestException {
        return requestBy("getActive")
            .withoutArgs().in(HttpMethod.GET).thenJsonArray();
    }

    /**
     * Return a JSON list of past 30 alerts.
     * @return <code>[{"nick_name": "frodo_b", ...}, ...]</code> JSON object of all the history alerts
     * @throws RequestException
     */
    public JSONArray getHistory() throws RequestException {
        return requestBy("getHistory")
            .withoutArgs().in(HttpMethod.GET).thenJsonArray();
    }
    
    /**
     * Accept user_id as fan.
     * @param user_id The user_id that has asked for friendship.
     * @return <code>{"success_text": "ok"}</code>
     * @throws RequestException
     */
    public JSONObject addAsFan(Long user_id) throws RequestException {
        return addAsFan(user_id.toString());
    }
	
    /**
     * Accept user_id as fan.
     * @param user_id The user_id that has asked for friendship.
     * @return <code>{"success_text": "ok"}</code>
     * @throws RequestException
     */
    public JSONObject addAsFan(String user_id) throws RequestException {
		return requestBy("addAsFan")
	            .with(new Args().add("user_id", user_id))
	            .in(HttpMethod.GET).thenJsonObject();
    }
	
	/**
	 * Accept all friendship requests as fans.
	 * @return <code>{"success_text": "ok"}</code>
	 * @throws RequestException
	 */
	public JSONArray addAllAsFan() throws RequestException {
        return requestBy("addAllAsFan")
            .withoutArgs().in(HttpMethod.GET).thenJsonArray();
    }
	
	/**
	 * Accept all friendship requests as friends.
	 * @return <code>{"success_text": "ok"}</code>
	 * @throws RequestException
	 */
	public JSONArray addAllAsFriends() throws RequestException {
        return requestBy("addAllAsFriends")
            .withoutArgs().in(HttpMethod.GET).thenJsonArray();
    }
    
	/**
	 * Accept user_id as friend.
	 * @param user_id The user_id that has asked for friendship.
	 * @return <code>{"success_text": "ok"}</code>
	 * @throws RequestException
	 */
	public JSONObject addAsFriend(Long user_id) throws RequestException {
        return addAsFriend(user_id.toString());
    }
	
	/**
	 * Accept user_id as friend.
	 * @param user_id The user_id that has asked for friendship.
	 * @return <code>{"success_text": "ok"}</code>
	 * @throws RequestException
	 */
	public JSONObject addAsFriend(String user_id) throws RequestException {
		return requestBy("addAsFriend")
	            .with(new Args().add("user_id", user_id))
	            .in(HttpMethod.GET).thenJsonObject();
    }
	
	/**
	 * Deny friendship to user_id.
	 * @param user_id The user_id that has asked for friendship.
	 * @return <code>{"success_text": "ok"}</code>
	 * @throws RequestException
	 */
	public JSONObject denyFriendship(Long user_id) throws RequestException {
        return denyFriendship(user_id.toString());
    }
	
	/**
	 * Deny friendship to user_id.
	 * @param user_id The user_id that has asked for friendship.
	 * @return <code>{"success_text": "ok"}</code>
	 * @throws RequestException
	 */
	public JSONObject denyFriendship(String user_id) throws RequestException {
		return requestBy("denyFriendship")
	            .with(new Args().add("user_id", user_id))
	            .in(HttpMethod.GET).thenJsonObject();
    }
	
	/**
	 * Remove notification to user with id user_id.
	 * @param user_id The user_id that the current user has requested friendship for
	 * @return <code>{"success_text": "ok"}</code>
	 * @throws RequestException
	 */
	public JSONObject removeNotification(Long user_id) throws RequestException {
        return removeNotification(user_id.toString());
    }
	
	/**
	 * Remove notification to user with id user_id.
	 * @param user_id The user_id that the current user has requested friendship for
	 * @return <code>{"success_text": "ok"}</code>
	 * @throws RequestException
	 */
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
