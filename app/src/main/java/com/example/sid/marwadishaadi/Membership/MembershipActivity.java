package com.example.sid.marwadishaadi.Membership;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sid.marwadishaadi.Dashboard.DashboardActivity;
import com.example.sid.marwadishaadi.R;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;


public class MembershipActivity extends AppCompatActivity {

    RadioButton radio1, radio2, radio3, radio4, radio5, radio6, radio7, radio8, radio9, radio10, radio11, radio12, radio13, radio14, radio15, radio16, radio17, radio18;
    RadioGroup gr1, gr2, gr3, gr4, gr5, gr6;
    static int c = 0, c1 = 0, c2 = 0, c3 = 0, c4 = 0, c5 = 0, c6 = 0;
    int id;
    Button skip,coupon;
    TextView dash,clear1,clear2,clear3,clear4,clear5,clear6;
    TextView amount;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_membership);

        Toolbar toolbar = (Toolbar) findViewById(R.id.membership_toolbar);
        toolbar.setTitle("MembershipActivity");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        skip = (Button)findViewById(R.id.skip);
        coupon = (Button)findViewById(R.id.coupon);

        c = 0; c1 = 0; c2 = 0; c3 = 0; c4 = 0; c5 = 0; c6 = 0;
        dash = (TextView) findViewById(R.id.dash);

        amount = (TextView) findViewById(R.id.amount);
        gr1 = (RadioGroup) findViewById(R.id.gr1);
        gr2 = (RadioGroup) findViewById(R.id.gr2);
        gr3 = (RadioGroup) findViewById(R.id.gr3);
        gr4 = (RadioGroup) findViewById(R.id.gr4);
        gr5 = (RadioGroup) findViewById(R.id.gr5);
        gr6 = (RadioGroup) findViewById(R.id.gr6);


        clear1 = (TextView) findViewById(R.id.g1reset);
        clear2 = (TextView) findViewById(R.id.g2reset);
        clear3 = (TextView) findViewById(R.id.g3reset);
        clear4 = (TextView) findViewById(R.id.g4reset);
        clear5 = (TextView) findViewById(R.id.g5reset);
        clear6 = (TextView) findViewById(R.id.g6reset);

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MembershipActivity.this,DashboardActivity.class);
                startActivity(i);
            }
        });

        coupon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                View reset_view = getLayoutInflater().inflate(R.layout.coupon_dialog, null);
                AlertDialog.Builder reset = new AlertDialog.Builder(MembershipActivity.this);
                reset.setView(reset_view);

                final EditText code = (EditText) reset_view.findViewById(R.id.code);

                Button redeem = (Button) reset_view.findViewById(R.id.redeem);

                redeem.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String user_code = code.getText().toString();


                        Toast.makeText(MembershipActivity.this, "yayay", Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog resetbox = reset.create();
                resetbox.show();
            }

        });

                clear1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        gr1.clearCheck();
                        c = c2 + c3 + c4 + c5;
                        c1 = 0;
                        amount.setText(String.valueOf(c));

                    }
                });

                clear2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        gr2.clearCheck();
                        c = c1 + c3 + c4 + c5;
                        c2 = 0;
                        amount.setText(String.valueOf(c));
                    }
                });

                clear3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        gr3.clearCheck();
                        c = c2 + c1 + c4 + c5;
                        c3 = 0;
                        amount.setText(String.valueOf(c));
                    }
                });

                clear4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        gr4.clearCheck();
                        c = c2 + c3 + c1 + c5;
                        c4 = 0;
                        amount.setText(String.valueOf(c));
                    }
                });

                clear5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        gr5.clearCheck();
                        c = c2 + c3 + c4 + c1;
                        c5 = 0;
                        amount.setText(String.valueOf(c));
                    }
                });

                clear6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        gr6.clearCheck();
                        c = c6 = 0;
                        amount.setText(String.valueOf(c));
                    }
                });

                radio1 = (RadioButton) findViewById(R.id.radio1);
                radio2 = (RadioButton) findViewById(R.id.radio2);
                radio3 = (RadioButton) findViewById(R.id.radio3);
                radio4 = (RadioButton) findViewById(R.id.radio4);
                radio5 = (RadioButton) findViewById(R.id.radio5);
                radio6 = (RadioButton) findViewById(R.id.radio6);
                radio7 = (RadioButton) findViewById(R.id.radio7);

                radio8 = (RadioButton) findViewById(R.id.radio8);
                radio9 = (RadioButton) findViewById(R.id.radio9);
                radio10 = (RadioButton) findViewById(R.id.radio10);
                radio11 = (RadioButton) findViewById(R.id.radio11);
                radio12 = (RadioButton) findViewById(R.id.radio12);
                radio13 = (RadioButton) findViewById(R.id.radio13);
                radio14 = (RadioButton) findViewById(R.id.radio14);
                radio15 = (RadioButton) findViewById(R.id.radio15);
                radio16 = (RadioButton) findViewById(R.id.radio16);
                radio17 = (RadioButton) findViewById(R.id.radio17);
                radio18 = (RadioButton) findViewById(R.id.radio18);

                dash.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(gr1.getCheckedRadioButtonId() == -1 && gr2.getCheckedRadioButtonId() == -1 && gr3.getCheckedRadioButtonId() == -1 && gr4.getCheckedRadioButtonId() == -1 && gr5.getCheckedRadioButtonId() == -1 && gr6.getCheckedRadioButtonId() == -1)
                        {
                            Toast.makeText(getApplicationContext(),"Please select atleast one MembershipActivity or press Skip",Toast.LENGTH_LONG).show();
                        }
                       else{
                        Intent i = new Intent(MembershipActivity.this, DashboardActivity.class);
                        startActivity(i);}
                    }
                });

                radio1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        gr6.clearCheck();
                        c1 = 1000;
                        c = c1 + c2 + c3 + c4 + c5;
                        amount.setText(String.valueOf(c));
                    }
                });

                radio2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        gr6.clearCheck();
                        c1 = 2000;
                        c = c1 + c2 + c3 + c4 + c5;
                        amount.setText(String.valueOf(c));
                    }
                });

                radio3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        gr6.clearCheck();
                        c1 = 2500;
                        c = c1 + c2 + c3 + c4 + c5;
                        amount.setText(String.valueOf(c));
                    }
                });

                radio4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        gr6.clearCheck();

                        c2 = 1000;
                        c = c1 + c2 + c3 + c4 + c5;
                        amount.setText(String.valueOf(c));
                    }
                });

                radio5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        gr6.clearCheck();

                        c2 = 2000;
                        c = c1 + c2 + c3 + c4 + c5;
                        amount.setText(String.valueOf(c));
                    }
                });

                radio6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        gr6.clearCheck();
                        c2 = 2500;
                        c = c1 + c2 + c3 + c4 + c5;
                        amount.setText(String.valueOf(c));
                    }
                });


                radio7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        gr6.clearCheck();

                        c3 = 1000;
                        c = c1 + c2 + c3 + c4 + c5;
                        amount.setText(String.valueOf(c));
                    }
                });

                radio8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        gr6.clearCheck();

                        c3 = 2000;
                        c = c1 + c2 + c3 + c4 + c5;
                        amount.setText(String.valueOf(c));
                    }
                });


                radio9.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        gr6.clearCheck();


                        c3 = 2500;
                        c = c1 + c2 + c3 + c4 + c5;
                        amount.setText(String.valueOf(c));
                    }
                });

                radio10.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        gr6.clearCheck();

                        c4 = 1000;
                        c = c1 + c2 + c3 + c4 + c5;
                        amount.setText(String.valueOf(c));
                    }
                });
                radio11.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        gr6.clearCheck();
                        c4 = 2000;
                        c = c1 + c2 + c3 + c4 + c5;
                        amount.setText(String.valueOf(c));

                    }
                });
                radio12.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        gr6.clearCheck();

                        c4 = 2500;
                        c = c1 + c2 + c3 + c4 + c5;
                        amount.setText(String.valueOf(c));
                    }
                });

                radio13.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        gr6.clearCheck();

                        c5 = 1000;
                        c = c1 + c2 + c3 + c4 + c5;
                        amount.setText(String.valueOf(c));
                    }
                });
                radio14.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        gr6.clearCheck();

                        c5 = 2000;
                        c = c1 + c2 + c3 + c4 + c5;
                        amount.setText(String.valueOf(c));
                    }
                });
                radio15.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        gr6.clearCheck();

                        c5 = 2500;
                        c = c1 + c2 + c3 + c4 + c5;
                        amount.setText(String.valueOf(c));
                    }
                });
                radio16.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        gr1.clearCheck();
                        gr2.clearCheck();
                        gr3.clearCheck();
                        gr4.clearCheck();
                        gr5.clearCheck();
                        c1 = c2 = c3 = c4 = c5 = 0;
                        c6 = 5000;
                        amount.setText(String.valueOf(c6));
                    }
                });
                radio17.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        gr1.clearCheck();
                        gr2.clearCheck();
                        gr3.clearCheck();
                        gr4.clearCheck();
                        gr5.clearCheck();
                        c1 = c2 = c3 = c4 = c5 = 0;
                        c6 = 10000;
                        amount.setText(String.valueOf(c6));
                    }
                });
                radio18.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        gr1.clearCheck();
                        gr2.clearCheck();
                        gr3.clearCheck();
                        gr4.clearCheck();
                        gr5.clearCheck();
                        c1 = c2 = c3 = c4 = c5 = 0;
                        c6 = 12500;
                        amount.setText(String.valueOf(c6));
                    }
                });

            }


            @Override
            public boolean onSupportNavigateUp() {
                finish();
                return true;
            }
        }
