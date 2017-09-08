package com.google.jplurk_oauth;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

import com.google.jplurk_oauth.module.Timeline;
import com.google.jplurk_oauth.skeleton.PlurkOAuth;
import com.google.jplurk_oauth.skeleton.PlurkOAuth.PlurkOAuthBuilder;

public class JPlurkTest {

    @Test
    public void testApis() throws Exception {
        PlurkOAuth client = PlurkOAuthBuilder.builderFromEnv();
        JSONObject plurksResult = client.using(Timeline.class).getPlurks();
        JSONArray plurks = plurksResult.getJSONArray("plurks");
        assertTrue(plurks.length() > 0);

        JSONObject plurk = (JSONObject) plurks.get(0);
        Integer id = plurk.getInt("plurk_id");
        JSONObject result = client.using(Timeline.class).unmutePlurks(Ids.values(id));
        assertEquals("ok", result.getString("success_text"));
    }

}
