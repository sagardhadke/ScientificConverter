package net.uniquecomputer.bcaallinone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Dashboard extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    ImageView imageView5;   // creating object
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

       // imageView5=findViewById(R.id.imageView5);     // giving id to the image
        imageView5.setOnClickListener(new View.OnClickListener() {                     // click of image
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Dashboard.this,CategoryActivity.class));         // calling another  activity
            }
        });

        bottomNavigationView = findViewById(R.id.botton_navigator);
        bottomNavigationView.setSelectedItemId(R.id.dashboard);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId())
                {
                    case R.id.dashboard:
                        return true;
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.info:
                        startActivity(new Intent(getApplicationContext(),Info.class));
                        overridePendingTransition(0,0);
                        return true;

                }
                return false;
            }
        });

    }
}
