package com.veer.bhumi;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import android.annotation.SuppressLint;
import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.app.ActivityOptions;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
public class SamlambActivity extends Activity{
	FrameLayout mainFrameLyout;
	FrameLayout.LayoutParams menuPanelParameters;
	FrameLayout.LayoutParams slidingPanelParameters;
	LinearLayout.LayoutParams headerPanelParameters;
	LinearLayout.LayoutParams listViewParameters;
	Button menuBtn;
	private DisplayMetrics metrics;
	private RelativeLayout slidingPanel,menulayout,SAKHALIMENULAYOUT;
	int panelWidth = 0;
	public EditText  MENUTotalEdittext,MENUTotalEdittext2;
	public ScrollView MenuscrollView;
	public double  totalArrayList[]=new double[10];
	int edittextwidth=0,edittextheight=0,totalwidth=0,imageviewwidth=0,deviceheight=0;
	SharedPreferences sharedPreferences;
	
	private boolean isExpanded;
	double jantria,jantrib,jantric;
	EditText areEdittext,acreEdittext,guntheEdittext,TipanEdittext;
	public EditText a1Edittext,a2Edittext,b1Edittext,b2Editext,c1Edittext,c2Edittext,outputEdittext1,outputEdittext2,UPEdittext1,UPEdittext2,UPEdittext3,UPEdittext4;
	@Override
	public void onBackPressed() {
		Constants.killAll();
	}
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.samlambchaukawnxml);
		try{
			
			sharedPreferences = PreferenceManager
					.getDefaultSharedPreferences(getApplicationContext());
			//sharedPreferences.getString("SUMTOTAL", "0").equalsIgnoreCase("")		
				
		Constants.activity_stack.add(this);
		metrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);
		panelWidth = (int) ((metrics.widthPixels) * 0.80);
		edittextwidth= (int) ((metrics.widthPixels) * 0.20);
		edittextheight=(int) ((metrics.widthPixels) * 0.23);
		imageviewwidth=(int) ((metrics.widthPixels) * 0.05);
		totalwidth=(int) ((metrics.widthPixels) * 0.50);
		
		slidingPanel = (RelativeLayout) findViewById(R.id.mainRelativeLayout);
		slidingPanelParameters = (FrameLayout.LayoutParams) slidingPanel
				.getLayoutParams();
		slidingPanelParameters.width = metrics.widthPixels;
		slidingPanel.setLayoutParams(slidingPanelParameters);

		 menulayout=(RelativeLayout)findViewById(R.id.Layoutmenubaar);
		 menulayout.setVisibility(View.GONE);
		 
		 SAKHALIMENULAYOUT=(RelativeLayout)findViewById(R.id.SAKHALIAANE_MENU_Layout);
		 SAKHALIMENULAYOUT.setVisibility(View.GONE);
		 
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
						
						new Handler().postDelayed(new Runnable() {

							@Override
							public void run() {
								// This method will be executed once the timer is over
								// Start your app main activity
								SAKHALIMENULAYOUT.setVisibility(View.GONE);

							}
						}, 500);
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
		a1Edittext=(EditText)findViewById(R.id.samlambleftinput2);
		a2Edittext=(EditText)findViewById(R.id.samlambleftinput1);
		b1Edittext=(EditText)findViewById(R.id.samlambinput1);
		b2Editext=(EditText)findViewById(R.id.samlambinput2);
		c1Edittext=(EditText)findViewById(R.id.samlambbelowinput2);
		c2Edittext=(EditText)findViewById(R.id.samlambbelowinput1);
		outputEdittext1=(EditText)findViewById(R.id.outputedittext1);
		outputEdittext2=(EditText)findViewById(R.id.outputedittext3);
		
		UPEdittext1=(EditText)findViewById(R.id.UPDATEoutputedittext1);
		UPEdittext2=(EditText)findViewById(R.id.UPEdittext1);
		//areEdittext=(EditText)findViewById(R.id.landareaedittext1);
		acreEdittext=(EditText)findViewById(R.id.HECTERoutput1);
		guntheEdittext=(EditText)findViewById(R.id.HECTERoutput2);
		
		Button btn_addsakli = (Button) findViewById(R.id.ADDSAKLI_BTN);
		//btn_addsakli.setTypeface(font);
		
		final Button btn_addtipan = (Button) findViewById(R.id.ADDTIPANBTN);
		btn_addtipan.setTypeface(font);
		final Button btn_minustipan = (Button) findViewById(R.id.MINUSTIPANBTN);
		btn_minustipan.setTypeface(font);
		
	if(!sharedPreferences.getString("SIGN", "").equals(""))
	if(sharedPreferences.getString("SIGN", "").equalsIgnoreCase("PLUS"))
	{
		btn_addtipan.setTextColor(Color.parseColor("#286118"));
		//btn_minustipan.setTextColor(Color.parseColor("#396094"));
	}
	else if(sharedPreferences.getString("SIGN", "").equalsIgnoreCase("MINUS"))
	{
		//btn_addtipan.setTextColor(Color.parseColor("#286118"));
		btn_minustipan.setTextColor(Color.parseColor("#286118"));
	}
		
		MenuscrollView=(ScrollView)findViewById(R.id.MENUmyscrollview);
		
		final ImageView samamblamb=(ImageView)findViewById(R.id.SAMLAMBIMAGEVIEW);
		final ImageView jantritriangle=(ImageView)findViewById(R.id.JANTRITRIANGLEIMAGEVIEW);
		final ImageView tipantriangle=(ImageView)findViewById(R.id.TIPANTRIANGLEIMAGEVIEW);
		
		
		 TipanEdittext = (EditText)findViewById(R.id.TOTALOUTPUTEDOTTEXT);
		 TipanEdittext = (EditText)findViewById(R.id.TOTALOUTPUTEDOTTEXT);
		 TipanEdittext.addTextChangedListener(new TextWatcher() {
				public void afterTextChanged(Editable s) {
					// Abstract Method of TextWatcher Interface.
				}

				public void beforeTextChanged(CharSequence s, int start, int count,
						int after) {
					// Abstract Method of TextWatcher Interface.
				}

				public void onTextChanged(CharSequence s, int start, int before,
						int count) {
					
					if(!TipanEdittext.getText().toString().equals(""))
					{
						CalculateInverseValue(TipanEdittext, UPEdittext2);
						CalculateValue();
					}//end of if
					else
					{
						UPEdittext2.setText("");
						acreEdittext.setText("");
					   guntheEdittext.setText("");
			     	}
				}
			});//end of listner
		 
		 outputEdittext1.addTextChangedListener(new TextWatcher() {
				public void afterTextChanged(Editable s) {
					// Abstract Method of TextWatcher Interface.
				}
				public void beforeTextChanged(CharSequence s, int start, int count,
						int after) {
					// Abstract Method of TextWatcher Interface.
				}
				public void onTextChanged(CharSequence s, int start, int before,
						int count) {
				  if(!outputEdittext1.getText().toString().equals(""))
					{
						CalculateInverseValue(outputEdittext1, UPEdittext1);
					}//end of if
					else {
						UPEdittext1.setText("");
					}//end of else
				
				}
			});//end of listner
		
		Button tipaltotalbtn=(Button) findViewById(R.id.TOTALBTN);
		tipaltotalbtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				try{
				
					double prevtotal=0;
					
					if(!sharedPreferences.getString("SUMTOTAL", "").equals(""))
						prevtotal	=Double.valueOf(sharedPreferences.getString("SUMTOTAL", "0"));
					
				if(sharedPreferences.getString("SIGN", "PLUS").equalsIgnoreCase("PLUS"))
				{
					double temp=0;
					if(!outputEdittext1.getText().toString().equals(""))
					temp=Double.valueOf(outputEdittext1.getText().toString());
					
					double tempsum=prevtotal+temp;
					
					TipanEdittext.setText(""+tempsum);
				}
				else
				{
					double temp=0;
					if(!outputEdittext1.getText().toString().equals(""))
					temp=Double.valueOf(outputEdittext1.getText().toString());
					
					double tempsum=0;
					if(prevtotal>0)
					 tempsum=prevtotal-temp;
					else 	if(!outputEdittext1.getText().toString().equals(""))
				 tempsum=Double.valueOf(outputEdittext1.getText().toString());
					
					TipanEdittext.setText(""+tempsum);
				}
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		});
		
		btn_addsakli.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				
				setListValues();
				for (int i = 0; i <10; i++) {
					totalArrayList[i]=0;
				}
			    MENUTotalEdittext.setText("0");
			    MENUTotalEdittext2.setText("0");
			    
			    MenuscrollView.smoothScrollTo(0, 0);
				
				if (!isExpanded) {
					isExpanded = true;

					SAKHALIMENULAYOUT.setVisibility(View.VISIBLE);
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
							0, 0.0f,SAKHALIMENULAYOUT);

				}
				
			}
		});
