package com.veer.bhumi;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityOptions;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
public class NewMazashortcut extends Activity {
	FrameLayout mainFrameLyout;
	FrameLayout.LayoutParams menuPanelParameters;
	FrameLayout.LayoutParams slidingPanelParameters;
	LinearLayout.LayoutParams headerPanelParameters;
	LinearLayout.LayoutParams listViewParameters;
	Button menuBtn;
	int clickcount=1;
	BhumiSingleton singleton;
	SharedPreferences sharedPreferences;
public double inputare=0,outputacre=0,outputgunthe=0;
	
	EditText aEdittext,bEdittext,cEdittext,dEdittext,eEdittext,AreEdittext,OUTPUTEdittext,newAreEdittext,newMeteroutputEdittext;
	Button aButton,bButton,dButton,eButton,btn_addtipan,btn_minustipan;
	private DisplayMetrics metrics;
	private RelativeLayout slidingPanel,menulayout;
	double ADDMAZATOTAL=0;
	int panelWidth = 0;
	private boolean  isExpanded,isAButton=false,isBButton=false,isDButton=false,isEButton=false,isPlusButton=false
			,isMinusButton=false,isAreTextview=true,isSqmTextview=false;
	@Override
	public void onBackPressed() {
		Constants.killAll();
	}
	
	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		//super.onRestart();
		try {
		
		double prevtotal=0;
		if(!sharedPreferences.getString("newADDMAZATOTAL", "").equals(""))
			prevtotal	=Double.valueOf(sharedPreferences.getString("newADDMAZATOTAL", "0"));
		
		ADDMAZATOTAL=prevtotal;
		System.out.println("****************"+ADDMAZATOTAL);
		if(!newAreEdittext.getText().toString().equals("")&&!aEdittext.getText().toString().equals("")&&!bEdittext.getText().toString().equals("")&&!cEdittext.getText().toString().equals("")&&!dEdittext.getText().toString().equals("")&&!eEdittext.getText().toString().equals("")&&!AreEdittext.getText().toString().equals(""))
		{
			CalculateValue();
		}//end of if
		else
			OUTPUTEdittext.setText("");
		super.onRestart();
		} catch (Exception e) {
			// TODO: handle exception
		e.printStackTrace();
		}
	}
	@TargetApi(Build.VERSION_CODES.JELLY_BEAN) @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.new_mazashortcut_xml);
		try{
			sharedPreferences = PreferenceManager
					.getDefaultSharedPreferences(getApplicationContext());
			singleton=BhumiSingleton.getInstance(this);
			
		Constants.activity_stack.add(this);
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
		
		menuBtn.setTypeface(font);
		
		aEdittext=(EditText)findViewById(R.id.MSHORTCUTEDITTEXT3);
		bEdittext=(EditText)findViewById(R.id.MSHORTCUTEDITTEXT2);
		cEdittext=(EditText)findViewById(R.id.MSHORTCUTEDITTEXT4);
		dEdittext=(EditText)findViewById(R.id.MSHORTCUTEDITTEXT6);
		eEdittext=(EditText)findViewById(R.id.MSHORTCUTEDITTEXT5);
		AreEdittext=(EditText)findViewById(R.id.MSHORTCUTEDITTEXT1);
		OUTPUTEdittext=(EditText)findViewById(R.id.MSHORTCUTEDITTEXT7);
		newAreEdittext=(EditText)findViewById(R.id.NEWUPDATEMSHORTCUTEDITTEXT2);
		newMeteroutputEdittext=(EditText)findViewById(R.id.MSHORTCUTEDITTEXT778);
		
		 btn_addtipan = (Button) findViewById(R.id.ADDTIPANBTN);
		 btn_addtipan.setTypeface(font);
	     btn_minustipan = (Button) findViewById(R.id.MINUSTIPANBTN);
		 btn_minustipan.setTypeface(font);
		
		btn_addtipan.setOnClickListener(new OnClickListener() {
			@TargetApi(Build.VERSION_CODES.JELLY_BEAN) @SuppressLint("NewApi") @Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(!isPlusButton)
				{
					btn_addtipan.setTextColor(Color.parseColor("#286118"));
					isPlusButton=true;
					
					btn_minustipan.setTextColor(Color.parseColor("#f40a21"));
					isMinusButton=false;
					singleton.newSELECTEDSIGN="PLUS";
					Intent slideactivity = new Intent(NewMazashortcut.this, AddnewMAZATOTALActivity.class);
					Bundle bndlanimation = 
							ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.animation,R.anim.animation2).toBundle();
					startActivity(slideactivity, bndlanimation);
				}
				else
				{
					btn_addtipan.setTextColor(Color.parseColor("#f40a21"));
					isPlusButton=false;
					singleton.newSELECTEDSIGN="";
					if(!aEdittext.getText().toString().equals("")&&!bEdittext.getText().toString().equals("")&&!cEdittext.getText().toString().equals("")&&!dEdittext.getText().toString().equals("")&&!eEdittext.getText().toString().equals("")&&!AreEdittext.getText().toString().equals(""))
					{
						CalculateValue();
					}//end of if
					else
					{
						OUTPUTEdittext.setText("");
						newMeteroutputEdittext.setText("");
					}
				}
				
				
			}
		});
		
		btn_minustipan.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(!isMinusButton)
				{
					btn_minustipan.setTextColor(Color.parseColor("#286118"));
					isMinusButton=true;
					btn_addtipan.setTextColor(Color.parseColor("#f40a21"));
					isPlusButton=false;
					singleton.newSELECTEDSIGN="MINUS";
					Intent slideactivity = new Intent(NewMazashortcut.this, AddnewMAZATOTALActivity.class);
					Bundle bndlanimation = 
					ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.animation,R.anim.animation2).toBundle();
					startActivity(slideactivity, bndlanimation);
				}
				else
				{
					btn_minustipan.setTextColor(Color.parseColor("#f40a21"));
					isMinusButton=false;
					singleton.newSELECTEDSIGN="";
					if(!aEdittext.getText().toString().equals("")&&!bEdittext.getText().toString().equals("")&&!cEdittext.getText().toString().equals("")&&!dEdittext.getText().toString().equals("")&&!eEdittext.getText().toString().equals("")&&!AreEdittext.getText().toString().equals(""))
					{
						CalculateValue();
					}//end of if
					else
					{
						OUTPUTEdittext.setText("");
						newMeteroutputEdittext.setText("");
					}
				}
				
			}
		});
		
		final TextView Uptextview7=(TextView)findViewById(R.id.MAZASHORTCUTTextview4);
		final TextView Uptextview8=(TextView)findViewById(R.id.MAZASHORTCUTTextview888);
		
		Uptextview7.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				isAreTextview=false;
				isSqmTextview=true;
				final int sdk = android.os.Build.VERSION.SDK_INT;
				  if(sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
					  Uptextview7.setBackgroundDrawable( getResources().getDrawable(R.drawable.green_rounded_xml) );
			    	} else {
			    		Uptextview7.setBackground( getResources().getDrawable(R.drawable.green_rounded_xml));
				     }
				  
				  if(sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
					  Uptextview8.setBackgroundDrawable( getResources().getDrawable(R.drawable.red_rounded_xml) );
			    	} else {
			    		Uptextview8.setBackground( getResources().getDrawable(R.drawable.red_rounded_xml));
				     }
				  
				  if(!newAreEdittext.getText().toString().equals("")&&!aEdittext.getText().toString().equals("")&&!bEdittext.getText().toString().equals("")&&!cEdittext.getText().toString().equals("")&&!dEdittext.getText().toString().equals("")&&!eEdittext.getText().toString().equals("")&&!AreEdittext.getText().toString().equals(""))
					{
						CalculateValue();
					}//end of if
					else
					{
						OUTPUTEdittext.setText("");
						newMeteroutputEdittext.setText("");
					}
			}
		});
		
          Uptextview8.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				isAreTextview=true;
				isSqmTextview=false;
				final int sdk = android.os.Build.VERSION.SDK_INT;
				  if(sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
					  Uptextview8.setBackgroundDrawable( getResources().getDrawable(R.drawable.green_rounded_xml) );
			    	} else {
			    		Uptextview8.setBackground( getResources().getDrawable(R.drawable.green_rounded_xml));
				     }
				  
				  if(sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
					  Uptextview7.setBackgroundDrawable( getResources().getDrawable(R.drawable.red_rounded_xml) );
			    	} else {
			    		Uptextview7.setBackground( getResources().getDrawable(R.drawable.red_rounded_xml));
				     }
				  
				  if(!newAreEdittext.getText().toString().equals("")&&!aEdittext.getText().toString().equals("")&&!bEdittext.getText().toString().equals("")&&!cEdittext.getText().toString().equals("")&&!dEdittext.getText().toString().equals("")&&!eEdittext.getText().toString().equals("")&&!AreEdittext.getText().toString().equals(""))
					{
						CalculateValue();
					}//end of if
					else
					{
						OUTPUTEdittext.setText("");
						newMeteroutputEdittext.setText("");
					}
			}
		});
		
		aButton=(Button)findViewById(R.id.ABTN);
		bButton=(Button)findViewById(R.id.BBTN);
		dButton=(Button)findViewById(R.id.DBTN);
		eButton=(Button)findViewById(R.id.EBTN);
		
       aButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(!isAButton)
				{
					if(clickcount<3)
					{
						setBackground(aButton, isAButton);
						isAButton=true;
						clickcount++;

						eButton.setEnabled(false);
					}//end of if
					
				}
				else
				{
					setBackground(aButton, isAButton);
					isAButton=false;
					clickcount--;
					eButton.setEnabled(true);
				}
				if(!aEdittext.getText().toString().equals("")&&!bEdittext.getText().toString().equals("")&&!cEdittext.getText().toString().equals("")&&!dEdittext.getText().toString().equals("")&&!eEdittext.getText().toString().equals("")&&!AreEdittext.getText().toString().equals(""))
				{
					CalculateValue();
				}//end of if
				else
				{
					OUTPUTEdittext.setText("");
					newMeteroutputEdittext.setText("");
				}
			}
		});
		
		bButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(!isBButton)
				{
					
					if(clickcount<3)
					{
						setBackground(bButton, isBButton);
						isBButton=true;
						clickcount++;

						
						dButton.setEnabled(false);
					}//end of if
				
				}
				else
				{
					setBackground(bButton, isBButton);
					isBButton=false;
					clickcount--;
					dButton.setEnabled(true);
				}
				if(!aEdittext.getText().toString().equals("")&&!bEdittext.getText().toString().equals("")&&!cEdittext.getText().toString().equals("")&&!dEdittext.getText().toString().equals("")&&!eEdittext.getText().toString().equals("")&&!AreEdittext.getText().toString().equals(""))
				{
					CalculateValue();
				}//end of if
				else
				{
					OUTPUTEdittext.setText("");
					newMeteroutputEdittext.setText("");
				}
			}
		});
		
		dButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(!isDButton)
				{
					if(clickcount<3)
					{
						setBackground(dButton, isDButton);
						isDButton=true;
						clickcount++;
						
						
						bButton.setEnabled(false);
					}//end of if
				
				}
				else
				{
					setBackground(dButton, isDButton);
					isDButton=false;
					clickcount--;
					bButton.setEnabled(true);
				}
				if(!aEdittext.getText().toString().equals("")&&!bEdittext.getText().toString().equals("")&&!cEdittext.getText().toString().equals("")&&!dEdittext.getText().toString().equals("")&&!eEdittext.getText().toString().equals("")&&!AreEdittext.getText().toString().equals(""))
				{
					CalculateValue();
				}//end of if
				else
				{
					OUTPUTEdittext.setText("");
					newMeteroutputEdittext.setText("");
				}
			}
		});
		
       eButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(!isEButton)
				{
					
					if(clickcount<3)
					{
						setBackground(eButton, isEButton);
						isEButton=true;
						clickcount++;
					
						aButton.setEnabled(false);
					}//end of if

				}
				else
				{
					setBackground(eButton, isEButton);
					isEButton=false;
					clickcount--;
					aButton.setEnabled(true);
				}
				if(!aEdittext.getText().toString().equals("")&&!bEdittext.getText().toString().equals("")&&!cEdittext.getText().toString().equals("")&&!dEdittext.getText().toString().equals("")&&!eEdittext.getText().toString().equals("")&&!AreEdittext.getText().toString().equals(""))
				{
					CalculateValue();
				}//end of if
				else
				{
					OUTPUTEdittext.setText("");
					newMeteroutputEdittext.setText("");
				}
			}
		});
		
		Button Clearbtn=(Button)findViewById(R.id.CLEARBTN);
		Clearbtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				aEdittext.setText("");
				bEdittext.setText("");
				cEdittext.setText("");
				dEdittext.setText("");
				eEdittext.setText("");
				AreEdittext.setText("");
				OUTPUTEdittext.setText("");
				newAreEdittext.setText("");
				
				btn_addtipan.setTextColor(Color.parseColor("#f40a21"));
				isPlusButton=false;
				btn_minustipan.setTextColor(Color.parseColor("#f40a21"));
				isMinusButton=false;
				
				for (int i = 0; i <5; i++) {
					singleton.newAarray[i]=0;
					singleton.newBarray[i]=0;
					singleton.newCarray[i]=0;
					singleton.newminusAarray[i]=0;
					singleton.newminusBarray[i]=0;
					singleton.newminusCarray[i]=0;
					singleton.newSELECTEDSIGN="";
				}
				
				clickcount=1;
				aButton.setEnabled(true);
				bButton.setEnabled(true);
				dButton.setEnabled(true);
				eButton.setEnabled(true);
				isEButton=true;
				isAButton=true;
				isDButton=true;
				isBButton=true;
				setBackground(aButton, isAButton);
				setBackground(dButton, isDButton);
				setBackground(bButton, isBButton);
				setBackground(eButton, isEButton);
				isAButton=false;
				isDButton=false;
				isBButton=false;
				isEButton=false;
				
				isAreTextview=true;
				isSqmTextview=false;
				final int sdk = android.os.Build.VERSION.SDK_INT;
				  if(sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
					  Uptextview8.setBackgroundDrawable( getResources().getDrawable(R.drawable.green_rounded_xml) );
			    	} else {
			    		Uptextview8.setBackground( getResources().getDrawable(R.drawable.green_rounded_xml));
				     }
				  
				  if(sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
					  Uptextview7.setBackgroundDrawable( getResources().getDrawable(R.drawable.red_rounded_xml) );
			    	} else {
			    		Uptextview7.setBackground( getResources().getDrawable(R.drawable.red_rounded_xml));
				     }
				
			}
		});
		
		//sakliEdittext.setRawInputType(Configuration.KEYBOARD_12KEY);
		
		newAreEdittext.addTextChangedListener(new TextWatcher() {
			public void afterTextChanged(Editable s) {
				// Abstract Method of TextWatcher Interface.
			}
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// Abstract Method of TextWatcher Interface.
			}

			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				try {
					
				
				if(!newAreEdittext.getText().toString().equals(""))
				{
					double temp=0;
					int len=0;
					if(!newAreEdittext.getText().toString().equals(""))
					{
					 len=newAreEdittext.getText().toString().length();
					
					if(!Character.toString(newAreEdittext.getText().toString().charAt(len-1)).equalsIgnoreCase("."))
						temp=Double.valueOf(newAreEdittext.getText().toString());
					}
					if(temp>0)
					if(temp<100011)
					{
						if(!newAreEdittext.getText().toString().equals("")&&!aEdittext.getText().toString().equals("")&&!bEdittext.getText().toString().equals("")&&!cEdittext.getText().toString().equals("")&&!dEdittext.getText().toString().equals("")&&!eEdittext.getText().toString().equals("")&&!AreEdittext.getText().toString().equals(""))
						{
							CalculateValue();
						}//end of if
						else
						{
							OUTPUTEdittext.setText("");
							newMeteroutputEdittext.setText("");
						}
					}
					else
					{
						AlertDialog.Builder builder = new AlertDialog.Builder(
								NewMazashortcut.this);
						builder.setTitle("BHUMI");
						builder.setMessage("Enter value lessthan 10,000")
								.setCancelable(false)
								.setPositiveButton("OK",
										new DialogInterface.OnClickListener() {
											public void onClick(
													DialogInterface dialog, int id) {
												// do things
												newAreEdittext.setText("");
											}
										});
						AlertDialog alert = builder.create();
						alert.show();
                    }//end of else
					
				}//end of outerif
				else
				{
					OUTPUTEdittext.setText("");
					newMeteroutputEdittext.setText("");
				}
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		});//end of listner
		
		aEdittext.addTextChangedListener(new TextWatcher() {
			public void afterTextChanged(Editable s) {
				// Abstract Method of TextWatcher Interface.
			}
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// Abstract Method of TextWatcher Interface.
			}

			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				try{
				if(!newAreEdittext.getText().toString().equals("")&&!aEdittext.getText().toString().equals("")&&!bEdittext.getText().toString().equals("")&&!cEdittext.getText().toString().equals("")&&!dEdittext.getText().toString().equals("")&&!eEdittext.getText().toString().equals("")&&!AreEdittext.getText().toString().equals(""))
				{
					CalculateValue();
				}//end of if
				else
				{
					OUTPUTEdittext.setText("");
					newMeteroutputEdittext.setText("");
				}
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		});//end of listner
		
		bEdittext.addTextChangedListener(new TextWatcher() {
			public void afterTextChanged(Editable s) {
				// Abstract Method of TextWatcher Interface.
			}
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// Abstract Method of TextWatcher Interface.
			}

			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				try{
					if(!newAreEdittext.getText().toString().equals("")&&!aEdittext.getText().toString().equals("")&&!bEdittext.getText().toString().equals("")&&!cEdittext.getText().toString().equals("")&&!dEdittext.getText().toString().equals("")&&!eEdittext.getText().toString().equals("")&&!AreEdittext.getText().toString().equals(""))
					{
						CalculateValue();
					}//end of if
					else
					{
						OUTPUTEdittext.setText("");
						newMeteroutputEdittext.setText("");
					}
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
			}
		});//end of listner
		
		cEdittext.addTextChangedListener(new TextWatcher() {
			public void afterTextChanged(Editable s) {
				// Abstract Method of TextWatcher Interface.
			}
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// Abstract Method of TextWatcher Interface.
			}

			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				try{
					if(!newAreEdittext.getText().toString().equals("")&&!aEdittext.getText().toString().equals("")&&!bEdittext.getText().toString().equals("")&&!cEdittext.getText().toString().equals("")&&!dEdittext.getText().toString().equals("")&&!eEdittext.getText().toString().equals("")&&!AreEdittext.getText().toString().equals(""))
					{
						CalculateValue();
					}//end of if
					else
					{
						OUTPUTEdittext.setText("");
						newMeteroutputEdittext.setText("");
					}
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
			}
		});//end of listner
		
		dEdittext.addTextChangedListener(new TextWatcher() {
			public void afterTextChanged(Editable s) {
				// Abstract Method of TextWatcher Interface.
			}
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// Abstract Method of TextWatcher Interface.
			}

			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				try{
					if(!newAreEdittext.getText().toString().equals("")&&!aEdittext.getText().toString().equals("")&&!bEdittext.getText().toString().equals("")&&!cEdittext.getText().toString().equals("")&&!dEdittext.getText().toString().equals("")&&!eEdittext.getText().toString().equals("")&&!AreEdittext.getText().toString().equals(""))
					{
						CalculateValue();
					}//end of if
					else
					{
						OUTPUTEdittext.setText("");
						newMeteroutputEdittext.setText("");
					}
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
			}
		});//end of listner
		
		eEdittext.addTextChangedListener(new TextWatcher() {
			public void afterTextChanged(Editable s) {
				// Abstract Method of TextWatcher Interface.
			}
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// Abstract Method of TextWatcher Interface.
			}

			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				try{
					if(!newAreEdittext.getText().toString().equals("")&&!aEdittext.getText().toString().equals("")&&!bEdittext.getText().toString().equals("")&&!cEdittext.getText().toString().equals("")&&!dEdittext.getText().toString().equals("")&&!eEdittext.getText().toString().equals("")&&!AreEdittext.getText().toString().equals(""))
					{
						CalculateValue();
					}//end of if
					else
					{
						OUTPUTEdittext.setText("");
						newMeteroutputEdittext.setText("");
					}
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
			}
		});//end of listner
		
		AreEdittext.addTextChangedListener(new TextWatcher() {
			public void afterTextChanged(Editable s) {
				// Abstract Method of TextWatcher Interface.
			}
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// Abstract Method of TextWatcher Interface.
			}

			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				try {
					
				
				if(!AreEdittext.getText().toString().equals(""))
				{
					double temp=0;
					int len=0;
					if(!AreEdittext.getText().toString().equals(""))
					{
					 len=AreEdittext.getText().toString().length();
					
					if(!Character.toString(AreEdittext.getText().toString().charAt(len-1)).equalsIgnoreCase("."))
					 temp=Double.valueOf(AreEdittext.getText().toString());
					}
					
					if(temp<100011)
					{
						if(!newAreEdittext.getText().toString().equals("")&&!aEdittext.getText().toString().equals("")&&!bEdittext.getText().toString().equals("")&&!cEdittext.getText().toString().equals("")&&!dEdittext.getText().toString().equals("")&&!eEdittext.getText().toString().equals("")&&!AreEdittext.getText().toString().equals(""))
						{
							CalculateValue();
						}//end of if
						else
						{
							OUTPUTEdittext.setText("");
							newMeteroutputEdittext.setText("");
						}
					}
					else
					{
						AlertDialog.Builder builder = new AlertDialog.Builder(
								NewMazashortcut.this);
						builder.setTitle("BHUMI");
						builder.setMessage("Enter value lessthan 10,000")
								.setCancelable(false)
								.setPositiveButton("OK",
										new DialogInterface.OnClickListener() {
											public void onClick(
													DialogInterface dialog, int id) {
												// do things
												AreEdittext.setText("");
											}
										});
						AlertDialog alert = builder.create();
						alert.show();
                    }//end of else
					
				}//end of outerif
				else
				{
					OUTPUTEdittext.setText("");
					newMeteroutputEdittext.setText("");
				}
				} catch (Exception e) {
					// TODO: handle exception
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
		int length=aEdittext.getText().toString().length();
		int length2=bEdittext.getText().toString().length();
		int length3=cEdittext.getText().toString().length();
		int length4=dEdittext.getText().toString().length();
		int length5=eEdittext.getText().toString().length();
		int length6=AreEdittext.getText().toString().length();
		int length7=newAreEdittext.getText().toString().length();
		
		if(length>0&&length2>0&&length3>0&&length4>0&&length5>0&&length6>0&&length7>0)
		{
		if(!Character.toString(aEdittext.getText().toString().charAt(length-1)).equalsIgnoreCase(".")&&!Character.toString(bEdittext.getText().toString().charAt(length2-1)).equalsIgnoreCase(".")&&!Character.toString(cEdittext.getText().toString().charAt(length3-1)).equalsIgnoreCase(".")&&!Character.toString(dEdittext.getText().toString().charAt(length4-1)).equalsIgnoreCase(".")&&!Character.toString(eEdittext.getText().toString().charAt(length5-1)).equalsIgnoreCase(".")&&!Character.toString(AreEdittext.getText().toString().charAt(length6-1)).equalsIgnoreCase(".")&&!Character.toString(newAreEdittext.getText().toString().charAt(length7-1)).equalsIgnoreCase("."))
		{
			NumberFormat formatter = new DecimalFormat("#0.00");
			NumberFormat formatter2 = new DecimalFormat("#0.00");
			//Latitude=formatter.format(latitude);
			
			double temp1=(Double.valueOf(aEdittext.getText().toString()));
			double temp2=(Double.valueOf(bEdittext.getText().toString()));
			double temp3=Double.valueOf(cEdittext.getText().toString());
			double temp4=(Double.valueOf(dEdittext.getText().toString()));
			double temp5=(Double.valueOf(eEdittext.getText().toString()));
			double temp6=Double.valueOf(AreEdittext.getText().toString());
			double neware=Double.valueOf(newAreEdittext.getText().toString());
			
			double tempS1=(temp1+temp2+temp3)/2;
			double tempS2=(temp3+temp4+temp5)/2;
			
			double tempA1= tempS1*(tempS1-temp1)*(tempS1-temp2)*(tempS1-temp3);
			double tempA2= tempS2*(tempS2-temp3)*(tempS2-temp4)*(tempS2-temp5);
			
			double tempSUM=Double.valueOf(formatter2.format(Math.sqrt(tempA1)+Math.sqrt(tempA2)));
			if(neware>0)
			if(tempSUM>0)
			{
				double temp91=1/(neware/1000);
				double temp101=(temp91*temp91);
				
				if(isAreTextview)
					temp6=temp101*temp6*100;
				
				if(isSqmTextview)
					temp6=(temp101*temp6);
				
				if(isPlusButton)
				{
					tempSUM=tempSUM+Double.valueOf(formatter2.format(ADDMAZATOTAL));
					System.out.println("/n*******plus");
				}
				
			double temp7=0;
			
			temp7=(temp6)-(tempSUM);
			
			if(isMinusButton)
			{
				temp7=((temp6)+Double.valueOf(formatter2.format(ADDMAZATOTAL)))-(tempSUM);
			}
			
			double divSUM=0;
			
			if(isAButton)
				divSUM+=temp1;
			
			if(isBButton)
			divSUM+=temp2;
			
			if(isDButton)
				divSUM+=temp4;
			
			if(isEButton)
				divSUM+=temp5;
				
			if(divSUM>0)
			{
			//double temp8=temp7/divSUM;
//				divSUM=196;
//				temp7=2024;
				
			double temp8=0;
			int tempcount=0;
			NumberFormat formatter3 = new DecimalFormat("#.00");
			
			if(temp7>=0)
			{
				temp8=divSUM+1;
				int temp9=0;
				while(temp9>=0)
				{
					temp9=(int) (temp7-temp8);
					if(temp9>=0)
					{
						temp7-=temp8;
						temp8+=2;
						tempcount++;
					}
					
				}//end of while
				
				double meteroutput=(neware/1000)*Double.valueOf(""+tempcount+formatter3.format(temp7/temp8));
				newMeteroutputEdittext.setText(""+formatter.format(meteroutput));
				OUTPUTEdittext.setText(""+tempcount+formatter3.format(temp7/temp8));
			}//end of  + ve
			else
			{
				temp8=divSUM+1;
				int temp9=0;
				temp7=Math.abs(temp7);
				
				while(temp9>=0)
				{
					temp9=(int) (temp7-temp8);
					if(temp9>=0)
					{
						temp7-=temp8;
						temp8+=2;
						tempcount++;
					}
					
				}//end of while
				double meteroutput=(neware/1000)*Double.valueOf("-"+tempcount+formatter3.format(temp7/temp8));
				newMeteroutputEdittext.setText(""+formatter.format(meteroutput));
				OUTPUTEdittext.setText("-"+tempcount+formatter3.format(temp7/temp8));
			}//end of else - ve

		//	OUTPUTEdittext.setText(""+formatter2.format(temp8));
			}
			else
			{
				OUTPUTEdittext.setText("");
				newMeteroutputEdittext.setText("");
			}
			}
			else
			{
				OUTPUTEdittext.setText("");
				newMeteroutputEdittext.setText("");
			}
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
		
		for (int i = 0; i <5; i++) {
			singleton.newAarray[i]=0;
			singleton.newBarray[i]=0;
			singleton.newCarray[i]=0;
			singleton.newminusAarray[i]=0;
			singleton.newminusBarray[i]=0;
			singleton.newminusCarray[i]=0;
			singleton.newSELECTEDSIGN="";
		}
		
		if (view.getId() == R.id.LANDAREALAYOUT) {
			Intent slideactivity = new Intent(this, LandAreaActivity.class);
			Bundle bndlanimation = 
					ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.animation,R.anim.animation2).toBundle();
			startActivity(slideactivity, bndlanimation);
			
			 finish();
		} else if (view.getId() == R.id.NEWMAZASORTCUTLAYOUT) {
			isExpanded = false;
			new CollapseAnimation(slidingPanel, panelWidth,
					TranslateAnimation.RELATIVE_TO_SELF, 0.75f,
					TranslateAnimation.RELATIVE_TO_SELF, 0.0f, 0, 0.0f, 0, 0.0f,menulayout);
		}else if (view.getId() == R.id.MAZASORTCUTLAYOUT) {
			
			Intent slideactivity = new Intent(this, MazaShortcutActivity.class);
			Bundle bndlanimation = 
					ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.animation,R.anim.animation2).toBundle();
			startActivity(slideactivity, bndlanimation);
			 finish();
		}
		else if (view.getId() == R.id.HECTERTOGUNTHELAYOUT) {
			
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
		} else if (view.getId() == R.id.AAKARFODLAYOUT) {
			Intent slideactivity = new Intent(this, AakarfodeActivity.class);
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
			}else if (view.getId() == R.id.JANTRILayout) {
				Intent slideactivity = new Intent(this, JantriActivity.class);
				Bundle bndlanimation = 
						ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.animation,R.anim.animation2).toBundle();
				startActivity(slideactivity, bndlanimation);
			}
	}// end of menu


	@SuppressLint("NewApi") public void setBackground(Button button,boolean istrue)
	{
		//Button button1=new Button(getApplicationContext());
		final int sdk = android.os.Build.VERSION.SDK_INT;
		
		if(!istrue)
		{
		  if(sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
	 		button.setBackgroundDrawable( getResources().getDrawable(R.drawable.green_rounded_xml) );
	    	} else {
			button.setBackground( getResources().getDrawable(R.drawable.green_rounded_xml));
		    }
		}
		else
		{
			if(sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
		 		button.setBackgroundDrawable( getResources().getDrawable(R.drawable.red_rounded_xml) );
		    	} else {
				button.setBackground( getResources().getDrawable(R.drawable.red_rounded_xml));
			    }
		}
		
	}//end of fun
}//end of Activity


