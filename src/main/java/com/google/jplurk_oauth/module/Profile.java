package com.google.jplurk_oauth.module;

import org.json.JSONObject;

import com.google.jplurk_oauth.skeleton.AbstractModule;
import com.google.jplurk_oauth.skeleton.Args;
import com.google.jplurk_oauth.skeleton.HttpMethod;
import com.google.jplurk_oauth.skeleton.RequestException;

public class Profile extends AbstractModule {

    @Override
    protected String getModulePath() {
        return "/APP/Profile";
    }

    public JSONObject getOwnProfile() throws RequestException {
        return requestBy("getOwnProfile").withoutArgs()
            .in(HttpMethod.GET).thenJsonObject();
    }
    
    public JSONObject getPublicProfile(Long userId) throws RequestException {
        return requestBy("getPublicProfile")
            .with(new Args().add("user_id", userId))
            .in(HttpMethod.GET).thenJsonObject();
    }
    
    public JSONObject getPublicProfile(String userId) throws RequestException {
        return requestBy("getPublicProfile")
            .with(new Args().add("user_id", userId))
            .in(HttpMethod.GET).thenJsonObject();
    }

}
