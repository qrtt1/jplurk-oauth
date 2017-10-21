package com.google.jplurk_oauth.example;

import com.google.jplurk_oauth.module.Realtime;
import com.google.jplurk_oauth.skeleton.PlurkOAuth;
import com.google.jplurk_oauth.skeleton.RequestException;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CometExample {
    //  Fill your APP_KEY, APP_SECRET, TOKEN, TOKEN_SECRET here
    private static final String APP_KEY = "";
    private static final String APP_SECRET = "";

    private static final String TOKEN = "";
    private static final String TOKEN_SECRET = "";

    public static void main(String[] args) throws RequestException, JSONException {
        PlurkOAuth auth = new PlurkOAuth(
                APP_KEY, APP_SECRET,
                TOKEN, TOKEN_SECRET);

        JSONObject getUserChannelResults = auth.using(Realtime.class).getUserChannel();
        String cometServer = getUserChannelResults.getString("comet_server");

        while (true) {
            //  response example: CometChannel.scriptCallback({"new_offset": -1});
            String response = auth.using(Realtime.class).cometUserChannel(cometServer);
            Pattern pattern = Pattern.compile("CometChannel.scriptCallback\\((.+)\\);");
            Matcher matcher = pattern.matcher(response);

            if (matcher.matches()) {
                String notificationData = matcher.group(1);
                JSONObject notificationJson = new JSONObject(notificationData);
                System.out.println(notificationJson.toString(4));
            }
        }
    }
}
