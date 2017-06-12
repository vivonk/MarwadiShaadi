package com.example.sid.marwadishaadi.Search;

import android.app.Dialog;
import android.content.res.XmlResourceParser;
import android.support.design.widget.BottomSheetDialogFragment;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.sid.marwadishaadi.R;
import com.example.sid.marwadishaadi.User_Profile.Profile_Additional_Details;
import com.example.sid.marwadishaadi.User_Profile.Profile_Family_Details;
import com.example.sid.marwadishaadi.User_Profile.Profile_Personal_Details;

import java.util.ArrayList;

import static android.icu.text.UnicodeSet.CASE;
import static com.facebook.GraphRequest.TAG;

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
            Profile_Personal_Details profile_personal_details = new Profile_Personal_Details();
            content = profile_personal_details.getCasebreak();
        }else if (i==2){
            Profile_Additional_Details profile_additional_details = new Profile_Additional_Details();
            content = profile_additional_details.getCasebreak();
        }else{
            Profile_Family_Details profile_family_details = new Profile_Family_Details();
            content = profile_family_details.getCasebreak();
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
            case 11:
                contentView = View.inflate(getContext(),R.layout.bottom_sheet_personal,null);
                break;
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

            // edit profile - family
            case 31:
                contentView = View.inflate(getContext(),R.layout.bottom_sheet_family,null);
                break;
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