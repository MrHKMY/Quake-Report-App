package com.example.android.quakereport;

import android.content.Context;
import android.content.AsyncTaskLoader;
import android.util.Log;

import java.util.List;

/**
 * Created by Hakimi on 2/10/2018.
 */
public class EarthquakeLoader extends AsyncTaskLoader<List<Earthquake>> {

    private static final String LOG_TAG = EarthquakeLoader.class.getName();

    private String mUrl;

    public EarthquakeLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        Log.i(LOG_TAG,"TEST: onStartLoading called...");
        forceLoad();
    }

    //background thread

    @Override
    public List<Earthquake> loadInBackground() {
        Log.i(LOG_TAG,"TEST: loadInBackground called...");
        if (mUrl == null){
            return null;
        }

        List<Earthquake> earthquakes = QueryUtils.fetchEarthquakeData(mUrl);
        return earthquakes;
    }
}
