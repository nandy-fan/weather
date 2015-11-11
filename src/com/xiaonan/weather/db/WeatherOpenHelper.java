package com.xiaonan.weather.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class WeatherOpenHelper extends SQLiteOpenHelper {
	
	/*
	 * provience±í
	 */
	
	public static final String CREATE_PROVINCE="create table Province(" 
	+ " id integer primary key autoincreament, "
	+ " provience_name text, "
	+ " provience_code text)";
	
	/*
	 * city±í
	 */
	
	public static final String CREATE_CITY="crate table City("
			+ " city_name text, "
			+ " city_code text, "
			+ " provice_id integer)";
	
	/*
	 * country±í
	 */
	
	public static final String CREATE_COUNTRY="create table Country("
			+ " country_name text, "
			+ " country_code text, "
			+ " city_id integer)";
			
	
	
			
	

	public WeatherOpenHelper(Context context, String name,
			CursorFactory factory, int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase arg0) {
		// TODO Auto-generated method stub
		
		arg0.execSQL(CREATE_PROVINCE);
		arg0.execSQL(CREATE_CITY);
		arg0.execSQL(CREATE_COUNTRY);
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}

}
