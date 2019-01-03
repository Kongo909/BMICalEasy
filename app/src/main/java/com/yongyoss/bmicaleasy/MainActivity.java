package com.yongyoss.bmicaleasy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button_cal = (Button)findViewById(R.id.button_cal);
        ((Button) button_cal).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calBMI();
            }
        });
    }
    private void calBMI(){
        EditText textw = (EditText)findViewById(R.id.editText_wieght);
        EditText texth = (EditText)findViewById(R.id.editText_high);

        double w = Double.parseDouble(textw.getText().toString());
        double h = Double.parseDouble(textw.getText().toString());

        h = h/100; // cm-->m

        double bmi = w / ( h * h );

        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        String msg = "ค่า BMI คือ = " + decimalFormat.format(bmi) + "\n";
        msg += "ลักษณะรูปร่างคือ:";
        if (bmi >= 40) msg += "อ้วนขั้นสูงสุด";
        else if (bmi >= 35) msg += "อ้วนขั้นที่ 2";
        else if (bmi >= 28.5) msg += "อ้วนขั้นที่ 1";
        else if (bmi >= 23.5) msg += "นํ้าหนักเกิน";
        else if (bmi >= 18.5) msg += "อยู่ในเกณฑ์ปกติ";
        else  msg += "นํ้าหนักตํ่ากว่าปกติ";

        Toast.makeText(getBaseContext(),msg,Toast.LENGTH_LONG).show();

    }
};
