package com.sibivarmanl.unitconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    static final int weight = 1;
    static final int lenght = 2;
    static final int temp = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init(){

        final EditText kilo = (EditText)findViewById(R.id.editText);
        final EditText pound = (EditText)findViewById(R.id.editText2);
        final EditText metre = (EditText)findViewById(R.id.editText3);
        final EditText yard = (EditText)findViewById(R.id.editText4);
        final EditText celsius = (EditText)findViewById(R.id.editText5);
        final EditText fahrenhiet = (EditText)findViewById(R.id.editText6);

        Button b1 = (Button)findViewById(R.id.button);
        Button b2 = (Button)findViewById(R.id.button2);
        Button b3 = (Button)findViewById(R.id.button3);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate(kilo,pound,weight);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate(metre,yard,lenght);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate(celsius,fahrenhiet,temp);
            }
        });

    }

    void calculate(EditText e1,EditText e2,int val){

        Double convert = 1.0,temp,div = 1.0;
        int num = 0;

        switch (val){

            case 1:
                convert = 2.20462;
                num = 0;
                div = 1.0;
                break;
            case 2:
                convert = 1.09361;
                num = 0;
                div = 1.0;
                break;
            case 3:
                convert = 1.0;
                num = 32;
                div = 1.8;
                break;

        }

        if(e1.getText().toString().equals("")){
            temp = Double.parseDouble(e2.getText().toString());
            e1.setText(Double.toString((temp/convert)-num/div));
        }
        else{
            temp = Double.parseDouble(e1.getText().toString());
            e2.setText(Double.toString((temp*convert)*div+num));
        }

    }
}
