package com.google.jplurk_oauth.module;

import org.json.JSONObject;

import com.google.jplurk_oauth.skeleton.AbstractModule;
import com.google.jplurk_oauth.skeleton.HttpMethod;
import com.google.jplurk_oauth.skeleton.RequestException;

public class Emoticons extends AbstractModule {
    
    /**
     * /APP/Emoticons/get
     * Emoticons are a big part of Plurk since they make it easy to express feelings. Check out current Plurk emoticons.
     * @return a JSON object.
     * @throws RequestException
     */
    public JSONObject get() throws RequestException {
        return requestBy("get")
            .withoutArgs().in(HttpMethod.GET).thenJsonObject();
    }
    
    @Override
    protected String getModulePath() {
        return "/APP/Emoticons";
    }

}