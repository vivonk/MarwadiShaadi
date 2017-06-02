package com.example.sid.marwadishaadi;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Blocked extends AppCompatActivity {

    private List<Block> blockList= new ArrayList<>();
    private RecyclerView recyclerView;
    private BlockAdapter blockAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blocked);


        recyclerView = (RecyclerView) findViewById(R.id.recycle);

        blockAdapter = new BlockAdapter(getApplicationContext(),blockList);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(Blocked.this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(blockAdapter);
        prepareBlockData();
    }

    public void prepareBlockData()
    {
        Block blo=new Block(" 124","Mervin Dalmet");
        blockList.add(blo);

        blo=new Block(" 125","Maitree Pasad");
        blockList.add(blo);

        blockAdapter.notifyDataSetChanged();
    }
}
