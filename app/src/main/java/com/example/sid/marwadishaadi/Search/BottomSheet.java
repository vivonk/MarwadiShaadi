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

import java.util.ArrayList;

import static android.icu.text.UnicodeSet.CASE;
import static com.facebook.GraphRequest.TAG;

/**
 * Created by vivonk on 01-06-2017.
 */


public class BottomSheet extends BottomSheetDialogFragment {
     int content;
     View contentView;
    @Override
    public void setupDialog(final Dialog dialog, int style) {
        super.setupDialog(dialog, style);
        Search srch=new Search();
        content =srch.getCasebreak();
//        Log.d(TAG,Integer.toString(srch.getCasebreak())+" does this worked or not");
//        Toast.makeText(getContext(),Integer.toString(srch.getCasebreak())+" does this worked or not", Toast.LENGTH_LONG).show();

        switch (content)
        {
            case 1:
//                ArrayAdapter<String> cast_adapter=new ArrayAdapter<String>(getContext(),R.layout.spinner_multiple_select,getResources().getStringArray(R.array.caste_array));
                ArrayList<User> arrayOfUsers = new ArrayList<>();
// Create the adapter to convert the array to views
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
//                Toast.makeText(getContext()," does  or not", Toast.LENGTH_LONG).show();
                break;
            case 2:
                contentView = View.inflate(getContext(),R.layout.bottom_sheet_search, null) ;
                break;
            default:
                contentView = View.inflate(getContext(),R.layout.custom_list_view, null) ;
                break;
        }
        dialog.setContentView(contentView);
    }

}