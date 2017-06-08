package com.example.sid.marwadishaadi.Dashboard_Interest;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TableLayout;

import com.example.sid.marwadishaadi.R;

public class InterestActivity extends AppCompatActivity implements
        ViewPager.OnPageChangeListener,
        InterestReceivedFragment.OnFragmentInteractionListener,
InterestSentFragment.OnFragmentInteractionListener{


    private InterestSectionPagerAdaper interestSectionPagerAdaper;
    private ViewPager mviewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interest);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.interest_toolbar);
        setSupportActionBar(myToolbar);

        interestSectionPagerAdaper = new InterestSectionPagerAdaper(getSupportFragmentManager());
        mviewpager = (ViewPager) findViewById(R.id.interest_container);
        mviewpager.setAdapter(interestSectionPagerAdaper);
        mviewpager.setOnPageChangeListener(this);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.interest_tabs);
        tabLayout.setupWithViewPager(mviewpager);

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

        switch (position){
            case 0:
                getSupportActionBar().setTitle("Received Interest");
                break;
            case 1:
                getSupportActionBar().setTitle("Sent Interest");
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public class InterestSectionPagerAdaper extends FragmentStatePagerAdapter{

        public InterestSectionPagerAdaper(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    InterestReceivedFragment interestReceivedFragment = new InterestReceivedFragment();
                    return interestReceivedFragment;
                case 1:
                    InterestSentFragment interestSentFragment = new InterestSentFragment();
                    return interestSentFragment;
            }
            return null;
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {

            switch (position){
                case 0:
                    return "Received";
                case 1:
                    return "Sent";
            }
           return null;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_interest, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_accepted:
                break;
            case R.id.action_pending:
                break;
            case R.id.action_rejected:
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
