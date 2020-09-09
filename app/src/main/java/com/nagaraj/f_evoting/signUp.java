package com.nagaraj.f_evoting;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.security.NoSuchAlgorithmException;

public class signUp extends voting{

    EditText name,password,reg_no,password1;
    Button register;
    private student1 student;
    private FirebaseDatabase database;
    private DatabaseReference ref;

    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        name = (EditText)findViewById(R.id.register_name);
        reg_no = (EditText)findViewById(R.id.register_reg_no);
        password = (EditText)findViewById(R.id.register_password);

        register = (Button)findViewById(R.id.register_register);

        student = new student1();
        database = FirebaseDatabase.getInstance();
        ref = database.getReference().child("Registration");

    }
    public void register_register_Click(View view){
        /*String s = password.toString();
        password_hash p = new password_hash();
        try {
            password = p.calculateHash(s);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        */
        String s1 = reg_no.getText().toString();
        verification ob = new verification();
        boolean check = ob.verify(s1);

        if (check==true){
            student.setName(name.getText().toString());
            student.setRegistration_no(reg_no.getText().toString());
            student.setPassword(password.getText().toString());
            //student.setPassword(password);
            ref.child(student.getRegistration_no()).setValue(student).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(signUp.this, "Created Successfully.......!", Toast.LENGTH_SHORT).show();
                        Intent category = new Intent(signUp.this,signIn.class);
                        startActivity(category);
                    }
                    else {
                        Toast.makeText(signUp.this, "Registration Failed........!", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
        else
        {
            Toast.makeText(signUp.this, "YOU ARE NOT ALLOWED TO PARTICIPATE........!", Toast.LENGTH_SHORT).show();
        }

    }


}
