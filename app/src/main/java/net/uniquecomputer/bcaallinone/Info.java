package net.uniquecomputer.bcaallinone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.net.URI;

public class Info extends AppCompatActivity {

    ImageView facebook;
    ImageView instagram;
    ImageView youtube;
    TextView SendYourMessage;
    TextView Email;
    TextView web;

    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        bottomNavigationView = findViewById(R.id.botton_navigator);
        bottomNavigationView.setSelectedItemId(R.id.info);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId())
                {
                    case R.id.dashboard:
                        startActivity(new Intent(getApplicationContext(),Dashboard.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.info:

                        return true;

                }
                return false;
            }
        });

        Email = (TextView) findViewById(R.id.feedback);
        Email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_SENDTO);
                String uriText = "mailto:" + Uri.encode("peaceunique2003@gmail.com") + "?subject=" +
                        Uri.encode("Scientific Converter ") + "&body=" + Uri.encode("");

                Uri uri = Uri.parse(uriText);
                intent.setData(uri);
                startActivity(Intent.createChooser(intent, "Send Email"));

            }
        });

        facebook = findViewById(R.id.facebook);
        instagram = findViewById(R.id.instagram);
        youtube = findViewById(R.id.youtube);
        SendYourMessage = findViewById(R.id.SendYourMessage);
        web = findViewById(R.id.web);

        instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.instagram.com/sagardhadke_uc");
            }
        });
        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://sagardhadke.github.io/webscientific/");
            }
        });
        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.facebook.com/sagar.dhadke.9889");
            }
        });
        youtube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.youtube.com/channel/UCarobx8SpGOvAnkZjeSZ1CA");
            }
        });
        SendYourMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.google.com");
            }
        });

    }

    private void gotoUrl(String s) {
        Uri url = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,url));
    }
}
