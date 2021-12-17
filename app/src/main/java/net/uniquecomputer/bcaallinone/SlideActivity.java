package net.uniquecomputer.bcaallinone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

public class SlideActivity extends AppCompatActivity {

    ViewPager viewPager;
    SlideviewPagerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide);

        viewPager.findViewById(R.id.viewSlider);
        adapter=new SlideviewPagerAdapter(this);
        viewPager.setAdapter(adapter);

    }
}