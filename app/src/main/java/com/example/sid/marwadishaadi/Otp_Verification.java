package com.example.sid.marwadishaadi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Otp_Verification extends AppCompatActivity {

    protected EditText otp ;
    protected Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp__verification);

        otp =( EditText) findViewById(R.id.user_otp);
        submit = (Button ) findViewById(R.id.Submit_otp);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String user_otp = otp.getText().toString();

                // rest
            }
        });


    }
}
