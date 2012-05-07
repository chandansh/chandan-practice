package org.usaopengov.validator;

import java.io.IOException;
import java.net.URL;

import org.usaopengov.data.bean.ValidationResultType;
import org.usaopengov.util.UrlUtil;

/**
 * @author <a href="http://www.benmccann.com/">Ben McCann</a>
 */
public class FpdsDunsValidator extends BaseValidator implements Validator {

  public FpdsDunsValidator() {
    super("http://www.usaspending.gov/fpds/fpds.php?datype=X&company_name=Boeing&fiscal_year=2009&detail=1");
  }

  @Override
  public String getImportance() {
    return "The DUNS number is the primary key for referring to US government contractors.";
  }

  @Override
  public String getIssue() {
    return "No DUNS number present";
  }
  
  @Override
  public void doValidation() throws IOException {
    String urlContents = UrlUtil.getUrlContents(new URL(url));
    if (urlContents.contains("<eeParentDuns ></eeParentDuns>")) {
      resultType = ValidationResultType.ERROR;
      validationMessage = "The element eeParentDuns was empty.";
    }
  }
  
  public static void main(String[] args) throws Exception {
    Validator v = new FpdsDunsValidator();
    ValidationResultType result = v.getResultType();
    System.out.println(result);
  }
    
}
