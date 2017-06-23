package com.example.sid.marwadishaadi.Dashboard_Interest_Sent;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sid.marwadishaadi.Analytics_Util;
import com.example.sid.marwadishaadi.R;
import com.google.firebase.analytics.FirebaseAnalytics;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.recyclerview.animators.FadeInLeftAnimator;


public class InterestSentFragment extends Fragment {

    private static final String TAG = "InterestActivity";
    private List<InterestSentModel> intererstListSent;
    private RecyclerView recyclerView;
    private InterestSentAdapter interestSentAdapter;
    private SwipeRefreshLayout swipeRefreshLayout;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View mview = inflater.inflate(R.layout.fragment_interest_received, container, false);



        swipeRefreshLayout = (SwipeRefreshLayout)mview.findViewById(R.id.swipe);
        recyclerView = (RecyclerView) mview.findViewById(R.id.swipe_recyclerview);
        intererstListSent = new ArrayList<>();
        interestSentAdapter = new InterestSentAdapter(getContext(), intererstListSent);
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        FadeInLeftAnimator fadeInLeftAnimator = new FadeInLeftAnimator();
        recyclerView.setItemAnimator(fadeInLeftAnimator);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(interestSentAdapter);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshData();
            }
        });
        prepareInterest();

        return mview;
    }

    private void refreshData() {
        InterestSentModel interestSentModel =new InterestSentModel("Mervin Dalmet","Mumbai","B. Tech","https://avatars2.githubusercontent.com/u/13920107?v=3&s=460","Seen your request and decided to respond later ",18,"05-Jul-2017");
        intererstListSent.add(interestSentModel);
        interestSentModel =new InterestSentModel("Maitree Pasad","Mumbai","B. Tech","https://scontent.fbom1-1.fna.fbcdn.net/v/t1.0-9/542932_1870229913255094_1073152164360738877_n.jpg?oh=414cb9683ac4daa8f7a67f63316215f6&oe=59ABFA15","Not seen your request  ",18,"05-Jul-2017");
        intererstListSent.add(interestSentModel);
        interestSentModel =new InterestSentModel("Siddhesh Rane","Mumbai","B. Tech","https://lh3.googleusercontent.com/-_2FnlCFcgfA/WTUS3yDAXII/AAAAAAAAIHg/IRXv4NgTIcMlyoDaGfr8IYdVR2y_9ccugCK8B/s512/2017-06-05.jpg","Seen your request and accepted ",18,"05-Jul-2017");
        intererstListSent.add(interestSentModel);

        interestSentAdapter.notifyDataSetChanged();
        swipeRefreshLayout.setRefreshing(false);
    }

    public void prepareInterest(){
        InterestSentModel interestSentModel =new InterestSentModel("Mervin Dalmet","Mumbai","B. Tech","https://avatars2.githubusercontent.com/u/13920107?v=3&s=460","Seen your request and decided to respond later ",18,"05-Jul-2017");
        intererstListSent.add(interestSentModel);
        interestSentModel =new InterestSentModel("Maitree Pasad","Mumbai","B. Tech","https://scontent.fbom1-1.fna.fbcdn.net/v/t1.0-9/542932_1870229913255094_1073152164360738877_n.jpg?oh=414cb9683ac4daa8f7a67f63316215f6&oe=59ABFA15","Not seen your request  ",18,"05-Jul-2017");
        intererstListSent.add(interestSentModel);
        interestSentModel =new InterestSentModel("Siddhesh Rane","Mumbai","B. Tech","https://lh3.googleusercontent.com/-_2FnlCFcgfA/WTUS3yDAXII/AAAAAAAAIHg/IRXv4NgTIcMlyoDaGfr8IYdVR2y_9ccugCK8B/s512/2017-06-05.jpg","Seen your request and accepted ",18,"05-Jul-2017");
        intererstListSent.add(interestSentModel);
        interestSentModel =new InterestSentModel("Nirmal Saraswat","Mumbai","B. Tech","https://avatars2.githubusercontent.com/u/13920107?v=3&s=460","Seen your request and decided to respond later ",18,"05-Jul-2017");
        intererstListSent.add(interestSentModel);
        interestSentAdapter.notifyDataSetChanged();
    }

}
