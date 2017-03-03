package com.dinesh.squery;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QueryExecutor {

  Map<String, Table> tables = new HashMap<String, Table>();
  
  public void addTables(Table... tables) {
    for (Table table : tables) {
      this.tables.put(table.getName(), table);
    }
  }

  //TODO !! // TODO..may be this should be a taxanomy tree.. like lexical parsing !!
  public Results executeQuery(String queryString) {
    
    // SELECT * FROM table;
    String[] queryParts = queryString.split(" ");
    
    throw new NotImplementedException();
    
  }

}
