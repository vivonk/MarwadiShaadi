package com.example.sid.marwadishaadi.Search;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.AsyncTask;
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
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.crystal.crystalrangeseekbar.interfaces.OnRangeSeekbarChangeListener;
import com.crystal.crystalrangeseekbar.interfaces.OnRangeSeekbarFinalValueListener;
import com.crystal.crystalrangeseekbar.widgets.CrystalRangeSeekbar;
import com.example.sid.marwadishaadi.Dashboard_Suggestions.SuggestionModel;
import com.example.sid.marwadishaadi.Login;
import com.example.sid.marwadishaadi.R;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

import static com.bumptech.glide.gifdecoder.GifHeaderParser.TAG;

public class Search extends AppCompatActivity {
    ImageView idoctor, iengineer, imbamca, icacs, ipg, ig, iug, illb;
    boolean intdoctor = false, intengineer = false, intmbamca = false, intcacs = false, intpg = false, intg = false, intug = false, intllb = false;
    TextView tdoctor, tengineer, tmbamca, tcacs, tpg, tg, tug, tllb;
    LinearLayout ldoctor, lengineer, lmbamca, lcacs, lpg, lg, lug, lllb;
    int colorg, colorb;
    Button mOpenIDSearchButton;
    private static int casebreak;
    TextView statetextView,citytextview;
    CardView advCV;
    Button addButton,searchaddbutton;
    EditText autoCompleteState,autocompletecity;
    static String  addTextState,addPrevious="";
    static String  addTextcity,addPreviousc="";
    public static  EditText maritalstatus;
    public static EditText familystatus;
    public static EditText annualincome;
    public static EditText physicalstatus;
    public static  EditText spinnerCastSearch;
    public static List<SuggestionModel> suggestionModelList;



    boolean int_very_fair, int_fair, int_wheatish, int_wheatish_brown, int_dark, int_doesnt_matter=true,int_profession,int_job,int_retired,int_business,int_not_employed,int_studying,int_dont_matter=true,intSlim,intAthletic,intHeavy,intAverage,intDoesntMatter=true;
    CheckBox very_fair,fair,wheatish,wheatish_brown,dark,doesnt_matter,profession,job,retired,business,not_employed,studying,dont_matter,slim,athletic,average,heavy,doesntMatter;
   public static List<String> complexion= new ArrayList<>();
    public static List<String> occupation=new ArrayList<>();
   public static List<String> education=new ArrayList<>();
   public static List<String> bodyType=new ArrayList<>();

