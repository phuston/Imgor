package com.android.phuston.imgor.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.Toast;

import com.android.phuston.imgor.R;
import com.android.phuston.imgor.adapters.GridViewAdapter;
import com.android.phuston.imgor.models.Item;

import java.util.ArrayList;


public class SearchFragment extends Fragment {

    private static final String TAG = SearchFragment.class.getSimpleName();

    OnImageSearchListener mListener;

    private final String title = "Search Imgor";
    private final String API_KEY = "AIzaSyB4JJeo-t-bpQCHQw1BCJlMkdxQw_jspaU";
    private final String CX = "016517584568088842047:wzc2owtisfu";
    private final String SEARCHTYPE = "image";

    private ImageButton mSearchButton;
    private EditText mSearchEditText;
    private GridView mGridView;
    private GridViewAdapter mGridviewAdapter;

    private ArrayList<Item> mImages;


    public SearchFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnImageSearchListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnImageSearchListener");
        }
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
                Toast.makeText(getActivity(), urltosave, Toast.LENGTH_SHORT).show();
            }
        });

        mSearchButton = (ImageButton) rootView.findViewById(R.id.searchButton);
        mSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String query = mSearchEditText.getText().toString();
                if (query != null) {
                    mListener.onImageSearch(query);
                }
            }
        });

        mSearchEditText = (EditText) rootView.findViewById(R.id.searchEditText);

        return rootView;
    }

    public GridViewAdapter getGridViewAdapter() {
        return mGridviewAdapter;
    }

    // Interface to keep track of data updates
    public interface OnImageSearchListener {
        void onImageSearch(String query);
    }
}
