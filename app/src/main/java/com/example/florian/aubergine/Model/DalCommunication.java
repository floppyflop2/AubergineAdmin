package com.example.florian.aubergine.Model;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

/**
 * Created by Florian on 06/02/2017.
 */

public class DalCommunication {

    public String url;

    public DalCommunication(String url){
        this.url = url;
    }

    // Add the request to the RequestQueue.
    public String onGetRequest(RequestQueue queue, String method){
        // Request a string response from the provided URL.
        StringRequest reqString = new StringRequest(Request.Method.GET, url+method,
                new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        System.out.println("Response is: "+ response.substring(0,500));

                    }


                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //  mTextView.setText("That didn't work!");
            }
        });

        queue.add(reqString);
    }


}
