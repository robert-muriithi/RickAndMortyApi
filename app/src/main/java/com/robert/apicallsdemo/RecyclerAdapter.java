package com.robert.apicallsdemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    RickyMorty arrayList;

    public RecyclerAdapter(RickyMorty arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_row, parent , false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(arrayList.getResults().get(position).getName());
        holder.species.setText(arrayList.getResults().get(position).getSpecies());
        holder.status.setText(arrayList.getResults().get(position).getStatus());

        Glide.with(holder.itemView)
                .load(arrayList.getResults().get(position).getImage())
                .fitCenter()
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return arrayList.getResults().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView status;
        TextView species;
        ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            image = itemView.findViewById(R.id.image);
            species = itemView.findViewById(R.id.species);
            status = itemView.findViewById(R.id.status);
        }
    }
}
