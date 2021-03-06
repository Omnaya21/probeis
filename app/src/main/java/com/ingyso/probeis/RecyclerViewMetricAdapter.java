package com.ingyso.probeis;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class RecyclerViewMetricAdapter extends RecyclerView.Adapter<RecyclerViewMetricAdapter.ViewHolder> {
    private static final String TAG = "RecyclerViewAdapter: Mt";

    // Vars
    private ArrayList<String> mTitles;
    private ArrayList<String> mDescriptions;
    private ArrayList<String> mImageUrls;
    private Context mContext;

    public RecyclerViewMetricAdapter(Context context, ArrayList<String> titles, ArrayList<String> descriptions, ArrayList<String> imageUrls) {
        mTitles = titles;
        mDescriptions = descriptions;
        mImageUrls = imageUrls;
        mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "Metrics - onCreateViewHolder: called");

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_metric_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        /*Glide.with(mContext)
                .asBitmap()
                .load(mImageUrls.get(position))
                .into(holder.image);*/
        holder.image.setImageResource(R.drawable.metric_exit_velocity);

        holder.title.setText(mTitles.get(position));
        holder.description.setText(mDescriptions.get(position));
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, mTitles.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mTitles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView description;
        TextView title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.metric_title);
            image = itemView.findViewById(R.id.metric_image);
            description = itemView.findViewById(R.id.metric_description);
        }
    }
}
