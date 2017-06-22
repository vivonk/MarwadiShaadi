package com.example.sid.marwadishaadi.Dashboard_Suggestions;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sid.marwadishaadi.Filter;
import com.example.sid.marwadishaadi.R;
import com.example.sid.marwadishaadi.User_Profile.Edit_User_Profile.EditPreferencesActivity;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.recyclerview.animators.FadeInLeftAnimator;


public class SuggestionsFragment extends Fragment {

    private List<SuggestionModel> suggestionModelList = new ArrayList<>();
    private RecyclerView recyclerView;
    private SuggestionAdapter suggestionAdapter;
    private TextView editprefs;
    private TextView filters;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            View mview = inflater.inflate(R.layout.fragment_suggestions, container, false);
        editprefs = (TextView) mview.findViewById(R.id.preference);
        filters = (TextView) mview.findViewById(R.id.filter);

        editprefs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getContext(), EditPreferencesActivity.class);
                startActivity(i);
                getActivity().overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
            }
        });

        filters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent i = new Intent(getContext(), Filter.class);
                startActivity(i);
                getActivity().overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);

            }
        });


        recyclerView = (RecyclerView) mview.findViewById(R.id.swipe_recyclerview);
        swipeRefreshLayout=(SwipeRefreshLayout)mview.findViewById(R.id.swipe);
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        suggestionAdapter=  new SuggestionAdapter(getContext(), suggestionModelList,recyclerView);
        FadeInLeftAnimator fadeInLeftAnimator = new FadeInLeftAnimator();
        recyclerView.setItemAnimator(fadeInLeftAnimator);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());

        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(suggestionAdapter);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshContent();
            }
        });
        prepareBlockData();
        return mview;
    }

    private void refreshContent() {
        SuggestionModel recentAttri=new SuggestionModel(19,"https://lh3.googleusercontent.com/-8D2J9cZOoG8/WTUSKeS-6iI/AAAAAAAAIHY/fv2ETqvW1WMegWYpleca_bacQO8IjZDKACK8B/s512/2017-06-05.jpg","Max Payne", "M1234","B.Tech","Mumbai","5'7 feet","Shaadi.com","INR 25000","Unmarried","Mulund","Software Engineer");
        suggestionModelList.add(recentAttri);
        SuggestionModel recentAttri2=new SuggestionModel(22,"https://lh3.googleusercontent.com/-XcUWlzpPfc8/WTUTyRwiTXI/AAAAAAAAIHs/E4zMBLDuWLwdiZ93WuMjQPfk5Ols_HZTwCK8B/s512/2017-06-05.jpg","Mervin Dalmet", "M1233","B.Tech","Mumbai","5'7","Shaadi.com","25000","Unmarried","Vasai","Software Engineer");
        suggestionModelList.add(recentAttri2);

        SuggestionModel recentAttri3=new SuggestionModel(22,"https://scontent.fbom1-1.fna.fbcdn.net/v/t1.0-9/542932_1870229913255094_1073152164360738877_n.jpg?oh=414cb9683ac4daa8f7a67f63316215f6&oe=59ABFA15","Nirmal Saraswat", "M1233","B.Tech","Mumbai","5'7","Shaadi.com","25000","Unmarried","Vasai","Software Engineer");
        suggestionModelList.add(recentAttri3);

        SuggestionModel recentAttri4=new SuggestionModel(22,"https://lh3.googleusercontent.com/-_2FnlCFcgfA/WTUS3yDAXII/AAAAAAAAIHg/IRXv4NgTIcMlyoDaGfr8IYdVR2y_9ccugCK8B/s512/2017-06-05.jpg","Pranay Parmar", "M1233","B.Tech","Mumbai","5'7","Shaadi.com","25000","Unmarried","Vasai","Software Engineer");
        suggestionModelList.add(recentAttri4);
        suggestionAdapter.notifyDataSetChanged();
        swipeRefreshLayout.setRefreshing(false);
    }

    public void  prepareBlockData()
    {
        SuggestionModel recentAttri=new SuggestionModel(19,"https://lh3.googleusercontent.com/-8D2J9cZOoG8/WTUSKeS-6iI/AAAAAAAAIHY/fv2ETqvW1WMegWYpleca_bacQO8IjZDKACK8B/s512/2017-06-05.jpg","Maitree Pasad", "M1234","B.Tech","Mumbai","5'7 feet","Shaadi.com","INR 25000","Unmarried","Mulund","Software Engineer");
        suggestionModelList.add(recentAttri);

        SuggestionModel recentAttri1=new SuggestionModel(22,"https://avatars2.githubusercontent.com/u/13920107?v=3&s=460","Siddhesh Rane", "S1234","B.Tech","Mumbai","5'11","Shaadi.com","25000","Unmarried","Thane","Software Engineer");
        suggestionModelList.add(recentAttri1);



        suggestionAdapter.notifyDataSetChanged();
    }


}
