package com.example.sid.marwadishaadi.Blocked_Members;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sid.marwadishaadi.R;
import com.example.sid.marwadishaadi.User_Profile.UserProfileActivity;

import java.util.List;

/**
 * Created by Sid on 31-May-17.
 */

public class BlockAdapter extends RecyclerView.Adapter<BlockAdapter.MyViewHolder> {

    private List<BlockModel> blockModelList;
    private Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView name,cusId,vview,unblock;

        public MyViewHolder(View view)
        {
            super(view);
            name=(TextView) view.findViewById(R.id.name);
            cusId=(TextView)view.findViewById(R.id.cusId);
            vview=(TextView)view.findViewById(R.id.vview);
            unblock=(TextView)view.findViewById(R.id.unblock);

        }


    }

    public BlockAdapter(Context context, List<BlockModel> blockModelList) {
        this.blockModelList = blockModelList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.blocked_row, parent, false);

        return new MyViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        BlockModel blocked= (BlockModel) blockModelList.get(position);

        holder.name.setText(blocked.getName());
        holder.cusId.setText(blocked.getId());

        holder.unblock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder unblock_user = new AlertDialog.Builder(view.getRootView().getContext());
                unblock_user.setMessage("Do you want to unblock the user ? ")
                        .setCancelable(true)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                BlockModel b= blockModelList.get(position);
                                blockModelList.remove(position);
                                notifyItemRemoved(position);
                                notifyItemRangeChanged(position, blockModelList.size());
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });

                AlertDialog unblock = unblock_user.create();
                unblock.setTitle("Unblock User");
                unblock.show();
            }
        });

        holder.vview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                        Intent i = new Intent(v.getRootView().getContext(),UserProfileActivity.class);
                        v.getRootView().getContext().startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return blockModelList.size();
    }


}
