package com.google.jplurk_oauth.module;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.jplurk_oauth.skeleton.AbstractModule;
import com.google.jplurk_oauth.skeleton.Args;
import com.google.jplurk_oauth.skeleton.HttpMethod;
import com.google.jplurk_oauth.skeleton.RequestException;

/**
 * @author Askeing
 *
 */
public class Search extends AbstractModule {
    
    /**
     * NOTE: It doesn't work now.
     * /APP/PlurkSearch/search
     * Returns the latest 20 plurks on a search term.
     * @param query The query after Plurks.
     * @return A JSON list of plurks that the user have permissions to see: [{"id": 3, "content": "Test", "qualifier_translated": "says", "qualifier": "says", ...}, ...]
     * @throws RequestException
     */
    public JSONArray plurkSearch(String query) throws RequestException {
        return requestBy("PlurkSearch/search")
        	.with(new Args().add("query", query))
        	.in(HttpMethod.GET).thenJsonArray();
    }

    /**
     * NOTE: It doesn't work now.
     * /APP/PlurkSearch/search
     * Returns the latest 20 plurks on a search term.
     * @param query The query after Plurks.
     * @param offset A plurk_id of the oldest Plurk in the last search result.
     * @return A JSON list of plurks that the user have permissions to see: [{"id": 3, "content": "Test", "qualifier_translated": "says", "qualifier": "says", ...}, ...]
     * @throws RequestException
     */
    public JSONArray plurkSearch(String query, String offset) throws RequestException {
        return requestBy("PlurkSearch/search")
        	.with(new Args().add("query", query).add("offset", offset))
        	.in(HttpMethod.GET).thenJsonArray();
    }
	
    /**
     * NOTE: The return description said the return is JSON list, but actually it is JSON Object.  
     * /APP/UserSearch/search
     * Returns 10 users that match query, users are sorted by karma.
     * @param query The query after users.
     * @return A JSON Object
     * @throws RequestException
     */
    public JSONObject userSearch(String query) throws RequestException {
        return userSearch(query, new Integer(0));
    }

    /**
     * NOTE: The return description said the return is JSON list, but actually it is JSON Object.
     * /APP/UserSearch/search
     * Returns 10 users that match query, users are sorted by karma.
     * @param query The query after users.
     * @param offset Page offset, like 10, 20, 30 etc.
     * @return A JSON Object
     * @throws RequestException
     */
    public JSONObject userSearch(String query, Integer offset) throws RequestException {
        return requestBy("UserSearch/search")
        	.with(new Args().add("query", query).add("offset", offset.toString()))
        	.in(HttpMethod.GET).thenJsonObject();
    }
	
    @Override
    protected String getModulePath() {
        return "/APP";
    }

}
