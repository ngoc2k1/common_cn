package com.bichngoc.android_day5_food;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class FoodDetailActivity extends AppCompatActivity {
    private TextView tvFoodName, tvTime, tvDistance, tvRatingStar, tvCategory, tvStatus;
    private ImageView imgFood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_detail_food);
        initView();
        getDataFromIntentToView();
    }

    private void getDataFromIntentToView() {
        Bundle bundle = getIntent().getExtras();
        Food food = (Food) bundle.getSerializable(Global.INFOR_DETAIL);
        Log.d("FoodDetailActivity", "getDataFromIntent: " + food.toString());

        String name = food.getFoodName();
        String image = food.getImgFood();
        String time = food.getTime();
        String distance = food.getDistance();
        String rating = food.getRatingStar();
        String category = food.getCategory();
        String status = food.getStatus();// thông tin detail nhiều hơn, ss vs db?  1 food t.tính khác nhau. load ảnh

        tvFoodName.setText(name + "");
        tvTime.setText(time + "");
        imgFood.setImageResource(R.drawable.img_error);
        tvDistance.setText(distance + "");
        tvRatingStar.setText(rating + "");
        tvCategory.setText(category + "");
        tvStatus.setText(status + "");
    }

    private void initView() {
        tvFoodName = findViewById(R.id.tvInforFoodName);
        imgFood = findViewById(R.id.imgInforFood);
        tvTime = findViewById(R.id.tvInforTime);
        tvDistance = findViewById(R.id.tvInforDistance);
        tvRatingStar = findViewById(R.id.tvInforRatingStar);
        tvCategory = findViewById(R.id.tvInforCategory);
        tvStatus = findViewById(R.id.tvInforStatus);
    }
}