package com.example.sid.marwadishaadi.Dashboard_Interest_Received;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sid.marwadishaadi.R;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.recyclerview.animators.FadeInLeftAnimator;


public class InterestReceivedFragment extends Fragment {

    private static final String TAG = "InterestActivity";
    private List<InterestReceivedModel> intererstList;
    private RecyclerView recyclerView;
    private InterestReceivedAdapter interestReceivedAdapter;
    private CoordinatorLayout coordinatorLayout;
    private SwipeRefreshLayout swipeRefreshLayout;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View mview = inflater.inflate(R.layout.fragment_interest_received, container, false);

        swipeRefreshLayout = (SwipeRefreshLayout)mview.findViewById(R.id.swipe);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshData();
            }
        });
        coordinatorLayout = (CoordinatorLayout) mview.findViewById(R.id.interest_layout);
        recyclerView = (RecyclerView) mview.findViewById(R.id.swipe_recyclerview);
        intererstList = new ArrayList<>();
        interestReceivedAdapter = new InterestReceivedAdapter(getContext(), intererstList,recyclerView);
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        FadeInLeftAnimator fadeInLeftAnimator = new FadeInLeftAnimator();
        recyclerView.setItemAnimator(fadeInLeftAnimator);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(interestReceivedAdapter);
        prepareInterest();

        return mview;
    }

    private void refreshData() {
        InterestReceivedModel interestReceivedModelF = new InterestReceivedModel("Tyrion,", "18", "Former Hand of Kind", "Seven Kingdom","https://avatars2.githubusercontent.com/u/13920107?v=3&s=460",0);
        intererstList.add(interestReceivedModelF);
        interestReceivedAdapter.notifyDataSetChanged();
        swipeRefreshLayout.setRefreshing(false);
    }

    private void prepareInterest() {


        InterestReceivedModel interestReceivedModelF = new InterestReceivedModel("Tyrion,", "18", "Former Hand of Kind", "Seven Kingdom","https://avatars2.githubusercontent.com/u/13920107?v=3&s=460",0);
        intererstList.add(interestReceivedModelF);

        InterestReceivedModel interestReceivedModelS = new InterestReceivedModel("Cersie,", "18", "Former Hand of Kind", "Seven Kingdom", "https://scontent.fbom1-1.fna.fbcdn.net/v/t1.0-9/542932_1870229913255094_1073152164360738877_n.jpg?oh=414cb9683ac4daa8f7a67f63316215f6&oe=59ABFA15",1);
        intererstList.add(interestReceivedModelS);

        InterestReceivedModel interestReceivedModelT = new InterestReceivedModel("Jon,", "18", "Former Hand of Kind", "Seven Kingdom","https://lh3.googleusercontent.com/-_2FnlCFcgfA/WTUS3yDAXII/AAAAAAAAIHg/IRXv4NgTIcMlyoDaGfr8IYdVR2y_9ccugCK8B/s512/2017-06-05.jpg",2);
        intererstList.add(interestReceivedModelT);

        Log.d(TAG, "prepareInterest: here called interest .........");

        interestReceivedAdapter.notifyDataSetChanged();
    }


}
