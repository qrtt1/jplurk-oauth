package com.google.jplurk_oauth;

import java.util.Calendar;

import com.google.jplurk_oauth.skeleton.DateTime;

public class Offset {
    
    private DateTime dateTime;
    
    public Offset() {
        dateTime = DateTime.create(Calendar.getInstance());
    }
    
    public Offset(long offsetInMs)
    {
        dateTime = DateTime.create(offsetInMs);
    }

    public String formatted() {
        return dateTime.toTimeOffset();
    }
    

}
