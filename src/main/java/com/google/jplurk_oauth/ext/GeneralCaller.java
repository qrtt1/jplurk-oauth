package com.google.jplurk_oauth.ext;

import com.google.jplurk_oauth.skeleton.AbstractModule;
import com.google.jplurk_oauth.skeleton.Args;
import com.google.jplurk_oauth.skeleton.HttpMethod;
import com.google.jplurk_oauth.skeleton.RequestException;

/**
 * @author Askeing
 * The general API caller can call APIs directly by API path.<br/>
 * It get more flexible to support new APIs is not implemented in modules.
 * 
 * <p><strong>NOTE</strong>: We suggest ONLY use this class when there is new API which is not implemented in modules.</p> 
 */
public class GeneralCaller extends AbstractModule {

    @Override
    protected String getModulePath() {
        return "";
    }
    
    /**
     * Call API directly by HTTP GET method.
     * @param apiPath the API path
     * @return
     * @throws RequestException
     */
    public String callApi(String apiPath) throws RequestException {
        return callApi(apiPath, null, HttpMethod.GET);
    }

    /**
     * Call API directly by HTTP GET method.
     * @param apiPath the API path
     * @param args parameters
     * @return
     * @throws RequestException
     */
    public String callApi(String apiPath, Args args) throws RequestException {
        return callApi(apiPath, args, HttpMethod.GET);
    }
    
    /**
     * Call API directly.
     * @param apiPath the API path
     * @param args parameters
     * @param method GET or POST
     * @return
     * @throws RequestException
     */
    public String callApi(String apiPath, Args args, HttpMethod method) throws RequestException {
    	/* 
    	 * To avoid the URL problem, if apiPath start with "/", remove it.
    	 * ex: If apiPath is "/APP/Users/currUser", the request URL will become "http://www.plurk.com//APP/Users/currUser".
    	 * */
    	if(apiPath.startsWith("/"))
    		apiPath = apiPath.substring(1);
    	
        return requestBy(apiPath)
            .with(new Args().add(args))
            .in(method).thenStringObject();
    }

}
