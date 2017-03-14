package com.example.pc.retrofit_server.viewholder;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.pc.retrofit_server.R;

/**
 * Created by pc on 3/10/2017.
 */

public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    public TextView name, email,phone;

    public RecyclerViewHolder(View itemView) {
        super(itemView);

        itemView.setOnClickListener(this);

        name = (TextView) itemView.findViewById(R.id.name);
        email = (TextView) itemView.findViewById(R.id.email);
        phone = (TextView) itemView.findViewById(R.id.phone);
    }

    @Override
    public void onClick(View view) {
        //Toast.makeText(, "", Toast.LENGTH_SHORT).show();
    }

}
