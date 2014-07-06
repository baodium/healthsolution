
<%@page import="org.eminphis.dto.tableview.Matches"%>
<%@page import="org.eminphis.dto.tableview.SearchPatientMatch"%>
<%@page import="org.eminphis.db.DBManager"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>

<%!
    private boolean isCompletelyNumeric(String query){
        for(int i=query.length()-1;i>=0;i--)
            if(query.charAt(i)<'0'||query.charAt(i)>'9')
                return false;
        return true;
    }
%>
<%!
    private boolean isCompletelyNonNumeric(String query){
        for(int i=query.length()-1;i>=0;i--)
            if(query.charAt(i)>='0'&&query.charAt(i)<='9')
                return false;
        return true;
    }
%>
<%!
    private Matches<SearchPatientMatch> findNumeric(long query) throws SQLException{
        return DBManager.retrieveSearchPatientMatchesByNumber(query);
    }
%>
<%!
    private Matches<SearchPatientMatch> findAlphabetic(String query) throws SQLException{
        return DBManager.retrieveSearchPatientMatchesByName(query);
    }
%>
<%!
    private Matches<SearchPatientMatch> findMatches(String query) throws SQLException{
        if(isCompletelyNumeric(query))
            return findNumeric(Long.parseLong(query));
        else if(isCompletelyNonNumeric(query))
            return findAlphabetic(query);
        else
            return null;
    }
%>
<%
    try{
        Matches<SearchPatientMatch> matches=findMatches((String)request.getParameter("q"));
        if(matches==null){
            out.println("mixed cased cannot be processed");
            return;
        }
        for(SearchPatientMatch match:matches)
            out.println(match.getRepresentation());
    } catch(java.sql.SQLException sqle){
        out.println("cannot display the records: "+sqle.getMessage());
    }
%>