package com.example.sid.marwadishaadi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.facebook.FacebookSdk;

import org.w3c.dom.Text;

public class Login extends AppCompatActivity {


    protected EditText login_email;
    protected EditText login_pass;
    protected Button login;
    protected TextView forgot;
    protected TextView signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);


        login_email = (EditText) findViewById(R.id.login_email);
        login_pass = (EditText) findViewById(R.id.login_password);
        login = (Button ) findViewById(R.id.login);

        forgot = (TextView) findViewById(R.id.forgot_link);
        signup = (TextView) findViewById(R.id.signup_link);

        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Login.this,forgot_password.class);
                startActivity(i);

            }
        });


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Login.this,Signup.class);
                startActivity(i);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = login_email.getText().toString();
                String pass = login_pass.getText().toString();

                // rest

            }
        });

    }
}
