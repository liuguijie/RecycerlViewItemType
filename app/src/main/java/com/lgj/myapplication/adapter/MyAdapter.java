package com.lgj.myapplication.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.lgj.myapplication.R;
import com.lgj.myapplication.bean.PersonBean;

import java.util.List;

/**
 * @author 刘桂杰
 * @package com.lgj.myapplication
 * @date 2020/8/18 13:39
 * @description $
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> {

    private LayoutInflater inflater;
    private List<PersonBean> list;
    private Context mContext;

    public MyAdapter(Context mContext) {
        this.mContext = mContext;
        inflater = LayoutInflater.from(mContext);
    }

    public void setData(List<PersonBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        return list.get(position).getType();
    }

    @SuppressLint("InflateParams")
    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MyHolder myHolder = null;
        View view;
        if (viewType == PersonBean.itemTypeDate) {
            view = inflater.inflate(R.layout.recycler_item_layout, null);
            myHolder = new MyHolder(view, PersonBean.itemTypeDate);
        } else if (viewType == PersonBean.itemTypeImage) {
            view = inflater.inflate(R.layout.recycler_item1_layout, null);
            myHolder = new MyHolder(view, PersonBean.itemTypeImage);
        }
        assert myHolder != null;
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        if (holder.type==PersonBean.itemTypeDate){
            holder.date.setText(list.get(position).getDate());
        }else {
            Glide.with(mContext).load(list.get(position).getDate()).into(holder.img);
        }
    }

    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }

    static class MyHolder extends RecyclerView.ViewHolder {
        private TextView date;
        private ImageView img;
        int type;
        public MyHolder(@NonNull View itemView, int type) {
            super(itemView);
            this.type=type;
            if (type == PersonBean.itemTypeDate) {
                date = itemView.findViewById(R.id.item_date);
            } else if (type == PersonBean.itemTypeImage) {
                img = itemView.findViewById(R.id.item_img);
            }
        }
    }
}
