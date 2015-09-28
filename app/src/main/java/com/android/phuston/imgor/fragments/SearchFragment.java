package com.android.phuston.imgor.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.android.phuston.imgor.R;
import com.android.phuston.imgor.adapters.GridViewAdapter;
import com.android.phuston.imgor.api.APIClient;
import com.android.phuston.imgor.models.ImageQuery;
import com.android.phuston.imgor.models.Item;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class SearchFragment extends Fragment {

    private static final String TAG = SearchFragment.class.getSimpleName();

    private final String title = "Search Imgor";
    private final String API_KEY = "AIzaSyDfO49CeKzTrhVTroM7bgkzni5_RTcRM7U";
    private final String CX = "016517584568088842047:uukas3fd3j4";
    private final String SEARCHTYPE = "image";

    private GridView mGridView;
    private GridViewAdapter mGridviewAdapter;

    private ArrayList<Item> mImages;


    public SearchFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mImages = new ArrayList<>();

        mGridviewAdapter = new GridViewAdapter(getActivity(), R.layout.grid_item_layout, mImages);

        View rootView = inflater.inflate(R.layout.fragment_search, container, false);

        mGridView = (GridView) rootView.findViewById(R.id.imageGridView);
        mGridView.setAdapter(mGridviewAdapter);

        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Item image = mGridviewAdapter.getItem(position);
                String urltosave = image.getLink();
                //TODO: Do something with the URL - AKA save it to a database woop woop
            }
        });
        return rootView;
    }

    public void updateImageList(String query){
        APIClient.getImageSearchClient().getImages(API_KEY, CX, SEARCHTYPE, query, new Callback<ImageQuery>() {
            @Override
            public void success(ImageQuery imageQuery, Response response) {
                mImages = (ArrayList<Item>) imageQuery.getItems();
                mGridviewAdapter.setGridData(mImages);
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
    public void onResume () {
        super.onStart();
        updateImageList("Patrick");
    }
}
