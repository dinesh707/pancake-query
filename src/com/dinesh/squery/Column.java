package com.dinesh.squery;

import java.util.ArrayList;
import java.util.List;

public class Column {
  
  private final String name;
  
  //TODO : may be an enum ??
  private final String dataType;
  
  private final List<?> data;

  public Column(String columnName, String columnType) {
    this.name = columnName;
    this.dataType = columnType;
    this.data = new ArrayList();
  }
  
}
