package com.dinesh.squery;

import java.util.List;


public class App {
  
  public static void main(String[] args) throws Exception {
    
    TableBuilder tableBuilder = new TableBuilder();
    
    //TODO, some day, system should auto discover all csvs and ymls
    Table views1 = tableBuilder.buildTable("views_1.csv", "views_1.yml");
    Table views2 = tableBuilder.buildTable("views_2.csv", "views_2.yml");
   
    QueryExecutor executor = new QueryExecutor();
    //TODO, some day, system should auto add them as they get discovered.
    executor.addTables(views1, views2);
    
    Results results = executor.executeQuery("SELECT * FROM views_1");
    
    
  }

}
