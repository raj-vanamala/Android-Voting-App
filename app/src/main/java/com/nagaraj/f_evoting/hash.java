package com.nagaraj.f_evoting;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;

public class hash {

    static  public ArrayList<String> hashValues = new ArrayList<>();
    String hash;
    static int count=0;

    public hash(String id) throws NoSuchAlgorithmException {

        String genesis_hash = calculateHash(id);
    }

    public hash() {

    }

    public String calculateHash(String f) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] encodedhash = digest.digest(f.getBytes(StandardCharsets.UTF_8));
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < encodedhash.length; i++) {
            String hex = Integer.toHexString(0xff & encodedhash[i]);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
            hash =hexString.toString();
            count+=1;
            //hashValues.add(hash);
        }
        hashValues.add(hash);
        return hash;

    }

    public String getHash() {

        return hashValues.get(hashValues.size()-1);
    }
    public String getTopHash() {

        return hashValues.get(0);
    }
}
