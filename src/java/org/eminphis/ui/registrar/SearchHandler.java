package org.eminphis.ui.registrar;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eminphis.db.DBManager;
import org.eminphis.dto.Patient;
import org.eminphis.dto.tableview.PersonalDetailsView;
import org.eminphis.dto.tableview.PersonalDetailsView.Match;

/**
 * <u>e-MINPHIS</u><br>
 * A project of the Health Information Systems Unit of the<br>
 * Department of Computer Science and Engineering,<br>
 * Obafemi Awolowo University, Ile-Ife.<br>
 *
 *
 * <pre>
 * Class name: SearchHandler.java
 * Version: 1.0
 * Author: Essiennta Emmanuel (colourfulemmanuel@gmail.com)
 *
 * <u>Description</u>
 * Responsible for retrieving the mode of search and presenting search results to the user.
 *
 * </pre>
 *
 * @author Essiennta Emmanuel (colourfulemmanuel@gmail.com)
 * @version 1.0
 */
public class SearchHandler{

    private final HttpServletRequest request;
    private final HttpServletResponse response;

    /**
     * Displays an error page with the specified {@code exception}
     *
     * @param exception the exception object, useful when the developer needs to trace the error
     */
    public static void showErrorPage(HttpServletResponse response,Exception exception) throws
            IOException{
        //An error occured while fulfilling your request
        response.getWriter().println(exception);
    }

    public SearchHandler(HttpServletRequest request,HttpServletResponse response){
        this.request=request;
        this.response=response;
    }

    /**
     * Retrieves the text in the text field captioned by 'Search patient by Name'.
     *
     * @return the content of the search text field.
     */
    public String retrieveQuery(){
        return request.getParameter("search_patient_by_name");
    }

    /**
     * Called when the search was successful.<br>
     * Displays information about the specified {@code patient}.
     *
     * @param patient the patient object capturing patient information
     */
    public void showPatientDetails(Patient patient) throws IOException{
        setDiagnosisAttributes(patient);
        setHospitalHistoryAttributes(patient);
        setNHISInformationAttributes(patient);
        setNextOfKinAttributes(patient);
        setOperationsAttributes(patient);
        setOtherInformationAttributes(patient);
        setPersonalDetailsAttributes(patient);
        response.sendRedirect("modify.jsp");
    }

    /**
     * Used by the auto-complete to display the current matches
     *
     * @param personalDetailsView
     */
    public void showSearchResults(){
//                    org.eminphis.dto.tableview.PersonalDetailsView personalDetailsView=DBManager.
//                            retrievePersonalDetailsView(searchHandler.retrieveQuery());
//        for(PersonalDetailsView.Match match:personalDetailsView){
//            //add match to auto-complete result
//        }
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private void setDiagnosisAttributes(Patient patient){
        request.getSession().setAttribute("date_diagnosed",patient.getDiagnosis().getDateDiagnosed());
        request.getSession().setAttribute("date_discharge",
                patient.getDiagnosis().getDateDischarged());
        request.getSession().setAttribute("diagnosis",patient.getDiagnosis().getDiagnosis());
        request.getSession().setAttribute("code_number",patient.getDiagnosis().getCodeNumber());
    }

    private void setHospitalHistoryAttributes(Patient patient){
        request.getSession().setAttribute("date_admitted",patient.getHospitalHistory().
                getDateAdmitted());
        request.getSession().setAttribute("refby_physician",patient.getHospitalHistory().
                getReferredBy());
        request.getSession().setAttribute("date_discharge",patient.getHospitalHistory().
                getDateDischarged());
        request.getSession().setAttribute("refto_physician",patient.getHospitalHistory().
                getReferredTo());
        request.getSession().setAttribute("discharge_to",patient.getHospitalHistory().
                getDischargedTo());
        request.getSession().setAttribute("outcome",patient.getHospitalHistory().getOutcomeOfCare());
    }

    private void setNHISInformationAttributes(Patient patient){
        request.getSession().setAttribute("nhis_number",patient.getNHISInformation().getNHISNumber());
        request.getSession().setAttribute("hmo",patient.getNHISInformation().getHMO());
        request.getSession().setAttribute("genotype",patient.getNHISInformation().getGenotype());
        request.getSession().setAttribute("blood_group",patient.getNHISInformation().getBloodGroup());
        request.getSession().setAttribute("hmo_code",patient.getNHISInformation().getHMOCode());
        request.getSession().setAttribute("hmo_id_no",patient.getNHISInformation().getHMOIDNumber());
        request.getSession().setAttribute("employer",patient.getNHISInformation().getEmployer());
        request.getSession().setAttribute("employers_address",patient.getNHISInformation().
                getEmployerAddress());
        request.getSession().setAttribute("allergies",patient.getNHISInformation().getAllergies());
    }

    private void setNextOfKinAttributes(Patient patient){
        request.getSession().setAttribute("next_of_kin_surname",patient.getNextOfKin().getSurname());
        request.getSession().setAttribute("next_of_kin_first_name",patient.getNextOfKin().
                getFirstName());
        request.getSession().setAttribute("next_of_kin_other_name",patient.getNextOfKin().
                getOtherName());
        request.getSession().setAttribute("nk_home_address",patient.getNextOfKin().getHomeAddress());
        request.getSession().setAttribute("nk_town",patient.getNextOfKin().getTown());
        request.getSession().setAttribute("nk_country",patient.getNextOfKin().getNationality());
        request.getSession().setAttribute("nk_state",patient.getNextOfKin().getState());
        request.getSession().setAttribute("nk_lga",patient.getNextOfKin().getLGA());
        request.getSession().setAttribute("relationship",patient.getNextOfKin().
                getRelationshipToNextOfKin());
        request.getSession().setAttribute("kin_number",patient.getNextOfKin().getPhoneNumber());
    }

    private void setOperationsAttributes(Patient patient){
        request.getSession().setAttribute("operation_date",patient.getOperations().getDate());
        request.getSession().setAttribute("op_surgeon",patient.getOperations().getOpSurgeon());
        request.getSession().setAttribute("operation",patient.getOperations().getOperation());
        request.getSession().setAttribute("operation_code_number",patient.getOperations().
                getCodeNumber());
    }

    private void setOtherInformationAttributes(Patient patient){
        request.getSession().setAttribute("other_town",patient.getOtherInformation().getTown());
        request.getSession().setAttribute("higher_level",patient.getOtherInformation().
                getEducationalLevel());
    }

    private void setPersonalDetailsAttributes(Patient patient){
        request.getSession().setAttribute("surname",patient.getPersonalDetails().getSurname());
        request.getSession().setAttribute("first_name",patient.getPersonalDetails().getFirstName());
        request.getSession().setAttribute("other_name",patient.getPersonalDetails().getOtherName());
        request.getSession().setAttribute("phone_number",
                patient.getPersonalDetails().getPhoneNumber());
        request.getSession().setAttribute("home_address",
                patient.getPersonalDetails().getHomeAddress());
        request.getSession().setAttribute("town",patient.getPersonalDetails().getTown());
        request.getSession().setAttribute("country",patient.getPersonalDetails().getNationality());
        request.getSession().setAttribute("lga",patient.getPersonalDetails().getLGA());
        request.getSession().setAttribute("date_of_reg",patient.getPersonalDetails().
                getDateOfRegistration());
        request.getSession().setAttribute("id_card_number",patient.getPersonalDetails().
                getNationalIDCardNumber());
        request.getSession().setAttribute("state",patient.getPersonalDetails().getStateOfOrigin());
    }
}
