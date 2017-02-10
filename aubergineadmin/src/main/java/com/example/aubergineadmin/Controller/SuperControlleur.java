package com.example.aubergineadmin.Controller;

import android.content.Context;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.example.aubergineadmin.Model.ProfilModel;
import com.example.aubergineadmin.Model.UtilisateurModel;
import com.example.aubergineadmin.MySingleton;
import com.example.aubergineadmin.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

/**
 * Created by babwin on 09-02-17.
 */

public class SuperControlleur {
    private String url ;
    private static SuperControlleur mInstance;
    private static Context context;
    private SuperControlleur(Context context){
        this.url = "http://fierce-basin-74883.herokuapp.com/api/";
        context = context;
    }
    public static SuperControlleur getInstance(Context context){
        if(mInstance==null){
            mInstance= new SuperControlleur(context);
        }
        return mInstance;
    }
    public void getAllUsers(final List<UtilisateurModel> rempliMoi){
        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, url+"users/getAllUsers", null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try{
                            JSONArray liste = response.getJSONArray("liste");
                            for(int i= 0; i<liste.length(); i++){
                                JSONObject user =liste.getJSONObject(i);
                                int id = user.getInt("id");
                                String matricule = user.getString("matricule");
                                String nom = user.getString("nom");
                                String prenom = user.getString("prenom");
                                String email = user.getString("email");
                                String type = user.getString("type");
                                int date =  user.getInt("dateNaissance");
                                UtilisateurModel utilisateur = new UtilisateurModel(1, nom, prenom, matricule, email,date+"",type);

                                JSONArray logins = user.getJSONArray("logins");
                                for(int j = 0; j<logins.length();j++){

                                }
                                JSONArray profils = user.getJSONArray("profils");
                                for(int j = 0; j<profils.length();j++){
                                    JSONObject profil =profils.getJSONObject(j);
                                    int idP = profil.getInt("id");
                                    String intitule = profil.getString("intitule");
                                    ProfilModel profilM = new ProfilModel(idP,intitule);
                                    utilisateur.ajouterProfil(profilM);
                                }
                                rempliMoi.add(utilisateur);
                            }
                            Toast.makeText(context,"Liste compléter",Toast.LENGTH_LONG).show();

                        }catch (JSONException e){
                            try{
                                if(response.getString("etat").equals("ko")){
                                    System.out.println(response.getString("message"));
                                    Toast.makeText(context,response.getString("message"),Toast.LENGTH_LONG).show();
                                }
                            }catch (JSONException e2){
                                System.out.println(e2);

                            }
                            System.out.println(e);
                            rempliMoi.add(new UtilisateurModel(-1, "mauvais Json", null, null, null, null,null));
                            Toast.makeText(context,"Problem Json",Toast.LENGTH_LONG).show();
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.print(error);
                        if(error.networkResponse==null){
                            rempliMoi.add(new UtilisateurModel(-2,"Pas de connexion", null, null, null, null,null));
                            Toast.makeText(context,"Pas de connexion",Toast.LENGTH_LONG).show();
                        }else{
                            rempliMoi.add(new UtilisateurModel(-3,"Code Erreur = "+error.networkResponse.statusCode, null, null, null, null,null));
                            Toast.makeText(context,"Code Erreur = "+error.networkResponse.statusCode,Toast.LENGTH_LONG).show();
                        }
                    }
                });
        MySingleton.getInstance(context).addToRequestQueue(jsObjRequest);
    }
    public void getUser(int id, final UtilisateurModel rempliMoi){
        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, url+"users/getAllUser/"+id, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try{

                            rempliMoi.setId(response.getInt("id"));
                            rempliMoi.setMatricule(response.getString("matricule"));
                            rempliMoi.setEmail(response.getString("email"));
                            rempliMoi.setNom("");
                            rempliMoi.setPrenom("");
                            rempliMoi.setType(response.getString("type"));
                            rempliMoi.setDateDeNaissance(response.getInt("dateNaissance")+"");

                            JSONArray profils = response.getJSONArray("profils");
                            for(int j = 0; j<profils.length();j++){
                                JSONObject profil =profils.getJSONObject(j);
                                int idP = profil.getInt("id");
                                String intitule = profil.getString("intitule");
                                ProfilModel profilM = new ProfilModel(idP,intitule);
                                rempliMoi.ajouterProfil(profilM);
                            }

                            Toast.makeText(context,"ProfilCharger",Toast.LENGTH_LONG).show();

                        }catch (JSONException e){
                            try{
                                if(response.getString("etat").equals("ko")){
                                    System.out.println(response.getString("message"));
                                }
                            }catch (JSONException e2){
                                System.out.println(e2);
                            }
                            System.out.println(e);
                            rempliMoi.setId(-1);
                            rempliMoi.setNom("Mauvais Json");
                            Toast.makeText(context,"Problem Json",Toast.LENGTH_LONG).show();
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.print(error);
                        if(error.networkResponse==null){
                            rempliMoi.setId(-2);
                            rempliMoi.setNom("Pas de connexion");
                            Toast.makeText(context,"Pas de connexion",Toast.LENGTH_LONG).show();
                        }else{
                            rempliMoi.setId(-3);
                            rempliMoi.setNom("Code Erreur = "+error.networkResponse.statusCode);
                            Toast.makeText(context,"Code Erreur = "+error.networkResponse.statusCode,Toast.LENGTH_LONG).show();
                        }
                    }
                });
        MySingleton.getInstance(context).addToRequestQueue(jsObjRequest);
    }
    public void insertUser(UtilisateurModel InsertMoi){
        JSONObject jsonEnvoie=null;
        try {
            jsonEnvoie = new JSONObject("{\"matricule\":\""+InsertMoi.getMatricule()+"\",\"nom\":\""+InsertMoi.getNom()
                    +"\", \"prenom\":\""+InsertMoi.getPrenom()+"\",\"email\":\""+InsertMoi.getEmail()+
                    "\",\"dateNaissance\":\""+InsertMoi.getDateDeNaissance()+
                    "\",\"type\":\""+InsertMoi.getType()+"\"}");
        }catch (JSONException e){
            System.out.println(e);
        }
        final String mRequestBody = jsonEnvoie.toString();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try{
                    JSONObject reponse = new JSONObject(response);
                    Toast.makeText(context,reponse.getString("message"),Toast.LENGTH_LONG).show();
                }catch (JSONException e){

                    Toast.makeText(context,"erreur JSON",Toast.LENGTH_LONG).show();

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                System.out.print(error);
                if(error.networkResponse==null){
                    Toast.makeText(context,"Pas de connexion",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(context,"Code Erreur = "+error.networkResponse.statusCode,Toast.LENGTH_LONG).show();
                }

            }
        }) {
            @Override
            public String getBodyContentType() {
                return "application/json; charset=utf-8";
            }

            @Override
            public byte[] getBody() throws AuthFailureError {
                try {
                    return mRequestBody == null ? null : mRequestBody.getBytes("utf-8");
                } catch (UnsupportedEncodingException uee) {
                    System.out.println("Unsupported Encoding while trying to get the bytes of %s using %s" + mRequestBody + "utf-8");
                    return null;
                }
            }
        };
        MySingleton.getInstance(context).addToRequestQueue(stringRequest);
    }
}
