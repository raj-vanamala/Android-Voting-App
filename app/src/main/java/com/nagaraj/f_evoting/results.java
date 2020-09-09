package com.nagaraj.f_evoting;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class results extends gs{

    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.results);
    }
    public void logout_Click(View view){

        Intent gs = new Intent(results.this,voting.class);
        startActivity(gs);
    }
    public void click_Click(View view){

        TextView textView1 = (TextView)findViewById(R.id.r_reg_no);
        TextView textView2 = (TextView)findViewById(R.id.r_vp_id);
        TextView textView3 = (TextView)findViewById(R.id.r_gs_id);


        TextView textView4 = (TextView)findViewById(R.id.ri);
        TextView textView5 = (TextView)findViewById(R.id.ay);
        TextView textView6 = (TextView)findViewById(R.id.pr);
        TextView textView7 = (TextView)findViewById(R.id.sh);


        String s1 = gs_voters_reg_no.get(gs_voters_reg_no.size()-1);
        textView1.setText(s1);
        String s2 = vp_c_id.get(vp_c_id.size()-1);
        if(s2.equals("i543987"))
            textView2.setText("VP_VOTE -> RISHAV");
        else
            textView2.setText("VP_VOTE -> AYUSH");

        String s3 = gs_c_id.get(gs_c_id.size()-1);
        if(s3.equals("i123789"))
            textView3.setText("GS_VOTE -> PRITHVI");
        else
            textView3.setText("GS_VOTE -> SHIVANSH");

        textView4.setText("RISHAV" + "->" + count1);
        textView5.setText("AYUSH" + "->" + count2);
        textView6.setText("PRITHVI" + "->" + count11);
        textView7.setText("SHIVANSH" + "->" + count22);
    }
}
