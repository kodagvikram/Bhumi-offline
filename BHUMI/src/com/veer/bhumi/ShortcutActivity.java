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

@SuppressLint("NewApi")
public class ShortcutActivity extends Activity {
	FrameLayout mainFrameLyout;
	FrameLayout.LayoutParams menuPanelParameters;
	FrameLayout.LayoutParams slidingPanelParameters;
	LinearLayout.LayoutParams headerPanelParameters;
	LinearLayout.LayoutParams listViewParameters;
	Button menuBtn;
	private DisplayMetrics metrics;
	private RelativeLayout slidingPanel,menulayout;
	int panelWidth = 0;
	EditText aEdittext,bEdittext,cEdittext,dEdittext,eEdittext,AreEdittext,OUTPUTEdittext,newAreEdittext,newMeteroutputEdittext;
	private boolean  isExpanded,isAButton=false,isBButton=false,isDButton=false,isEButton=false,isPlusButton=false
			,isMinusButton=false,isAreTextview=true,isSqmTextview=false;

	int edittextwidth=0,edittextheight=0,totalwidth=0,imageviewwidth=0;
	public double  totalArrayList[]=new double[10];
	public EditText  inputEditext1,outputedittext,inputEditext2,inputEditext3;
	@Override
	public void onBackPressed() {
		Constants.killAll();
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.shortcutxml);
		try{
		Constants.activity_stack.add(this);
		metrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);
		panelWidth = (int) ((metrics.widthPixels) * 0.75);
		edittextwidth= (int) ((metrics.widthPixels) * 0.30);
		edittextheight=(int) ((metrics.widthPixels) * 0.23);
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
			
			Button clearbtn=(Button)findViewById(R.id.CLEARBTN);
			final TextView  textviewtitle2=(TextView)findViewById(R.id.SHORTCUTtextview1);
			
			  inputEditext1=(EditText)findViewById(R.id.MSHORTCUTEDITTEXT1);
			  inputEditext2=(EditText)findViewById(R.id.OUTPUTTRIANGLE2);
			  inputEditext3=(EditText)findViewById(R.id.OUTPUTTRIANGLE3);
			  outputedittext=(EditText)findViewById(R.id.OUTPUTTRIANGLE4);
			
			  newAreEdittext=(EditText)findViewById(R.id.NEWUPDATEMSHORTCUTEDITTEXT2);
				newMeteroutputEdittext=(EditText)findViewById(R.id.MSHORTCUTEDITTEXT778);
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
						  
						  if(!newAreEdittext.getText().toString().equals("")&&!inputEditext1.getText().toString().equals("")&&!inputEditext2.getText().toString().equals("")&&!inputEditext3.getText().toString().equals(""))
							{
								CalculateValue();
							}//end of if
							else
								
