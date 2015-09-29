package com.android.phuston.imgor.adapters;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.android.phuston.imgor.R;
import com.android.phuston.imgor.models.Item;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class GridViewAdapter extends ArrayAdapter<Item> {

    private Context mContext;
    private int layoutResourceId;
    private ArrayList<Item> mGridData = new ArrayList<>();

    public GridViewAdapter(Context mContext, int layoutResourceId, ArrayList<Item> mGridData) {
        super(mContext, layoutResourceId, mGridData);
        this.layoutResourceId = layoutResourceId;
        this.mContext = mContext;
        this.mGridData = mGridData;
    }

    /**
     * Updates grid data and refresh grid items.
     */
    public void setGridData(ArrayList<Item> newData) {
        mGridData = newData;
        notifyDataSetChanged();
        for (Item i : mGridData) {
            Log.i("ITEM: ", i.getLink());
        }
    }

    @Override
    public int getCount() {
        return mGridData.size();
    }

    @Override
    public Item getItem(int position) {
        return mGridData.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.i("Getview ", " was called");
        ViewHolder holder;

        if(convertView == null) {
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            convertView = inflater.inflate(layoutResourceId, parent, false);
            holder = new ViewHolder();
            holder.imageView = (ImageView)convertView.findViewById(R.id.image);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Item item = mGridData.get(position);

        Log.i("Item should be there ", item.getLink());

        Picasso.with(mContext).load(item.getLink()).into(holder.imageView);
        return convertView;
    }

    static class ViewHolder {
        ImageView imageView;
    }

}
