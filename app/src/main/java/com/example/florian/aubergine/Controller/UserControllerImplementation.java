package com.example.florian.aubergine.Controller;

import android.view.View;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.apache.http.*;

import com.example.florian.aubergine.Model.DalCommunication;
import com.example.florian.aubergine.Model.UtilisateurModel;
import com.example.florian.aubergine.View.MainActivity;

import java.io.File;
import java.util.Date;

/**
 * Created by Florian on 06/02/2017.
 */


public class UserControllerImplementation implements UserController{

    public static String url = "http://fierce-basin-74883.herokuapp.com/api/hello";
    MainActivity view;
    // Instantiate the RequestQueue.
    RequestQueue queue = Volley.newRequestQueue(view);
    DalCommunication dalCommunication;

    public UserControllerImplementation(MainActivity view, DalCommunication dalCommunication){
        this.view = view;
        this.dalCommunication=dalCommunication;

        // Instantiate the cache  ps donner l'adresse du cache
        Cache cache = new DiskBasedCache( new File("bl"), 1024*1024); // 1MB cap
        // Set up the network to use HttpURLConnection as the HTTP client.
        Network network = new BasicNetwork(new HurlStack());
    // Instantiate the RequestQueue with the cache and network.
        queue = new RequestQueue(cache, network);

        queue.start();
    }


    @Override
    public UtilisateurModel login(String authentifiant, Date dateN) {
       String demand = "login";
       dalCommunication.onGetRequest(queue, demand);

    }
}
