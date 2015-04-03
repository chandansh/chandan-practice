package org.usaopengov.validator;

import java.io.IOException;
import java.net.URL;
import java.security.AccessControlException;
import java.util.HashSet;
import java.util.Set;

import org.usaopengov.data.bean.ValidationResultType;
import org.usaopengov.util.UrlUtil;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import com.sun.org.apache.xerces.internal.parsers.SAXParser;

/**
 * @author <a href="http://www.benmccann.com/">Ben McCann</a>
 */
public class XercesXmlValidator extends XmlValidator {

  public XercesXmlValidator(String url) {
    super(url);
  }

  public void doValidation() throws IOException, SAXException {
    // check for existence of schema
    String contents = UrlUtil.getUrlContents(new URL(url));
    if (!contents.contains("xsi:schemaLocation") && !contents.contains("xsi:noNamespaceSchemaLocation")) {
      resultType = ValidationResultType.WARNING;
      validationMessage = "No XML Schema is specified.  The attribute xsi:schemaLocation or xsi:noNamespaceSchemaLocation should be present.";
      return;
    }
    
    // check for other errors
    final Set<SAXParseException> errors = new HashSet<SAXParseException>();
    SAXParser parser = new SAXParser();
    parser.setFeature("http://xml.org/sax/features/validation", true);
    parser.setFeature("http://apache.org/xml/features/validation/schema", true);
    parser.setErrorHandler(new ErrorHandler() {

      @Override
      public void error(SAXParseException arg0) throws SAXException {
        errors.add(arg0);
      }

      @Override
      public void fatalError(SAXParseException arg0) throws SAXException {
        errors.add(arg0);
      }

      @Override
      public void warning(SAXParseException arg0) throws SAXException {
      }
      
    });
    
    InputSource inputSource = new InputSource(new URL(url).openStream());
    try {
      parser.parse(inputSource);
    } catch (AccessControlException e) {
      resultType = ValidationResultType.WARNING;
      validationMessage = "The document could not be parsed due to a relative schema location. Relative paths are deprecated in favor of full paths.  <a href=\"http://www.validome.org/xml/validate/?lang=en&url=" + UrlUtil.encodeUrl(url) + "\">Further errors may exist</a>.";      
    }
    
    if (errors.size() > 0) {
      resultType = ValidationResultType.ERROR;
      validationMessage = errors.iterator().next().getMessage() + "<br />The document should <a href=\"http://www.validome.org/xml/validate/?lang=en&url=" + UrlUtil.encodeUrl(url) + "\">pass validation</a>.";
    }
  }
  
  public static void main(String[] args) throws IOException, SAXException {
//    String url = "http://www.usaspending.gov/fpds/fpds.php?datype=X&company_name=Boeing&fiscal_year=2009&detail=1";
//    String url = "http://iaspub.epa.gov/webservices/StationService/index.html?invoke=getStationCharacteristicsForMap&MinimumLatitude=0&MaximumLatitude=90&MinimumLongitude=0&MaximumLongitude=90";
//    String url = "http://feeds.feedburner.com/sba/rAIO";
//    ValidationResult result = new XmlValidator(url).validate();
//    System.out.println(result.getValidationMessage());
  }
    
}
