package com.roconmachine.app.marketchef.util;

import com.google.gson.Gson;

/**
 * Created by asus on 12/28/2016.
 */
public class MyGson{
    private Gson gson;
    private MyGson(){
        this.gson = new Gson();
    }

    private static MyGson instance = null;
    public static MyGson getInstance(){
        if(instance == null) instance = new MyGson();
        return  instance;
    }

    public String objectToJson(Object obj){
        return gson.toJson(obj);
    }

    public Object jsonToObject(String s, Class T){
        return this.gson.fromJson(s, T);
    }
}
