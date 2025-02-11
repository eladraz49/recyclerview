package com.example.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.editText_item.setText("");
        holder.button_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = holder.editText_item.getText().toString();
                Toast.makeText(view.getContext(), text, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataItems.Length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        Button button_submit;
        EditText editText_item;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            button_submit = itemView.findViewById(R.id.button_submit);
            editText_item = itemView.findViewById(R.id.editText_item);
        }
    }
    private DataItem[] dataItems;
    private Context context;

    public MyAdapter(DataItem[] dataItems, Context context) {
        this.dataItems = dataItems;
        this.context = context;
    }
}
