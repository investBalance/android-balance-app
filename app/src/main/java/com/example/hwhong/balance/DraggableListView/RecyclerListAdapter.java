package com.example.hwhong.balance.DraggableListView;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v4.util.Pair;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hwhong.balance.DraggableListView.helper.ItemTouchHelperAdapter;
import com.example.hwhong.balance.DraggableListView.helper.ItemTouchHelperViewHolder;
import com.example.hwhong.balance.DraggableListView.helper.OnStartDragListener;
import com.example.hwhong.balance.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by hwhong on 7/12/17.
 */

public class RecyclerListAdapter extends RecyclerView.Adapter<RecyclerListAdapter.ItemViewHolder>
        implements ItemTouchHelperAdapter {

    private final List<Pair<Integer, String>> mItems = new ArrayList<>();

    private final OnStartDragListener mDragStartListener;

    private final Context context;

    public RecyclerListAdapter(Context context, OnStartDragListener dragStartListener) {
        mDragStartListener = dragStartListener;
        int[] arr = new int[] {R.drawable.animal, R.drawable.diversity, R.drawable.environment,
                R.drawable.hrights, R.drawable.peace, R.drawable.sustainable};
        String[] str = new String[] {"Animal Rights",
                                     "Diversity",
                                     "Environment",
                                     "Human Rights",
                                     "Promoting Peace",
                                     "Sustainable Products"};
        for(int i = 0; i < arr.length; i++) {
            mItems.add(new Pair<>(arr[i], str[i]));
        }
        this.context = context;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main, parent, false);
        ItemViewHolder itemViewHolder = new ItemViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(final ItemViewHolder holder, int position) {
        Typeface dinot = Typeface.createFromAsset(context.getAssets(), "fonts/DINOT-Regular.ttf");

        holder.textView.setText(mItems.get(position).second);
        holder.textView.setTypeface(dinot);
        holder.imageView.setImageResource(mItems.get(position).first);

        // Start a drag whenever the handle view it touched
        holder.handleView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (MotionEventCompat.getActionMasked(event) == MotionEvent.ACTION_DOWN) {
                    mDragStartListener.onStartDrag(holder);
                }
                return false;
            }
        });
    }

    @Override
    public void onItemDismiss(int position) {
        mItems.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        Collections.swap(mItems, fromPosition, toPosition);
        notifyItemMoved(fromPosition, toPosition);
        return true;
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder implements
            ItemTouchHelperViewHolder {

        public final TextView textView;
        public final ImageView handleView;
        public final ImageView imageView;

        public ItemViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.text);
            handleView = (ImageView) itemView.findViewById(R.id.handle);
            imageView = (ImageView) itemView.findViewById(R.id.values_pic);
        }

        @Override
        public void onItemSelected() {
            itemView.setBackgroundColor(Color.LTGRAY);
        }

        @Override
        public void onItemClear() {
            itemView.setBackgroundColor(0);
        }
    }
}
