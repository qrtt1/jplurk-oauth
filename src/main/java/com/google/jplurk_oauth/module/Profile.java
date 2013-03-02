package com.google.jplurk_oauth.module;

import org.json.JSONObject;

import com.google.jplurk_oauth.skeleton.AbstractModule;
import com.google.jplurk_oauth.skeleton.Args;
import com.google.jplurk_oauth.skeleton.HttpMethod;
import com.google.jplurk_oauth.skeleton.RequestException;

public class Profile extends AbstractModule {

    @Override
    protected String getModulePath() {
        return "/APP/Profile";
    }

    /**
     * Returns data that's private for the current user.
     * <p>This can be used to construct a profile and render a timeline of the latest plurks.</p>
     * @return Returns a JSON object with a lot of information that can be used to construct a user's own profile and timeline.
     * @throws RequestException
     */
    public JSONObject getOwnProfile() throws RequestException {
        return requestBy("getOwnProfile").withoutArgs()
            .in(HttpMethod.GET).thenJsonObject();
    }
    
    /**
     * Fetches public information such as a user's public plurks and basic information.
     * <p>Fetches also if the current user is following the user, are friends with or is a fan.</p>
     * @param userId The user_id of the public profile. Can be integer (like 34) or nick name (like amix).
     * @return Returns a JSON object with a lot of information that can be used to construct a user's public profile and timeline.
     * @throws RequestException
     */
    public JSONObject getPublicProfile(Long userId) throws RequestException {
        return requestBy("getPublicProfile")
            .with(new Args().add("user_id", userId))
            .in(HttpMethod.GET).thenJsonObject();
    }
    
    /**
     * Fetches public information such as a user's public plurks and basic information.
     * <p>Fetches also if the current user is following the user, are friends with or is a fan.</p>
     * @param userId The user_id of the public profile. Can be integer (like 34) or nick name (like amix).
     * @return Returns a JSON object with a lot of information that can be used to construct a user's public profile and timeline.
     * @throws RequestException
     */
    public JSONObject getPublicProfile(String userId) throws RequestException {
        return requestBy("getPublicProfile")
            .with(new Args().add("user_id", userId))
            .in(HttpMethod.GET).thenJsonObject();
    }

}
