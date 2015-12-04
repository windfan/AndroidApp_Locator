package com.example.mylocator;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;



public class DBAdapter {

	/////////////////////////////////////////////////////////////////////
	//	Constants & Data
	/////////////////////////////////////////////////////////////////////
	// For logging:
	private static final String TAG = "DBAdapter";
	
	// DB Fields
	public static final String KEY_ROWID = "_id";
	public static final int COL_ROWID = 0;

	// TODO: Setup your fields here:
	
	public final static String YEAR="year";				//event year
	public final static String MONTH="month";			//event month
	public final static String DATE="date";				//event date
	public final static String M="m";					//am or pm
	public final static String HOUR="hour";				//event hour
	public final static String MINUTE="minute";			//event minute
	public final static String NAME="name";				//event name
	public final static String CATE_TYPE="cate_type";	//category type
	public final static String CATE_NO="cate_no";		//category number
	public final static String ADDR="addr";				//event address
	public final static String REGION_AREA="region_area";//event region
	public final static String REGION_NO="region_no";	//region number
	public final static String GPS_LO="gps_lo";			//GPS longitude
	public final static String GPS_LA="gps_la";			//GPS latitude
	public final static String DETAIL="detail";			//event detail
	public final static String MARK="mark";				//event mark
	public final static String PHOTO="photo";			//event photo
	public final static String RANK="rank";				//event rank
	public final static String OTHER="other";			//other
	
	// TODO: Setup your field numbers here (0 = KEY_ROWID, 1=...)
	public final static int COL_YEAR=1;				//event year
	public final static int COL_MONTH=2;			//event month
	public final static int COL_DATE=3;				//event date
	public final static int COL_M=4;					//am or pm
	public final static int COL_HOUR=5;				//event hour
	public final static int COL_MINUTE=6;			//event minute
	public final static int COL_NAME=7;				//event name
	public final static int COL_CATE_TYPE=8;	//category type
	public final static int COL_CATE_NO=9;		//category number
	public final static int COL_ADDR=10;				//event address
	public final static int COL_REGION_AREA=11;//event region
	public final static int COL_REGION_NO=12;	//region number
	public final static int COL_GPS_LO=13;			//GPS longitude
	public final static int COL_GPS_LA=14;			//GPS latitude
	public final static int COL_DETAIL=15;			//event detail
	public final static int COL_MARK=16;				//event mark
	public final static int COL_PHOTO=17;			//event photo
	public final static int COL_RANK=18;				//event rank
	public final static int COL_OTHER=19;			//other

	
	public static final String[] cols = new String[] {KEY_ROWID, YEAR, MONTH, DATE,
		M, HOUR, MINUTE, NAME, CATE_TYPE, CATE_NO, ADDR, REGION_AREA, REGION_NO,
		GPS_LO, GPS_LA, DETAIL, MARK, PHOTO, RANK, OTHER};
	
	// DB info: it's name, and the table we are using (just one).
	public static final String DATABASE_NAME = "LocatorDB";
	public static final String DATABASE_TABLE = "Events";
	// Track DB version if a new version of your app changes the format.
	public static final int DATABASE_VERSION = 1;	
	
	private static final String DATABASE_CREATE_SQL = 
			"create table " + DATABASE_TABLE 
			+ " (" + KEY_ROWID + " integer primary key autoincrement, "

			+ YEAR + " integer not null, "
			+ MONTH + " text not null, "
			+ DATE + " integer not null, "
			+ M + " text not null, "
			+ HOUR + " text not null, "
			+ MINUTE + " text not null, "
			+ NAME + " text not null, "
			+ CATE_TYPE + " text not null, "
			+ CATE_NO + " integer not null, "
			+ ADDR + " text not null, "
			+ REGION_AREA + " text not null, "
			+ REGION_NO + " integer not null, "
			+ GPS_LO + " numeric not null, "
			+ GPS_LA + " numeric not null, "
			+ DETAIL + " text not null, "
			+ MARK + " integer null, "
			+ PHOTO + " text null, "
			+ RANK + " integer null, "
			+ OTHER + " text not null"
			
			// Rest  of creation:
			+ ");";
	
	// Context of application who uses us.
	private final Context context;
	
	private DatabaseHelper myDBHelper;
	private SQLiteDatabase db;

	/////////////////////////////////////////////////////////////////////
	//	Public methods:
	/////////////////////////////////////////////////////////////////////
	
	public DBAdapter(Context ctx) {
		this.context = ctx;
		myDBHelper = new DatabaseHelper(context);
	}
	
	// Open the database connection.
	public DBAdapter open() {
		db = myDBHelper.getWritableDatabase();
		return this;
	}
	
	// Close the database connection.
	public void close() {
		myDBHelper.close();
	}
	
