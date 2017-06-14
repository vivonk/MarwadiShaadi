package com.example.sid.marwadishaadi.Search;

import android.animation.ObjectAnimator;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.crystal.crystalrangeseekbar.interfaces.OnRangeSeekbarChangeListener;
import com.crystal.crystalrangeseekbar.interfaces.OnRangeSeekbarFinalValueListener;
import com.crystal.crystalrangeseekbar.widgets.CrystalRangeSeekbar;
import com.example.sid.marwadishaadi.R;

public class Search extends AppCompatActivity {
    ImageView idoctor, iengineer, imbamca, icacs, ipg, ig, iug, illb;
    boolean intdoctor = false, intengineer = false, intmbamca = false, intcacs = false, intpg = false, intg = false, intug = false, intllb = false;
    TextView tdoctor, tengineer, tmbamca, tcacs, tpg, tg, tug, tllb;
    LinearLayout ldoctor, lengineer, lmbamca, lcacs, lpg, lg, lug, lllb;
    int colorg, colorb;
    EditText spinnerCastSearch;
    Button mOpenIDSearchButton;
    private static int casebreak;
    TextView statetextView,citytextview;
    CardView advCV;
    Button addButton,searchaddbutton;
    EditText autoCompleteState,autocompletecity;
    static String  addTextState,addPrevious="";
    static String  addTextcity,addPreviousc="";
    private  EditText maritalstatus;
    private EditText familystatus;
    private EditText annualincome;
    private EditText physicalstatus;

    public Search()
    {

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        Toolbar toolbar = (Toolbar) findViewById(R.id.search_toolbar);
        toolbar.setTitle("Search");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        idoctor = (ImageView) findViewById(R.id.doctor);
        iengineer = (ImageView) findViewById(R.id.engineer);
        icacs = (ImageView) findViewById(R.id.ca_cs);
        ipg = (ImageView) findViewById(R.id.pg);
        ig = (ImageView) findViewById(R.id.g);
        iug = (ImageView) findViewById(R.id.ug);
        imbamca = (ImageView) findViewById(R.id.mba_mca);
        illb = (ImageView) findViewById(R.id.llb);

        tdoctor = (TextView) findViewById(R.id.text_doctor);
        tengineer = (TextView) findViewById(R.id.text_engineer);
        tmbamca = (TextView) findViewById(R.id.text_mba_mca);
        tcacs = (TextView) findViewById(R.id.text_ca_cs);
        tllb = (TextView) findViewById(R.id.text_llb);
        tpg = (TextView) findViewById(R.id.text_pg);
        tg = (TextView) findViewById(R.id.text_g);
        tug = (TextView) findViewById(R.id.text_ug);

        ldoctor = (LinearLayout) findViewById(R.id.list_doctor);
        lengineer = (LinearLayout) findViewById(R.id.list_engineer);
        lmbamca = (LinearLayout) findViewById(R.id.list_mab_mca);
        lcacs = (LinearLayout) findViewById(R.id.list_ca_cs);
        lllb = (LinearLayout) findViewById(R.id.list_llb);
        lpg = (LinearLayout) findViewById(R.id.list_pg);
        lg = (LinearLayout) findViewById(R.id.list_g);
        lug = (LinearLayout) findViewById(R.id.list_ug);

        maritalstatus = (EditText) findViewById(R.id.search_Marital_status);
        maritalstatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                casebreak = 3;
                BottomSheetDialogFragment btm= new BottomSheet(0);
                btm.show(getSupportFragmentManager(),btm.getTag());
            }
        });

        familystatus = (EditText) findViewById(R.id.search_Family_status);
        familystatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                casebreak=4;
                BottomSheetDialogFragment btm= new BottomSheet(0);
                btm.show(getSupportFragmentManager(),btm.getTag());
            }
        });

        annualincome = (EditText) findViewById(R.id.search_Annual_income);
        annualincome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                casebreak=5;
                BottomSheetDialogFragment btm= new BottomSheet(0);
                btm.show(getSupportFragmentManager(),btm.getTag());
            }
        });

        physicalstatus = (EditText) findViewById(R.id.search_physical_status) ;
        physicalstatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                casebreak=6;
                BottomSheetDialogFragment btm= new BottomSheet(0);
                btm.show(getSupportFragmentManager(),btm.getTag());
            }
        });


        addButton=(Button)findViewById(R.id.search_add_state);
        searchaddbutton=(Button)findViewById(R.id.search_add_city);
        statetextView=(TextView)findViewById(R.id.text_view_search_add_state);
        citytextview=(TextView)findViewById(R.id.text_view_search_add_city);
        spinnerCastSearch=(EditText) findViewById(R.id.search_user_caste);
        autoCompleteState=(EditText)findViewById(R.id.search_state);
        autocompletecity=(EditText)findViewById(R.id.search_city);

        advCV=(CardView)findViewById(R.id.advanced_search);
        final CrystalRangeSeekbar rangeSeekbar = (CrystalRangeSeekbar) findViewById(R.id.rangeSeekbar);
