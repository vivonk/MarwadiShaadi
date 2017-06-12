package com.example.sid.marwadishaadi;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;

/**
 * Created by Lawrence Dalmet on 12-06-2017.
 */

public class UpgradeMembership extends AppCompatActivity {
    Button upgrade;
    CardView maheshwari, agarwal, jain, khandelwal, others, all;
    boolean isMaheshwari,isAgarwal, isJain, isKhandelwal, isOthers, isAll;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.upgrade_membership);
        upgrade = (Button)findViewById(R.id.upgrade);
        maheshwari = (CardView) findViewById(R.id.maheshwari);
        agarwal = (CardView) findViewById(R.id.agarwal);
        jain = (CardView) findViewById(R.id.jain);
        khandelwal = (CardView) findViewById(R.id.khandelwal);
        others = (CardView) findViewById(R.id.others);
        all = (CardView) findViewById(R.id.all);

        isMaheshwari = isAgarwal = isJain = isKhandelwal = isOthers = isAll = true;

        if(!isMaheshwari)
        {
            maheshwari.setVisibility(View.GONE);
        }
        if(!isAgarwal)
        {
            agarwal.setVisibility(View.GONE);
        }
        if(!isJain)
        {
            jain.setVisibility(View.GONE);
        }
        if(!isKhandelwal)
        {
            khandelwal.setVisibility(View.GONE);
        }
        if(!isOthers)
        {
            others.setVisibility(View.GONE);
        }
        if(!isAll)
        {
            all.setVisibility(View.GONE);
        }




        upgrade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(UpgradeMembership.this,Membership.class);
                startActivity(i);
            }
        });



    }


}
