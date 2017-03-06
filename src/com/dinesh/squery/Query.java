package com.dinesh.squery;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Query {

  // SELECT (subset) FROM (resource) WHERE (filter) LIMIT (trim);
  private final Pattern subsetPattern = Pattern.compile("select(.*?)from.*");
  private final Pattern resourcePattern = Pattern.compile(".*from(.*?)(where|limit|;).*");
  private final Pattern filterPattern = Pattern.compile(".*where(.*?)(limit|;).*");
  private final Pattern limitPattern = Pattern.compile(".*limit(.*?);");
  
  private String subset;
  private String resource;
  private String filter;
  private String limit;
    
  public Query(String queryString) {
    tokanizeQuery(queryString);    
  }

  private void tokanizeQuery(String queryString) {
    // removes all the newlines in query.
    queryString = queryString.replace("\n", "").replace("\r", "");
    queryString = queryString.toLowerCase();
       
    Matcher subsetMatcher = subsetPattern.matcher(queryString);
    Matcher resourceMatcher = resourcePattern.matcher(queryString);
    Matcher filterMatcher = filterPattern.matcher(queryString);
    Matcher limitMatcher = limitPattern.matcher(queryString);
    
    if (subsetMatcher.matches()) {
      subset = subsetMatcher.group(1).trim();
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
