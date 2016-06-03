package com.yahoo.mobile;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by srikanthv on 6/3/16.
 */
public class Terminal {
    
    public static String runCommand(String command) throws Exception{
        Process process=Runtime.getRuntime().exec(command);
        BufferedReader br=new BufferedReader(new InputStreamReader(process.getInputStream()));
        //print
        String line=null;
        String output="";
        while((line=br.readLine())!=null){
            output=output+line+"\n";
        }
        return output;
    }

}
