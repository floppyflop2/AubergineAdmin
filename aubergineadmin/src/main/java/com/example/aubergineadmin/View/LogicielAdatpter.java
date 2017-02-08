package com.example.aubergineadmin.View;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.example.aubergineadmin.Model.LogicielModel;

import java.util.ArrayList;

/**
 * Created by Florian on 08/02/2017.
 */

public class LogicielAdatpter extends ArrayAdapter<LogicielModel> {

    public LogicielAdatpter(Context context , ArrayList<LogicielModel> logiciels){
        super(context,0,logiciels);
    }



}
