package com.example.ali_ahmed.calc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btn_one;
    private Button btn_tow;
    private Button btn_three;
    private Button btn_four;
    private Button btn_five;
    private Button btn_six;
    private Button btn_seven;
    private Button btn_eight;
    private Button btn_nine;
    private Button btn_zero;
    private Button btn_duobleZero;
    private Button btn_dot;
    private Button btn_clear;
    private Button btn_percentage;
    private Button btn_divid;
    private Button btn_multiply;
    private Button btn_minus;
    private Button btn_add;
    private Button btn_equal;
    private TextView result;
    private TextView info;
    private final char ADDITION='+';
    private final char SUBSTRUCTION='-';
    private final char MULTIPCATION='*';
    private final char DIVISION='/';
    private final char PERCENTAGE='%';
    private final char EQU = 0;
    private double val1 = Double.NaN;
    private double val2;
    private char ACTION;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupUIviews();
        btn_zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                info.setText(info.getText().toString()+"0");
            }
        });

        btn_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                info.setText(info.getText().toString()+"1");
            }
        });

        btn_tow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                info.setText(info.getText().toString()+"2");
            }
        });

        btn_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                info.setText(info.getText().toString()+"3");
            }
        });

        btn_four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                info.setText(info.getText().toString()+"4");
            }
        });

        btn_five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                info.setText(info.getText().toString()+"5");
            }
        });

        btn_six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                info.setText(info.getText().toString()+"6");
            }
        });

        btn_seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                info.setText(info.getText().toString()+"7");
            }
        });

        btn_eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                info.setText(info.getText().toString()+"8");
            }
        });

        btn_nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                info.setText(info.getText().toString()+"9");
            }
        });

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(String.valueOf(val1) + "+");
                compute();
                ACTION = ADDITION;
                result.setText(String.valueOf(val1) + "+");
                info.setText(null);
            }
        });

        btn_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                ACTION = SUBSTRUCTION;
                result.setText(String.valueOf(val1) + "-");
                info.setText(null);
            }
        });

        btn_multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                ACTION = MULTIPCATION;
                result.setText(String.valueOf(val1) + "x");
                info.setText(null);
            }
        });

        btn_divid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                ACTION = DIVISION;
                result.setText(String.valueOf(val1) + "/");
                info.setText(null);
            }
        });

        btn_percentage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                ACTION = PERCENTAGE;
                result.setText(String.valueOf(val1));
                info.setText(null);
            }
        });

        btn_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                ACTION = EQU;
                result.setText(result.getText().toString() + String.valueOf(val2) + "=" + String.valueOf(val1));
                info.setText(null);
            }
        });

        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(info.getText().length() > 0 ){
                    CharSequence name = info.getText().toString();
                    info.setText(name.subSequence(0,name.length() -1));
                }else {
                    val1 = Double.NaN;
                    val2 = Double.NaN;
                    info.setText(null);
                    result.setText(null);
                }
            }
        });



    }
    private void setupUIviews(){
        btn_one = (Button)findViewById(R.id.btn_one);
        btn_tow = (Button)findViewById(R.id.btn_tow);
        btn_three = (Button)findViewById(R.id.btn_three3);
        btn_four = (Button)findViewById(R.id.btn_four);
        btn_five = (Button)findViewById(R.id.btn_five);
        btn_six = (Button)findViewById(R.id.btn_six);
        btn_seven = (Button)findViewById(R.id.btn_seven);
        btn_eight = (Button)findViewById(R.id.btn_eight);
        btn_nine = (Button)findViewById(R.id.btn_nine);
        btn_zero = (Button)findViewById(R.id.btn_zero);
        btn_duobleZero = (Button)findViewById(R.id.btn_doubleZero);
        btn_dot = (Button)findViewById(R.id.btn_dot);
        btn_clear = (Button)findViewById(R.id.btn_clear);
        btn_percentage = (Button)findViewById(R.id.btn_percentage);
        btn_divid = (Button)findViewById(R.id.btn_divid);
        btn_multiply = (Button)findViewById(R.id.multiply);
        btn_minus = (Button)findViewById(R.id.btn_minus);
        btn_add = (Button)findViewById(R.id.btn_add);
        btn_equal = (Button)findViewById(R.id.btn_equal);
        info = (TextView)findViewById(R.id.tv_userInput);
        result = (TextView)findViewById(R.id.tv_userResult);
    }

    private void compute(){
        if(!Double.isNaN(val1)){
            val2 = Double.parseDouble(info.getText().toString());
            switch (ACTION){
                case ADDITION:
                    val1 = val1 + val2;
                    break;
                case SUBSTRUCTION:
                    val1 = val1 - val2;
                    break;
                case MULTIPCATION:
                    val1 = val1 * val2;
                    break;
                case DIVISION:
                    val1 = val1 / val2;
                    break;
                case PERCENTAGE:
                    val1 = val2 / 100;
                    break;
                case EQU:
                    break;

            }
        }else {
            val1 = Double.parseDouble(info.getText().toString());
        }
    }
}
