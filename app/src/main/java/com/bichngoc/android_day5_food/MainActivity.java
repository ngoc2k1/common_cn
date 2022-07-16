package com.bichngoc.android_day5_food;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Food food;//food -> mFoodData -> mFoodAdapter -> lvCustom
    private ArrayList<Food> mFoodData;
    private FoodAdapter mFoodAdapter;//nơi để nạp dl vào
    @Nullable
    @BindView(R.id.lvCustom)
    ListView lvCustom;
    @Nullable
    @BindView(R.id.btn_add)
    Button btn_add;
    @Nullable
    @BindView(R.id.tvFoodName)
    TextView tvFoodName;
    @Nullable
    @BindView(R.id.tvTime)
    TextView tvTime;
    @Nullable
    @BindView(R.id.tvDistance)
    TextView tvDistance;
    @Nullable
    @BindView(R.id.tvRatingStar)
    TextView tvRatingStar;
    @Nullable
    @BindView(R.id.tvCategory)
    TextView tvCategory;
    @Nullable
    @BindView(R.id.tvStatus)
    TextView tvStatus;
    @Nullable
    @BindView(R.id.imgFood)
    ImageView imgFood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initDataCustom();
        initView();
    }

    private void initDataCustom() {//load từ csdl lên || down từ mạng về
        mFoodData = new ArrayList<>();
        mFoodData.clear();//tao cac O, truyen dl vao
        Food foodA = new Food("Tiệm Trà Sữa Coca Tea", "", "25 phút", "1,4 km", "4.5(207)", "Trà sữa", "Sắp đóng cửa", 0);
        Food foodB = new Food("Tiến Chân Gà", "", "20 phút", "0,7 km", "", "Ăn Vặt", "", 1);
        Food foodC = new Food("Lò Bánh Mì Hải An", "", "25 phút", "0,9 km", "3.7 (103)", "Bánh Mì - Xôi", " Uư đãi đến 100K", 2);
        mFoodData.add(foodA);
        mFoodData.add(foodB);
        mFoodData.add(foodC);
    }

    private void initView() {
        ButterKnife.bind(this);//ánh xạ tương ứng, chưa truyền/lấy dl
        btn_add.setOnClickListener(this);

        if (mFoodData != null & mFoodData.size() > 0) {
            mFoodAdapter = new FoodAdapter(mFoodData, getApplicationContext());//constructor
            lvCustom.setAdapter(mFoodAdapter);
        } else { //hien thi list ds co layout giong nhau
            Toast.makeText(getApplicationContext(), "Chua co dl", Toast.LENGTH_LONG);
        }

        lvCustom.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @SuppressLint("WrongConstant")
            @Override//view là layout_item_food, vì ở trong FoodAdapter
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, FoodDetailActivity.class);
                Bundle bundle = new Bundle();
                Food food = mFoodData.get(i);//lấy ra vị trí i, còn view là sửa UI
                bundle.putSerializable(Global.INFOR_DETAIL, food);
                intent.putExtras(bundle);
                startActivity(intent);
//                TextView tvFoodName = view.findViewById(R.id.tvFoodName);
//                Log.d("TAG", "onItemClick: "+tvFoodName.getText().toString());
//                tvFoodName.setTextColor(Color.parseColor("#FFFFFF"));
//                Log.d("TAG", "onItemClick: "+Color.parseColor("#FFFFFF"));
            }
        });

        lvCustom.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int pos, long l) {
                Food food = mFoodData.get(pos);
                Toast.makeText(getApplicationContext(), "Món ăn này sẽ bị xóa", Toast.LENGTH_LONG).show();
                removeItem(pos);
                return true;
            }
        });
    }

    private void removeItem(int pos) {
        mFoodData.remove(pos);
        mFoodAdapter.notifyDataSetChanged();//bao gồm dòng 81,82 ?
    }

    private void addItem() {
        Food food = new Food("Bánh Mì Yame - Tú Hoàng", "", "25 phút", "1,8 km", "4.4 (69)", "Bánh Mì - Xôi", " Uư đãi đến 100K", 0);
        food.setImgFood("https://inhat.vn/ha-noi/wp-content/uploads/2019/05/mon-an-vat-ha-noi-13-1.jpg");
        mFoodData.add(mFoodData.size(), food);
        mFoodAdapter.notifyDataSetChanged();
        lvCustom.smoothScrollToPosition(mFoodData.size());
        Toast.makeText(this, "Vừa thêm món cuối", Toast.LENGTH_SHORT).show();
        Toast.makeText(getApplicationContext(), "Thêm " + food.getImgFood(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_add:
                addItem();
                break;
        }
    }
}