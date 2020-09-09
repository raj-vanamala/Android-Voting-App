package com.nagaraj.f_evoting;

import android.util.Log;

public class block_string {

    String registration_number;
    String candidate_id;
    String current_hash;
    String previous_hash;
    String index;
    block_string(String index,String registration_number,String candidate_id,String current_hash,String previous_hash){
        this.index=index;
        this.registration_number=registration_number;
        this.candidate_id = candidate_id;
        this.current_hash=current_hash;
        this.previous_hash=previous_hash;
    }
}
