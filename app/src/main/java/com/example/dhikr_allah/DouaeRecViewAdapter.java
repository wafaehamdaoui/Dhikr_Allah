package com.example.dhikr_allah;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class DouaeRecViewAdapter extends RecyclerView.Adapter<DouaeRecViewAdapter.ViewHolder>{
    private static final String TAG = "DouaeRecViewAdapter";

    private ArrayList<Douae> douaeList = new ArrayList<>();
    private Context mContext;

    public DouaeRecViewAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_douae,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG,"onbindViewHolder:Called");
        holder.content.setText(douaeList.get(position).getContent());
        holder.counter.setText(douaeList.get(position).getCount());
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Integer.valueOf(holder.counter.getText().toString())>1){
                    holder.counter.setText(Integer.valueOf(holder.counter.getText().toString())-1+"");
                }else {
                    holder.counter.setText("\uD83D\uDC4D");
                    Toast.makeText(mContext, "التالي!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return douaeList.size();
    }
    public void setDouaeList(ArrayList<Douae> douaeList) {
        this.douaeList = douaeList;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private CardView parent;
        private TextView content;
        private TextView counter;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            parent=itemView.findViewById(R.id.parent);
            content=itemView.findViewById(R.id.content);
            counter=itemView.findViewById(R.id.counter);
        }
    }
}
