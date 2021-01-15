package com.example.institutionx;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private LayoutInflater layoutInflater;
    private List<String> data;
    private Context mContext;
    private List<ClassDetails> classDetailsList;

    public RecyclerViewAdapter(Context mContext, List<ClassDetails> classDetailsList) {
        this.mContext = mContext;
        this.classDetailsList = classDetailsList;
    }

//    RecyclerViewAdapter(Context context, List<String> data){
//        this.layoutInflater = LayoutInflater.from(context);
//        this.data = data;
//    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.course_list_view,null);
        ViewHolder holder = new ViewHolder(view);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ClassDetails classDetails = classDetailsList.get(position);

        holder.courseName.setText(classDetails.getCourseName());
        holder.courseCode.setText(classDetails.getCourseCode());
        holder.courseTime.setText(String.valueOf(classDetails.getCourseTime()));

    }

    @Override
    public int getItemCount() {
        return classDetailsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView courseName, courseCode, courseTime;
        Button joinClassButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            courseName = itemView.findViewById(R.id.course_name);
            courseCode = itemView.findViewById(R.id.course_code);
            courseTime = itemView.findViewById(R.id.course_time);
            joinClassButton = itemView.findViewById(R.id.joinClassBtn);

            joinClassButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), ClassroomActivity.class);
                    v.getContext().startActivity(intent);
                }
            });

/*            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), ClassroomActivity.class);
                    v.getContext().startActivity(intent);
                }
            });*/
        }
    }

}
