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

public class numbersystemApi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbersystem_api);

        ListView listView = findViewById(R.id.listview);

        List<String> list = new ArrayList<>();
        list.add("Decimal to binary");
        list.add("Binary to decimal");
        list.add("Binary to octal");
        list.add("Binary to hexa-decimal");
        list.add("Octal to decimal");
        list.add("Octal to binary");
        list.add("Octal to hexa-decimal");
        list.add("Hexa-decimal To binary");
        list.add("Hexa-decimal to octal");


        ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1,list);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0) {
                    //Decimal to binary

                    startActivity(new Intent(numbersystemApi.this,Decimaltobinary.class));

                }else if (position==1) {

                    //Binary to decimal
                }else {

                }
            };
        });


    }
}