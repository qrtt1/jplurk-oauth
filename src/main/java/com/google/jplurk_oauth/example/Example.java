package com.google.jplurk_oauth.example;

import java.util.Properties;

import com.google.jplurk_oauth.Qualifier;
import com.google.jplurk_oauth.module.Timeline;
import com.google.jplurk_oauth.skeleton.PlurkOAuth;
import com.google.jplurk_oauth.skeleton.RequestException;

public class Example {
    public static void main(String[] args) throws RequestException {
        Properties prop = System.getProperties();
        
        /* create oauth config */
        PlurkOAuth auth = new PlurkOAuth(
                prop.getProperty("appkey"), prop.getProperty("appsecret"), 
                prop.getProperty("token"), prop.getProperty("tokensecret"));
        
        auth.using(Timeline.class).plurkAdd("嗯，將 apikey 改成 appkey 似乎比較恰當。", Qualifier.SAYS);
    }
}
