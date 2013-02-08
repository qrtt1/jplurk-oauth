package com.google.jplurk_oauth.module;

import org.json.JSONObject;

import com.google.jplurk_oauth.skeleton.AbstractModule;
import com.google.jplurk_oauth.skeleton.Args;
import com.google.jplurk_oauth.skeleton.HttpMethod;
import com.google.jplurk_oauth.skeleton.RequestException;

public class Users extends AbstractModule {

    public JSONObject currUser() throws RequestException{
        return requestBy("currUser")
            .withoutArgs().in(HttpMethod.GET).thenJsonObject();
    }
    
    public JSONObject update(Args optional) throws RequestException{
        return requestBy("update")
            .with(new Args().add(optional))
            .in(HttpMethod.GET).thenJsonObject();
        
    }
    
    public JSONObject updatePicture(String file) throws RequestException{
    	return requestBy("updatePicture")
	            .with(new Args().add("profile_image", file))
	            .in(HttpMethod.POST).thenJsonObject();
    }
    
    public JSONObject getKarmaStats() throws RequestException{
        return requestBy("getKarmaStats")
            .withoutArgs().in(HttpMethod.GET).thenJsonObject();
    }

    @Override
    protected String getModulePath() {
        return "/APP/Users";
    }

}
