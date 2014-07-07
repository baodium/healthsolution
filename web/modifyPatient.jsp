<%--
    Document   : modifyPatient
    Created on : 28-Jun-2014, 11:51:28
    Author     : olajuwon
--%>

<%@page import="org.eminphis.dto.patient.NhisInformation"%>
<%@page import="org.eminphis.dto.patient.NextOfKin"%>
<%@page import="org.eminphis.dto.patient.PersonalDetails"%>
<%@page import="org.eminphis.dto.Patient"%>
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
                <a href="appointment.jsp"></a>
                <div class="contact">
                    <a href="appointment.jsp"></a>
                    <div class="section group">
                        <div class="col span_2_of_3">
                            <div class="contact-form">
                                <%
                                    session.setAttribute("AUTO_COMPLETE_MODE",":SOMETHING_ELSE");
                                %>
                                <form action="modify" method="GET">
                                    <div class="searchPanel">


                                        <input type="text" class="searchPatient"  id="search" name="search_query" required placeholder="Enter query" >
                                        <input type="submit" value="search">

                                    </div>
                                </form>

                                <!-- display of the patient detail searched for -->
                                <%
                                    Patient patient=(Patient)request.getAttribute(Patient.class.getName());
                                    if(patient!=null){
                                        PersonalDetails personalDetails=patient.getPersonalDetails();
                                        NextOfKin nextOfKin=patient.getNextOfKin();
                                        NhisInformation nhisInformation=patient.getNhisInformation();
                                %>

                                <div>
                                    <h3>PATIENT DETAIL</h3>
                                    Hospital Number :<%=patient.getHospitalNumber()%><br />
                                    <form action="modify" method="POST">
                                        <input type="hidden" name="hospital_number" value="<%=patient.getHospitalNumber()%>" />
                                        <table>
                                            Personal Details:
                                            <tr>
                                            <p><td>SURNAME :&nbsp;&nbsp;</td><td> <input name="surname" type="text" value="<%=personalDetails.getSurname()%>"/></td></p>
                                            </tr>
                                            <tr>
                                            <p><td>FIRST NAME :&nbsp;&nbsp;</td><td> <input name="first_name" type="text" value="<%=personalDetails.getFirstName()%>"/></td></p>
                                            </tr>
                                            <tr>
                                            <p><td>OTHER NAME :&nbsp;&nbsp;</td><td> <input name="other_name" type="text" value="<%=personalDetails.getOtherName()%>"/></td></p>
                                            </tr>
                                            <tr>
                                            <p><td>SEX :&nbsp;&nbsp;</td><td> <input name="sex" type="text" value="<%=personalDetails.getSex()%>"/></td></p>
                                            </tr>
                                            <tr>
                                            <p><td>MARITAL STATUS :&nbsp;&nbsp;</td><td> <input name="marital_status" type="text" value="<%=personalDetails.getMaritalStatus()%>"/></td></p>
                                            </tr>
                                            <%
                                                if(personalDetails.getSex().equals("Female")&&personalDetails.
                                                        getMaritalStatus().equals("Married")){
                                            %>
                                            <tr>
                                            <p><td>MAIDEN NAME :&nbsp;&nbsp;</td><td> <input name="maiden_name" type="text" value="<%=personalDetails.getMaidenName()%>"/></td></p>
                                            </tr>
                                            <%
                                                }
                                            %>
                                            <tr>
                                            <p><td>PHONE NUMBER :&nbsp;&nbsp;</td><td> <input name="phone_number" type="text" value="<%=personalDetails.getPhoneNumbers()%>"/></td></p>
                                            </tr>
                                            <tr>
                                            <p><td>RESIDENTIAL ADDRESS :&nbsp;&nbsp;</td><td> <input name="home_address" type="text" value="<%=personalDetails.getResidentialAddress()%>"/></td></p>
                                            </tr>
                                            <tr>
                                            <p><td>TOWN :&nbsp;&nbsp;</td><td> <input name="town" type="text" value="<%=personalDetails.getTown()%>"/></td></p>
                                            </tr>
                                            <tr>
                                            <p><td>NATIONALITY :&nbsp;&nbsp;</td><td> <input name="country" type="text" value="<%=personalDetails.getNationality()%>"/></td></p>
                                            </tr>
                                            <tr>
                                            <p><td>STATE :&nbsp;&nbsp;</td><td> <input name="state" type="text" value="<%=personalDetails.getState()%>"/></td></p>
                                            </tr>
                                            <tr>
                                            <p><td>LGA :&nbsp;&nbsp;</td><td> <input name="lga" type="text" value="<%=personalDetails.getLga()%>"/></td></p>
                                            </tr>
                                            <tr>
                                            <p><td>DATE OF REGISTRATION :&nbsp;&nbsp;</td><td> <input name="date_of_reg" type="text" value="<%=personalDetails.getDateOfRegistration()%>"/></td></p>
                                            </tr>
                                            <tr>
                                            <p><td>NATIONAL ID CARD NUMBER :&nbsp;&nbsp;</td><td> <input name="id_card_number" type="text" value="<%=personalDetails.getNationalIdCardNumber()%>"/></td></p>
                                            </tr>
                                            <tr>
                                            <p><td>HIGHEST LEVEL OF EDUCATION :&nbsp;&nbsp;</td><td> <input name="higher_level" type="text" value="<%=personalDetails.getHighestLevelOfEducation()%>"/></td></p>
                                            </tr>
                                        </table>
                                        <table>
                                            Next of Kin:
                                            <tr>
                                            <p><td>SURNAME :&nbsp;&nbsp;</td><td> <input name="next_of_kin_surname" type="text" value="<%=nextOfKin.getSurname()%>"/></td></p>
                                            </tr>
                                            <tr>
                                            <p><td>FIRST NAME :&nbsp;&nbsp;</td><td> <input name="next_of_kin_first_name" type="text" value="<%=nextOfKin.getFirstName()%>"/></td></p>
                                            </tr>
                                            <tr>
                                            <p><td>OTHER NAME :&nbsp;&nbsp;</td><td> <input name="next_of_kin_other_name" type="text" value="<%=nextOfKin.getOtherName()%>"/></td></p>
                                            </tr>
                                            <tr>
                                            <p><td>TOWN :&nbsp;&nbsp;</td><td> <input name="nk_town" type="text" value="<%=nextOfKin.getTown()%>"/></td></p>
                                            </tr>
                                            <tr>
                                            <p><td>NATIONALITY :&nbsp;&nbsp;</td><td> <input name="nk_country" type="text" value="<%=nextOfKin.getNationality()%>"/></td></p>
                                            </tr>
                                            <tr>
                                            <p><td>STATE :&nbsp;&nbsp;</td><td> <input name="nk_state" type="text" value="<%=nextOfKin.getState()%>"/></td></p>
                                            </tr>
                                            <tr>
                                            <p><td>LGA :&nbsp;&nbsp;</td><td> <input name="nk_lga" type="text" value="<%=nextOfKin.getLga()%>"/></td></p>
                                            </tr>
                                            <tr>
                                            <p><td>RELATIONSHIP TO NEXT OF KIN :&nbsp;&nbsp;</td><td> <input name="relationship" type="text" value="<%=nextOfKin.getRelationshipToNextOfKin()%>"/></td></p>
                                            </tr>
                                            <tr>
                                            <p><td>PHONE NUMBER :&nbsp;&nbsp;</td><td> <input name="kin_number" type="text" value="<%=nextOfKin.getPhoneNumber()%>"/></td></p>
                                            </tr>
                                        </table>
                                        <table>
                                            NHIS Information:
                                            <tr>
                                            <p><td>NHIS NUMBER :&nbsp;&nbsp;</td><td> <input name="nhis_number" type="text" value="<%=nhisInformation.getNhisNumber()%>"/></td></p>
                                            </tr>
                                            <tr>
                                            <p><td>HMO :&nbsp;&nbsp;</td><td> <input name="hmo" type="text" value="<%=nhisInformation.getHmo()%>"/></td></p>
                                            </tr>
                                            <tr>
                                            <p><td>HMO CODE :&nbsp;&nbsp;</td><td> <input name="hmo_code" type="text" value="<%=nhisInformation.getHmoCode()%>"/></td></p>
                                            </tr>
                                            <tr>
                                            <p><td>HMO ID :&nbsp;&nbsp;</td><td> <input name="hmo_id_no" type="text" value="<%=nhisInformation.getHmoId()%>"/></td></p>
                                            </tr>
                                            <tr>
                                            <p><td>GENOTYPE :&nbsp;&nbsp;</td><td> <input name="genotype" type="text" value="<%=nhisInformation.getGenotype()%>"/></td></p>
                                            </tr>
                                            <tr>
                                            <p><td>BLOOD GROUP :&nbsp;&nbsp;</td><td> <input name="blood_group" type="text" value="<%=nhisInformation.getBloodGroup()%>"/></td></p>
                                            </tr>
                                            <tr>
                                            <p><td>EMPLOYER :&nbsp;&nbsp;</td><td> <input name="employer" type="text" value="<%=nhisInformation.getEmployer()%>"/></td></p>
                                            </tr>
                                            <tr>
                                            <p><td>EMPLOYER'S ADDRESS :&nbsp;&nbsp;</td><td> <input name="employers_address" type="text" value="<%=nhisInformation.getAddressOfEmployer()%>"/></td></p>
                                            </tr>
                                            <tr>
                                            <p><td>ALLERGIES :&nbsp;&nbsp;</td><td> <input name="allergies" type="text" value="<%=nhisInformation.getAllergies()%>"/></td></p>
                                            </tr>
                                        </table>
                                        <input type="submit" value="modify"/>
                                    </form>
                                </div>
                                <%
                                    }
                                %>
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
