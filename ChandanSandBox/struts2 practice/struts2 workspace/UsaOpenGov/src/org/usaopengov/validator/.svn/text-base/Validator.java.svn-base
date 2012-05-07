package org.usaopengov.validator;

import org.usaopengov.data.bean.ValidationResult;
import org.usaopengov.data.bean.ValidationResultType;

/**
 * @author <a href="http://www.benmccann.com/">Ben McCann</a>
 */
public interface Validator {

  void doValidation() throws Exception;
  
  ValidationResult validate();
  
  ValidationResultType getResultType();
  
  String getUrl();
  
  String getIssue();
  
  String getImportance();

  String getValidationMessage();
  
}
