package com.u063.agslcalcs;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class AGSLReader {
    String readFrom(int id, Context c){
        InputStream is = c.getResources().openRawResource(id);
        BufferedReader bf = new BufferedReader(new InputStreamReader(is));
        String s="";
        String lines = "";
        try {
            while (((s = bf.readLine()) != null)) {
                lines += s;
                lines += "\n";
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return lines;
    }
}
