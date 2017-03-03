package com.dinesh.squery;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Table {
  
  private final Map<String, Column> columns = new HashMap<String, Column>();
  private final Map<Integer, String> index = new HashMap<Integer, String>();
  

  public void addColumn(int columnIndex, Column column) {
    if (columns.containsKey(column.getName())) {
      throw new RuntimeException("Column already available with given name");
    }
    if (index.containsKey(columnIndex)) {
      throw new RuntimeException("Column already available at given index");   
    }
    
    columns.put(column.getName(), column);
    index.put(columnIndex, column.getName());
  }


  public void addDataCell(int columnIndex, String data) throws ParseException {
    String columnName = index.get(columnIndex);
    Column column = columns.get(columnName);
    
    Object typedData = parseToType(column, data);
    column.addDataCell(typedData);
  }


  private Object parseToType(Column column, String data) throws ParseException {
    final String dataType = column.getDataType();
    if ("integer".equals(dataType)) {
      if (data.length() == 0) {
        return null;
      }
      return Integer.parseInt(data);      
    } 
    if ("string".equals(dataType)) {
      return data;
    }
    if (dataType.contains("date")) {
      if (data.length() == 0) {
        return null;
      }
      return column.formatDate(data);
    } 
    throw new NotImplementedException("Not known type " + dataType);
  }

}
