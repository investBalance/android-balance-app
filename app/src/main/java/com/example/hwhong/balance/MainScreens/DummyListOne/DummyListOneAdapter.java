package com.example.hwhong.balance.MainScreens.DummyListOne;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.hwhong.balance.R;

import java.util.ArrayList;

/**
 * Created by hwhong on 7/25/17.
 */

public class DummyListOneAdapter extends ArrayAdapter<Item> {

    private Context context;
    private ArrayList<Item> allItems;

    private LayoutInflater mInflater;
    private boolean mNotifyOnChange = true;

    public DummyListOneAdapter(Context context, ArrayList<Item> mItems) {
        super(context, R.layout.list_item_layout);
        this.context = context;
        this.allItems = new ArrayList<Item>(mItems);
        this.mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return allItems .size();
    }

    @Override
    public Item getItem(int position) {
        return allItems .get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public int getPosition(Item item) {
        return allItems .indexOf(item);
    }

    @Override
    public int getViewTypeCount() {
        return 1; //Number of types + 1 !!!!!!!!
    }

    @Override
    public int getItemViewType(int position) {
        return 1;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Typeface roboto_light = Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Light.ttf");
        final ViewHolder holder;
        int type = getItemViewType(position);
        if (convertView == null) {
            holder = new ViewHolder();
            switch (type) {
                case 1:
                    convertView = mInflater.inflate(R.layout.list_item_layout,parent, false);
                    holder.name = (TextView) convertView.findViewById(R.id.item_names);
                    holder.value = (TextView) convertView.findViewById(R.id.item_values);
                    break;
            }
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.name.setText(allItems.get(position).getName());
        holder.value.setText(allItems.get(position).getValue());
        holder.name.setTypeface(roboto_light);
        holder.value.setTypeface(roboto_light);
        holder.pos = position;
        return convertView;
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        mNotifyOnChange = true;
    }

    public void setNotifyOnChange(boolean notifyOnChange) {
        mNotifyOnChange = notifyOnChange;
    }


    //---------------static views for each row-----------//
    static class ViewHolder {

        TextView name;
        TextView value;
        int pos; //to store the position of the item within the list
    }
}
