package com.example.todoappwithfirease.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.todoappwithfirease.HomeScreen;
import com.example.todoappwithfirease.ItemClickListener;
import com.example.todoappwithfirease.MainActivity;
import com.example.todoappwithfirease.Model.Listdata;
import com.example.todoappwithfirease.R;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.MyHolder>
{

    List<Listdata> noteslist;
    public  NotesAdapter(List<Listdata> noteslist)
    {
        this.noteslist=noteslist;
    }


    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item,viewGroup,false);

        MyHolder myHolder=new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder myHolder, int position) {
        Listdata data=noteslist.get(position);
        myHolder.title.setText(data.getTitle());
        myHolder.desc.setText(data.getDesc());

        myHolder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(int pos) {

                Log.i("Button CLicked", "On item Click");

                    //Toast.makeText((Context) context,"dd",Toast.LENGTH_SHORT).show();
                 }
        });
    }

    @Override
    public int getItemCount() {
        return noteslist.size();
    }

    class  MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title,desc;
        ItemClickListener itemClickListener;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.title);
            desc=itemView.findViewById(R.id.desc);
            itemView.setOnClickListener(this);

        }

        public void setItemClickListener(ItemClickListener itemClickListener)
        {
            this.itemClickListener=itemClickListener;
        }
        @Override
        public void onClick(View v) {
            this.itemClickListener.onItemClick(this.getLayoutPosition());
        }
    }
}
