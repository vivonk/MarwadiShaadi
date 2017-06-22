package com.example.sid.marwadishaadi.Dashboard_Favourites;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sid.marwadishaadi.R;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.recyclerview.animators.FadeInLeftAnimator;


public class FavouritesFragment extends Fragment {

    private List<FavouriteModel> favouritesList= new ArrayList<>();
    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private FavouritesAdapter favouritesAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View mview =  inflater.inflate(R.layout.swipe_to_refresh, container, false);
        recyclerView = (RecyclerView) mview.findViewById(R.id.swipe_recyclerview);
        swipeRefreshLayout=(SwipeRefreshLayout)mview.findViewById(R.id.swipe);
        favouritesAdapter = new FavouritesAdapter(getContext(), favouritesList);
        recyclerView.setHasFixedSize(true);
        FadeInLeftAnimator fadeInLeftAnimator = new FadeInLeftAnimator();
        recyclerView.setItemAnimator(fadeInLeftAnimator);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        recyclerView.setAdapter(favouritesAdapter);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshContent();

            }});
        prepareBlockData();
        return mview;
    }

    private void refreshContent() {
        FavouriteModel favouriteModel = new FavouriteModel("Mervin", "Vasai", "B.A", 21, "https://avatars2.githubusercontent.com/u/13920107?v=3&s=460");
        favouritesList.add(favouriteModel);
        favouritesAdapter.notifyDataSetChanged();
        swipeRefreshLayout.setRefreshing(false);
    }

    public void prepareBlockData(){
        FavouriteModel favouriteModel = new FavouriteModel("Praveen", "Mumbai", "B.Tech", 21, "https://lh3.googleusercontent.com/-_2FnlCFcgfA/WTUS3yDAXII/AAAAAAAAIHg/IRXv4NgTIcMlyoDaGfr8IYdVR2y_9ccugCK8B/s512/2017-06-05.jpg");
        favouritesList.add(favouriteModel);
        favouriteModel = new FavouriteModel("Saniya", "Kalyan", "B.A", 21, "https://avatars2.githubusercontent.com/u/13920107?v=3&s=460");
        favouritesList.add(favouriteModel);
        favouritesAdapter.notifyDataSetChanged();
    }


}
