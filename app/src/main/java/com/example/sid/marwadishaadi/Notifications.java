package com.example.sid.marwadishaadi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Notifications extends AppCompatActivity {

    private List<Notifications_elements> notifications_elementsList=new ArrayList<>();
    private RecyclerView recyclerView;
    private NotifAdapter notifAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);

        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        notifAdapter=  new NotifAdapter(this,notifications_elementsList);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(notifAdapter);
        prepareBlockData();

    }

    public void prepareBlockData()
    {
        Notifications_elements ne;

        ne= new Notifications_elements("Mervin",3,"https://thoughtcatalog.files.wordpress.com/2016/04/jon-snow.jpg",true,false,false,false,false,false,false,false,false);
        notifications_elementsList.add(ne);
        ne= new Notifications_elements("Mervin",3,"http://assets.viewers-guide.hbo.com/larges1-ep1-people-profilepic-lannister-jaime-800x800.jpg",false,true,false,false,false,false,false,false,false);
        notifications_elementsList.add(ne);
        ne= new Notifications_elements("Mervin",3,"http://winteriscoming.net/files/2015/12/Bran-Stark-in-Season-1.png",false,false,true,false,false,false,false,false,false);
        notifications_elementsList.add(ne);
        ne= new Notifications_elements("Mervin",3,"http://winteriscoming.net/files/2014/04/petyr-baelish-1024.jpg",false,false,false,true,false,false,false,false,false);
        notifications_elementsList.add(ne);

        notifAdapter.notifyDataSetChanged();
    }
}
