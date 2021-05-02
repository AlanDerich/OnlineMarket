package com.derich.onlinemarket.view.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.derich.onlinemarket.model.Categories;

import java.util.ArrayList;

public class CategoriesAdapter extends ArrayAdapter<Categories> {
    public CategoriesAdapter(Context context, ArrayList<Categories> items) {
        super(context, 0, items);
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        Categories item = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(this.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
        }

        TextView tvName = (TextView) convertView.findViewById(android.R.id.text1);
        tvName.setText(item.getCategoryName());

        return convertView;
    }
}
