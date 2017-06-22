package com.example.sid.marwadishaadi.Dashboard_Interest_Sent;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
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


public class InterestSentAdapter extends RecyclerView.Adapter<InterestSentAdapter.MyViewHolder> {

    private Context context;
    private List<InterestSentModel> interestSentModelList;


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

    public InterestSentAdapter(Context context, List<InterestSentModel> interestSentModelList) {
        this.context = context;
        this.interestSentModelList = interestSentModelList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_interestsent, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        InterestSentModel interestSentModel = interestSentModelList.get(position);

        String ag= interestSentModel.getName()+", "+ interestSentModel.getAge()+" yrs";
        Glide.with(context).load(interestSentModel.getImgAdd()).into(holder.profilepic);
        holder.name_age.setText(ag);
        holder.degree.setText(interestSentModel.getDegree());
        holder.location.setText(interestSentModel.getCity());
        holder.req_status.setText((CharSequence) interestSentModel.getReqStatus());
        holder.date.setText(interestSentModel.getDate());
    }

    @Override
    public int getItemCount() {
        return interestSentModelList.size();
    }


}
