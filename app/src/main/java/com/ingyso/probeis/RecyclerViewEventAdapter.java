package com.ingyso.probeis;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
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
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

        Glide.with(mContext)
                .asBitmap()
                .load(mImageUrls.get(position))
                .into(holder.image);
        /*
        Glide.with(mContext)
                .asBitmap()
                .load(mMapUrls.get(position))
                .into(holder.map);
        */
        //if (mRegistered.get(position) == true) {
            Glide.with(mContext)
                    .asBitmap()
                    .load(mQrUrls.get(position))
                    .into(holder.qr);
        //}

        holder.name.setText(mNames.get(position));
        holder.description.setText(mDescriptions.get(position));
        //holder.image.setImageResource(R.drawable.img5);
        //holder.date.setText(mDates.get(position).toString());

        /*holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, mNames.get(position), Toast.LENGTH_SHORT).show();
            }
        });
         */
        holder.registered = mRegistered.get(position);
        Toast.makeText(mContext, holder.name.getText(), Toast.LENGTH_SHORT).show();
        if (holder.registered) {
            //holder.qr.setVisibility(View.VISIBLE);
            holder.qr.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //showDialog((Activity) mContext, "Código de Registro");

                    AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                    View qrView = LayoutInflater.from(mContext).inflate(R.layout.layout_event_qr,null);

                    TextView eventName = qrView.findViewById(R.id.event_name_dialog);
                    eventName.setText(holder.name.getText());


                    ImageView backButton = qrView.findViewById(R.id.back_button_qr_dialog);

                    builder.setView(qrView);

                    /*
                    builder.setNegativeButton("back", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    }); */

                    final AlertDialog alertDialog = builder.create();
                    backButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            alertDialog.dismiss();
                        }
                    });
                    alertDialog.show();
                }
            });
        }
        else {
            //holder.qr.setVisibility(View.GONE);
            // Registrar para el evento
        }
    }

    @Override
    public int getItemCount() {
        return mNames.size();
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
            image = itemView.findViewById(R.id.event_image);
            //map = itemView.findViewById(R.id.event_map);
            description = itemView.findViewById(R.id.event_description);
            //date = itemView.findViewById(R.id.event_date);
            qr = itemView.findViewById(R.id.event_qr_image);
        }
    }
}
