package com.dinesh.squery;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Column {
  
  private final String name;
  
  //TODO : may be an enum ??
  private final String dataType;
  
  private final SimpleDateFormat dateFormatter;
  
  private final List<Object> data;

  public Column(String columnName, String columnType) {
    this.name = columnName;
    this.dataType = columnType;
    this.data = new ArrayList();
    
    if (dataType.contains("date")) {
      // date is denoted with the date pattern eg : 'date(yyyy-mm-dd)'.
      String format = dataType.split("\\(")[1].split("\\)")[0];
      dateFormatter = new SimpleDateFormat(format);
    } else {
      dateFormatter = null;
    }
  }

  public String getName() {
    return name;
  }

  public String getDataType() {
    return dataType;
  }

  public List<?> getData() {
    return data;
  }

  public synchronized Date formatDate(String data) throws ParseException {
    return dateFormatter.parse(data);
  }

  /**
   * Adds the new element to the tail of the data column
   * @param dataElement
   */
  public void addDataCell(Object dataElement) {
    data.add(dataElement);
  }
  
}
