package com.google.jplurk_oauth.module;

import org.json.JSONObject;

import com.google.jplurk_oauth.skeleton.AbstractModule;
import com.google.jplurk_oauth.skeleton.HttpMethod;
import com.google.jplurk_oauth.skeleton.RequestException;

public class Users extends AbstractModule {

    public JSONObject getKarmaStats() throws RequestException{
        return requestBy("getKarmaStats")
            .withoutArgs().in(HttpMethod.GET).thenJsonObject();
    }

    @Override
    protected String getModulePath() {
        return "/APP/Users";
    }

}
