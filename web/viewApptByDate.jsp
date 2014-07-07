<%--
    Document   : appointment
    Created on : 28-Jun-2014, 11:54:14
    Author     : olajuwon
--%>

<%@page import="org.eminphis.dto.Appointment"%>
<%@page import="org.eminphis.dto.Group"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
    <head>
        <title>eMinphis</title>
        <link href="css/style.css" rel="stylesheet" type="text/css"  media="all" />
        <!--	<link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>-->
        <link href='css/font-face.css' rel='stylesheet' type='text/css'>
        <link rel="stylesheet"  type="text/css" href="css/datePicker.css">
        <script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
        <script type="text/javascript" src="js/my.js"></script>
        <script type="text/javascript" src="js/datePicker.js"></script>
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
                    <!--<div class="social-links">
                                                                              <ul>
                                                                                      <li><a href="#"><img src="images/facebook.png" title="facebook" /></a></li>
                                                                                      <li><a href="#"><img src="images/twitter.png" title="twitter" /></a></li>
                                                                                      <li><a href="#"><img src="images/feed.png" title="Rss" /></a></li>
                                                                                      <div class="clear"> </div>
                                                                              </ul>
                                                                      </div>-->
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
                        <li ><a href="modifyPatient.jsp">Modify Patient</a></li>
                        <li class="activeSub"><a href="appointment.jsp">Appointments</a></li>
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
                        <div class="col span_1_of_3">
                            <div class="contact_info">
                                <h3><a href="viewConsultantAppointment.jsp"><img src="images/consulltant.png">&nbsp;<span class="a_m">Consultant</span></a></h3>
                            </div>
                            <div class="contact_info">
                                <h3> <a href="viewClinicAppointment.jsp"><img src="images/clinic.png">&nbsp;<span class="a_m">Clinic</span></a></h3>
                            </div>
                            <div class="contact_info">
                                <h3><a href="viewApptByDate.jsp"><img src="images/date.png">&nbsp;<span class="a_m activeSub">Date</span></h3>
                            </div>

                            <br/><br/>

                            <div class="contact_info">
                                <h3><a href="appointment.jsp"><img src="images/sch_apt.png">&nbsp;<span class="a_m">SCHEDULE</span></a></h3>
                            </div>
                        </div>
                        <div class="col span_2_of_3">
                            <div class="contact-form">
                                <div>
                                    <form action="appointment" method="GET">
                                        <span><input readonly style="cursor: pointer;" type="text" id ="sel_date" placeholder="click to pop date" name="date_name"/></span>

                                        <input type="submit" value="view">
                                    </form>
                                </div>
                                <br/>
                                <!-- DATE SELECTED SCHEDULE INFORMATION -->
                                <%
                                    session.setAttribute("VIEW_TYPE",Appointment.MODE_DATE);
                                    if(request.getAttribute("VIEW_SHOW")==Boolean.TRUE){
                                %>
                                <h3> APPOINTMENT DATE </h3>
                                <input type="text" value="<%=request.getParameter("date_name")%>" readonly />
                                <table>
                                    <!-- SCHEDULE HEADING -->
                                    <tr>
                                        <th>Patient Name</th>
                                        <th>Hospital number</th>
                                        <th>Type</th>
                                        <th>Clinic</th>
                                        <th>Consultant</th>
                                        <th>Reason</th>
                                        <th>Referral</th>
                                        <th>Tally number</th>
                                        <th>Clinic time</th>
                                    </tr>
                                    <%
                                        Group<Appointment> appointments=(Group<Appointment>)request.getAttribute(
                                                Group.class.getName());
                                        for(Appointment appointment:appointments){
                                    %>
                                    <!-- SCHEDULE INFO -->
                                    <tr>
                                        <td><%=appointment.getNameOfPatient()%></td>
                                        <td><%=appointment.getHospitalNumber()%></td>
                                        <td><%=appointment.getAppointmentType()%></td>
                                        <td><%=appointment.getClinic()%></td>
                                        <td><%=appointment.getConsultantToSee()%></td>
                                        <td><%=appointment.getReason()%></td>
                                        <td><%=appointment.getReferralSource()%></td>
                                        <td><%=appointment.getTallyNumber()%></td>
                                        <td><%=appointment.getClinicTime()%></td>
                                    </tr>
                                    <%
                                        }
                                    %>
                                </table>
                                <%
                                    }
                                %>

                            </div>  <!-- CONSULTANT APPINTMENT END -->

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