btn_addtipan.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				btn_addtipan.setTextColor(Color.parseColor("#286118"));
				btn_minustipan.setTextColor(Color.parseColor("#396094"));
				
				samamblamb.setVisibility(View.VISIBLE);
				jantritriangle.setVisibility(View.VISIBLE);
				tipantriangle.setVisibility(View.VISIBLE);
				
				SharedPreferences.Editor editor = sharedPreferences
						.edit();
				 editor.putString("SIGN","PLUS");
				 if(!TipanEdittext.getText().toString().equals(""))
				editor.putString("SUMTOTAL",TipanEdittext.getText().toString());
				 else
				editor.putString("SUMTOTAL","0");
				editor.commit();
			}
		});
		
        btn_minustipan.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				btn_addtipan.setTextColor(Color.parseColor("#396094"));
				btn_minustipan.setTextColor(Color.parseColor("#286118"));

				samamblamb.setVisibility(View.VISIBLE);
				jantritriangle.setVisibility(View.VISIBLE);
				tipantriangle.setVisibility(View.VISIBLE);
				
				SharedPreferences.Editor editor = sharedPreferences
						.edit();
				 editor.putString("SIGN","MINUS");
				 if(!TipanEdittext.getText().toString().equals(""))
				editor.putString("SUMTOTAL",TipanEdittext.getText().toString());
				 else
				editor.putString("SUMTOTAL","0");
				editor.commit();
			}
		});
		samamblamb.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
