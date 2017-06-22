package com.example.sid.marwadishaadi.Login;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.sid.marwadishaadi.Analytics_Util;
import com.example.sid.marwadishaadi.Dashboard.DashboardActivity;
import com.example.sid.marwadishaadi.Forgot_Password.ForgotPasswordActivity;
import com.example.sid.marwadishaadi.R;
import com.example.sid.marwadishaadi.Signup.SignupActivity;
import com.facebook.CallbackManager;
import com.facebook.login.widget.LoginButton;
import com.google.firebase.analytics.FirebaseAnalytics;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;


public class LoginActivity extends AppCompatActivity {


    protected EditText login_email;
    protected EditText login_pass;
    protected Button login;
    protected TextView forgot;
    protected TextView signup;
    protected LoginButton fblogin;

    private FirebaseAnalytics mFirebaseAnalytics;

    CallbackManager callbackManager;
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
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
                            Intent i = new Intent(LoginActivity.this,Otp_VerificationActivity.class);
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

                // analytics
                Analytics_Util.logAnalytic(mFirebaseAnalytics,"Forgot","button");
                Intent i = new Intent(LoginActivity.this,ForgotPasswordActivity.class);
                startActivity(i);

            }
        });


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // analytics
                Analytics_Util.logAnalytic(mFirebaseAnalytics,"Signup","button");
                Intent i = new Intent(LoginActivity.this,SignupActivity.class);
                startActivity(i);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // analytics
                Analytics_Util.logAnalytic(mFirebaseAnalytics,"Login","button");

                String email = login_email.getText().toString();
                String pass = login_pass.getText().toString();
                // @TODO to be changed
                Intent intent = new Intent(LoginActivity.this,DashboardActivity.class);
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
