package com.example.bookit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    private EditText user_input_email,user_input_password;
    Button register_button;
    FirebaseAuth firebaseAuth;
    Button login_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        user_input_email=findViewById(R.id.LoginEmail);
        user_input_password=findViewById(R.id.LoginPassword);
        register_button= findViewById(R.id.signupedit);
        login_button=findViewById(R.id.button);
        firebaseAuth =FirebaseAuth.getInstance();
        register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this,sign_up.class));
            }
        });
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email= user_input_email.getText().toString().trim();
                String pass= user_input_password.getText().toString().trim();
                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(pass)) {
                    Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }
                firebaseAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(!task.isSuccessful()){
                            Toast.makeText(Login.this, "Error", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            String enter = "warden1@gmail.com";
                            String security = "security1@gmail.com";
                            String email= user_input_email.getText().toString().trim();
                            Intent intent;
                            if(email.equals(enter)){
                                intent = new Intent(Login.this,Warden.class);
                                startActivity(intent);
                                finish();
                            }
                            else if(email.equals(security))
                            {
                                intent = new Intent(Login.this,Security.class);
                                startActivity(intent);
                                finish();
                            }
                            else {
                                intent = new Intent(Login.this, MainActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        }
                    }
                });
            }
        });


    }
}