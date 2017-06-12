package com.example.sid.marwadishaadi.Chat2;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.sid.marwadishaadi.Blocked_Members.BlockedActivity;
import com.example.sid.marwadishaadi.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lawrence Dalmet on 10-06-2017.
 */

public class Messaging extends AppCompatActivity {

    private ImageView send,receive;
    private EditText typemsg;
    private List<MsgModel> msgModelList = new ArrayList<>();
    private MsgAdapter msgAdapter;
    private RecyclerView recyclerView;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.msg_recycler);
        Bundle bundle = getIntent().getExtras();
        send = (ImageView) findViewById(R.id.send);
        receive = (ImageView) findViewById(R.id.received);
        typemsg = (EditText) findViewById(R.id.typedmsg);
        recyclerView = (RecyclerView)findViewById(R.id.recycler);
        msgAdapter = new MsgAdapter(msgModelList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(Messaging.this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(msgAdapter);
        recyclerView.setHasFixedSize(true);
        MsgData();
    }

    public void MsgData()
    {

        final MsgModel[] msgModel = new MsgModel[1];

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                msgModel[0] = new MsgModel(true,typemsg.getText().toString());
                typemsg.setText("");
                msgModelList.add(msgModel[0]);
                recyclerView.getLayoutManager().smoothScrollToPosition(recyclerView, null,msgAdapter.getItemCount() - 1);
                msgAdapter.notifyDataSetChanged();
            }
        });

        receive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                msgModel[0] = new MsgModel(false,typemsg.getText().toString());
                typemsg.setText("");
                msgModelList.add(msgModel[0]);
                recyclerView.getLayoutManager().smoothScrollToPosition(recyclerView, null,msgAdapter .getItemCount() - 1);
                msgAdapter.notifyDataSetChanged();
            }
        });

    }
}
