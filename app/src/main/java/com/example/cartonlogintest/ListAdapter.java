package com.example.cartonlogintest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyViewHolder> {

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView nameTextView;

        public MyViewHolder(View temp){
            super(temp);
            nameTextView = (TextView) temp.findViewById(R.id.item_name);
        }
    }

    private List<Item> pantry;

    public ListAdapter(List<Item> pantry){
        this.pantry = pantry;
    }

    @Override
    public ListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int typeOfView){
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View listView = inflater.inflate(R.layout.item_row,parent,false);
        MyViewHolder vh = new MyViewHolder(listView);
        return vh;

    }


    @Override
    public void onBindViewHolder(MyViewHolder vh, int pos){
        Item temp = pantry.get(pos);
        TextView textView = vh.nameTextView;
        textView.setText(temp.getName() +"\t," + temp.getLabel() +"\t," + temp.getQuantity() +"\t," + temp.getPrice());
    }

    @Override
    public int getItemCount(){
        return pantry.size();
    }
}
