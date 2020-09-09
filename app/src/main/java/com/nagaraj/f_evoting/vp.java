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

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class vp extends signIn{

    static int index=0;
    String reg_no;
    static ArrayList<block> b_chain = new ArrayList<>();
    static ArrayList<String> vp_c_id = new ArrayList();
    static ArrayList<String> voters_reg_no = new ArrayList();
    static HashMap<String,Integer> ri = new HashMap<>();
    static HashMap<String,Integer> ay = new HashMap<>();
    static int count1=0,count2=0;
    private FirebaseDatabase database ;
    private DatabaseReference ref ;

    static {
        index++;
        try {
            hash b1 = new hash("VicePresident");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        block b2 = new block();
        b_chain.add(b2);
    }

    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vp_candidates);
    }
    public void vp1_Click(View view) throws NoSuchAlgorithmException {
        String id = "i543987";
        reg_no = g_r_no();
        String f = reg_no + id ;
        boolean check = check_voter(reg_no);
        boolean check1 = validateChain();
        if(check==false && check1==true){
            index++;
            hash b = new hash();
            String previous_hash = b.getHash();
            String current_hash = b.calculateHash(f);
            block block1 = new block(index,reg_no, id, current_hash,previous_hash);
            b_chain.add(block1);
            voters_reg_no.add(reg_no);
            vp_c_id.add(id);
            count1=count1+1;
            ri.put("RISHAV",count1);
            database = FirebaseDatabase.getInstance();
            ref = database.getReference().child("VicePresident");
            HashMap<String,block_string> voters = new HashMap<>();
            String index1 = Integer.toString(index);
            voters.put(reg_no, new block_string(index1,reg_no, id, current_hash,previous_hash));
            ref.child(reg_no).setValue(voters).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                        Intent gs = new Intent(vp.this,gs.class);
                        startActivity(gs);
                        Toast.makeText(getApplicationContext(),"Your Franchise Has Been Utilized",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(getApplicationContext(),"Your Franchise Has Not Been Utilized",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
        else {
            Toast.makeText(getApplicationContext(),"Already Utilized Your Franchise",Toast.LENGTH_SHORT).show();
        }
    }

    public void vp2_Click(View view) throws NoSuchAlgorithmException {
        String id = "i987543";
        reg_no = g_r_no();
        String f = reg_no + id ;
        boolean check = check_voter(reg_no);
        boolean check1 = validateChain();
        if(check==false && check1==true){
            index++;
            hash b = new hash();
            String previous_hash = b.getHash();
            String current_hash = b.calculateHash(f);
            block block1 = new block(index,reg_no, id, current_hash,previous_hash);
            b_chain.add(block1);
            voters_reg_no.add(reg_no);
            vp_c_id.add(id);
            count2=count2+1;
            ay.put("AYUSH",count2);
            System.out.println(block1.index + "\t" + block1.registration_number + "\t" + block1.current_hash + "\t" + block1.previous_hash + "\t" + block1.candidate_id);
            database = FirebaseDatabase.getInstance();
            ref = database.getReference().child("VicePresident");
            HashMap<String,block_string> voters = new HashMap<>();
            String index1 = Integer.toString(index);
            voters.put(reg_no, new block_string(index1,reg_no, id, current_hash,previous_hash));
            ref.child(reg_no).setValue(voters).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                        Intent gs = new Intent(vp.this,gs.class);
                        startActivity(gs);
                        Toast.makeText(getApplicationContext(),"Your Franchise Has Been Utilized",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(getApplicationContext(),"Your Franchise Has Not Been Utilized",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
        else {
            Toast.makeText(getApplicationContext(),"Already Utilized Your Franchise",Toast.LENGTH_SHORT).show();
        }
    }

    private Boolean check_voter(String reg_no) {

        if(voters_reg_no.contains(reg_no)){
            return true;
        }
        else {
            return false;
        }
    }
    public Boolean validateChain(){
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!ENTERDE VERFICATION!!!!!!!!!!!!!!!!!!!!!!!");
        Iterator itr = b_chain.iterator();
        if(index==1)
            return true;
        else {
            if(b_chain.size()%2==0){
                for(int i=1;i<b_chain.size();i++) {
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
            else {
                String previous_hash=null;
                for(int i=1;i<b_chain.size();i++) {
                    if(i==(b_chain.size()-1))
                        return true;
                    block b = (block) itr.next();
                    String current_hash = b.current_hash;
                    System.out.println(current_hash);
                    b = (block) itr.next();
                    previous_hash = b.previous_hash;
                    System.out.println(previous_hash);
                    if (!current_hash.equals(previous_hash)) {
                        return false;
                    }
                }
                return true;
            }
        }
    }
}