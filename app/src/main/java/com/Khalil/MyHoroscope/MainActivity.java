package com.Khalil.MyHoroscope;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.app.Activity;
import android.os.Bundle;
import android.widget.FrameLayout;

public class MainActivity extends Activity implements HoroscopeListFragment.HoroscopeListListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void itemClicked(long id) {
        FrameLayout detailContainer = (FrameLayout)findViewById(R.id.detail_container);
        if (detailContainer == null) {
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra(DetailActivity.EXTRA_HOROSCOPE_ID, (int)id);
            startActivity(intent);
        } else {
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            DetailFragment detailFragment = new DetailFragment();
            detailFragment.setHoroscopeId((int)id);
            ft.replace(R.id.detail_container, detailFragment);
            ft.addToBackStack(null);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();
        }
    }
}
