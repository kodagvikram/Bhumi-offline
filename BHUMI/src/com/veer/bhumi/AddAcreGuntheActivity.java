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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
public class AddAcreGuntheActivity extends Activity {
	FrameLayout mainFrameLyout;
	FrameLayout.LayoutParams menuPanelParameters;
	FrameLayout.LayoutParams slidingPanelParameters;
	LinearLayout.LayoutParams headerPanelParameters;
	LinearLayout.LayoutParams listViewParameters;
	Button menuBtn;
	private DisplayMetrics metrics;
	private RelativeLayout slidingPanel,menulayout;
	int panelWidth = 0;
	int edittextwidth=0,edittextheight=0,totalwidth=0,imageviewwidth=0;
	EditText areEdittext,acreEdittext,guntheEdittext,hecteroutputEdittext;
	private boolean isExpanded;
	public double  totalArrayList[]=new double[10];
	public EditText  TotalEdittext;
	@Override
	public void onBackPressed() {
		Constants.killAll();
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.addacregunthexml);
		try{
		Constants.activity_stack.add(this);
		metrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);
		panelWidth = (int) ((metrics.widthPixels) * 0.75);
		edittextwidth= (int) ((metrics.widthPixels) * 0.22);
		edittextheight=(int) ((metrics.widthPixels) * 0.18);
		imageviewwidth=(int) ((metrics.widthPixels) * 0.05);
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
			
			Button clearbtn=(Button)findViewById(R.id.CLEARBTN);
			final TextView  textviewtitle2=(TextView)findViewById(R.id.HECTAREtextview5);
			
			  TotalEdittext=(EditText)findViewById(R.id.OUTPUTTRIANGLE);
			  acreEdittext=(EditText)findViewById(R.id.HECTERoutput1);
			  guntheEdittext=(EditText)findViewById(R.id.HECTERoutput2);

			
//			Button totalbtn=(Button)findViewById(R.id.Trainglebtn);
//			totalbtn.setOnClickListener(new OnClickListener() {
//				
//				@Override
//				public void onClick(View v) {
//					// TODO Auto-generated method stub
////					EditText editText=(EditText)findViewById(100);
////					String str=editText.getText().toString();
//					double sum=0;
//					for (int i = 0; i <10; i++) {
//						sum=sum+totalArrayList[i];
//					}
//					
//				    TotalEdittext.setText(""+sum);
//					
//				}
//			});
			
			  TotalEdittext.addTextChangedListener(new TextWatcher() {
					public void afterTextChanged(Editable s) {
						// Abstract Method of TextWatcher Interface.
					}

					public void beforeTextChanged(CharSequence s, int start, int count,
							int after) {
						// Abstract Method of TextWatcher Interface.
					}

					public void onTextChanged(CharSequence s, int start, int before,
							int count) {
						if(!TotalEdittext.getText().toString().equals(""))
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
			
			clearbtn.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
//					EditText editText=(EditText)findViewById(100);
//					String str=editText.getText().toString();
					setListValues();
					for (int i = 0; i <10; i++) {
						totalArrayList[i]=0;
					}
				    TotalEdittext.setText("0");
					
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
		} else if (view.getId() == R.id.ADDACREGUNTHELAYOUT) {
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
		} else if (view.getId() == R.id.AAKARFODLAYOUT) {
			Intent slideactivity = new Intent(this, AakarfodeActivity.class);
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
	
	
	//**********************************************************
	void setListValues()
	{
		try {
			
    RelativeLayout mainlayout = (RelativeLayout) findViewById(R.id.ParentLayout);
    mainlayout.removeAllViews();
    Typeface type = Typeface.createFromAsset(AddAcreGuntheActivity.this.getAssets(),"fonts/calibribold.ttf");	
    Typeface type2 = Typeface.createFromAsset(AddAcreGuntheActivity.this.getAssets(),"fonts/calibri.ttf");	
    for (int i = 0; i <10; i++) {
			
			//final ChatGroupVO groupVO=usergroupArrayList.get(i);

			// ******************************************
			RelativeLayout layout= new RelativeLayout(this);
			layout.setId(100+i);
			RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			layoutParams.topMargin=10;
			//layoutParams.bottomMargin=100;
			if(i!=0)
			layoutParams.addRule(RelativeLayout.BELOW,99+i);
			
			layoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
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
//			 tv1.setText("Acre");
            
			final EditText editText1=new EditText(this);
			params1.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
			//params1.addRule(RelativeLayout.BELOW,tv1.getId());
			//params1.topMargin=5;
			editText1.setId(100+i);
			editText1.setBackgroundResource(R.drawable.roundes_edittext_border);
			editText1.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
			editText1.setFilters(new InputFilter[] {new InputFilter.LengthFilter(maxLength)});
			editText1.setGravity(Gravity.CENTER | Gravity.BOTTOM);
			final ImageView imageView=new ImageView(AddAcreGuntheActivity.this);
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
//			 tv2.setText("Gunthe");
            
			final EditText editText2=new EditText(this);
			params2.addRule(RelativeLayout.RIGHT_OF,imageView.getId());
			//params2.addRule(RelativeLayout.BELOW,tv2.getId());
			//params2.topMargin=5;
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
								double sum=0;
								for (int i = 0; i <10; i++) {
									sum=sum+totalArrayList[i];
								}
								
							    TotalEdittext.setText(""+sum);
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
						double sum=0;
						for (int i = 0; i <10; i++) {
							sum=sum+totalArrayList[i];
						}
						
					    TotalEdittext.setText(""+sum);
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
						
						if(temp<40)
						{
							if(!editText1.getText().toString().equals("")&&!editText2.getText().toString().equals(""))
							{
								CalculateValue(editText1, editText2, k);
							}//end of if
							else
							{
								totalArrayList[k]=0;
								double sum=0;
								for (int i = 0; i <10; i++) {
									sum=sum+totalArrayList[i];
								}
								
							    TotalEdittext.setText(""+sum);
							}//end of else
						}
						else
						{
							AlertDialog.Builder builder = new AlertDialog.Builder(
									AddAcreGuntheActivity.this);
							builder.setTitle("BHUMI");
							builder.setMessage("Enter value lessthan 39")
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
						double sum=0;
						for (int i = 0; i <10; i++) {
							sum=sum+totalArrayList[i];
						}
						
					    TotalEdittext.setText(""+sum);
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
				double temp=Double.valueOf(Integer.valueOf(acreEdittext.getText().toString()));
				double temp2=(Double.valueOf(guntheEdittext.getText().toString())/40);
				
				double temp3=temp+temp2;
				
				double temp4=Double.valueOf(formatter.format((temp3*4046.85642)))/10000;
				
				String temp5=formatter2.format(temp4);

				
				totalArrayList[pos]=Double.valueOf(temp5);
				
				double sum=0;
				for (int i = 0; i <10; i++) {
					sum=sum+totalArrayList[i];
				}
				
			    TotalEdittext.setText(""+formatter2.format(sum));
				
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

	public void CalculateValue()
	{
		try {
			
			int length=TotalEdittext.getText().toString().length();
			if(length>0)
			{
			if(!Character.toString(TotalEdittext.getText().toString().charAt(length-1)).equalsIgnoreCase("."))
			{
				NumberFormat formatter = new DecimalFormat("#0.0000000");
				NumberFormat formatter2 = new DecimalFormat("#0.0000000");
				//Latitude=formatter.format(latitude);
				double temp=Double.valueOf(TotalEdittext.getText().toString())*10000;
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

}// end of Activity