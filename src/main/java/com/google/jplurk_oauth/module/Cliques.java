package com.google.jplurk_oauth.module;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.jplurk_oauth.skeleton.AbstractModule;
import com.google.jplurk_oauth.skeleton.Args;
import com.google.jplurk_oauth.skeleton.HttpMethod;
import com.google.jplurk_oauth.skeleton.RequestException;

public class Cliques extends AbstractModule {
    
    /**
     * Returns a JSON list of users current cliques.
     * @return Returns a JSON list of users current cliques, e.g. <code>["Homies", "Coders", ...]</code>
     * @throws RequestException
     */
    public JSONArray getCliques() throws RequestException {
        return requestBy("getCliques")
            .withoutArgs().in(HttpMethod.GET).thenJsonArray();
    }
    
    /**
     * Returns the users in the clique.
     * @param clique_name The name of the new clique
     * @return Returns the users in the clique, e.g. <code>[{"display_name": "amix3", "gender": 0, "nick_name": "amix", "has_profile_image": 1, "id": 1, "avatar": null}, ...]</code>
     * @throws RequestException
     */
    public JSONArray getClique(String clique_name) throws RequestException {
        return requestBy("getClique")
            .with(new Args().add("clique_name", clique_name))
            .in(HttpMethod.GET).thenJsonArray();
    }
    
    
    /**
     * Create the new clique.
     * @param clique_name The name of the new clique
     * @return <code>{"success_text": "ok"}</code>
     * @throws RequestException
     */
    public JSONObject createClique(String clique_name) throws RequestException {
        return requestBy("createClique")
            .with(new Args().add("clique_name", clique_name))
            .in(HttpMethod.GET).thenJsonObject();
    }
    
    /**
     * Rename the clique.
     * @param clique_name The name of the clique to rename
     * @param new_name The name of the new clique
     * @return <code>{"success_text": "ok"}</code>
     * @throws RequestException
     */
    public JSONObject renameClique(String clique_name, String new_name) throws RequestException {
        return requestBy("renameClique")
            .with(new Args().add("clique_name", clique_name).add("new_name", new_name))
            .in(HttpMethod.GET).thenJsonObject();
    }
    
    /**
     * Add the user to the clique.
     * @param clique_name The name of the clique
     * @param user_id The user to add to the clique
     * @return <code>{"success_text": "ok"}</code>
     * @throws RequestException
     */
    public JSONObject add(String clique_name, String user_id) throws RequestException {
        return requestBy("add")
            .with(new Args().add("clique_name", clique_name).add("user_id", user_id))
            .in(HttpMethod.GET).thenJsonObject();
    }
    
    /**
     * Remove the user from the clique.
     * @param clique_name The name of the clique
     * @param user_id The user to remove from the clique
     * @return <code>{"success_text": "ok"}</code>
     * @throws RequestException
     */
    public JSONObject remove(String clique_name, String user_id) throws RequestException {
        return requestBy("remove")
            .with(new Args().add("clique_name", clique_name).add("user_id", user_id))
            .in(HttpMethod.GET).thenJsonObject();
    }
    
    @Override
    protected String getModulePath() {
        return "/APP/Cliques";
    }

}
