package com.nagaraj.f_evoting;

import java.util.HashMap;

public class verification {
    HashMap<String, Boolean> valid = new HashMap<>();
    int flag=0;

    verification() {
        valid.put("201500335",true);
        valid.put("201500261",true);
        valid.put("201500100",true);
        valid.put("201500101",true);
        valid.put("201500102",true);
        valid.put("201500103",true);
        valid.put("201500352",true);
        valid.put("201500739",true);
    }

    public boolean verify(String s) {

        for (int i = 0; i < valid.size(); i++) {

            if (valid.containsKey(s))
                flag = 1;

        }
        if (flag==1)
            return true;
        else
            return false;
    }
}