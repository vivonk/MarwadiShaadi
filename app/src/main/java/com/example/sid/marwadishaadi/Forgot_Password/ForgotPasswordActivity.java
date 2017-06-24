package com.example.sid.marwadishaadi.Forgot_Password;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sid.marwadishaadi.Analytics_Util;
import com.example.sid.marwadishaadi.R;
import com.google.firebase.analytics.FirebaseAnalytics;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class ForgotPasswordActivity extends AppCompatActivity {

    private FirebaseAnalytics mFirebaseAnalytics;
    protected EditText email;
    protected Button submit;
    protected LinearLayout call_us;
    protected TextView call_us_number;
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_forgot_password);

        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        call_us = (LinearLayout) findViewById(R.id.call_us);
        email = (EditText) findViewById(R.id.user_email);
        submit = (Button) findViewById(R.id.Submit_forgot);
        call_us_number = (TextView)findViewById((R.id.call_us_number));

        call_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // analytics
                Analytics_Util.logAnalytic(mFirebaseAnalytics,"Call Us","button");

                final Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" + call_us_number.getText().toString()));//change the number
                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

                    Toast.makeText(getApplicationContext(), "Permission for Call Denied!", Toast.LENGTH_LONG).show();
                    return;
                } else {
                    AlertDialog.Builder discarduser = new AlertDialog.Builder(ForgotPasswordActivity.this);
                    discarduser.setMessage("Do you want to call " + call_us_number.getText().toString() + " ? ")
                            .setCancelable(false)
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    startActivity(callIntent);
                                }
                            })
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });

                    // setting up dialog box
                    AlertDialog alertbox = discarduser.create();
                    alertbox.setTitle("Contact Us");
                    alertbox.show();


                }
            }});

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // analytics
                Analytics_Util.logAnalytic(mFirebaseAnalytics,"ForgotSubmit","button");

                String user_email = email.getText().toString();

                Toast.makeText(getApplicationContext(),user_email,Toast.LENGTH_LONG).show();

                // rest

            }
        });


    }

}
