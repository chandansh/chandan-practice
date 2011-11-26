package org.usaopengov.validator;

import java.util.logging.Logger;

import org.usaopengov.data.bean.ValidationResult;
import org.usaopengov.data.bean.ValidationResultType;

/**
 * @author <a href="http://www.benmccann.com/">Ben McCann</a>
 */
public abstract class BaseValidator implements Validator {

  private final Logger logger = Logger.getLogger(this.getClass().getName());
  protected final String url;
  protected ValidationResultType resultType = ValidationResultType.OK;
  protected String validationMessage;
  
  public BaseValidator(String url) {
    this.url = url;
  }
  
  public String getUrl() {
    return url;
  }
  
  public ValidationResult validate() {
    try {
      doValidation();
    } catch (Exception e) {
      logger.severe("Error running validator. " + e.getMessage());
      resultType = ValidationResultType.WARNING;
      validationMessage = "There was an error running this validator.";
    }
    ValidationResult validation =  new ValidationResult();
    validation.setImportance(getImportance());
    validation.setIssue(getIssue());
    validation.setResultType(getResultType());
    validation.setUrl(url);
    validation.setValidationMessage(validationMessage);
    return validation;
  }
  
  public ValidationResultType getResultType() {
    return resultType;
  }
  
  public String getValidationMessage() {
    return validationMessage;
  }
  
}
