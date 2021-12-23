package com.growindigo.aimt.simpletaskapp.remote;

import android.content.Context;
import com.growindigo.aimt.simpletaskapp.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * remote db handler class
 * can be Firebase for actual application
 */
public class RemoteDbHandler {

    /**
     *
     * @param context - context for connection
     *                or in this case, for loading list fro strings.xml
     * @return - list
     */
    public List<String> getRemoteData(Context context){
        // value hardcoded for test purpose
        List<String> listStr = new ArrayList<>();
        Collections.addAll(listStr, context.getResources().getStringArray(R.array.names));
        return listStr;
    }
}
