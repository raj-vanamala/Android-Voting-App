package com.nagaraj.f_evoting;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class hash1 {

    static  public ArrayList<String> gs_hashValues = new ArrayList<>();
    String hash;
    static int count=0;
    public hash1(String id) throws NoSuchAlgorithmException {

        String genesis_hash = calculateHash(id);
    }

    public hash1() {

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
        }
        gs_hashValues.add(hash);
        return hash;
    }

    public String getHash() {

        return gs_hashValues.get(gs_hashValues.size()-1);
    }
    public String getTopHash() {

        return gs_hashValues.get(0);
    }

}
