package com.prototype.ditenun.ditenunuiprototype.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.prototype.ditenun.ditenunuiprototype.R;
import com.prototype.ditenun.ditenunuiprototype.activity.DescTenunActivity;
import com.prototype.ditenun.ditenunuiprototype.activity.MoreActivity;
import com.prototype.ditenun.ditenunuiprototype.model.Ulos;

import java.util.Collections;
import java.util.List;


public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.MyViewHolder> {

    private static final String TAG = "RecyclerViewAdapter";

    List<Ulos> horizontalList = Collections.emptyList();
    Context mContext;
    String daerah;


    public HorizontalAdapter(List<Ulos> horizontalList, Context mContext, String daerah) {
        this.horizontalList = horizontalList;
        this.mContext = mContext;
        this.daerah = daerah;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView txtview;
        public MyViewHolder(View view) {
            super(view);
            imageView = (ImageView) view.findViewById(R.id.gambar);
            txtview = (TextView) view.findViewById(R.id.title);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.motif_home_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        holder.imageView.setImageResource(horizontalList.get(position).imageId);
        holder.txtview.setText(horizontalList.get(position).nama);

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                String list = horizontalList.get(position).nama.toString();

                if(position == 3){
                    Intent intent = new Intent(mContext, MoreActivity.class);
                    intent.putExtra("daerah", daerah);
                    mContext.startActivity(intent);
                } else {
                    Intent intent = new Intent(mContext, DescTenunActivity.class);
                    mContext.startActivity(intent);
                }
            }

        });

    }



    @Override
    public int getItemCount()
    {
        return horizontalList.size();
    }
}
