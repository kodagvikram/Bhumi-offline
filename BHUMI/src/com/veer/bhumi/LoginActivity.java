package com.veer.bhumi;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.telephony.TelephonyManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends Activity {

	public EditText userid,password;
	public Button login;
	SharedPreferences sharedPreferences;
	 String device_id="";
	 
	 private boolean isValidUser=false;
	 
	 public ArrayList<String> deviceIdArrayList=new ArrayList<String>() {{
		    add("B");
		    add("911441050118797");
		    add("353953065743679");
		    add("358352054268621");
		    add("353267065740993");
		}};
	 
	@Override
	public void onBackPressed() {
		Constants.killAll();
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_activity);
		try{
		Constants.activity_stack.add(this);
		 
		TelephonyManager tm = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
	        device_id = tm.getDeviceId();
	        
		sharedPreferences = PreferenceManager
				.getDefaultSharedPreferences(getApplicationContext());
		
		SharedPreferences.Editor editor = sharedPreferences
				.edit();
		 editor.putString("SIGN","");
		editor.putString("SUMTOTAL","0");
		editor.commit();
		
		if(sharedPreferences.getString("username", "").equalsIgnoreCase(""))
		{
			
		}
		else
		{
			Intent intent=new Intent(getApplicationContext(), JantriActivity.class);
			startActivity(intent);
			finish();
		}
		
		userid=(EditText)findViewById(R.id.usereditext);
		//password=(EditText)findViewById(R.id.passwordedittext);
		login=(Button)findViewById(R.id.logbutton);
		
		login.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				if(Integer.parseInt(sharedPreferences.getString("LOGINCOUNT", "0"))>2)
				{
					AlertDialog.Builder builder = new AlertDialog.Builder(
							LoginActivity.this);
					builder.setTitle("BHUMI");
					builder.setMessage("UNAUTHORIZED USER. ")
							.setCancelable(false)
							.setPositiveButton("OK",
									new DialogInterface.OnClickListener() {
										public void onClick(
												DialogInterface dialog, int id) {
											// do things
										}
									});
					AlertDialog alert = builder.create();
					alert.show();
				}
				else
				{
				if(userid.getText().toString().equals("")||!userid.getText().toString().equalsIgnoreCase("*VrushalI@4"))
				{
					AlertDialog.Builder builder = new AlertDialog.Builder(
							LoginActivity.this);
					builder.setTitle("BHUMI");
					builder.setMessage("Enter Valid Userid and Password")
							.setCancelable(false)
							.setPositiveButton("OK",
									new DialogInterface.OnClickListener() {
										public void onClick(
												DialogInterface dialog, int id) {
											// do things
										}
									});
					AlertDialog alert = builder.create();
					alert.show();
					
					int cnt=Integer.parseInt(sharedPreferences.getString("LOGINCOUNT", "0"));
					cnt++;
					SharedPreferences.Editor editor = sharedPreferences
							.edit();
					//editor.putString("password", password.getText().toString());
					editor.putString("LOGINCOUNT",""+cnt);
					editor.commit();
					
				}//end of if
				else
				{
					for(String object: deviceIdArrayList){
						  
						 if(object.equalsIgnoreCase(device_id))
						 {
							 isValidUser=true;
							 break;
						 }
						}
					
					 isValidUser=true;
					 
					if(!isValidUser)
					{
						AlertDialog.Builder builder = new AlertDialog.Builder(
								LoginActivity.this);
						builder.setTitle("BHUMI");
						builder.setMessage("Please Contact \n9766846506\nto Purchase the app and get Login.")
								.setCancelable(false)
								.setPositiveButton("OK",
										new DialogInterface.OnClickListener() {
											public void onClick(
													DialogInterface dialog, int id) {
												// do things
											}
										});
						AlertDialog alert = builder.create();
						alert.show();
					}
					else
					{
						SharedPreferences.Editor editor = sharedPreferences
								.edit();
						//editor.putString("password", password.getText().toString());
						editor.putString("username", "VALID");
						editor.putString("LOGINCOUNT","0");
						editor.commit();
						
					   Intent intent=new Intent(getApplicationContext(), JantriActivity.class);
					   startActivity(intent);
					   finish();
					}
				
				}//end of else
				
				}//end of else authorize
				
				
			}//end of submit click
		});
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}//end of oncreate()
	
}//end of Activity
