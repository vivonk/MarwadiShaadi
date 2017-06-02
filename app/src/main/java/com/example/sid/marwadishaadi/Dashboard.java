package com.example.sid.marwadishaadi;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

public class Dashboard extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,ViewPager.OnPageChangeListener,BasicInfo.OnFragmentInteractionListener,Additional_Info.OnFragmentInteractionListener,Preferences.OnFragmentInteractionListener{


    private DashboardSectionsPagerAdapter mSectionsPagerAdapter;

    private ViewPager mViewPager;

    boolean more = false;

    public void MoreDrawer(){
        setContentView(R.layout.more_navigation_drawer);

        Toolbar toolbar = (Toolbar) findViewById(R.id.dash_toolbar);
        setSupportActionBar(toolbar);

        final DrawerLayout more_drawer = (DrawerLayout) findViewById(R.id.more_drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, more_drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        more_drawer.setDrawerListener(toggle);
        toggle.syncState();


        NavigationView navigationView = (NavigationView) findViewById(R.id.more_nav_view);
        navigationView.setNavigationItemSelectedListener(this);



        View header = navigationView.getHeaderView(0);
        ImageView back = (ImageView) header.findViewById(R.id.back_more);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                more_drawer.closeDrawer(GravityCompat.START);
                more=true;
                InitUi();
            }
        });

        mSectionsPagerAdapter = new DashboardSectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.dash_container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.setOnPageChangeListener(this);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.dash_tabs);
        tabLayout.setupWithViewPager(mViewPager);

        more_drawer.openDrawer(GravityCompat.START);

    }

    public void InitUi(){
        setContentView(R.layout.activity_navigation_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.dash_toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        mSectionsPagerAdapter = new DashboardSectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.dash_container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.setOnPageChangeListener(this);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.dash_tabs);
        tabLayout.setupWithViewPager(mViewPager);

        if(more){
            drawer.openDrawer(GravityCompat.START);
            more=false;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        InitUi();
    }

    @Override
    public void onBackPressed() {

        DrawerLayout more_drawer = (DrawerLayout) findViewById(R.id.more_drawer_layout);
        if(more_drawer!=null){
            if (more_drawer.isDrawerOpen(GravityCompat.START)) {
                more_drawer.closeDrawer(GravityCompat.START);
            } else {
                super.onBackPressed();
            }
        }else{
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            } else {
                super.onBackPressed();
            }
        }

    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_notifications) {

            Intent i = new Intent(Dashboard.this,Notifications.class);
            startActivity(i);
            overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
        }else if(id == R.id.nav_membership){
            Intent i = new Intent(Dashboard.this,Membership.class);
            startActivity(i);
            overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
        }
        else if (id == R.id.nav_settings) {
            Intent i = new Intent(Dashboard.this,Settings.class);
            startActivity(i);
            overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
        }else if(id == R.id.nav_more){
            MoreDrawer();
        }else if (id == R.id.nav_feedback){
            Intent i = new Intent(Dashboard.this,Feedback.class);
            startActivity(i);
            overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
        }else if (id == R.id.nav_privacy_policy){
            Intent i = new Intent(Dashboard.this,Privacy_policy.class);
            startActivity(i);
            overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
        }

        return true;

       // DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
       // drawer.closeDrawer(GravityCompat.START);
        //return true;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

        switch (position){
            case 0:
                getSupportActionBar().setTitle("Suggestions");
                break;
            case 1:
                getSupportActionBar().setTitle("Recent Profiles");
                break;
            case 2:
                getSupportActionBar().setTitle("Reverse Matching");
                break;
            case 3:
                getSupportActionBar().setTitle("Favourites");
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public class DashboardSectionsPagerAdapter extends FragmentPagerAdapter {



        public DashboardSectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            switch (position){
                case 0:
                   Suggestions suggestions = new Suggestions();
                    return suggestions;
                case 1:
                   Recent_Profiles recent_profiles = new Recent_Profiles();
                    return recent_profiles;
                case 2:
                    Reverse_Matching reverse_matching = new Reverse_Matching();
                    return  reverse_matching;
                case 3:
                   Favourites favourites = new Favourites();
                    return favourites;
            }
            return null;
        }

        @Override
        public int getCount() {
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0:
                    return "Suggestions";
                case 1:
                    return "Recent Profiles";
                case 2:
                    return "Reverse Matching";
                case 3:
                    return "Favourites";
                default:
                    return null;
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu( Menu menu) {
        getMenuInflater().inflate(R.menu.navigation_drawer, menu);

        final MenuItem myActionMenuItem = menu.findItem( R.id.action_search);
        final SearchView searchView = (SearchView) myActionMenuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(Dashboard.this,query, Toast.LENGTH_SHORT).show();
                if( ! searchView.isIconified()) {
                    searchView.setIconified(true);
                }
                myActionMenuItem.collapseActionView();
                return false;
            }
            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
        return true;
    }


}
