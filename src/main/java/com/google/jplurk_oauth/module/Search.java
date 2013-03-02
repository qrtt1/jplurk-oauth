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
     * Returns the latest 20 plurks on a search term.
     * <p>NOTE: It doesn't work now.</p>
     * @param query The query after Plurks.
     * @return A JSON list of plurks that the user have permissions to see: [{"id": 3, "content": "Test", "qualifier_translated": "says", "qualifier": "says", ...}, ...]
     * @throws RequestException
     */
    public JSONArray plurkSearch(String query) throws RequestException {
        return plurkSearch(query, null);
    }

    /**
     * Returns the latest 20 plurks on a search term.
     * <p>NOTE: It doesn't work now.</p>
     * @param query The query after Plurks.
     * @param optional offset: A plurk_id of the oldest Plurk in the last search result.
     * @return A JSON list of plurks that the user have permissions to see: [{"id": 3, "content": "Test", "qualifier_translated": "says", "qualifier": "says", ...}, ...]
     * @throws RequestException
     */
    public JSONArray plurkSearch(String query, Args optional) throws RequestException {
        return requestBy("PlurkSearch/search")
        	.with(new Args().add("query", query).add(optional))
        	.in(HttpMethod.GET).thenJsonArray();
    }
	
    /**
     * Returns 10 users that match query, users are sorted by karma.
     * <p>NOTE: The return description said the return is JSON list, but actually it is JSON Object.</p>  
     * @param query The query after users.
     * @return A JSON Object
     * @throws RequestException
     */
    public JSONObject userSearch(String query) throws RequestException {
        return userSearch(query, null);
    }

    /**
     * Returns 10 users that match query, users are sorted by karma.
     * <p>NOTE: The return description said the return is JSON list, but actually it is JSON Object.</p> 
     * @param query The query after users.
     * @param optional offset: Page offset, like 10, 20, 30 etc.
     * @return A JSON Object
     * @throws RequestException
     */
    public JSONObject userSearch(String query, Args optional) throws RequestException {
        return requestBy("UserSearch/search")
        	.with(new Args().add("query", query).add(optional))
        	.in(HttpMethod.GET).thenJsonObject();
    }
	
    @Override
    protected String getModulePath() {
        return "/APP";
    }

}
