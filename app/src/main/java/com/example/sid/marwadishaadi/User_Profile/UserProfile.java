package com.example.sid.marwadishaadi.User_Profile;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.sid.marwadishaadi.R;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class UserProfile extends AppCompatActivity implements ViewPager.OnPageChangeListener,
        Profile_Personal_Details.OnFragmentInteractionListener,
        Profile_Additional_Details.OnFragmentInteractionListener,
        Profile_Family_Details.OnFragmentInteractionListener,PartnerPreferencesFragment.OnFragmentInteractionListener,
        ImageListener{

    private ProfilePageAdapter profilePageAdapter;
    private ViewPager userinfo;
    private CarouselView carouselView;
    protected ImageView pref;
    private int[] sampleImages = {R.drawable.profile, R.drawable.profile, R.drawable.profile};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        CollapsingToolbarLayout toolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        toolbarLayout.setTitle("Siddhesh Rane");

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

                AlertDialog.Builder prefs = new AlertDialog.Builder(UserProfile.this);
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
                    Profile_Personal_Details profile_personal_details = new Profile_Personal_Details();
                    return profile_personal_details;
                case 1:
                   Profile_Additional_Details profile_additional_details = new Profile_Additional_Details();
                    return profile_additional_details;
                case 2:
                    Profile_Family_Details profile_family_details = new Profile_Family_Details();
                    return profile_family_details;
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
