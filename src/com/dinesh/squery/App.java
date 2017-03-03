package com.dinesh.squery;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class App {
  
  public static void main(String[] args) throws Exception {
    
    TableBuilder tableBuilder = new TableBuilder();
    
    //TODO, some day, system should auto discover all csvs and ymls
    Table views1 = tableBuilder.buildTable("views_1.csv", "views_1.yml");
    Table views2 = tableBuilder.buildTable("views_2.csv", "views_2.yml");
    
  }

}
