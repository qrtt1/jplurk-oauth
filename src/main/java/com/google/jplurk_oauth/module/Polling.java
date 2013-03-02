package com.google.jplurk_oauth.module;

import org.json.JSONObject;

import com.google.jplurk_oauth.Offset;
import com.google.jplurk_oauth.skeleton.AbstractModule;
import com.google.jplurk_oauth.skeleton.Args;
import com.google.jplurk_oauth.skeleton.HttpMethod;
import com.google.jplurk_oauth.skeleton.RequestException;

public class Polling extends AbstractModule {
    
	/**
	 * You should use this call to find out if there any new plurks posted to the user's timeline.
	 * <p>It's much more efficient than doing it with /APP/Timeline/getPlurks, so please use it :)</p>
     * @param offset Return plurks newer than offset, formatted as 2009-6-20T21:55:34.
     * @return Returns a JSON object of plurks and their users, e.g. <code>{"plurks": [{"plurk_id": 3, "content": "Test", "qualifier_translated": "says", "qualifier": "says", "lang": "en" ...}, ...], "plurk_users": {"3": {"id": 3, "nick_name": "alvin", ...}}</code>
     * @throws RequestException
     */
	public JSONObject getPlurks(Offset offset) throws RequestException {
		return getPlurks(offset, null);
	}
	    
	/**
	 * You should use this call to find out if there any new plurks posted to the user's timeline.
	 * <p>It's much more efficient than doing it with /APP/Timeline/getPlurks, so please use it :)</p>
     * @param offset Return plurks newer than offset, formatted as 2009-6-20T21:55:34.
     * @param optional Optional parameters:
     * <ul>
     * <li>limit: The max number of plurks to be returned (default: 20)</li>
     * <li>favorers_detail, limited_detail and replurkers_detail: See /APP/Timline/getPlurks for details</li>
     * </ul>
     * @return Returns a JSON object of plurks and their users, e.g. <code>{"plurks": [{"plurk_id": 3, "content": "Test", "qualifier_translated": "says", "qualifier": "says", "lang": "en" ...}, ...], "plurk_users": {"3": {"id": 3, "nick_name": "alvin", ...}}</code>
     * @throws RequestException
     */
    public JSONObject getPlurks(Offset offset, Args optional) throws RequestException {
        return requestBy("getPlurks")
            .with(new Args().add("offset", offset.formatted()).add(optional))
            .in(HttpMethod.GET).thenJsonObject();
    }

    /**
     * Use this call to find out if there are unread plurks on a user's timeline.
     * @return Returns a JSON object of counts, e.g. <code>{"all": 2, "my": 1, "private": 1, "responded": 0}</code>
     * @throws RequestException
     */
    public JSONObject getUnreadCount() throws RequestException {
        return requestBy("getUnreadCount")
            .withoutArgs().in(HttpMethod.GET).thenJsonObject();
    }
    
    @Override
    protected String getModulePath() {
        return "/APP/Polling";
    }

}
