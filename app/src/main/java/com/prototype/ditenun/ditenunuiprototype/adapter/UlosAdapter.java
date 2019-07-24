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
import com.prototype.ditenun.ditenunuiprototype.model.UlosData;

import java.util.List;


public class UlosAdapter extends RecyclerView.Adapter<UlosViewHolder> {

    private Context mContext;
    private List<UlosData> mUlosList;

    public UlosAdapter(Context mContext, List<UlosData> mUlosList) {
        this.mContext = mContext;
        this.mUlosList = mUlosList;
    }

    @Override
    public UlosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.motif_lain_row, parent, false);
        return new UlosViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(final UlosViewHolder holder, final int position) {
        holder.mImage.setImageResource(mUlosList.get(position).getFlowerImage());
        holder.mTitle.setText(mUlosList.get(position).getFlowerName());

        holder.mImage.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
            Intent intent = new Intent(mContext, DescTenunActivity.class);
            mContext.startActivity(intent);
            }

        });
    }

    @Override
    public int getItemCount() {
        return mUlosList.size();
    }
}

class UlosViewHolder extends RecyclerView.ViewHolder {

    ImageView mImage;
    TextView mTitle;

    UlosViewHolder(View itemView) {
        super(itemView);

        mImage = itemView.findViewById(R.id.ivImage);
        mTitle = itemView.findViewById(R.id.tvTitle);
    }
}
