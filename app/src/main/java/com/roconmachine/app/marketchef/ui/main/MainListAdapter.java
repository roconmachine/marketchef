package com.roconmachine.app.marketchef.ui.main;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.roconmachine.app.marketchef.R;
import com.roconmachine.app.marketchef.data.model.SearchedItem;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by asus on 12/26/2016.
 */

public class MainListAdapter extends RecyclerView.Adapter<MainListAdapter.MainListAdapterHolder> {


    private List<SearchedItem> items;

    @Inject
    public MainListAdapter()
    {
        items = new ArrayList<>(0);
    }

    public void setData(List<SearchedItem> searchedItems){
        items = searchedItems;
    }
    public List<SearchedItem> getItems()
    {
        return this.items;
    }

    public SearchedItem getItem(int position){
        return this.getItems().get(position);
    }
    @Override
    public MainListAdapterHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new MainListAdapterHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MainListAdapterHolder holder, int position) {

        SearchedItem searchedItem = items.get(position);
        holder.ivThumb.setImageDrawable(searchedItem.getThumb());
        holder.tvTitle.setText(searchedItem.getTitle());
        holder.tvPrice.setText(searchedItem.getPrice());
        holder.tvDescription.setText(searchedItem.getDescription());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    class MainListAdapterHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.iv_item_thumb)
        ImageView ivThumb;
        @BindView(R.id.tv_item_title)
        TextView tvTitle;
        @BindView(R.id.tv_item_price)
        TextView tvPrice;
        @BindView(R.id.tv_item_description)
        TextView tvDescription;

        public MainListAdapterHolder(View viewItemParents) {
            super(viewItemParents);
            ButterKnife.bind(this, itemView);
        }
    }
}
