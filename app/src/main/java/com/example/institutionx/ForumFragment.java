package com.example.institutionx;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ForumFragment extends Fragment {
    private static final String STREAM_LIST_URL = "http://192.168.0.104/login_android/streamList.php";

    RecyclerView recyclerView;
    List<StreamDetails> streamDetailsList;
    PostAdapter postAdapter;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_stream, container, false);

//        recyclerView = view.findViewById(R.id.comment_recyclerview);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        streamDetailsList = new ArrayList<>();

        recyclerView = (RecyclerView) view.findViewById(R.id.comment_recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        loadStreamList();

        postAdapter = new PostAdapter(this,streamDetailsList);
        recyclerView.setAdapter(postAdapter);
        return view;
    }


    private void loadStreamList() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, STREAM_LIST_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            //converting the string to json array object
                            JSONArray array = new JSONArray(response);

                            //traversing through all the object
                            for (int i = 0; i < array.length(); i++) {

                                //getting product object from json array
                                JSONObject arrayJSONObject = array.getJSONObject(i);

                                //adding the product to product list
                                streamDetailsList.add(new StreamDetails(
                                        arrayJSONObject.getString("User_Name"),
                                        arrayJSONObject.getString("Time"),
                                        arrayJSONObject.getString("Post_Details"),
                                        arrayJSONObject.getString("Number_of_Comments")
                                ));
                            }

                            //creating recyclerViewAdapter object and setting it to recyclerview
                            PostAdapter postAdapter = new PostAdapter(ForumFragment.this, streamDetailsList);
                            recyclerView.setAdapter(postAdapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        //adding our stringrequest to queue
        Volley.newRequestQueue(getContext()).add(stringRequest);
    }

}
