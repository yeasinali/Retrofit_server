package com.example.pc.retrofit_server.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pc.retrofit_server.R;
import com.example.pc.retrofit_server.model.User;
import com.example.pc.retrofit_server.viewholder.RecyclerViewHolder;

import java.util.List;

/**
 * Created by pc on 3/10/2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {

    private List<User> item;


    public RecyclerViewAdapter(List<User> list) {
        this.item = list;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_row, null);

        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(layoutView);

        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {

        holder.name.setText(item.get(position).getName());
        holder.email.setText(item.get(position).getEmail());
        holder.phone.setText(item.get(position).getPhone());
    }

    @Override
    public int getItemCount() {
        return item.size();
    }
}
