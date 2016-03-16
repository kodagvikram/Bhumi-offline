package com.veer.bhumi;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityOptions;
import android.app.AlertDialog;
import android.app.ActionBar.LayoutParams;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
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
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class VasalevarActivity extends Activity {
	FrameLayout mainFrameLyout;
	FrameLayout.LayoutParams menuPanelParameters;
	FrameLayout.LayoutParams slidingPanelParameters;
	LinearLayout.LayoutParams headerPanelParameters;
	LinearLayout.LayoutParams listViewParameters;
	Button menuBtn;
	private DisplayMetrics metrics;
	private RelativeLayout slidingPanel,menulayout;
	int panelWidth = 0;
	int edittextwidth=0,edittextheight=0,totalwidth=0;
	
	private boolean isExpanded,is1000Button=false,is500Button=false,is300Button=false,is2000Button=false,is20Button=false,is480Button=false,is600Button=false;
	
	public double  totalArrayList[]=new double[10];
	public double  totalArrayList600[]=new double[10];
	public double  totalArrayList480[]=new double[10];
	public double  totalArrayList500[]=new double[10];
	public double  totalArrayList300[]=new double[10];
	public double  totalArrayList2000[]=new double[10];
	public double  totalArrayList20[]=new double[10];
	public double  totalArrayLista[]=new double[10];
	public double  totalArrayListb[]=new double[10];
	public double  totalArrayListc[]=new double[10];
	
	//public double  totalArrayList[]=new double[10];
	
	String SCALESELECTED="";
	
	@Override
	public void onBackPressed() {
		Constants.killAll();
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.vasalevar);
		try{
		Constants.activity_stack.add(this);
		metrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);
		panelWidth = (int) ((metrics.widthPixels) * 0.75);
		edittextwidth= (int) ((metrics.widthPixels) * 0.22);
		edittextheight=(int) ((metrics.widthPixels) * 0.18);
		totalwidth=(int) ((metrics.widthPixels) * 0.35);
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
		try {
			setListValues();
			final EditText  TotalEdittext=(EditText)findViewById(R.id.OUTPUTTRIANGLE);
			final EditText  TotalEdittext2=(EditText)findViewById(R.id.OUTPUTTRIANGLE2);
			final EditText  TotalEdittext3=(EditText)findViewById(R.id.OUTPUTTRIANGLE3);
			final EditText  TotalEdittext4=(EditText)findViewById(R.id.OUTPUTTRIANGLE4);
			final EditText  TotalEdittext5=(EditText)findViewById(R.id.OUTPUTTRIANGLE5);
			final EditText  TotalEdittext6=(EditText)findViewById(R.id.OUTPUTTRIANGLE6);
			final EditText  TotalEdittext7=(EditText)findViewById(R.id.OUTPUTTRIANGLE7);
			
			final TextView Uptextview=(TextView)findViewById(R.id.HECTAREtextview21);
			final TextView Uptextview1=(TextView)findViewById(R.id.HECTAREtextview23);
			final TextView Uptextview2=(TextView)findViewById(R.id.HECTAREtextview25);
			final TextView Uptextview3=(TextView)findViewById(R.id.HECTAREtextview27);
			final TextView Uptextview4=(TextView)findViewById(R.id.HECTAREtextview29);
			final TextView Uptextview5=(TextView)findViewById(R.id.HECTAREtextview32);
			final TextView Uptextview6=(TextView)findViewById(R.id.HECTAREtextview33);
			
			final TextView Uptextview7=(TextView)findViewById(R.id.MAZASHORTCUTTextview4);
			final TextView Uptextview8=(TextView)findViewById(R.id.MAZASHORTCUTTextview888);
			
           Uptextview5.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
					setBackground(Uptextview5, false);
					
					setBackground(Uptextview, true);
					setBackground(Uptextview1, true);
					setBackground(Uptextview2, true);
					setBackground(Uptextview3, true);
					setBackground(Uptextview4, true);
					setBackground(Uptextview6, true);
					
					setBackground(Uptextview7, false);
					setBackground(Uptextview8, true);
					
					SCALESELECTED="1:480";
					setListValues();
					
					double sum=0;
					for (int i = 0; i <10; i++) {
						sum=sum+(totalArrayList480[i]);
					}
					
					NumberFormat formatter = new DecimalFormat("#0.00");
				    TotalEdittext6.setText(""+formatter.format(sum));
				}
			});
			
        
        Uptextview6.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				setBackground(Uptextview6, false);
				
				setBackground(Uptextview, true);
				setBackground(Uptextview1, true);
				setBackground(Uptextview2, true);
				setBackground(Uptextview3, true);
				setBackground(Uptextview4, true);
				setBackground(Uptextview5, true);
				
				setBackground(Uptextview7, false);
				setBackground(Uptextview8, true);
				
				SCALESELECTED="1:600";
				setListValues();
				
				double sum=0;
				for (int i = 0; i <10; i++) {
					sum=sum+(totalArrayList600[i]);
				}
				
				NumberFormat formatter = new DecimalFormat("#0.00");
			    TotalEdittext7.setText(""+formatter.format(sum));
			}
		});
			
			Uptextview1.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
                 setBackground(Uptextview1, false);
					
					setBackground(Uptextview, true);
					setBackground(Uptextview5, true);
					setBackground(Uptextview2, true);
					setBackground(Uptextview3, true);
					setBackground(Uptextview4, true);
					setBackground(Uptextview6, true);
					
					setBackground(Uptextview7, false);
					setBackground(Uptextview8, true);
					SCALESELECTED="1:500";
					setListValues();
					
					double sum=0;
					for (int i = 0; i <10; i++) {
						sum=sum+(totalArrayList500[i]);
					}
					
					NumberFormat formatter = new DecimalFormat("#0.00");
					
				   // TotalEdittext.setText(""+sum);
				    TotalEdittext2.setText(""+formatter.format(sum));
				    //TotalEdittext3.setText(""+formatter.format(sum*9));
				    //TotalEdittext4.setText(""+formatter.format(sum*4));
				   // TotalEdittext5.setText(""+formatter.format(sum*62.7264));
				}
			});
			
       Uptextview2.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
                 setBackground(Uptextview2, false);
					
					setBackground(Uptextview, true);
					setBackground(Uptextview1, true);
					setBackground(Uptextview5, true);
					setBackground(Uptextview3, true);
					setBackground(Uptextview4, true);
					setBackground(Uptextview6, true);
					
					setBackground(Uptextview7, false);
					setBackground(Uptextview8, true);
					
					SCALESELECTED="1:300";
					setListValues();
					double sum=0;
					for (int i = 0; i <10; i++) {
						sum=sum+(totalArrayList300[i]);
					}
					
					NumberFormat formatter = new DecimalFormat("#0.00");
					
				   // TotalEdittext.setText(""+sum);
				    TotalEdittext3.setText(""+formatter.format(sum));
				    //TotalEdittext3.setText(""+formatter.format(sum*9));
				    //TotalEdittext4.setText(""+formatter.format(sum*4));
				   // TotalEdittext5.setText(""+formatter.format(sum*62.7264));
				}
			});
			
       Uptextview3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				setBackground(Uptextview3, false);
				
				setBackground(Uptextview, true);
				setBackground(Uptextview1, true);
				setBackground(Uptextview2, true);
				setBackground(Uptextview5, true);
				setBackground(Uptextview4, true);
				setBackground(Uptextview6, true);
				
				setBackground(Uptextview8, false);
				setBackground(Uptextview7, true);
				
				SCALESELECTED="1:2000";
				setListValues();
				double sum=0;
				for (int i = 0; i <10; i++) {
					sum=sum+(totalArrayList2000[i]);
				}
				
				NumberFormat formatter = new DecimalFormat("#0.00");
				
			   // TotalEdittext.setText(""+sum);
			    TotalEdittext4.setText(""+formatter.format(sum));
			    //TotalEdittext3.setText(""+formatter.format(sum*9));
			    //TotalEdittext4.setText(""+formatter.format(sum*4));
			   // TotalEdittext5.setText(""+formatter.format(sum*62.7264));
			}
		});
       
       Uptextview4.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				setBackground(Uptextview4, false);
				
				setBackground(Uptextview, true);
				setBackground(Uptextview1, true);
				setBackground(Uptextview2, true);
				setBackground(Uptextview3, true);
				setBackground(Uptextview5, true);
				setBackground(Uptextview6, true);
				setBackground(Uptextview8, false);
				setBackground(Uptextview7, true);
				
				SCALESELECTED="1:20";
				setListValues();
				double sum=0;
				for (int i = 0; i <10; i++) {
					sum=sum+(totalArrayList20[i]);
				}
				
				NumberFormat formatter = new DecimalFormat("#0.00");
				
			   // TotalEdittext.setText(""+sum);
			    TotalEdittext5.setText(""+formatter.format(sum));
			    //TotalEdittext3.setText(""+formatter.format(sum*9));
			    //TotalEdittext4.setText(""+formatter.format(sum*4));
			   // TotalEdittext5.setText(""+formatter.format(sum*62.7264));
			}
		});
       
			Button totalbtn=(Button)findViewById(R.id.Trainglebtn);
			totalbtn.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
