package com.example.sid.marwadishaadi;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.SearchView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.sid.marwadishaadi.Chat.DefaultDialogsActivity;
import com.example.sid.marwadishaadi.Dashboard_Favourites.FavouritesFragment;
import com.example.sid.marwadishaadi.Dashboard_Interest.InterestActivity;
import com.example.sid.marwadishaadi.Dashboard_Membership.UpgradeMembershipActivity;
import com.example.sid.marwadishaadi.Dashboard_Recent_Profiles.RecentProfilesFragment;
import com.example.sid.marwadishaadi.Dashboard_Reverse_Matching.Reverse_MatchingActivity;
import com.example.sid.marwadishaadi.Dashboard_Suggestions.SuggestionsFragment;
import com.example.sid.marwadishaadi.Dashboard_Super_Match.SuperMatchFragment;
import com.example.sid.marwadishaadi.Feedback.FeedbackActivity;
import com.example.sid.marwadishaadi.Notifications.NotificationsActivity;
import com.example.sid.marwadishaadi.Search.Search;
import com.example.sid.marwadishaadi.Search.SearchResultsActivity;
import com.example.sid.marwadishaadi.Settings.SettingsActivity;
import com.example.sid.marwadishaadi.User_Profile.UserProfileActivity;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class Dashboard extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        ViewPager.OnPageChangeListener,
        BasicInfo.OnFragmentInteractionListener,
        Additional_Info.OnFragmentInteractionListener,
        Preferences.OnFragmentInteractionListener,
        SuperMatchFragment.OnFragmentInteractionListener{

    private DashboardSectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    private ImageView userdp;
    private LinearLayout interest;
    private LinearLayout inbox;
    private LinearLayout search;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_navigation_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.dash_toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        View mview = navigationView.getHeaderView(0);
        userdp = (ImageView) mview.findViewById(R.id.user_dp);
        userdp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Dashboard.this, UserProfileActivity.class);
                startActivity(i);
                overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
            }
        });

        interest = (LinearLayout)mview.findViewById(R.id.nav_interest);
        interest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Dashboard.this, InterestActivity.class);
                startActivity(i);
                overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
            }
        });


        inbox = (LinearLayout)mview.findViewById(R.id.nav_inbox);
        inbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Dashboard.this, DefaultDialogsActivity.class);
                startActivity(i);
                overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
            }
        });


        search = (LinearLayout)mview.findViewById(R.id.nav_search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Dashboard.this,Search.class);
                startActivity(i);
                overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
            }
        });

        navigationView.setItemIconTintList(null);
        navigationView.setNavigationItemSelectedListener(this);

        mSectionsPagerAdapter = new DashboardSectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.dash_container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.setOnPageChangeListener(this);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.dash_tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    public void onBackPressed() {


            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            } else {
                super.onBackPressed();
            }


    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here .
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        Menu menu = navigationView.getMenu();
        int id = item.getItemId();
       if (id == R.id.nav_home){
                onBackPressed();
        }else if (id == R.id.nav_interest){
            Intent i = new Intent(Dashboard.this,InterestActivity.class);
            startActivity(i);
            overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
        }
        else if (id == R.id.nav_notifications) {
            Intent i = new Intent(Dashboard.this,NotificationsActivity.class);
            startActivity(i);
            overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
        }else if(id == R.id.nav_membership){
            Intent i = new Intent(Dashboard.this,UpgradeMembershipActivity.class);
            startActivity(i);
            overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
        }
        else if (id == R.id.nav_settings) {
            Intent i = new Intent(Dashboard.this,SettingsActivity.class);
            startActivity(i);
            overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
        }else if (id == R.id.nav_feedback){
            Intent i = new Intent(Dashboard.this,FeedbackActivity.class);
            startActivity(i);
            overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
        }

            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
            return true;

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

        int count = 35;

        switch (position){
            case 0:
                getSupportActionBar().setTitle("Suggestions ("+count+")");
                break;
            case 1:
                getSupportActionBar().setTitle("Recent Profiles ("+count+")");
                break;
            case 2:
                getSupportActionBar().setTitle("Reverse Matching ("+count+")");
                break;
            case 3:
                getSupportActionBar().setTitle("Favourites ("+count+")");
                break;
           /* case 4:
                getSupportActionBar().setTitle("Super Match ("+count+")");
                break;*/


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
                   SuggestionsFragment suggestionsFragment = new SuggestionsFragment();
                    return suggestionsFragment;
                case 1:
                   RecentProfilesFragment recent_profilesFragment = new RecentProfilesFragment();
                    return recent_profilesFragment;
                case 2:
                    Reverse_MatchingActivity reverse_matchingActivity = new Reverse_MatchingActivity();
                    return reverse_matchingActivity;
                case 3:
                   FavouritesFragment favouritesFragment = new FavouritesFragment();
                    return favouritesFragment;
               /*case 4:
                    SuperMatchFragment superMatchFragment = new SuperMatchFragment();
                    return superMatchFragment;*/

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
               /* case 4:
                    return "Super Match";*/

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
                Intent i = new Intent(Dashboard.this,SearchResultsActivity.class);
                startActivity(i);
                overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
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
