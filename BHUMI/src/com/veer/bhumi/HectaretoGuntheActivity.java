package com.veer.bhumi;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityOptions;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class HectaretoGuntheActivity extends Activity {
	FrameLayout mainFrameLyout;
	FrameLayout.LayoutParams menuPanelParameters;
	FrameLayout.LayoutParams slidingPanelParameters;
	LinearLayout.LayoutParams headerPanelParameters;
	LinearLayout.LayoutParams listViewParameters;
	Button menuBtn;
	private DisplayMetrics metrics;
	private RelativeLayout slidingPanel,menulayout;
	int panelWidth = 0;
	private boolean isExpanded;
	
	EditText areEdittext,acreEdittext,guntheEdittext,hecteroutputEdittext;
	
	@Override
	public void onBackPressed() {
		Constants.killAll();
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hectertogunthexml);
		try{
		Constants.activity_stack.add(this);
		metrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);
		panelWidth = (int) ((metrics.widthPixels) * 0.75);
		slidingPanel = (RelativeLayout) findViewById(R.id.mainRelativeLayout);
		slidingPanelParameters = (FrameLayout.LayoutParams) slidingPanel
				.getLayoutParams();
		slidingPanelParameters.width = metrics.widthPixels;
		slidingPanel.setLayoutParams(slidingPanelParameters);

		 menulayout=(RelativeLayout)findViewById(R.id.Layoutmenubaar);
		 menulayout.setVisibility(View.GONE);
		 
			metrics = new DisplayMetrics();
			getWindowManager().getDefaultDisplay().getMetrics(metrics);
			panelWidth = (int) ((metrics.widthPixels) * 0.75);
			slidingPanel = (RelativeLayout) findViewById(R.id.mainRelativeLayout);
			slidingPanelParameters = (FrameLayout.LayoutParams) slidingPanel
					.getLayoutParams();
			slidingPanelParameters.width = metrics.widthPixels;
			slidingPanel.setLayoutParams(slidingPanelParameters);

			menuBtn = (Button) findViewById(R.id.menuBtn);
			menuBtn.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					KeyboardUtil.hideKeyboard(getParent());
					if (!isExpanded) {
						isExpanded = true;

						menulayout.setVisibility(View.VISIBLE);
						// Expand
						new ExpandAnimation(slidingPanel, panelWidth,
								Animation.RELATIVE_TO_SELF, 0.0f,
								Animation.RELATIVE_TO_SELF, 0.75f, 0, 0.0f, 0, 0.0f);
					} else {
						isExpanded = false;
						
						// Collapse
						new CollapseAnimation(slidingPanel, panelWidth,
								TranslateAnimation.RELATIVE_TO_SELF, 0.75f,
								TranslateAnimation.RELATIVE_TO_SELF, 0.0f, 0, 0.0f,
								0, 0.0f,menulayout);

					}
				}
			});
		
		Typeface font = Typeface.createFromAsset(getAssets(),
				"fontawesome-webfont.ttf");
		Button button1 = (Button) findViewById(R.id.btn_recruit);
		//Button button2 = (Button) findViewById(R.id.btn_chat);
		Button button3 = (Button) findViewById(R.id.btn_matchup);
		Button button4 = (Button) findViewById(R.id.btn_guest);
		Button button5 = (Button) findViewById(R.id.btn_business);
		Button button6 = (Button) findViewById(R.id.btn_BPM_Check_In);
		Button button7 = (Button) findViewById(R.id.btn_logout);
		button1.setTypeface(font);
		//button2.setTypeface(font);
		button3.setTypeface(font);
		button4.setTypeface(font);
		button5.setTypeface(font);
		button6.setTypeface(font);
		button7.setTypeface(font);
		Button button8 = (Button) findViewById(R.id.btn_Dashboard);
		button8.setTypeface(font);
		menuBtn.setTypeface(font);
		Button button9 = (Button) findViewById(R.id.btn_AAKAR);
		button9.setTypeface(font);
		Button button10 = (Button) findViewById(R.id.btn_ADDACRE);
		button10.setTypeface(font);
		Button button11 = (Button) findViewById(R.id.btn_VASALEVAR);
		button11.setTypeface(font);
		Button button12 = (Button) findViewById(R.id.btn_SORTCUT);
		button12.setTypeface(font);
		Button button13 = (Button) findViewById(R.id.btn_SCALE);
		button13.setTypeface(font);
		Button button14 = (Button) findViewById(R.id.btn_MAZASORTCUT);
		button14.setTypeface(font);
		Button button15 = (Button) findViewById(R.id.btn_NEWMAZASORTCUT);
		button15.setTypeface(font);
		areEdittext=(EditText)findViewById(R.id.HECTERINPUT1);
		acreEdittext=(EditText)findViewById(R.id.HECTERoutput1);
		guntheEdittext=(EditText)findViewById(R.id.HECTERoutput2);
		hecteroutputEdittext=(EditText)findViewById(R.id.HECTERINPUT4);
		
		Button Clearbtn=(Button)findViewById(R.id.CLEARBTN);
		Clearbtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				areEdittext.setText("");
				acreEdittext.setText("");
				guntheEdittext.setText("");
				hecteroutputEdittext.setText("");
			}
		});
		
		Button backbtn=(Button)findViewById(R.id.BACKBTN);
		backbtn.setOnClickListener(new OnClickListener() {
			
			@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
			@SuppressLint("NewApi")
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent slideactivity = new Intent(getApplicationContext(), NewHecter_Acre_GuntheActivity.class);
				Bundle bndlanimation = 
						ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.animation,R.anim.animation2).toBundle();
				startActivity(slideactivity, bndlanimation);
			}
		});
		
		areEdittext.addTextChangedListener(new TextWatcher() {
			public void afterTextChanged(Editable s) {
				// Abstract Method of TextWatcher Interface.
			}

			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// Abstract Method of TextWatcher Interface.
			}

			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				if(!areEdittext.getText().toString().equals(""))
				{
					CalculateValue();
				}//end of if
				else
				{
					acreEdittext.setText("");
					guntheEdittext.setText("");
				}
			}
		});//end of listner

		
		acreEdittext.addTextChangedListener(new TextWatcher() {
			public void afterTextChanged(Editable s) {
				// Abstract Method of TextWatcher Interface.
			}

			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// Abstract Method of TextWatcher Interface.
			}

			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				
				if(!acreEdittext.getText().toString().equals("")&&!guntheEdittext.getText().toString().equals(""))
				{
					CalculateInverseValue();
				}//end of if
				else
					hecteroutputEdittext.setText("");
			}
		});//end of listner
		
		guntheEdittext.addTextChangedListener(new TextWatcher() {
			public void afterTextChanged(Editable s) {
				// Abstract Method of TextWatcher Interface.
			}

			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// Abstract Method of TextWatcher Interface.
			}

			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				
				if(!guntheEdittext.getText().toString().equals(""))
					if(Integer.parseInt(guntheEdittext.getText().toString())<40)
					{
						if(!acreEdittext.getText().toString().equals("")&&!guntheEdittext.getText().toString().equals(""))
						{
							CalculateInverseValue();
						}//end of if
						else
							hecteroutputEdittext.setText("");
					}//end of if
					else
					{
						AlertDialog.Builder builder = new AlertDialog.Builder(
								HectaretoGuntheActivity.this);
						builder.setTitle("BHUMI");
						builder.setMessage("Enter value less than 39")
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
						guntheEdittext.setText("");
					}
					else
						hecteroutputEdittext.setText("");
				
				
				
			}
		});//end of listner

		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}// end of oncreate()
	
	public void CalculateValue()
	{
		try {
			
			int length=areEdittext.getText().toString().length();
			if(length>0)
			{
			if(!Character.toString(areEdittext.getText().toString().charAt(length-1)).equalsIgnoreCase("."))
			{
				NumberFormat formatter = new DecimalFormat("#0.0000000");
				NumberFormat formatter2 = new DecimalFormat("#0.0000000");
				//Latitude=formatter.format(latitude);
				double temp=Double.valueOf(areEdittext.getText().toString())*10000;
				String temp2=formatter.format(temp/4046.85642);
				
				String[] strArray = temp2.split("\\.");
				
				double temp3=Double.valueOf("0."+strArray[1]);
				//double temp5=temp3/2.5;
				String temp4=formatter2.format(temp3*40);

				String[] strArray2 = temp4.split("\\.");
				int n=Integer.parseInt(strArray2[0]);
				int m=Integer.parseInt(strArray2[1].substring(0, 2));
			 if(m>50)
				n=n+1;
			 
			 if(n>39)
			 {
				 n=0;
				 int x=Integer.parseInt(strArray[0]);
				 x++;
				 
				 strArray[0]=""+x;
			 }
				
				acreEdittext.setText(""+strArray[0]);
				
				guntheEdittext.setText(""+n);
				
				
			 }//end of if
			}//end of if length
			else
			{
				
			}//end of else			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}//end of Calculate Value
	
	public void CalculateInverseValue()
	{
		
		try {
			int length=acreEdittext.getText().toString().length();
			int length2=guntheEdittext.getText().toString().length();
			if(length>0&&length2>0)
			{
			if(!Character.toString(acreEdittext.getText().toString().charAt(length-1)).equalsIgnoreCase(".")&&!Character.toString(guntheEdittext.getText().toString().charAt(length2-1)).equalsIgnoreCase("."))
			{
				NumberFormat formatter = new DecimalFormat("#0.000");
				NumberFormat formatter2 = new DecimalFormat("#0.00");
				//Latitude=formatter.format(latitude);
				int temp=(Integer.valueOf(acreEdittext.getText().toString()));
				double temp2=(Double.valueOf(guntheEdittext.getText().toString())/40);
				
				double temp3=temp+temp2;
				
				double temp4=Double.valueOf(formatter.format((temp3*4046.85642)))/10000;
				
				String temp5=formatter2.format(temp4);
//				
//				String[] strArray = temp2.split("\\.");
//				
//			  // int	temp3=Integer.parseInt(strArray[1]);
//			  //String temp4=formatter2.format(temp3/2.5);
////				
////				String[] strArray2 = temp3.split("\\.");
////				
//				int n=Integer.parseInt(strArray[1].substring(0, 2));
//				int m=Integer.parseInt(strArray[1].substring(2, 4));
//				if(m>50)
//					n=n+1;
//				String outputstring=strArray[0];
//				
//				if(n<10)
//				outputstring=outputstring+".0"+n;
//				else
//					outputstring=outputstring+"."+n;	
				
				hecteroutputEdittext.setText(""+temp5);
				
				//guntheEdittext.setText(""+n);
			 }//end of if
			}//end of if length
			else
			{
				
			}//end of else
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		
		
	}//end of calculate inverse value
	
	@SuppressLint("NewApi")
	public void onMenuOptionClicked(View view) {
		if (view.getId() == R.id.LANDAREALAYOUT) {
			Intent slideactivity = new Intent(this, LandAreaActivity.class);
			Bundle bndlanimation = 
					ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.animation,R.anim.animation2).toBundle();
			startActivity(slideactivity, bndlanimation);
			
			 finish();
		} else if (view.getId() == R.id.HECTERTOGUNTHELAYOUT) {
			isExpanded = false;
			new CollapseAnimation(slidingPanel, panelWidth,
					TranslateAnimation.RELATIVE_TO_SELF, 0.75f,
					TranslateAnimation.RELATIVE_TO_SELF, 0.0f, 0, 0.0f, 0, 0.0f,menulayout);
		}else if (view.getId() == R.id.ENLARGMENTLAYOUT) {
			
			Intent slideactivity = new Intent(this, EnlargmentActivity.class);
			Bundle bndlanimation = 
					ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.animation,R.anim.animation2).toBundle();
			startActivity(slideactivity, bndlanimation);
			 finish();
		} else if (view.getId() == R.id.AAKARFODLAYOUT) {
			Intent slideactivity = new Intent(this, AakarfodeActivity.class);
			Bundle bndlanimation = 
					ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.animation,R.anim.animation2).toBundle();
			startActivity(slideactivity, bndlanimation);
		
		}  else if (view.getId() == R.id.ADDACREGUNTHELAYOUT) {
			Intent slideactivity = new Intent(this, AddAcreGuntheActivity.class);
			Bundle bndlanimation = 
					ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.animation,R.anim.animation2).toBundle();
			startActivity(slideactivity, bndlanimation);
			 finish();
		} else if (view.getId() == R.id.SAMLAMBLAYOUT) {
			Intent slideactivity = new Intent(this, TriangleAreaActivity.class);
			Bundle bndlanimation = 
					ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.animation,R.anim.animation2).toBundle();
			startActivity(slideactivity, bndlanimation);
			 finish();
		} 
