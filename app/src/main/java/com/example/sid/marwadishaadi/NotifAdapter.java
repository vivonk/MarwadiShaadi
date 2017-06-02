package com.example.sid.marwadishaadi;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Sid on 02-Jun-17.
 */

public class NotifAdapter extends RecyclerView.Adapter<NotifAdapter.MyViewHolder> {

    private final Context context;
    private List<Notifications_elements> notifications_elementsList;

    @Override
    public NotifAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.notif_row, parent, false);

        return new NotifAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Notifications_elements notifications_elements=notifications_elementsList.get(position);

        if(notifications_elements.isBday())
        {
            String notification = "Marwadishaadi.com wishes you a very happy birthday.";
            holder.notiftext.setText(notification);
            Glide.with(context)
                    .load(notifications_elements.getImgAdd())
                    .into(holder.notifimage);

        }

        else if(notifications_elements.isInterestAcc())
        {
            String notification = notifications_elements.getName()+" has accepted your interest request.";
            holder.notiftext.setText(notification);
            Glide.with(context)
                    .load(notifications_elements.getImgAdd())
                    .into(holder.notifimage);

        }

        else if(notifications_elements.isInterestRec())
        {
            String notification = notifications_elements.getName()+" has sent you an interest request.";
            holder.notiftext.setText(notification);
            Glide.with(context)
                    .load(notifications_elements.getImgAdd())
                    .into(holder.notifimage);

        }
        else if(notifications_elements.isSuggested())
        {   String notification=null;
            if(notifications_elements.getNumber()>1)
                notification = "you have "+notifications_elements.getNumber()+" new suggestions";
            else if(notifications_elements.getNumber()==1)
                notification = "you have "+notifications_elements.getNumber()+" new suggestion";


            holder.notiftext.setText(notification);
            Glide.with(context)
                    .load(notifications_elements.getImgAdd())
                    .into(holder.notifimage);

        }

        else if(!notifications_elements.isMemExp())
        {
            String notification=null ;
            if(notifications_elements.getNumber()>1)
                notification= "Your membership is about to expire in "+notifications_elements.getNumber()+"days.";
            if(notifications_elements.getNumber()==1)
                notification= "Your membership is going to expire tomorrow";

            holder.notiftext.setText(notification);
            Glide.with(context)
                    .load(notifications_elements.getImgAdd())
                    .into(holder.notifimage);

        }

        else if(notifications_elements.isMemExp())
        {
            String notification = "Your membership has expired.";
            holder.notiftext.setText(notification);
            Glide.with(context)
                    .load(notifications_elements.getImgAdd())
                    .into(holder.notifimage);

        }

        else if(notifications_elements.isMsgRec())
        {
            String notification = notifications_elements.getName()+" has sent you an message.";
            holder.notiftext.setText(notification);
            Glide.with(context)
                    .load(notifications_elements.getImgAdd())
                    .into(holder.notifimage);

        }

        else if(notifications_elements.isOffers())
        {
            String notification = "Offers!!!";
            holder.notiftext.setText(notification);
            Glide.with(context)
                    .load(notifications_elements.getImgAdd())
                    .into(holder.notifimage);

        }

        else if(notifications_elements.isPremMem())
        {
            String notification = "Become a member to experience premium features of our service ";
            holder.notiftext.setText(notification);
            Glide.with(context)
                    .load(notifications_elements.getImgAdd())
                    .into(holder.notifimage);

        }

        else if(notifications_elements.isReminders())
        {
            String notification = "Reminders!!!";
            holder.notiftext.setText(notification);
            Glide.with(context)
                    .load(notifications_elements.getImgAdd())
                    .into(holder.notifimage);

        }



    }

    @Override
    public int getItemCount() {
        return notifications_elementsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView notiftext;
        ImageView notifimage;

        public MyViewHolder(View view){
            super(view);
            notiftext=(TextView)view.findViewById(R.id.notiftext);
            notifimage=(ImageView)view.findViewById(R.id.notifimage);

        }
    }

    public NotifAdapter(Context context, List<Notifications_elements> notifications_elementsList){

        this.context=context;
        this.notifications_elementsList=notifications_elementsList;

    }



}
