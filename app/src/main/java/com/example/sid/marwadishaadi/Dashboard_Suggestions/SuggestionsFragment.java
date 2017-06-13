package com.example.sid.marwadishaadi.Dashboard_Suggestions;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sid.marwadishaadi.Dashboard;
import com.example.sid.marwadishaadi.R;
import com.example.sid.marwadishaadi.Settings.SettingsActivity;
import com.example.sid.marwadishaadi.User_Profile.Edit_User_Profile.EditPreferencesActivity;
import com.example.sid.marwadishaadi.User_Profile.UserProfileActivity;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SuggestionsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SuggestionsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SuggestionsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private List<SuggestionModel> suggestionModelList = new ArrayList<>();
    private RecyclerView recyclerView;
    private SuggestionAdapter suggestionAdapter;
    private TextView editprefs;
    private TextView filter;
    private OnFragmentInteractionListener mListener;

    public SuggestionsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SuggestionsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SuggestionsFragment newInstance(String param1, String param2) {
        SuggestionsFragment fragment = new SuggestionsFragment();
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
        View mview = inflater.inflate(R.layout.fragment_suggestions, container, false);
        editprefs = (TextView) mview.findViewById(R.id.preference);
        filter = (TextView) mview.findViewById(R.id.filter);

        editprefs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getContext(), EditPreferencesActivity.class);
                startActivity(i);
                getActivity().overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
            }
        });

        filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                View filter_view =getActivity().getLayoutInflater().inflate(R.layout.filter_dialog,null);
                AlertDialog.Builder filter = new AlertDialog.Builder(getContext());
                filter.setTitle("Refine");
                filter.setView(filter_view);
                AlertDialog filterbox = filter.create();
                filterbox.show();
            }
        });

        recyclerView = (RecyclerView) mview.findViewById(R.id.recycler);

        suggestionAdapter=  new SuggestionAdapter(getContext(), suggestionModelList);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(suggestionAdapter);
        prepareBlockData();

        return mview;
    }
    public void  prepareBlockData()
    {
        SuggestionModel recentAttri=new SuggestionModel(19,"https://lh3.googleusercontent.com/-8D2J9cZOoG8/WTUSKeS-6iI/AAAAAAAAIHY/fv2ETqvW1WMegWYpleca_bacQO8IjZDKACK8B/s512/2017-06-05.jpg","Maitree Pasad", "M1234","B.Tech","Mumbai","5'7 feet","Shaadi.com","INR 25000","Unmarried","Mulund","Software Engineer");
        suggestionModelList.add(recentAttri);

        SuggestionModel recentAttri1=new SuggestionModel(22,"https://avatars2.githubusercontent.com/u/13920107?v=3&s=460","Siddhesh Rane", "S1234","B.Tech","Mumbai","5'11","Shaadi.com","25000","Unmarried","Thane","Software Engineer");
        suggestionModelList.add(recentAttri1);

        SuggestionModel recentAttri2=new SuggestionModel(22,"https://lh3.googleusercontent.com/-XcUWlzpPfc8/WTUTyRwiTXI/AAAAAAAAIHs/E4zMBLDuWLwdiZ93WuMjQPfk5Ols_HZTwCK8B/s512/2017-06-05.jpg","Mervin Dalmet", "M1233","B.Tech","Mumbai","5'7","Shaadi.com","25000","Unmarried","Vasai","Software Engineer");
        suggestionModelList.add(recentAttri2);

        SuggestionModel recentAttri3=new SuggestionModel(22,"https://scontent.fbom1-1.fna.fbcdn.net/v/t1.0-9/542932_1870229913255094_1073152164360738877_n.jpg?oh=414cb9683ac4daa8f7a67f63316215f6&oe=59ABFA15","Nirmal Saraswat", "M1233","B.Tech","Mumbai","5'7","Shaadi.com","25000","Unmarried","Vasai","Software Engineer");
        suggestionModelList.add(recentAttri3);

        SuggestionModel recentAttri4=new SuggestionModel(22,"https://lh3.googleusercontent.com/-_2FnlCFcgfA/WTUS3yDAXII/AAAAAAAAIHg/IRXv4NgTIcMlyoDaGfr8IYdVR2y_9ccugCK8B/s512/2017-06-05.jpg","Pranay Parmar", "M1233","B.Tech","Mumbai","5'7","Shaadi.com","25000","Unmarried","Vasai","Software Engineer");
        suggestionModelList.add(recentAttri4);

        suggestionAdapter.notifyDataSetChanged();
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
}
