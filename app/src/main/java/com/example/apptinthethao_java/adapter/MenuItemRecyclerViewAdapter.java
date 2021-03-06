package com.example.apptinthethao_java.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apptinthethao_java.R;

import java.util.ArrayList;

public class MenuItemRecyclerViewAdapter extends RecyclerView.Adapter<MenuItemRecyclerViewAdapter.ViewHolder> {
    private Context context;
    private ArrayList<String> arrayList;
    private ItemClickInterface itemClickInterface;
    public void setOnClickItemRecyclerView(ItemClickInterface itemRecyclerView){
        itemClickInterface = itemRecyclerView;
    }
    public MenuItemRecyclerViewAdapter( ArrayList<String> arrayList, Context mContext) {
        this.arrayList = arrayList;
        this.context = mContext;
    }
    @NonNull
    @Override
    public MenuItemRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View heroView = inflater.inflate(R.layout.item_menu_recyclerview, parent, false);
        ViewHolder viewHolder = new ViewHolder(heroView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MenuItemRecyclerViewAdapter.ViewHolder holder, int position) {
        holder.bind();
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView textViewBtn;
        public CardView cardViewBtn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewBtn = itemView.findViewById(R.id.tvItemMenuRecyclerView);
            cardViewBtn = itemView.findViewById(R.id.cvMenuRecyclerView);
        }
        public void bind(){
            textViewBtn.setText(arrayList.get(getAdapterPosition()));
            cardViewBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemClickInterface.onClick(v, getAdapterPosition());
                }
            });
        }

    }

}



