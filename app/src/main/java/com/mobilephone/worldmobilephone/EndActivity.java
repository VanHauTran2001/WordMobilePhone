package com.mobilephone.worldmobilephone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.mobilephone.worldmobilephone.databinding.ActivityEndBinding;

public class EndActivity extends AppCompatActivity {
    private ActivityEndBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_end);
        binding.linear1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    showMessage("Email");
            }
        });
        binding.linear2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMessage("Phone");
            }
        });
        binding.linear3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMessage("Payment");
            }
        });
        binding.linear4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMessage("Address");
            }
        });
    }
    private void showMessage(String message){
        Toast.makeText(EndActivity.this, message, Toast.LENGTH_SHORT).show();
    }
}