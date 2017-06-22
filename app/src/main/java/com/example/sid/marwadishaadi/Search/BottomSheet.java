package com.example.sid.marwadishaadi.Search;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Parcelable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.example.sid.marwadishaadi.Dashboard_Suggestions.SuggestionAdapter;
import com.example.sid.marwadishaadi.Dashboard_Suggestions.SuggestionModel;
import com.example.sid.marwadishaadi.R;
import com.example.sid.marwadishaadi.User_Profile.ProfileAdditionalDetailsFragment;
import com.example.sid.marwadishaadi.User_Profile.ProfileFamilyDetailsFragment;
import com.example.sid.marwadishaadi.User_Profile.ProfilePersonalDetailsFragment;

import org.json.JSONArray;
import org.json.JSONException;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static android.content.ContentValues.TAG;
import static com.example.sid.marwadishaadi.Search.BottomSheet.err;
import static com.example.sid.marwadishaadi.Search.BottomSheet.size;
import static com.example.sid.marwadishaadi.Search.BottomSheet.sm;
import static com.example.sid.marwadishaadi.Search.BottomSheet.success;
import static com.example.sid.marwadishaadi.Search.Search.AIList;
import static com.example.sid.marwadishaadi.Search.Search.CastList;
import static com.example.sid.marwadishaadi.Search.Search.annualincome;
import static com.example.sid.marwadishaadi.Search.Search.countannualincome;
import static com.example.sid.marwadishaadi.Search.Search.countfamilystatus;
import static com.example.sid.marwadishaadi.Search.Search.countmaritalstatus;
import static com.example.sid.marwadishaadi.Search.Search.countphysicalstatus;
import static com.example.sid.marwadishaadi.Search.Search.countspinnerCastSearch;
import static com.example.sid.marwadishaadi.Search.Search.familystatus;
import static com.example.sid.marwadishaadi.Search.Search.familystatusList;
import static com.example.sid.marwadishaadi.Search.Search.maritalstatus;
import static com.example.sid.marwadishaadi.Search.Search.maritalstatusList;
import static com.example.sid.marwadishaadi.Search.Search.physicalstatus;
import static com.example.sid.marwadishaadi.Search.Search.physicalstatusList;
import static com.example.sid.marwadishaadi.Search.Search.spinnerCastSearch;

/**
 * Created by vivonk on 01-06-2017.
 */


public class BottomSheet extends BottomSheetDialogFragment {
    int content;
    View contentView;
    UsersAdapter usersAdapter;
    static String s;
    int coun;
    static EditText fname, lname, id;
    static int count = 0, size = 0;
    public static ArrayList<SuggestionModel> sm;
    public static SuggestionAdapter SA;
    public static String err, success;
    public ProgressDialog dialog;

    public BottomSheet() {

    }

