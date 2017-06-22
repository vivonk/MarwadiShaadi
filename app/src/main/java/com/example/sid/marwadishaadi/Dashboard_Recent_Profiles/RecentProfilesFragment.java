package com.example.sid.marwadishaadi.Dashboard_Recent_Profiles;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toolbar;

import com.example.sid.marwadishaadi.R;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.recyclerview.animators.FadeInLeftAnimator;


public class RecentProfilesFragment extends Fragment {


    private List<RecentModel> recentList;
    private RecyclerView recentRecyclerView;
    private RecentAdapter recentAdapter;
    private SwipeRefreshLayout swipeRefreshLayout;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View mview = inflater.inflate(R.layout.fragment_recent__profiles, container, false);


        recentRecyclerView = (RecyclerView) mview.findViewById(R.id.swipe_recyclerview);
        swipeRefreshLayout = (SwipeRefreshLayout)mview.findViewById(R.id.swipe);
        recentList = new ArrayList<>();
        recentAdapter = new RecentAdapter(getContext(), recentList);
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        FadeInLeftAnimator fadeInLeftAnimator = new FadeInLeftAnimator();
        recentRecyclerView.setItemAnimator(fadeInLeftAnimator);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recentRecyclerView.setLayoutManager(layoutManager);
        recentRecyclerView.setAdapter(recentAdapter);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshData();
            }
        });
        prepareRecent();

        return mview;
    }

    private void refreshData() {
        RecentModel recentF = new RecentModel("Tyrion", "18", "Former Hand of Kind", "Seven Kingdom", "Last 20 hours ago" ,"https://avatars2.githubusercontent.com/u/13920107?v=3&s=460");
        recentList.add(recentF);

        RecentModel recentS = new RecentModel("Tyrion", "28", "Former Hand of Kind", "Seven Kingdom", "Whatever" ,"https://scontent.fbom1-1.fna.fbcdn.net/v/t1.0-9/542932_1870229913255094_1073152164360738877_n.jpg?oh=414cb9683ac4daa8f7a67f63316215f6&oe=59ABFA15");
        recentList.add(recentS);
        recentAdapter.notifyDataSetChanged();
        swipeRefreshLayout.setRefreshing(false);
    }

    private void prepareRecent() {



        RecentModel recentT = new RecentModel("Tyrion", "38", "Former Hand of Kind", "Seven Kingdom", "Whatever" ,"https://lh3.googleusercontent.com/-_2FnlCFcgfA/WTUS3yDAXII/AAAAAAAAIHg/IRXv4NgTIcMlyoDaGfr8IYdVR2y_9ccugCK8B/s512/2017-06-05.jpg");
        recentList.add(recentT);

        recentAdapter.notifyDataSetChanged();
    }

}
