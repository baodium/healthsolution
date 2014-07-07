<%--
    Document   : appointment
    Created on : 28-Jun-2014, 11:54:14
    Author     : olajuwon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
    <head>
        <title>eMinphis</title>
        <link href="css/style.css" rel="stylesheet" type="text/css"  media="all" />
        <!--	<link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>-->
        <link href='css/font-face.css' rel='stylesheet' type='text/css'>
        <link rel="stylesheet"  type="text/css" href="css/datePicker.css">
        <link rel="stylesheet" type="text/css" href="css/autocomplete.css" />
        <script src="js/jquery-1.8.0.min.js"></script>
        <script src="js/autocomplete.js"></script>
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
                                <h3><a href="appointment.jsp"><img src="images/sch_apt.png">&nbsp;<span class="a_m activeSub">SCHEDULE</span></a></h3>
                            </div>
                            <div class="contact_info">
                                <h3><a href="viewConsultantAppointment.jsp"><img src="images/viw_apt.png">&nbsp;<span class="a_m">VIEW</span></a></h3>
                            </div>
                        </div>
                        <div class="col span_2_of_3">
                            <div class="contact-form">
                                <%
                                    session.setAttribute("AUTO_COMPLETE_MODE",":APPOINTMENT");
                                %>
                                <form action="appointment" method="POST">
                                    <div>  <span>
                                            <input type="text"  class="searchPatient" id="search" name="search_query" placeholder="search patient name">

                                        </span> </div>
                                    <div> <span>
                                            <label>DATE OF BIRTH</label>
                                        </span> <span>
                                            <input type="text" name="patient_dob" readonly>
                                        </span> </div>
                                    <div> <span>
                                            <label>HOSPITAL NUMBER</label>
                                        </span> <span>
                                            <input type="text" name="hospital_number" readonly>
                                        </span> </div>
                                    <div> <span>
                                            <label>APPOINTMENT TYPE</label>
                                        </span> <span>
                                            <select name="appt_type">
                                                <option>New</option>
                                                <option>Re-schedule</option>
                                                <option>Re-visit</option>
                                            </select>
                                        </span> </div>
                                    <div> <span>
                                            <label>Clinic</label>
                                        </span> <span>
                                            <select name="appt_clinic">
                                                <option>Haematology</option>
                                                <option>Physiology</option>
                                            </select>
                                        </span> </div>
                                    <div> <span>
                                            <label>APPOINTMENT DATE</label>
                                        </span> <span>
                                            <input style="cursor: pointer;" type="text" id="appt_date" name="appt_date" readonly placeholder="click to pop up calendar"/>
                                        </span> </div>
                                    <div> <span>
                                            <label>CONSULTANT TO SEE</label>
                                        </span> <span>
                                            <select name="appt_consultant">
                                                <option>Dr. Dewunmi</option>
                                                <option>Dr. Azeez</option>
                                                <option>Dr. Obadimu</option>
                                                <option>Dr. Olabisi</option>
                                            </select>
                                        </span> </div>
                                    <div> <span>
                                            <label>Reason</label>
                                        </span> <span>
                                            <textarea name="appt_reason"> </textarea>
                                        </span> </div>
                                    <div> <span>
                                            <label>REFERRAL SOURCE</label>
                                        </span> <span>
                                            <input type="text" name="appt_referral"/>
                                        </span> </div>
                                    <div> <span>
                                            <label>TALLY NUMBER</label>
                                        </span> <span>
                                            <input type="text" name="appt_tally_num"/>
                                        </span> </div>
                                    <div> <span>
                                            <label>CLINIC TIME</label>
                                        </span> <span>
                                            <select name="clinic_time">
                                                <option value="12am">12am</option> <option value="1am">1am</option> <option value="2am">2am</option>
                                                <option value="3am">3am</option>   <option value="4am">4am</option> <option value="5am">5am</option>
                                                <option value="6am">6am</option>  <option value="7am">7am</option> <option value="8am">8am</option>
                                                <option value="9am">9am</option> <option value="10am">10am</option> <option value="11am">11am</option>
                                                <option value="12pm">12pm</option>   <option value="1pm">1pm</option> <option value="2pm">2pm</option>
                                                <option value="3pm">3pm</option>  <option value="4pm">4pm</option> <option value="5pm">5pm</option>
                                                <option value="6pm">6pm</option> <option value="7pm">7pm</option> <option value="8pm">8pm</option>
                                                <option value="9pm">9pm</option>   <option value="10pm">10pm</option> <option value="11pm">11pm</option>
                                            </select>

                                        </span> </div>
                                    <div> <span>
                                            <input type="submit" value="Submit">
                                        </span> </div>
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
