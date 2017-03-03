package com.dinesh.squery;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class App {
  
  public static void main(String[] args) throws Exception {
    
    TableBuilder tableBuilder = new TableBuilder();
    Table views1 = tableBuilder.buildTable("views_1.csv", "views_1.yml");
    
  }

}
