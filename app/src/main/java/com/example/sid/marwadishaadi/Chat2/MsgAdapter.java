package com.example.sid.marwadishaadi.Chat2;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sid.marwadishaadi.Blocked_Members.BlockAdapter;
import com.example.sid.marwadishaadi.R;

import java.util.List;

/**
 * Created by Lawrence Dalmet on 10-06-2017.
 */

public class MsgAdapter extends RecyclerView.Adapter<MsgAdapter.MyViewHolder> {

    private List<MsgModel> msgModelList;
    public MsgAdapter(List<MsgModel> msgModelList) {
        this.msgModelList = msgModelList;

    }

    @Override

    public MsgAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.msg_item, parent, false);

        return new MsgAdapter.MyViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(MsgAdapter.MyViewHolder holder, int position) {
        MsgModel msgModel = msgModelList.get(position);

        if(msgModel.isSend())
        {
            if(msgModel.getMsg().trim()!=null)
            holder.sendtext.setText(msgModel.getMsg().trim());
            holder.receivedtext.setVisibility(View.GONE);
        }
        else if(!msgModel.isSend())
        {
            if(msgModel.getMsg().trim()!=null)
            holder.receivedtext.setText(msgModel.getMsg());
            holder.sendtext.setVisibility(View.GONE);
        }

    }

    @Override
    public int getItemCount() {
        return msgModelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView sendtext,receivedtext;

        public MyViewHolder(View itemView) {
            super(itemView);
            sendtext = (TextView)itemView.findViewById(R.id.sendtext);
            receivedtext = (TextView)itemView.findViewById(R.id.receivedtext);

        }



    }
}
