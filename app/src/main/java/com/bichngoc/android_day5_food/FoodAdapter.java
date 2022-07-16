package com.bichngoc.android_day5_food;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;

public class FoodAdapter extends BaseAdapter {
    private ArrayList<Food> mFoodData;
    private Context context;

    public FoodAdapter(ArrayList<Food> FoodData, Context context) {
        this.mFoodData = FoodData;
        this.context = context;//c1
    }

    @Override
    public int getCount() {
        return mFoodData.size();
    }


    @Override
    public Object getItem(int position) {
        return mFoodData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return mFoodData.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View foodView;
        //this.context = parent.getContext();c2
        if (convertView == null) {
            foodView = LayoutInflater
                    .from(parent.getContext())
                    .inflate(R.layout.layout_item_food, parent, false);
        } else {
            foodView = convertView;
        }
        //ánh xạ -> lấy ra dl food khi biết vị trí -> gán view
        TextView tvFoodName = foodView.findViewById(R.id.tvFoodName);
        ImageView imgFood = foodView.findViewById(R.id.imgFood);
        TextView tvTime = foodView.findViewById(R.id.tvTime);
        TextView tvDistance = foodView.findViewById(R.id.tvDistance);
        TextView tvRatingStar = foodView.findViewById(R.id.tvRatingStar);
        TextView tvCategory = foodView.findViewById(R.id.tvCategory);

        Food food = (Food) getItem(position);

        tvFoodName.setText(food.getFoodName() + "");
        tvTime.setText(food.getTime() + "");
        tvDistance.setText(food.getDistance() + "");
        tvRatingStar.setText(food.getRatingStar() + "");
        tvCategory.setText(food.getCategory() + "");
        tvCategory.setText(food.getStatus() + "");

        if (food.getImgFood() != null && !food.getImgFood().trim().equals("")) {
            Glide.with(context)
                    .load(food.getImgFood())
                    .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                    .placeholder(R.drawable.img_error)
                    .into(imgFood);
        } else {
            imgFood.setImageResource(R.drawable.img_error);
        }
        return foodView;
    }
}
