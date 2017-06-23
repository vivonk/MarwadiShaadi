package com.example.sid.marwadishaadi.Blocked_Members;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.sid.marwadishaadi.R;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.recyclerview.animators.FadeInLeftAnimator;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class BlockedActivity extends AppCompatActivity {

    private List<BlockModel> blockModelList = new ArrayList<>();
    private RecyclerView recyclerView;
    private BlockAdapter blockAdapter;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blocked);

        Toolbar toolbar = (Toolbar) findViewById(R.id.blocked_toolbar);
        toolbar.setTitle("Blocked Members");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        recyclerView = (RecyclerView) findViewById(R.id.recycle);
        FadeInLeftAnimator fadeInLeftAnimator = new FadeInLeftAnimator();
        recyclerView.setItemAnimator(fadeInLeftAnimator);
        blockAdapter = new BlockAdapter(getApplicationContext(), blockModelList);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(BlockedActivity.this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(blockAdapter);
        prepareBlockData();
    }

    public void prepareBlockData()
    {
        BlockModel blo=new BlockModel(" 124","Mervin Dalmet");
        blockModelList.add(blo);

        blo=new BlockModel(" 125","Maitree Pasad");
        blockModelList.add(blo);


        blockAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }




}
