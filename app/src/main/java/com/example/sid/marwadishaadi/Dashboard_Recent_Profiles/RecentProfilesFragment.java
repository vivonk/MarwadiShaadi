package com.example.sid.marwadishaadi.Dashboard_Recent_Profiles;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toolbar;

import com.example.sid.marwadishaadi.R;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link RecentProfilesFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link RecentProfilesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RecentProfilesFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private List<RecentModel> recentList;
    private RecyclerView recentRecyclerView;
    private RecentAdapter recentAdapter;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public RecentProfilesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RecentProfilesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RecentProfilesFragment newInstance(String param1, String param2) {
        RecentProfilesFragment fragment = new RecentProfilesFragment();
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
        View mview = inflater.inflate(R.layout.fragment_recent__profiles, container, false);


        recentRecyclerView = (RecyclerView) mview.findViewById(R.id.recent_recycler_view);
        recentList = new ArrayList<>();
        recentAdapter = new RecentAdapter(getContext(), recentList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recentRecyclerView.setLayoutManager(layoutManager);
        recentRecyclerView.setAdapter(recentAdapter);

        prepareRecent();

        return mview;
    }

    private void prepareRecent() {


        RecentModel recentF = new RecentModel("Tyrion", "18", "Former Hand of Kind", "Seven Kingdom", "Last 20 hours ago" ,"https://avatars2.githubusercontent.com/u/13920107?v=3&s=460");
        recentList.add(recentF);

        RecentModel recentS = new RecentModel("Tyrion", "28", "Former Hand of Kind", "Seven Kingdom", "Whatever" ,"https://scontent.fbom1-1.fna.fbcdn.net/v/t1.0-9/542932_1870229913255094_1073152164360738877_n.jpg?oh=414cb9683ac4daa8f7a67f63316215f6&oe=59ABFA15");
        recentList.add(recentS);

        RecentModel recentT = new RecentModel("Tyrion", "38", "Former Hand of Kind", "Seven Kingdom", "Whatever" ,"https://lh3.googleusercontent.com/-_2FnlCFcgfA/WTUS3yDAXII/AAAAAAAAIHg/IRXv4NgTIcMlyoDaGfr8IYdVR2y_9ccugCK8B/s512/2017-06-05.jpg");
        recentList.add(recentT);

        recentAdapter.notifyDataSetChanged();
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
