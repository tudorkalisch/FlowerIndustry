package com.example.tudorckalisch.flowerindustry.ui.main.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tudorckalisch.flowerindustry.R;
import com.example.tudorckalisch.flowerindustry.model.Flower;

import java.util.List;

/**
 * Created by tudor.c.kalisch on 23-Mar-18.
 */

public class FlowerAdapter extends RecyclerView.Adapter<FlowerViewHolder> implements View.OnClickListener {
    private List<Flower> myData;
    private FlowerClickListener listener;

    public FlowerAdapter(List<Flower> myData, FlowerClickListener listener) {
        this.myData = myData;
        this.listener = listener;
    }

    public interface FlowerClickListener {
        void setOnClickListener(Flower flower);
    }

    @Override
    public FlowerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView cardView = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.flower_row, parent, false);
        return new FlowerViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(FlowerViewHolder holder, int position) {
        holder.description.setText(myData.get(position).getDescription());
        holder.container.setTag(position);
        String price = Integer.toString((int) myData.get(position).getPrice());
        holder.price.setText(price);
        holder.deliver_to.setText(myData.get(position).getDeliver_to());
        holder.container.setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        return myData.size();
    }

    @Override
    public void onClick(View v) {
        int position = (int) v.getTag();
        listener.setOnClickListener(myData.get(position));
    }
}