							{
								outputedittext.setText("0");
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
						  
						  if(!newAreEdittext.getText().toString().equals("")&&!inputEditext1.getText().toString().equals("")&&!inputEditext2.getText().toString().equals("")&&!inputEditext3.getText().toString().equals(""))
							{
								CalculateValue();
							}//end of if
							else
								
							{
								outputedittext.setText("0");
								newMeteroutputEdittext.setText("");
							}
					}
				});
			
			
			clearbtn.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					inputEditext1.setText("");
					inputEditext2.setText("");
					inputEditext3.setText("");
					outputedittext.setText("0");
					newAreEdittext.setText("");
					
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
			
			
			inputEditext1.addTextChangedListener(new TextWatcher() {
				public void afterTextChanged(Editable s) {
					// Abstract Method of TextWatcher Interface.
				}

				public void beforeTextChanged(CharSequence s, int start, int count,
						int after) {
					// Abstract Method of TextWatcher Interface.
				}

				public void onTextChanged(CharSequence s, int start, int before,
						int count) {
					if(!inputEditext1.getText().toString().equals(""))
					{
						double temp=0;
						int len=inputEditext1.getText().toString().length();
						
//						if(!Character.toString(inputEditext1.getText().toString().charAt(len-1)).equalsIgnoreCase("."))
//						 temp=Double.valueOf(inputEditext1.getText().toString());
//						
//						if(temp<1000)
//						{
						  if(!newAreEdittext.getText().toString().equals("")&&!inputEditext1.getText().toString().equals("")&&!inputEditext2.getText().toString().equals("")&&!inputEditext3.getText().toString().equals(""))
							{
								CalculateValue();
							}//end of if
							else
								
							{
								outputedittext.setText("0");
								newMeteroutputEdittext.setText("");
							}
//						}
//						else
//						{
//							AlertDialog.Builder builder = new AlertDialog.Builder(
//									ShortcutActivity.this);
//							builder.setTitle("BHUMI");
//							builder.setMessage("Enter value lessthan 1000")
//									.setCancelable(false)
//									.setPositiveButton("OK",
//											new DialogInterface.OnClickListener() {
//												public void onClick(
//														DialogInterface dialog, int id) {
//													// do things
//													inputEditext1.setText("");
//												}
//											});
//							AlertDialog alert = builder.create();
//							alert.show();
//                        }//end of else
//						
					}//end of outerif
					else
						
					{
						outputedittext.setText("0");
						newMeteroutputEdittext.setText("");
					}

				}
			});//end of listner
			
			
			inputEditext2.addTextChangedListener(new TextWatcher() {
				public void afterTextChanged(Editable s) {
					// Abstract Method of TextWatcher Interface.
				}

				public void beforeTextChanged(CharSequence s, int start, int count,
						int after) {
					// Abstract Method of TextWatcher Interface.
				}

				public void onTextChanged(CharSequence s, int start, int before,
						int count) {
					if(!inputEditext2.getText().toString().equals(""))
					{
						double temp=0;
						int len=inputEditext2.getText().toString().length();
						
//						if(!Character.toString(inputEditext2.getText().toString().charAt(len-1)).equalsIgnoreCase("."))
//						 temp=Double.valueOf(inputEditext2.getText().toString());
//						
//						if(temp<1000)
//						{
						  if(!newAreEdittext.getText().toString().equals("")&&!inputEditext1.getText().toString().equals("")&&!inputEditext2.getText().toString().equals("")&&!inputEditext3.getText().toString().equals(""))
							{
								CalculateValue();
							}//end of if
							else
								
							{
								outputedittext.setText("0");
								newMeteroutputEdittext.setText("");
							}
//						}
//						else
//						{
//							AlertDialog.Builder builder = new AlertDialog.Builder(
//									ShortcutActivity.this);
//							builder.setTitle("BHUMI");
//							builder.setMessage("Enter value lessthan 1000")
//									.setCancelable(false)
//									.setPositiveButton("OK",
//											new DialogInterface.OnClickListener() {
//												public void onClick(
//														DialogInterface dialog, int id) {
//													// do things
//													inputEditext2.setText("");
//												}
//											});
//							AlertDialog alert = builder.create();
//							alert.show();
//                        }//end of else
						
					}//end of outerif
					else
						
					{
						outputedittext.setText("0");
						newMeteroutputEdittext.setText("");
					}
				}
			});//end of listner

			inputEditext3.addTextChangedListener(new TextWatcher() {
				public void afterTextChanged(Editable s) {
					// Abstract Method of TextWatcher Interface.
				}

				public void beforeTextChanged(CharSequence s, int start, int count,
						int after) {
					// Abstract Method of TextWatcher Interface.
				}

				public void onTextChanged(CharSequence s, int start, int before,
						int count) {
					if(!inputEditext3.getText().toString().equals(""))
					{
						double temp=0;
						int len=inputEditext3.getText().toString().length();
						
//						if(!Character.toString(inputEditext3.getText().toString().charAt(len-1)).equalsIgnoreCase("."))
//						 temp=Double.valueOf(inputEditext3.getText().toString());
//						
//						if(temp<1000)
//						{
						  if(!newAreEdittext.getText().toString().equals("")&&!inputEditext1.getText().toString().equals("")&&!inputEditext2.getText().toString().equals("")&&!inputEditext3.getText().toString().equals(""))
							{
								CalculateValue();
							}//end of if
							else
								
							{
								outputedittext.setText("0");
								newMeteroutputEdittext.setText("");
							}
//						}
//						else
//						{
//							AlertDialog.Builder builder = new AlertDialog.Builder(
//									ShortcutActivity.this);
//							builder.setTitle("BHUMI");
//							builder.setMessage("Enter value lessthan 1000")
//									.setCancelable(false)
//									.setPositiveButton("OK",
//											new DialogInterface.OnClickListener() {
//												public void onClick(
//														DialogInterface dialog, int id) {
//													// do things
//													inputEditext3.setText("");
//												}
//											});
//							AlertDialog alert = builder.create();
//							alert.show();
//                        }//end of else
						
					}//end of outerif
					else
						
					{
						outputedittext.setText("0");
						newMeteroutputEdittext.setText("");
					}

				}
			});//end of listner
			
			
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
						
						if(temp<100011)
						{
							  if(!newAreEdittext.getText().toString().equals("")&&!inputEditext1.getText().toString().equals("")&&!inputEditext2.getText().toString().equals("")&&!inputEditext3.getText().toString().equals(""))
								{
									CalculateValue();
								}//end of if
								else
									
								{
									outputedittext.setText("0");
									newMeteroutputEdittext.setText("");
								}
						}
						else
						{
							AlertDialog.Builder builder = new AlertDialog.Builder(
									ShortcutActivity.this);
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
						outputedittext.setText("0");
						newMeteroutputEdittext.setText("");
					}

				}
			});//end of listner

			
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
		if (view.getId() == R.id.HECTERTOGUNTHELAYOUT) {
			Intent slideactivity = new Intent(this, HectaretoGuntheActivity.class);
			Bundle bndlanimation = 
					ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.animation,R.anim.animation2).toBundle();
			startActivity(slideactivity, bndlanimation);
			
			 finish();
		} else if (view.getId() == R.id.SORTCUTLAYOUT) {
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
				
			} else if (view.getId() == R.id.LANDAREALAYOUT) {
				Intent slideactivity = new Intent(this, LandAreaActivity.class);
				Bundle bndlanimation = 
						ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.animation,R.anim.animation2).toBundle();
				startActivity(slideactivity, bndlanimation);
				
			}else if (view.getId() == R.id.LANDAREALAYOUT) {
				Intent slideactivity = new Intent(this, LandAreaActivity.class);
				Bundle bndlanimation = 
						ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.animation,R.anim.animation2).toBundle();
				startActivity(slideactivity, bndlanimation);
			}else if (view.getId() == R.id.MAZASORTCUTLAYOUT) {
				Intent slideactivity = new Intent(this, MazaShortcutActivity.class);
				Bundle bndlanimation = 
						ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.animation,R.anim.animation2).toBundle();
				startActivity(slideactivity, bndlanimation);
			}
			else if (view.getId() == R.id.SCALELAYOUT) {
				Intent slideactivity = new Intent(this, ScaleActivity.class);
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
	
	
	

	public void CalculateValue()
	{
		try {
		int length=inputEditext1.getText().toString().length();
		int length2=inputEditext2.getText().toString().length();
		int length3=inputEditext3.getText().toString().length();
		int length7=newAreEdittext.getText().toString().length();
		if(length>0&&length2>0&&length3>00&&length7>0)
		{
		if(!Character.toString(inputEditext1.getText().toString().charAt(length-1)).equalsIgnoreCase(".")&&!Character.toString(inputEditext2.getText().toString().charAt(length2-1)).equalsIgnoreCase(".")&&!Character.toString(inputEditext3.getText().toString().charAt(length3-1)).equalsIgnoreCase(".")&&!Character.toString(newAreEdittext.getText().toString().charAt(length7-1)).equalsIgnoreCase("."))
		{
			NumberFormat formatter = new DecimalFormat("#0.0000000");
			NumberFormat formatter2 = new DecimalFormat("#0.00");
			//Latitude=formatter.format(latitude);
			double temp1=(Double.valueOf(inputEditext1.getText().toString()));
			double temp2=(Double.valueOf(inputEditext2.getText().toString()));
			double temp3=Double.valueOf(inputEditext3.getText().toString());
			double neware=Double.valueOf(newAreEdittext.getText().toString());
			
			double temp91=1/(neware/1000);
			double temp101=(temp91*temp91);
			
			if(isAreTextview)
				temp1=temp101*temp1*100;
			
			if(isSqmTextview)
				temp1=(temp101*temp1);
			
			double temp4=(temp2*temp3)/2;
			
			double temp5=((temp1-temp4)/temp3)*2;
			
			
			
			String[] strArray = String.valueOf(temp5).split("\\.");
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
			
			double meteroutput=(neware/1000)*Double.valueOf(""+strArray[0]+"."+strArray[1].substring(0, 2));
			newMeteroutputEdittext.setText(""+formatter2.format(meteroutput));
			outputedittext.setText(""+strArray[0]+"."+strArray[1].substring(0, 2));
			
			//guntheEdittext.setText(""+n);
			
		 }//end of if
		}//end of if length
		else
		{
			outputedittext.setText("0");
			newMeteroutputEdittext.setText("");
		}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}//end of calculate


}// end of Activity
