package com.veer.bhumi;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityOptions;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
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

public class AakarfodeActivity extends Activity {
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

	EditText sakliEdittext,aaneEdittext,inputEdittext3,outputEdittext,outputEdittext2,outputEdittext3;
	@Override
	public void onBackPressed() {
		Constants.killAll();
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.aakarfodxml);
		try {
			
		Constants.activity_stack.add(this);
		metrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);
		panelWidth = (int) ((metrics.widthPixels) * 0.75);
		slidingPanel = (RelativeLayout) findViewById(R.id.mainRelativeLayout);
		slidingPanelParameters = (FrameLayout.LayoutParams) slidingPanel
				.getLayoutParams();
		slidingPanelParameters.width = metrics.widthPixels;
		slidingPanel.setLayoutParams(slidingPanelParameters);

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
		sakliEdittext=(EditText)findViewById(R.id.AAKARFODEDITTEXT2);
		aaneEdittext=(EditText)findViewById(R.id.AAKARFODEDITTEXT1);
		inputEdittext3=(EditText)findViewById(R.id.AAKARFODEDITTEXT4);
		outputEdittext=(EditText)findViewById(R.id.AAKARFODEDITTEXT3);
		
		outputEdittext2=(EditText)findViewById(R.id.newAAKARFODEDITTEXT4);
		outputEdittext3=(EditText)findViewById(R.id.newAAKARFODEDITTEXT3);
		
		Button Clearbtn=(Button)findViewById(R.id.CLEARBTN);
		Clearbtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				sakliEdittext.setText("");
				aaneEdittext.setText("");
				outputEdittext.setText("");
				inputEdittext3.setText("");
				outputEdittext2.setText("");
				outputEdittext3.setText("");
			}
		});
		
		sakliEdittext.addTextChangedListener(new TextWatcher() {
			public void afterTextChanged(Editable s) {
				// Abstract Method of TextWatcher Interface.
			}

			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// Abstract Method of TextWatcher Interface.
			}

			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				
				if(!sakliEdittext.getText().toString().equals("")&&!aaneEdittext.getText().toString().equals("")&&!inputEdittext3.getText().toString().equals(""))
				{
					CalculateValue();
				}//end of if
				else
					outputEdittext.setText("");
			}
		});//end of listner
		
		aaneEdittext.addTextChangedListener(new TextWatcher() {
			public void afterTextChanged(Editable s) {
				// Abstract Method of TextWatcher Interface.
			}
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// Abstract Method of TextWatcher Interface.
			}

			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				if(!sakliEdittext.getText().toString().equals("")&&!aaneEdittext.getText().toString().equals("")&&!inputEdittext3.getText().toString().equals(""))
				{
					CalculateValue();
				}//end of if
				else
					outputEdittext.setText("");
			}
		});//end of listner
		
		inputEdittext3.addTextChangedListener(new TextWatcher() {
			public void afterTextChanged(Editable s) {
				// Abstract Method of TextWatcher Interface.
			}

			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// Abstract Method of TextWatcher Interface.
			}

			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				if(!sakliEdittext.getText().toString().equals("")&&!aaneEdittext.getText().toString().equals("")&&!inputEdittext3.getText().toString().equals(""))
				{
					CalculateValue();
				}//end of if
				else
					outputEdittext.setText("");
			}
		});//end of listner

		
		outputEdittext.addTextChangedListener(new TextWatcher() {
			public void afterTextChanged(Editable s) {
				// Abstract Method of TextWatcher Interface.
			}

			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// Abstract Method of TextWatcher Interface.
			}

			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				
				if(!sakliEdittext.getText().toString().equals("")&&!aaneEdittext.getText().toString().equals("")&&!inputEdittext3.getText().toString().equals("")&&!outputEdittext.getText().toString().equals(""))
				{
					NumberFormat formatter2 = new DecimalFormat("#0.00");
					
					double temp=Double.valueOf(sakliEdittext.getText().toString())-Double.valueOf(inputEdittext3.getText().toString());
				   double temp2=Double.valueOf(aaneEdittext.getText().toString())-Double.valueOf(outputEdittext.getText().toString());	
					
					outputEdittext2.setText(""+formatter2.format(temp));
					outputEdittext3.setText(""+formatter2.format(temp2));
				}//end of if
				else{
					//outputEdittext.setText("");
					outputEdittext2.setText("");
					outputEdittext3.setText("");
				
				}
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
		int length=sakliEdittext.getText().toString().length();
		int length2=aaneEdittext.getText().toString().length();
		int length3=inputEdittext3.getText().toString().length();
		if(length>0&&length2>0&&length3>0)
		{
		if(!Character.toString(sakliEdittext.getText().toString().charAt(length-1)).equalsIgnoreCase(".")&&!Character.toString(aaneEdittext.getText().toString().charAt(length2-1)).equalsIgnoreCase(".")&&!Character.toString(inputEdittext3.getText().toString().charAt(length3-1)).equalsIgnoreCase("."))
		{
			NumberFormat formatter = new DecimalFormat("#0.0000000");
			NumberFormat formatter2 = new DecimalFormat("#0.00");
			//Latitude=formatter.format(latitude);
			double temp=(Double.valueOf(sakliEdittext.getText().toString()));
			double temp2=(Double.valueOf(aaneEdittext.getText().toString()))*(Double.valueOf(inputEdittext3.getText().toString()));
			
			double temp3=Double.valueOf(formatter.format(temp2/temp));
			
//			String[] strArray = String.valueOf(temp3).split("\\.");
//			
//			int n=Integer.parseInt(strArray[0]);
//			int m=Integer.parseInt(strArray[1].substring(0, 2));
//			
//			String outputString="";
//			if(m>50)
//			{
//				n=n+1;
//				outputString=""+n;
//			}
//			else
//				outputString=""+n+"."+m;
						
			outputEdittext.setText(""+formatter2.format(temp3));
			
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
	}//end of calculate



	@SuppressLint("NewApi")
	public void onMenuOptionClicked(View view) {
		if (view.getId() == R.id.LANDAREALAYOUT) {
			Intent slideactivity = new Intent(this, LandAreaActivity.class);
			Bundle bndlanimation = 
					ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.animation,R.anim.animation2).toBundle();
			startActivity(slideactivity, bndlanimation);
			
			 finish();
		} else if (view.getId() == R.id.AAKARFODLAYOUT) {
			isExpanded = false;
			new CollapseAnimation(slidingPanel, panelWidth,
					TranslateAnimation.RELATIVE_TO_SELF, 0.75f,
					TranslateAnimation.RELATIVE_TO_SELF, 0.0f, 0, 0.0f, 0, 0.0f,menulayout);
		}else if (view.getId() == R.id.HECTERTOGUNTHELAYOUT) {
			
			Intent slideactivity = new Intent(this, HectaretoGuntheActivity.class);
			Bundle bndlanimation = 
					ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.animation,R.anim.animation2).toBundle();
			startActivity(slideactivity, bndlanimation);
			 finish();
		} else if (view.getId() == R.id.AANEWARILAYOUT) {
			Intent slideactivity = new Intent(this, AanewariActivity.class);
			Bundle bndlanimation = 
					ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.animation,R.anim.animation2).toBundle();
			startActivity(slideactivity, bndlanimation);
		
		}  else if (view.getId() == R.id.ENLARGMENTLAYOUT) {
			Intent slideactivity = new Intent(this, EnlargmentActivity.class);
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
		 else if (view.getId() == R.id.ADDACREGUNTHELAYOUT) {
				Intent slideactivity = new Intent(this, AddAcreGuntheActivity.class);
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

