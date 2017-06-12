package com.example.sid.marwadishaadi.Notifications;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.sid.marwadishaadi.R;

import java.util.ArrayList;
import java.util.List;

public class NotificationsActivity extends AppCompatActivity {

    private List<NotificationsModel> notificationsModelList =new ArrayList<>();
    private RecyclerView recyclerView;
    private NotificationsAdapter notificationsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);

        Toolbar toolbar = (Toolbar) findViewById(R.id.notify_toolbar);
        toolbar.setTitle("Notifications");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        notificationsAdapter =  new NotificationsAdapter(this, notificationsModelList);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(notificationsAdapter);
        prepareBlockData();

    }

    public void prepareBlockData()
    {
        NotificationsModel ne;

        ne= new NotificationsModel("Mervin",3,true,false,false,false,false,false,false,false,false);
        notificationsModelList.add(ne);
        ne= new NotificationsModel("Mervin",3,false,true,false,false,false,false,false,false,false);
        notificationsModelList.add(ne);
        ne= new NotificationsModel("Mervin",3,false,false,true,false,false,false,false,false,false);
        notificationsModelList.add(ne);
        ne= new NotificationsModel("Mervin",3,false,false,false,true,false,false,false,false,false);
        notificationsModelList.add(ne);
        ne= new NotificationsModel("Mervin",3,false,false,false,false,true,false,false,false,false);
        notificationsModelList.add(ne);
        ne= new NotificationsModel("Mervin",3,false,false,false,false,false,true,false,false,false);
        notificationsModelList.add(ne);
        ne= new NotificationsModel("Mervin",3,false,false,false,false,false,false,true,false,false);
        notificationsModelList.add(ne);
        ne= new NotificationsModel("Mervin",3,false,false,false,false,false,false,false,true,false);
        notificationsModelList.add(ne);
        ne= new NotificationsModel("Mervin",3,false,false,false,false,false,false,false,false,true);
        notificationsModelList.add(ne);

        notificationsAdapter.notifyDataSetChanged();
    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