//					EditText editText=(EditText)findViewById(100);
//					String str=editText.getText().toString();
					
                     setBackground(Uptextview, false);
					
					setBackground(Uptextview5, true);
					setBackground(Uptextview1, true);
					setBackground(Uptextview2, true);
					setBackground(Uptextview3, true);
					setBackground(Uptextview4, true);
					setBackground(Uptextview6, true);
					
					setBackground(Uptextview8, false);
					setBackground(Uptextview7, true);
					SCALESELECTED="";
					setListValues();
					double sum=0;
					for (int i = 0; i <10; i++) {
						sum=sum+totalArrayList[i];
					}
					
					NumberFormat formatter = new DecimalFormat("#0.00");
					
				    TotalEdittext.setText(""+formatter.format(sum));
//				    TotalEdittext2.setText(""+formatter.format(sum*25));
//				    TotalEdittext3.setText(""+formatter.format(sum*9));
//				    TotalEdittext4.setText(""+formatter.format(sum*4));
//				    TotalEdittext5.setText(""+formatter.format(sum*62.7264));
				    
				}
			});
			
			Uptextview.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
//					EditText editText=(EditText)findViewById(100);
//					String str=editText.getText().toString();
					
                     setBackground(Uptextview, false);
					
					setBackground(Uptextview5, true);
					setBackground(Uptextview1, true);
					setBackground(Uptextview2, true);
					setBackground(Uptextview3, true);
					setBackground(Uptextview4, true);
					setBackground(Uptextview6, true);
					
					setBackground(Uptextview8, false);
					setBackground(Uptextview7, true);
					
					SCALESELECTED="";
					setListValues();
					double sum=0;
					for (int i = 0; i <10; i++) {
						sum=sum+totalArrayList[i];
					}
					
					NumberFormat formatter = new DecimalFormat("#0.00");
					
				    TotalEdittext.setText(""+formatter.format(sum));
