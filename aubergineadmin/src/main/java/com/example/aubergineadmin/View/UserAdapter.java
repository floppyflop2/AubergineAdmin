package com.example.aubergineadmin.View;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.aubergineadmin.Model.LogicielModel;
import com.example.aubergineadmin.Model.UtilisateurModel;
import com.example.aubergineadmin.R;

import java.util.ArrayList;

/**
 * Created by Florian on 09/02/2017.
 */

public class UserAdapter extends ArrayAdapter<UtilisateurModel> {

    /**
     @param context
     @param utilisateurs
     */
    public UserAdapter(Context context , ArrayList<UtilisateurModel> utilisateurs){
        super(context,0,utilisateurs);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       UtilisateurModel utilisateur = getItem(position);
        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list,parent,false);
        }
      //  (TextView) tvId = (TextView)convertView.findViewById(R.id.userid);
        TextView tvMatricule = (TextView) convertView.findViewById(R.id.usermatricule);
        TextView tvName = (TextView) convertView.findViewById(R.id.username);
        TextView tvSection = (TextView) convertView.findViewById(R.id.usersection);

        tvMatricule.setText(utilisateur.getMatricule());
        tvName.setText(utilisateur.getNom());
        tvSection.setText(utilisateur.getSection());

        return convertView;
    }

}
