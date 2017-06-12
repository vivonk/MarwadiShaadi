package com.example.sid.marwadishaadi.Chat2;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.sid.marwadishaadi.R;

import java.util.List;

/**
 * Created by Lawrence Dalmet on 11-06-2017.
 */

public class InboxAdapter extends RecyclerView.Adapter<InboxAdapter.MyViewHolder>{

    List<InboxModel> inboxModelList;
    Context context;
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.inbox_item, parent, false);

        return new InboxAdapter.MyViewHolder(itemView);


    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        final InboxModel inboxModel = inboxModelList.get(position);
        if(inboxModel.isSeen()){
        holder.count.setText(inboxModel.getCount());
        holder.time.setTextColor(Color.BLUE);
        holder.lastmsg.setTypeface(null, Typeface.BOLD);
        holder.lastmsg.setTypeface(null, Typeface.BOLD);
        }
        else {
            holder.stamp.setVisibility(View.INVISIBLE);
            holder.count.setVisibility(View.INVISIBLE);
        }

        holder.name.setText(inboxModel.getName());
        holder.time.setText(inboxModel.getTime());
        Glide.with(context).load(inboxModel.getImgAdd()).into(holder.imgAdd);
        holder.lastmsg.setText(inboxModel.getLastmsg());

        holder.inboxitem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context,Messaging.class);
                i.putExtra("name",inboxModel.getName());
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return inboxModelList.size();
    }

    public InboxAdapter(List<InboxModel> inboxModelList, Context context) {
        this.inboxModelList = inboxModelList;
        this.context = context;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        LinearLayout inboxitem;
        TextView name,time,count,lastmsg;
        ImageView imgAdd,stamp;
        public MyViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();
            inboxitem = (LinearLayout) itemView.findViewById(R.id.inboxitem);
            name = (TextView)itemView.findViewById(R.id.name);
            time = (TextView)itemView.findViewById(R.id.time);
            count = (TextView)itemView.findViewById(R.id.count);
            lastmsg = (TextView)itemView.findViewById(R.id.lastmsg);
            imgAdd = (ImageView) itemView.findViewById(R.id.imgAdd);
            stamp = (ImageView) itemView.findViewById(R.id.stamp);


        }
    }
}
