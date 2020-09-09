package com.nagaraj.f_evoting;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Iterator;


public class block  extends AppCompatActivity{
    String registration_number;
    String candidate_id;
    String current_hash;
    String previous_hash;
    int index;
    public block(int i, int i1) {

    }

    public String getRegistration_number() {
        return registration_number;
    }

    public void setRegistration_number(String registration_number) {
        this.registration_number = registration_number;
    }

    public String getCandidate_id() {
        return candidate_id;
    }

    public void setCandidate_id(String candidate_id) {
        this.candidate_id = candidate_id;
    }

    public String getCurrent_hash() {
        return current_hash;
    }

    public void setCurrent_hash(String current_hash) {
        this.current_hash = current_hash;
    }

    public String getPrevious_hash() {
        return previous_hash;
    }

    public void setPrevious_hash(String previous_hash) {
        this.previous_hash = previous_hash;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

   public block() {
        Log.d("hsa","ENTERED DEFAULT CONSTRUCTOR-GENESIS");
            this.index=0;
            this.candidate_id=this.registration_number=this.previous_hash="0";
            this.current_hash = new hash().getTopHash();
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" + this.current_hash);
        }
    block(int index,String registration_number,String candidate_id,String current_hash,String previous_hash){
        Log.d("jsdh","ENTERED PARAMETER CONSTRUCTOR-DATA BLOCK");
        this.index=index;
        this.registration_number=registration_number;
        this.candidate_id = candidate_id;
        this.current_hash=current_hash;
        this.previous_hash=previous_hash;
    }
}
