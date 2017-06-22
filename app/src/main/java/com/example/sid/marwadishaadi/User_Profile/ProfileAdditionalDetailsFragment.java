package com.example.sid.marwadishaadi.User_Profile;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.sid.marwadishaadi.R;
import com.example.sid.marwadishaadi.Search.BottomSheet;
import com.example.sid.marwadishaadi.Similar_Profiles.SimilarActivity;

public class ProfileAdditionalDetailsFragment extends Fragment {

    private TextView edit_about;
    private TextView edit_hobbies;
    private TextView edit_lifestyle;
    private TextView edit_horoscope;
    private static  int casebreak;
    private Button similar;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View mview = inflater.inflate(R.layout.fragment_profile__additional__details, container, false);
        edit_about = (TextView) mview.findViewById(R.id.aboutme_clear);
        edit_hobbies=(TextView) mview.findViewById(R.id.hobbies_clear);
        edit_lifestyle=(TextView)mview.findViewById(R.id.lifestyle_clear);
        edit_horoscope = (TextView) mview.findViewById(R.id.horoscope_clear);
        similar = (Button) mview.findViewById(R.id.similar);

        similar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), SimilarActivity.class);
                startActivity(i);
                getActivity().overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
            }
        });

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


    public int getCasebreak()
    {
        return this.casebreak;
    }
}
