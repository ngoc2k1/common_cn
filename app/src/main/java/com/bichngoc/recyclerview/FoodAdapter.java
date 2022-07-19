package com.bichngoc.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {
    ArrayList<Food> mFood;
    Food food;
    private IOnClickListener callback;

    public FoodAdapter(ArrayList<Food> mFood) {
        this.mFood = mFood;
    }

    public void setOnItemClickListener(IOnClickListener callback) {
        this.callback = callback;
    }

    @NonNull
    @Override
    public FoodAdapter.FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_food, parent, false);
        return new FoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodAdapter.FoodViewHolder holder, int position) {
        food = mFood.get(position);
        holder.tvName.setText(food.getName());
        holder.tvPrice.setText(food.getPrice());
        holder.tvStar.setText(food.getStar());
    }

    @Override
    public int getItemCount() {
        return mFood.size();
    }

    public class FoodViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvName)
        TextView tvName;
        @BindView(R.id.tvPrice)
        TextView tvPrice;
        @BindView(R.id.tvStar)
        TextView tvStar;


        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (callback != null) {
                        callback.onClickListener(getAdapterPosition(), view);
                    }
                }
            });

        }
    }
}
