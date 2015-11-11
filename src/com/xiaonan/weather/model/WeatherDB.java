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
	 * ���ݿ���
	 */
	public static final String DB_NAME = "weather.db";
	
	/*
	 * ���ݿ�汾
	 */
	public static final int VERSION = 1;
	private static WeatherDB weatherDB;
	private SQLiteDatabase db;
	
	/*
	 * �����췽��˽�л�
	 */
	
	private WeatherDB(Context context){
		WeatherOpenHelper dbHelper = new WeatherOpenHelper(context, DB_NAME, null, VERSION);
		db = dbHelper.getWritableDatabase();
	}
	
	/*
	 * ��ȡWeatherDB��ʵ��
	 */
	public synchronized static WeatherDB getINstence(Context context){
		if(weatherDB == null){
			weatherDB = new WeatherDB(context);
			
		}
		return weatherDB;
		
	}
	
	/*
	 * ��provinceʵ���洢�����ݿ�
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
	 * �����ݿ��ж�ȡȫ�����е������Ϣ
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
	 * ��Cityʵ���洢�����ݿ�
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
	 * �����ݿ��ж�ȡȫ����������Ϣ
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
	 * ��Countryʵ���洢�����ݿ�
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
	 * �����ݿ��ж�ȡȫ����������Ϣ
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
