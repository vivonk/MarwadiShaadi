package com.example.sid.marwadishaadi;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class Membership extends AppCompatActivity {
    RadioButton radio1, radio2, radio3, radio4, radio5, radio6, radio7, radio8, radio9, radio10, radio11, radio12, radio13, radio14, radio15, radio16, radio17, radio18;
    RadioGroup gr1, gr2, gr3, gr4, gr5, gr6;
    static int c = 0, c1 = 0, c2 = 0, c3 = 0, c4 = 0, c5 = 0, c6 = 0;
    String str;
    Button dash;
    TextView amount;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_membership);

        dash = (Button) findViewById(R.id.dash);

        amount = (TextView) findViewById(R.id.amount);
        gr1 = (RadioGroup) findViewById(R.id.gr1);
        gr2 = (RadioGroup) findViewById(R.id.gr2);
        gr3 = (RadioGroup) findViewById(R.id.gr3);
        gr4 = (RadioGroup) findViewById(R.id.gr4);
        gr5 = (RadioGroup) findViewById(R.id.gr5);
        gr6 = (RadioGroup) findViewById(R.id.gr6);

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
                Intent i = new Intent(Membership.this,Dashboard.class);
                startActivity(i);
            }
        });

        gr1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                if (i == R.id.radio1) {
                    c1 = 1000;
                }
                if (i == R.id.radio2) {
                    c1 = 2000;
                }
                if (i == R.id.radio3) {
                    c1 = 2500;
                }
                c = c1 + c2 + c3 + c4 + c5 + c6;
                amount.setText(String.valueOf(c));
            }
        });


        gr2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                if (i == R.id.radio4) {
                    c2 = 1000;
                }
                if (i == R.id.radio5) {
                    c2 = 2000;
                }
                if (i == R.id.radio6) {
                    c2 = 2500;
                }
                c = c1 + c2 + c3 + c4 + c5 + c6;
                amount.setText(String.valueOf(c));
            }
        });
        gr3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                if (i == R.id.radio7) {
                    c3 = 1000;
                }
                if (i == R.id.radio8) {
                    c3 = 2000;
                }
                if (i == R.id.radio9) {
                    c3 = 2500;
                }
                c = c1 + c2 + c3 + c4 + c5 + c6;
                amount.setText(String.valueOf(c));
            }
        });

        gr4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                if (i == R.id.radio10) {
                    c4 = 1000;
                }
                if (i == R.id.radio11) {
                    c4 = 2000;
                }
                if (i == R.id.radio12) {
                    c4 = 2500;
                }
                c = c1 + c2 + c3 + c4 + c5 + c6;
                amount.setText(String.valueOf(c));
            }
        });


        gr5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                if (i == R.id.radio13) {
                    c5 = 1000;
                }
                if (i == R.id.radio14) {
                    c5 = 2000;
                }
                if (i == R.id.radio15) {
                    c5 = 2500;
                }
                c = c1 + c2 + c3 + c4 + c5 + c6;
                amount.setText(String.valueOf(c));
            }
        });

        gr6.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                if (i == R.id.radio16) {
                    c6 = 1000;
                }
                if (i == R.id.radio17) {
                    c6 = 2000;
                }
                if (i == R.id.radio18) {
                    c6 = 2500;
                }
                c = c1 + c2 + c3 + c4 + c5 + c6;
                amount.setText(String.valueOf(c));
            }
        });

    }

}
