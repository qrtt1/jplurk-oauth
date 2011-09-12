package com.google.jplurk_oauth.example;

import java.util.Properties;

import org.json.JSONObject;

import com.google.jplurk_oauth.Offset;
import com.google.jplurk_oauth.Qualifier;
import com.google.jplurk_oauth.module.Polling;
import com.google.jplurk_oauth.module.Timeline;
import com.google.jplurk_oauth.skeleton.PlurkOAuth;
import com.google.jplurk_oauth.skeleton.RequestException;

public class Example {
    public static void main(String[] args) throws RequestException {
        Properties prop = System.getProperties();
        
        /* create oauth config */
        PlurkOAuth auth = new PlurkOAuth(
                prop.getProperty("apikey"), prop.getProperty("apisecret"), 
                prop.getProperty("token"), prop.getProperty("tokensecret"));
        
        auth.using(Timeline.class).plurkAdd("Hello JPlurk-OAuth", Qualifier.SAYS);
    }
}