	// Add a new set of values to the database.
	public long insertRow(int year, String month, int date, String m, String hour, String minute, String name, String cate_type,
			int cate_no, String addr, String region_area, int region_no, double gps_lo, double gps_la, String detail, int mark,
			String photo, int rank, String other) {

		// TODO: Update data in the row with new fields.
		// TODO: Also change the function's arguments to be what you need!
		// Create row's data:
		ContentValues initialValues = new ContentValues();
		initialValues.put(YEAR, year);
		initialValues.put(MONTH, month);
		initialValues.put(DATE, date);
		initialValues.put(M, m);
		initialValues.put(HOUR, hour);
		initialValues.put(MINUTE, minute);
		initialValues.put(NAME, name);
		initialValues.put(CATE_TYPE, cate_type);
		initialValues.put(CATE_NO, cate_no);
		initialValues.put(ADDR, addr);
		initialValues.put(REGION_AREA, region_area);
		initialValues.put(REGION_NO, region_no);
		initialValues.put(GPS_LO, gps_lo);
		initialValues.put(GPS_LA, gps_la);
		initialValues.put(DETAIL, detail);
		initialValues.put(MARK, mark);
		initialValues.put(PHOTO, photo);
		initialValues.put(RANK, rank);
		initialValues.put(OTHER, other);
		
		// Insert it into the database.
		return db.insert(DATABASE_TABLE, null, initialValues);
	}
	
	// Delete a row from the database, by rowId (primary key)
	public boolean deleteRow(long rowId) {
		String where = KEY_ROWID + "=" + rowId;
		return db.delete(DATABASE_TABLE, where, null) != 0;
	}
	
	public void deleteAll() {
		Cursor c = getAllRows();
		long rowId = c.getColumnIndexOrThrow(KEY_ROWID);
		if (c.moveToFirst()) {
			do {
				deleteRow(c.getLong((int) rowId));				
			} while (c.moveToNext());
		}
		c.close();
	}
	
	// Return all data in the database.
	public Cursor getAllRows() {
		String where = null;
		Cursor c = 	db.query(true, DATABASE_TABLE, cols, 
							where, null, null, null, null, null);
		if (c != null) {
			c.moveToFirst();
		}
		return c;
	}

	// Get a specific row (by rowId)
	public Cursor getRow(long rowId) {
		String where = KEY_ROWID + "=" + rowId;
		Cursor c = 	db.query(true, DATABASE_TABLE, cols, 
						where, null, null, null, null, null);
		if (c != null) {
			c.moveToFirst();
		}
		return c;
	}
	
	// Change an existing row to be equal to new data.
	public boolean updateRow(long rowId, int year, int month, int date, String m, String hour, String minute, String name, String cate_type,
			int cate_no, String addr, String region_area, int region_no, double gps_lo, double gps_la, String detail, int mark,
			String photo, int rank, String other) {
		String where = KEY_ROWID + "=" + rowId;


		ContentValues newValues = new ContentValues();
		newValues.put(YEAR, year);
		newValues.put(MONTH, month);
		newValues.put(DATE, date);
		newValues.put(M, m);
		newValues.put(HOUR, hour);
		newValues.put(MINUTE, minute);
		newValues.put(NAME, name);
		newValues.put(CATE_TYPE, cate_type);
		newValues.put(CATE_NO, cate_no);
		newValues.put(ADDR, addr);
		newValues.put(REGION_AREA, region_area);
		newValues.put(REGION_NO, region_no);
		newValues.put(GPS_LO, gps_lo);
		newValues.put(GPS_LA, gps_la);
		newValues.put(DETAIL, detail);
		newValues.put(MARK, mark);
		newValues.put(PHOTO, photo);
		newValues.put(RANK, rank);
		newValues.put(OTHER, other);
		
		// Insert it into the database.
		return db.update(DATABASE_TABLE, newValues, where, null) != 0;
	}
	
	
	
	/////////////////////////////////////////////////////////////////////
	//	Private Helper Classes:
	/////////////////////////////////////////////////////////////////////
	
	/**
	 * Private class which handles database creation and upgrading.
	 * Used to handle low-level database access.
	 */
	private static class DatabaseHelper extends SQLiteOpenHelper
	{
		DatabaseHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase _db) {
			_db.execSQL(DATABASE_CREATE_SQL);			
		}

		@Override
		public void onUpgrade(SQLiteDatabase _db, int oldVersion, int newVersion) {
			Log.w(TAG, "Upgrading application's database from version " + oldVersion
					+ " to " + newVersion + ", which will destroy all old data!");
			
			// Destroy old database:
			_db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
			
			// Recreate new database:
			onCreate(_db);
		}
	}
}