//				Intent intent=new Intent(getApplicationContext(), SamlambActivity.class);
//				startActivity(intent);
				
				Intent slideactivity = new Intent(getApplicationContext(), SamlambActivity.class);
				Bundle bndlanimation = 
						ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.animation,R.anim.animation2).toBundle();
				startActivity(slideactivity, bndlanimation);
				finish();
			}
		});
		
		jantritriangle.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent slideactivity = new Intent(getApplicationContext(), TriangleAreaActivity.class);
				Bundle bndlanimation = 
						ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.animation,R.anim.animation2).toBundle();
				startActivity(slideactivity, bndlanimation);
				finish();
			}
		});
		
		tipantriangle.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				
				Intent slideactivity = new Intent(getApplicationContext(), TipanTriangleActivity.class);
				Bundle bndlanimation = 
						ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.animation,R.anim.animation2).toBundle();
				startActivity(slideactivity, bndlanimation);
				finish();
			}
		});
		

		
		
		a1Edittext.addTextChangedListener(new TextWatcher() {
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
					
				
			  if(!a1Edittext.getText().toString().equals("")&&!a2Edittext.getText().toString().equals(""))
				{
					CalculateValueJANTRI(a1Edittext,a2Edittext,"A");
				}//end of if
				else {
					outputEdittext1.setText("");
			    	outputEdittext2.setText("");
				}//end of else
			  if(!a1Edittext.getText().toString().equals("")&&!a2Edittext.getText().toString().equals("")&&!b1Edittext.getText().toString().equals("")&&!b2Editext.getText().toString().equals("")&&!c1Edittext.getText().toString().equals("")&&!c2Edittext.getText().toString().equals(""))
				{
					CalculateAreDdash();
				}//end of outer if
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		});//end of listner
		
		a2Edittext.addTextChangedListener(new TextWatcher() {
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
				int length2=a2Edittext.getText().toString().length();
				
				if(!a2Edittext.getText().toString().equals(""))
				{
					double x=0;
					if(!Character.toString(a2Edittext.getText().toString().charAt(length2-1)).equalsIgnoreCase("."))
					 x=Double.valueOf(a2Edittext.getText().toString());
					
					if(x>15)
					{
						AlertDialog.Builder builder = new AlertDialog.Builder(
								SamlambActivity.this);
						builder.setTitle("BHUMI");
						builder.setMessage("Enter value less than 15")
								.setCancelable(false)
								.setPositiveButton("OK",
										new DialogInterface.OnClickListener() {
											public void onClick(
													DialogInterface dialog, int id) {
												// do things
												a2Edittext.setText("");
											}
										});
						AlertDialog alert = builder.create();
						alert.show();
						
					}//end of if
					else
					{
						
						if(!a1Edittext.getText().toString().equals("")&&!a2Edittext.getText().toString().equals(""))
						{
							CalculateValueJANTRI(a1Edittext,a2Edittext,"A");
						}//end of if
						else {
							outputEdittext1.setText("");
					    	outputEdittext2.setText("");
						}//end of else
						 if(!a1Edittext.getText().toString().equals("")&&!a2Edittext.getText().toString().equals("")&&!b1Edittext.getText().toString().equals("")&&!b2Editext.getText().toString().equals("")&&!c1Edittext.getText().toString().equals("")&&!c2Edittext.getText().toString().equals(""))
							{
								CalculateAreDdash();
							}//end of outer if
					
					}//end of else
					
				}//end of if
				else {
					outputEdittext1.setText("");
			    	outputEdittext2.setText("");
				}//end of else
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		});//end of listner
		
		b1Edittext.addTextChangedListener(new TextWatcher() {
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
			   if(!b1Edittext.getText().toString().equals("")&&!b2Editext.getText().toString().equals(""))
				{
					CalculateValueJANTRI(b1Edittext,b2Editext,"B");
				}//end of if
				else {
					outputEdittext1.setText("");
			    	outputEdittext2.setText("");
				}//end of else
			   
			   if(!a1Edittext.getText().toString().equals("")&&!a2Edittext.getText().toString().equals("")&&!b1Edittext.getText().toString().equals("")&&!b2Editext.getText().toString().equals("")&&!c1Edittext.getText().toString().equals("")&&!c2Edittext.getText().toString().equals(""))
				{
					CalculateAreDdash();
				}//end of outer if
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		});//end of listner
		
		b2Editext.addTextChangedListener(new TextWatcher() {
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
              int length2=b2Editext.getText().toString().length();
				
				if(!b2Editext.getText().toString().equals(""))
				{
					double x=0;
					if(!Character.toString(b2Editext.getText().toString().charAt(length2-1)).equalsIgnoreCase("."))
					 x=Double.valueOf(b2Editext.getText().toString());
					
					if(x>15)
					{
						AlertDialog.Builder builder = new AlertDialog.Builder(
								SamlambActivity.this);
						builder.setTitle("BHUMI");
						builder.setMessage("Enter value less than 15")
								.setCancelable(false)
								.setPositiveButton("OK",
										new DialogInterface.OnClickListener() {
											public void onClick(
													DialogInterface dialog, int id) {
												// do things
												b2Editext.setText("");
											}
										});
						AlertDialog alert = builder.create();
						alert.show();
						
					}//end of if
					else
					{
						
						 if(!b1Edittext.getText().toString().equals("")&&!b2Editext.getText().toString().equals(""))
							{
								CalculateValueJANTRI(b1Edittext,b2Editext,"B");
							}//end of if
							else {
								outputEdittext1.setText("");
						    	outputEdittext2.setText("");
							}//end of else
						  
						  if(!a1Edittext.getText().toString().equals("")&&!a2Edittext.getText().toString().equals("")&&!b1Edittext.getText().toString().equals("")&&!b2Editext.getText().toString().equals("")&&!c1Edittext.getText().toString().equals("")&&!c2Edittext.getText().toString().equals(""))
							{
								CalculateAreDdash();
							}//end of outer if
					
					}//end of else
					
				}//end of if
				else {
					outputEdittext1.setText("");
			    	outputEdittext2.setText("");
				}//end of else
				
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			 
			}
		});//end of listner
		
		c1Edittext.addTextChangedListener(new TextWatcher() {
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
			 if(!c1Edittext.getText().toString().equals("")&&!c2Edittext.getText().toString().equals(""))
				{
					CalculateValueJANTRI(c1Edittext,c2Edittext,"C");
				}//end of if
				else {
					outputEdittext1.setText("");
			    	outputEdittext2.setText("");
				}//end of else
			 
			 if(!a1Edittext.getText().toString().equals("")&&!a2Edittext.getText().toString().equals("")&&!b1Edittext.getText().toString().equals("")&&!b2Editext.getText().toString().equals("")&&!c1Edittext.getText().toString().equals("")&&!c2Edittext.getText().toString().equals(""))
				{
					CalculateAreDdash();
				}//end of outer if
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		});//end of listner
		
		c2Edittext.addTextChangedListener(new TextWatcher() {
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
            int length2=c2Edittext.getText().toString().length();
				
				if(!c2Edittext.getText().toString().equals(""))
				{
					double x=0;
					if(!Character.toString(c2Edittext.getText().toString().charAt(length2-1)).equalsIgnoreCase("."))
					 x=Double.valueOf(c2Edittext.getText().toString());
					
					if(x>15)
					{
						AlertDialog.Builder builder = new AlertDialog.Builder(
								SamlambActivity.this);
						builder.setTitle("BHUMI");
						builder.setMessage("Enter value less than 15")
								.setCancelable(false)
								.setPositiveButton("OK",
										new DialogInterface.OnClickListener() {
											public void onClick(
													DialogInterface dialog, int id) {
												// do things
												c2Edittext.setText("");
											}
										});
						AlertDialog alert = builder.create();
						alert.show();
						
					}//end of if
					else
					{
						if(!c1Edittext.getText().toString().equals("")&&!c2Edittext.getText().toString().equals(""))
						{
							CalculateValueJANTRI(c1Edittext,c2Edittext,"C");
						}//end of if
						else {
							outputEdittext1.setText("");
					    	outputEdittext2.setText("");
						}//end of else
					 
					 if(!a1Edittext.getText().toString().equals("")&&!a2Edittext.getText().toString().equals("")&&!b1Edittext.getText().toString().equals("")&&!b2Editext.getText().toString().equals("")&&!c1Edittext.getText().toString().equals("")&&!c2Edittext.getText().toString().equals(""))
						{
							CalculateAreDdash();
						}//end of outer if
					
					}//end of else
					
				}//end of if
				else {
					outputEdittext1.setText("");
			    	outputEdittext2.setText("");
				}//end of else
				
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		});//end of listner
		
		
		Button clearbtn=(Button)findViewById(R.id.CLEARBTN);
		clearbtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				SharedPreferences.Editor editor = sharedPreferences
						.edit();
				 editor.putString("SIGN","");
				editor.putString("SUMTOTAL","0");
				editor.commit();
				
				btn_addtipan.setTextColor(Color.parseColor("#396094"));
				btn_minustipan.setTextColor(Color.parseColor("#396094"));
				a1Edittext.setText("");
				a2Edittext.setText("");
		    	
				b1Edittext.setText("");
				b2Editext.setText("");
		    	
				c1Edittext.setText("");
				c2Edittext.setText("");
				
				outputEdittext1.setText("");
		    	outputEdittext2.setText("");
		    	TipanEdittext.setText("");

			}
		});//**************************************END OF SAMALAMB**************
		
		try {
			
			
			Button MENUclearbtn=(Button)findViewById(R.id.MENUCLEARBTN);
			setListValues();
			Button MENUtotalbtn=(Button)findViewById(R.id.MENUTrainglebtn);
			
			final TextView  MENUSaklitextview=(TextView)findViewById(R.id.MENUHECTAREtextview5);
			
			ImageView MENUsakliimage=(ImageView)findViewById(R.id.MENUSAKLIDELDA);
              RelativeLayout.LayoutParams params16 = new RelativeLayout.LayoutParams(imageviewwidth,edittextheight);
			
              params16.addRule(RelativeLayout.BELOW,MENUSaklitextview.getId());
              params16.addRule(RelativeLayout.CENTER_HORIZONTAL);
              params16.topMargin=10;
              params16.rightMargin=10;
              MENUsakliimage.setLayoutParams(params16);
			
		  MENUTotalEdittext=(EditText)findViewById(R.id.MENUOUTPUTTRIANGLE);
		  MENUTotalEdittext2=(EditText)findViewById(R.id.MENUOUTPUTTRIANGLE2);
			
			RelativeLayout.LayoutParams params13 = new RelativeLayout.LayoutParams(edittextwidth,edittextheight);
			
			params13.addRule(RelativeLayout.BELOW,MENUSaklitextview.getId());
			params13.addRule(RelativeLayout.LEFT_OF,MENUsakliimage.getId());
			params13.topMargin=10;
			params13.rightMargin=10;
			MENUTotalEdittext.setLayoutParams(params13);
			
           // final EditText  MENUTotalEdittex2=(EditText)findViewById(R.id.MENUOUTPUTTRIANGLE2);
			
			RelativeLayout.LayoutParams params14 = new RelativeLayout.LayoutParams(edittextwidth,edittextheight);
			
			params14.addRule(RelativeLayout.BELOW,MENUSaklitextview.getId());
			params14.addRule(RelativeLayout.RIGHT_OF,MENUsakliimage.getId());
			params14.topMargin=10;
			params14.rightMargin=10;
			MENUTotalEdittext2.setLayoutParams(params14);
			
		
MENUtotalbtn.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
//					EditText editText=(EditText)findViewById(100);
//					String str=editText.getText().toString();
					double sum=0;
					for (int i = 0; i <10; i++) {
						sum=sum+totalArrayList[i];
					}
					NumberFormat formatter2 = new DecimalFormat("#0.00");
					
					double temp3=sum/16;
					
					String[] strArray = String.valueOf(temp3).split("\\.");
					
					//int n=Integer.parseInt(strArray[0]);
					double m=Double.valueOf("0."+strArray[1]);

					MENUTotalEdittext.setText(""+strArray[0]);			
				    MENUTotalEdittext2.setText(""+formatter2.format(m*16));
					
				}
			});
			
			
			MENUclearbtn.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
