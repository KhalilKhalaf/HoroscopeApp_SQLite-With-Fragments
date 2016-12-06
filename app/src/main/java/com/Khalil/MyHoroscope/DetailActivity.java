package com.Khalil.MyHoroscope;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Activity;

public class DetailActivity extends Activity {

    public static final String EXTRA_HOROSCOPE_ID = "horoscopeId";

    private int horoscopeId;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        horoscopeId = (int) getIntent().getExtras().get(EXTRA_HOROSCOPE_ID);

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        DetailFragment detailFragment = new DetailFragment();
        detailFragment.setHoroscopeId(horoscopeId);
        ft.replace(R.id.detail_container, detailFragment);
        //ft.addToBackStack(null);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();
    }
}