    public BottomSheet(int i) {
        if (i == 0) {
            Search search = new Search();
            content = search.getCasebreak();
        } else if (i == 1) {
            ProfilePersonalDetailsFragment profile_personal_detailsFragment = new ProfilePersonalDetailsFragment();
            content = profile_personal_detailsFragment.getCasebreak();
        } else if (i == 2) {
            ProfileAdditionalDetailsFragment profile_additional_detailsFragment = new ProfileAdditionalDetailsFragment();
            content = profile_additional_detailsFragment.getCasebreak();
        } else {
            ProfileFamilyDetailsFragment profile_family_detailsFragment = new ProfileFamilyDetailsFragment();
            content = profile_family_detailsFragment.getCasebreak();
        }
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    @Override
    public void setupDialog(final Dialog dialog, int style) {
        super.setupDialog(dialog, style);
        switch (content) {
            case 0:
                break;
            // search
            case 1:
                ArrayList<User> arrayOfUsers = new ArrayList<>();
                String[] str = getResources().getStringArray(R.array.caste_array);
                for (int i = 0; i < str.length; i++) {
                    User user = new User(str[i], "null");
                    arrayOfUsers.add(user);
                }
                UsersAdapter adapter = new UsersAdapter(getContext(), arrayOfUsers);
                View mview = View.inflate(getContext(), R.layout.custom_list_view, null);
                ListView listView = (ListView) mview.findViewById(R.id.list_view);
                usersAdapter = adapter;
                listView.setAdapter(adapter);
                contentView = mview;
                count = 2;
                break;
            case 2:
                contentView = View.inflate(getContext(), R.layout.bottom_sheet_search, null);
                count = 1;
                sm = new ArrayList<>();
                SA = new SuggestionAdapter(getContext(), sm, SearchResultsActivity.recyclerView);
                break;

            case 3:
                ArrayList<User> arrayOfUserss = new ArrayList<>();
                String[] str1 = getResources().getStringArray(R.array.status_search_array);
                for (int i = 0; i < str1.length; i++) {
                    User user = new User(str1[i], "null");
                    arrayOfUserss.add(user);
                }
                UsersAdapter adapters = new UsersAdapter(getContext(), arrayOfUserss);
                View msview = View.inflate(getContext(), R.layout.custom_list_view, null);
                ListView listView1 = (ListView) msview.findViewById(R.id.list_view);
                listView1.setAdapter(adapters);
                usersAdapter = adapters;
                contentView = msview;
                count = 2;
                break;

            case 4:
                ArrayList<User> arrayOfUsersq = new ArrayList<>();
                String[] strq = getResources().getStringArray(R.array.fstatus_search_array);
                for (int i = 0; i < strq.length; i++) {
                    User user = new User(strq[i], "null");
                    arrayOfUsersq.add(user);
                }
                UsersAdapter adapterq = new UsersAdapter(getContext(), arrayOfUsersq);
                View mwview = View.inflate(getContext(), R.layout.custom_list_view, null);
                ListView listView3 = (ListView) mwview.findViewById(R.id.list_view);
                listView3.setAdapter(adapterq);
                count = 2;
                usersAdapter = adapterq;
                contentView = mwview;
                break;

            case 5:
                ArrayList<User> arrayOfUsersa = new ArrayList<>();
                String[] stra = getResources().getStringArray(R.array.aincome_search_array);
                for (int i = 0; i < stra.length; i++) {
                    User user = new User(stra[i], "null");
                    arrayOfUsersa.add(user);
                }
                UsersAdapter adaptera = new UsersAdapter(getContext(), arrayOfUsersa);
                View mqview = View.inflate(getContext(), R.layout.custom_list_view, null);
                ListView listView4 = (ListView) mqview.findViewById(R.id.list_view);
                listView4.setAdapter(adaptera);
                count = 2;
                usersAdapter = adaptera;
                contentView = mqview;
                break;

            case 6:
                ArrayList<User> arrayOfUsersp = new ArrayList<>();
                String[] strp = getResources().getStringArray(R.array.physicalstatus_search_array);
                for (int i = 0; i < strp.length; i++) {
                    User user = new User(strp[i], "null");
                    arrayOfUsersp.add(user);
                }
                UsersAdapter adapterp = new UsersAdapter(getContext(), arrayOfUsersp);
                View pview = View.inflate(getContext(), R.layout.custom_list_view, null);
                ListView listView5 = (ListView) pview.findViewById(R.id.list_view);
                listView5.setAdapter(adapterp);
                usersAdapter = adapterp;
                count = 2;
                contentView = pview;
                break;


            // edit profile - personal details
            case 12:
                contentView = View.inflate(getContext(), R.layout.bottom_sheet_education, null);

                break;
            case 13:
                contentView = View.inflate(getContext(), R.layout.bottom_sheet_profession, null);
                break;

            // edit profile - additional details
            case 21:
                contentView = View.inflate(getContext(), R.layout.bottom_sheet_about_me, null);
                break;
            case 22:
                contentView = View.inflate(getContext(), R.layout.bottom_sheet_hobbies, null);
                break;
            case 23:
                contentView = View.inflate(getContext(), R.layout.bottom_sheet_lifestyle, null);
                break;
            case 24:
                contentView = View.inflate(getContext(), R.layout.bottom_sheet_horoscope, null);
                break;

            // edit profile - family
            case 32:
                contentView = View.inflate(getContext(), R.layout.bottom_sheet_relatives, null);
                break;

            default:
                contentView = View.inflate(getContext(), R.layout.custom_list_view, null);
                break;
        }
        dialog.setContentView(contentView);
        if (count == 1) {
            Button srch = (Button) contentView.findViewById(R.id.search_by_id_name_search_button);
            srch.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    fname = (EditText) contentView.findViewById(R.id.search_by_first_name);
                    lname = (EditText) contentView.findViewById(R.id.search_by_last_name);
                    id = (EditText) contentView.findViewById(R.id.search_by_id);
                    String strfname, strlname, strid;
                    strfname = fname.getText().toString();
                    strlname = lname.getText().toString();
                    strid = id.getText().toString();
                    if (!strid.trim().isEmpty() & (!strlname.trim().isEmpty() | !strfname.trim().isEmpty())) {
                        Toast.makeText(getContext(), " Please use either ID or Name ", Toast.LENGTH_SHORT).show();
                        fname.setText("");
                        lname.setText("");
                        id.setText("");
                        strfname = null;
                        strlname = null;
                        strid = null;
                    } else if (!strid.trim().isEmpty()) {
                        new BackNd().execute("select YEAR(tbl_user.birthdate),tbl_user_files.file_name,tbl_user.first_name,tbl_user.customer_no,tbl_user.edu_degree,tbl_user.occup_location,tbl_user.height,tbl_user.occup_company,tbl_user.anuual_income,tbl_user.marrital_status,tbl_user.city,tbl_user.occup_designation  from tbl_user INNER JOIN tbl_user_files ON tbl_user.customer_no=tbl_user_files.customer_no and tbl_user.customer_no=\"" + strid + "\" ; ");
                        if (success == "success") {
                            if (size == 0) {
                                Toast.makeText(getContext(), "No result found on these query", Toast.LENGTH_SHORT).show();
                            } else {
                                Log.d(TAG, "onClick: sizzw is ************************************* " + Integer.toString(size));
                                Intent i = new Intent(getContext(), SearchResultsActivity.class);
                                i.putExtra("COUNT", size);
                                size = 0;
                                fname.setText("");
                                lname.setText("");
                                id.setText("");
                                strfname = null;
                                strlname = null;
                                strid = null;
//                            i.putParcelableArrayListExtra("list", (ArrayList<? extends Parcelable>) sm);
                                startActivity(i);

                            }
                        } else {
                            Toast.makeText(getContext(), err, Toast.LENGTH_SHORT).show();
                        }
                    } else if ((!strlname.trim().isEmpty() & !strfname.trim().isEmpty())) {
                        new BackNd().execute("select YEAR(tbl_user.birthdate),tbl_user_files.file_name,tbl_user.first_name,tbl_user.customer_no,tbl_user.edu_degree,tbl_user.occup_location,tbl_user.height,tbl_user.occup_company,tbl_user.anuual_income,tbl_user.marrital_status,tbl_user.city,tbl_user.occup_designation  from tbl_user  INNER JOIN tbl_user_files ON tbl_user.customer_no=tbl_user_files.customer_no and tbl_user.first_name=\" " + strfname + "\"and tbl_user.surname=\"" + strlname + "\" order by created_on asc ;");
                        if (success == "success") {
                            if (size == 0) {
                                Toast.makeText(getContext(), "No result found on these query", Toast.LENGTH_SHORT).show();
                            } else {
                                Intent i = new Intent(getContext(), SearchResultsActivity.class);
                                i.putExtra("COUNT", size);
                                Log.d(TAG, "onClick: sizzw is ************************************* " + Integer.toString(size));

                                size = 0;
                                fname.setText("");
                                lname.setText("");
                                id.setText("");
                                strfname = null;
                                strlname = null;
                                strid = null;
//                            i.putParcelableArrayListExtra("list", (ArrayList<? extends Parcelable>) sm);
                                startActivity(i);

                            }
                        } else {
                            Toast.makeText(getContext(), err, Toast.LENGTH_SHORT).show();
                        }
                    } else if ((!strlname.trim().isEmpty() | !strfname.trim().isEmpty())) {

                        if (!strlname.trim().isEmpty()) {
                            new BackNd().execute("select YEAR(tbl_user.birthdate),tbl_user_files.file_name,tbl_user.first_name,tbl_user.customer_no,tbl_user.edu_degree,tbl_user.occup_location,tbl_user.height,tbl_user.occup_company,tbl_user.anuual_income,tbl_user.marrital_status,tbl_user.city,tbl_user.occup_designation from tbl_user INNER JOIN tbl_user_files ON tbl_user.customer_no=tbl_user_files.customer_no and tbl_user.surname=\"" + strlname + "\"   order by created_on asc ;");
                            if (success == "success") {
                                if (size == 0) {

                                    Toast.makeText(getContext(), "No result found on these query", Toast.LENGTH_SHORT).show();
                                } else {
                                    Intent i = new Intent(getContext(), SearchResultsActivity.class);
//                            i.putParcelableArrayListExtra("list", (ArrayList<? extends Parcelable>) sm);
                                    i.putExtra("COUNT", size);
                                    Log.d(TAG, "onClick: sizzw is ************************************* " + Integer.toString(size));
                                    fname.setText("");
                                    lname.setText("");
                                    id.setText("");
                                    strfname = null;
                                    strlname = null;
                                    strid = null;
                                    size = 0;
                                    startActivity(i);
                                }
                            } else {
                                Toast.makeText(getContext(), err, Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            new BackNd().execute("select YEAR(tbl_user.birthdate),tbl_user_files.file_name,tbl_user.first_name,tbl_user.customer_no,tbl_user.edu_degree,tbl_user.occup_location,tbl_user.height,tbl_user.occup_company,tbl_user.anuual_income,tbl_user.marrital_status,tbl_user.city,tbl_user.occup_designation from tbl_user INNER JOIN tbl_user_files ON tbl_user.customer_no=tbl_user_files.customer_no and tbl_user.first_name=\"" + strfname + "\"   order by created_on asc;");


                            if (success == "success") {
                                if (size == 0) {
                                    Toast.makeText(getContext(), "No results found! ", Toast.LENGTH_SHORT).show();
                                } else {

                                    Intent i = new Intent(getContext(), SearchResultsActivity.class);
                                    i.putExtra("COUNT", size);
                                    Log.d(TAG, "onClick: sizzw is ************************************* " + Integer.toString(size));
                                    fname.setText("");
                                    lname.setText("");
                                    id.setText("");
                                    strfname = null;
                                    strlname = null;
                                    strid = null;
                                    size = 0;
                                    i.putExtra("which","second");
                                    startActivity(i);
                                }
                            } else {
                                Toast.makeText(getContext(), err, Toast.LENGTH_SHORT).show();
                            }
                        }

                    } else {
                        Toast.makeText(getContext(), "Search detail can't be empty", Toast.LENGTH_SHORT).show();
                    }


                }
            });
        } else if (count == 2) {
            coun = 0;
            Button btn = (Button) contentView.findViewById(R.id.ok);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    List<String> result = new ArrayList<String>();

                    for (User p : usersAdapter.getBox()) {
                        if (p.box) {
                            coun++;
                            result.add(p.name);

                        }
                    }
//                Toast.makeText(getContext(), result+"\n"+"Total Amount:="+totalAmount, Toast.LENGTH_LONG).show();
                    Search srch = new Search();
//                srch.setStr(result);
                    switch (content) {
                        case 1:
                            spinnerCastSearch.setText(result.toString());
                            CastList = result;
                            countspinnerCastSearch = coun;
                            break;
                        case 3:
                            maritalstatus.setText(result.toString());
                            maritalstatusList = result;
                            countmaritalstatus = coun;
                            break;
                        case 4:
                            familystatus.setText(result.toString());
                            familystatusList = result;
                            countfamilystatus = coun;
                            break;
                        case 5:
                            annualincome.setText(result.toString());
                            AIList = result;
                            countannualincome = coun;
                            break;
                        case 6:
                            physicalstatus.setText(result.toString());
                            physicalstatusList = (result);
                            countphysicalstatus = coun;
                            break;
                    }
                    dialog.dismiss();
                }
            });


        }
    }

    class BackNd extends AsyncTask<String, String, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog=new ProgressDialog(getContext());
            dialog.setMessage("Please Wait...");
        }

        @Override
        protected String doInBackground(String... strings) {
            Log.d(TAG, "response query is  ----------" + strings[0]);
            AndroidNetworking.post("http://192.168.43.61:5050/searchById")
                    .addBodyParameter("query", strings[0])
                    .setPriority(Priority.HIGH)
                    .build()
                    .getAsJSONArray(new JSONArrayRequestListener() {
                        @Override
                        public void onResponse(JSONArray response) {
                            String s = response.toString();
                            Log.d(TAG, "onResponse:----------------" + s);
                            size = response.length();
                            for (int i = 0; i < response.length(); i++) {
                                try {
                                                    /*SuggestionModel(int age, String imgAdd, String name, String cusId, String highDeg, String workLoc, String height, String comapany, String annInc, String mariSta, String hometown, String designation)
*/

                                    JSONArray user = response.getJSONArray(i);

                                    Calendar calender = Calendar.getInstance();
                                    int year = calender.get(Calendar.YEAR);
                                    SuggestionModel suggestionModel = new SuggestionModel(year - (int) user.get(0), "http://www.marwadishaadi.com/uploads/cust_" + user.get(3).toString() + "/thumb/" + user.get(1).toString(), user.get(2).toString(), user.get(3).toString(), user.get(4).toString(), user.get(5).toString(), user.get(6).toString(), user.get(7).toString(), user.get(8).toString(), user.get(9).toString(), user.get(10).toString(), user.get(11).toString());
                                    sm.add(suggestionModel);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                            success = "success";

                        }

                        @Override
                        public void onError(ANError error) {
//                        Toast.makeText(BottomSheet.this," ", Toast.LENGTH_SHORT).show();
                            Log.d(TAG, "onError: --------------------- error is " + error);
                            err = "Network Error, Check Connection";
                        }
                    });
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }
    }
}

