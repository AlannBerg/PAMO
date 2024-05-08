package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.myapplication.placeholder.PlaceholderContent.PlaceholderItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link PlaceholderItem}.
 * TODO: Replace the implementation with code for your data type.
 */
public class ShopListViewAdapter extends RecyclerView.Adapter<ShopListViewAdapter.ViewHolder> {

    private final List<String> products;
    private boolean[] checkedState;


    public ShopListViewAdapter(List<String> products) {
        this.products = products;
        this.checkedState = new boolean[products.size()];
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.textViewItemName.setText(products.get(position));
        holder.checkBoxItem.setChecked(checkedState[position]);
        holder.checkBoxItem.setOnCheckedChangeListener((buttonView, isChecked) -> {
            checkedState[position] = isChecked;
        });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewItemName;
        public CheckBox checkBoxItem;

        public ViewHolder(View itemView) {
            super(itemView);
            textViewItemName = (TextView) itemView.findViewById(R.id.textViewItemName);
            checkBoxItem = (CheckBox) itemView.findViewById(R.id.checkboxItem);
        }
    }
}