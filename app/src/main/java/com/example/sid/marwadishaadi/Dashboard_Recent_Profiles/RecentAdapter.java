package com.example.sid.marwadishaadi.Dashboard_Recent_Profiles;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.sid.marwadishaadi.R;

import java.util.List;

/**
 * Created by USER on 02-06-2017.
 */

public class RecentAdapter extends RecyclerView.Adapter<RecentAdapter.MyViewHolder>{

    private Context context;
    private List<RecentModel> recentModelList;



    public class MyViewHolder extends RecyclerView.ViewHolder {

        public ImageView recentUserImage;
        public TextView recentName, recentAge, recentHighestDegree, recentLocation, recentOnline;

        public MyViewHolder(View itemView) {

            super(itemView);
            recentUserImage = (ImageView) itemView.findViewById(R.id.recentUserImage);
            recentName = (TextView) itemView.findViewById(R.id.recentTextViewName);
            recentAge = (TextView) itemView.findViewById(R.id.recentTextViewAge);
            recentHighestDegree = (TextView) itemView.findViewById(R.id.recentTextViewEducation);
            recentLocation = (TextView) itemView.findViewById(R.id.recentTextViewCity);
            recentOnline = (TextView) itemView.findViewById(R.id.recentTextViewLastOnline);

        }
    }

    public RecentAdapter(Context context, List<RecentModel> recentModelList) {
        this.context = context;
        this.recentModelList = recentModelList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recent, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        RecentModel recentModel = recentModelList.get(position);
        Glide.with(context).load(recentModel.getRecentUserImage()).into(holder.recentUserImage);
        holder.recentName.setText(recentModel.getRecentName());
        holder.recentAge.setText(recentModel.getRecentAge());
        holder.recentHighestDegree.setText(recentModel.getRecentHighestDegree());
        holder.recentLocation.setText(recentModel.getRecentLocation());
    }

    @Override
    public int getItemCount() {
        return recentModelList.size();
    }

}
