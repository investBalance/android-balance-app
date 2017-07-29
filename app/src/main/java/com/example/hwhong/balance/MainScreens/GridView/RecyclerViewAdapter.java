package com.example.hwhong.balance.MainScreens.GridView;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.hwhong.balance.R;
import com.squareup.picasso.Picasso;

/**
 * Created by hwhong on 7/28/17.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private Card[] mData;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    private Context ctx;

    // data is passed into the constructor
    public RecyclerViewAdapter(Context context, Card[] data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
        ctx = context;
    }

    // inflates the cell layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.card_view, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    // binds the data to the textview in each cell
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // setCardBackgroundColor takes rgb values which reduces the color
        // because R.color value is not rgb
        holder.cardView.setCardBackgroundColor(ContextCompat.getColor(ctx, mData[position].getColor()));
        Picasso.with(ctx).load(mData[position].getDrawable()).into(holder.tech_icon);
    }

    // total number of cells
    @Override
    public int getItemCount() {
        return mData.length;
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView tech_icon;
        public CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.card_view);
            tech_icon = (ImageView) itemView.findViewById(R.id.tech_logo_view);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
            Toast.makeText(ctx, "You've clicked " + mData[getAdapterPosition()].getName(), Toast.LENGTH_SHORT).show();
        }
    }

    // allows clicks events to be caught
    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
