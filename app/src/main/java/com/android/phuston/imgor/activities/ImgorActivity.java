package com.android.phuston.imgor.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.android.phuston.imgor.R;
import com.android.phuston.imgor.adapters.GridViewAdapter;
import com.android.phuston.imgor.api.APIClient;
import com.android.phuston.imgor.data.ArrayHelper;
import com.android.phuston.imgor.fragments.GalleryFragment;
import com.android.phuston.imgor.fragments.SearchFragment;
import com.android.phuston.imgor.models.ImageQuery;
import com.android.phuston.imgor.models.Item;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class ImgorActivity extends AppCompatActivity implements SearchFragment.OnImageSearchListener, SearchFragment.OnImageSaveListener {

    private static final String TAG = SearchFragment.class.getSimpleName();

    private final String title = "Search Imgor";
    private final String API_KEY = "AIzaSyB4JJeo-t-bpQCHQw1BCJlMkdxQw_jspaU";
    private final String CX = "016517584568088842047:wzc2owtisfu";
    private final String SEARCHTYPE = "image";

    private ArrayHelper mImageDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imgor);

        mImageDbHelper = new ArrayHelper(this);

        if(savedInstanceState == null){
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new SearchFragment())
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_imgor, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_gallery) {
            getFragmentManager().beginTransaction()
                    .replace(R.id.container, new GalleryFragment())
                    .addToBackStack(null)
                    .commit();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onImageSearch(final String query) {
        SearchFragment mSearchFragment = (SearchFragment) getFragmentManager().findFragmentById(R.id.container);
        final GridViewAdapter adapter = mSearchFragment.getGridViewAdapter();
        APIClient.getImageSearchClient().getImages(API_KEY, CX, SEARCHTYPE, query, new Callback<ImageQuery>() {
            @Override
            public void success(ImageQuery imageQuery, Response response) {
                Log.i(TAG, response.getUrl());
                ArrayList<Item> queryResult = (ArrayList<Item>) imageQuery.getItems();
                ArrayList<String> urls = new ArrayList<String>();

                for (Item i : queryResult) {
                    urls.add(i.getLink());
                }
                adapter.setGridData(urls);
            }

            @Override
            public void failure(RetrofitError error) {
                Log.e(TAG, "Encountered an error in Retrofit");
                Log.e(TAG, error.getUrl());
                Log.e(TAG, error.getMessage());
            }
        });
    }

    @Override
    public void onImageSave(String url) {
        mImageDbHelper.saveImage(url);
        Log.i(TAG, "Just saved " + url);
    }
}
