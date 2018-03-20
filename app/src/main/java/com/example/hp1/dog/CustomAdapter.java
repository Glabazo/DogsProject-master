package com.example.hp1.dog;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * Created by Hp1 on 27/02/2018.
 */

public class CustomAdapter extends ArrayAdapter<Bitmap> {

    public CustomAdapter(Context context,ArrayList<Bitmap> bitmaps) {
        super(context, R.layout.custom_adapter,bitmaps );
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        return super.getView(position, convertView, parent);
    }
}
