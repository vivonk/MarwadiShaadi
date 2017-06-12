package com.example.sid.marwadishaadi.Chat2;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.sid.marwadishaadi.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lawrence Dalmet on 11-06-2017.
 */

public class InboxActivity extends AppCompatActivity {

    InboxAdapter inboxAdapter;
    List<InboxModel> inboxModelsList;
    RecyclerView recyclerView;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inbox_recycler);

        inboxModelsList = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        inboxAdapter = new InboxAdapter(inboxModelsList,getApplicationContext());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(inboxAdapter);
        recyclerView.setHasFixedSize(true);
        prepareInbox();

    }

    private void prepareInbox() {
        InboxModel inboxModel = new InboxModel("https://avatars2.githubusercontent.com/u/13920107?v=3&s=460","Mervin Dalmet","hi, how r u?","2:30","1",true);
        inboxModelsList.add(inboxModel);
        inboxModel = new InboxModel("https://scontent.fbom1-1.fna.fbcdn.net/v/t1.0-9/542932_1870229913255094_1073152164360738877_n.jpg?oh=414cb9683ac4daa8f7a67f63316215f6&oe=59ABFA15","Siddhesh Rane","I am fine","3:00","2",true);
        inboxModelsList.add(inboxModel);
        inboxModel = new InboxModel("https://lh3.googleusercontent.com/-_2FnlCFcgfA/WTUS3yDAXII/AAAAAAAAIHg/IRXv4NgTIcMlyoDaGfr8IYdVR2y_9ccugCK8B/s512/2017-06-05.jpg","Maitree Pasad","cool","1:00","0",false);
        inboxModelsList.add(inboxModel);
        inboxModel = new InboxModel("https://avatars2.githubusercontent.com/u/13920107?v=3&s=460","Mervin Dalmet","hi, how r u?","2:30","1",false);
        inboxModelsList.add(inboxModel);
        inboxModel = new InboxModel("https://lh3.googleusercontent.com/-_2FnlCFcgfA/WTUS3yDAXII/AAAAAAAAIHg/IRXv4NgTIcMlyoDaGfr8IYdVR2y_9ccugCK8B/s512/2017-06-05.jpg","Siddhesh Rane","I am fine","3:00","2",true);
        inboxModelsList.add(inboxModel);

        inboxAdapter.notifyDataSetChanged();

    }
}