//					EditText editText=(EditText)findViewById(100);
//					String str=editText.getText().toString();
					setListValues();
					for (int i = 0; i <10; i++) {
						totalArrayList[i]=0;
					}
				    MENUTotalEdittext.setText("0");
				    MENUTotalEdittext2.setText("0");
					
				}
			});

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		//****************************************END OF ADD SAKHALI
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}// end of oncreate()
	
	public void CalculateAreDdash()
	{
		try {
			NumberFormat formatter = new DecimalFormat("#0.00");
			double temp=(((jantria+jantrib)/2)*jantric)/100;	
			outputEdittext1.setText(""+formatter.format(temp));
			//outputEdittext1.setText(""+jantria+"-"+jantrib+"-"+jantric);
			
			double temp2=0;
			
			if(jantria>jantrib)
				temp2=jantria-jantrib;
			else if(jantrib>jantria)
				temp2=jantrib-jantria;
				
			double temp3=(temp2*temp2)+(jantric*jantric);
			double temp4=Math.sqrt(temp3);
			
			outputEdittext2.setText(""+formatter.format(temp4));
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}//end of calculateAre()
	
	public void CalculateValueJANTRI(EditText a1Edittext,EditText a2Edittext,String SELECTEDEDITTEXT)
	{
		try {
		int length=a1Edittext.getText().toString().length();
		int length2=a2Edittext.getText().toString().length();
		if(length>0&&length2>0)
		{
		if(!Character.toString(a1Edittext.getText().toString().charAt(length-1)).equalsIgnoreCase(".")&&!Character.toString(a2Edittext.getText().toString().charAt(length2-1)).equalsIgnoreCase("."))
		{
			NumberFormat formatter = new DecimalFormat("#0.00000");
			NumberFormat formatter2 = new DecimalFormat("#0.00000");
			//Latitude=formatter.format(latitude);
			double temp=(Double.valueOf(a1Edittext.getText().toString())*16)+(Double.valueOf(a2Edittext.getText().toString()));
			
			String temp2=formatter.format(temp*0.62865);
			
			String[] strArray = temp2.split("\\.");
			int n=Integer.parseInt(strArray[1].substring(0, 2));
			int m=Integer.parseInt(strArray[1].substring(2, 4));
			if(m>50)
				n=n+1;
			String outputstring=strArray[0];
			
			if(n<10)
			outputstring=outputstring+".0"+n;
			else
				outputstring=outputstring+"."+n;	
			
			//outputEdittext.setText(""+outputstring);
			if(SELECTEDEDITTEXT.equalsIgnoreCase("A"))
				jantria=Double.valueOf(outputstring);
			else 	if(SELECTEDEDITTEXT.equalsIgnoreCase("B"))
				jantrib=Double.valueOf(outputstring);
			else 	if(SELECTEDEDITTEXT.equalsIgnoreCase("C"))
				jantric=Double.valueOf(outputstring);
		 }//end of if
		}//end of if length
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}//end of calculate
	@SuppressLint("NewApi")
	public void onMenuOptionClicked(View view) {
		
		SharedPreferences.Editor editor = sharedPreferences
				.edit();
		 editor.putString("SIGN","");
		editor.putString("SUMTOTAL","0");
		editor.commit();
		if (view.getId() == R.id.LANDAREALAYOUT) {
			Intent slideactivity = new Intent(this, LandAreaActivity.class);
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
		} else if (view.getId() == R.id.VASALEVARLAYOUT) {
			Intent slideactivity = new Intent(this, VasalevarActivity.class);
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
				
			} else if (view.getId() == R.id.HECTERTOGUNTHELAYOUT) {
				Intent slideactivity = new Intent(this, HectaretoGuntheActivity.class);
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
	
	
	//**********************************************************
	void setListValues()
	{
		try {
			
    RelativeLayout mainlayout = (RelativeLayout) findViewById(R.id.MENUParentLayout);
    mainlayout.removeAllViews();
    
    RelativeLayout menudoubleline=(RelativeLayout)findViewById(R.id.MENUdlublelinelayout);
	RelativeLayout menudoubleline2=(RelativeLayout)findViewById(R.id.MENUdlublelinelayout2);

	RelativeLayout.LayoutParams layoutParams20 = new RelativeLayout.LayoutParams(totalwidth, 4);
	layoutParams20.topMargin=15;
	layoutParams20.addRule(RelativeLayout.CENTER_HORIZONTAL);
	layoutParams20.addRule(RelativeLayout.BELOW,mainlayout.getId());
	menudoubleline.setBackgroundResource(R.drawable.lightborder);
	menudoubleline.setLayoutParams(layoutParams20);
	
	RelativeLayout.LayoutParams layoutParams21 = new RelativeLayout.LayoutParams(totalwidth, 4);
	layoutParams21.topMargin=5;
	layoutParams21.addRule(RelativeLayout.CENTER_HORIZONTAL);
	layoutParams21.addRule(RelativeLayout.BELOW,menudoubleline.getId());
	menudoubleline2.setBackgroundResource(R.drawable.lightborder);
	menudoubleline2.setLayoutParams(layoutParams21);
    
    Typeface type = Typeface.createFromAsset(SamlambActivity.this.getAssets(),"fonts/calibribold.ttf");	
    Typeface type2 = Typeface.createFromAsset(SamlambActivity.this.getAssets(),"fonts/calibri.ttf");	
    for (int i = 0; i <8; i++) {
			
			//final ChatGroupVO groupVO=usergroupArrayList.get(i);

			// ******************************************
			RelativeLayout layout= new RelativeLayout(this);
			layout.setId(100+i);
			RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			layoutParams.topMargin=5;
			//layoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
			//layoutParams.bottomMargin=100;
			if(i!=0)
			layoutParams.addRule(RelativeLayout.BELOW,99+i);
			
			layout.setBackgroundResource(R.drawable.lightborder);
			layout.setLayoutParams(layoutParams);
			//layout.setBackgroundResource(R.drawable.lightborder);

			RelativeLayout.LayoutParams params1 = new RelativeLayout.LayoutParams(edittextwidth,edittextheight);
			RelativeLayout.LayoutParams params2 = new RelativeLayout.LayoutParams(edittextwidth,edittextheight);
			RelativeLayout.LayoutParams params3 = new RelativeLayout.LayoutParams(imageviewwidth,edittextheight);
			RelativeLayout.LayoutParams params4 = new RelativeLayout.LayoutParams(totalwidth,edittextheight);
			RelativeLayout.LayoutParams params5 = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			RelativeLayout.LayoutParams params6 = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			RelativeLayout.LayoutParams params7 = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			RelativeLayout.LayoutParams params8 = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			//params1.setMargins(5,25,5,55);
			int maxLength = 5;
			params1.leftMargin=3;
			params2.leftMargin=3;
			params3.leftMargin=3;
			params4.leftMargin=3;
			
//			final TextView tv1 = new TextView(this);
//			params5.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
//			params5.leftMargin=30;
//			tv1.setId(1000+i);
//			tv1.setTextSize(20);
//			tv1.setTextColor(Color.parseColor("#000000"));
//			 tv1.setTypeface(type);
//			 tv1.setText("Sakhali");
            
			final EditText editText1=new EditText(this);
			params1.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
		//	params1.addRule(RelativeLayout.BELOW,tv1.getId());
			params1.topMargin=5;
			editText1.setId(100+i);
			editText1.setBackgroundResource(R.drawable.roundes_edittext_border);
			editText1.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
			editText1.setFilters(new InputFilter[] {new InputFilter.LengthFilter(maxLength)});
			editText1.setGravity(Gravity.CENTER | Gravity.BOTTOM);
			final ImageView imageView=new ImageView(this);
			params3.addRule(RelativeLayout.RIGHT_OF,editText1.getId());
			//params3.addRule(RelativeLayout.BELOW,tv1.getId());
			params3.leftMargin=20;
			params3.rightMargin=20;
			imageView.setId(3000+i);
			imageView.setImageResource(R.drawable.deltaimage);
			
			
//			final TextView tv2 = new TextView(this);
//			params6.addRule(RelativeLayout.RIGHT_OF,imageView.getId());
//			params6.leftMargin=30;
//			tv2.setId(2000+i);
//			tv2.setTextSize(20);
//			tv2.setTextColor(Color.parseColor("#000000"));
//			 tv2.setTypeface(type);
//			 tv2.setText("Aane");
            
			final EditText editText2=new EditText(this);
			params2.addRule(RelativeLayout.RIGHT_OF,imageView.getId());
			//params2.addRule(RelativeLayout.BELOW,tv2.getId());
			params2.topMargin=5;
			editText2.setId(200+i);
			editText2.setBackgroundResource(R.drawable.roundes_edittext_border);
			editText2.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
			editText2.setFilters(new InputFilter[] {new InputFilter.LengthFilter(maxLength)});
			editText2.setGravity(Gravity.CENTER | Gravity.BOTTOM);
//			final TextView tv3 = new TextView(this);
//			params7.addRule(RelativeLayout.RIGHT_OF,editText2.getId());
//			params7.leftMargin=30;
//			tv3.setId(3000+i);
//			tv3.setTextSize(20);
//			tv3.setTextColor(Color.parseColor("#000000"));
//			 tv3.setTypeface(type);
//			 tv3.setText("c");
//            
//			final EditText editText3=new EditText(this);
//			params3.addRule(RelativeLayout.RIGHT_OF,editText2.getId());
//			params3.addRule(RelativeLayout.BELOW,tv3.getId());
//			params3.topMargin=5;
//			editText3.setId(300+i);
//			editText3.setBackgroundResource(R.drawable.roundes_edittext_border);
//			editText3.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
//			editText3.setFilters(new InputFilter[] {new InputFilter.LengthFilter(maxLength)});
//			
//			final TextView tv4 = new TextView(this);
//			params8.addRule(RelativeLayout.RIGHT_OF,editText3.getId());
//			params8.leftMargin=30;
//			tv4.setId(4000+i);
//			tv4.setTextSize(20);
//			tv4.setTextColor(Color.parseColor("#000000"));
//			 tv4.setTypeface(type);
//			 tv4.setText("Are");
//            
//			final EditText editText4=new EditText(this);
//			params4.addRule(RelativeLayout.RIGHT_OF,editText3.getId());
//			params4.addRule(RelativeLayout.BELOW,tv4.getId());
//			params4.topMargin=5;
//			editText4.setId(400+i);
//			editText4.setText("0");
//			editText4.setGravity(Gravity.CENTER);
//			editText4.setBackgroundResource(R.drawable.roundes_edittext_border);
//			editText4.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
			
			layout.addView(editText1, params1);
			//layout.addView(tv1, params5);
			layout.addView(editText2, params2);
			//layout.addView(tv2, params6);
			layout.addView(imageView, params3);
//			layout.addView(tv3, params7);
//			layout.addView(editText4, params4);
//			layout.addView(tv4, params8);
			// *******************************************
			mainlayout.addView(layout,layoutParams);
			
			layout.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
				}
			});
			
			final int k=i;
			
			editText1.addTextChangedListener(new TextWatcher() {
				public void afterTextChanged(Editable s) {
					// Abstract Method of TextWatcher Interface.
				}

				public void beforeTextChanged(CharSequence s, int start, int count,
						int after) {
					// Abstract Method of TextWatcher Interface.
				}

				public void onTextChanged(CharSequence s, int start, int before,
						int count) {
					if(!editText1.getText().toString().equals(""))
					{
						double temp=0;
						int len=editText1.getText().toString().length();
						
						if(!Character.toString(editText1.getText().toString().charAt(len-1)).equalsIgnoreCase("."))
						 temp=Double.valueOf(editText1.getText().toString());
						
//						if(temp<40)
//						{
							if(!editText1.getText().toString().equals("")&&!editText2.getText().toString().equals(""))
							{
								CalculateValue(editText1, editText2, k);
							}//end of if
							else
							{
								totalArrayList[k]=0;
//								double sum=0;
//								for (int i = 0; i <10; i++) {
//									sum=sum+totalArrayList[i];
//								}
//								
//							    TotalEdittext.setText(""+sum);
							}//end of else
//						}
//						else
//						{
//							AlertDialog.Builder builder = new AlertDialog.Builder(
//									AddAcreGuntheActivity.this);
//							builder.setTitle("BHUMI");
//							builder.setMessage("Enter value lessthan 39")
//									.setCancelable(false)
//									.setPositiveButton("OK",
//											new DialogInterface.OnClickListener() {
//												public void onClick(
//														DialogInterface dialog, int id) {
//													// do things
//													editText1.setText("");
//												}
//											});
//							AlertDialog alert = builder.create();
//							alert.show();
//                        }//end of else
						
					}//end of outerif
					else
					{
						totalArrayList[k]=0;
//						double sum=0;
//						for (int i = 0; i <10; i++) {
//							sum=sum+totalArrayList[i];
//						}
//						
//					    TotalEdittext.setText(""+sum);
					}//end of else

				}
			});//end of listner
			editText2.addTextChangedListener(new TextWatcher() {
				public void afterTextChanged(Editable s) {
					// Abstract Method of TextWatcher Interface.
				}

				public void beforeTextChanged(CharSequence s, int start, int count,
						int after) {
					// Abstract Method of TextWatcher Interface.
				}

				public void onTextChanged(CharSequence s, int start, int before,
						int count) {
					if(!editText2.getText().toString().equals(""))
					{
						double temp=0;
						int len=editText2.getText().toString().length();
						
						if(!Character.toString(editText2.getText().toString().charAt(len-1)).equalsIgnoreCase("."))
						 temp=Double.valueOf(editText2.getText().toString());
						
						if(temp<16)
						{
							if(!editText1.getText().toString().equals("")&&!editText2.getText().toString().equals(""))
							{
								CalculateValue(editText1, editText2, k);
							}//end of if
							else
							{
								totalArrayList[k]=0;
//								double sum=0;
//								for (int i = 0; i <10; i++) {
//									sum=sum+totalArrayList[i];
//								}
//								
//							    TotalEdittext.setText(""+sum);
							}//end of else
						}
						else
						{
							AlertDialog.Builder builder = new AlertDialog.Builder(
									SamlambActivity.this);
							builder.setTitle("BHUMI");
							builder.setMessage("Enter value lessthan 15")
									.setCancelable(false)
									.setPositiveButton("OK",
											new DialogInterface.OnClickListener() {
												public void onClick(
														DialogInterface dialog, int id) {
													// do things
													editText2.setText("");
												}
											});
							AlertDialog alert = builder.create();
							alert.show();
                        }//end of else
						
					}//end of outerif
					else
					{
						totalArrayList[k]=0;
//						double sum=0;
//						for (int i = 0; i <10; i++) {
//							sum=sum+totalArrayList[i];
//						}
//						
//					    TotalEdittext.setText(""+sum);
					}//end of else
				}
			});//end of listner
			
		}// end of for
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}//end of list values
	//**********************************************************
	
	public void CalculateValue()
	{
		int length=TipanEdittext.getText().toString().length();
		if(length>0)
		{
		if(!Character.toString(TipanEdittext.getText().toString().charAt(length-1)).equalsIgnoreCase("."))
		{
			NumberFormat formatter = new DecimalFormat("#0.00000000");
			NumberFormat formatter2 = new DecimalFormat("#0");
			//Latitude=formatter.format(latitude);
			double temp=Double.valueOf(TipanEdittext.getText().toString())*100;
			String temp2=formatter.format(temp/4046.85642);
			
			String[] strArray = temp2.split("\\.");
			double 	temp3=Double.valueOf("0."+strArray[1]);
			
			double temp4= (temp3*40);
			
//		String temp5=String.valueOf(temp4);
//
//		int n=Integer.parseInt(temp5.substring(0, 2));
//			int m=Integer.parseInt(temp5.substring(2, 3));
//			if(m>5)
//				n=n+1;
			if(temp4>39)
			{
				int 	n=Integer.valueOf(strArray[0]);
				n++;
				strArray[0]=""+n;
				temp4=0;
			}
			
			acreEdittext.setText(""+strArray[0]);
			guntheEdittext.setText(""+formatter2.format(temp4));
			
		 }//end of if
		}//end of if length
		else
		{
			
		}//end of else
		
	}//end of Calculate
	
	public void CalculateInverseValue(EditText acreEdittext,EditText guntheEdittext)
	{
		try {
			
			int length=acreEdittext.getText().toString().length();
			if(length>0)
			{
			if(!Character.toString(acreEdittext.getText().toString().charAt(length-1)).equalsIgnoreCase("."))
			{
				NumberFormat formatter = new DecimalFormat("#0.00");
				NumberFormat formatter2 = new DecimalFormat("#0.0000000");
				//Latitude=formatter.format(latitude);
				double temp=Double.valueOf(acreEdittext.getText().toString())*1076;
				
				String temp2=formatter.format(temp/1089);
				
//				String[] strArray = temp2.split("\\.");
//				
//				double temp3=Double.valueOf("0."+strArray[1]);
//				//double temp5=temp3/2.5;
//				String temp4=formatter2.format(temp3*40);
//
//				String[] strArray2 = temp4.split("\\.");
//				int n=Integer.parseInt(strArray2[0]);
//				int m=Integer.parseInt(strArray2[1].substring(0, 2));
//			 if(m>50)
//				n=n+1;
//			 
//			 if(n>39)
//			 {
//				 n=0;
//				 int x=Integer.parseInt(strArray[0]);
//				 x++;
//				 
//				 strArray[0]=""+x;
//			 }
//				
//			 guntheEdittext.setText(""+strArray[0]);
				
				guntheEdittext.setText(""+temp2);
				
				
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
	
	public void CalculateValue(EditText acreEdittext,EditText guntheEdittext,int pos)
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
				double temp=(Double.valueOf(acreEdittext.getText().toString())*16);
				double temp2=(Double.valueOf(guntheEdittext.getText().toString()));
				
				double temp3=temp+temp2;
				
									
				totalArrayList[pos]=Double.valueOf(formatter2.format(temp3));
				
//				double sum=0;
//				for (int i = 0; i <10; i++) {
//					sum=sum+totalArrayList[i];
//				}
				
			    //TotalEdittext.setText(""+formatter2.format(sum));
				
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

}// end of Activity
