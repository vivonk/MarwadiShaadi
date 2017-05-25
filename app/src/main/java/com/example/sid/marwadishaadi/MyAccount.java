package com.example.sid.marwadishaadi;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.AccessToken;
import com.facebook.login.LoginManager;

public class MyAccount extends AppCompatActivity {

    protected LinearLayout linearLayoutMore;
    protected LinearLayout linearLayoutMoreExpand;
    protected TextView logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_account);

        linearLayoutMore = (LinearLayout) findViewById(R.id.linearLayoutMore);
        linearLayoutMoreExpand = (LinearLayout) findViewById(R.id.linearLayoutMoreExpand);
        logout = (TextView) findViewById(R.id.Logout);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder logout_user = new AlertDialog.Builder(MyAccount.this);
                logout_user.setMessage("Do you want to logout ?")
                        .setCancelable(true)
                        .setTitle("Logout")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                // perform check
                                LoginManager.getInstance().logOut();
                                AccessToken.setCurrentAccessToken(null);

                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alertbox = logout_user.create();
                alertbox.setTitle("Logout");
                alertbox.show();
            }
        });

        linearLayoutMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (linearLayoutMoreExpand.getVisibility() == View.VISIBLE) {
                    linearLayoutMoreExpand.setVisibility(View.GONE);
                } else {
                    linearLayoutMoreExpand.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}
