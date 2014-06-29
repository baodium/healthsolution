package org.eminphis.ui.manager;

import org.eminphis.dto.patient.OtherInformation;
import org.eminphis.dto.patient.Diagnosis;
import org.eminphis.dto.patient.NHISInformation;
import org.eminphis.dto.patient.Operations;
import org.eminphis.dto.patient.NextOfKin;
import org.eminphis.dto.patient.HospitalHistory;
import org.eminphis.dto.patient.PersonalDetails;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eminphis.dto.*;

/**
 * <u>e-MINPHIS</u><br>
 * A project of the Health Information Systems Unit of the<br>
 * Department of Computer Science and Engineering,<br>
 * Obafemi Awolowo University, Ile-Ife.<br>
 *
 *
 * <pre>
 Class name: RegistrationManager.java
 Version: 1.0
 Author: Essiennta Emmanuel (colourfulemmanuel@gmail.com)

 <u>Description</u>
 * Manages the presentation of the registration page and also the retrieval of the fields in it.
 *
 * </pre>
 *
 * @author Essiennta Emmanuel (colourfulemmanuel@gmail.com)
 * @version 1.0
 */
public class RegistrationManager extends UIManager{

    private Patient patient;

    public RegistrationManager(HttpServletRequest request,HttpServletResponse response){
        super(request,response);
        patient=new Patient(
                retrieveDiagnosis(),
                retrieveHospitalHistory(),
                retrieveNHISInformation(),
                retrieveNextOfKin(),
                retrieveOperations(),
                retrieveOtherInformation(),
                retrievePersonalDetails());
    }

    /**
     * Get the patient's details
     * 
     *
     * @return the patient's information object
     */
    public Patient getPatient(){
        return patient;
    }

    private Diagnosis retrieveDiagnosis(){
        return new Diagnosis(
                request.getParameter("date_diagnosed"),
                request.getParameter("date_discharge"),
                request.getParameter("diagnosis"),
                request.getParameter("code_number"));
    }

    private HospitalHistory retrieveHospitalHistory(){
        return new HospitalHistory(
                request.getParameter("date_admitted"),
                request.getParameter("refby_physician"),
                request.getParameter("date_discharge"),
                request.getParameter("refto_physician"),
                request.getParameter("discharge_to"),
                request.getParameter("outcome"));
    }

    private NHISInformation retrieveNHISInformation(){
        return new NHISInformation(
                request.getParameter("nhis_number"),
                request.getParameter("hmo"),
                request.getParameter("genotype"),
                request.getParameter("blood_group"),
                request.getParameter("hmo_code"),
                request.getParameter("hmo_id_no"),
                request.getParameter("employer"),
                request.getParameter("employers_address"),
                request.getParameter("allergies"));
    }

    private NextOfKin retrieveNextOfKin(){
        return new NextOfKin(
                request.getParameter("next_of_kin_surname"),
                request.getParameter("next_of_kin_first_name"),
                request.getParameter("next_of_kin_other_name"),
                request.getParameter("nk_home_address"),
                request.getParameter("nk_town"),
                request.getParameter("nk_country"),
                request.getParameter("nk_state"),
                request.getParameter("nk_lga"),
                request.getParameter("relationship"),
                request.getParameter("kin_number"));
    }

    private Operations retrieveOperations(){
        return new Operations(
                request.getParameter("operation_date"),
                request.getParameter("op_surgeon"),
                request.getParameter("operation"),
                request.getParameter("operation_code_number"));
    }

    private OtherInformation retrieveOtherInformation(){
        return new OtherInformation(
                request.getParameter("other_town"),
                request.getParameter("higher_level"));
    }

    private PersonalDetails retrievePersonalDetails(){
        return new PersonalDetails(
                request.getParameter("surname"),
                request.getParameter("first_name"),
                request.getParameter("other_name"),
                request.getParameter("phone_number"),
                request.getParameter("home_address"),
                request.getParameter("town"),
                request.getParameter("country"),
                request.getParameter("lga"),
                request.getParameter("date_of_reg"),
                request.getParameter("id_card_number"),
                request.getParameter("state"));
    }

    @Override
    public void showErrorPage(Exception exception) throws IOException{
        response.getWriter().println(
                "<h2>An error occurred while inserting the patient's details</h2>");
        super.showErrorPage(exception);
    }

    @Override
    public void showSuccessPage() throws IOException{
        response.getWriter().println("<h2>Patient details was inserted successfully.</h2>");
    }
}
