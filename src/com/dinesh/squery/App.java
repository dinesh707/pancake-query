package com.dinesh.squery;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class App {
  
  public static void main(String[] args) throws Exception {
    
    FileInputStream fis = new FileInputStream("input_views_2.csv");
    
    //Construct BufferedReader from InputStreamReader
    BufferedReader br = new BufferedReader(new InputStreamReader(fis));
 
    String line = null;
    while ((line = br.readLine()) != null) {
        System.out.println(line);
    }
 
    br.close();
  }

}
