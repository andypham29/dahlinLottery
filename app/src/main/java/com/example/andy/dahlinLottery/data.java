package com.example.andy.dahlinLottery;

import org.json.*;

/**
 * Created by Andy on 2018-01-23.
 */

public class data {
    private final String BASE_URL = "http://api.eliteprospects.com:80/beta/leagues/7/teamstats?season=2010-2011&apikey=6c55096112cbbae549d608238c861ddf";



    public data() throws JSONException {
    }

    public String showData() throws JSONException {
        try {
            JSONObject obj = new JSONObject(BASE_URL);
            String str = obj.getJSONObject("data").getString("position");
            return str;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
