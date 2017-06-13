package com.example.sid.marwadishaadi.Search;

import android.app.Dialog;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.View;
import android.widget.ListView;

import com.example.sid.marwadishaadi.R;
import com.example.sid.marwadishaadi.User_Profile.ProfileAdditionalDetailsFragment;
import com.example.sid.marwadishaadi.User_Profile.ProfileFamilyDetailsFragment;
import com.example.sid.marwadishaadi.User_Profile.ProfilePersonalDetailsFragment;

import java.util.ArrayList;

/**
 * Created by vivonk on 01-06-2017.
 */


public class BottomSheet extends BottomSheetDialogFragment {
     int content;
     View contentView;

    public BottomSheet(int i) {
        if(i==0){
            Search search = new Search();
            content=search.getCasebreak();
        }else if (i==1){
            ProfilePersonalDetailsFragment profile_personal_detailsFragment = new ProfilePersonalDetailsFragment();
            content = profile_personal_detailsFragment.getCasebreak();
        }else if (i==2){
            ProfileAdditionalDetailsFragment profile_additional_detailsFragment = new ProfileAdditionalDetailsFragment();
            content = profile_additional_detailsFragment.getCasebreak();
        }else{
            ProfileFamilyDetailsFragment profile_family_detailsFragment = new ProfileFamilyDetailsFragment();
            content = profile_family_detailsFragment.getCasebreak();
        }
    }

    @Override
    public void setupDialog(final Dialog dialog, int style) {
        super.setupDialog(dialog, style);
        switch (content)
        {
            // search
            case 1:
                ArrayList<User> arrayOfUsers = new ArrayList<>();
                String [] str=getResources().getStringArray(R.array.caste_array);
                for(int i=0;i<str.length;i++)
                {
                    User user=new User(str[i],"null");
                    arrayOfUsers.add(user);
                }
                UsersAdapter adapter = new UsersAdapter(getContext(), arrayOfUsers);
                View mview = View.inflate(getContext(),R.layout.custom_list_view, null) ;
                ListView listView = (ListView) mview.findViewById(R.id.list_view);
                listView.setAdapter(adapter);
                contentView=mview;
                break;
            case 2:
                contentView = View.inflate(getContext(),R.layout.bottom_sheet_search, null) ;
                break;

            // edit profile - personal details
            case 12:
                contentView = View.inflate(getContext(),R.layout.bottom_sheet_education,null);
                break;
            case 13:
                contentView=View.inflate(getContext(),R.layout.bottom_sheet_profession,null);
                break;

            // edit profile - additional details
            case 21:
                contentView = View.inflate(getContext(),R.layout.bottom_sheet_about_me,null);
                break;
            case 22:
                contentView = View.inflate(getContext(),R.layout.bottom_sheet_hobbies,null);
                break;
            case 23:
                contentView = View.inflate(getContext(),R.layout.bottom_sheet_lifestyle,null);
                break;
            case 24:
                contentView = View.inflate(getContext(),R.layout.bottom_sheet_horoscope,null);
                break;

            // edit profile - family
            case 32:
                contentView = View.inflate(getContext(),R.layout.bottom_sheet_relatives,null);
                break;

            default:
                contentView = View.inflate(getContext(),R.layout.custom_list_view, null) ;
                break;
        }
        dialog.setContentView(contentView);
    }

}