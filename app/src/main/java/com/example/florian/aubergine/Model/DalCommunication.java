package com.example.florian.aubergine.Model;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;


import org.json.JSONObject;

/**
 * Created by Florian on 06/02/2017.
 */

public class DalCommunication {

    private String url;
    private static JSONObject resp ;// trouver solution pour mettre autrement que static mais y accéder depuis onget

    public DalCommunication(String url) {
        this.url = url;
    }

    // Add the request to the RequestQueue.
    public JSONObject onGetRequest(RequestQueue queue, String method, String id) {
        // Request a string response from the provided URL.
        System.out.println(url);
        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, url+"/"+method+"/"+id, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        resp = response;
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {


                    }
                });


       // queue.add(reqObj);
        return resp;
    }


}