//				    TotalEdittext2.setText(""+formatter.format(sum*25));
//				    TotalEdittext3.setText(""+formatter.format(sum*9));
//				    TotalEdittext4.setText(""+formatter.format(sum*4));
//				    TotalEdittext5.setText(""+formatter.format(sum*62.7264));
				    
				}
			});
			
			Button clearbtn=(Button)findViewById(R.id.CLEARBTN);
			clearbtn.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
//					EditText editText=(EditText)findViewById(100);
//					String str=editText.getText().toString();
					SCALESELECTED="";
					
					for (int i = 0; i <10; i++) {
						totalArrayList[i]=0;
						totalArrayList500[i]=0;
						totalArrayList600[i]=0;
						totalArrayList480[i]=0;
						totalArrayList2000[i]=0;
						totalArrayList300[i]=0;
						totalArrayList20[i]=0;
						totalArrayLista[i]=0;
						totalArrayListb[i]=0;
						totalArrayListc[i]=0;
					}
				    TotalEdittext.setText("0");
				    TotalEdittext2.setText("0");
				    TotalEdittext3.setText("0");
				    TotalEdittext4.setText("0");
				    TotalEdittext5.setText("0");
				    TotalEdittext6.setText("0");
				    TotalEdittext7.setText("0");
				    setListValues();
				}
			});
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}// end of oncreate()
	
	
	@SuppressLint("NewApi")
	public void onMenuOptionClicked(View view) {
		if (view.getId() == R.id.LANDAREALAYOUT) {
			Intent slideactivity = new Intent(this, LandAreaActivity.class);
			Bundle bndlanimation = 
					ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.animation,R.anim.animation2).toBundle();
			startActivity(slideactivity, bndlanimation);
			
			 finish();
		} else if (view.getId() == R.id.VASALEVARLAYOUT) {
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
			
    RelativeLayout mainlayout = (RelativeLayout) findViewById(R.id.ParentLayout);
    mainlayout.removeAllViews();
    Typeface type = Typeface.createFromAsset(VasalevarActivity.this.getAssets(),"fonts/calibribold.ttf");	
    Typeface type2 = Typeface.createFromAsset(VasalevarActivity.this.getAssets(),"fonts/calibri.ttf");	
    for (int i = 0; i <10; i++) {
			
			//final ChatGroupVO groupVO=usergroupArrayList.get(i);

			// ******************************************
			RelativeLayout layout= new RelativeLayout(this);
			layout.setId(100+i);
			RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
			layoutParams.topMargin=2;
			//layoutParams.bottomMargin=100;
			if(i!=0)
			layoutParams.addRule(RelativeLayout.BELOW,99+i);
			
			layout.setBackgroundResource(R.drawable.lightborder);
			layout.setLayoutParams(layoutParams);
			//layout.setBackgroundResource(R.drawable.lightborder);

			RelativeLayout.LayoutParams params1 = new RelativeLayout.LayoutParams(edittextwidth,edittextheight);
			RelativeLayout.LayoutParams params2 = new RelativeLayout.LayoutParams(edittextwidth,edittextheight);
			RelativeLayout.LayoutParams params3 = new RelativeLayout.LayoutParams(edittextwidth,edittextheight);
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
//			 tv1.setText("a");
            
			final EditText editText1=new EditText(this);
			params1.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
			//params1.addRule(RelativeLayout.BELOW,tv1.getId());
			params1.topMargin=1;
			editText1.setId(100+i);
			editText1.setBackgroundResource(R.drawable.roundes_edittext_border);
			editText1.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
			editText1.setFilters(new InputFilter[] {new InputFilter.LengthFilter(maxLength)});
			editText1.setGravity(Gravity.CENTER | Gravity.BOTTOM);
//			final TextView tv2 = new TextView(this);
//			params6.addRule(RelativeLayout.RIGHT_OF,editText1.getId());
//			params6.leftMargin=30;
//			tv2.setId(2000+i);
//			tv2.setTextSize(20);
//			tv2.setTextColor(Color.parseColor("#000000"));
//			 tv2.setTypeface(type);
//			 tv2.setText("b");
            
			final EditText editText2=new EditText(this);
			params2.addRule(RelativeLayout.RIGHT_OF,editText1.getId());
		//	params2.addRule(RelativeLayout.BELOW,tv2.getId());
			params2.topMargin=1;
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
            
			final EditText editText3=new EditText(this);
			params3.addRule(RelativeLayout.RIGHT_OF,editText2.getId());
			//params3.addRule(RelativeLayout.BELOW,tv3.getId());
			params3.topMargin=1;
			editText3.setId(300+i);
			editText3.setBackgroundResource(R.drawable.roundes_edittext_border);
			editText3.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
			editText3.setFilters(new InputFilter[] {new InputFilter.LengthFilter(maxLength)});
			editText3.setGravity(Gravity.CENTER | Gravity.BOTTOM);
//			final TextView tv4 = new TextView(this);
//			params8.addRule(RelativeLayout.RIGHT_OF,editText3.getId());
//			params8.leftMargin=30;
//			tv4.setId(4000+i);
//			tv4.setTextSize(20);
//			tv4.setTextColor(Color.parseColor("#000000"));
//			 tv4.setTypeface(type);
//			 tv4.setText("Are");
            
			final EditText editText4=new EditText(this);
			params4.addRule(RelativeLayout.RIGHT_OF,editText3.getId());
			//params4.addRule(RelativeLayout.BELOW,tv4.getId());
			params4.topMargin=1;
			editText4.setId(400+i);
			editText4.setText("0");
			editText4.setGravity(Gravity.CENTER);
			editText4.setBackgroundResource(R.drawable.roundes_edittext_border);
			editText4.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
			editText4.setGravity(Gravity.CENTER | Gravity.BOTTOM);
			layout.addView(editText1, params1);
			//layout.addView(tv1, params5);
			layout.addView(editText2, params2);
			//layout.addView(tv2, params6);
			layout.addView(editText3, params3);
			//layout.addView(tv3, params7);
			layout.addView(editText4, params4);
			//layout.addView(tv4, params8);
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
					if(!editText1.getText().toString().equals("")||!editText2.getText().toString().equals(""))
					{
						double temp=0;
						int len=0;
						if(!editText1.getText().toString().equals(""))
						{
						 len=editText1.getText().toString().length();
						
						if(!Character.toString(editText1.getText().toString().charAt(len-1)).equalsIgnoreCase("."))
						 temp=Double.valueOf(editText1.getText().toString());
						}
						
						if(temp<1000)
						{
							totalArrayLista[k]=temp;
							if(!editText3.getText().toString().equals(""))
							{
								CalculateValue(editText1, editText2, editText3, editText4,k);
							}//end of if
							else
								editText4.setText("0");
						}
						else
						{
							AlertDialog.Builder builder = new AlertDialog.Builder(
									VasalevarActivity.this);
							builder.setTitle("BHUMI");
							builder.setMessage("Enter value lessthan 1000")
									.setCancelable(false)
									.setPositiveButton("OK",
											new DialogInterface.OnClickListener() {
												public void onClick(
														DialogInterface dialog, int id) {
													// do things
													editText1.setText("");
												}
											});
							AlertDialog alert = builder.create();
							alert.show();
                        }//end of else
						
					}//end of outerif
					else
						editText4.setText("0");

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
					if(!editText2.getText().toString().equals("")||!editText1.getText().toString().equals(""))
					{
						double temp=0;
						int len=0;
						if(!editText2.getText().toString().equals(""))
						{
						 len=editText2.getText().toString().length();
						
						if(!Character.toString(editText2.getText().toString().charAt(len-1)).equalsIgnoreCase("."))
						 temp=Double.valueOf(editText2.getText().toString());
						}
						
						if(temp<1000)
						{
							totalArrayListb[k]=temp;
							if(!editText3.getText().toString().equals(""))
							{
								CalculateValue(editText1, editText2, editText3, editText4,k);
							}//end of if
							else
								editText4.setText("0");
						}
						else
						{
							AlertDialog.Builder builder = new AlertDialog.Builder(
									VasalevarActivity.this);
							builder.setTitle("BHUMI");
							builder.setMessage("Enter value lessthan 1000")
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
						editText4.setText("0");

				}
			});//end of listner
			editText3.addTextChangedListener(new TextWatcher() {
				public void afterTextChanged(Editable s) {
					// Abstract Method of TextWatcher Interface.
				}

				public void beforeTextChanged(CharSequence s, int start, int count,
						int after) {
					// Abstract Method of TextWatcher Interface.
				}

				public void onTextChanged(CharSequence s, int start, int before,
						int count) {
					
					if(!editText1.getText().toString().equals("")||!editText2.getText().toString().equals(""))
					{
					
					if(!editText3.getText().toString().equals(""))
					{
						double temp=0;
						int len=editText3.getText().toString().length();
						
						if(!Character.toString(editText3.getText().toString().charAt(len-1)).equalsIgnoreCase("."))
						 temp=Double.valueOf(editText3.getText().toString());
						
						if(temp<1000)
						{
							totalArrayListc[k]=temp;
							if(!editText3.getText().toString().equals(""))
							{
								CalculateValue(editText1, editText2, editText3, editText4,k);
							}//end of if
							else
								editText4.setText("0");
						}
						else
						{
							AlertDialog.Builder builder = new AlertDialog.Builder(
									VasalevarActivity.this);
							builder.setTitle("BHUMI");
							builder.setMessage("Enter value lessthan 1000")
									.setCancelable(false)
									.setPositiveButton("OK",
											new DialogInterface.OnClickListener() {
												public void onClick(
														DialogInterface dialog, int id) {
													// do things
													editText3.setText("");
												}
											});
							AlertDialog alert = builder.create();
							alert.show();
                        }//end of else
						
					}//end of outerif
					else
						editText4.setText("0");
					}
					else
						editText4.setText("0");
				}
			});//end of listner
			//final int k=i;
			editText4.addTextChangedListener(new TextWatcher() {
				public void afterTextChanged(Editable s) {
					// Abstract Method of TextWatcher Interface.
				}

				public void beforeTextChanged(CharSequence s, int start, int count,
						int after) {
					// Abstract Method of TextWatcher Interface.
				}

				public void onTextChanged(CharSequence s, int start, int before,
						int count) {
					if(!editText4.getText().toString().equals(""))
					{
//						totalArrayList[k]= (Double.valueOf(editText4.getText().toString()));
//						totalArrayList500[k]= (Double.valueOf(editText4.getText().toString()));
//						totalArrayList300[k]= (Double.valueOf(editText4.getText().toString()));
//						totalArrayList2000[k]= (Double.valueOf(editText4.getText().toString()));
//						totalArrayList20[k]= (Double.valueOf(editText4.getText().toString()));
						
					}//end of if
				
				}
			});//end of listner
			
			if(totalArrayLista[k]!=0)
			editText1.setText(""+totalArrayLista[k]);
			if(totalArrayListb[k]!=0)
			editText2.setText(""+totalArrayListb[k]);
			if(totalArrayListc[k]!=0)
			editText3.setText(""+totalArrayListc[k]);
			
		}// end of for
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}//end of list values
	//**********************************************************

	public void CalculateValue(EditText a,EditText b,EditText c,EditText outputEdittext,int k)
	{
		try {
		int length=a.getText().toString().length();
		int length2=b.getText().toString().length();
		int length3=c.getText().toString().length();
		if(length3>0)
		{
		//if(!Character.toString(a.getText().toString().charAt(length-1)).equalsIgnoreCase(".")&&!Character.toString(b.getText().toString().charAt(length2-1)).equalsIgnoreCase(".")&&!Character.toString(c.getText().toString().charAt(length3-1)).equalsIgnoreCase("."))
		//{
			NumberFormat formatter = new DecimalFormat("#0.00000000");
			NumberFormat formatter2 = new DecimalFormat("#0.00");
			//Latitude=formatter.format(latitude);
			
			double a1=0,b1=0,c1=0;
			
			if(!a.getText().toString().equals(""))
			 a1=(Double.valueOf(a.getText().toString()));
			if(!b.getText().toString().equals(""))
			 b1=(Double.valueOf(b.getText().toString()));
			if(!c.getText().toString().equals(""))
			 c1=(Double.valueOf(c.getText().toString()));
			
			 double temp=((a1+b1)/2)*c1;
			
		     double s=temp/100;
							
		     String Lastoutput=formatter.format(s);
			 String[] strArray = Lastoutput.split("\\.");
				
			outputEdittext.setText(""+formatter2.format(s));
				totalArrayList[k]= (Double.valueOf(Lastoutput));
				
				if(SCALESELECTED.equalsIgnoreCase("1:500"))
				{
					  String Lastoutput2=formatter.format(s*25);
						String[] strArray2 = Lastoutput2.split("\\.");
				outputEdittext.setText(""+formatter2.format(s*25));
				totalArrayList500[k]= (Double.valueOf(Lastoutput2));
				}
				else if(SCALESELECTED.equalsIgnoreCase("1:300"))
				{
					  String Lastoutput2=formatter.format(s*9);
					  String[] strArray2 = Lastoutput2.split("\\.");
				      outputEdittext.setText(""+formatter2.format(s*9));
				      totalArrayList300[k]= (Double.valueOf(Lastoutput2));
				}else if(SCALESELECTED.equalsIgnoreCase("1:2000"))
				{
					  String Lastoutput2=formatter.format(s*4);
					  String[] strArray2 = Lastoutput2.split("\\.");
				      outputEdittext.setText(""+formatter2.format(s*4));
				      totalArrayList2000[k]= (Double.valueOf(Lastoutput2));
				}else if(SCALESELECTED.equalsIgnoreCase("1:20"))
				{
					  String Lastoutput2=formatter.format(s*62.7264);
					  String[] strArray2 = Lastoutput2.split("\\.");
				      outputEdittext.setText(""+formatter2.format(s*62.7264));
				      totalArrayList20[k]= (Double.valueOf(Lastoutput2));
				}else if(SCALESELECTED.equalsIgnoreCase("1:480"))
				{
					  String Lastoutput2=formatter.format(s*23.04);
					  String[] strArray2 = Lastoutput2.split("\\.");
				      outputEdittext.setText(""+formatter2.format(s*23.04));
				      totalArrayList480[k]= (Double.valueOf(Lastoutput2));
				}else if(SCALESELECTED.equalsIgnoreCase("1:600"))
				{
					  String Lastoutput2=formatter.format(s*36);
					  String[] strArray2 = Lastoutput2.split("\\.");
				      outputEdittext.setText(""+formatter2.format(s*36));
				      totalArrayList600[k]= (Double.valueOf(Lastoutput2));
				}
				
//				totalArrayList300[k]= (Double.valueOf(Lastoutput));
//				totalArrayList2000[k]= (Double.valueOf(Lastoutput));
//				totalArrayList20[k]= (Double.valueOf(Lastoutput));
				
			
			//}
			//else
			//	outputEdittext.setText("0");
			//guntheEdittext.setText(""+n);
			
		 //}//end of if
		}//end of if length
		else
		{
			
		}//end of else
		
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}//end of calculate
	@SuppressLint("NewApi") public void setBackground(TextView button,boolean istrue)
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

}// end of Activity
