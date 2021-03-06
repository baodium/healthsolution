package org.eminphis.ui.manager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eminphis.dto.Patient;
import org.eminphis.dto.patient.NextOfKin;
import org.eminphis.dto.patient.NhisInformation;
import org.eminphis.dto.patient.PersonalDetails;

/**
 * <u>e-MINPHIS</u><br>
 * A project of the Health Information Systems Unit of the<br>
 * Department of Computer Science and Engineering,<br>
 * Obafemi Awolowo University, Ile-Ife.<br>
 *
 *
 * <pre>
 * Class name: RegistrationManager.java
 * Version: 1.0
 * Author: Essiennta Emmanuel (colourfulemmanuel@gmail.com)
 *
 * <u>Description</u>
 * Manages the presentation of the registration page and also the retrieval of the fields in it.
 *
 * </pre>
 *
 * @author Essiennta Emmanuel (colourfulemmanuel@gmail.com)
 * @version 1.0
 */
public class RegistrationManager extends UIManager{

    private final Patient patient;

    public RegistrationManager(HttpServletRequest request,HttpServletResponse response){
        super(request,response);
        patient=new Patient(
                retrieveNextOfKin(),
                retrieveNHISInformation(),
                retrievePersonalDetails()
        );
        patient.setHospitalNumber(Long.parseLong(request.getParameter("hospital_number")));
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

    private NhisInformation retrieveNHISInformation(){
        return new NhisInformation(
                Long.parseLong(request.getParameter("nhis_number")),
                request.getParameter("hmo"),
                request.getParameter("hmo_code"),
                request.getParameter("genotype"),
                request.getParameter("blood_group"),
                request.getParameter("hmo_id_no"),
                request.getParameter("employer"),
                request.getParameter("employers_address"),
                request.getParameter("allergies")
        );
    }

    private NextOfKin retrieveNextOfKin(){
        return new NextOfKin(
                request.getParameter("next_of_kin_surname"),
                request.getParameter("next_of_kin_first_name"),
                request.getParameter("next_of_kin_other_name"),
                request.getParameter("nk_town"),
                request.getParameter("nk_country"),
                request.getParameter("nk_state"),
                request.getParameter("nk_lga"),
                request.getParameter("relationship"),
                request.getParameter("kin_number")
        );
    }

    private PersonalDetails retrievePersonalDetails(){
        return new PersonalDetails(
                request.getParameter("surname"),
                request.getParameter("first_name"),
                request.getParameter("other_name"),
                request.getParameter("sex"),
                request.getParameter("marital_status"),
                request.getParameter("maiden_name"),
                request.getParameter("phone_number"),//is actually multivalued
                request.getParameter("home_address"),
                request.getParameter("town"),
                request.getParameter("country"),
                request.getParameter("state"),
                request.getParameter("lga"),
                request.getParameter("date_of_reg"),
                request.getParameter("id_card_number"),
                request.getParameter("higher_level")
        );
    }
}
