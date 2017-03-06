package com.dinesh.squery;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Query {

  // SELECT (subcols) FROM (resource) WHERE (filter) LIMIT (trim);
  private final Pattern subcolsPattern = Pattern.compile("select(.*?)from.*");
  private final Pattern resourcePattern = Pattern.compile(".*from(.*?)(where|limit|;).*");
  private final Pattern filterPattern = Pattern.compile(".*where(.*?)(limit|;).*");
  private final Pattern limitPattern = Pattern.compile(".*limit(.*?);");
  
  private String subcols;
  private String resource;
  private String filter;
  private String limit;
    
  public Query(String queryString) {
    tokanizeQuery(queryString);    
  }
  
  public String getSubcols() {
    return subcols;
  }
  
  public String getResource() {
    return resource;
  }
  
  public String getFilter() {
    return filter;
  }
  
  public String getLimit() {
    return limit;
  }

  private void tokanizeQuery(String queryString) {
    // removes all the newlines in query.
    queryString = queryString.replace("\n", "").replace("\r", "");
    queryString = queryString.toLowerCase();
       
    Matcher subcolsMatcher = subcolsPattern.matcher(queryString);
    Matcher resourceMatcher = resourcePattern.matcher(queryString);
    Matcher filterMatcher = filterPattern.matcher(queryString);
    Matcher limitMatcher = limitPattern.matcher(queryString);
    
    if (subcolsMatcher.matches()) {
      subcols = subcolsMatcher.group(1).trim();
    }
    if (resourceMatcher.matches()) {
      resource = resourceMatcher.group(1).trim();
    }
    if (filterMatcher.matches()) {
      filter = filterMatcher.group(1).trim();
    }
    if (limitMatcher.matches()) {
      limit = limitMatcher.group(1).trim();
    }
  }

}
