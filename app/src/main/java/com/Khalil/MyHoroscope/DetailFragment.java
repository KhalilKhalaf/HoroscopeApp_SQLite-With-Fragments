package com.Khalil.MyHoroscope;

import android.app.Fragment;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class DetailFragment extends Fragment {

    private int horoscopeId;
    SQLiteDatabase MyDatabase;
    Cursor cursor;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        LinearLayout view = (LinearLayout) inflater.inflate(R.layout.fragment_detail, container, false);

        try
        {
        SQLiteOpenHelper MyDatabaseHelper = new ZodiacDatabaseHelper(getActivity());
        MyDatabase = MyDatabaseHelper.getReadableDatabase();

        cursor = MyDatabase.query("ZodiacTable", new String[]{"NAME", "DESCRIPTION", "SYMBOL", "MONTH"},
                "_id = ?",
                new String[] {Integer.toString(horoscopeId + 1)},
                null, null,null);

        cursor.moveToFirst();
        String ZodiacName = cursor.getString(0);
        String ZodiacDescription = cursor.getString(1);
        String ZodiacSymbol = cursor.getString(2);
        String ZodiacMonnth = cursor.getString(3);

        TextView name = (TextView) view.findViewById(R.id.Name);
            name.setText(ZodiacName);

        TextView description = (TextView) view.findViewById(R.id.Description);
            description.setText(ZodiacDescription);

        TextView symbol = (TextView) view.findViewById(R.id.Symbol);
            symbol.setText(ZodiacSymbol);

        TextView month = (TextView) view.findViewById(R.id.Month);
        month.setText(ZodiacMonnth);

        cursor.close();
        MyDatabase.close();

        //new AsyncTaskParseJson(zodiac).execute();

        }catch(SQLiteException e)
        {
            Toast toast = Toast.makeText(getActivity(), "Database unavailable", Toast.LENGTH_SHORT);
            toast.show();
        }

        return view;
    }

    public void setHoroscopeId(int id) {
        horoscopeId = id;
    }
}
