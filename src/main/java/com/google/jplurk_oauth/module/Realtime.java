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
     * <code>{"comet_server": "http://comet03.plurk.com/comet/1235515351741/?channel=generic-4-f733d8522327edf87b4d1651e6395a6cca0807a0", "channel_name": "generic-4-f733d8522327edf87b4d1651e6395a6cca0807a0"}</code>
     * @throws RequestException
     */
    public JSONObject getUserChannel() throws RequestException {
        return requestBy("getUserChannel")
        		.withoutArgs().in(HttpMethod.GET).thenJsonObject();
    }
    
    /**
     * @param channel You get this from /APP/Realtime/getUserChannel channel_name parameter.
     * @return
     * @throws RequestException
     */
    public JSONObject getUserChannel(String channel) throws RequestException {
        return getUserChannel(channel, null);
    }
    
    /**
     * @param channel You get this from /APP/Realtime/getUserChannel channel_name parameter.
     * @param optional Optional parameters:
     * <ul>
     * <li>offset: Only fetch new messages from a given offset. You'll get offset when a response is returned, it's returned as new_offset.</li>
     * </ul>
     * @return
     * @throws RequestException
     */
    public JSONObject getUserChannel(String channel, Args optional) throws RequestException {
        return requestBy("getUserChannel").with(new Args().add("channel", channel).add(optional))
        		.in(HttpMethod.GET).thenJsonObject();
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
