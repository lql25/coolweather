package db;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class CoolWeatherOpenHelper extends SQLiteOpenHelper{

	public static final String create_province = "create table province("
			+ "id integer primary key autoincrement,"
			+ "province_name text,"
			+ "province_code text"
			+ ")"; 
	
	public static final String create_city = "create table city("
			+ "id integer primary key autoincrement,"
			+ "city_name text,"
			+ "city_code text"
			+ "province_id integer"
			+ ")";
	
	public static final String create_county = "create table county("
			+ "id integer primary key autoincrement,"
			+ "county_name text,"
			+ "county_code text"
			+ "city_id integer"
			+ ")";
	
	public CoolWeatherOpenHelper(Context context, String name,
			CursorFactory factory, int version) {
		super(context, name, factory, version);
		// TODO 自动生成的构造函数存根
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO 自动生成的方法存根
		db.execSQL(create_province);
		db.execSQL(create_city);
		db.execSQL(create_county);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO 自动生成的方法存根
		
	}

}
