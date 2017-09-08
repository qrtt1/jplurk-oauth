package com.google.jplurk_oauth.module;

import com.google.jplurk_oauth.skeleton.Args;
import org.json.JSONObject;

import com.google.jplurk_oauth.skeleton.AbstractModule;
import com.google.jplurk_oauth.skeleton.HttpMethod;
import com.google.jplurk_oauth.skeleton.RequestException;

public class Emoticons extends AbstractModule {
    
    /**
     * Get the Emoticons list.
     * <p>Emoticons are a big part of Plurk since they make it easy to express feelings.<p>
     * @return a JSON object.
     * @throws RequestException
     */
    public JSONObject get() throws RequestException {
        return requestBy("get")
            .withoutArgs().in(HttpMethod.GET).thenJsonObject();
    }

    public JSONObject addFromURL(String url) throws RequestException {
        return requestBy("addFromURL")
                .with(new Args().add("url", url))
                .in(HttpMethod.GET).thenJsonObject();
    }

    public JSONObject addFromURL(String url, Args optional) throws RequestException {
        return requestBy("addFromURL")
                .with(new Args().add("url", url).add(optional))
                .in(HttpMethod.GET).thenJsonObject();
    }

    public JSONObject delete(String url) throws RequestException {
        return requestBy("delete")
                .with(new Args().add("url", url))
                .in(HttpMethod.GET).thenJsonObject();
    }
    
    @Override
    protected String getModulePath() {
        return "/APP/Emoticons";
    }

}
