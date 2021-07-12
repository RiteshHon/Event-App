package com.app.eventapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.eventapp.Model.EventPlaceModel;
import com.app.eventapp.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class EventPlaceRecyclerAdapter extends RecyclerView.Adapter<EventPlaceRecyclerAdapter.ViewHolder> {

    List<EventPlaceModel> eventPlaceModels = new ArrayList<>();
    Context context;

    public EventPlaceRecyclerAdapter(Context context, List<EventPlaceModel> eventPlaceModels) {
        this.context = context;
        this.eventPlaceModels = eventPlaceModels;
    }

    @NonNull
    @Override
    public EventPlaceRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_event_place, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventPlaceRecyclerAdapter.ViewHolder holder, int position) {

        holder.tv_eventPlaceName.setText(eventPlaceModels.get(position).getEventPlaceName());
        Glide.with(context).load(eventPlaceModels.get(position).getEventPlaceImage()).into(holder.img_eventPlace);

        holder.rl_eventPlace.setOnClickListener(v -> {
            Toast.makeText(context, ""+eventPlaceModels.get(position).getEventPlaceName(), Toast.LENGTH_SHORT).show();
        });

    }

    @Override
    public int getItemCount() {
        return eventPlaceModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //        Initializing Variables
        RelativeLayout rl_eventPlace;
        ImageView img_eventPlace;
        TextView tv_eventPlaceName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            rl_eventPlace = itemView.findViewById(R.id.rl_eventPlace);
            img_eventPlace = itemView.findViewById(R.id.img_eventPlace);
            tv_eventPlaceName = itemView.findViewById(R.id.tv_eventPlaceName);
        }
    }
}
