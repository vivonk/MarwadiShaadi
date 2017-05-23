package com.example.sid.marwadishaadi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class Signup extends AppCompatActivity {

    protected EditText email;
    protected EditText pass;
    protected EditText confirm;
    protected Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_signup);

       email=(EditText)findViewById(R.id.signup_email);
        pass=(EditText)findViewById(R.id.signup_password);
        confirm=(EditText)findViewById(R.id.confirm_password);

        next=(Button)findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                String uemail = email.getText().toString();
                String upass =pass.getText().toString();
                String cpass = confirm.getText().toString();

                Intent i = new Intent(Signup.this,signup_details.class);
                startActivity(i);

                // rest
        }});
    }
}
