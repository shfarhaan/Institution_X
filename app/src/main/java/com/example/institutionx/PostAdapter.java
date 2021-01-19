package com.example.institutionx;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {

    private ForumFragment context;
    private List<StreamDetails> StreamDetailsList;
    private LayoutInflater streamLayoutInflater;

    public PostAdapter(ForumFragment context, List<StreamDetails> streamDetailsList) {
        this.context = context;
        this.StreamDetailsList = streamDetailsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.comment_list_view, parent, false);
//        ViewHolder viewHolder = new ViewHolder(view);

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.comment_list_view, parent, false);
        PostAdapter.ViewHolder holder = new PostAdapter.ViewHolder(view);
        return new PostAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        StreamDetails streamDetails = StreamDetailsList.get(position);

        holder.tv_name.setText(streamDetails.getUserName());
        holder.tv_time.setText(streamDetails.getTime());
        holder.tv_no_of_comments.setText(streamDetails.getNumberOfComments() + " Comments");
        holder.tv_postDetails.setText(streamDetails.getPostDetail());

    }

    @Override
    public int getItemCount() {
        return StreamDetailsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_name, tv_no_of_comments, tv_time, tv_postDetails;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_name = (TextView)itemView.findViewById(R.id.username);
            tv_time = (TextView)itemView.findViewById(R.id.postTime);
            tv_no_of_comments = (TextView)itemView.findViewById(R.id.no_of_comments);
            tv_postDetails = (TextView)itemView.findViewById(R.id.post_details);
        }
    }
}