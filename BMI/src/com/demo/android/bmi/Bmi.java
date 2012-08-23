package com.demo.android.bmi;

import java.text.DecimalFormat;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;

public class Bmi extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        //Listen for button clicks
        Button button = (Button)findViewById(R.id.submit);
        button.setOnClickListener(calcBMI);		// callback
    }
    
private OnClickListener calcBMI = new OnClickListener()
 {
		public void onClick(View v)
		{
				DecimalFormat nf = new DecimalFormat("0.00");
				EditText fieldheight = (EditText)findViewById(R.id.height);
				EditText fieldweight = (EditText)findViewById(R.id.weight);
				double height = Double.parseDouble(fieldheight.getText().toString())/100;
				double weight = Double.parseDouble(fieldweight.getText().toString());
				double BMI = weight / (height * height);
				TextView result = (TextView)findViewById(R.id.result);
				result.setText("Your BMI is "+nf.format(BMI));
	
				//Give health advice
				TextView fieldsuggest = (TextView)findViewById(R.id.suggest);
				if(BMI>25){
						fieldsuggest.setText(R.string.advice_heavy);
				}else if(BMI<20){
						fieldsuggest.setText(R.string.advice_light);
				}else{
						fieldsuggest.setText(R.string.advice_average);
				}
			}
};

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_bmi, menu);
        return true;
    }
}
