<%-- 
    Document   : index
    Created on : Apr 14, 2014, 4:57:50 PM
    Author     : moscoworld
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Memphis- Register</title>
        <link rel="stylesheet" type="text/css" href="css/font_face.css">
        <link rel="stylesheet"  type="text/css" href="css/style.css">
        <link rel="stylesheet"  type="text/css" href="css/datePicker.css">
        <link rel="stylesheet" type="text/css" href="css/jquery.autocomplete.css" />
        <script type="text/javascript" src="js/jquery-1.6.min.js"></script>
        <script src="js/jquery.autocomplete.js"></script> 
        <script type="text/javascript" src="js/my.js"></script>
        <script type="text/javascript" src="js/datePicker.js"></script>
        <script type= "text/javascript" src = "js/couuntry_state_lga.js"></script>

        <script>  
            google.load("jquery", "1");
        </script>

    </head>
    <body>
        <div class="header">   
            <img src="image/curr_user.jpg" height="20px"/> Welcome Adebayo Moses            
        </div>

        <!-- MENU BAR -->

        <div class="nav_bar">
            <!-- LOGO -->
            <a href="index.jsp" ><div class="logoIcon">
                    <br/>
                    <span class="p_span">e</span>MINPHIS
                    <!--<div class="logoIconText">hospital information system</div>-->
                </div>
            </a>

            <div class="menu">
                <li class="regMenu activeMenu" name="addPatient" ><a ><span class="iconWrap"><img src="image/addPatientIcon.png">&nbsp;</span>Add Patient</a></li>
                <li class="regMenu" name="searchPatient"  ><a ><span class="iconWrap"><img src="image/searchIcon.png">&nbsp</span>Search Patient</a> </li>
                <li class="regMenu "   name="modifyPatient"><a ><span class="iconWrap"><img src="image/modifyPatentIcon.png">&nbsp</span>Modify Patient</a> </li>
                <li  class="appointment"><a > <span class="iconWrap"><img src="image/appointmentIcon.png">&nbsp</span>Appointments<span class="subMenuIcon">&nbsp;&Del;</span></a> 

                    <ul>
                        <li class="regMenu appt_menu" name="newAppointment"> <a >&nbsp;Plan Appointment</a></li>
                        <li class="regMenu appt_menu" name="viewAppointment"><a >&nbsp;View Appointments</a></li>

                    </ul>

                </li>
            </div>




        </div>

        <!-- content in page -->
        <div class="content">


            <!--- menu contents -->
            <div class="item  addPatient selected ">
                <h3><img src="image/addPatient.png">&nbsp;ADD PATIENT</h3>

                <div class="item2  personal_details selected2">
                    <h4> Personal details</h4>
                    <!-- start OF ADD PATIENT FORM -->

                    <form action="register.jsp" method="post">
                        <table>
                            <tr>
                                <td>Surname </td>
                                <td><input type="text" name="surname" ><br/></td>
                            </tr>
                            <tr>
                                <td>First Name</td>
                                <td><input type="text" name="first_name" ><br/></td>
                            </tr>
                            <tr>
                                <td>Other Name</td>
                                <td><input type="text" name="other_name" ><br/></td>
                            </tr>

                            <tr>
                                <td>Sex</td>
                                <td><select name="sex" >
                                        <option>Male</option>
                                        <option>Female</option>
                                    </select><br/></td>
                            </tr>

                            <tr>
                                <td>Phone number</td>
                                <td><input type="text"  ><br/></td>
                            </tr>

                            <tr>
                                <td>Other number1 (if any)</td>
                                <td><input type="text" ><br/></td>
                            </tr>

                            <tr>
                                <td>Other number2 (if any)</td>
                                <td><input type="text"  ><br/></td>
                            </tr>

                            <tr>
                                <td>Home Address</td>
                                <td><input type="text"   name="home_address" ><br/></td>
                            </tr>

                            <tr>
                                <td>Maiden Name</td>
                                <td><input type="text"   name="maiden_name"><br/></td>
                            </tr>

                            <tr>
                                <td>Town</td>
                                <td><input type="text" name="town" ><br/></td>
                            </tr>
                            <tr>
                                <td>Nationality</td>
                                <td><select id="country" name="country" ></select><br/></td>
                            </tr>
                            <tr>
                                <td>State</td>
                                <td><select id="state"  name="state" ></select><br/></td>
                            </tr>

                            <!-- JAVASCRIPT TO POPULATE THE STATES FOR EACH COUNTRY SELECTED -->
                            <script language="javascript">
                                populateCountries("country", "state");
                            </script>
                            <tr>
                                <td>LGA</td>
                                <td><input type="text" name="lga" ><br/></td>
                            </tr> 
                            <tr>
                                <td>Date of Registration</td>
                                <td><input type="text" id ="reg_date" name="date_of_reg"  placeholder="click to pop up calendar"><br/></td>
                                <!-- javascript that generates the date field -->
                            <script type="text/javascript">
                                new datepickr('reg_date');

                            </script>
                            </tr>
                            <tr>
                                <td>National ID Card Number</td>
                                <td><input type="text" name="id_card_number" ><br/></td>
                            </tr>




                        </table>
                        <div class="panelContainer">
                            <div class="nextPanel">
                                <span class="activeSubMenu sub_regMenu"  name="next_kin" >NEXT</span>
                            </div>
                        </div>

                </div> 


                <div class="item2 next_kin">
                    <h4> Next of kin</h4>
                    <table>

                        <tr>
                            <td>Surname </td>
                            <td><input type="text" name="next_of_kin_surname" placeholder="type surname here" ><br/></td>
                        </tr>
                        <tr>
                            <td>First Name</td>
                            <td><input type="text" name="next_of_kin_first_name" ><br/></td>
                        </tr>
                        <tr>
                            <td>Other Name</td>
                            <td><input type="text" name="next_of_kin_other_name" ><br/></td>
                        </tr>
                        <tr>
                            <td>Home Address</td>
                            <td><input type="text"   name="home_address" ><br/></td>
                        </tr>
                        <tr>
                            <td>Town</td>
                            <td><input type="text" name="town" ><br/></td>
                        </tr>
                        <tr>
                            <td>Nationality</td>
                            <td><select id="country" name="country" ></select><br/></td>
                        </tr>
                        <tr>
                            <td>State</td>
                            <td><select id="state"  name="state" ></select><br/></td>
                        </tr>

                        <!-- JAVASCRIPT TO POPULATE THE STATES FOR EACH COUNTRY SELECTED -->
                        <script language="javascript">
                            populateCountries("country", "state");
                        </script>
                        <tr>
                            <td>LGA</td>
                            <td><input type="text" name="lga" ><br/></td>
                        </tr> 
                        <tr>
                            <td>Relationship to next of kin</td>
                            <td><input type="text" name="relationship" ><br/></td>
                        </tr> 
                        <tr>
                            <td>Phone number</td>
                            <td><input type="number" name="kin_number" ><br/></td>
                        </tr> 


                    </table>

                    <div class="panelContainer">
                        <div class="previousPanel">
                            <span class="activeSubMenu sub_regMenu"  name="personal_details" >PREVI0US</span>

                        </div>

                        <div class="nextPanel">
                            <span class="activeSubMenu sub_regMenu"  name="diagnosis" >NEXT</span>
                        </div>
                    </div>
                </div>


                <!--                <div class="item2 hospital_history">
                                    <h4>  Hospital History </h4>
                
                                    <table>
                                        <tr>
                                            <td>Date Admitted </td>
                                            <td><input type="date" name="date_admitted" ><br/></td>
                                        </tr> 
                
                                        <tr>
                                            <td>Referred by: </td>
                                            <td><select  name="physician" >
                                                  <option>Consultant 1</option>
                                                    <option>Consultant 2</option>
                                                    <option>Consultant 3</option>
                                                </select><br/></td>
                                        </tr> 
                
                                        <tr>
                                            <td>Date Discharged </td>
                                            <td><input type="date" name="date_discharge" ><br/></td>
                                        </tr> 
                
                                        <tr>
                                            <td>Referred to: </td>
                                            <td><select  name="physician" >
                                                    <option>Physician</option>
                                                    <option>Surgeon</option>
                                                    <option>Ward</option>
                                                </select><br/>
                                            </td>
                                        </tr> 
                
                                        <tr>
                                            <td>Discharged to</td>
                                            <td><select  name="discharge_to" >
                                                    <option>Home</option>
                                                    <option>Office</option>
                                                    <option>Out-Patient ward</option>
                                                </select><br/>
                                            </td>
                
                                        </tr> 
                
                                        <tr>
                                            <td>Outcome of care </td>
                                            <td><input type="text" name="outcome" ><br/></td>
                                        </tr>
                
                                    </table>
                
                                    <div class="panelContainer">
                                        <div class="previousPanel">
                                            <span class="activeSubMenu sub_regMenu "  name="next_kin" >PREVI0US</span>
                                        </div>
                                        <div class="nextPanel">
                                            <span class="activeSubMenu sub_regMenu "  name="diagnosis" >NEXT</span>
                                        </div>
                                    </div>
                
                                </div>-->

                <div class="item2 diagnosis">
                    <h4>Diagnosis</h4>
                    <table>
                        <tr>
                            <td>Date</td>
                            <td><input type="date" name="date_diagnosed" ><br/></td>
                        </tr> 
                        <tr>
                            <td>Date Discharged </td>
                            <td><input type="date" name="date_discharge" ><br/></td>
                        </tr> 

                        <tr>
                            <td>Diagnosis </td>
                            <td><input type="text" name="date_discharge" ><br/></td>
                        </tr> 

                        <tr>
                            <td>Code number </td>
                            <td><input type="number" name="code_number" ><br/></td>
                        </tr> 
                    </table>
                    <div class="panelContainer">
                        <div class="previousPanel">
                            <span class="activeSubMenu sub_regMenu"  name="next_kin" >PREVI0US</span> &nbsp;
                        </div>
                        <div class="nextPanel">
                            <span class="activeSubMenu sub_regMenu"  name="operations" >NEXT</span>
                        </div>
                    </div>

                </div>


                <div class="item2 operations">
                    <h4>Operations</h4>
                    <table>
                        <tr>
                            <td>Date</td>
                            <td><input type="date" name="operation_date" ><br/></td>
                        </tr> 
                        <tr>
                            <td>Surgeon</td>
                            <td><select>
                                    <option>Dr. Dewunmi</option>
                                    <option>Dr. Essienta</option>
                                    <option>Dr. Augustina</option>
                                </select>
                            </td>
                        </tr> 

                        <tr>
                            <td>Operation</td>
                            <td><select>
                                    <option>ENT </option>
                                    <option>Appendicitis</option>
                                    <option>Abortion</option>
                                </select>
                            </td>
                        </tr> 


                        <tr>
                            <td>Code number </td>
                            <td><input type="number" name="operation_code_number" ><br/></td>
                        </tr> 
                    </table>
                    <div class="panelContainer">
                        <div class="previousPanel">
                            <span class="activeSubMenu sub_regMenu"  name="diagnosis" >PREVI0US</span> &nbsp;
                        </div>
                        <div class="nextPanel">
                            <span class="activeSubMenu sub_regMenu"  name="others" >NEXT</span>
                        </div>
                    </div>

                </div>


                <div class="item2 others">
                    <h4>Other Information</h4>
                    <table>
                        <tr>
                            <td>Town / Village </td>
                            <td><input type="number" name="town" ><br/></td>
                        </tr> 
                        <tr>
                            <td>Highest Educational level</td>
                            <td><select>
                                    <option>Primary school </option>
                                    <option>Secondary school</option>
                                    <option>Polytechnic</option>
                                    <option>University</option>
                                    <option>MSc.</option>
                                    <option>PhD.</option>
                                </select>
                            </td>
                        </tr> 


                    </table>

                    <div class="panelContainer">
                        <div class="previousPanel">
                            <span class="activeSubMenu sub_regMenu"  name="operations" >PREVI0US</span> &nbsp;
                        </div>
                        <div class="nextPanel">
                            <span class="activeSubMenu sub_regMenu"  name="nhis_info" >NEXT</span>
                        </div>
                    </div>

                </div>

                <div class="item2 nhis_info">
                    <h4>NHIS Information</h4>
                    <table>
                        <tr>
                            <td>NHIS Number </td>
                            <td><input type="text" name="nhis_number" ><br/></td>
                        </tr> 
                        <tr>
                            <td>Referral </td>
                            <td><input type="text" name="referral" ><br/></td>
                        </tr> 
                        <tr>
                            <td>HMO Code</td>
                            <td><select>
                                    <option>HMO 1</option>
                                    <option>HMO 2</option>
                                    <option>HMO 3</option>
                                    <option>HMO 4</option>

                                </select>
                            </td>
                        </tr> 

                        <tr>
                            <td>Genotype</td>
                            <td><select>
                                    <option>AA</option>
                                    <option>AS</option>
                                    <option>SS</option>
                                    <option>SC</option>

                                </select>
                            </td>
                        </tr> 

                        <tr>
                            <td>Blood Group</td>
                            <td><select>
                                    <option>O positive</option>
                                    <option>O negative</option>


                                </select>
                            </td>
                        </tr> 

                        <tr>
                            <td>HMO Code</td>
                            <td><input type="text" name="hmo_code" ><br/></td>
                        </tr>  

                        <tr>
                            <td>HMOS Id No</td>
                            <td><input type="text" name="hmo_id_no" ><br/></td>
                        </tr>  
                        <tr>
                            <td>Employer</td>
                            <td><input type="text" name="employer" ><br/></td>
                        </tr>

                        <tr>
                            <td>Employers address</td>
                            <td><input type="text" name="employers_address" ><br/></td>
                        </tr>
                        <tr>
                            <td>Allergies</td>
                            <td><input type="text" name="allergies" ><br/></td>
                        </tr>



                    </table>
                    <div class="panelContainer">
                        <div class="previousPanel">
                            <span class="activeSubMenu sub_regMenu"  name="others" >PREVI0US</span> &nbsp;
                        </div>
                        <input type="submit" value="ADD PATIENT">
                        <!-- END OF ADD PATIENT FORM -->
                        </form>  
                    </div>

                </div>

            </div>

            <div class="item  searchPatient">
                <h3><img src="image/search.png">SEARCH PATIENT</h3>

                <form>
                    <input class="searchPatient" type="search" name="search_patient_by_name" placeholder="Search by name, id or NHIS number" >
                    <input type="submit" value="search">
                </form>

                <script>
                    jQuery(function(){
                        $(".searchPatient").autocomplete("list.jsp");
                    });
                </script>

            </div> 

            <div class="item modifyPatient">
                <h3><img src="image/modifyPatient.png">MODIFY PATIENT </h3>
                <form>
                    <input class="searchPatient" type="search" name="search_patient_by_name" placeholder="Search by name, id or NHIS number" >
                    <input type="submit" value="search">
                </form>
                
                <div>
                    <br/>
                    PATIENTS DETAILS DISPLAYED HERE
                </div>
            </div>


            <div class="item newAppointment">
                <h3> <img src="image/appointment.png">&nbsp;SCHEDULE APPOINTMENT </h3>

                <form name="plan_appointment">
                    <table>

                        <tr>
                            <td>Find Patient function</td>
                            <td><input type="text" name="find_patient_function" ><br/></td>
                        </tr>  
                         <tr>
                            <td>Date of Birth</td>
                            <td><input type="text" name="patient_dob" readonly="readonly"><br/></td>
                        </tr>  
                         <tr>
                            <td>Hospital number</td>
                            <td><input type="text" name="hospital_number" readonly="readonly" ><br/></td>
                        </tr>  
                        <tr>
                            <td>Appointment Type</td>
                            <td><select>
                                    <option>New</option>
                                    <option>Re-schedule</option>
                                    <option>Re-visit</option>


                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Clinic</td>
                            <td><select>
                                    <option>Haematology</option>
                                    <option>Physiology</option>


                                </select>
                            </td>
                        </tr>
                        <tr> 
                            <td>Appointment Date</td>
                            <td><input type="date" name="appointment_date" ><br/></td>
                        </tr> 

                        <tr>
                            <td>Consultant to see</td>
                            <td><select>
                                    <option>Dr. Dewunmi</option>
                                    <option>Dr. Essienta</option>
                                    <option>Dr. Augustina</option>
                                </select>
                            </td>
                        </tr> 

                        <tr>
                            <td>Reason</td>
                            <td><input type="text" name="appointment_reason" ><br/></td>
                        </tr>

                        <tr>
                            <td>Referral source</td>
                            <td><input type="text" name="appointment_referral" ><br/></td>
                        </tr>
                        <tr>
                            <td>Tally Number</td>
                            <td><input type="text" name="appointment_tally_number" ><br/></td>
                        </tr>
                        <tr>
                            <td>Clinic time</td>
                            <td><input type="text" name="appointment_time_name" ><br/></td>
                        </tr>

                    </table>
                    <div class="panelContainer">
                        <input type="submit" value="submit">
                    </div>
                </form>
            </div>


            <div class="item viewAppointment">
                <h3> <img src="image/appointment.png">&nbsp;VIEW APPOINTMENT</h3>

                <!-- SUB MENU FOR VIEW APPOINTMENT -->
                <div class="sub_Menu">
                    <span class="sub_sub_regMenu activeSubSubMenu" name="by_consultant">Consultant</span>

                    <span class="sub_sub_regMenu" name="by_clinic">Clinic</span>

                    <span class="sub_sub_regMenu" name="by_date">Date</span>

                </div>

                <!-- content of the submenu -->

                <div class="item3 by_consultant selected3">
                    BY CONSULTANT



                </div>

                <div class="item3 by_clinic">

                    BY CLINIC
                </div>

                <div class="item3 by_date">
                    BY DATE
                </div>

            </div>



    </body>
</html>
