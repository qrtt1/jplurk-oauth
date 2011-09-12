package com.google.jplurk_oauth.module;

import org.json.JSONObject;

import com.google.jplurk_oauth.Offset;
import com.google.jplurk_oauth.skeleton.AbstractModule;
import com.google.jplurk_oauth.skeleton.Args;
import com.google.jplurk_oauth.skeleton.HttpMethod;
import com.google.jplurk_oauth.skeleton.RequestException;

public class Polling extends AbstractModule {
    
    public JSONObject getPlurks(Offset offset) throws RequestException {
        return requestBy("getPlurks")
            .with(new Args().add("offset", offset.formatted()))
            .in(HttpMethod.GET).thenJsonObject();
    }

    public JSONObject getUnreadCount() throws RequestException {
        return requestBy("getUnreadCount")
            .withoutArgs().in(HttpMethod.GET).thenJsonObject();
    }
    
    @Override
    protected String getModulePath() {
        return "/APP/Polling";
    }

}
