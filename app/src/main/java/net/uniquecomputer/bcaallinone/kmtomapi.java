package net.uniquecomputer.bcaallinone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class kmtomapi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kmtomapi);

        ListView listView = findViewById(R.id.listviewkm);

        List<String> list = new ArrayList<>();
        list.add("Meters to Centimetres (M TO CM)");
        list.add("Centimetres to Meters (CM To M)");
        list.add("Feet to Inches (F-In)");
        list.add("Inches to Feet (In-F)");
        list.add("Meters to Kilometres (M-KM)");
        list.add("Kilometres to Meters (KM-M)");
        list.add("Millimetres to Nanometres (MM-NM)");
        list.add("Nanometres to Millimetres (NM-MM)");

        ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1,list);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                if(position==0){
                    //M-CM
                    startActivity(new Intent(kmtomapi.this,MCM.class));

                }else if (position==1){
                    //CM To M
                    startActivity(new Intent(kmtomapi.this,CMToM.class));

                }else if (position==2){
                    //Feet to Inches
                    startActivity(new Intent(kmtomapi.this,Fin.class));

                }else if (position==3){
                    //Inches to Feet
                    startActivity(new Intent(kmtomapi.this,IntoF.class));


                }else if (position==4){
                    //Meters to Kilometres
                    startActivity(new Intent(kmtomapi.this,MtoKm.class));


                }else if (position==5){
                    //Kilometres to Meters
                    startActivity(new Intent(kmtomapi.this,KmtoM.class));


                }else if (position==6){
                    //Millimetres to Nanometres
                    startActivity(new Intent(kmtomapi.this,MMtoNM.class));



                }else if (position==7){
                    //Nanometres to Millimetres
                    startActivity(new Intent(kmtomapi.this,NMtoMM.class));



                }



            }
        });

    }
}