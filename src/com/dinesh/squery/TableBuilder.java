package com.dinesh.squery;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Map;

import com.esotericsoftware.yamlbeans.YamlException;
import com.esotericsoftware.yamlbeans.YamlReader;

public class TableBuilder {

  private int skipRowCount;
  private String separatedBy;
  private boolean dataQuoated;
  
  public Table buildTable(String csvFile, String schemaFile) throws IOException, ParseException {
    
    final YamlReader reader = new YamlReader(new FileReader(schemaFile));
    final Map config = (Map) reader.read();
    
    final Table table = new Table();
    
    loadMetaConfig(config);
    loadColumns(config, table);
    loadData(csvFile, table);
    
    return table;
  }
  
  private void loadMetaConfig(Map config) throws FileNotFoundException, YamlException {
    Map metaConfig = (Map) config.get("meta");
    
    skipRowCount = metaConfig.containsKey("skip_rows") ?
                          Integer.valueOf((String) metaConfig.get("skip_rows")) : 
                          0;
                          
    //TODO : may be a ENUM later
    //possible values : comma, tab
    separatedBy = metaConfig.containsKey("separated_by") ?
                          (String) metaConfig.get("separated_by") : 
                            "comma";                   
    
    dataQuoated = metaConfig.containsKey("quoated") ?
                          Boolean.valueOf((String) metaConfig.get("quoated")) : 
                          false;
  }
  
  private void loadColumns(final Map config, Table table) {

    ArrayList<Object> schemaConfig = (ArrayList) config.get("schema");
    
    int columnIndex = 0;
    for (Object columnObj : schemaConfig) {
      Map column = (Map) columnObj;
      String columnName = (String) column.get("name");
      String columnType = (String) column.get("type");
      Column tableColumn = new Column(columnName, columnType);
      table.addColumn(columnIndex, tableColumn);
      columnIndex++;
    }
  }

  private void loadData(String csvFile, Table table) throws IOException, ParseException {
    
    final FileInputStream fis = new FileInputStream(csvFile);
    final BufferedReader br = new BufferedReader(new InputStreamReader(fis));
  
    final String separator =  "comma".equals(separatedBy) ? "," : "\t";
    
    String rawRow = null;
    while ((rawRow = br.readLine()) != null) {
      String[] cells = rawRow.split(separator);
      int columnIndex = 0;
      for (String cell : cells) {
        String formattedCell = cell.trim();
        if (dataQuoated) {       
          formattedCell = removeQuoates(formattedCell);
        }
        table.addDataCell(columnIndex, formattedCell);
        columnIndex++;
      }
    }
 
    br.close();
  }

  private String removeQuoates(String formattedCell) {
    // if the trimmed cell is empty,then it should be a NULL
    // empty string should minimully contain "".
    if (formattedCell.length() >= 2) {
      // we identify its single or double quoate
      String quoateType = formattedCell.substring(0, 1);
      // this will cut off starting and ending quoates.
      formattedCell = formattedCell.substring(1, formattedCell.length()-1);
      formattedCell = formattedCell.replaceAll("\\\\" + quoateType, quoateType);
    }
    return formattedCell;
  }

}
