package com.example.mutablelivedatasqlite;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Date;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    List<Favourites> favouritesList;
    Context context;

    public RecyclerAdapter(Context context, List<Favourites> favouritesList) {
        this.favouritesList = favouritesList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_row, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Favourites favourites = favouritesList.get(position);
        holder.tvUrl.setText(favourites.mUrl);
        holder.tvDate.setText((new Date(favourites.mDate).toString()));
    }

    @Override
    public int getItemCount() {
        return favouritesList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvUrl, tvDate;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvDate = itemView.findViewById(R.id.tvDate);
            tvUrl = itemView.findViewById(R.id.tvUrl);
        }
    }

}
