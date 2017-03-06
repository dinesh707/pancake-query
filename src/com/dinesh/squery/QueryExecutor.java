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
  
 
  //TODO : ALLOW : Sub queries 
  //TODO : ALLOW : Grouping 
  //TODO : ALLOW : Other types of joins
  /**
   * Processes the queries in format 
   * SELECT <subset> FROM <resource> WHERE <filter> LIMIT <trim>;
   * 
   * @param queryString
   * @return
   */
  public Results executeQuery(String queryString) {
        
    Query query = new Query(queryString);
    
    
    //throw new NotImplementedException();
    return null;
  }

}
