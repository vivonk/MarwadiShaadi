package com.example.sid.marwadishaadi;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Reverse_Matching.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Reverse_Matching#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Reverse_Matching extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private List<Reverse> reverseList = new ArrayList<>();
    private RecyclerView reverseRecyclerView;
    private ReverseAdapter reverseAdapter;
    private StaggeredGridLayoutManager staggeredGridLayoutManager;
    private OnFragmentInteractionListener mListener;

    public Reverse_Matching() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Reverse_Matching.
     */
    // TODO: Rename and change types and number of parameters
    public static Reverse_Matching newInstance(String param1, String param2) {
        Reverse_Matching fragment = new Reverse_Matching();
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

        reverseRecyclerView = (RecyclerView) mview.findViewById(R.id.reverse);
        reverseRecyclerView.setHasFixedSize(true);
        staggeredGridLayoutManager = new StaggeredGridLayoutManager(2,1);
        reverseRecyclerView.setLayoutManager(staggeredGridLayoutManager);
        getData();
        reverseAdapter = new ReverseAdapter(reverseList,getContext());
        reverseRecyclerView.setAdapter(reverseAdapter);
        return mview;
    }

    public void getData(){

        Reverse rev1 = new Reverse("http://i.lv3.hbo.com/assets/images/series/game-of-thrones/character/s5/arya-stark-1920.jpg","Arya Stark",20);
        reverseList.add(rev1);

        Reverse rev2 = new Reverse("http://vignette1.wikia.nocookie.net/gameofthrones/images/c/cf/Sansa_Battle_of_Bastards_main.jpg/revision/latest?cb=20160621005428","Sansa Stark",20);
        reverseList.add(rev2);

        Reverse rev3 = new Reverse("http://i.lv3.hbo.com/assets/images/series/game-of-thrones/character/s5/daenarys-1024.jpg","Daenarys",20);
        reverseList.add(rev3);

        Reverse rev4 = new Reverse("http://assets.viewers-guide.hbo.com/larges1-ep1-people-profilepic-lannister-jaime-800x800.jpg","Jaime Lannister",20);
        reverseList.add(rev4);

        Reverse rev5 = new Reverse("http://i.lv3.hbo.com/assets/images/series/game-of-thrones/character/s5/talisa-stark-1920.jpg","Talisa Stark",20);
        reverseList.add(rev5);

        Reverse rev6 = new Reverse("https://thoughtcatalog.files.wordpress.com/2016/04/jon-snow.jpg","Jon Snow",20);
        reverseList.add(rev6);

        Reverse rev7 = new Reverse("http://winteriscoming.net/files/2015/12/Bran-Stark-in-Season-1.png","Bran Stark",20);
        reverseList.add(rev7);

        Reverse rev8 = new Reverse("https://s-media-cache-ak0.pinimg.com/736x/56/3e/08/563e08fb3e9089a9b2e0463faeb36bab.jpg","Margary Tyrell",20);
        reverseList.add(rev8);

        Reverse rev9 = new Reverse("http://winteriscoming.net/files/2014/04/petyr-baelish-1024.jpg","Petr Baelish",20);
        reverseList.add(rev9);

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
