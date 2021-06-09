package com.example.bookit;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;


public class MyAdapter  extends FirebaseRecyclerAdapter<FormData, MyAdapter.personsViewholder> {

    public MyAdapter (FirebaseRecyclerOptions<FormData> options)
    {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull MyAdapter.personsViewholder holder, int position, @NonNull FormData model) {
        holder.Name.setText(model.getName());
        holder.Admin_Number.setText(model.getAdmin_Number());
        holder.Phone_Number.setText(model.getPhone_Number());
        holder.Guardian_Name.setText(model.getGuardian_Name());
        holder.Guardian_Number.setText(model.getGuardian_Number());
        holder.Data.setText(model.getData());
    }


    @NonNull
    @Override
    public personsViewholder
    onCreateViewHolder(@NonNull ViewGroup parent,
                       int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pattern, parent, false);
        return new MyAdapter.personsViewholder(view);
    }

    // Sub Class to create references of the views in Crad
    // view (here "person.xml")
    class personsViewholder
            extends RecyclerView.ViewHolder {
        TextView Name,Admin_Number,Phone_Number, Guardian_Name,Guardian_Number,Data;
        public personsViewholder(@NonNull View itemView)
        {
            super(itemView);
            Name = itemView.findViewById(R.id.username);
            Admin_Number = itemView.findViewById(R.id.admin_number);
            Phone_Number= itemView.findViewById(R.id.userphone);
            Guardian_Name = itemView.findViewById(R.id.guardianname);
            Guardian_Number= itemView.findViewById(R.id.guardianphone);
            Data = itemView.findViewById(R.id.reason);


            itemView.findViewById(R.id.accept).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TextView tv = v.findViewById(R.id.status);
                    tv.setText("Accepted");
                    ImageView imageView = v.findViewById(R.id.avatar);
                    imageView.setImageResource(R.drawable.acepted);
                }
            });
            itemView.findViewById(R.id.decline).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TextView tv = v.findViewById(R.id.status);
                    tv.setText("Declined");
                    ImageView imageView = v.findViewById(R.id.avatar);
                    imageView.setImageResource(R.drawable.declined);
                }
            });

        }
    }
}