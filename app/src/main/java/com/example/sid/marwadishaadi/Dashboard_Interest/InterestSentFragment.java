package com.example.sid.marwadishaadi.Dashboard_Interest;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sid.marwadishaadi.R;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.recyclerview.animators.FadeInLeftAnimator;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link InterestSentFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link InterestSentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InterestSentFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters

    private String mParam1;
    private String mParam2;
    private static final String TAG = "InterestActivity";
    private Context mContext;
    private List<InterestModelSent> intererstListSent;
    private RecyclerView recyclerView;
    private InterestAdapterSent interestAdapterSent;
    private View view;
    private SwipeRefreshLayout swipeRefreshLayout;

    private OnFragmentInteractionListener mListener;

    public InterestSentFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment InterestSentFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static InterestSentFragment newInstance(String param1, String param2) {
        InterestSentFragment fragment = new InterestSentFragment();
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
        View mview = inflater.inflate(R.layout.fragment_interest_received, container, false);

        swipeRefreshLayout = (SwipeRefreshLayout)mview.findViewById(R.id.swipe);
        recyclerView = (RecyclerView) mview.findViewById(R.id.swipe_recyclerview);
        intererstListSent = new ArrayList<>();
        interestAdapterSent = new InterestAdapterSent(getContext(), intererstListSent);
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        FadeInLeftAnimator fadeInLeftAnimator = new FadeInLeftAnimator();
        recyclerView.setItemAnimator(fadeInLeftAnimator);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(interestAdapterSent);
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
        InterestModelSent interestModelSent=new InterestModelSent("Mervin Dalmet","Mumbai","B. Tech","https://avatars2.githubusercontent.com/u/13920107?v=3&s=460","Seen your request and decided to respond later ",18,"05-Jul-2017");
        intererstListSent.add(interestModelSent);
        interestModelSent=new InterestModelSent("Maitree Pasad","Mumbai","B. Tech","https://scontent.fbom1-1.fna.fbcdn.net/v/t1.0-9/542932_1870229913255094_1073152164360738877_n.jpg?oh=414cb9683ac4daa8f7a67f63316215f6&oe=59ABFA15","Not seen your request  ",18,"05-Jul-2017");
        intererstListSent.add(interestModelSent);
        interestModelSent=new InterestModelSent("Siddhesh Rane","Mumbai","B. Tech","https://lh3.googleusercontent.com/-_2FnlCFcgfA/WTUS3yDAXII/AAAAAAAAIHg/IRXv4NgTIcMlyoDaGfr8IYdVR2y_9ccugCK8B/s512/2017-06-05.jpg","Seen your request and accepted ",18,"05-Jul-2017");
        intererstListSent.add(interestModelSent);

        interestAdapterSent.notifyDataSetChanged();
        swipeRefreshLayout.setRefreshing(false);
    }

    public void prepareInterest(){
        InterestModelSent interestModelSent=new InterestModelSent("Mervin Dalmet","Mumbai","B. Tech","https://avatars2.githubusercontent.com/u/13920107?v=3&s=460","Seen your request and decided to respond later ",18,"05-Jul-2017");
        intererstListSent.add(interestModelSent);
        interestModelSent=new InterestModelSent("Maitree Pasad","Mumbai","B. Tech","https://scontent.fbom1-1.fna.fbcdn.net/v/t1.0-9/542932_1870229913255094_1073152164360738877_n.jpg?oh=414cb9683ac4daa8f7a67f63316215f6&oe=59ABFA15","Not seen your request  ",18,"05-Jul-2017");
        intererstListSent.add(interestModelSent);
        interestModelSent=new InterestModelSent("Siddhesh Rane","Mumbai","B. Tech","https://lh3.googleusercontent.com/-_2FnlCFcgfA/WTUS3yDAXII/AAAAAAAAIHg/IRXv4NgTIcMlyoDaGfr8IYdVR2y_9ccugCK8B/s512/2017-06-05.jpg","Seen your request and accepted ",18,"05-Jul-2017");
        intererstListSent.add(interestModelSent);
        interestModelSent=new InterestModelSent("Nirmal Saraswat","Mumbai","B. Tech","https://avatars2.githubusercontent.com/u/13920107?v=3&s=460","Seen your request and decided to respond later ",18,"05-Jul-2017");
        intererstListSent.add(interestModelSent);
        interestAdapterSent.notifyDataSetChanged();
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

   /* @Override
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
