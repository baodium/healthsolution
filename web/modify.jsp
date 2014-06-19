<%-- 
    Document   : modify
    Created on : May 28, 2014, 9:44:25 PM
    Author     : AZEEZ TAIWO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PATIENT RECORD</title>
    </head>
    <body>
            
        <form action="ModifyServlet" method="get">
            <input type="text" name="patient_id" value="" /><input type="submit" value="search" name="search_button" /><br />
        Surname<input type="text" name="surname" value=" <%=(String)session.getAttribute("surname")%>">
        Firstname<input type="text" name="first_namevalue=" value="<%=(String)session.getAttribute("first_namevalue")%>" /><br/>
        Othername<input type="text" name="other_namevalue=" value="<%=(String)session.getAttribute("other_namevalue")%>" />
        Phone No<input type="text" name="phone_number" value=" <%=(String)session.getAttribute("phone_number")%>"><br/>
        Home Address<input type="text" name="home_address" value=" <%=(String)session.getAttribute("home_address")%>">
        Town<input type="text" name="town" value=" <%=(String)session.getAttribute("town")%>"><br/>
        Nationality<input type="text" name="country" value=" <%=(String)session.getAttribute("country")%>">
        State<input type="text" name="state" value=" <%=(String)session.getAttribute("state")%>"><br/>
        LGA<input type="text" name="lga" value=" <%=(String)session.getAttribute("lga")%>">
        Date of Registration<input type="text" name="date_of_reg" value=" <%=(String)session.getAttribute("date_of_reg")%>"><br/>
        National ID Card Number<input type="text" name="id_card_number" value=" <%=(String)session.getAttribute("id_card_number")%>" >
        Surname<input type="text" name="next_of_kin_surname" value=" <%=(String)session.getAttribute("next_of_kin_surname")%>"><br/>
        First Name<input type="text" name="next_of_kin_first_name" value=" <%=(String)session.getAttribute("next_of_kin_first_name")%>">
        Other Name<input type="text" name="next_of_kin_other_name" value=" <%=(String)session.getAttribute("next_of_kin_other_name")%>"><br/>
        Home Address<input type="text" name="nk_home_address" value=" <%=(String)session.getAttribute("nk_home_address")%>" >
        Town<input type="text" name="nk_town" value=" <%=(String)session.getAttribute("nk_town")%>"><br/>
        Nationality<input type="text" name="nk_country" value=" <%=(String)session.getAttribute("nk_country")%>">
        State<input type="text" name="nk_state" value=" <%=(String)session.getAttribute("nk_state")%>"><br/>
        LGA<input type="text" name="nk_lga" value=" <%=(String)session.getAttribute("nk_lga")%>">
        Relationship To Next Of Kin<input type="text" name="relationship" value=" <%=(String)session.getAttribute("relationship")%>"><br/>
        Phone Number<input type="text" name="kin_number" value=" <%=(String)session.getAttribute("kin_number")%>">
        Date Admitted<input type="text" name="date_admitted" value=" <%=(String)session.getAttribute("date_admitted")%>"><br/>
        Referred By<input type="text" name="refby_physician" value=" <%=(String)session.getAttribute("refby_physician")%>">
        Date Discharged<input type="text" name="date_discharge" value=" <%=(String)session.getAttribute("date_discharge")%>"><br/>
        Referred To<input type="text" name="refto_physician" value=" <%=(String)session.getAttribute("refto_physician")%>">
        Discharged To<input type="text" name="discharge_to" value=" <%=(String)session.getAttribute("discharge_to")%>"><br/>
        Outcome<input type="text" name="outcome" value=" <%=(String)session.getAttribute("outcome")%>">
        Date Diagnosed<input type="text" name="date_diagnosed" value=" <%=(String)session.getAttribute("date_diagnosed")%>"><br/>
        Date Discharged<input type="text" name="date_discharge" value=" <%=(String)session.getAttribute("date_discharge")%>">
        Diagnosis<input type="text" name="diagnosis" value=" <%=(String)session.getAttribute("diagnosis")%>"><br/>
        Code Number<input type="text" name="code_number" value=" <%=(String)session.getAttribute("code_number")%>">
        Operation Date<input type="text" name="operation_date" value=" <%=(String)session.getAttribute("operation_date")%>"><br/>
        Surgeon<input type="text" name="op_surgeon" value=" <%=(String)session.getAttribute("op_surgeon")%>">
        Operation<input type="text" name="operation" value=" <%=(String)session.getAttribute("operation")%>" ><br/>
        code Number<input type="text" name="operation_code_number" value=" <%=(String)session.getAttribute("operation_code_number")%>">
        Town<input type="text" name="other_town" value=" <%=(String)session.getAttribute("other_town")%>"><br/>
        Highest Edu Level<input type="text" name="higher_level" value=" <%=(String)session.getAttribute("higher_level")%>">
        NHIS Number<input type="text" name="nhis_number" value=" <%=(String)session.getAttribute("nhis_number")%>"><br/>
        HMO<input type="text" name="hmo" value=" <%=(String)session.getAttribute("hmo")%>">
        Genotype<input type="text" name="genotype"value=" <%=(String)session.getAttribute("genotype")%>"><br/>
        Blood Group<input type="text" name="blood_group" value=" <%=(String)session.getAttribute("blood_group")%>">
        HMO Code<input type="text" name="hmo_code" value=" <%=(String)session.getAttribute("hmo_code")%>"><br/>
        HMO id Number<input type="text" name="hmo_id_no" value=" <%=(String)session.getAttribute("hmo_id_no")%>">
        Employer<input type="text" name="employer" value=" <%=(String)session.getAttribute("employer")%>"><br/>
        Address<input type="text" name="employers_address" value=" <%=(String)session.getAttribute("employers_address")%>">
        Allergies<input type="text" name="allergies" value=" <%=(String)session.getAttribute("allergies")%>">
        
        </form>
        </body>
</html>
