package com.google.jplurk_oauth.module;

import org.json.JSONObject;

import com.google.jplurk_oauth.skeleton.AbstractModule;
import com.google.jplurk_oauth.skeleton.Args;
import com.google.jplurk_oauth.skeleton.HttpMethod;
import com.google.jplurk_oauth.skeleton.RequestException;

/**
 * @author Askeing
 *
 * <p>
 * Get instant notifications when there are new plurks and responses on a user's timeline. <br/>
 * This is much more efficient and faster than polling so please use it!
 * </p>
 * This API works like this:
 * <ul>
 * <li>A request is sent to /APP/Realtime/getUserChannel and in it you get an unique channel to the specified user's timeline</li>
 * <li>You do requests to this unqiue channel in order to get notifications</li>
 * </ul>
 */
/**
 * @author Askeing
 *
 */
public class Realtime extends AbstractModule {
    
    /**
     * @return Return's a JSON object with an URL that you should listen to, e.g. 
     * <code>{"comet_server": "https://comet03.plurk.com/comet/1235515351741/?channel=generic-4-f733d8522327edf87b4d1651e6395a6cca0807a0", "channel_name": "generic-4-f733d8522327edf87b4d1651e6395a6cca0807a0"}</code>
     * @throws RequestException
     */
    public JSONObject getUserChannel() throws RequestException {
        return requestBy("getUserChannel")
        		.withoutArgs().in(HttpMethod.GET).thenJsonObject();
    }
    
    /**
     * Do requests to this unqiue channel in order to get notifications.
     * @param comet_server
     * @return
     * @throws RequestException
     */
    public String cometUserChannel(String comet_server) throws RequestException {
    	return requestSpecificURL(comet_server, new Args())
    			.in(HttpMethod.GET).thenStringObject();
    }
    
    @Override
    protected String getModulePath() {
        return "/APP/Realtime";
    }

}
