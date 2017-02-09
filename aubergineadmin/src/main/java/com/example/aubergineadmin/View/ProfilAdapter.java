package com.example.aubergineadmin.View;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.aubergineadmin.Model.LogicielModel;
import com.example.aubergineadmin.Model.ProfilModel;
import com.example.aubergineadmin.R;

import java.util.ArrayList;

/**
 * Created by Florian on 09/02/2017.
 */

public class ProfilAdapter extends ArrayAdapter<ProfilModel> {
    public static String url = "http://fierce-basin-74883.herokuapp.com/api";
    /**
     @param context
     @param profils
     */
    public ProfilAdapter(Context context , ArrayList<ProfilModel> profils){
        super(context,0,profils);
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ProfilModel profil = getItem(position);
        if(convertView==null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list, parent, false);
        }

        TextView logicielName = (TextView)convertView.findViewById(R.id.nameLogiciel);
        logicielName.setText(profil.getNomLogiciel());
        return convertView;

    }

}
