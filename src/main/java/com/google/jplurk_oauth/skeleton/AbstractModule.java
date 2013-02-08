package com.google.jplurk_oauth.skeleton;

public abstract class AbstractModule {

    public static final String API_URL_PREFIX = "http://www.plurk.com";

    private PlurkOAuth plurkOAuth;

    public void setPlurkOAuth(PlurkOAuth auth) {
        this.plurkOAuth = auth;
    }

    protected abstract String getModulePath();

    protected RequestBuilder requestBy(String url) {
        return new RequestBuilder(plurkOAuth, API_URL_PREFIX + getModulePath() + "/" + url);
    }
    
    protected RequestBuilder requestSpecificURL(String url, Args args) {
    	return new RequestBuilder(plurkOAuth, url).with(args);
    }
}
