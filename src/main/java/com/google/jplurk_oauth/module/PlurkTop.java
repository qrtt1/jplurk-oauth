package com.google.jplurk_oauth.module;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.jplurk_oauth.skeleton.AbstractModule;
import com.google.jplurk_oauth.skeleton.Args;
import com.google.jplurk_oauth.skeleton.HttpMethod;
import com.google.jplurk_oauth.skeleton.RequestException;

public class PlurkTop extends AbstractModule {
    
    /**
     * Returns a JSON list of PlurkTop collections.
     * @return Returns a JSON list of PlurkTop collections, e.g. <code>[ [u'Taiwan', u'cn,tr_ch,en', u'\u53f0\u7063'], [u'English', u'en', u'English'], [u'Philippines', u'en,en_fo,ta_fp', u'Pilipinas'], ... [u'Educators', u'en,es', u'Educators']] ]</code>
     * @throws RequestException
     */
    public JSONArray getCollections() throws RequestException {
        return requestBy("getCollections")
            .withoutArgs().in(HttpMethod.GET).thenJsonArray();
    }
    
    /**
     * Get topics for specified lang.
     * (default: en)
     * @return Returns a JSON list of PlurkTop topics.
     * @throws RequestException
     */
    public JSONArray getTopics() throws RequestException {
        return getTopics(null);
    }

    /**
     * Get topics for specified lang.
     * (default: en)
     * @param optional Optional parameters:
     * <ul>
     * <li>lang: get topics for specified lang (default: en)</li>
     * </ul>
     * @return Returns a JSON list of PlurkTop topics.
     * @throws RequestException
     */
    public JSONArray getTopics(Args optional) throws RequestException {
        return requestBy("getTopics")
            .with(new Args().add(optional))
            .in(HttpMethod.GET).thenJsonArray();
    }
    
    /**
     * Only get plurks in specified collection.
     * @param collection_name only get plurks in specified collection
     * @param optional Optional parameters:
     * <ul>
     * <li>offset: offset of Plurks in PlurkTop, should be an float, e.g. 0.99.</li>
     * <li>limit: number of plurks returned (default: 30)</li>
     * <li>sorting: the way to sort plurks in PlurkTop, can be "hot" for sorting by popularity or "new" for posted time.</li>
     * <li>topic_filter: only show topic with this id (default: null)</li>
     * </ul>
     * @return
     * @throws RequestException
     */
    public JSONObject getPlurks(String collection_name) throws RequestException {
    	return getPlurks(collection_name, null);
    }
    
    /**
     * Only get plurks in specified collection.
     * @param collection_name only get plurks in specified collection
     * @param optional Optional parameters:
     * <ul>
     * <li>offset: offset of Plurks in PlurkTop, should be an float, e.g. 0.99.</li>
     * <li>limit: number of plurks returned (default: 30)</li>
     * <li>sorting: the way to sort plurks in PlurkTop, can be "hot" for sorting by popularity or "new" for posted time.</li>
     * <li>topic_filter: only show topic with this id (default: null)</li>
     * </ul>
     * @return
     * @throws RequestException
     */
    public JSONObject getPlurks(String collection_name, Args optional) throws RequestException {
        return requestBy("getPlurks")
            .with(new Args().add("collection_name", collection_name).add(optional))
            .in(HttpMethod.GET).thenJsonObject();
    }
    
    @Override
    protected String getModulePath() {
        return "/APP/PlurkTop";
    }

}
