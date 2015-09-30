package com.android.phuston.imgor.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.android.phuston.imgor.R;
import com.android.phuston.imgor.adapters.GridViewAdapter;
import com.android.phuston.imgor.data.ArrayHelper;

import java.util.ArrayList;


public class GalleryFragment extends Fragment {

    private static final String TAG = GalleryFragment.class.getSimpleName();
    private ArrayList<String> mSavedImages;
    private ArrayHelper mDbHelper;

    private GridViewAdapter mGridviewAdapter;

    public GalleryFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDbHelper = new ArrayHelper(getActivity());
        loadSavedImages();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mGridviewAdapter = new GridViewAdapter(getActivity(), R.layout.grid_item_layout, mSavedImages);

        View rootView = inflater.inflate(R.layout.fragment_search, container, false);

        GridView mGridView = (GridView) rootView.findViewById(R.id.imageGridView);
        mGridView.setEmptyView(rootView.findViewById(R.id.empty_grid_view));
        mGridView.setAdapter(mGridviewAdapter);

        mGridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                return true;
            }
        });

        return rootView;
    }

    public void loadSavedImages() {
        mSavedImages = mDbHelper.getSavedImages();
    }
}
