package com.growindigo.aimt.simpletaskapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.growindigo.aimt.simpletaskapp.handler.DisplayListHandler;
import java.util.List;

/**
 * Launcher activity - uses switch to capitalize names of
 *  a list
 *  List can be fetched from a local/remote DB
 *  For test purposes, value has been hardcoded from strings.xml file
 */
public class MainActivity extends AppCompatActivity {
    SwitchMaterial switchM;
    ListView listView;
    DisplayListHandler handler;

    /**
     *
     * @param savedInstanceState - default
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // instantiate variables
        switchM = findViewById(R.id.switch_main);
        listView = findViewById(R.id.name_list);
        handler = new DisplayListHandler(this);
    }

    /**
     * display list on every resume
     */
    @Override
    protected void onResume() {
        super.onResume();
        displayList();
    }

    /**
     * method to display list
     * checks for switch pressed and changes list accordingly
     */
    private void displayList(){
        List<String> list = handler.getList();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);
        switchM.setOnCheckedChangeListener((compoundButton, isChecked) -> {
            // if checked, capitalize names
            if(isChecked)
                handler.capitalizeNames();
            // if unchecked, display original list
            else
                handler.fetchOriginalList();
            // clear list and add the updated one
            list.clear();
            list.addAll(handler.getList());
            adapter.notifyDataSetChanged();
        });
    }
}