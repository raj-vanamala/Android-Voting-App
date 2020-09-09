package com.nagaraj.f_evoting;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class category extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category);
    }
    public void category_vp_Click(View view){
        Intent category = new Intent(category.this, vp.class);
        startActivity(category);
    }
    public void category_gs_Click(View view){
        Intent category = new Intent(category.this, gs.class);
        startActivity(category);
    }
}
