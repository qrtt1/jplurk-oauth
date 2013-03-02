package com.google.jplurk_oauth.skeleton;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONArray;
import org.json.JSONObject;

public class RequestBuilder {

    private static Log log = LogFactory.getLog(RequestBuilder.class);
    private PlurkOAuth auth;
    private String url;
    private HttpMethod method;
    private Args args;

    public RequestBuilder(PlurkOAuth plurkOAuth, String url) {
        this.auth = plurkOAuth;
        this.url = url;
    }

    public RequestBuilder with(Args args) {
        this.args = args;
        return this;
    }

    protected String result() throws RequestException {
    	validate();
    	String result = auth.sendRequest(url, args, method);
    	if (log.isDebugEnabled())
    		log.debug(String.format("Result: %s", result));
    	return result;
    }

    public boolean validate() {
        if(url != null && args != null && method != null)
            return true;
        throw new IllegalStateException("url, args, method should all have values.");
    }

    public RequestBuilder in(HttpMethod method) {
        this.method = method;
        return this;
    }

    public JSONObject thenJsonObject() throws RequestException {
        try {
            return new JSONObject(result());
        } catch (Exception e) {
            throw new RequestException(e);
        }
    }
    
    public JSONArray thenJsonArray() throws RequestException {
        try {
            return new JSONArray(result());
        } catch (Exception e) {
            throw new RequestException(e);
        }
    }
    
    public String thenStringObject() throws RequestException {
        try {
            return result();
        } catch (Exception e) {
            throw new RequestException(e);
        }
    }

    public RequestBuilder withoutArgs() {
        return with(new Args());
    }

}
