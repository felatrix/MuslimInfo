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

import java.util.List;

import flo.muslim.info.R;
import flo.muslim.info.model.ZakatModel;


public class ZakatAdapter extends RecyclerView.Adapter<ZakatAdapter.ViewHolder> {
    private Context mContext;
//    private OnItemClickListener mOnItemClickListener;
    private List<ZakatModel> mZakatModel;

    public ZakatAdapter(Context context, List<ZakatModel> listItems) {
        mContext = context;
        mZakatModel = listItems;
    }

//    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
//        mOnItemClickListener = onItemClickListener;
//    }

    public ZakatModel getItem(int position) {
        return mZakatModel.get(position);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        ZakatModel listItem = mZakatModel.get(position);
        holder.tvTitle.setText(listItem.getStringTitleId());
//        holder.cvSholat.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ZakatModel clickedDataItem = mZakatModel.get(position);
//
//            }
//        });
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_zakat, parent, false);
        return new ViewHolder(v);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvTitle;
        public CardView cvZakat;

        private ViewHolder(View v) {
            super(v);
            tvTitle = v.findViewById(R.id.tvZakatItem);
            cvZakat = v.findViewById(R.id.cvZakatItem);
        }

    }

    @Override
    public int getItemCount() {
        return mZakatModel != null ? mZakatModel.size() : 0;
    }


}
