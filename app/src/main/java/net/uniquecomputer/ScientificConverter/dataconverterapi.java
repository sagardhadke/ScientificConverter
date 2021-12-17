package net.uniquecomputer.ScientificConverter;

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
                    //MB-GB
                    startActivity(new Intent(dataconverterapi.this,MBGB.class));

                }else if (position==3){
                    //GB-MB
                    startActivity(new Intent(dataconverterapi.this,GBMB.class));


                }else if (position==4){
                    //MB-TB
                    startActivity(new Intent(dataconverterapi.this,MBTB.class));

                }else if (position==5){
                    //TB-MB
                    startActivity(new Intent(dataconverterapi.this,TbMB.class));

                }else if (position==6){
                    //GB-TB
                    startActivity(new Intent(dataconverterapi.this,GBTB.class));


                }else if (position==7){
                    //TB-GB
                    startActivity(new Intent(dataconverterapi.this,TBGB.class));

                }else if (position==8){
                    //Bytes-MB
                    startActivity(new Intent(dataconverterapi.this,BytesMB.class));


                }else if (position==9){
                    //Bytes-GB
                    startActivity(new Intent(dataconverterapi.this,BytesGB.class));


                }else if (position==10){
                    //Bytes-TB
                    startActivity(new Intent(dataconverterapi.this,BytesTB.class));




                }

            }
        });

    }
}