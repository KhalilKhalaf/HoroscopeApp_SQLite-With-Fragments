package com.Khalil.MyHoroscope;

import android.app.ListFragment;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.app.Activity;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class HoroscopeListFragment extends ListFragment {
    static interface HoroscopeListListener {
        void itemClicked(long id);
    }

    private HoroscopeListListener listener;
    SQLiteDatabase MyDatabase;
    Cursor cursor;
    //ListView _listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        SQLiteOpenHelper MyDatabaseHelper = new ZodiacDatabaseHelper(getActivity());
        MyDatabase = MyDatabaseHelper.getReadableDatabase();

        cursor = MyDatabase.query("ZodiacTable", new String[]{"_id", "NAME"},
                null, null, null, null, null);

        CursorAdapter listAdapter = new SimpleCursorAdapter(getActivity(),
                android.R.layout.simple_list_item_1,
                cursor,
                new String[]{"NAME"},
                new int[]{android.R.id.text1},
                0);

        //_listView.setAdapter(listAdapter);

        setListAdapter(listAdapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.listener = (HoroscopeListListener)activity;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        if (listener != null) {
            listener.itemClicked(id - 1);
        }

    }
}
