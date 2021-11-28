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

public class timeconverterapi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeconverterapi);

        ListView listView = findViewById(R.id.timelistview);

        List<String> list = new ArrayList<>();
        list.add("Milliseconds to Nanoseconds (MS-NS)");
        list.add("Nanoseconds to Milliseconds (NS-MS)");
        list.add("Seconds to Microseconds (Sec-MicroSec)");
        list.add("Microseconds to Seconds (MicroSec-Sec)");
        list.add("Minutes to Hours (Minutes-Hours)");
        list.add("Hours to Minutes (Hours-Minutes)");
        list.add("Days-Weeks");
        list.add("Weeks-Days");
        list.add("Months-Years");
        list.add("Years-Months");


        ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1,list);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    //MS-NS
                    startActivity(new Intent(timeconverterapi.this,MStoNS.class));

                }else if (position==1){
                    //NS-MS
                    startActivity(new Intent(timeconverterapi.this,NStoMS.class));

                }else if (position==2){
                    //Seconds to Microseconds (Sec-MicroSec)
                    startActivity(new Intent(timeconverterapi.this,SectoMicroSec.class));

                }else if (position==3){
                    //MicroSec-Sec
                    startActivity(new Intent(timeconverterapi.this,MicroSectoSec.class));

                }else if (position==4){
                    //Minutes-Hours
                    startActivity(new Intent(timeconverterapi.this,MinutesHours.class));


                }else if (position==5){
                    //Hours-Minutes
                    startActivity(new Intent(timeconverterapi.this,HourstoMinutes.class));

                }else if (position==6){
                    //Days-Weeks
                    startActivity(new Intent(timeconverterapi.this,DaystoWeeks.class));

                }else if (position==7){
                    //Weeks-Days
                    startActivity(new Intent(timeconverterapi.this,WeekstoDays.class));

                }else if (position==8){
                    //Months-Years
                    startActivity(new Intent(timeconverterapi.this,MonthstoYears.class));

                }else if (position==9){
                    //Years-Months
                    startActivity(new Intent(timeconverterapi.this,YearstoMonths.class));



                }



            };
        });


    }
}