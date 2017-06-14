package com.example.sid.marwadishaadi.Dashboard_Interest;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.sid.marwadishaadi.R;

import java.util.List;

/**
 * Created by USER on 01-06-2017.
 */

public class InterestAdapter extends RecyclerView.Adapter<InterestAdapter.MyViewHolder>{

    private Context context;
    private List<InterestModel> interestModelList;
    private static final String TAG = "InterestAdapter";

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public ImageView userImage;
        public TextView name, age, highestDegree, location, status;
        public ImageView accept, reject;

        public MyViewHolder(View itemView) {
            super(itemView);
            userImage = (ImageView) itemView.findViewById(R.id.userImage);
            name = (TextView) itemView.findViewById(R.id.textviewName);
            highestDegree = (TextView) itemView.findViewById(R.id.textviewHighestDegree);
            location = (TextView) itemView.findViewById(R.id.textviewLocation);
            status = (TextView) itemView.findViewById(R.id.status);
            accept = (ImageView)itemView.findViewById(R.id.interest_accept);
            reject = (ImageView)itemView.findViewById(R.id.interest_reject);
        }
    }

    public InterestAdapter(Context context, List<InterestModel> interestModelList) {
        this.context = context;
        this.interestModelList = interestModelList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_interest, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        InterestModel interestModel = interestModelList.get(position);

        Log.d(TAG, "onBindViewHolder: values are " + interestModel.getAge().toString() + " " + interestModel.getLocation().toString() + " "+ interestModel.getName().toString() + " ");
        String ag=interestModel.getName()+", "+interestModel.getAge();
        Glide.with(context).load(interestModel.getUserImage()).into(holder.userImage);
        holder.name.setText(ag);
        holder.highestDegree.setText(interestModel.getHighestDegree());
        holder.location.setText(interestModel.getLocation());
        if(interestModel.getStatus() == 0){
            holder.status.setText("Accepted");
            holder.status.setBackgroundColor(Color.parseColor("#00c864"));
            holder.accept.setVisibility(View.INVISIBLE);
            holder.reject.setVisibility(View.INVISIBLE);
        }else if (interestModel.getStatus() == 1){
            holder.status.setText("Rejected");
            holder.status.setBackgroundColor(Color.parseColor("#ff0000"));
            holder.accept.setVisibility(View.INVISIBLE);
            holder.reject.setVisibility(View.INVISIBLE);
        }else {
            holder.status.setText("Pending");
            holder.status.setBackgroundColor(Color.parseColor("#7faeff"));

        }
    }

    @Override
    public int getItemCount() {
        return interestModelList.size();
    }


}
