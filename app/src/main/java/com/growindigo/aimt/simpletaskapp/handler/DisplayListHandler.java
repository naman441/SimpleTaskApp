package com.growindigo.aimt.simpletaskapp.handler;

import android.content.Context;

import com.growindigo.aimt.simpletaskapp.remote.RemoteDbHandler;
import com.growindigo.aimt.simpletaskapp.repo.ListRepo;

import org.apache.commons.lang3.StringUtils;
import java.util.ArrayList;
import java.util.List;

/**
 * handler class for all the backend functions
 */
public class DisplayListHandler {

    private List<String> list;
    private final Context context;

    /**
     * constructor fetches list
     * @param context - context used for getting DB calls or
     *                in this case, get list from string.xml
     */
    public DisplayListHandler(Context context){
        this.context = context;
        fetchOriginalList();
    }

    /**
     * simple return method
     * @return - list
     */
    public List<String> getList(){
        return list;
    }

    /**
     * handles capitalization
     * using apache.commons lib
     */
    public void capitalizeNames(){
        List<String> l = new ArrayList<>(list.size());
        for(String s : list){
            l.add(StringUtils.capitalize(s));
        }
        list = l;
    }

    /**
     * fetches original list
     * first checks the local db
     * if null - load from remote
     */
    public void fetchOriginalList(){
        list = new ListRepo(context).getListFromDb();
        if(list == null){
            list = new RemoteDbHandler().getRemoteData(context);
        }
    }
}
