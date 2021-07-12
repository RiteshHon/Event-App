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

import com.app.eventapp.Model.EventModel;
import com.app.eventapp.R;
import com.bumptech.glide.Glide;
import java.util.ArrayList;
import java.util.List;

public class EventRecyclerAdapter extends RecyclerView.Adapter<EventRecyclerAdapter.ViewHolder> {

    List<EventModel> eventModel = new ArrayList<>();
    Context context;

    public EventRecyclerAdapter(Context context, List<EventModel> eventModels) {
        this.context = context;
        this.eventModel = eventModels;
    }

    @NonNull
    @Override
    public EventRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_event, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventRecyclerAdapter.ViewHolder holder, int position) {

        holder.tv_eventName.setText(eventModel.get(position).getEventName());
        Glide.with(context).load(eventModel.get(position).getEventImage()).into(holder.img_event);

        holder.rl_event.setOnClickListener(v -> {
            Toast.makeText(context, ""+eventModel.get(position).getEventName(), Toast.LENGTH_SHORT).show();
        });

    }

    @Override
    public int getItemCount() {
        return eventModel.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //        Initializing Variables
        RelativeLayout rl_event;
        ImageView img_event;
        TextView tv_eventName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            rl_event = itemView.findViewById(R.id.rl_event);
            img_event = itemView.findViewById(R.id.img_event);
            tv_eventName = itemView.findViewById(R.id.tv_eventName);
        }
    }
}
