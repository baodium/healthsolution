<%-- 
    Document   : error
    Created on : Jun 18, 2014, 11:58:50 AM
    Author     : Essiennta Emmanuel (colourfulemmanuel@gmail.com)
--%>

<%@page import="org.eminphis.Constants"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>
            Error occurred during startup;
            <br>Further database operations will yield errors;
            <br>Please shutdown the application and try restarting it.
        </h1>
        <h3>
            <%=request.getAttribute(Constants.EXCEPTION_MESSAGE)%>
        </h3>
    </body>
</html>
