package com.google.jplurk_oauth.module;



import org.json.JSONObject;

import com.google.jplurk_oauth.Ids;
import com.google.jplurk_oauth.Qualifier;
import com.google.jplurk_oauth.skeleton.AbstractModule;
import com.google.jplurk_oauth.skeleton.Args;
import com.google.jplurk_oauth.skeleton.HttpMethod;
import com.google.jplurk_oauth.skeleton.RequestException;

public class Timeline extends AbstractModule {

    public JSONObject getPlurk(Long plurkId) throws RequestException {
        return getPlurk(plurkId, null);
    }
    
    public JSONObject getPlurk(Long plurkId, Args optional) throws RequestException {
        return requestBy("getPlurk")
            .with(new Args().add("plurk_id", plurkId).add(optional))
            .in(HttpMethod.GET).thenJsonObject();
    }
    
    public JSONObject getPlurks() throws RequestException {
    	return getPlurks(null);
    }
    
    public JSONObject getPlurks(Args optional) throws RequestException {
        return requestBy("getPlurks")
            .with(new Args().add(optional))
            .in(HttpMethod.GET).thenJsonObject();
    }
    
    public JSONObject getUnreadPlurks() throws RequestException {
        return getUnreadPlurks(null);
    }

    public JSONObject getUnreadPlurks(Args optional) throws RequestException {
        return requestBy("getUnreadPlurks")
            .with(new Args().add(optional)).in(HttpMethod.GET).thenJsonObject();
    }

    public JSONObject getPublicPlurks(Long userId) throws RequestException {
        return getPublicPlurks(userId);
    }
    
    public JSONObject getPublicPlurks(Long userId, Args optional) throws RequestException {
        return requestBy("getPublicPlurks")
            .with(new Args().add("user_id", userId).add(optional))
            .in(HttpMethod.GET).thenJsonObject();
    }
    
    public JSONObject plurkAdd(String content, Qualifier qualifier) throws RequestException {
        return plurkAdd(content, qualifier, null);
    }
    
    public JSONObject plurkAdd(String content, Qualifier qualifier, Args optional) throws RequestException {
        return requestBy("plurkAdd")
            .with(new Args().add("content", content)
                .add("qualifier", qualifier.toString()).add(optional))
            .in(HttpMethod.GET).thenJsonObject();
    }
    
    public JSONObject plurkDelete(Long plurkId) throws RequestException {
        return requestBy("plurkDelete")
            .with(new Args().add("plurk_id", plurkId))
            .in(HttpMethod.GET).thenJsonObject();
    }

    public JSONObject plurkEdit(Long plurkId, String content) throws RequestException {
        return requestBy("plurkEdit")
            .with(new Args().add("plurk_id", plurkId).add("content", content))
            .in(HttpMethod.GET).thenJsonObject();
    }
    
    public JSONObject mutePlurks(Ids ids) throws RequestException {
        return requestBy("mutePlurks")
            .with(new Args().add("ids", ids.formatted()))
            .in(HttpMethod.GET).thenJsonObject();
    }

    public JSONObject unmutePlurks(Ids ids) throws RequestException {
        return requestBy("unmutePlurks")
            .with(new Args().add("ids", ids.formatted()))
            .in(HttpMethod.GET).thenJsonObject();
    }

    public JSONObject favoritePlurks(Ids ids) throws RequestException {
        return requestBy("favoritePlurks")
            .with(new Args().add("ids", ids.formatted()))
            .in(HttpMethod.GET).thenJsonObject();
    }

    public JSONObject unfavoritePlurks(Ids ids) throws RequestException {
        return requestBy("unfavoritePlurks")
            .with(new Args().add("ids", ids.formatted()))
            .in(HttpMethod.GET).thenJsonObject();
    }
    
    public JSONObject replurk(Ids ids) throws RequestException {
        return requestBy("replurk")
            .with(new Args().add("ids", ids.formatted()))
            .in(HttpMethod.GET).thenJsonObject();
    }

    public JSONObject unreplurk(Ids ids) throws RequestException {
        return requestBy("unreplurk")
            .with(new Args().add("ids", ids.formatted()))
            .in(HttpMethod.GET).thenJsonObject();
    }
    
    public JSONObject markAsRead(Ids ids) throws RequestException {
        return requestBy("markAsRead")
            .with(new Args().add("ids", ids.formatted()))
            .in(HttpMethod.GET).thenJsonObject();
    }
    
    public JSONObject uploadPicture(String file) throws RequestException {
    	 return requestBy("uploadPicture")
    	            .with(new Args().add("image", file))
    	            .in(HttpMethod.POST).thenJsonObject();
    }

    
    @Override
    protected String getModulePath() {
        return "/APP/Timeline";
    }

}
