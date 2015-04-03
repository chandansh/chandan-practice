<%

String orderByCol = request.getParameter("orderByCol");
String oldOrderByCol = request.getParameter("curSort");

String direction = "desc";

if (orderByCol != null && oldOrderByCol != null) {
    if (orderByCol.equals(oldOrderByCol)) {
        if (request.getParameter("curDirect").equals("desc")) {
            direction = "asc";
        }
    }
}

if (orderByCol == null) {
    if(oldOrderByCol == null) {
        //This is to be provided for the first column to sort.
        
        
   orderByCol = defaultColumn;
        		
        		
    } else {
        orderByCol = oldOrderByCol;
        direction = request.getParameter("curDirect");
    }
}
%>

