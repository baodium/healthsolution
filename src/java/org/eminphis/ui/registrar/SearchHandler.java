package org.eminphis.ui.registrar;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;
import org.eminphis.dto.Patient;
import org.eminphis.dto.tableview.PersonalDetailsView;
import org.eminphis.exceptions.InvalidRequestException;

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

    /**
     * Search mode indicating that the search type is not known.
     */
    public static final int SEARCH_UNKNOWN=-1;
    /**
     * Search mode indicating a search by ID number.
     */
    public static final int SEARCH_ID=0;
    /**
     * Search mode indicating a search by NHIS number.
     */
    public static final int SEARCH_NHIS=1;
    /**
     * Search mode indicating a search by the prefix of the patient's name.
     */
    public static final int SEARCH_PREFIX=2;
    private final HttpServletRequest request;
    private final HttpServletResponse response;
    private int searchType=SEARCH_UNKNOWN;

    /**
     * Displays an error page with the specified {@code technicalMessage}
     *
     * @param technicalMessage the message returned from the exception object.
     * Useful for the developer when trying to fix the error.
     */
    public static void showErrorPage(String technicalMessage){
        //An error occured while fulfilling your request
        
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public SearchHandler(HttpServletRequest request,HttpServletResponse response){
        this.request=request;
        this.response=response;
        if(request.getParameter("search_patient_by_name")!=null)
            searchType=SEARCH_PREFIX;
        else if(request.getParameter("search_patient_by_id")!=null)
            searchType=SEARCH_ID;
        else if(request.getParameter("search_patient_by_nhis")!=null)
            searchType=SEARCH_NHIS;
        else
            searchType=SEARCH_UNKNOWN;
    }

    public int getSearchType(){
        return searchType;
    }

    /**
     * Retrieves the ID in the text field captioned by 'Search patient by ID Number'.
     *
     * @return the ID that was found in the text field.
     */
    public long retrieveID(){
        return Long.parseLong(request.getParameter("search_patient_by_id"));
    }

    /**
     * Retrieves the text in the text field captioned by 'Search patient by Name'.
     *
     * @return the content of the search text field.
     */
    public String retrievePrefix(){
        return request.getParameter("search_patient_by_name");
    }

    /**
     * Retrieves the text in the text field captioned by 'Search patient by NHIS Number'.
     *
     * @return the content of the search text field.
     */
    public String retrieveNHISNumber(){
        return request.getParameter("search_patient_by_nhis");
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
        response.sendRedirect("/modify.jsp");
    }

    /**
     * Used by the auto-complete to display the current matches
     *
     * @param personalDetailsView
     */
    public void showSearchResults(PersonalDetailsView personalDetailsView){
        for(PersonalDetailsView.Match match:personalDetailsView){
            //add match to auto-complete result
        }
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private void setDiagnosisAttributes(Patient patient){
        request.getSession().setAttribute("date_diagnosed",patient.getDiagnosis().getDateDiagnosed());
        request.getSession().setAttribute("date_discharge",patient.getDiagnosis().getDateDischarged());
        request.getSession().setAttribute("diagnosis",patient.getDiagnosis().getDiagnosis());
        request.getSession().setAttribute("code_number",patient.getDiagnosis().getCodeNumber());
    }

    private void setHospitalHistoryAttributes(Patient patient){
        request.getSession().setAttribute("date_admitted",patient.getHospitalHistory().getDateAdmitted());
        request.getSession().setAttribute("refby_physician",patient.getHospitalHistory().getReferredBy());
        request.getSession().setAttribute("date_discharge",patient.getHospitalHistory().getDateDischarged());
        request.getSession().setAttribute("refto_physician",patient.getHospitalHistory().getReferredTo());
        request.getSession().setAttribute("discharge_to",patient.getHospitalHistory().getDischargedTo());
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
        request.getSession().setAttribute("employers_address",patient.getNHISInformation().getEmployerAddress());
        request.getSession().setAttribute("allergies",patient.getNHISInformation().getAllergies());
    }

    private void setNextOfKinAttributes(Patient patient){
        request.getSession().setAttribute("next_of_kin_surname",patient.getNextOfKin().getSurname());
        request.getSession().setAttribute("next_of_kin_first_name",patient.getNextOfKin().getFirstName());
        request.getSession().setAttribute("next_of_kin_other_name",patient.getNextOfKin().getOtherName());
        request.getSession().setAttribute("nk_home_address",patient.getNextOfKin().getHomeAddress());
        request.getSession().setAttribute("nk_town",patient.getNextOfKin().getTown());
        request.getSession().setAttribute("nk_lga",patient.getNextOfKin().getNationality());
        request.getSession().setAttribute("nk_state",patient.getNextOfKin().getState());
        request.getSession().setAttribute("nk_lga",patient.getNextOfKin().getLGA());
        request.getSession().setAttribute("relationship",patient.getNextOfKin().getRelationshipToNextOfKin());
        request.getSession().setAttribute("kin_number",patient.getNextOfKin().getPhoneNumber());
    }

    private void setOperationsAttributes(Patient patient){
        request.getSession().setAttribute("operation_date",patient.getOperations().getDate());
        request.getSession().setAttribute("op_surgeon",patient.getOperations().getOpSurgeon());
        request.getSession().setAttribute("operation",patient.getOperations().getOperation());
        request.getSession().setAttribute("operation_code_number",patient.getOperations().getCodeNumber());
    }

    private void setOtherInformationAttributes(Patient patient){
        request.getSession().setAttribute("other_town",patient.getOtherInformation().getTown());
        request.getSession().setAttribute("higher_level",patient.getOtherInformation().getEducationalLevel());
    }

    private void setPersonalDetailsAttributes(Patient patient){
        request.getSession().setAttribute("surname",patient.getPersonalDetails().getSurname());
        request.getSession().setAttribute("first_name",patient.getPersonalDetails().getFirstName());
        request.getSession().setAttribute("other_name",patient.getPersonalDetails().getOtherName());
        request.getSession().setAttribute("phone_number",patient.getPersonalDetails().getPhoneNumber());
        request.getSession().setAttribute("home_address",patient.getPersonalDetails().getHomeAddress());
        request.getSession().setAttribute("town",patient.getPersonalDetails().getTown());
        request.getSession().setAttribute("country",patient.getPersonalDetails().getNationality());
        request.getSession().setAttribute("lga",patient.getPersonalDetails().getLGA());
        request.getSession().setAttribute("date_of_reg",patient.getPersonalDetails().getDateOfRegistration());
        request.getSession().setAttribute("id_card_number",patient.getPersonalDetails().getNationalIDCardNumber());
        request.getSession().setAttribute("state",patient.getPersonalDetails().getStateOfOrigin());
    }
}
