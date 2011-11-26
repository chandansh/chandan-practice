package org.usaopengov.action;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import org.usaopengov.data.bean.ValidationResult;
import org.usaopengov.data.bean.ValidationResultType;
import org.usaopengov.data.dao.PMF;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author <a href="http://www.benmccann.com/">Ben McCann</a>
 */
@SuppressWarnings("serial")
public class ViewDashboardAction extends ActionSupport {
  
  private final List<ValidationResult> errorResults = new ArrayList<ValidationResult>();
  private final List<ValidationResult> warningResults = new ArrayList<ValidationResult>();
  private final List<ValidationResult> okResults = new ArrayList<ValidationResult>();
  
  @Override
  public String execute() throws Exception {

    PersistenceManager pm = PMF.get().getPersistenceManager();

    Query query = pm.newQuery(ValidationResult.class, "this.timestamp >= dateParam");
    query.declareParameters("java.util.Date dateParam");
    Calendar c = new GregorianCalendar();
    c.add(Calendar.DAY_OF_MONTH, -1);
    Date yesterday = c.getTime();
    
    try {
      @SuppressWarnings("unchecked")
      List<ValidationResult> results = (List<ValidationResult>) query.execute(yesterday);
      for (ValidationResult vr : results) {
        if (vr.getResultType() == ValidationResultType.ERROR) {
          errorResults.add(vr);
        } else if (vr.getResultType() == ValidationResultType.WARNING) {
          warningResults.add(vr);
        } else if (vr.getResultType() == ValidationResultType.OK) {
          okResults.add(vr);
        }
      }
    } finally {
      query.closeAll();
    }

    return Action.SUCCESS;
  }

  public List<ValidationResult> getErrorResults() {
    return errorResults;
  }

  public List<ValidationResult> getWarningResults() {
    return warningResults;
  }

  public List<ValidationResult> getOkResults() {
    return okResults;
  }
  
}
