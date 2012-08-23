package com.demo.android.bmi;

import java.text.DecimalFormat;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.Menu;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;

public class Bmi extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        findViews();
        setListensers();
        }
    
    private Button button_calc;
    private EditText field_height;
    private EditText field_weight;
    private TextView view_result;
    private TextView view_suggest;
    
    private void findViews()
    {
    button_calc = (Button) findViewById(R.id.submit);
    field_height = (EditText) findViewById(R.id.height);
    field_weight = (EditText) findViewById(R.id.weight);
    view_result = (TextView) findViewById(R.id.result);
    view_suggest = (TextView) findViewById(R.id.suggest);
    }
    //Listen for button clicks
    private void setListensers() {
    button_calc.setOnClickListener(calcBMI);
    }
    
    private Button.OnClickListener calcBMI = new Button.OnClickListener() {
			    public void onClick(View v)
			    {
			    DecimalFormat nf = new DecimalFormat("0.0");
			    double height = Double.parseDouble(field_height.getText().toString())/100;
			    double weight = Double.parseDouble(field_weight.getText().toString());
			    double BMI = weight / (height * height);
			    //Present result
			    view_result.setText(getText(R.string.bmi_result) + nf.format(BMI));
			    //Give health advice
			    if(BMI>25){
			    view_suggest.setText(R.string.advice_heavy);
			    }else if(BMI<20){
			    view_suggest.setText(R.string.advice_light);
			    }else{
			    view_suggest.setText(R.string.advice_average);
			    	   }
			    openOptionsDialog();
			    }		    
  };

  
  private void openOptionsDialog() {
  	new AlertDialog.Builder(Bmi.this)
  	.setTitle(R.string.about_title)
  	.setMessage(R.string.about_msg)
  	.setPositiveButton(
	  			R.string.ok_label,
	  			new DialogInterface.OnClickListener(){			  	
		  			public void onClick(DialogInterface dialoginterface, int i){}
	  				}
  			)
  	.show();
  	}
  
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_bmi, menu);
        return true;
    }
}
