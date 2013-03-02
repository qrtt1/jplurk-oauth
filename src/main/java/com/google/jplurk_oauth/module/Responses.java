package com.google.jplurk_oauth.module;

import org.json.JSONObject;

import com.google.jplurk_oauth.Qualifier;
import com.google.jplurk_oauth.skeleton.AbstractModule;
import com.google.jplurk_oauth.skeleton.Args;
import com.google.jplurk_oauth.skeleton.HttpMethod;
import com.google.jplurk_oauth.skeleton.RequestException;

public class Responses extends AbstractModule {

    /**
     * Fetches responses for plurk with plurk_id and some basic info about the users.
     * @param plurkId The plurk that the responses belong to.
     * @return Returns a JSON object of responses, friends (users that has posted responses) and responses_seen (the last response that the logged in user has seen) e.g. <code>{"friends": {"3": ...}, "responses_seen": 2, "responses": [{"lang": "en", "content_raw": "Reforms...}}</code>
     * @throws RequestException
     */
    public JSONObject get(Long plurkId) throws RequestException {
        return get(plurkId, null);
    }
    
    /**
     * Fetches responses for plurk with plurk_id and some basic info about the users.
     * @param plurkId The plurk that the responses belong to.
     * @param optional Optional parameters:
     * <ul>
     * <li>from_response: Only fetch responses from an offset - could be 5, 10 or 15 (default: 0)</li>
     * </ul>
     * @return Returns a JSON object of responses, friends (users that has posted responses) and responses_seen (the last response that the logged in user has seen) e.g. <code>{"friends": {"3": ...}, "responses_seen": 2, "responses": [{"lang": "en", "content_raw": "Reforms...}}</code>
     * @throws RequestException
     */
    public JSONObject get(Long plurkId, Args optional) throws RequestException {
        return requestBy("get")
            .with(new Args().add("plurk_id", plurkId).add(optional))
            .in(HttpMethod.GET).thenJsonObject();
    }
    
    /**
     * Adds a responses to plurk_id. Language is inherited from the plurk.
     * @param plurkId The plurk that the responses should be added to.
     * @param content The response's text.
     * @param qualifier  The Plurk's qualifier, must be in English.
     * @return Returns a JSON object of the new responses, e.g. <code>{"id": 3, "content": "Test", "qualifier_translated": "says", "qualifier": "says", ...}</code>
     * @throws RequestException
     */
    public JSONObject responseAdd(Long plurkId, String content, Qualifier qualifier)
            throws RequestException {
        return requestBy("responseAdd")
            .with(new Args().add("plurk_id", plurkId)
                    .add("content", content).add("qualifier", qualifier.toString()))
            .in(HttpMethod.GET)
            .thenJsonObject();
    }
    
    /**
     * Deletes a response. A user can delete own responses or responses that are posted to own plurks.
     * @param responseId The id of the response to delete.
     * @param plurkId The plurk that the response belongs to.
     * @return <code>{"success_text": "ok"}</code> if the response has been deleted.
     * @throws RequestException
     */
    public JSONObject responseDelete(Long responseId, Long plurkId) throws RequestException {
        return requestBy("responseDelete")
            .with(new Args().add("response_id", responseId).add("plurk_id", plurkId))
            .in(HttpMethod.GET).thenJsonObject();
    }

    @Override
    protected String getModulePath() {
        return "/APP/Responses";
    }

}
