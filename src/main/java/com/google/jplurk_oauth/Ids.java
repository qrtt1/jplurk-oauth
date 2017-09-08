package com.google.jplurk_oauth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.json.JSONArray;

public class Ids {

    private List<Integer> idList = new ArrayList<Integer>();

    public Ids() {
    }

    public Ids(List<Integer> idList) {
        if (idList != null && !idList.isEmpty()) {
            this.idList.addAll(idList);
        }
    }

    public String formatted() {
        return new JSONArray(idList).toString();
    }

    public static Ids values(Integer... ids) {
        return new Ids(Arrays.asList(ids));
    }

}
