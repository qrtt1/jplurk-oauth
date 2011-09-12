package com.google.jplurk_oauth.skeleton;

import org.scribe.builder.api.DefaultApi10a;
import org.scribe.model.Token;

public class PlurkOAuthConfig extends DefaultApi10a
{

    @Override
    public String getRequestTokenEndpoint()
    {
        return "http://www.plurk.com/OAuth/request_token";
    }

    @Override
    public String getAccessTokenEndpoint()
    {
        return "http://www.plurk.com/OAuth/access_token";
    }

    @Override
    public String getAuthorizationUrl(Token requestToken)
    {
        return String.format("http://www.plurk.com/OAuth/authorize?oauth_token=%s", requestToken.getToken());
    }

}
