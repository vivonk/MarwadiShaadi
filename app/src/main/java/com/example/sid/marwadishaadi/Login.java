package com.example.sid.marwadishaadi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sid.marwadishaadi.Forgot_Password.ForgotPasswordActivity;
import com.example.sid.marwadishaadi.Otp_Verification.Otp_Verification;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;


public class Login extends AppCompatActivity {


    protected EditText login_email;
    protected EditText login_pass;
    protected Button login;
    protected TextView forgot;
    protected TextView signup;
    protected LoginButton fblogin;

    CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);


        callbackManager = CallbackManager.Factory.create();


        login_email = (EditText) findViewById(R.id.login_email);
        login_pass = (EditText) findViewById(R.id.login_password);
        login = (Button ) findViewById(R.id.login);
       /* fblogin = (LoginButton) findViewById(R.id.fb_login_button);

        fblogin.setReadPermissions(Arrays.asList("email"));
        fblogin.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {

                GraphRequest request = GraphRequest.newMeRequest(loginResult.getAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(JSONObject object, GraphResponse response) {

                        Log.d("object",object.toString());

                        try {
                            String first_name = object.getString("first_name");
                            String last_name = object.getString("last_name");
                            String gender = object.getString("gender");
                            String name = object.getString("name");

                            // check must be performed here
                            //String email = object.getString("email");
                            String birthday = object.getString("birthday");
                            Toast.makeText(getApplicationContext(),first_name + last_name + gender + birthday,Toast.LENGTH_LONG).show();

                            // MUST GO TO dashboard
                            Intent i = new Intent(Login.this,Otp_Verification.class);
                            startActivity(i);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                });

                Bundle parameters = new Bundle();
                parameters.putString("fields", "id,about,birthday,middle_name,first_name,last_name,email,gender,name,relationship_status");
                request.setParameters(parameters);
                request.executeAsync();
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });*/

        forgot = (TextView) findViewById(R.id.forgot_link);
        signup = (TextView) findViewById(R.id.signup_link);

        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Login.this,ForgotPasswordActivity.class);
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
                // @TODO to be changed
                Intent intent = new Intent(Login.this,Dashboard.class);
                startActivity(intent);

                // rest

            }
        });



    }

    @Override
    protected void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);


    }
}
