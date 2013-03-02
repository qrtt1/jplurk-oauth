package com.google.jplurk_oauth.module;

import org.json.JSONObject;

import com.google.jplurk_oauth.skeleton.AbstractModule;
import com.google.jplurk_oauth.skeleton.Args;
import com.google.jplurk_oauth.skeleton.HttpMethod;
import com.google.jplurk_oauth.skeleton.RequestException;

public class OAuthUtilities extends AbstractModule {
    
    /**
     * Check if current access token is valid and return information for this token.
     * @return Successful return:
     * <ul>
     * <li>app_id: application id of this access token</li>
     * <li>user_id: user id of this access token</li>
     * <li>issued: the date/time when this token is issued</li>
     * <li>deviceid: deviceid used to authorize this token</li>
     * </ul>
     * @throws RequestException
     */
    public JSONObject checkToken() throws RequestException {
        return requestBy("checkToken")
            .withoutArgs().in(HttpMethod.GET).thenJsonObject();
    }

    /**
     * Expire current access token.
     * @return Successful return:
     * <ul>
     * <li>app_id: application id of this access token</li>
     * <li>user_id: user id of this access token</li>
     * <li>issued: the date/time when this token is issued</li>
     * <li>deviceid: deviceid used to authorize this token</li>
     * </ul>
     * @throws RequestException
     */
    public JSONObject expireToken() throws RequestException {
        return requestBy("expireToken")
            .withoutArgs().in(HttpMethod.GET).thenJsonObject();
    }
	
    /**
     * Check current time of plurk servers.
     * @return Successful return:
     * <ul>
     * <li>now: current time of plurk servers</li>
     * <li>timestamp: current time of plurk servers (as UNIX timestamp)</li>
     * <li>app_id: application id of this access token</li>
     * <li>user_id: user id of this access token (null for two-legged OAuth)</li>
     * </ul>
     * @throws RequestException
     */
    public JSONObject checkTime() throws RequestException {
		return requestBy("checkTime")
	            .withoutArgs().in(HttpMethod.GET).thenJsonObject();
    }
	
	/**
	 * Test for argument passing.
	 * @param data
	 * @return Successful return:
     * <ul>
     * <li>data: same as the data passing in</li>
     * <li>length: length of data</li>
     * </ul>
	 * @throws RequestException
	 */
	public JSONObject echo(String data) throws RequestException {
        return requestBy("echo")
            .with(new Args().add("data", data))
            .in(HttpMethod.GET).thenJsonObject();
    }
	
    @Override
    protected String getModulePath() {
        return "/APP";
    }

}
