package com.example.sid.marwadishaadi.Membership;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.view.View;

import com.example.sid.marwadishaadi.R;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by Lawrence Dalmet on 12-06-2017.
 */

public class UpgradeMembershipActivity extends AppCompatActivity {
    Button upgrade;
    CardView maheshwari, agarwal, jain, khandelwal, others, all;
    boolean isMaheshwari,isAgarwal, isJain, isKhandelwal, isOthers, isAll;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.upgrade_membership);

        Toolbar toolbar = (Toolbar) findViewById(R.id.upgrademembership_toolbar);
        toolbar.setTitle("MembershipActivity");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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
                Intent i = new Intent(UpgradeMembershipActivity.this,MembershipActivity.class);
                startActivity(i);
            }
        });



    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

}
