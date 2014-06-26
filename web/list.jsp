
<%@page import="org.eminphis.Printer"%>
<%@page import="org.eminphis.dto.tableview.PersonalDetailsView"%>
<%@page import="org.eminphis.db.DBManager"%>
<%@page import="org.eminphis.ui.registrar.SearchHandler"%>
<%@page import="org.eminphis.Constants"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>


<%
    Printer.println("entered list.jsp");
    String query=(String)request.getParameter("q");
    PersonalDetailsView personalDetailsView;
    try{
        personalDetailsView=DBManager.retrievePersonalDetailsView(query);
        Printer.println("query was "+query);
        Printer.println("PersonalDetailsView retrieved.");
        for(PersonalDetailsView.Match match:personalDetailsView)
            out.println(match);
        Printer.println("done");
    }catch(java.sql.SQLException ex){
        out.println("Error occured");
    }
%>
