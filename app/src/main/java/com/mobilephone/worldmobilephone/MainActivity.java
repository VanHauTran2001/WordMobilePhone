package com.mobilephone.worldmobilephone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.mobilephone.worldmobilephone.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private AdapterPhone adapterPhone;
    private List<Phone> phoneList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        initButtomNavigation();
        inttViewFlipper();
        intRecyler();
    }

    private void intRecyler() {
        phoneList = new ArrayList<>();
        phoneList.add(new Phone(R.drawable.iphone7,"Iphone 7 plus","6.500.000 Đ","5.500.000 Đ"));
        phoneList.add(new Phone(R.drawable.iphone1,"Iphone 8 ","7.500.000 Đ","6.500.000 Đ"));
        phoneList.add(new Phone(R.drawable.iphone6s,"Iphone 6s","3.500.000 Đ","2.500.000 Đ"));
        phoneList.add(new Phone(R.drawable.iphone6plus,"Iphone 6s plus","4.500.000 Đ","4.000.000 Đ"));
        phoneList.add(new Phone(R.drawable.iphonex,"Iphone X","9.500.000 Đ","8.000.000 Đ"));
        phoneList.add(new Phone(R.drawable.iphone7,"Iphone 7","7.500.000 Đ","7.000.000 Đ"));
        adapterPhone = new AdapterPhone(this,phoneList);
        binding.recylerPhone.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        binding.recylerPhone.setAdapter(adapterPhone);
    }

    private void inttViewFlipper() {
        ArrayList<Integer> mangquangcao = new ArrayList<>();
        mangquangcao.add(R.drawable.phone6);
        mangquangcao.add(R.drawable.phone4);
        mangquangcao.add(R.drawable.phone5);
        mangquangcao.add(R.drawable.phone7);
        for (int i=0;i<mangquangcao.size();i++){
            ImageView imageView = new ImageView(getApplicationContext());
            Glide.with(getApplicationContext()).load(mangquangcao.get(i)).into(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            binding.viewFlipper.addView(imageView);
        }
        binding.viewFlipper.setFlipInterval(3000);
        binding.viewFlipper.setAutoStart(true);
        Animation animation_slide_in = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.annim_banner);
        binding.viewFlipper.setInAnimation(animation_slide_in);
    }

    private void initButtomNavigation() {
        binding.bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected( MenuItem item) {
                switch (item.getItemId()){
                    case R.id.bottomHome:
                        showMessage("Home");
                        break;
                    case R.id.bottomChat:
                        showMessage("Chat");
                        break;
                    case R.id.bottomYeuThich:
                        showMessage("Favorite");
                        break;
                    case R.id.bottomThongBao:
                        showMessage("Notification");
                        break;
                    case R.id.bottomTaiKhoan:
                        showMessage("Account");
                        break;
                }
                return true;
            }
        });

    }
    private void showMessage(String message){
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
    }
}