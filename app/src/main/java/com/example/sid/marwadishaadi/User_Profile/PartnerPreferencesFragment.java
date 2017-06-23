package com.example.sid.marwadishaadi.User_Profile;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.example.sid.marwadishaadi.Similar_Profiles.SimilarActivity;
import com.example.sid.marwadishaadi.User_Profile.Edit_User_Profile.EditPreferencesActivity;
import com.example.sid.marwadishaadi.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.w3c.dom.Text;

import java.util.Arrays;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PartnerPreferencesFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PartnerPreferencesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PartnerPreferencesFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private TextView edit_prefs;
    private OnFragmentInteractionListener mListener;
    private Button similar;

    private TextView age,height,build,complexion,physicalStatus,highestDegree,occup,maritalStatus,annualIncome,city;
    public PartnerPreferencesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PartnerPreferencesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PartnerPreferencesFragment newInstance(String param1, String param2) {
        PartnerPreferencesFragment fragment = new PartnerPreferencesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View mview= inflater.inflate(R.layout.fragment_partner_preferences, container, false);
        edit_prefs = (TextView) mview.findViewById(R.id.partner_prefs_clear);
        similar = (Button) mview.findViewById(R.id.similar);

        age = (TextView)mview.findViewById(R.id.age);
        height = (TextView)mview.findViewById(R.id.height);
        complexion = (TextView)mview.findViewById(R.id.complexion);
        build = (TextView)mview.findViewById(R.id.build);
        physicalStatus = (TextView)mview.findViewById(R.id.physical_status);
        city = (TextView)mview.findViewById(R.id.city);
        highestDegree = (TextView)mview.findViewById(R.id.highest_degree);
        occup = (TextView)mview.findViewById(R.id.occup);
        maritalStatus = (TextView)mview.findViewById(R.id.marital_status);
        annualIncome = (TextView)mview.findViewById(R.id.annual_income);

        new PartnerPreference().execute();

        similar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), SimilarActivity.class);
                startActivity(i);
                getActivity().overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
            }
        });
        edit_prefs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getContext(), EditPreferencesActivity.class);
                startActivity(i);
                getActivity().overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);

            }
        });

        return mview;
    }


    class PartnerPreference extends AsyncTask<Void,Void,Void>{

        @Override
        protected Void doInBackground(Void... params) {
            AndroidNetworking.post("http://192.168.43.143:5050/profilePartnerPreferences")
                    .addBodyParameter("customerNo", "A1028")
                    .setTag(this)
                    .setPriority(Priority.MEDIUM)
                    .build()
                    .getAsJSONArray(new JSONArrayRequestListener() {
                        @Override
                        public void onResponse(JSONArray response) {

                            try {
                                JSONArray array;
                                String a = response.getString(0)+" yrs to "+response.getString(1)+" yrs";
                                age.setText(a);

                                double feet = Double.parseDouble(response.getString(2)) / 30.48 ;
                                double inches = (Double.parseDouble(response.getString(2)) / 2.54) - ((int) feet * 12);
                                double feet1 = Double.parseDouble(response.getString(3)) / 30.48;
                                double inches1 = (Double.parseDouble(response.getString(3)) / 2.54) - ((int) feet * 12);
                                String h = (int)feet+" ft "+inches+" inch to "+(int)feet1+" ft "+inches1+" inch ";
                                height.setText(h);

                                array = response.getJSONArray(4);
                                String c = array.getString(0);
                                for (int i = 1; i<array.length();i++)
                                {
                                    c = c+ "/ "+array.getString(i);
                                }
                                complexion.setText(c);

                                array = response.getJSONArray(5);
                                String b = array.getString(0);
                                for (int i = 1; i<array.length();i++)
                                {
                                    b = b+ "/ "+array.getString(i);
                                }
                                build.setText(b);

                                physicalStatus.setText(response.getString(6));
                                city.setText(response.getString(7));

                                array=response.getJSONArray(8);
                                String hd=array.getString(0);
                                for (int i = 1; i<array.length();i++)
                                {
                                    hd = hd+ "/ "+array.getString(i);
                                }
                                highestDegree.setText(hd);

                                array = response.getJSONArray(9);
                                String o=array.getString(0);
                                for (int i = 1; i<array.length();i++)
                                {
                                    o = o+ "/ "+array.getString(i);
                                }
                                occup.setText(o);

                                array = response.getJSONArray(10);
                                String m = array.getString(0);
                                for (int i = 1; i<array.length();i++)
                                {
                                    m = m+ "/ "+array.getString(i);
                                }
                                maritalStatus.setText(m);





                                annualIncome.setText(response.getString(11));
                            }
                            catch (JSONException e)
                            {
                                e.printStackTrace();
                            }

                        }

                        @Override
                        public void onError(ANError error) {
                            Log.d(TAG, "onError: errr ------------- " + error.toString());
                            // handle error
                        }
                    });

                                            return null;

    }

        public String income(String aincome) {

            String annualI = aincome;
            annualI = annualI.replaceAll("[^-?0-9]+", " ");
            List<String> incomeArray = Arrays.asList(annualI.trim().split(" "));
            Log.d(TAG, "onResponse: income array is " + incomeArray);
            if (annualI.contains("Upto")) {
                annualI = "Upto 3L";
            } else if (annualI.contains("Above")) {
                annualI = "Above 50L";

            } else if (incomeArray.size() == 3) {
                Log.d(TAG, "onResponse: when three");
                double first = Integer.parseInt(incomeArray.get(0)) / 100000.0;
                double second = Integer.parseInt(incomeArray.get(2)) / 100000.0;
                annualI = (int) first + "L - " + (int) second + "L";
            } else {
                annualI = "No Income mentioned.";
            }
            return  annualI;
        }


    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    /*@Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }*/

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
