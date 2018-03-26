package com.example.tudorckalisch.flowerindustry.ui.main.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.tudorckalisch.flowerindustry.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by tudor.c.kalisch on 23-Mar-18.
 */

public class FlowerViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.flower_cardView)
    CardView container;
    @BindView(R.id.flower_row_description)
    TextView description;
    @BindView(R.id.flower_row_price)
    TextView price;
    @BindView(R.id.flower_row_deliver_to)
    TextView deliver_to;

    public FlowerViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
