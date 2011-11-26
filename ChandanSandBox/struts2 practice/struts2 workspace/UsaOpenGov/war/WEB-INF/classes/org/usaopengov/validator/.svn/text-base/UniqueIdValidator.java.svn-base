package org.usaopengov.validator;

import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.usaopengov.data.bean.ValidationResultType;
import org.usaopengov.util.UrlUtil;

/**
 * @author <a href="http://www.benmccann.com/">Ben McCann</a>
 */
public class UniqueIdValidator extends BaseValidator implements Validator {

  public UniqueIdValidator(String url) {
    super(url);
  }

  @Override
  public String getImportance() {
    return "HTML ids allow for easier import of data through sources such as Google Spreadsheets' ImportXml function.";
  }

  @Override
  public String getIssue() {
    return "Duplicate HTML ids";
  }
  
  @Override
  public void doValidation() throws IOException {
    String urlContents = UrlUtil.getUrlContents(new URL(url));
    Pattern pattern = Pattern.compile("id=\"?(\\w*)\"?");
    Matcher matcher = pattern.matcher(urlContents);
    Set<String> ids = new HashSet<String>(); 
    while (matcher.find()) {
      String id = matcher.group(1);
      if (ids.contains(id)) {
        resultType = ValidationResultType.ERROR;
        validationMessage = "Multiple HTML DOM elements were found with the ID \"" + id + "\"";
        return;
      }
      ids.add(id);
    }
  }
  
  public static void main(String[] args) throws Exception {
    Validator v = new UniqueIdValidator("http://www.usaspending.gov/fpds/fpds.php?company_name=Boeing&fiscal_year=2009&detail=1");
    ValidationResultType result = v.getResultType();
    System.out.println(result);
  }
    
}
