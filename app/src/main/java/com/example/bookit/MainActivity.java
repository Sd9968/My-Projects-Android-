package com.example.bookit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    EditText Name,Admin_Number,Phone_Number, Guardian_Name,Guardian_Number,Data;
    Button submit;
    FirebaseDatabase parent=FirebaseDatabase.getInstance();
    DatabaseReference children;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Name = findViewById(R.id.one);
        Admin_Number = findViewById(R.id.two);
        Phone_Number= findViewById(R.id.three);
        Guardian_Name = findViewById(R.id.four);
        Guardian_Number= findViewById(R.id.five);
        Data = findViewById(R.id.six);
        submit = findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String name = Name.getText().toString();
                String admin = Admin_Number.getText().toString();
                String user_number = Phone_Number.getText().toString();
                String guardian = Guardian_Name.getText().toString();
                String guardian_number= Guardian_Number.getText().toString();
                String data = Data.getText().toString();
                FormData formData= new FormData(name,admin,user_number,guardian,guardian_number,data);
                children=parent.getReference("Submitted List");
                children.setValue(formData);
                startActivity(new Intent(MainActivity.this, StatusForUser.class));
            }
        });
        
    }


}