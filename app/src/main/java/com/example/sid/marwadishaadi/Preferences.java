package com.example.sid.marwadishaadi;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.crystal.crystalrangeseekbar.interfaces.OnRangeSeekbarChangeListener;
import com.crystal.crystalrangeseekbar.interfaces.OnRangeSeekbarFinalValueListener;
import com.crystal.crystalrangeseekbar.widgets.CrystalRangeSeekbar;
import com.example.sid.marwadishaadi.Otp_Verification.Otp_Verification;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

import static com.facebook.FacebookSdk.getApplicationContext;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Preferences.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Preferences#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Preferences extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    ImageView idoctor,iengineer,imbamca,icacs,ipg,ig,iug,illb;
    boolean intdoctor=false,intengineer=false,intmbamca=false,intcacs=false,intpg=false,intg=false,intug=false,intllb=false;
    TextView tdoctor,tengineer,tmbamca,tcacs,tpg,tg,tug,tllb;
    LinearLayout ldoctor,lengineer,lmbamca,lcacs,lpg,lg,lug,lllb;
    int colorg,colorb;

    Button complete;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Preferences() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Preferences.
     */
    // TODO: Rename and change types and number of parameters
    public static Preferences newInstance(String param1, String param2) {
        Preferences fragment = new Preferences();
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
        View view = inflater.inflate(R.layout.fragment_preferences, container, false);

        complete = (Button) view.findViewById(R.id.complete);

        idoctor=(ImageView) view.findViewById(R.id.doctor);
        iengineer=(ImageView)view.findViewById(R.id.engineer);
        icacs=(ImageView)view.findViewById(R.id.ca_cs);
        ipg=(ImageView)view.findViewById(R.id.pg);
        ig=(ImageView)view.findViewById(R.id.g);
        iug=(ImageView)view.findViewById(R.id.ug);
        imbamca=(ImageView)view.findViewById(R.id.mba_mca);
        illb=(ImageView)view.findViewById(R.id.llb);

        tdoctor=(TextView)view.findViewById(R.id.text_doctor);
        tengineer=(TextView)view.findViewById(R.id.text_engineer);
        tmbamca=(TextView)view.findViewById(R.id.text_mba_mca);
        tcacs=(TextView)view.findViewById(R.id.text_ca_cs);
        tllb=(TextView)view.findViewById(R.id.text_llb);
        tpg=(TextView)view.findViewById(R.id.text_pg);
        tg=(TextView)view.findViewById(R.id.text_g);
        tug=(TextView)view.findViewById(R.id.text_ug);

        ldoctor=(LinearLayout)view.findViewById(R.id.list_doctor);
        lengineer=(LinearLayout)view.findViewById(R.id.list_engineer);
        lmbamca=(LinearLayout)view.findViewById(R.id.list_mab_mca);
        lcacs=(LinearLayout)view.findViewById(R.id.list_ca_cs);
        lllb=(LinearLayout)view.findViewById(R.id.list_llb);
        lpg=(LinearLayout)view.findViewById(R.id.list_pg);
        lg=(LinearLayout)view.findViewById(R.id.list_g);
        lug=(LinearLayout)view.findViewById(R.id.list_ug);



        complete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(),Otp_Verification.class);
                startActivity(i);
            }
        });

        // get seekbar from view

        final CrystalRangeSeekbar rangeSeekbar = (CrystalRangeSeekbar) view.findViewById(R.id.rangeSeekbar);
// get min and max text view
        final TextView tvMin = (TextView) view.findViewById(R.id.textMin);
        final TextView tvMax = (TextView) view.findViewById(R.id.textMax);
        rangeSeekbar.setMinValue(18);
        rangeSeekbar.setMaxValue(71);
// set listener
        rangeSeekbar.setOnRangeSeekbarChangeListener(new OnRangeSeekbarChangeListener() {
            @Override
            public void valueChanged(Number minValue, Number maxValue) {
                tvMin.setText(String.valueOf(minValue));
                tvMax.setText(String.valueOf(maxValue));
            }
        });