    public Search()
    {

    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        suggestionModelList=new ArrayList<>();
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
        occupation.add("Doesn't Matter");
        bodyType.add("Doesn't Matter");
        complexion.add("Doesn't Matter");
        education.add("Doesn't Matter");

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
                    education.remove(tdoctor.getText().toString());

                    Toast.makeText(getApplicationContext(), "Doctor Removed", Toast.LENGTH_SHORT).show();
                    idoctor.setImageResource(R.drawable.doctor_black);
                } else if (!intdoctor) {
                    intdoctor = true;
                    tdoctor.setTextColor(colorg);
                    education.add(tdoctor.getText().toString());
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
                    education.remove(tengineer.getText().toString());

                    Toast.makeText(getApplicationContext(), "Engineer Removed", Toast.LENGTH_SHORT).show();
                    iengineer.setImageResource(R.drawable.engineer_black);
                } else if (!intengineer) {
                    intengineer = true;
                    tengineer.setTextColor(colorg);
                    education.add(tengineer.getText().toString());

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
                    education.remove(tmbamca.getText().toString());

                    Toast.makeText(getApplicationContext(), "MBA/MCA Removed", Toast.LENGTH_SHORT).show();
                    imbamca.setImageResource(R.drawable.mba_black);
                } else if (!intmbamca) {
                    intmbamca = true;
                    tmbamca.setTextColor(colorg);
                    education.add(tmbamca.getText().toString());

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
                    education.remove(tcacs.getText().toString());

                    Toast.makeText(getApplicationContext(), "CA/CS Removed", Toast.LENGTH_SHORT).show();
                    icacs.setImageResource(R.drawable.ca_black);
                } else if (!intcacs) {
                    intcacs = true;
                    tcacs.setTextColor(colorg);
                    education.add(tcacs.getText().toString());

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
                    education.remove(tpg.getText().toString());

                    Toast.makeText(getApplicationContext(), "PostGraduate Removed", Toast.LENGTH_SHORT).show();
                    ipg.setImageResource(R.drawable.mba_black);
                } else if (!intpg) {
                    intpg = true;
                    tpg.setTextColor(colorg);
                    education.add(tpg.getText().toString());

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
                    education.remove(tg.getText().toString());

                    Toast.makeText(getApplicationContext(), "Graduate Removed", Toast.LENGTH_SHORT).show();
                    ig.setImageResource(R.drawable.grad_black);
                } else if (!intg) {
                    intg = true;
                    tg.setTextColor(colorg);
                    education.add(tg.getText().toString());

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
                    education.remove(tug.getText().toString());

                    Toast.makeText(getApplicationContext(), "UnderGraduate Removed", Toast.LENGTH_SHORT).show();
                    iug.setImageResource(R.drawable.undergrad_black);
                } else if (!intug) {
                    intug = true;
                    education.add(tug.getText().toString());

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
                    education.remove(tllb.getText().toString());

                    Toast.makeText(getApplicationContext(), "LLB Removed", Toast.LENGTH_SHORT).show();
                    illb.setImageResource(R.drawable.llb_black);
                } else if (!intllb) {
                    intllb = true;
                    education.add(tllb.getText().toString());

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
                    education.remove(tdoctor.getText().toString());

                    Toast.makeText(getApplicationContext(), "Doctor Removed", Toast.LENGTH_SHORT).show();
                    idoctor.setImageResource(R.drawable.doctor_black);
                } else if (!intdoctor) {
                    intdoctor = true;
                    tdoctor.setTextColor(colorg);
                    education.add(tdoctor.getText().toString());

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
                    education.remove(tengineer.getText().toString());

                    Toast.makeText(getApplicationContext(), "Engineer Removed", Toast.LENGTH_SHORT).show();
                    iengineer.setImageResource(R.drawable.engineer_black);
                } else if (!intengineer) {
                    intengineer = true;
                    tengineer.setTextColor(colorg);
                    education.add(tengineer.getText().toString());

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
                    education.remove(tmbamca.getText().toString());

                    Toast.makeText(getApplicationContext(), "MBA/MCA Removed", Toast.LENGTH_SHORT).show();
                    imbamca.setImageResource(R.drawable.mba_black);
                } else if (!intmbamca) {
                    intmbamca = true;
                    tmbamca.setTextColor(colorg);
                    education.add(tmbamca.getText().toString());

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
                    education.remove(tcacs.getText().toString());

                    Toast.makeText(getApplicationContext(), "CA/CS Removed", Toast.LENGTH_SHORT).show();
                    icacs.setImageResource(R.drawable.ca_black);
                } else if (!intcacs) {
                    intcacs = true;
                    tcacs.setTextColor(colorg);
                    education.add(tcacs.getText().toString());

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
                    education.remove(tpg.getText().toString());

                    Toast.makeText(getApplicationContext(), "PostGraduate Removed", Toast.LENGTH_SHORT).show();
                    ipg.setImageResource(R.drawable.mba_black);
                } else if (!intpg) {
                    intpg = true;
                    tpg.setTextColor(colorg);
                    education.add(tpg.getText().toString());

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
                    education.remove(tg.getText().toString());

                    Toast.makeText(getApplicationContext(), "Graduate Removed", Toast.LENGTH_SHORT).show();
                    ig.setImageResource(R.drawable.grad_black);
                } else if (!intg) {
                    intg = true;
                    tg.setTextColor(colorg);
                    education.add(tg.getText().toString());

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
                    education.remove(tug.getText().toString());

                    Toast.makeText(getApplicationContext(), "UnderGraduate Removed", Toast.LENGTH_SHORT).show();
                    iug.setImageResource(R.drawable.undergrad_black);
                } else if (!intug) {
                    intug = true;
                    education.add(tug.getText().toString());

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
                    education.remove(tllb.getText().toString());

                    Toast.makeText(getApplicationContext(), "LLB Removed", Toast.LENGTH_SHORT).show();
                    illb.setImageResource(R.drawable.llb_black);
                } else if (!intllb) {
                    intllb = true;
                    education.add(tllb.getText().toString());

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
//                 new BackEnd().execute("","","","","","","","","");
//                Intent i=new Intent(Search.this,SearchResultsActivity.class);
//                i.putStringArrayListExtra("value",);
                Toast.makeText(getApplicationContext(),"Education are :------" + education.toString(),Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(),"Complexion are :------" + complexion.toString(),Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(),"Body Type are :------" + bodyType.toString(),Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(),"Occupation are :------" + occupation.toString(),Toast.LENGTH_SHORT).show();
              /*  Toast.makeText(getApplicationContext(),"Education are :------" + education.toString(),Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(),"Education are :------" + education.toString(),Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(),"Education are :------" + education.toString(),Toast.LENGTH_SHORT).show();
*/
            }
        });



        very_fair = (CheckBox) findViewById(R.id.search_check_very_fair);
        fair = (CheckBox) findViewById(R.id.search_check_fair);
        wheatish = (CheckBox) findViewById(R.id.search_check_wheatish);
        wheatish_brown = (CheckBox) findViewById(R.id.search_check_wheatish_brown);
        dark = (CheckBox) findViewById(R.id.search_check_dark);
        doesnt_matter = (CheckBox) findViewById(R.id.complexion_doesnt_matter);

        profession=(CheckBox)findViewById(R.id.check_profession);
        job=(CheckBox)findViewById(R.id.check_job);
        retired=(CheckBox)findViewById(R.id.check_retired);
        business=(CheckBox)findViewById(R.id.check_business);
        studying=(CheckBox)findViewById(R.id.check_studying_not_employed);
        not_employed=(CheckBox)findViewById(R.id.check_not_employed);
        dont_matter=(CheckBox)findViewById(R.id.occupation_doesnt_matter);

        slim=(CheckBox)findViewById(R.id.search_check_slim);
        athletic=(CheckBox)findViewById(R.id.search_check_athletic);
        heavy=(CheckBox)findViewById(R.id.search_check_heavy);
        average=(CheckBox)findViewById(R.id.search_check_average);
        doesntMatter=(CheckBox)findViewById(R.id.bodytype_doesnt_matter);

        very_fair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (int_very_fair) {
                    int_very_fair = false;
                    complexion.remove(very_fair.getText().toString());
                    Toast.makeText(getApplicationContext(), "Removed", Toast.LENGTH_SHORT).show();

                } else if (!int_very_fair) {
                    int_very_fair = true;
                    complexion.add(very_fair.getText().toString());
                    Toast.makeText(getApplicationContext(), "Added", Toast.LENGTH_SHORT).show();

                }
            }
        });
        fair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (int_fair) {
                    int_fair = false;
                    complexion.remove(fair.getText().toString());
                    Toast.makeText(getApplicationContext(), "Removed", Toast.LENGTH_SHORT).show();

                } else if (!int_fair) {
                    int_fair = true;
                    complexion.add(fair.getText().toString());
                    Toast.makeText(getApplicationContext(), "Added", Toast.LENGTH_SHORT).show();

                }
            }
        });
        wheatish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (int_wheatish) {
                    int_wheatish = false;
                    complexion.remove(wheatish.getText().toString());
                    Toast.makeText(getApplicationContext(), "Removed", Toast.LENGTH_SHORT).show();

                } else if (!int_wheatish) {
                    int_wheatish = true;
                    complexion.add(wheatish.getText().toString());
                    Toast.makeText(getApplicationContext(), "Added", Toast.LENGTH_SHORT).show();

                }
            }
        });
        wheatish_brown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (int_wheatish_brown) {
                    int_wheatish_brown = false;
                    complexion.remove(wheatish_brown.getText().toString());
                    Toast.makeText(getApplicationContext(), "Removed", Toast.LENGTH_SHORT).show();

                } else if (!int_wheatish_brown) {
                    int_wheatish_brown = true;
                    complexion.add(wheatish_brown.getText().toString());
                    Toast.makeText(getApplicationContext(), "Added", Toast.LENGTH_SHORT).show();

                }
            }
        });
        very_fair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (int_very_fair) {
                    int_very_fair = false;
                    complexion.remove(very_fair.getText().toString());
                    Toast.makeText(getApplicationContext(), "Removed", Toast.LENGTH_SHORT).show();

                } else if (!int_very_fair) {
                    int_very_fair = true;
                    complexion.add(very_fair.getText().toString());
                    Toast.makeText(getApplicationContext(), "Added", Toast.LENGTH_SHORT).show();

                }
            }
        });
        dark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (int_dark) {
                    int_dark = false;
                    complexion.remove(dark.getText().toString());
                    Toast.makeText(getApplicationContext(), "Removed", Toast.LENGTH_SHORT).show();

                } else if (!int_dark) {
                    int_dark = true;
                    complexion.add(dark.getText().toString());
                    Toast.makeText(getApplicationContext(), "Added", Toast.LENGTH_SHORT).show();

                }
            }
        });
        doesnt_matter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (int_doesnt_matter) {
                    int_doesnt_matter = false;

                    complexion.remove(doesnt_matter.getText().toString());
                    Toast.makeText(getApplicationContext(), "Removed", Toast.LENGTH_SHORT).show();

                } else if (!int_doesnt_matter) {
                    int_doesnt_matter = true;
                    complexion.add(doesnt_matter.getText().toString());
                    Toast.makeText(getApplicationContext(), "Added", Toast.LENGTH_SHORT).show();

                }
            }
        });


        profession.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (int_profession) {
                    int_profession= false;
                    occupation.remove(profession.getText().toString());
                    Toast.makeText(getApplicationContext(), "Removed", Toast.LENGTH_SHORT).show();

                } else if (!int_profession) {
                    int_profession = true;
                    occupation.add(profession.getText().toString());
                    Toast.makeText(getApplicationContext(), "Added", Toast.LENGTH_SHORT).show();

                }
            }
        });
        job.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (int_job) {
                    int_job= false;
                    occupation.remove(job.getText().toString());
                    Toast.makeText(getApplicationContext(), "Removed", Toast.LENGTH_SHORT).show();

                } else if (!int_job) {
                    int_job = true;
                    occupation.add(job.getText().toString());
                    Toast.makeText(getApplicationContext(), "Added", Toast.LENGTH_SHORT).show();

                }
            }
        });
        retired.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (int_retired) {
                    int_retired= false;
                    occupation.remove(retired.getText().toString());
                    Toast.makeText(getApplicationContext(), "Removed", Toast.LENGTH_SHORT).show();

                } else if (!int_retired) {
                    int_retired = true;
                    occupation.add(retired.getText().toString());
                    Toast.makeText(getApplicationContext(), "Added", Toast.LENGTH_SHORT).show();

                }
            }
        });
        business.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (int_business) {
                    int_business= false;
                    occupation.remove(business.getText().toString());
                    Toast.makeText(getApplicationContext(), "Removed", Toast.LENGTH_SHORT).show();

                } else if (!int_business) {
                    int_business = true;
                    occupation.add(business.getText().toString());
                    Toast.makeText(getApplicationContext(), "Added", Toast.LENGTH_SHORT).show();

                }
            }
        });
        not_employed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (int_not_employed) {
                    int_not_employed= false;
                    occupation.remove(not_employed.getText().toString());
                    Toast.makeText(getApplicationContext(), "Removed", Toast.LENGTH_SHORT).show();

                } else if (!int_not_employed) {
                    int_not_employed = true;
                    occupation.add(not_employed.getText().toString());
                    Toast.makeText(getApplicationContext(), "Added", Toast.LENGTH_SHORT).show();
                }
            }
        });
        studying.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (int_studying) {
                    int_studying= false;
                    occupation.remove(studying.getText().toString());
                    Toast.makeText(getApplicationContext(), "Removed", Toast.LENGTH_SHORT).show();

                } else if (!int_studying) {
                    int_studying = true;
                    occupation.add(studying.getText().toString());
                    Toast.makeText(getApplicationContext(), "Added", Toast.LENGTH_SHORT).show();

                }
            }
        });
        dont_matter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (int_dont_matter) {
                    int_dont_matter= false;
                    occupation.remove(dont_matter.getText().toString());
                    Toast.makeText(getApplicationContext(), "Added", Toast.LENGTH_SHORT).show();

                } else if (!int_dont_matter) {
                    int_dont_matter = true;
                    occupation.add(dont_matter.getText().toString());
                    Toast.makeText(getApplicationContext(), "Removed", Toast.LENGTH_SHORT).show();

                }
            }
        });


        slim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (intSlim) {
                    intSlim= false;
                    bodyType.remove(slim.getText().toString());
                    Toast.makeText(getApplicationContext(), "Removed", Toast.LENGTH_SHORT).show();

                } else if (!intSlim) {
                    intSlim = true;
                    bodyType.add(slim.getText().toString());
                    Toast.makeText(getApplicationContext(), "Added", Toast.LENGTH_SHORT).show();

                }
            }
        });
        athletic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (intAthletic) {
                    intAthletic= false;
                    bodyType.remove(athletic.getText().toString());
                    Toast.makeText(getApplicationContext(), "Removed", Toast.LENGTH_SHORT).show();

                } else if (!intAthletic) {
                    intAthletic = true;
                    bodyType.add(athletic.getText().toString());
                    Toast.makeText(getApplicationContext(), "Added", Toast.LENGTH_SHORT).show();

                }
            }
        });
        average.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (intAverage) {
                    intAverage= false;
                    bodyType.remove(average.getText().toString());
                    Toast.makeText(getApplicationContext(), "Removed", Toast.LENGTH_SHORT).show();

                } else if (!intAverage) {
                    intAverage = true;
                    bodyType.add(average.getText().toString());
                    Toast.makeText(getApplicationContext(), "Added", Toast.LENGTH_SHORT).show();

                }
            }
        });
        heavy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (intHeavy) {
                    intHeavy= false;
                    bodyType.remove(heavy.getText().toString());
                    Toast.makeText(getApplicationContext(), "Removed", Toast.LENGTH_SHORT).show();

                } else if (!intHeavy) {
                    intHeavy = true;
                    bodyType.add(heavy.getText().toString());
                    Toast.makeText(getApplicationContext(), "Added", Toast.LENGTH_SHORT).show();

                }
            }
        });
        doesntMatter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (intDoesntMatter) {
                    intDoesntMatter= false;
                    bodyType.remove(doesntMatter.getText().toString());
                    Toast.makeText(getApplicationContext(), "Removed", Toast.LENGTH_SHORT).show();

                } else if (!intDoesntMatter) {
                    intDoesntMatter = true;
                    bodyType.add(doesntMatter.getText().toString());
                    Toast.makeText(getApplicationContext(), "Added", Toast.LENGTH_SHORT).show();

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
class BackEnd extends AsyncTask<String,String,String>
{

    @Override
    protected String doInBackground(String... strings) {
        AndroidNetworking.post("http://192.168.221.50:5050/checkLogin")
                .addBodyParameter("email",strings[1])
                .addBodyParameter("password", strings[2])
                .setPriority(Priority.HIGH)
                .build()
                .getAsJSONArray(new JSONArrayRequestListener() {

                    @Override
                    public void onResponse(JSONArray response) {


                    }

                    @Override
                    public void onError(ANError error) {

                    }
                });

        return null;
    }
}
