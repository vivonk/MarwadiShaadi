package com.example.sid.marwadishaadi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class UploadPhotoActivity extends AppCompatActivity {

     Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_photo);

        submit= (Button)findViewById(R.id.submit_photo);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(UploadPhotoActivity.this,Dashboard.class);
                startActivity(i);
            }
        });
    }


}
