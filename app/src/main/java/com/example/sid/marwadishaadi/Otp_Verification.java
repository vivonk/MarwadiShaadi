package com.example.sid.marwadishaadi;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Otp_Verification extends AppCompatActivity {

    protected EditText otp;
    protected Button submit;
    protected TextView call_us;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp__verification);

        otp = (EditText) findViewById(R.id.user_otp);
        submit = (Button) findViewById(R.id.Submit_otp);
        call_us = (TextView) findViewById(R.id.call_us);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String user_otp = otp.getText().toString();

                // rest
            }
        });

        call_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" + call_us.getText().toString()));//change the number
                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

                    Toast.makeText(getApplicationContext(),"Permission for Call Denied!",Toast.LENGTH_LONG).show();
                    return;
                }else{
                    AlertDialog.Builder discarduser = new AlertDialog.Builder(Otp_Verification.this);
                    discarduser.setMessage("Do you want to call " + call_us.getText().toString() + " ? ")
                            .setCancelable(false)
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id)
                                {
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
            }
        });

    }
}
