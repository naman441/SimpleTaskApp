package com.growindigo.aimt.simpletaskapp.repo;

import android.content.Context;

import com.growindigo.aimt.simpletaskapp.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListRepo {

    private final Context context;

    /**
     * - constructor to get DB instance
     * - DAO instance obtained using DB object - DAO used as query interface for ROOM
     */
    public ListRepo(Context context){
        this.context = context;
    }

    public List<String> getListFromDb(){
        // value hardcoded for test purpose
        List<String> listStr = new ArrayList<>();
       Collections.addAll(listStr, context.getResources().getStringArray(R.array.names));
       return listStr;
    }
}
