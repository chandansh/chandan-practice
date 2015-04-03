package org.usaopengov.validator;

import junit.framework.TestCase;

public class BaseValidatorTest extends TestCase {

  public void testGetSite() {
    BaseValidator v = new BaseValidator("http://www.usaspending.gov/fpds/fpds.php?datype=X&company_name=Boeing&fiscal_year=2009&detail=1") { };
    assertEquals("usaspending.gov", v.getSite());
  }
  
}
