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
    
    Results results = loadResource(query.getResource());
    applyFilter(results, query.getFilter());
    applyLimit(results, query.getLimit());
    applySubcols(results, query.getSubcols());
    
    //throw new NotImplementedException();
    return null;
  }

  private Results loadResource(String resource) {
    // TODO Auto-generated method stub
    return null;
  }

  private void applyFilter(Results results, String filter) {
    // TODO Auto-generated method stub    
  }

  private void applyLimit(Results results, String limit) {
    // TODO Auto-generated method stub
  }

  private void applySubcols(Results results, String subset) {
    // TODO Auto-generated method stub
  }

}
