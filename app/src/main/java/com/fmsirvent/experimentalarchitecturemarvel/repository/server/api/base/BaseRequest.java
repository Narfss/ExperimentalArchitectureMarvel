package com.fmsirvent.experimentalarchitecturemarvel.repository.server.api.base;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class BaseRequest {
    private static final String APIKEY = "apikey";
    private static final String TS = "ts";
    private static final String HASH = "hash";
    private static final String apiKey = "6a7ed890b4b941a925202a5630d5b162";
    private static final String apiSecret = "0f1d0fdf46a0bf32f962b0b9997233c0395cdf8e";

    public static Map<String,String> getMap() {
        Map<String, String> map = new HashMap<>();
        map.put(APIKEY, apiKey);
        long timeStamp = System.currentTimeMillis();
        map.put(TS, String.valueOf(timeStamp));
        map.put(HASH, md5(timeStamp + apiSecret + apiKey));
        return map;
    }

    private static String md5(final String s) {
        final String MD5 = "MD5";
        String md5Result = "";
        try {
            MessageDigest digest = MessageDigest.getInstance(MD5);
            digest.update(s.getBytes());
            byte messageDigest[] = digest.digest();
            StringBuilder hexString = new StringBuilder();
            for (byte aMessageDigest : messageDigest) {
                String h = Integer.toHexString(0xFF & aMessageDigest);
                while (h.length() < 2) {
                    h = "0" + h;
                }
                hexString.append(h);
            }
            md5Result = hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return md5Result;
    }
}
