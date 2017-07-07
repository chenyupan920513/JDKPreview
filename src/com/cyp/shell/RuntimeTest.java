package com.cyp.shell;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RuntimeTest {

    /**
     * Run a command in the command line just like the console.
     */
    public static void main(String[] args) throws IOException {

        Process process = null;
        Runtime rt = Runtime.getRuntime();
        try {
            process = rt.exec("ipconfig");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            process.waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        InputStream is = process.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is,"gbk"));
        String b;
        while((b=br.readLine())!=null){
            System.out.println(b);
            System.out.println(br.readLine());
        }
    }

}
