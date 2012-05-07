package org.usaopengov.validator;


/**
 * @author <a href="http://www.benmccann.com/">Ben McCann</a>
 */
public abstract class XmlValidator extends BaseValidator {

  public XmlValidator(String url) {
    super(url);
  }
  
  @Override
  public String getImportance() {
    return "XML should validate against a known XML schema in order to be easily readable by XML parsing libraries.";
  }

  @Override
  public String getIssue() {
    return "Invalid XML";
  }
    
}
