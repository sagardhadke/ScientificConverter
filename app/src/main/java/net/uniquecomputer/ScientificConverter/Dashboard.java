package net.uniquecomputer.ScientificConverter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class Dashboard extends AppCompatActivity implements View.OnClickListener {

    public CardView cardRecommended;

    BottomNavigationView bottomNavigationView;
 //   ImageView imageView5;   // creating object
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        setupMoviesViewPager();

        cardRecommended = (CardView) findViewById(R.id.cardRecommended);

        cardRecommended.setOnClickListener(this);

       // imageView5=findViewById(R.id.imagePoster);     // giving id to the image
       // imageView5.setOnClickListener(new View.OnClickListener() {                     // click of image
       //     @Override
        //   public void onClick(View view) {
      //          startActivity(new Intent(Dashboard.this,CategoryActivity.class));         // calling another  activity
      //      }
      //  });

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

    private void setupMoviesViewPager() {
        ViewPager2 moviesViewPager = findViewById(R.id.appviewpage);
        moviesViewPager.setClipToPadding(false);
        moviesViewPager.setClipChildren(false);
        moviesViewPager.setOffscreenPageLimit(3);
        moviesViewPager.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);
        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(10));
        compositePageTransformer.addTransformer((page, position) -> {
            float r = 1 - Math.abs(position);
            page.setScaleY(0.85f + r * 0.15f);
        });
        moviesViewPager.setPageTransformer(compositePageTransformer);
        moviesViewPager.setAdapter(new MoviesAdapter(getMovies(),Dashboard.this));

    }

    private List<Movie> getMovies() {
        List<Movie> movies = new ArrayList<>();

        Movie java = new Movie();
        java.poster = R.drawable.java;
        java.name = "Java online compiler";
        java.category = "James Gosling";
        java.releaseDate = "May 23, 1995";
        java.rating = 4.6f;
        movies.add(java);


        Movie Python = new Movie();
        Python.poster = R.drawable.pythonlo;
        Python.name = "python online compiler";
        Python.category = "Guido van Rossum";
        Python.releaseDate = "20 February 1991";
        Python.rating = 4.8f;
        movies.add(Python);

        Movie CPP = new Movie();
        CPP.poster = R.drawable.cpp;
        CPP.name = "CPP online compiler";
        CPP.category = "Bjarne Stroustrup";
        CPP.releaseDate = "15 December 2020";
        CPP.rating = 4.6f;
        movies.add(CPP);

        Movie PHP = new Movie();
        PHP.poster = R.drawable.php;
        PHP.name = "PHP online compiler";
        PHP.category = "Rasmus Lerdorf";
        PHP.releaseDate = "June 8, 1995";
        PHP.rating = 4.3f;
        movies.add(PHP);

        Movie HtmlCssJavaS = new Movie();
        HtmlCssJavaS.poster = R.drawable.htmlcss;
        HtmlCssJavaS.name = "Html Css Js online compiler";
        HtmlCssJavaS.category = "WHATWG";
        HtmlCssJavaS.releaseDate = "1993";
        HtmlCssJavaS.rating = 4.0f;
        movies.add(HtmlCssJavaS);

        return movies;

    }

    @Override
    public void onClick(View view) {
        Intent i;

        switch (view.getId()) {
            case R.id.cardRecommended :
                i = new Intent(this,CategoryActivity.class);
                startActivity(i);
                break;

        }

    }
}
