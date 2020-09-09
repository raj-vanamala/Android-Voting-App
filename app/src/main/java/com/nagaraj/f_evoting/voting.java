package com.nagaraj.f_evoting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View;

import com.google.firebase.FirebaseApp;

public class voting extends AppCompatActivity{

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Toast.makeText(getApplicationContext(), "WELCOME TO SMIT ELECTIONS", Toast.LENGTH_SHORT).show();
        setContentView(R.layout.intro);

    }
    public void intro_register_Click(View view){
        Intent su;
        su = new Intent(this,signUp.class);
        startActivity(su);
    }
    public void intro_signIn_Click(View view){
        Intent si;
        si = new Intent(this,signIn.class);
        startActivity(si);
    }

}
