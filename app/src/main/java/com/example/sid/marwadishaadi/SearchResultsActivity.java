package com.example.sid.marwadishaadi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.sid.marwadishaadi.Dashboard_Suggestions.SuggestionAdapter;
import com.example.sid.marwadishaadi.Dashboard_Suggestions.SuggestionModel;

import java.util.ArrayList;
import java.util.List;

public class SearchResultsActivity extends AppCompatActivity {


    private List<SuggestionModel> suggestionModelList = new ArrayList<>();
    private RecyclerView recyclerView;
    private SuggestionAdapter suggestionAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);

        recyclerView = (RecyclerView) findViewById(R.id.recycler);

        suggestionAdapter=  new SuggestionAdapter(getApplicationContext(), suggestionModelList);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(suggestionAdapter);
        prepareBlockData();

    }

    private void prepareBlockData() {

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


}
