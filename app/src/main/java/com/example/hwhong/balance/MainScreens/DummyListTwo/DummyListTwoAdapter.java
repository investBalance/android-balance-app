package com.example.hwhong.balance.MainScreens.DummyListTwo;

import android.content.Context;
import android.graphics.Typeface;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hwhong.balance.MainScreens.DummyListTwo.RowItem;
import com.example.hwhong.balance.R;

import java.util.ArrayList;

/**
 * Created by hwhong on 7/25/17.
 */

public class DummyListTwoAdapter extends ArrayAdapter<RowItem> {

    private Context context;
    private ArrayList<RowItem> allRowItems;

    private LayoutInflater mInflater;
    private boolean mNotifyOnChange = true;

    public DummyListTwoAdapter(Context context, ArrayList<RowItem> mRowItems) {
        super(context, R.layout.list_item_layout);
        this.context = context;
        this.allRowItems = new ArrayList<RowItem>(mRowItems);
        this.mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return allRowItems .size();
    }

    @Override
    public RowItem getItem(int position) {
        return allRowItems .get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public int getPosition(RowItem item) {
        return allRowItems .indexOf(item);
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
                    // Custom HERE
                    convertView = mInflater.inflate(R.layout.row_item_layout,parent, false);
                    holder.name = (TextView) convertView.findViewById(R.id.share_short_textview);
                    holder.value = (TextView) convertView.findViewById(R.id.value_textview);
                    holder.image = (ImageView) convertView.findViewById(R.id.value_image);
                    break;
            }
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        // Setting the item values
        holder.name.setText(allRowItems.get(position).getName());
        holder.value.setText(allRowItems.get(position).getValue());
        holder.image.setImageResource(allRowItems.get(position).getImage());

        // Customizing the views
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
        ImageView image;
        int pos; //to store the position of the item within the list
    }
}
