package com.example.sid.marwadishaadi.Dashboard_Reverse_Matching;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sid.marwadishaadi.R;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Reverse_MatchingActivity.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Reverse_MatchingActivity#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Reverse_MatchingActivity extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private List<ReverseModel> reverseModelList = new ArrayList<>();
    private RecyclerView reverseRecyclerView;
    private ReverseAdapter reverseAdapter;
    private StaggeredGridLayoutManager staggeredGridLayoutManager;
    private OnFragmentInteractionListener mListener;
    private SwipeRefreshLayout swipeRefreshLayout;
    public Reverse_MatchingActivity() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Reverse_MatchingActivity.
     */
    // TODO: Rename and change types and number of parameters
    public static Reverse_MatchingActivity newInstance(String param1, String param2) {
        Reverse_MatchingActivity fragment = new Reverse_MatchingActivity();
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
        View mview =  inflater.inflate(R.layout.fragment_reverse__matching, container, false);

        reverseRecyclerView = (RecyclerView) mview.findViewById(R.id.swipe_recyclerview);
        swipeRefreshLayout = (SwipeRefreshLayout)mview.findViewById(R.id.swipe);
        reverseRecyclerView.setHasFixedSize(true);
        staggeredGridLayoutManager = new StaggeredGridLayoutManager(2,1);
        reverseRecyclerView.setLayoutManager(staggeredGridLayoutManager);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshContent();
            }
        });
        getData();
        reverseAdapter = new ReverseAdapter(reverseModelList,getContext());
        reverseRecyclerView.setAdapter(reverseAdapter);
        return mview;
    }

    private void refreshContent() {
        ReverseModel rev1 = new ReverseModel("https://lh3.googleusercontent.com/-_2FnlCFcgfA/WTUS3yDAXII/AAAAAAAAIHg/IRXv4NgTIcMlyoDaGfr8IYdVR2y_9ccugCK8B/s512/2017-06-05.jpg","Arya Stark",20);
        reverseModelList.add(rev1);

        ReverseModel rev2 = new ReverseModel("https://lh3.googleusercontent.com/-XcUWlzpPfc8/WTUTyRwiTXI/AAAAAAAAIHs/E4zMBLDuWLwdiZ93WuMjQPfk5Ols_HZTwCK8B/s512/2017-06-05.jpg","Mervin Dalmet",20);
        reverseModelList.add(rev2);

        ReverseModel rev3 = new ReverseModel("https://scontent.fbom1-1.fna.fbcdn.net/v/t1.0-9/542932_1870229913255094_1073152164360738877_n.jpg?oh=414cb9683ac4daa8f7a67f63316215f6&oe=59ABFA15","Nirmal Saraswat",20);
        reverseModelList.add(rev3);

        ReverseModel rev4 = new ReverseModel("https://lh3.googleusercontent.com/-_2FnlCFcgfA/WTUS3yDAXII/AAAAAAAAIHg/IRXv4NgTIcMlyoDaGfr8IYdVR2y_9ccugCK8B/s512/2017-06-05.jpg","Pranay Parmar",20);
        reverseModelList.add(rev4);
        reverseAdapter.notifyDataSetChanged();
        swipeRefreshLayout.setRefreshing(false);
    }

    public void getData(){


        ReverseModel rev5 = new ReverseModel("https://avatars2.githubusercontent.com/u/13920107?v=3&s=460","Siddhesh Rane",20);
        reverseModelList.add(rev5);

        ReverseModel rev6 = new ReverseModel("https://lh3.googleusercontent.com/-V1g8Z_BDz08/WTUm1so2uPI/AAAAAAAAIIA/Dd_KRjoj0oosdISwTRTKcFVgO_YLkbAmgCK8B/s512/2017-06-05.jpg","Vatsal Mankodi",20);
        reverseModelList.add(rev6);

        ReverseModel rev7 = new ReverseModel("https://lh3.googleusercontent.com/-_FDXYHeFNkI/WTUnfm1hDII/AAAAAAAAIII/10qU1JXB_twFY6HO9Z7um-sY8EmLiqCBgCK8B/s512/2017-06-05.jpg","Chinmayee Waze",20);
        reverseModelList.add(rev7);

        ReverseModel rev8 = new ReverseModel("https://lh3.googleusercontent.com/-goP7QgrSZko/WTUnI_sU6xI/AAAAAAAAIIE/etkE4Lx_roc4nyeJY-PHf7ZzJ819YA3jACK8B/s512/2017-06-05.jpg","Saloni Agrawal",20);
        reverseModelList.add(rev8);

        ReverseModel rev9 = new ReverseModel("https://lh3.googleusercontent.com/-fuehKVkteYg/WTUn0PG0exI/AAAAAAAAIIM/FDP13YTCdqguOHXL08kP5pdxlPDnzZXtwCK8B/s512/2017-06-05.jpg","Rutuja Bagul",20);
        reverseModelList.add(rev9);
        reverseAdapter.notifyDataSetChanged();
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
