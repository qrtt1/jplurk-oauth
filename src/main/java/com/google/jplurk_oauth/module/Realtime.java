package com.google.jplurk_oauth.module;

import org.json.JSONObject;

import com.google.jplurk_oauth.skeleton.AbstractModule;
import com.google.jplurk_oauth.skeleton.Args;
import com.google.jplurk_oauth.skeleton.HttpMethod;
import com.google.jplurk_oauth.skeleton.RequestException;

public class Realtime extends AbstractModule {
    
    public JSONObject getUserChannel() throws RequestException {
        return requestBy("getUserChannel")
        		.withoutArgs().in(HttpMethod.GET).thenJsonObject();
    }
    
    public JSONObject getUserChannel(String channel) throws RequestException {
        return getUserChannel(channel, null);
    }
    
    public JSONObject getUserChannel(String channel, Args optional) throws RequestException {
        return requestBy("getUserChannel").with(new Args().add("channel", channel).add(optional))
        		.in(HttpMethod.GET).thenJsonObject();
    }

    public String cometUserChannel(String comet_server) throws RequestException {
    	return requestSpecificURL(comet_server, new Args())
    			.in(HttpMethod.GET).thenStringObject();
    }
    
    @Override
    protected String getModulePath() {
        return "/APP/Realtime";
    }

}
