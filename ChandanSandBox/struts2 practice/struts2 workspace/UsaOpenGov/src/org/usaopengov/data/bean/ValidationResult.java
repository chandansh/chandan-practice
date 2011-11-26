package org.usaopengov.data.bean;

import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;


/**
 * @author <a href="http://www.benmccann.com/">Ben McCann</a>
 */
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class ValidationResult {

  @PrimaryKey
  @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
  private Long id;
  
  @Persistent
  private ValidationResultType resultType;

  @Persistent
  private String url;
  
  @Persistent
  private String issue;
  
  @Persistent
  private String importance;
  
  @Persistent
  private String validationMessage;
  
  @Persistent
  private Date timestamp;
  
  public ValidationResult() {
    timestamp = new Date();
  }
  
  public ValidationResultType getResultType() {
    return resultType;
  }
  
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setResultType(ValidationResultType result) {
    this.resultType = result;
  }
  
  public String getUrl() {
    return url;
  }
  
  public void setUrl(String url) {
    this.url = url;
  }
  
  public String getIssue() {
    return issue;
  }
  
  public void setIssue(String issue) {
    this.issue = issue;
  }
  
  public String getImportance() {
    return importance;
  }
  
  public void setImportance(String importance) {
    this.importance = importance;
  }
  
  public String getValidationMessage() {
    return validationMessage;
  }

  public void setValidationMessage(String validationMessage) {
    this.validationMessage = validationMessage;
  }
  
  public Date getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Date timestamp) {
    this.timestamp = timestamp;
  }

  public String getSite() {
    if (url == null) {
      return null;
    }
    String noProtocol = url.substring(url.indexOf("//") + "//".length());
    String noPath = noProtocol.substring(0, noProtocol.indexOf('/'));
    return noPath.contains("www.") ? noPath.substring("www.".length()) : noPath;
  }
  
}
