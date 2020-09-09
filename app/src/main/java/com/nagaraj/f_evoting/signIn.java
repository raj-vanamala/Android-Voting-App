package com.nagaraj.f_evoting;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class signIn extends voting {

    EditText reg_no1;
    EditText password2;
    Button sign_in;
    private DatabaseReference ref ;
    String reg_no;
    static  ArrayList <String> r_no = new ArrayList();

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in1);

        reg_no1 = (EditText)findViewById(R.id.sign_in1_reg_no);
        System.out.println(reg_no1);
        password2 = (EditText)findViewById(R.id.sign_in1_password);
        sign_in = (Button)findViewById(R.id.sign_in1_sign_in);

        ref = FirebaseDatabase.getInstance().getReference().child("Registration");
    }

    public void sign_in1_sign_in_Click(View view) {
        reg_no = reg_no1.getText().toString();
        r_no.add(reg_no);
        final String password = password2.getText().toString();


        try {
            ref.child(reg_no).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    student1 student = dataSnapshot.getValue(student1.class);
                    if (password.equals(student.getPassword())) {

                        Toast.makeText(signIn.this, "Login Successfull", Toast.LENGTH_SHORT).show();
                        Intent category = new Intent(signIn.this, category.class);
                        startActivity(category);
                    } else {
                        Toast.makeText(signIn.this, "Entered Details Are Incorrect", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
        catch (Exception e)
        {
            Toast.makeText(signIn.this, "Student details does not exist.....!", Toast.LENGTH_SHORT).show();

        }
    }
    public String g_r_no(){
        return r_no.get(r_no.size()-1);
    }

}
