package com.example.sid.marwadishaadi.User_Profile;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;

import com.example.sid.marwadishaadi.Similar_Profiles.SimilarActivity;
import com.github.clans.fab.FloatingActionButton;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.sid.marwadishaadi.R;
import com.github.clans.fab.FloatingActionMenu;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class
UserProfileActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener,
        ProfilePersonalDetailsFragment.OnFragmentInteractionListener,
        ProfileAdditionalDetailsFragment.OnFragmentInteractionListener,
        ProfileFamilyDetailsFragment.OnFragmentInteractionListener,PartnerPreferencesFragment.OnFragmentInteractionListener,
        ImageListener{

    private ProfilePageAdapter profilePageAdapter;
    private ViewPager userinfo;
    private CarouselView carouselView;
    protected ImageView pref;
    private int[] sampleImages = {R.drawable.profile, R.drawable.profile, R.drawable.profile};
    private FloatingActionButton fav;
    private FloatingActionButton sendmsg;
    private FloatingActionButton sendinterest;
    private FloatingActionButton shareprofile;
    private FloatingActionButton sharesave;
    private FloatingActionMenu fab;
    private CoordinatorLayout coordinatorLayout;
    private FrameLayout frameLayout;
    private Button similar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        CollapsingToolbarLayout toolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        toolbarLayout.setTitle("Siddhesh Rane");

        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.entire_ui);
        frameLayout = (FrameLayout) findViewById(R.id.fabmenu);

        fab = (FloatingActionMenu) findViewById(R.id.menu_yellow);
        fav = (FloatingActionButton) findViewById(R.id.fab_favourite);
        sendmsg = (FloatingActionButton) findViewById(R.id.fab_send_message);
        sendinterest = (FloatingActionButton) findViewById(R.id.fab_send_interest);
        shareprofile = (FloatingActionButton) findViewById(R.id.fab_share_profile);
        sharesave = (FloatingActionButton) findViewById(R.id.fab_save);

        similar = (Button)findViewById(R.id.similar);

        similar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(UserProfileActivity.this, SimilarActivity.class);
                startActivity(i);
            }
        });

        fab.setOnMenuToggleListener(new FloatingActionMenu.OnMenuToggleListener() {
            @Override
            public void onMenuToggle(boolean opened) {
                if (opened) {
                    coordinatorLayout.setBackgroundColor(Color.parseColor("#1A2d2d2d"));
                } else {
                    coordinatorLayout.setBackgroundColor(Color.TRANSPARENT);
                }
                Toast.makeText(getApplicationContext(),"yay", Toast.LENGTH_SHORT).show();
            }
        });



        fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        sendmsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        sendinterest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        shareprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        sharesave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        carouselView = (CarouselView) findViewById(R.id.carouselView);
        carouselView.setPageCount(sampleImages.length);
        carouselView.setImageListener(this);

        profilePageAdapter = new ProfilePageAdapter(getSupportFragmentManager());
        userinfo = (ViewPager) findViewById(R.id.profile_container);
        userinfo.setAdapter(profilePageAdapter);
        userinfo.setOnPageChangeListener(this);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.profile_tabs);
        tabLayout.setupWithViewPager(userinfo);

      /*  pref= (ImageView) findViewById(R.id.profile_user_preferences);
        pref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                View preferences_view = getLayoutInflater().inflate(R.layout.profile_preferences,null);

                AlertDialog.Builder prefs = new AlertDialog.Builder(UserProfileActivity.this);
                prefs.setTitle("Partner Preferences");
                prefs.setView(preferences_view);

                // creating
                AlertDialog uprefs = prefs.create();
                uprefs.setTitle("Partner Preferences");
                uprefs.show();
            }
        });*/

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

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void setImageForPosition(int position, ImageView imageView) {
        imageView.setImageResource(sampleImages[position]);

    }



    public static class ProfilePageAdapter extends FragmentPagerAdapter{

        public ProfilePageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            switch (position){
                case 0:
                    ProfilePersonalDetailsFragment profile_personal_detailsFragment = new ProfilePersonalDetailsFragment();
                    return profile_personal_detailsFragment;
                case 1:
                   ProfileAdditionalDetailsFragment profile_additional_detailsFragment = new ProfileAdditionalDetailsFragment();
                    return profile_additional_detailsFragment;
                case 2:
                    ProfileFamilyDetailsFragment profile_family_detailsFragment = new ProfileFamilyDetailsFragment();
                    return profile_family_detailsFragment;
                case 3:
                    PartnerPreferencesFragment partnerPreferencesFragment= new PartnerPreferencesFragment();
                    return partnerPreferencesFragment;
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
                    return "Personal Details";
                case 1:
                    return "Additional Details";
                case 2:
                    return "Family Details";
                case 3:
                    return "Partner Preferences";
                default:
                    return null;
            }
        }
    }
}
