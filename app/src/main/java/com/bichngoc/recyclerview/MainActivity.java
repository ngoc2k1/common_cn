package com.bichngoc.recyclerview;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Nullable
    @BindView(R.id.rvInfor)
    RecyclerView rvInfor;
    @Nullable
    @BindView(R.id.edtName)
    EditText edtName;
    @Nullable
    @BindView(R.id.edtPrice)
    EditText edtPrice;
    @Nullable
    @BindView(R.id.edtStar)
    EditText edtStar;
    @Nullable
    @BindView(R.id.btn_add)
    Button btn_add;
    @Nullable
    @BindView(R.id.btn_update)
    Button btn_update;
    ArrayList<Food> mFood;
    FoodAdapter mFoodAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniData();
        initView();
    }

    private void iniData() {
        mFood = new ArrayList<>();
        mFood.clear();
        for (int i = 0; i < 3; i++) {
            Food item = new Food("a", "b", "c");
            mFood.add(item);
        }
    }

    private void initView() {
        ButterKnife.bind(this);
        btn_add.setOnClickListener(this);
        btn_update.setOnClickListener(this);
        mFoodAdapter = new FoodAdapter(mFood);
        rvInfor.setAdapter(mFoodAdapter);
        LinearLayoutManager manager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        rvInfor.setLayoutManager(manager);
        mFoodAdapter.setOnItemClickListener(new IOnClickListener() {
            @Override
            public void onClickListener(int i, View v) {
                Food food = mFood.get(i);
                edtName.setText("Hello ");
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_add:

                break;
            case R.id.btn_update:

                break;
        }
    }
}