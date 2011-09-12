package com.google.jplurk_oauth.skeleton;

import java.util.HashMap;
import java.util.Map;

public class Args {

    Map<String, String> map;

    private String key;
    private String value;

    public Args() {
        this(new HashMap<String, String>());
    }

    public Args(Map<String, String> map) {
        this.map = map;
    }

    public Args name(String key) {
        this.key = key;
        checkAndPush();
        return this;
    }
    
    public Args value(int value) {
        return value(Integer.toString(value));
    }

    public Args value(String value) {
        this.value = value;
        checkAndPush();
        return this;
    }
    
    public Args add(String key, String value){
        return name(key).value(value);
    }
    
    public Args add(String key, Object value){
        return name(key).value("" + value);
    }

    private void checkAndPush() {
        if (key != null && value != null) {
            map.put(key, value);
            this.key = null;
            this.value = null;
        }
    }

    public Map<String, String> getMap() {
        return map;
    }

    public Args add(Args args) {
        if (args != null) {
            map.putAll(args.getMap());
        }
        return this;
    }
}