// set final value listener
        rangeSeekbar.setOnRangeSeekbarFinalValueListener(new OnRangeSeekbarFinalValueListener() {
            @Override
            public void finalValue(Number minValue, Number maxValue) {
                Log.d("CRS=>", String.valueOf(minValue) + " : " + String.valueOf(maxValue));
            }
        });

        colorg= Color.parseColor("#"+"fb6542");
        colorb= Color.parseColor("#"+"000000");
        tdoctor.setTextColor(colorb);
        tengineer.setTextColor(colorb);
        tmbamca.setTextColor(colorb);
        tcacs.setTextColor(colorb);
        tllb.setTextColor(colorb);
        tpg.setTextColor(colorb);
        tg.setTextColor(colorb);
        tug.setTextColor(colorb);



        ldoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(intdoctor)
                {
                    intdoctor=false;
                    tdoctor.setTextColor(colorb);
                    Toast.makeText(getApplicationContext(),"Doctor Removed", Toast.LENGTH_SHORT).show();
                    idoctor.setImageResource(R.drawable.doctor_black);
                }
                else if(!intdoctor) {
                    intdoctor=true;
                    tdoctor.setTextColor(colorg);
                    Toast.makeText(getApplicationContext(),"Doctor Added", Toast.LENGTH_SHORT).show();
                    idoctor.setImageResource(R.drawable.doctor);
                }
            }
        });
        lengineer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(intengineer)
                {
                    intengineer=false;
                    tengineer.setTextColor(colorb);
                    Toast.makeText(getApplicationContext(),"Engineer Removed", Toast.LENGTH_SHORT).show();
                    iengineer.setImageResource(R.drawable.engineer_black);
                }
                else if(!intengineer) {
                    intengineer=true;
                    tengineer.setTextColor(colorg);
                    Toast.makeText(getApplicationContext(),"Engineer Added", Toast.LENGTH_SHORT).show();
                    iengineer.setImageResource(R.drawable.engineer);
                }
            }
        });
        lmbamca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(intmbamca)
                {
                    intmbamca=false;
                    tmbamca.setTextColor(colorb);
                    Toast.makeText(getApplicationContext(),"MBA/MCA Removed", Toast.LENGTH_SHORT).show();
                    imbamca.setImageResource(R.drawable.mba_black);
                }
                else if(!intmbamca) {
                    intmbamca=true;
                    tmbamca.setTextColor(colorg);
                    Toast.makeText(getApplicationContext(),"MBA/MCA Added", Toast.LENGTH_SHORT).show();
                    imbamca.setImageResource(R.drawable.mba);
                }
            }
        });
        lcacs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(intcacs)
                {
                    intcacs=false;
                    tcacs.setTextColor(colorb);
                    Toast.makeText(getApplicationContext(),"CA/CS Removed", Toast.LENGTH_SHORT).show();
                    icacs.setImageResource(R.drawable.ca_black);
                }
                else if(!intcacs) {
                    intcacs=true;
                    tcacs.setTextColor(colorg);
                    Toast.makeText(getApplicationContext(),"CA/CS Added", Toast.LENGTH_SHORT).show();
                    icacs.setImageResource(R.drawable.ca);
                }
            }
        });
        lpg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(intpg)
                {
                    intpg=false;
                    tpg.setTextColor(colorb);
                    Toast.makeText(getApplicationContext(),"PostGraduate Removed", Toast.LENGTH_SHORT).show();
                    ipg.setImageResource(R.drawable.mba_black);
                }
                else if(!intpg) {
                    intpg=true;
                    tpg.setTextColor(colorg);
                    Toast.makeText(getApplicationContext(),"PostGraduate Added", Toast.LENGTH_SHORT).show();
                    ipg.setImageResource(R.drawable.mba);
                }
            }
        });
        lg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(intg)
                {
                    intg=false;
                    tg.setTextColor(colorb);
                    Toast.makeText(getApplicationContext(),"Graduate Removed", Toast.LENGTH_SHORT).show();
                    ig.setImageResource(R.drawable.grad_black);
                }
                else if(!intg) {
                    intg=true;
                    tg.setTextColor(colorg);
                    Toast.makeText(getApplicationContext(),"Graduate Added", Toast.LENGTH_SHORT).show();
                    ig.setImageResource(R.drawable.grad);
                }
            }
        });
        lug.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(intug)
                {
                    intug=false;
                    tug.setTextColor(colorb);
                    Toast.makeText(getApplicationContext(),"UnderGraduate Removed", Toast.LENGTH_SHORT).show();
                    iug.setImageResource(R.drawable.undergrad_black);
                }
                else if(!intug) {
                    intug=true;
                    Toast.makeText(getApplicationContext(),"UnderGraduate Added", Toast.LENGTH_SHORT).show();
                    tug.setTextColor(colorg);
                    iug.setImageResource(R.drawable.undergrad);
                }
            }
        });
        lllb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(intllb)
                {
                    intllb=false;
                    tllb.setTextColor(colorb);
                    Toast.makeText(getApplicationContext(),"LLB Removed", Toast.LENGTH_SHORT).show();
                    illb.setImageResource(R.drawable.llb_black);
                }
                else if(!intllb) {
                    intllb=true;
                    Toast.makeText(getApplicationContext(),"LLB Added", Toast.LENGTH_SHORT).show();
                    tllb.setTextColor(colorg);
                    illb.setImageResource(R.drawable.llb);
                }
            }
        });
        idoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(intdoctor)
                {
                    intdoctor=false;
                    tdoctor.setTextColor(colorb);
                    Toast.makeText(getApplicationContext(),"Doctor Removed", Toast.LENGTH_SHORT).show();
                    idoctor.setImageResource(R.drawable.doctor_black);
                }
                else if(!intdoctor) {
                    intdoctor=true;
                    tdoctor.setTextColor(colorg);
                    Toast.makeText(getApplicationContext(),"Doctor Added", Toast.LENGTH_SHORT).show();
                    idoctor.setImageResource(R.drawable.doctor);
                }
            }
        });
        iengineer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(intengineer)
                {
                    intengineer=false;
                    tengineer.setTextColor(colorb);
                    Toast.makeText(getApplicationContext(),"Engineer Removed", Toast.LENGTH_SHORT).show();
                    iengineer.setImageResource(R.drawable.engineer_black);
                }
                else if(!intengineer) {
                    intengineer=true;
                    tengineer.setTextColor(colorg);
                    Toast.makeText(getApplicationContext(),"Engineer Added", Toast.LENGTH_SHORT).show();
                    iengineer.setImageResource(R.drawable.engineer);
                }
            }
        });
        imbamca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(intmbamca)
                {
                    intmbamca=false;
                    tmbamca.setTextColor(colorb);
                    Toast.makeText(getApplicationContext(),"MBA/MCA Removed", Toast.LENGTH_SHORT).show();
                    imbamca.setImageResource(R.drawable.mba_black);
                }
                else if(!intmbamca) {
                    intmbamca=true;
                    tmbamca.setTextColor(colorg);
                    Toast.makeText(getApplicationContext(),"MBA/MCA Added", Toast.LENGTH_SHORT).show();
                    imbamca.setImageResource(R.drawable.mba);
                }
            }
        });
        icacs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(intcacs)
                {
                    intcacs=false;
                    tcacs.setTextColor(colorb);
                    Toast.makeText(getApplicationContext(),"CA/CS Removed", Toast.LENGTH_SHORT).show();
                    icacs.setImageResource(R.drawable.ca_black);
                }
                else if(!intcacs) {
                    intcacs=true;
                    tcacs.setTextColor(colorg);
                    Toast.makeText(getApplicationContext(),"CA/CS Added", Toast.LENGTH_SHORT).show();
                    icacs.setImageResource(R.drawable.ca);
                }
            }
        });
        ipg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(intpg)
                {
                    intpg=false;
                    tpg.setTextColor(colorb);
                    Toast.makeText(getApplicationContext(),"PostGraduate Removed", Toast.LENGTH_SHORT).show();
                    ipg.setImageResource(R.drawable.mba_black);
                }
                else if(!intpg) {
                    intpg=true;
                    tpg.setTextColor(colorg);
                    Toast.makeText(getApplicationContext(),"PostGraduate Added", Toast.LENGTH_SHORT).show();
                    ipg.setImageResource(R.drawable.mba);
                }
            }
        });
        ig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(intg)
                {
                    intg=false;
                    tg.setTextColor(colorb);
                    Toast.makeText(getApplicationContext(),"Graduate Removed", Toast.LENGTH_SHORT).show();
                    ig.setImageResource(R.drawable.grad_black);
                }
                else if(!intg) {
                    intg=true;
                    tg.setTextColor(colorg);
                    Toast.makeText(getApplicationContext(),"Graduate Added", Toast.LENGTH_SHORT).show();
                    ig.setImageResource(R.drawable.grad);
                }
            }
        });
        iug.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(intug)
                {
                    intug=false;
                    tug.setTextColor(colorb);
                    Toast.makeText(getApplicationContext(),"UnderGraduate Removed", Toast.LENGTH_SHORT).show();
                    iug.setImageResource(R.drawable.undergrad_black);
                }
                else if(!intug) {
                    intug=true;
                    Toast.makeText(getApplicationContext(),"UnderGraduate Added", Toast.LENGTH_SHORT).show();
                    tug.setTextColor(colorg);
                    iug.setImageResource(R.drawable.undergrad);
                }
            }
        });
        illb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(intllb)
                {
                    intllb=false;
                    tllb.setTextColor(colorb);
                    Toast.makeText(getApplicationContext(),"LLB Removed", Toast.LENGTH_SHORT).show();
                    illb.setImageResource(R.drawable.llb_black);
                }
                else if(!intllb) {
                    intllb=true;
                    Toast.makeText(getApplicationContext(),"LLB Added", Toast.LENGTH_SHORT).show();
                    tllb.setTextColor(colorg);
                    illb.setImageResource(R.drawable.llb);
                }
            }
        });
        return view;

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

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
