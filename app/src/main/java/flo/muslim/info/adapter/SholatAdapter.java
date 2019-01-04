package flo.muslim.info.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import flo.muslim.info.R;
import flo.muslim.info.model.SholatModel;


public class SholatAdapter extends RecyclerView.Adapter<SholatAdapter.ViewHolder> {
    private Context mContext;
//    private OnItemClickListener mOnItemClickListener;
    private List<SholatModel> mSholatModel;

    public SholatAdapter(Context context, List<SholatModel> listItems) {
        mContext = context;
        mSholatModel = listItems;
    }

//    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
//        mOnItemClickListener = onItemClickListener;
//    }

    public SholatModel getItem(int position) {
        return mSholatModel.get(position);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        SholatModel listItem = mSholatModel.get(position);
        holder.tvTitle.setText(listItem.getStringTitleId());
        Glide.with(mContext).load(listItem.getDrawableResId()).into(holder.ivExp);
//        holder.cvSholat.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                SholatModel clickedDataItem = mSholatModel.get(position);
//
//            }
//        });
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sholat, parent, false);
        return new ViewHolder(v);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvTitle;
        public ImageView ivExp;
        public CardView cvSholat;

        private ViewHolder(View v) {
            super(v);
            tvTitle = v.findViewById(R.id.tvSholatItem);
            ivExp = v.findViewById(R.id.ivSholatItem);
            cvSholat = v.findViewById(R.id.cvSholatItem);
        }

    }

    @Override
    public int getItemCount() {
        return mSholatModel != null ? mSholatModel.size() : 0;
    }


}
