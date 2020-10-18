package com.company;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.*;

public class Main {

    public static void main(String[] args) {
    parseJson();

    }

    public static void parseJson() {
        FS fs = new FS();
        JSONObject obj = new JSONObject(fs.readJson());
        Iterator iter = obj.keys();
        while(iter.hasNext()){
            String key = (String)iter.next();
            System.out.println(key );
            JSONObject plantObj = obj.getJSONObject(key);
            Iterator objIter = plantObj.keys();
            while (objIter.hasNext()) {
                String key2 = (String)objIter.next();
                String value = plantObj.getString(key2);
                System.out.println(key2 + " " + value);
            }
        }
    }
}
