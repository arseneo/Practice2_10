package com.mirea.kt.practice2_10;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PhoneAdapter extends RecyclerView.Adapter<PhoneAdapter.PhoneViewHolder> {
    private final List<Phone> phones;

    public PhoneAdapter(List<Phone> phones) {
        this.phones = phones;
    }

    @NonNull
    @Override
    public PhoneViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.phone_item, parent, false);
        return new PhoneViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhoneViewHolder holder, int position) {
        Phone phone = phones.get(position);
        holder.modelTextView.setText(phone.getModel());
        holder.serialNumberTextView.setText(phone.getSerialNumber());
        holder.priceTextView.setText(String.valueOf(phone.getPrice()));
    }

    @Override
    public int getItemCount() {
        return phones.size();
    }

    static class PhoneViewHolder extends RecyclerView.ViewHolder {
        final TextView modelTextView;
        final TextView serialNumberTextView;
        final TextView priceTextView;

        PhoneViewHolder(View itemView) {
            super(itemView);
            modelTextView = itemView.findViewById(R.id.modelTextView);
            serialNumberTextView = itemView.findViewById(R.id.serialNumberTextView);
            priceTextView = itemView.findViewById(R.id.priceTextView);
        }
    }
}
