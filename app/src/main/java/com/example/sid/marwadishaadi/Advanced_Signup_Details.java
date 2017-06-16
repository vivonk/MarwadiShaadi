package com.example.sid.marwadishaadi;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sid.marwadishaadi.Otp_Verification.Otp_Verification;
import com.example.sid.marwadishaadi.Search.SearchResultsActivity;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

import static com.facebook.FacebookSdk.getApplicationContext;

public class Advanced_Signup_Details extends AppCompatActivity implements StepperLayout.StepperListener{

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    private StepperLayout mStepperLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_advanced__signup__details);

        mStepperLayout = (StepperLayout) findViewById(R.id.stepperLayout);
        mStepperLayout.setAdapter(new MyStepperAdapter(getSupportFragmentManager(), this));
        mStepperLayout.setListener(this);
    }

    @Override
    public void onCompleted(View completeButton) {
        Intent i = new Intent(Advanced_Signup_Details.this,Otp_Verification.class);
        startActivity(i);
        overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
    }

    @Override
    public void onError(VerificationError verificationError) {

    }

    @Override
    public void onStepSelected(int newStepPosition) {

    }

    @Override
    public void onReturn() {
        Intent i = new Intent(Advanced_Signup_Details.this,signup_details.class);
        startActivity(i);
        overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
    }
}
