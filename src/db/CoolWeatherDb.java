package db;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import model.City;
import model.County;
import model.Province;
import android.R.id;
import android.R.integer;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class CoolWeatherDb {

	public static final String db_name = "cool_weather";
	
	public static final int version = 1;
	private static CoolWeatherDb coolWeatherDb;
	private SQLiteDatabase db;
	
	public CoolWeatherDb(Context context) {
		// TODO 自动生成的构造函数存根
		CoolWeatherOpenHelper dbHelper = new CoolWeatherOpenHelper(context, db_name, null, version);
		dbHelper.getWritableDatabase();
	}
	
	public synchronized static CoolWeatherDb getInstance(Context context)
	{
		if(coolWeatherDb == null)
		{
			coolWeatherDb = new CoolWeatherDb(context);
		}
		return coolWeatherDb;
	}
	
	private void saveProvince(Province province) {
		// TODO 自动生成的方法存根
		if(province != null)
		{
			db.execSQL("insert into province(provinceName,provinceCode) values(?,?)",
					new String[] {province.getProvinceName(),province.getProvinceCode()});
		}
	}
	
	
	public List<Province> loadProvinces()
	{
		List<Province> list = new ArrayList<Province>();
		Cursor cursor = db.rawQuery("select * from province", null);
		if(cursor.moveToFirst())
		{
			do {
				Province province = new Province();
				province.setId(cursor.getInt(cursor.getColumnIndex("id")));
				province.setProvinceCode(cursor.getString(cursor.getColumnIndex("province_code")));
				province.setProvinceName(cursor.getString(cursor.getColumnIndex("province_name")));
				list.add(province);
			} while (cursor.moveToNext());
		}
		return list;
	}
	
	private void saveCity(City city) {
		// TODO 自动生成的方法存根
		if(city!=null)
		{
			db.execSQL("insert into city(city_name,city_code,province_id) values(?,?,?)",
					new String[] {city.getCity_name(),city.getCity_code(),String.valueOf(city.getId())});
		}
	}
	
	public List<City> loadCities()
	{
		List<City> list = new ArrayList<City>();
		Cursor cursor = db.rawQuery("select * from city", null);
		if(cursor.moveToFirst())
		{
			do {
				City city = new City();
				city.setCity_code(cursor.getString(cursor.getColumnIndex("city_code")));
				city.setCity_name(cursor.getString(cursor.getColumnIndex("city_name")));
				city.setId(cursor.getInt(cursor.getColumnIndex("province_id")));
				list.add(city);
			} while (cursor.moveToNext());
		}
		
		return list;
	}
	
	
	private void saveCounty(County county) {
		// TODO 自动生成的方法存根
		if(county != null)
		{
			db.execSQL("insert into county(county_name,county_code,city_id) values(?,?,?)",
					new String[] {county.getCounty_name(),county.getCounty_code(),String.valueOf(county.getId())});
			
		}
	}
	
	public List<County> loadCounties()
	{
		List<County> list = new ArrayList<County>();
		Cursor cursor = db.rawQuery("select * from county", null);
		if(cursor.moveToFirst())
		{
			do {
				County county = new County();
				county.setCity_id(cursor.getInt(cursor.getColumnIndex("id")));
				county.setCounty_code(cursor.getString(cursor.getColumnIndex("county_code")));
				county.setCounty_name(cursor.getString(cursor.getColumnIndex("county_name")));
				list.add(county);
			} while (cursor.moveToNext());
		}
		return null;
		
	}
	
}
