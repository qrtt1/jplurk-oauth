package com.google.jplurk_oauth.module;

import org.json.JSONObject;

import com.google.jplurk_oauth.skeleton.AbstractModule;
import com.google.jplurk_oauth.skeleton.Args;
import com.google.jplurk_oauth.skeleton.HttpMethod;
import com.google.jplurk_oauth.skeleton.RequestException;

public class Blocks extends AbstractModule {
    
	/**
	 * /APP/Blocks/get
	 * @return
	 * @throws RequestException
	 */
	public JSONObject get() throws RequestException {
		return get(null);
	}
	
    /**
     * /APP/Blocks/get
     * @param optional offset: What page should be shown, e.g. 0, 10, 20.
     * @return A JSON list of users that are blocked by the current user, e.g. {"total": 12, "users": {"display_name": "amix3", "gender": 0, "nick_name": "amix", "has_profile_image": 1, "id": 1, "avatar": null}, ...]}
     * @throws RequestException
     */
    public JSONObject get(Args optional) throws RequestException {
        return requestBy("get")
            .with(new Args().add(optional))
            .in(HttpMethod.GET).thenJsonObject();
    }

    /**
     * /APP/Blocks/block
     * @param user_id The id of the user that should be blocked.
     * @return {"success_text": "ok"}
     * @throws RequestException
     */
    public JSONObject block(String user_id) throws RequestException {
        return requestBy("block")
            .with(new Args().add("user_id", user_id))
            .in(HttpMethod.GET).thenJsonObject();
    }
	
    /**
     * /APP/Blocks/unblock
     * @param user_id The id of the user that should be unblocked.
     * @return {"success_text": "ok"}
     * @throws RequestException
     */
    public JSONObject unblock(String user_id) throws RequestException {
        return requestBy("unblock")
            .with(new Args().add("user_id", user_id))
            .in(HttpMethod.GET).thenJsonObject();
    }
    
    @Override
    protected String getModulePath() {
        return "/APP/Blocks";
    }

}
