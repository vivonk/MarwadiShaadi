package com.example.sid.marwadishaadi.Search;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.sid.marwadishaadi.R;

import java.util.ArrayList;


public class UsersAdapter extends ArrayAdapter<User> {
     ArrayList<User> arraylist;
    private static final String TAG = "UsersAdapter";
    public UsersAdapter(Context context, ArrayList<User> users) {
        super(context, R.layout.spinner_multiple_select, users);
        this.arraylist=users;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        User user = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.spinner_multiple_select, parent, false);
        }

        // Lookup view for data population

        TextView tvName = (TextView) convertView.findViewById(R.id.checkBoxTextView);
//        TextView tvHome = (TextView) convertView.findViewById(R.id.tvHome);
        // Populate the data into the template view using the data object
//        Log.d(TAG, "getView: get name is ------------------------------------ " +  user.getName());
        tvName.setText(user.getName());
//        tvHome.setText(user.hometown);
        // Return the completed view to render on screen
        return convertView;
    }
}
