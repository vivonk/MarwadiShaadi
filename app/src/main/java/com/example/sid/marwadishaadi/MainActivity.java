package com.example.sid.marwadishaadi;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;


import com.example.sid.marwadishaadi.Intro_Slides.Intro1Fragment;
import com.example.sid.marwadishaadi.Intro_Slides.Intro2Fragment;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener{

    private ViewPager mviewpager;

   @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SliderAdapter sliderAdapter = new SliderAdapter(getSupportFragmentManager());
        mviewpager = (ViewPager) findViewById(R.id.main_container);
        mviewpager.setAdapter(sliderAdapter);
        mviewpager.setOnPageChangeListener(this);
 SharedPreferences sharedpref=getSharedPreferences("userinfo",MODE_PRIVATE);
        boolean check = sharedpref.getBoolean("isLoggedIn",false);

        Log.d(":", "onDonePressed:--------------------------- bool is  "+check);
        if(check){
            Intent i = new Intent(MainActivity.this, Dashboard.class);
            startActivity(i);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            finish();
        }
        else {
            Intent i = new Intent(MainActivity.this, Login.class);
            startActivity(i);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            finish();
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    public class SliderAdapter extends FragmentStatePagerAdapter {

        public SliderAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    Intro1Fragment intro1Fragment = new Intro1Fragment();
                    return intro1Fragment;
                case 1:
                    Intro2Fragment intro2Fragment = new Intro2Fragment();
                    return intro2Fragment;
            }
            return null;
        }

        @Override
        public int getCount() {
            return 2;
        }

    }



}
