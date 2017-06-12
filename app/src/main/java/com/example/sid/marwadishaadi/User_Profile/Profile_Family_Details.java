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


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Profile_Family_Details.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Profile_Family_Details#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Profile_Family_Details extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private static int casebreak;
    private TextView edit_family;
    private TextView edit_relatives;

    private OnFragmentInteractionListener mListener;

    public Profile_Family_Details() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Profile_Family_Details.
     */
    // TODO: Rename and change types and number of parameters
    public static Profile_Family_Details newInstance(String param1, String param2) {
        Profile_Family_Details fragment = new Profile_Family_Details();
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
        View mview = inflater.inflate(R.layout.fragment_profile__family__details, container, false);
        edit_family=(TextView)mview.findViewById(R.id.family_clear);
        edit_relatives=(TextView)mview.findViewById(R.id.relatives_clear);

        edit_family.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                casebreak=31;
                BottomSheetDialogFragment btm= new BottomSheet(3);
                btm.show(getFragmentManager(),btm.getTag());
            }
        });

        edit_relatives.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                casebreak=32;
                BottomSheetDialogFragment btm= new BottomSheet(3);
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

   /* @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }
*/
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