//		else if (view.getId() == R.id.TRIANGLELAYOUT) {
//			Intent intent = new Intent(JantriActivity.this,
//					TriangleAreaActivity.class);
//			startActivity(intent);
//			 finish();
//		} 
		else if (view.getId() == R.id.TRIANGLELANDLAYOUT) {
			Intent slideactivity = new Intent(this, TriangleLandActivity.class);
			Bundle bndlanimation = 
					ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.animation,R.anim.animation2).toBundle();
			startActivity(slideactivity, bndlanimation);
			 finish();
		} else if (view.getId() == R.id.JANTRILayout) {
			Intent slideactivity = new Intent(this, JantriActivity.class);
			Bundle bndlanimation = 
					ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.animation,R.anim.animation2).toBundle();
			startActivity(slideactivity, bndlanimation);
		} 
		 else if (view.getId() == R.id.AANEWARILAYOUT) {
				Intent slideactivity = new Intent(this, AanewariActivity.class);
				Bundle bndlanimation = 
						ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.animation,R.anim.animation2).toBundle();
				startActivity(slideactivity, bndlanimation);
				
			} else if (view.getId() == R.id.VASALEVARLAYOUT) {
				Intent slideactivity = new Intent(this, VasalevarActivity.class);
				Bundle bndlanimation = 
						ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.animation,R.anim.animation2).toBundle();
				startActivity(slideactivity, bndlanimation);
				
			} else if (view.getId() == R.id.SORTCUTLAYOUT) {
				Intent slideactivity = new Intent(this, ShortcutActivity.class);
				Bundle bndlanimation = 
						ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.animation,R.anim.animation2).toBundle();
				startActivity(slideactivity, bndlanimation);
				
			}else if (view.getId() == R.id.SCALELAYOUT) {
				Intent slideactivity = new Intent(this, ScaleActivity.class);
				Bundle bndlanimation = 
						ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.animation,R.anim.animation2).toBundle();
				startActivity(slideactivity, bndlanimation);
			}else if (view.getId() == R.id.MAZASORTCUTLAYOUT) {
				Intent slideactivity = new Intent(this, MazaShortcutActivity.class);
				Bundle bndlanimation = 
						ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.animation,R.anim.animation2).toBundle();
				startActivity(slideactivity, bndlanimation);
			}else if (view.getId() == R.id.NEWMAZASORTCUTLAYOUT) {
				Intent slideactivity = new Intent(this, NewMazashortcut.class);
				Bundle bndlanimation = 
						ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.animation,R.anim.animation2).toBundle();
				startActivity(slideactivity, bndlanimation);
			}
	}// end of menu
}// end of Activity
