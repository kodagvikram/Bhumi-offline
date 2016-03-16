package com.veer.bhumi;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityOptions;
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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

@TargetApi(Build.VERSION_CODES.JELLY_BEAN) @SuppressLint("NewApi") public class AllTipanActivity extends Activity {
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
	
	double jantria,jantrib,jantric;
	public EditText a1Edittext,a2Edittext,b1Edittext,b2Editext,c1Edittext,c2Edittext,outputEdittext1,outputEdittext2;
	
	@Override
	public void onBackPressed() {
		Constants.killAll();
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.all_in_one_tipanxml);
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
		Button button14 = (Button) findViewById(R.id.btn_MAZASORTCUT);
		button14.setTypeface(font);
		Button button15 = (Button) findViewById(R.id.btn_NEWMAZASORTCUT);
		button15.setTypeface(font);
		
		final ImageView samamblamb=(ImageView)findViewById(R.id.SAMLAMBIMAGEVIEW);
		final ImageView jantritriangle=(ImageView)findViewById(R.id.JANTRITRIANGLEIMAGEVIEW);
		final ImageView tipantriangle=(ImageView)findViewById(R.id.TIPANTRIANGLEIMAGEVIEW);
		
		samamblamb.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent intent=new Intent(getApplicationContext(), SamlambActivity.class);
				startActivity(intent);
				finish();
			}
		});
		
		jantritriangle.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent intent=new Intent(getApplicationContext(), TriangleAreaActivity.class);
				startActivity(intent);
				finish();
			}
		});
		
		tipantriangle.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent intent=new Intent(getApplicationContext(), TipanTriangleActivity.class);
				startActivity(intent);
				finish();
			}
		});

				
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}// end of oncreate()
	
	public void onMenuOptionClicked(View view) {
		if (view.getId() == R.id.LANDAREALAYOUT) {
			Intent intent = new Intent(this,
					LandAreaActivity.class);
			startActivity(intent);
		}
		else if (view.getId() == R.id.SAMLAMBLAYOUT) {
			isExpanded = false;
			new CollapseAnimation(slidingPanel, panelWidth,
					TranslateAnimation.RELATIVE_TO_SELF, 0.75f,
					TranslateAnimation.RELATIVE_TO_SELF, 0.0f, 0, 0.0f, 0, 0.0f,menulayout);
		}
		else if (view.getId() == R.id.HECTERTOGUNTHELAYOUT) {
			Intent intent = new Intent(this,
					HectaretoGuntheActivity.class);
			startActivity(intent);
		} else if (view.getId() == R.id.AANEWARILAYOUT) {
			Intent intent = new Intent(this,
					AanewariActivity.class);
			startActivity(intent);
		}  else if (view.getId() == R.id.ENLARGMENTLAYOUT) {
			Intent intent = new Intent(this,
					EnlargmentActivity.class);
			startActivity(intent);
		} 
		 else if (view.getId() == R.id.JANTRILayout) {
				Intent intent = new Intent(this,
						JantriActivity.class);
				startActivity(intent);
			} 
//		 else if (view.getId() == R.id.SAMLAMBLAYOUT) {
//				Intent intent = new Intent(this,
//						AllTipanActivity.class);
//				startActivity(intent);
//			} 
		 else if (view.getId() == R.id.TRIANGLELANDLAYOUT) {
				Intent intent = new Intent(this,
						TriangleLandActivity.class);
				startActivity(intent);
			} else if (view.getId() == R.id.AAKARFODLAYOUT) {
				Intent intent = new Intent(this,
						AakarfodeActivity.class);
				startActivity(intent);
			}  else if (view.getId() == R.id.ADDACREGUNTHELAYOUT) {
				Intent intent = new Intent(this,
						AddAcreGuntheActivity.class);
				startActivity(intent);
			} else if (view.getId() == R.id.VASALEVARLAYOUT) {
				Intent intent = new Intent(this,
						VasalevarActivity.class);
				startActivity(intent);
			} else if (view.getId() == R.id.SORTCUTLAYOUT) {
				Intent intent = new Intent(this,
						ShortcutActivity.class);
				startActivity(intent);
			}else if (view.getId() == R.id.NEWMAZASORTCUTLAYOUT) {
				Intent slideactivity = new Intent(this, NewMazashortcut.class);
				Bundle bndlanimation = 
						ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.animation,R.anim.animation2).toBundle();
				startActivity(slideactivity, bndlanimation);
			}
		
	}// end of menu

}// end of Activity
