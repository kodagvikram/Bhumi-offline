package com.veer.bhumi;

import java.util.ArrayList;

import android.app.Activity;

public class Constants {
	
public static ArrayList<Activity> activity_stack=new ArrayList<Activity>();

	public Constants() {
		// TODO Auto-generated constructor stub
	}
	 public static void killAll() {

		    for (Activity act : Constants.activity_stack) {
		        act.finish();
		    }
		    Constants.activity_stack.clear();
}
}