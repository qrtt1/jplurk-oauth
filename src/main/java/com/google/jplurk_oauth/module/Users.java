package com.google.jplurk_oauth.module;

import org.json.JSONObject;

import com.google.jplurk_oauth.skeleton.AbstractModule;
import com.google.jplurk_oauth.skeleton.Args;
import com.google.jplurk_oauth.skeleton.HttpMethod;
import com.google.jplurk_oauth.skeleton.RequestException;

public class Users extends AbstractModule {

    /**
     * Returns information about current user, including page-title and user-about.
     * @return user data.
     * @throws RequestException
     */
    public JSONObject currUser() throws RequestException{
        return requestBy("currUser")
            .withoutArgs().in(HttpMethod.GET).thenJsonObject();
    }
    
    /**
     * Update a user's information (such as display name, email or privacy).
     * @param optional Optional parameters:
     * <ul>
     * <li>full_name: Change full name.</li>
     * <li>email: Change email.</li>
     * <li>display_name: User's display name, can be empty and full unicode. Must be shorter than 15 characters.</li>
     * <li>privacy: User's privacy settings. The option can be world (whole world can view the profile) or only_friends (only friends can view the profile).</li>
     * <li>date_of_birth: Should be YYYY-MM-DD, example 1985-05-13.</li>
     * </ul>
     * @return a JSON object with updated user info <code>{"id": 42, "nick_name": "frodo_b", ...}</code>
     * @throws RequestException
     */
    public JSONObject update(Args optional) throws RequestException{
        return requestBy("update")
            .with(new Args().add(optional))
            .in(HttpMethod.GET).thenJsonObject();
        
    }
    
    /**
     * Update a user's profile picture. You can read more about how to render an avatar via user data.
     * <p>You should do a multipart/form-data POST request to /API/Users/updatePicture. The picture will be scaled down to 3 versions: big, medium and small. The optimal size of profile_image should be 195x195 pixels.</p>
     * @param file The new profile image.
     * @return a JSON object with updated user info <code>{"id": 42, "nick_name": "frodo_b", ...}</code>
     * @throws RequestException
     */
    public JSONObject updatePicture(String file) throws RequestException{
    	return requestBy("updatePicture")
	            .with(new Args().add("profile_image", file))
	            .in(HttpMethod.POST).thenJsonObject();
    }
    
    /**
     * Returns info about current user's karma, including current karma, karma growth, karma graph and the latest reason why the karma has dropped.
     * @return  a JSON object with karma stats <code>{'karma_trend': ['1282046402-97.85', '1282060802-97.86', '1282075202-97.87', '1282089602-97.88', ...], 'karma_fall_reason': '', 'current_karma': 97.88, 'karma_graph': 'http://chart.apis.google.com/...'}</code>
     * @throws RequestException
     */
    public JSONObject getKarmaStats() throws RequestException{
        return requestBy("getKarmaStats")
            .withoutArgs().in(HttpMethod.GET).thenJsonObject();
    }

    @Override
    protected String getModulePath() {
        return "/APP/Users";
    }

}
