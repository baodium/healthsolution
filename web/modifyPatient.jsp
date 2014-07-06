<%-- 
    Document   : modifyPatient
    Created on : 28-Jun-2014, 11:51:28
    Author     : olajuwon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
    <head>
        <title>eMinphis</title>
        <link href="css/style.css" rel="stylesheet" type="text/css"  media="all" />
        <!--<link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>-->
        <link href='css/font-face.css' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" type="text/css" href="css/autocomplete.css" />
        <script src="js/jquery-1.8.0.min.js"></script>
        <script src="js/autocomplete.js"></script> 
        
    </head>
    <body>
        <!---start-wrap----> 

        <!---start-header---->
        <div class="header">
            <div class="top-header">
                <div class="wrap">
                    <div class="top-header-left"> 
                        <!--<p>+800-020-12345</p>--> 
                    </div>
                    <div class="right-left">
                        <ul>
                            <li class="login"><a href="#">Login</a></li>
                            <li class="sign"><a href="#">Sign up</a></li>
                        </ul>
                    </div>
                    <div class="clear"> </div>
                </div>
            </div>
            <div class="main-header">
                <div class="wrap">
                    <div class="logo"> <a href="index.jsp"><img src="images/minLogo.png" title="logo" /></a> </div>
                    <div class="social-links">
                        <ul>
                            <li><a href="#"><img src="images/facebook.png" title="facebook" /></a></li>
                            <li><a href="#"><img src="images/twitter.png" title="twitter" /></a></li>
                            <li><a href="#"><img src="images/feed.png" title="Rss" /></a></li>
                            <div class="clear"> </div>
                        </ul>
                    </div>
                    <div class="clear"> </div>
                </div>
            </div>
            <div class="clear"> </div>
            <div class="top-nav">
                <div class="wrap">
                    <ul>
                        <li><a href="index.jsp">Home</a></li>
                        <li><a href="#">Module #</a></li>
                        <li><a href="#">Module #</a></li>
                        <li><a href="#">Module #</a></li>
                        <li class="active"><a href="register.jsp">Registration Module</a></li>
                        <li ><a href="#">Module #</a></li>
                        <div class="clear"> </div>
                    </ul>
                </div>
            </div>

            <!-- sub menu -->
            <div class="sub-nav">
                <div class="wrap">
                    <ul>
                        <li ><a href="register.jsp">Add Patient</a></li>
                        <li ><a href="searchPatient.jsp">Search patient</a></li>
                        <li class="activeSub"><a href="modifyPatient.jsp">Modify Patient</a></li>
                        <li><a href="appointment.jsp">Appointments</a></li>
                        <div class="clear"> </div>
                    </ul>
                </div>
            </div>
        </div>
        <!---End-header----> 
        <!----start-content----->
        <div class="content">
            <div class="wrap"> 
                <!---start-contact---->
                <div class="contact">
                    <div class="section group">
                        <div class="col span_2_of_3">
                            <div class="contact-form">
                                <form action="modifyPatient.jsp" method="post">
                                    <div class="searchPanel">


                                        <input type="text" class="searchPatient"  id="search" name="search_patient_by_name" required placeholder="Enter query" >
                                        <input type="submit" value="search">
                                        </form>
                                         
                                    </div>

                                    <!-- display of the patient detail searched for -->
                                    <div>
                                        <h3>PATIENT DETAIL</h3>
                                        <form action="#">
                                            <table>

                                                <tr>
                                                <p><td>Patient name :&nbsp;&nbsp;</td><td>XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX</td></p>
                                                </tr>
                                                <tr>
                                                <p><td>Patient ID: &nbsp;&nbsp;</td><td> <input name="p_r2" type="text" value="XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX"/></td></p>
                                                </tr>
                                                <tr>
                                                <p><td>Patient Record: &nbsp;&nbsp;</td><td><input name="p_r3" type="text" value="XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX"/></td></p>
                                                </tr>
                                                <tr>
                                                <p><td>Patient Record: &nbsp;&nbsp;</td><td><input name="p_r4" type="text" value="XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX"/></td></p>
                                                </tr>
                                                <tr>
                                                <p><td>Patient Record: &nbsp;&nbsp;</td><td><input name="p_r5" type="text" value="XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX"/></td></p>
                                                </tr>
                                                <tr>
                                                <p><td>Patient Record: &nbsp;&nbsp;</td><td><input name="p_r6" type="text" value="XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX"/></td></p>
                                                </tr>

                                            </table>
                                            <input type="submit" value="modify"/>
                                        </form>
                                    </div>
                            </div>
                        </div>
                    </div>
                    <!---End-contact---->
                    <div class="clear"> </div>
                </div>
                <!----End-content-----> 
            </div>
            <!---End-wrap----> 
            <!---start-footer---->
            <div class="footer">
                <div class="wrap">
                    <div class="clear"> </div>
                    <!---start-copy-right----->
                    <div class="copy-tight">
                        <p> &copy; 2014 Memphis</p>
                    </div>
                    <!---End-copy-right-----> 
                </div>
            </div>
            <!---End-footer---->
    </body>
</html>
