package com.xiaonan.weather.model;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.xiaonan.weather.db.WeatherOpenHelper;

public class WeatherDB {
	/*
	 * 数据库名
	 */
	public static final String DB_NAME = "weather.db";
	
	/*
	 * 数据库版本
	 */
	public static final int VERSION = 1;
	private static WeatherDB weatherDB;
	private SQLiteDatabase db;
	
	/*
	 * 将构造方法私有化
	 */
	
	private WeatherDB(Context context){
		WeatherOpenHelper dbHelper = new WeatherOpenHelper(context, DB_NAME, null, VERSION);
		db = dbHelper.getWritableDatabase();
	}
	
	/*
	 * 获取WeatherDB的实例
	 */
	public synchronized static WeatherDB getINstence(Context context){
		if(weatherDB == null){
			weatherDB = new WeatherDB(context);
			
		}
		return weatherDB;
		
	}
	
	/*
	 * 将province实例存储到数据库
	 */
	
	@SuppressWarnings("null")
	public void saveProvince(Province province){
		if(province == null){
			ContentValues values =new ContentValues();
			values.put("province_name",province.getProvinceName());
			values.put("province_code", province.getProvinceCode());
			db.insert("Province", null, values);
		}
	}
	/*
	 * 从数据库中读取全国所有的身份信息
	 */
	
	
	public List<Province> loadProvince(){
		
		List<Province> list = new ArrayList<Province>();
		Cursor cursor = db.query("Province", null, null, null, null, null, null);
		if(cursor.moveToNext()){
			do{
				Province province  = new Province();
				province.setId(cursor.getInt(cursor.getColumnIndex("id")));
				province.setProvinceCode(cursor.getString(cursor.getColumnIndex("province_name")));
				list.add(province);
			}while (cursor.moveToNext());
			if(cursor != null){
				cursor.close();
				
			}
			
		}
		return list;
		
	}
	
	
	/*
	 * 将City实例存储到数据库
	 */
	
	@SuppressWarnings("null")
	public void saveCity(City city){
		if(city == null){
			ContentValues values =new ContentValues();
			values.put("city_name", city.getCityName());
			values.put("city_code", city.getCityCode());
			values.put("province_id", city.getProvinceId());
			
			db.insert("Country", null, values);
		}
	}
	/*
	 * 从数据库中读取全国所有市信息
	 */
	
	public List<City> loadCity(){
		
		List<City> list = new ArrayList<City>();
		Cursor cursor = db.query("City", null, null, null, null, null, null);
		if(cursor.moveToNext()){
			do{
				City city  = new City();
				city.setId(cursor.getInt(cursor.getColumnIndex("id")));
				city.setCityName(cursor.getString(cursor.getColumnIndex("city_name")));
				city.setCityCode(cursor.getString(cursor.getColumnIndex("city_code")));
				city.setProvinceId(cursor.getInt(cursor.getColumnIndex("province_id")));
				list.add(city);
			}while (cursor.moveToNext());
			if(cursor != null){
				cursor.close();
				
			}
			
		}
		return list;
		
	}
	
	
	
	
	/*
	 * 将Country实例存储到数据库
	 */
	
	@SuppressWarnings("null")
	public void saveCountry(Country country){
		if(country == null){
			ContentValues values =new ContentValues();
			values.put("country_name", country.getCountryName());
			values.put("country_code", country.getCountryCode());
			values.put("city_id", country.getCityId());
			
			db.insert("Country", null, values);
		}
	}
	/*
	 * 从数据库中读取全国所有县信息
	 */
	
	public List<Country> loadCountry(){
		
		List<Country> list = new ArrayList<Country>();
		Cursor cursor = db.query("Country", null, null, null, null, null, null);
		if(cursor.moveToNext()){
			do{
				Country country = new Country();
				country.setId(cursor.getInt(cursor.getColumnIndex("id")));
				country.setCountryName(cursor.getString(cursor.getColumnIndex("country_name")));
				country.setCountryCode(cursor.getString(cursor.getColumnIndex("country_code")));
				country.setCityId(cursor.getInt(cursor.getColumnIndex("city_id")));
				list.add(country);
			}while (cursor.moveToNext());
			if(cursor != null){
				cursor.close();
				
			}
			
		}
		return list;
		
	}
}
