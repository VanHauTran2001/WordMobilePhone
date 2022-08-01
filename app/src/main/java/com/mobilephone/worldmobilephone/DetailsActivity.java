package com.mobilephone.worldmobilephone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.bumptech.glide.Glide;
import com.mobilephone.worldmobilephone.databinding.ActivityDetailsBinding;

import java.util.ArrayList;
import java.util.List;

public class DetailsActivity extends AppCompatActivity {
    private ActivityDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_details);
        Intent intent = getIntent();
        int imgDetails = intent.getIntExtra("image",0);
        String nameDeails = intent.getStringExtra("name");
        Glide.with(getApplicationContext()).load(imgDetails).into(binding.imgDetails);
        binding.txtNameDetails.setText(nameDeails);
        binding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DetailsActivity.this,MainActivity.class));
            }
        });
        binding.btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DetailsActivity.this,EndActivity.class));
            }
        });
    }
}