<%--
    Document   : register
    Created on : 28-Jun-2014, 11:35:35
    Author     : olajuwon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>eMinphis</title>
        <link href="css/style.css" rel="stylesheet" type="text/css"  media="all" />
        <!--<link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>-->
        <link href='css/font-face.css' rel='stylesheet' type='text/css'>
        <link rel="stylesheet"  type="text/css" href="css/datePicker.css">
        <script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
        <script type="text/javascript" src="js/country_state.js"></script>
        <!--<script type="text/javascript" src="js/nig_state_lga.js.js"></script>-->
        <script type="text/javascript" src="js/datePicker.js"></script>
        <script type="text/javascript" src="js/my.js"></script>
        <style>
        </style>
        <script>
        </script>
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
                        <li class="activeSub"><a href="register.jsp">Add Patient</a></li>
                        <li ><a href="searchPatient.jsp">Search patient</a></li>
                        <li><a href="modifyPatient.jsp">Modify Patient</a></li>
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
                                <form action="register" method="POST">
                                    <div class="item selected personal_details ">
                                        <h3>Step 1 of 3</h3>
                                        <h2>PERSONAL DETAILS</h2>
                                        <div> <span>
                                                <label>SURNAME</label>
                                            </span> <span>
                                                <input type="text"  name="surname" >
                                            </span> </div>

                                        <div> <span>
                                                <label>FIRST NAME</label>
                                            </span> <span>
                                                <input type="text" name="first_name">
                                            </span> </div>
                                        <div> <span>
                                                <label>OTHER NAME</label>
                                            </span> <span>
                                                <input type="text" name="other_name">
                                            </span> </div>
                                        <div> <span>
                                                <label>SEX</label>
                                            </span> <span>
                                                <select id="sex" name="sex" onclick="showMaiden()">
                                                    <option value="male">Male</option>
                                                    <option value="female">Female</option>

                                                </select>
                                            </span> </div>
                                        <div> <span>
                                                <label>MARITAL STATUS</label>
                                            </span> <span>
                                                <select id="marital_status" name="marital_status" onclick="showMaiden()">
                                                    <option value="single">Single</option>
                                                    <option value="married">Married</option>
                                                    <option value="divorced">Divorced</option>
                                                    <option value="separated">Separated</option>

                                                </select>
                                            </span> </div>
                                        <div id="maiden_field"> <span>
                                                <label >MAIDEN NAME</label>
                                            </span> <span>
                                                <input type="hidden" id="m_d" name="maiden_name" />
                                            </span> </div>
                                        <div> <span>
                                                <label>PHONE NUMBER</label>
                                            </span> <span>
                                                <input type="text" name="phone_number"> <span id="add_num" style="cursor: pointer; color: #ff0000;">Add number</span>

                                            </span>
                                            <span id="numbers"></span>
                                        </div>
                                        <div> <span>
                                                <label>RESIDENTIAL ADDRESS</label>
                                            </span> <span>
                                                <textarea name="home_address"> </textarea>
                                            </span> </div>

                                        <div> <span>
                                                <label>TOWN</label>
                                            </span> <span>
                                                <input type="text" name="town">
                                            </span> </div>
                                        <div> <span>
                                                <label>NATIONALITY</label>
                                            </span> <span>
                                                <select style="cursor: pointer;" id="country" name="country">
                                                </select>
                                            </span> </div>
                                        <div> <span>
                                                <label>STATE</label>
                                            </span> <span>
                                                <select style="cursor: pointer;" id="state" name="state">
                                                </select>
                                            </span> </div>
                                        <!-- JAVASCRIPT TO POPULATE THE STATES FOR EACH COUNTRY SELECTED -->
                                        <script language="javascript">
                                            populateCountries("country", "state");
                                        </script>
                                        <div> <span>
                                                <label>LGA</label>
                                            </span> <span>
                                                <input type="text" name="lga">
                                            </span> </div>
                                        <div> <span>
                                                <label>DATE OF REGISTRATION</label>
                                            </span>
                                            <div id="feedback"></div>
                                            <span>
                                                <td><input style="cursor: pointer" type="text" id="reg_date" name="date_of_reg"  readonly placeholder="click to pop up calendar"><br/></td>

                                            </span> </div>
                                        <div> <span>
                                                <label>NATIONAL ID CARD NUMBER</label>
                                            </span> <span>
                                                <input type="text" name="id_card_number">
                                            </span> </div>
                                        <div>
                                            <span><label>Highest Eductaional Level</label></span>
                                            <span><select name="higher_level">
                                                    <option>NILL</option>
                                                    <option>Primary school</option>
                                                    <option>Secondary school</option>
                                                    <option>Polytechnic</option>
                                                    <option>University</option>
                                                    <option>MSc.</option>
                                                    <option>PhD.</option>
                                                </select></span>
                                        </div>

                                        <div class="panel"> <span class="form_section"  name="next_of_kin" >NEXT</span> </div>
                                    </div>



                                    <!-- END OF PERSONAL DETAIL SECTION -->

                                    <!--- next of kin SECTION START -->
                                    <div class="item next_of_kin">
                                        <h3>Step 2 OF 3</h3>
                                        <h2>NEXT OF KIN</h2>

                                        <div>
                                            <span><label>SURNAME</label></span>
                                            <span><input type="text"  name="next_of_kin_surname" ></span>
                                        </div>
                                        <div>
                                            <span><label>FIRST NAME</label></span>
                                            <span><input type="text" name="next_of_kin_first_name"></span>
                                        </div>
                                        <div>
                                            <span><label>OTHER NAME</label></span>
                                            <span><input type="text" name="next_of_kin_other_name"></span>
                                        </div>

                                        <div>
                                            <span><label>TOWN</label></span>
                                            <span><input type="text" name="nk_town"></span>
                                        </div>
                                        <div>
                                            <span><label>NATIONALITY</label></span>
                                            <span><select style="cursor: pointer;" id="nk_country" name="nk_country"></select></span>
                                        </div>
                                        <div>
                                            <span><label>STATE</label></span>
                                            <span><select style="cursor: pointer;" id="nk_state" name="nk_state"></select></span>
                                        </div>
                                        <!-- JAVASCRIPT TO POPULATE THE STATES FOR EACH COUNTRY SELECTED -->
                                        <script language="javascript">
                                            populateCountries("nk_country", "nk_state");
                                        </script>
                                        <div>
                                            <span><label>LGA</label></span>
                                            <span><input type="text" name="nk_lga"></span>
                                        </div>

                                        <div>
                                            <span><label>RELATIONSHIP TO NEXT OF KIN</label></span>
                                            <span><input type="text" name="relationship"></span>
                                        </div>
                                        <div>
                                            <span><label>PHONE NUMBER</label></span>
                                            <span><input type="text" name="kin_number"></span>
                                        </div>


                                        <div class="panel">
                                            <span class="form_section"  name="personal_details" >PREVIOUS</span> &nbsp;
                                            <span class="form_section"  name="nhis_info" >NEXT</span>
                                        </div>

                                    </div> <!-- END OF NEXT OF KIN SECTION -->


                                    <!-- START OF NHIS INFORMATION SECTION -->
                                    <div class="item nhis_info">
                                        <h3> STEP 3 OF 3 </h3>
                                        <h2>NHIS INFORMATION</h2>
                                        <div>
                                            <span><label>NHIS NUMBER</label></span>
                                            <span><input type="text" name="nhis_number"></span>
                                        </div>

                                        <div>
                                            <span><label>HMO</label></span>
                                            <span><select name="hmo">
                                                    <option>HMO 1</option>
                                                    <option>HMO 2</option>
                                                    <option>HMO 3</option>
                                                    <option>HMO 4</option>
                                                </select></span>
                                        </div>
                                        <div>
                                            <span><label>HMO CODE</label></span>
                                            <span><input type="text" name="hmo_code"></span>
                                        </div>

                                        <div>
                                            <span><label>GENOTYPE</label></span>
                                            <span><select name="genotype">
                                                    <option>AA</option>
                                                    <option>AS</option>
                                                    <option>SS</option>
                                                    <option>SC</option>
                                                </select></span>
                                        </div>
                                        <div>
                                            <span><label>BLOOD GROUP</label></span>
                                            <span><select name="blood_group">
                                                    <option>O positive</option>
                                                    <option>O negative</option>
                                                </select></span>
                                        </div>
                                        <div>
                                            <span><label>HMOS ID No</label></span>
                                            <span><input type="text" name="hmo_id_no"></span>
                                        </div>
                                        <div>
                                            <span><label>EMPLOYER</label></span>
                                            <span><input type="text" name="employer"></span>
                                        </div>
                                        <div>
                                            <span><label>EMPLOYER ADDRESS</label></span>
                                            <span><textarea name="employers_address"></textarea></span>
                                        </div>
                                        <div>
                                            <span><label>ALLERGIES</label></span>
                                            <span><input type="text" name="allergies"></span>
                                        </div>
                                        <div class="panel">
                                            <span class="form_section"  name="next_of_kin" >PREVIOUS</span> &nbsp;
                                        </div>
                                        <div>
                                            <span><input type="submit" value="ADD PATIENT"></span>
                                        </div>
                                    </div> <!-- END OF NHIS INFO -->

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
