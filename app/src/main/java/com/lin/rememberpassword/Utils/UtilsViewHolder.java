package com.lin.rememberpassword.Utils;

import android.support.annotation.LayoutRes;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class UtilsViewHolder {

    public View convertView;
    private SparseArray<View> cacheView = new SparseArray<>();

    private UtilsViewHolder(View convertView) {
        this.convertView = convertView;
    }

    public static UtilsViewHolder create(View convertView, ViewGroup parent, @LayoutRes int resId) {
        UtilsViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(resId, parent, false);
            holder = new UtilsViewHolder(convertView);
            convertView.setTag(holder);
        }
        return (UtilsViewHolder) convertView.getTag();
    }

    public void putView(int id, View view) {
        cacheView.put(id, view);
    }

    public View getView(int id) {
        if (cacheView.get(id) == null) {
            putView(id, convertView.findViewById(id));
        }

        return cacheView.get(id);
    }

    public TextView getTextView(int id) {
        if (cacheView.get(id) == null) {
            putView(id, convertView.findViewById(id));
        }
        return (TextView) cacheView.get(id);
    }

    public ImageView getImageView(int id) {
        if (cacheView.get(id) == null) {
            putView(id, convertView.findViewById(id));
        }
        return (ImageView) cacheView.get(id);
    }
}