package com.example.jsonparsing;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ArrayAdapter extends RecyclerView.Adapter<ArrayAdapter.MyViewHolder>{

    Context context;
    LayoutInflater inflater;
    List<HashMap<String, String>> contactList;

    public ArrayAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.contactList = new ArrayList<>();
    }

    public void add(List<HashMap<String, String>> arg){
        contactList.addAll(arg);
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.row_item,parent,false);

        return new  MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        HashMap<String, String> data = contactList.get(position);
        holder.bindData(data);
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView email;
        private TextView mobile;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            email = itemView.findViewById(R.id.email);
            mobile = itemView.findViewById(R.id.mobile);
        }

        public void bindData(HashMap<String, String> data){
            email.setText(data.get("email"));
            mobile.setText(data.get("mobile"));
        }
    }
}