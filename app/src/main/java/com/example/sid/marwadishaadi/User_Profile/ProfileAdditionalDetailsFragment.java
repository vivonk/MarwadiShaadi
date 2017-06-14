package com.example.sid.marwadishaadi.User_Profile;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sid.marwadishaadi.R;
import com.example.sid.marwadishaadi.Search.BottomSheet;

public class ProfileAdditionalDetailsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private TextView edit_about;
    private TextView edit_hobbies;
    private TextView edit_lifestyle;
    private TextView edit_horoscope;
    private static  int casebreak;
    private OnFragmentInteractionListener mListener;

    public ProfileAdditionalDetailsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileAdditionalDetailsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileAdditionalDetailsFragment newInstance(String param1, String param2) {
        ProfileAdditionalDetailsFragment fragment = new ProfileAdditionalDetailsFragment();
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
        View mview = inflater.inflate(R.layout.fragment_profile__additional__details, container, false);
        edit_about = (TextView) mview.findViewById(R.id.aboutme_clear);
        edit_hobbies=(TextView) mview.findViewById(R.id.hobbies_clear);
        edit_lifestyle=(TextView)mview.findViewById(R.id.lifestyle_clear);
        edit_horoscope = (TextView) mview.findViewById(R.id.horoscope_clear);

        edit_horoscope.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                casebreak=24;
                BottomSheetDialogFragment btm= new BottomSheet(2);
                btm.show(getFragmentManager(),btm.getTag());
            }
        });

        edit_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                casebreak=21;
                BottomSheetDialogFragment btm= new BottomSheet(2);
                btm.show(getFragmentManager(),btm.getTag());
            }
        });

        edit_hobbies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                casebreak=22;
                BottomSheetDialogFragment btm= new BottomSheet(2);
                btm.show(getFragmentManager(),btm.getTag());
            }
        });


        edit_lifestyle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                casebreak=23;
                BottomSheetDialogFragment btm= new BottomSheet(2);
                btm.show(getFragmentManager(),btm.getTag());
            }
        });




        return mview;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

  /*  @Override
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
    public int getCasebreak()
    {
        return this.casebreak;
    }
}