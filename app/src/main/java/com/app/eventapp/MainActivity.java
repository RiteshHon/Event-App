package com.app.eventapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.app.eventapp.Adapter.EventPlaceRecyclerAdapter;
import com.app.eventapp.Adapter.EventRecyclerAdapter;
import com.app.eventapp.Model.EventModel;
import com.app.eventapp.Model.EventPlaceModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv_eventPlace, rv_event;
//    Event Name
    List<EventModel> eventModels = new ArrayList<>();
    EventRecyclerAdapter eventRecyclerAdapter;
//    Event Place
    List<EventPlaceModel> eventPlaceModels = new ArrayList<>();
    EventPlaceRecyclerAdapter eventPlaceRecyclerAdapter;
//    Layout Manager
    RecyclerView.LayoutManager layoutManagerEvent, layoutManagerEventPlace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Utils.whiteIconStatusBar(this, R.color.purple_300);

        rv_eventPlace = findViewById(R.id.rv_eventPlace);
        rv_event = findViewById(R.id.rv_event);

        events();
        eventPlace();

    }

    private void events(){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Utils.api +"event.php",
                response -> {
                    eventModels.clear();
                    for (int i=0; i<response.length(); i++){
                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            EventModel eventModel = new EventModel();
                            eventModel.setEventName(jsonObject.getString("eventName"));
                            eventModel.setEventImage(jsonObject.getString("eventImage"));
                            eventModels.add(eventModel);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    eventRecyclerAdapter = new EventRecyclerAdapter(this, eventModels);
                    layoutManagerEvent = new GridLayoutManager(this, 1, RecyclerView.HORIZONTAL, false);
                    rv_event.setLayoutManager(layoutManagerEvent);
                    rv_event.setAdapter(eventRecyclerAdapter);
                },
                error -> {
                    Toast.makeText(this, ""+error, Toast.LENGTH_SHORT).show();
                }
        ){
            @Nullable
            @Override
            protected Map<String, String> getParams() {
                HashMap<String, String> param = new HashMap<>();
                param.put("key", "6C@t3?apT%hM29t7jGQay68Se@aX@b*V");
                return param;
            }
        };
        RequestQueue requestQueue1 = Volley.newRequestQueue(this);
        requestQueue1.add(stringRequest);
    }

    private void eventPlace(){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Utils.api +"eventplace.php",
                response -> {
                    eventPlaceModels.clear();
                    for (int i=0; i<response.length(); i++){
                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            EventPlaceModel eventPlaceModel = new EventPlaceModel();
                            eventPlaceModel.setEventPlaceName(jsonObject.getString("eventPlaceName"));
                            eventPlaceModel.setEventPlaceImage(jsonObject.getString("eventPlaceImage"));
                            eventPlaceModels.add(eventPlaceModel);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    eventPlaceRecyclerAdapter = new EventPlaceRecyclerAdapter(this, eventPlaceModels);
                    layoutManagerEventPlace = new GridLayoutManager(this, 2, RecyclerView.HORIZONTAL, false);
                    rv_eventPlace.setLayoutManager(layoutManagerEventPlace);
                    rv_eventPlace.setAdapter(eventPlaceRecyclerAdapter);
                },
                error -> {
                    Toast.makeText(this, ""+error, Toast.LENGTH_SHORT).show();
                }
        ){
            @Nullable
            @Override
            protected Map<String, String> getParams() {
                HashMap<String, String> param = new HashMap<>();
                param.put("key", "R4n4a59V?k2Fu?Y");
                return param;
            }
        };
        RequestQueue requestQueue1 = Volley.newRequestQueue(this);
        requestQueue1.add(stringRequest);
    }

}