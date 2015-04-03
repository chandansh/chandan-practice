<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
  <head>
    <title>UsaOpenGov.org :: Improving Open Government</title>
    <style>
      body {
        font-size:2em;
        font-family:Optima,Arial,Helvetica,sans-serif;
      }
      table {
        border-collapse:collapse;
      }
      td, th {
        padding:10px;
      }
      td {
        font-size:.9em;
      }
      h4 {
        margin:2em 0 1em;
        font-size:.8em;
      }
      .table-header {
        background-color:#BBB;      
      }
      .odd {
        background-color:#DDD;
      }
      .about {
        margin-top:3em;
        font-size:.7em;
      }
    </style>
  </head>
  <body>
    <div style="width:950px; margin:30px auto; text-align:center">
      <h2>Help Fix Crippled Data and APIs</h2>
      <p>
        The availability of government data increases transparency when made available freely and correctly in machine-readable format.
        Bring attention to data issues by <a href="http://www.benmccann.com/contact/">reporting them here</a> and sending this page to <a href="http://www.data.gov/contact">the agencies responsible</a>.
      </p>

      <h4>Errors</h4>
      <table style="width:100%">
        <thead>
          <tr class="table-header">
            <th style="width:20%">Site</th>
            <th style="width:40%">Issue</th>
            <th style="width:40%">Importance</th>
          </tr>
        </thead>
        <tbody>
          <s:iterator value="errorResults" status="rowstatus">
            <tr <s:if test="#rowstatus.odd">class="odd"</s:if><s:else>class="even"</s:else>>
              <td><a href="<s:property value="url" />"><s:property value="site" /></a></td>
              <td><s:property value="validationMessage" escape="false" /></td>
              <td><s:property value="importance" /></td>
            </tr>
          </s:iterator>
          <s:if test="errorResults.size() == 0">
            <tr><td colspan="3" class="odd" style="text-align:center">None</td></tr>
          </s:if>
        </tbody>
      </table>

      <h4>Warnings</h4>
      <table style="width:100%">
        <thead>
          <tr class="table-header">
            <th style="width:20%">Site</th>
            <th style="width:40%">Issue</th>
            <th style="width:40%">Importance</th>
          </tr>
        </thead>
        <tbody>
          <s:iterator value="warningResults" status="rowstatus">
            <tr <s:if test="#rowstatus.odd">class="odd"</s:if><s:else>class="even"</s:else>>
              <td><a href="<s:property value="url" />"><s:property value="site" /></a></td>
              <td><s:property value="validationMessage" escape="false" /></td>
              <td><s:property value="importance" /></td>
            </tr>
          </s:iterator>
          <s:if test="warningResults.size() == 0">
            <tr><td colspan="3" class="odd" style="text-align:center">None</td></tr>
          </s:if>
        </tbody>
      </table>

      <h4>Fixed Issues</h4>
      <table style="width:100%">
        <thead>
          <tr class="table-header">
            <th style="width:20%">Site</th>
            <th style="width:40%">Issue</th>
            <th style="width:40%">Importance</th>
          </tr>
        </thead>
        <tbody>
          <s:iterator value="okResults" status="rowstatus">
            <tr <s:if test="#rowstatus.odd">class="odd"</s:if><s:else>class="even"</s:else>>
              <td><a href="<s:property value="url" />"><s:property value="site" /></a></td>
              <td><s:property value="issue" /></td>
              <td><s:property value="importance" /></td>
            </tr>
          </s:iterator>
          <s:if test="okResults.size() == 0">
            <tr><td colspan="3" class="odd" style="text-align:center">None</td></tr>
          </s:if>
        </tbody>
      </table>

      <p class="about">
        This site was created by <a href="http://www.benmccann.com/dev-blog/">Ben McCann</a> and <a href="http://sunlightlabs.com/contests/appsforamerica2/">inspired by SunlightLabs</a>.<br />
        Hosting provided by <a href="http://code.google.com/p/usaopengov/">Google Code</a> and <a href="http://code.google.com/appengine/">Google App Engine</a>.<br />
        Want to mandate data standards? <a href="http://www.visi.com/juan/congress/">Contact your Congresspeople</a>.
      </p>
    </div>
  </body>
</html>

