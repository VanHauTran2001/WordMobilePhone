package com.mobilephone.worldmobilephone;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mobilephone.worldmobilephone.databinding.ItemPhoneBinding;

import java.util.List;

public class AdapterPhone extends RecyclerView.Adapter<AdapterPhone.PhoneViewHolder>{
    private Context context;
    private List<Phone> phoneList;
    private ItemPhoneBinding binding;

    public AdapterPhone(Context context, List<Phone> phoneList) {
        this.context = context;
        this.phoneList = phoneList;
    }

    @NonNull
    @Override
    public PhoneViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_phone,parent,false);
        binding = DataBindingUtil.bind(view);
        return new PhoneViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull PhoneViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Phone phone = phoneList.get(position);
        Glide.with(context).load(phone.getImage()).into(binding.imgPhone);
        binding.txtNamePhone.setText(phone.getName());
        binding.txtPriceSells.setText(phone.getPriceSel());
        binding.txtPrice.setText(phone.getPrice());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,DetailsActivity.class);
                intent.putExtra("image",phone.getImage());
                intent.putExtra("name",phone.getName());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return phoneList.size();
    }

    public class PhoneViewHolder extends RecyclerView.ViewHolder{

        public PhoneViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
