package com.example.sid.marwadishaadi;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.crystal.crystalrangeseekbar.interfaces.OnRangeSeekbarChangeListener;
import com.crystal.crystalrangeseekbar.interfaces.OnRangeSeekbarFinalValueListener;
import com.crystal.crystalrangeseekbar.widgets.CrystalRangeSeekbar;
import com.example.sid.marwadishaadi.Otp_Verification.Otp_Verification;
import com.example.sid.marwadishaadi.Search.BottomSheet;

import static com.facebook.FacebookSdk.getApplicationContext;

public class filter extends AppCompatActivity {


    ImageView idoctor, iengineer, imbamca, icacs, ipg, ig, iug, illb;
    boolean intdoctor = false, intengineer = false, intmbamca = false, intcacs = false, intpg = false, intg = false, intug = false, intllb = false;
    TextView tdoctor, tengineer, tmbamca, tcacs, tpg, tg, tug, tllb;
    LinearLayout ldoctor, lengineer, lmbamca, lcacs, lpg, lg, lug, lllb;
    int colorg, colorb;
    static String  addTextState,addPrevious="";
    Button complete,addButton;
    TextView statetextView;
    EditText autoCompleteState;
    private EditText annualincome;

    public static int getCasebreak() {
        return casebreak;
    }

    public static void setCasebreak(int casebreak) {
        filter.casebreak = casebreak;
    }
    public filter()
    {

    }
    private static int casebreak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);

        Toolbar toolbar = (Toolbar) findViewById(R.id.filter_toolbar);
        toolbar.setTitle("Filter");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        statetextView=(TextView)findViewById(R.id.text_view_search_add_state);
        complete = (Button) findViewById(R.id.filter_submit);

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

        autoCompleteState=(EditText)findViewById(R.id.filter_by_location);
        addButton=(Button)findViewById(R.id.search_add_state);
        final TextView statetextView=(TextView)findViewById(R.id.text_view_search_add_state);
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
        annualincome = (EditText) findViewById(R.id.search_Annual_income);
        annualincome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                casebreak=5;
                BottomSheetDialogFragment btm= new BottomSheet(4);
                btm.show(getSupportFragmentManager(),btm.getTag());
            }
        });

        // TODO: 13-06-2017 implement filter logic below 
        complete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(filter.this,Dashboard.class);
                startActivity(i);
            }
        });

        // get seekbar from view

        final CrystalRangeSeekbar rangeSeekbar = (CrystalRangeSeekbar)findViewById(R.id.rangeSeekbar);
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
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
