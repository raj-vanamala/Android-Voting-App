package com.nagaraj.f_evoting;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class gs extends vp{

    static int index=0;
    String reg_no;
    static ArrayList<block> gs_b_chain = new ArrayList<>();
    static ArrayList<String> gs_c_id = new ArrayList();
    static ArrayList<String> gs_voters_reg_no = new ArrayList<>();
    static HashMap<String,Integer> pr = new HashMap<>();
    static HashMap<String,Integer> sh = new HashMap<>();
    static int count11=0,count22=0;
    private FirebaseDatabase database ;
    private DatabaseReference ref ;
    static {
        index++;
        Log.d("ENTERED GENESIS BLOCK","ENTERED GENESIS BLOCK");
        try {
            hash1 b1 = new hash1("GeneralSecretary");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        block b2 = new block();
        gs_b_chain.add(b2);
    }

    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gs_candidates);
    }
    public void gs1_Click(View view) throws NoSuchAlgorithmException {
        String id = "i123789";
        reg_no = g_r_no();
        String f = reg_no + id ;
        boolean check = check_voter(reg_no);
        //boolean check1 = validateChain();
        if(check==false){
            index++;
            hash1 b = new hash1();
            String previous_hash = b.getHash();
            String current_hash = b.calculateHash(f);
            block block1 = new block(index,reg_no, id, current_hash,previous_hash);
            gs_b_chain.add(block1);
            gs_voters_reg_no.add(reg_no);
            gs_c_id.add(id);
            count11=count11+1;
            pr.put("PRITHVI",count11);
            System.out.println(block1.index + "\t" + block1.registration_number + "\t" + block1.current_hash + "\t" + block1.previous_hash + "\t" + block1.candidate_id);
            database = FirebaseDatabase.getInstance();
            ref = database.getReference().child("GeneralSecretary");
            HashMap<String,block_string> voters = new HashMap<>();
            String index1 = Integer.toString(index);
            voters.put(reg_no, new block_string(index1,reg_no, id,  current_hash,previous_hash));
            ref.child(reg_no).setValue(voters).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {

                        Toast.makeText(getApplicationContext(),"Your Franchise Has Been Utilized",Toast.LENGTH_SHORT).show();
                        Intent category = new Intent(gs.this, results.class);
                        startActivity(category);
                    }
                    else {

                        Toast.makeText(getApplicationContext(),"Your Franchise Has Not Been Utilized",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
        else{
            Toast.makeText(getApplicationContext(),"Already Utilized Your Franchise",Toast.LENGTH_SHORT).show();
        }
    }
    public void gs2_Click(View view) throws NoSuchAlgorithmException {
        String id = "i789123";
        reg_no = g_r_no();
        String f = reg_no + id ;
        boolean check = check_voter(reg_no);
       // boolean check1 = validateChain();
        if(check==false ){
            index++;
            hash1 b = new hash1();
            String previous_hash = b.getHash();
            String current_hash = b.calculateHash(f);
            block block1 = new block(index,reg_no, id,  current_hash,previous_hash);
            gs_b_chain.add(block1);
            gs_voters_reg_no.add(reg_no);
            gs_c_id.add(id);
            count22=count22+1;
            sh.put("SHIVANSH",count22);
            System.out.println(block1.index + "\t" + block1.registration_number + "\t" + block1.current_hash + "\t" + block1.previous_hash + "\t" + block1.candidate_id);
            database = FirebaseDatabase.getInstance();
            ref = database.getReference().child("GeneralSecretary");
            HashMap<String,block_string> voters = new HashMap<>();
            String index1 = Integer.toString(index);
            voters.put(reg_no, new block_string(index1,reg_no, id, current_hash,previous_hash));
            ref.child(reg_no).setValue(voters).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {

                        Toast.makeText(getApplicationContext(),"Your Franchise Has Been Utilized",Toast.LENGTH_SHORT).show();
                        Intent category = new Intent(gs.this, results.class);
                        startActivity(category);
                    }
                    else {

                        Toast.makeText(getApplicationContext(),"Your Franchise Has Not Been Utilized",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
        else{
            Toast.makeText(getApplicationContext(),"Already Utilized Your Franchise",Toast.LENGTH_SHORT).show();
        }
    }
    private Boolean check_voter(String reg_no) {

        if(gs_voters_reg_no.contains(reg_no)){
            return true;
        }
        else {
            return false;
        }
    }
    public Boolean validateChain(){
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!ENTERDE VERFICATION!!!!!!!!!!!!!!!!!!!!!!!");
        Iterator itr = gs_b_chain.iterator();
        if(index==1)
            return true;
        else {
            for(int i=1;i<gs_b_chain.size();i++) {
                block b = (block) itr.next();
                String current_hash = b.current_hash;
                System.out.println(current_hash);
                b = (block) itr.next();
                String previous_hash = b.previous_hash;
                System.out.println(previous_hash);
                if (!current_hash.equals(previous_hash)) {
                    return false;
                }
            }
            return true;
        }
    }
}
