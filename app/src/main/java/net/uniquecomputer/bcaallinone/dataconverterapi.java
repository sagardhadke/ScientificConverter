package net.uniquecomputer.bcaallinone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class dataconverterapi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dataconverterapi);

        ListView listView = findViewById(R.id.listviewdata);

        List<String> list = new ArrayList<>();
        list.add("KB-MB");
        list.add("MB-KB");
        list.add("MB-GB");
        list.add("GB-MB");
        list.add("MB-TB");
        list.add("TB-MB");
        list.add("GB-TB");
        list.add("TB-GB");
        list.add("Bytes-MB");
        list.add("Bytes-GB");
        list.add("Bytes-TB");

        ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1,list);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    //KB-MB
                    startActivity(new Intent(dataconverterapi.this,KBMB.class));

                }else if (position==1){
                    //MB-KB
                    startActivity(new Intent(dataconverterapi.this,MBKB.class));

                }else if (position==2){


                }

            }
        });

    }
}