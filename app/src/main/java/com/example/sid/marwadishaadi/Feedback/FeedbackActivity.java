package com.example.sid.marwadishaadi.Feedback;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sid.marwadishaadi.R;

public class FeedbackActivity extends AppCompatActivity {

    protected EditText fftext;
    protected Button send;
    protected CheckBox email_response;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_feedback);

        fftext=(EditText) findViewById(R.id.edt_feedback);
        send=(Button) findViewById(R.id.sendFeedback);
        email_response = (CheckBox) findViewById(R.id.email_response);

        // TODO: 30-May-17 change border of edit text on key press
      fftext.setOnFocusChangeListener(new View.OnFocusChangeListener() {
          @Override
          public void onFocusChange(View v, boolean hasFocus) {
              fftext.setBackgroundResource(R.drawable.edit_text_border);
          }
      });

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean email_response_required = false;
                if (email_response.isChecked()){
                    email_response_required = true;
                }
                String subject = "FeedbackActivity";
                String feedback=fftext.getText().toString();
                if(!feedback.trim().isEmpty())
                {

                    String TO = "techteam@marwadishaadi.com";
                    Intent send = new Intent(Intent.ACTION_SENDTO);
                    String uriText = "mailto:" + Uri.encode(TO) +
                            "?subject=" + Uri.encode(subject) +
                            "&body=" + Uri.encode(feedback);
                    Uri uri = Uri.parse(uriText);
                    send.setData(uri);
                    startActivity(Intent.createChooser(send, "Send mail..."));
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Please Enter Text in FeedbackActivity Details", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
