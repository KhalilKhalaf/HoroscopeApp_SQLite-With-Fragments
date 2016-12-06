package com.Khalil.MyHoroscope;

/**
 * Created by kkhalaf on 12/3/2016.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class ZodiacDatabaseHelper extends SQLiteOpenHelper
{
    private static final String DB_NAME = "ZodiacDatabase"; // the name of our database
    private static final int DB_VERSION = 1; // the version of the database

    private String name;
    private String description;
    private String symbol;
    private String month;

    ZodiacDatabaseHelper(Context context)
    {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("CREATE TABLE ZodiacTable ("
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "NAME TEXT, "
                + "DESCRIPTION TEXT, "
                + "SYMBOL TEXT, "
                + "MONTH TEXT);");

        InsertRow(db, "Aries","Aries From Database", "Ram", "April");
        InsertRow(db, "Taurus","Taurus From Database", "Bull", "May");
        InsertRow(db, "Gemini","Gemini From Database", "Twins", "June");
        InsertRow(db, "Cancer","Cancer From Database", "Crab", "July");
        InsertRow(db, "Leo","Leo From Database", "Lion", "August");
        InsertRow(db, "Virgo","Virgo From Database", "Virgin", "September");

        InsertRow(db, "Libra","Libra From Database", "Scales", "October");
        InsertRow(db, "Scorpio","Scorpio From Database", "Scorpion", "November");
        InsertRow(db, "Sagittarius","Sagittarius From Database", "Archer", "December");
        InsertRow(db, "Capricorn","Capricorn From Database", "Goat", "January");
        InsertRow(db, "Aquarius","Aquarius From Database", "Bearer", "February");
        InsertRow(db, "Pisces","Pisces From Database", "Fish", "March");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }

    private static void InsertRow(SQLiteDatabase _db, String _name, String _description, String _symbol, String _month) {
        ContentValues ZodiacValues = new ContentValues();
        ZodiacValues.put("NAME", _name);
        ZodiacValues.put("DESCRIPTION", _description);
        ZodiacValues.put("SYMBOL", _symbol);
        ZodiacValues.put("MONTH", _month);

        _db.insert("ZodiacTable", null, ZodiacValues);
    }

}