// get min and max text view
        final TextView tvMin = (TextView) findViewById(R.id.textMin);
        final TextView tvMax = (TextView) findViewById(R.id.textMax);
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
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addTextState = autoCompleteState.getText().toString();
                if(addTextState.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Please click + button after state selection ",Toast.LENGTH_SHORT).show();
                }
                else {

                    statetextView.setTextSize(TypedValue.COMPLEX_UNIT_SP,18);
                    statetextView.setText(addPrevious+"\n"+addTextState);
                    addPrevious=statetextView.getText().toString();
                    autoCompleteState.setText("");
                    Toast.makeText(getApplicationContext(),"Added successfully ", Toast.LENGTH_SHORT).show();
                }
            }
        });

        searchaddbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addTextcity = autocompletecity.getText().toString();
                if(addTextcity.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Please click + button after city selection ",Toast.LENGTH_SHORT).show();
                }
                else {

                    citytextview.setTextSize(TypedValue.COMPLEX_UNIT_SP,18);
                    citytextview.setText(addPreviousc+"\n"+addTextcity);
                    addPreviousc=citytextview.getText().toString();
                    autocompletecity.setText("");
                    Toast.makeText(getApplicationContext(),"Added successfully ", Toast.LENGTH_SHORT).show();
                }
            }
        });

        colorg = Color.parseColor("#" + "fb6542");
        colorb = Color.parseColor("#" + "000000");
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

                if (intdoctor) {
                    intdoctor = false;
                    tdoctor.setTextColor(colorb);
                    Toast.makeText(getApplicationContext(), "Doctor Removed", Toast.LENGTH_SHORT).show();
                    idoctor.setImageResource(R.drawable.doctor_black);
                } else if (!intdoctor) {
                    intdoctor = true;
                    tdoctor.setTextColor(colorg);
                    Toast.makeText(getApplicationContext(), "Doctor Added", Toast.LENGTH_SHORT).show();
                    idoctor.setImageResource(R.drawable.doctor);
                }
            }
        });
        lengineer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (intengineer) {
                    intengineer = false;
                    tengineer.setTextColor(colorb);
                    Toast.makeText(getApplicationContext(), "Engineer Removed", Toast.LENGTH_SHORT).show();
                    iengineer.setImageResource(R.drawable.engineer_black);
                } else if (!intengineer) {
                    intengineer = true;
                    tengineer.setTextColor(colorg);
                    Toast.makeText(getApplicationContext(), "Engineer Added", Toast.LENGTH_SHORT).show();
                    iengineer.setImageResource(R.drawable.engineer);
                }
            }
        });
        lmbamca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (intmbamca) {
                    intmbamca = false;
                    tmbamca.setTextColor(colorb);
                    Toast.makeText(getApplicationContext(), "MBA/MCA Removed", Toast.LENGTH_SHORT).show();
                    imbamca.setImageResource(R.drawable.mba_black);
                } else if (!intmbamca) {
                    intmbamca = true;
                    tmbamca.setTextColor(colorg);
                    Toast.makeText(getApplicationContext(), "MBA/MCA Added", Toast.LENGTH_SHORT).show();
                    imbamca.setImageResource(R.drawable.mba);
                }
            }
        });
        lcacs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (intcacs) {
                    intcacs = false;
                    tcacs.setTextColor(colorb);
                    Toast.makeText(getApplicationContext(), "CA/CS Removed", Toast.LENGTH_SHORT).show();
                    icacs.setImageResource(R.drawable.ca_black);
                } else if (!intcacs) {
                    intcacs = true;
                    tcacs.setTextColor(colorg);
                    Toast.makeText(getApplicationContext(), "CA/CS Added", Toast.LENGTH_SHORT).show();
                    icacs.setImageResource(R.drawable.ca);
                }
            }
        });
        lpg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (intpg) {
                    intpg = false;
                    tpg.setTextColor(colorb);
                    Toast.makeText(getApplicationContext(), "PostGraduate Removed", Toast.LENGTH_SHORT).show();
                    ipg.setImageResource(R.drawable.mba_black);
                } else if (!intpg) {
                    intpg = true;
                    tpg.setTextColor(colorg);
                    Toast.makeText(getApplicationContext(), "PostGraduate Added", Toast.LENGTH_SHORT).show();
                    ipg.setImageResource(R.drawable.mba);
                }
            }
        });
        lg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (intg) {
                    intg = false;
                    tg.setTextColor(colorb);
                    Toast.makeText(getApplicationContext(), "Graduate Removed", Toast.LENGTH_SHORT).show();
                    ig.setImageResource(R.drawable.grad_black);
                } else if (!intg) {
                    intg = true;
                    tg.setTextColor(colorg);
                    Toast.makeText(getApplicationContext(), "Graduate Added", Toast.LENGTH_SHORT).show();
                    ig.setImageResource(R.drawable.grad);
                }
            }
        });
        lug.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (intug) {
                    intug = false;
                    tug.setTextColor(colorb);
                    Toast.makeText(getApplicationContext(), "UnderGraduate Removed", Toast.LENGTH_SHORT).show();
                    iug.setImageResource(R.drawable.undergrad_black);
                } else if (!intug) {
                    intug = true;
                    Toast.makeText(getApplicationContext(), "UnderGraduate Added", Toast.LENGTH_SHORT).show();
                    tug.setTextColor(colorg);
                    iug.setImageResource(R.drawable.undergrad);
                }
            }
        });
        lllb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (intllb) {
                    intllb = false;
                    tllb.setTextColor(colorb);
                    Toast.makeText(getApplicationContext(), "LLB Removed", Toast.LENGTH_SHORT).show();
                    illb.setImageResource(R.drawable.llb_black);
                } else if (!intllb) {
                    intllb = true;
                    Toast.makeText(getApplicationContext(), "LLB Added", Toast.LENGTH_SHORT).show();
                    tllb.setTextColor(colorg);
                    illb.setImageResource(R.drawable.llb);
                }
            }
        });
        idoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (intdoctor) {
                    intdoctor = false;
                    tdoctor.setTextColor(colorb);
                    Toast.makeText(getApplicationContext(), "Doctor Removed", Toast.LENGTH_SHORT).show();
                    idoctor.setImageResource(R.drawable.doctor_black);
                } else if (!intdoctor) {
                    intdoctor = true;
                    tdoctor.setTextColor(colorg);
                    Toast.makeText(getApplicationContext(), "Doctor Added", Toast.LENGTH_SHORT).show();
                    idoctor.setImageResource(R.drawable.doctor);
                }
            }
        });
        iengineer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (intengineer) {
                    intengineer = false;
                    tengineer.setTextColor(colorb);
                    Toast.makeText(getApplicationContext(), "Engineer Removed", Toast.LENGTH_SHORT).show();
                    iengineer.setImageResource(R.drawable.engineer_black);
                } else if (!intengineer) {
                    intengineer = true;
                    tengineer.setTextColor(colorg);
                    Toast.makeText(getApplicationContext(), "Engineer Added", Toast.LENGTH_SHORT).show();
                    iengineer.setImageResource(R.drawable.engineer);
                }
            }
        });
        imbamca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (intmbamca) {
                    intmbamca = false;
                    tmbamca.setTextColor(colorb);
                    Toast.makeText(getApplicationContext(), "MBA/MCA Removed", Toast.LENGTH_SHORT).show();
                    imbamca.setImageResource(R.drawable.mba_black);
                } else if (!intmbamca) {
                    intmbamca = true;
                    tmbamca.setTextColor(colorg);
                    Toast.makeText(getApplicationContext(), "MBA/MCA Added", Toast.LENGTH_SHORT).show();
                    imbamca.setImageResource(R.drawable.mba);
                }
            }
        });
        icacs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (intcacs) {
                    intcacs = false;
                    tcacs.setTextColor(colorb);
                    Toast.makeText(getApplicationContext(), "CA/CS Removed", Toast.LENGTH_SHORT).show();
                    icacs.setImageResource(R.drawable.ca_black);
                } else if (!intcacs) {
                    intcacs = true;
                    tcacs.setTextColor(colorg);
                    Toast.makeText(getApplicationContext(), "CA/CS Added", Toast.LENGTH_SHORT).show();
                    icacs.setImageResource(R.drawable.ca);
                }
            }
        });
        ipg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (intpg) {
                    intpg = false;
                    tpg.setTextColor(colorb);
                    Toast.makeText(getApplicationContext(), "PostGraduate Removed", Toast.LENGTH_SHORT).show();
                    ipg.setImageResource(R.drawable.mba_black);
                } else if (!intpg) {
                    intpg = true;
                    tpg.setTextColor(colorg);
                    Toast.makeText(getApplicationContext(), "PostGraduate Added", Toast.LENGTH_SHORT).show();
                    ipg.setImageResource(R.drawable.mba);
                }
            }
        });
        ig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (intg) {
                    intg = false;
                    tg.setTextColor(colorb);
                    Toast.makeText(getApplicationContext(), "Graduate Removed", Toast.LENGTH_SHORT).show();
                    ig.setImageResource(R.drawable.grad_black);
                } else if (!intg) {
                    intg = true;
                    tg.setTextColor(colorg);
                    Toast.makeText(getApplicationContext(), "Graduate Added", Toast.LENGTH_SHORT).show();
                    ig.setImageResource(R.drawable.grad);
                }
            }
        });
        iug.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (intug) {
                    intug = false;
                    tug.setTextColor(colorb);
                    Toast.makeText(getApplicationContext(), "UnderGraduate Removed", Toast.LENGTH_SHORT).show();
                    iug.setImageResource(R.drawable.undergrad_black);
                } else if (!intug) {
                    intug = true;
                    Toast.makeText(getApplicationContext(), "UnderGraduate Added", Toast.LENGTH_SHORT).show();
                    tug.setTextColor(colorg);
                    iug.setImageResource(R.drawable.undergrad);
                }
            }
        });
        illb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (intllb) {
                    intllb = false;
                    tllb.setTextColor(colorb);
                    Toast.makeText(getApplicationContext(), "LLB Removed", Toast.LENGTH_SHORT).show();
                    illb.setImageResource(R.drawable.llb_black);
                } else if (!intllb) {
                    intllb = true;
                    Toast.makeText(getApplicationContext(), "LLB Added", Toast.LENGTH_SHORT).show();
                    tllb.setTextColor(colorg);
                    illb.setImageResource(R.drawable.llb);
                }
            }
        });

        mOpenIDSearchButton = (Button) findViewById(R.id.search_by_id_name_open);
        mOpenIDSearchButton.setFocusable(true);
        spinnerCastSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                casebreak=1;
                BottomSheetDialogFragment btm= new BottomSheet(0);
                btm.show(getSupportFragmentManager(),btm.getTag());

            }
        });

        mOpenIDSearchButton = (Button) findViewById(R.id.search_by_id_name_open);
        mOpenIDSearchButton.setFocusable(true);
        mOpenIDSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                casebreak=2;
                //  Toast.makeText(getApplicationContext(),Integer.toString(getCasebreak())+" does this worked or not", Toast.LENGTH_LONG).show();
                BottomSheetDialogFragment bottomSheetDialogFragment = new BottomSheet(0);
                bottomSheetDialogFragment.show(getSupportFragmentManager(), bottomSheetDialogFragment.getTag());

            }
        });
        FloatingActionButton search=(FloatingActionButton)findViewById(R.id.search_Submit);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(dataChecker())
                {

                }
                else{
                    Toast.makeText(getApplicationContext(),"Please fill all search details correct",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public int getCasebreak()
    {
        return this.casebreak;
    }
    boolean dataChecker()
    {
        return false;
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
