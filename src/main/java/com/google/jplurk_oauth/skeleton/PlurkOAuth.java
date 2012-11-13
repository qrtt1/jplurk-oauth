package com.google.jplurk_oauth.skeleton;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.scribe.builder.ServiceBuilder;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;
import org.scribe.utils.URLUtils;


public class PlurkOAuth {
    
    private static Log log = LogFactory.getLog(PlurkOAuth.class);

    @SuppressWarnings("serial")
    private static Map<HttpMethod, Verb> actionMap = new HashMap<HttpMethod, Verb>() {
        {
            put(HttpMethod.DELETE, Verb.DELETE);
            put(HttpMethod.GET, Verb.GET);
            put(HttpMethod.POST, Verb.POST);
            put(HttpMethod.PUT, Verb.PUT);
        }
    };
    
    @SuppressWarnings("rawtypes")
    private static Map<Class, Object> cachedModule = new HashMap<Class, Object>();
    
    private OAuthService service;
    private Token token;

    public PlurkOAuth(String appKey, String appSecret, String token, String tokenSecret) {
        super();
        this.service = new ServiceBuilder()
            .provider(PlurkOAuthConfig.class)
            .apiKey(appKey)
            .apiSecret(appSecret).build();
        this.token = new Token(token, tokenSecret);
    }

    public String sendRequest(String url, Args args, HttpMethod method) throws RequestException {
        OAuthRequest request = new OAuthRequest(actionMap.get(method), url);
        log.info("args: " + args.map);
        if(HttpMethod.POST.equals(method) || HttpMethod.PUT.equals(method))
        {
        	if(args.getMap().get("image")!=null){
                service.signRequest(token, request);
        		File file = new File(args.getMap().get("image"));
        		return this.uploadFile(request, file);
        	}else{
        		addBodyParams(request, args);
        	}
        }
        else
        {
            addQueryStrings(request, args);
        }
        
        service.signRequest(token, request);
        Response response = request.send();
        if(response.getCode() != 200)
        {
            throw new RequestException(String.format("http status %d, body: %s", response.getCode(), response.getBody()));
        }
        return response.getBody();
    }

    private void addBodyParams(OAuthRequest request, Args args) {
        for (Entry<String, String> e : args.map.entrySet()) {
            request.addBodyParameter(e.getKey(), e.getValue());
        }
    }

    private void addQueryStrings(OAuthRequest request, Args args) {
        
        for (Entry<String, String> e : args.map.entrySet()) {
            request.addQuerystringParameter(e.getKey(), e.getValue());
        }
    }

    @SuppressWarnings("unchecked")
    public <T> T using(Class<T> clazz) {
        try {
            if (cachedModule.containsKey(clazz) && cachedModule.get(clazz) != null) {
                return (T) cachedModule.get(clazz);
            }
            T instance = clazz.newInstance();
            if (instance instanceof AbstractModule) {
                AbstractModule module = (AbstractModule) instance;
                module.setPlurkOAuth(this);
                cachedModule.put(clazz, instance);
                return instance;
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    private String uploadFile(OAuthRequest request,File file) {
        HttpClient hc = new HttpClient();
        Map<String, String> querystringParams = request.getOauthParameters();
        String url = URLUtils.appendParametersToQueryString(request.getUrl(), querystringParams);
        PostMethod post = new PostMethod(url);
        String responseString = null;
        try {
            FilePart filePart = new FilePart("image", file.getName(), file, "image/png", "UTF-8");
            filePart.setTransferEncoding("binary");
            Part[] parts = new Part[] { filePart };
            post.setRequestEntity(new MultipartRequestEntity(parts, post.getParams()));
            int responseCode = hc.executeMethod(post);
            if (responseCode == 200) {
                responseString = post.getResponseBodyAsString();
            } else{
            }
        } catch (FileNotFoundException fe) {
        	fe.printStackTrace();
        } catch (HttpException he) {
        	he.printStackTrace();
        } catch (IOException ioe) {
        	ioe.printStackTrace();
        } finally {
            post.releaseConnection();
        }
        return responseString;
    }

}
