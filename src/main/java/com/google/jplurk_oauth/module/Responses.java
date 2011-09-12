package com.google.jplurk_oauth.module;

import org.json.JSONObject;

import com.google.jplurk_oauth.Qualifier;
import com.google.jplurk_oauth.skeleton.AbstractModule;
import com.google.jplurk_oauth.skeleton.Args;
import com.google.jplurk_oauth.skeleton.HttpMethod;
import com.google.jplurk_oauth.skeleton.RequestException;

public class Responses extends AbstractModule {

    public JSONObject get(Long plurkId) throws RequestException {
        return requestBy("get")
            .with(new Args().add("plurk_id", plurkId))
            .in(HttpMethod.GET).thenJsonObject();
    }
    
    public JSONObject responseAdd(Long plurkId, String content, Qualifier qualifier)
            throws RequestException {
        return requestBy("responseAdd")
            .with(new Args().add("plurk_id", plurkId)
                    .add("content", content).add("qualifier", qualifier.toString()))
            .in(HttpMethod.GET)
            .thenJsonObject();
    }
    
    public JSONObject responseDelete(Long responseId, Long plurkId) throws RequestException {
        return requestBy("responseDelete")
            .with(new Args().add("response_id", responseId).add("plurk_id", plurkId))
            .in(HttpMethod.GET).thenJsonObject();
    }

    @Override
    protected String getModulePath() {
        return "/APP/Responses";
    }

}
