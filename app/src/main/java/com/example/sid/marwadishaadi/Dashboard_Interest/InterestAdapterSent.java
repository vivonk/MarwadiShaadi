package com.example.sid.marwadishaadi.Dashboard_Interest;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;

import com.bumptech.glide.Glide;
import com.example.sid.marwadishaadi.R;
/**
 * Created by Lawrence Dalmet on 07-06-2017.
 */


public class InterestAdapterSent extends RecyclerView.Adapter<InterestAdapterSent.MyViewHolder> {

    private Context context;
    private List<InterestModelSent> interestModelSentList;


    public class MyViewHolder extends RecyclerView.ViewHolder{
       public  TextView name_age,location,degree,req_status,date;
       public ImageView profilepic;

        public MyViewHolder(View view)
        {
            super(view);
            name_age=(TextView)view.findViewById(R.id.name_age);
            location=(TextView)view.findViewById(R.id.location);
            degree=(TextView)view.findViewById(R.id.degree);
            req_status=(TextView)view.findViewById(R.id.req_status);
            profilepic=(ImageView)view.findViewById(R.id.profilepic);
            date=(TextView)view.findViewById(R.id.date);

        }


    }

    public InterestAdapterSent(Context context, List<InterestModelSent> interestModelSentList) {
        this.context = context;
        this.interestModelSentList = interestModelSentList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_interestsent, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        InterestModelSent interestModelSent = interestModelSentList.get(position);

        String ag=interestModelSent.getName()+", "+interestModelSent.getAge()+" yrs";
        Glide.with(context).load(interestModelSent.getImgAdd()).into(holder.profilepic);
        holder.name_age.setText(ag);
        holder.degree.setText(interestModelSent.getDegree());
        holder.location.setText(interestModelSent.getCity());
        holder.req_status.setText((CharSequence) interestModelSent.getReqStatus());
        holder.date.setText(interestModelSent.getDate());
    }

    @Override
    public int getItemCount() {
        return interestModelSentList.size();
    }


}
