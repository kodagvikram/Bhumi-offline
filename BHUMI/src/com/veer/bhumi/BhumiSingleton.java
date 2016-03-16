package com.veer.bhumi;

import android.content.Context;

public class BhumiSingleton {

	static Context context;
	public static BhumiSingleton bhumiSingleton=null;
	
	public double Aarray[]=new double[5];
	public double Barray[]=new double[5];
	public double Carray[]=new double[5];
	
	public double minusAarray[]=new double[5];
	public double minusBarray[]=new double[5];
	public double minusCarray[]=new double[5];
	
	public String SELECTEDSIGN="";
	
	public double newAarray[]=new double[5];
	public double newBarray[]=new double[5];
	public double newCarray[]=new double[5];
	
	public double newminusAarray[]=new double[5];
	public double newminusBarray[]=new double[5];
	public double newminusCarray[]=new double[5];
	
	public String newSELECTEDSIGN="";
	
	public BhumiSingleton(Context context) {
		this.context=context;
	}
	
	public static BhumiSingleton getInstance(Context context)
	{
		
		if(bhumiSingleton==null)
		{
			bhumiSingleton=new BhumiSingleton(context);
		}
		return bhumiSingleton;
	}

}
