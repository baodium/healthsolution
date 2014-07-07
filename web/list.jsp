<%--
    Document   : list
    Created on : Jul 6, 2014, 10:45:58 PM
    Author     : Essiennta Emmanuel (colourfulemmanuel@gmail.com)
--%>

<%@page import="org.eminphis.Printer"%>
<%@page import="org.eminphis.dto.tableview.ScheduleAppointmentMatch"%>
<%@page import="org.eminphis.dto.tableview.Match"%>
<%@page import="org.eminphis.dto.tableview.Matches"%>
<%@page import="org.eminphis.dto.tableview.SearchPatientMatch"%>
<%@page import="org.eminphis.db.DBManager"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>

<%!
    private static abstract class Matcher<M extends Match>{

        abstract Matches<M> findNumeric(long query) throws SQLException;

        abstract Matches<M> findAlphabetic(String query) throws SQLException;

        private static boolean isCompletelyNumeric(String query){
            for(int i=query.length()-1;i>=0;i--)
                if(query.charAt(i)<'0'||query.charAt(i)>'9')
                    return false;
            return true;
        }

        private static boolean isCompletelyNonNumeric(String query){
            for(int i=query.length()-1;i>=0;i--)
                if(query.charAt(i)>='0'&&query.charAt(i)<='9')
                    return false;
            return true;
        }

        final Matches<M> findMatches(String query) throws SQLException{
            if(isCompletelyNumeric(query))
                return findNumeric(Long.parseLong(query));
            else if(isCompletelyNonNumeric(query))
                return findAlphabetic(query);
            else
                return null;
        }
    }
%>
<%!
    private class SearchPatientMatcher extends Matcher<SearchPatientMatch>{

        Matches<SearchPatientMatch> findNumeric(long query) throws SQLException{
            return DBManager.retrieveSearchPatientMatchesByNumber(query);
        }

        Matches<SearchPatientMatch> findAlphabetic(String query) throws SQLException{
            return DBManager.retrieveSearchPatientMatchesByName(query);
        }
    }
%>
<%!
    private class ScheduleAppointmentMatcher extends Matcher<ScheduleAppointmentMatch>{

        Matches<ScheduleAppointmentMatch> findNumeric(long query) throws SQLException{
            return DBManager.retrieveScheduleAppointmentMatchesByNumber(query);
        }

        Matches<ScheduleAppointmentMatch> findAlphabetic(String query) throws SQLException{
            return DBManager.retrieveScheduleAppointmentMatchesByName(query);
        }
    }
%>


<%
    Matcher matcher;
    Printer.println("Session attribute: "+session.getAttribute("AUTO_COMPLETE_MODE"));
    if(session.getAttribute("AUTO_COMPLETE_MODE")==":APPOINTMENT")
        matcher=new ScheduleAppointmentMatcher();
    else
        matcher=new SearchPatientMatcher();

    try{
        Matches matches=matcher.findMatches((String)request.getParameter("q"));
        if(matches==null){
            out.println("mixed cased cannot be processed");
            return;
        }
        for(Object match:matches)
            out.println(((Match)match).getRepresentation());
    } catch(java.sql.SQLException sqle){
        out.println("cannot display the records: "+sqle.getMessage());
    }
%>