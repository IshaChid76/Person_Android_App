package com.example.person;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter <MyAdapter.ViewHolder>{

    Context context;
    private ArrayList<User> mList;
    private onItemClickListerner mListener;

    public interface onItemClickListerner {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(onItemClickListerner listener){
        this.mListener = listener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView name_card_view, phone_no_card_view, emailId_card_view;

        public ViewHolder(View itemView, final onItemClickListerner listener) {
            super(itemView);

            name_card_view = itemView.findViewById(R.id.name_card_view);
            phone_no_card_view = itemView.findViewById(R.id.phone_no_card_view);
            emailId_card_view = itemView.findViewById(R.id.emailId_card_view);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

    public MyAdapter(ArrayList<User> mList, Context context){
        this.mList = mList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder( ViewGroup parent, int i) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view,parent,false);
        MyAdapter.ViewHolder vh = new MyAdapter.ViewHolder(v,mListener);
        return vh;
    }

    @Override
    public void onBindViewHolder( MyAdapter.ViewHolder viewHolder, int i) {

        User CurrentUser = mList.get(i);

        viewHolder.name_card_view.setText(CurrentUser.getName());
        viewHolder.phone_no_card_view.setText(String.valueOf(CurrentUser.getPhone()));
        viewHolder.emailId_card_view.setText(CurrentUser.getEmail());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}

