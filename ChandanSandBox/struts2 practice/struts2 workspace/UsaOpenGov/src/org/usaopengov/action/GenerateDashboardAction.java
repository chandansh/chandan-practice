package org.usaopengov.action;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import org.usaopengov.data.bean.ValidationResult;
import org.usaopengov.data.dao.PMF;
import org.usaopengov.validator.FpdsDunsValidator;
import org.usaopengov.validator.UniqueIdValidator;
import org.usaopengov.validator.Validator;
import org.usaopengov.validator.XercesXmlValidator;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author <a href="http://www.benmccann.com/">Ben McCann</a>
 */
@SuppressWarnings("serial")
public class GenerateDashboardAction extends ActionSupport {

  private final PersistenceManager pm = PMF.get().getPersistenceManager();
  private final List<Validator> validators = new ArrayList<Validator>();

  public GenerateDashboardAction() {
    validators.add(new FpdsDunsValidator());
    validators.add(new UniqueIdValidator("http://www.usaspending.gov/fpds/fpds.php?company_name=Boeing&fiscal_year=2009&detail=1"));
    validators.add(new XercesXmlValidator("http://earthquake.usgs.gov/eqcenter/catalogs/7day-M2.5.xml"));
    validators.add(new XercesXmlValidator("http://feeds.feedburner.com/sba/rAIO"));
    validators.add(new XercesXmlValidator("http://iaspub.epa.gov/webservices/StationService/index.html?invoke=getStationCharacteristicsForMap&MinimumLatitude=0&MaximumLatitude=90&MinimumLongitude=0&MaximumLongitude=90"));
    validators.add(new XercesXmlValidator("http://www.sba.gov/advo/whatsnew.xml"));
    validators.add(new XercesXmlValidator("http://www.treasury.gov/offices/domestic-finance/debt-management/interest-rate/yield.xml"));
    validators.add(new XercesXmlValidator("http://www.usaspending.gov/fpds/fpds.php?datype=X&company_name=Boeing&fiscal_year=2009&detail=1"));
  }

  
  @Override
  public String execute() throws Exception {
    
    deleteRecentResults();
    
    List<ValidationResult> results = new ArrayList<ValidationResult>(); 
    for (Validator validator : validators) {
      results.add(validator.validate());
    }
    try {
      pm.makePersistentAll(results);
    } finally {
      pm.close();
    }

    return Action.SUCCESS;
  }
  
  private void deleteRecentResults() {
    Query query = pm.newQuery(ValidationResult.class, "this.timestamp >= dateParam");
    query.declareParameters("java.util.Date dateParam");
    Calendar c = new GregorianCalendar();
    c.add(Calendar.HOUR, -24);
    Date last12hours = c.getTime();
    
    try {
      @SuppressWarnings("unchecked")
      List<ValidationResult> recent = (List<ValidationResult>) query.execute(last12hours);
      pm.deletePersistentAll(recent);
    } finally {
      query.closeAll();
    }
  }
  
}
