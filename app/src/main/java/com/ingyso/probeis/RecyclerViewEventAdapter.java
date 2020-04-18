package com.ingyso.probeis;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class RecyclerViewEventAdapter extends RecyclerView.Adapter<RecyclerViewEventAdapter.ViewHolder> {
    private static final String TAG = "RecyclerViewAdapter - E";

    // Vars
    private ArrayList<String> mNames;
    private ArrayList<String> mDescriptions = new ArrayList<>();
    private ArrayList<Calendar> mDates = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();
    private ArrayList<String> mMapUrls = new ArrayList<>();
    private ArrayList<String> mQrUrls = new ArrayList<>();
    private ArrayList<Boolean> mRegistered = new ArrayList<>();
    private Context mContext;

    OnItemClick onItemClick;

    public void setOnItemClick(OnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }

    public interface OnItemClick {
        void getPosition(); //pass any things
    }

    public RecyclerViewEventAdapter(Context context, ArrayList<String> names, ArrayList<String> descriptions,
            ArrayList<String> imageUrls, ArrayList<Calendar> dates, ArrayList<String> mapUrls,
            ArrayList<String> qrUrls, ArrayList<Boolean> registered) {
        mNames = names;
        mDescriptions = descriptions;
        mImageUrls = imageUrls;
        mMapUrls = mapUrls;
        mDates = dates;
        mQrUrls = qrUrls;
        mRegistered = registered;
        mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "Event - onCreateViewHolder: called");

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_event_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        /*
        Glide.with(mContext)
                .asBitmap()
                .load(mImageUrls.get(position))
                .into(holder.image);

        Glide.with(mContext)
                .asBitmap()
                .load(mMapUrls.get(position))
                .into(holder.map);

        if (mRegistered.get(position) == true) {
            Glide.with(mContext)
                    .asBitmap()
                    .load(mQrUrls.get(position))
                    .into(holder.qr);
        }
         */

        //holder.image.setImageResource(R.drawable.img5);
        holder.name.setText(mNames.get(position));
        holder.description.setText(mDescriptions.get(position));
        //holder.date.setText(mDates.get(position).toString());
        /*holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, mNames.get(position), Toast.LENGTH_SHORT).show();
            }
        });
         */
        /*
        holder.qr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(this, "Codigo de Registro");
            }
        });*/

        /*
        holder.qr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClick.getPosition();
            }
        });
         */
    }

    @Override
    public int getItemCount() {
        return mNames.size();
    }

    public void showDialog(Activity activity, String msg){
        final Dialog qrDialog = new Dialog(activity);
        qrDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        qrDialog.setCancelable(false);
        qrDialog.setContentView(R.layout.layout_event_qr);

        TextView eventName = qrDialog.findViewById(R.id.event_name_dialog);
        eventName.setText(msg);

        ImageView backButton = qrDialog.findViewById(R.id.back_button_qr_dialog);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                qrDialog.dismiss();
            }
        });

        qrDialog.show();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView image;
        ImageView map;
        TextView date;
        TextView description;
        ImageView qr;
        Boolean registered;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.event_title);
            //image = itemView.findViewById(R.id.event_image);
            //map = itemView.findViewById(R.id.event_map);
            description = itemView.findViewById(R.id.event_description);
            //date = itemView.findViewById(R.id.event_date);
            /*
            if (registered) {
                qr = itemView.findViewById(R.id.event_qr_image);
                qr.setVisibility(View.VISIBLE);
            }
            else
                qr.setVisibility(View.GONE);
             */
        }
    }
}
