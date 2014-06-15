/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Register;

import Register.data.Diagnosis;
import Register.data.Hospital_History;
import Register.data.NHIS_Information;
import Register.data.Next_Of_Kin;
import Register.data.Operations;
import Register.data.Other_Information;
import Register.data.Personal_Details;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author AZEEZ TAIWO
 */
public class ModifyAction {

    private Connection con;
    private Statement st;
    ResultSet rs;
    /**
     * 
     */
    public static int id;
    Personal_Details personalDetails = new Personal_Details();

    Next_Of_Kin nextOfKin = new Next_Of_Kin();

    Diagnosis diagnosis = new Diagnosis();
    Hospital_History hospitalHistory = new Hospital_History();
    Operations operations = new Operations();
    Other_Information otherInformation = new Other_Information();
    NHIS_Information nhisInfo = new NHIS_Information();
    private String patientID; //patient identity card Number

    private String g(String param) throws SQLException {
        return rs.getString(param);
    }

    /**
     * 
     * @param patientID
     * @throws SQLException
     */
    public ModifyAction(String patientID) throws SQLException {
        this.patientID = patientID;
        fillPatientDetails();
    }

    private void fillPatientDetails() throws SQLException {
        loadDriver();
        rs = st.executeQuery("SELECT id FROM personal_details WHERE id_card_number = " + patientID);
        rs.next();
        id = rs.getInt(1);
        System.out.println("id here is " + id);
        System.out.println("tgfxdfucf");

        rs = st.executeQuery("SELECT * FROM personal_details WHERE id = '" + id + "'");
        rs.next();
        rs.getString("date_of_reg");
        System.out.println("date of reg is " + rs.getString("date_of_reg"));

        personalDetails.setDateOfRegistration(rs.getString("date_of_reg"));
        System.out.println("getting date of reg " + personalDetails.getDateOfRegistration());
        personalDetails.setFirstName(rs.getString("first_name"));
        personalDetails.setHomeAddress(rs.getString("home_address"));
        personalDetails.setLGA(rs.getString("lga"));
        personalDetails.setNationalIDCardNumber(rs.getString("id_card_number"));
        personalDetails.setNationality(rs.getString("country"));
        personalDetails.setOtherName(rs.getString("other_name"));
        personalDetails.setPhoneNumber(rs.getString("phone_number"));
        personalDetails.setStateOfOrigin(rs.getString("stateOfOrigin"));
        personalDetails.setSurname(rs.getString("surname"));
        personalDetails.setTown(rs.getString("town"));

        //Capture fields from the next of kin section
        rs = st.executeQuery("SELECT * FROM next_of_kin WHERE id = '" + id + "'");
        rs.next();
        nextOfKin.setFirstName(rs.getString("next_of_kin_first_name"));
        nextOfKin.setHomeAddress(rs.getString("nk_home_address"));
        nextOfKin.setLGA(rs.getString("nk_lga"));
        nextOfKin.setNationality(rs.getString("nk_lga"));
        nextOfKin.setOtherName(rs.getString("next_of_kin_other_name"));
        nextOfKin.setPhoneNumber(rs.getString("kin_number"));
        nextOfKin.setRelationshipToNextOfKin(rs.getString("relationship"));
        nextOfKin.setState(rs.getString("nk_state"));
        nextOfKin.setSurname(rs.getString("next_of_kin_surname"));
        nextOfKin.setTown(rs.getString("nk_town"));

        //capture fields from the diagnosis section
        rs = st.executeQuery("SELECT * FROM diagnosis WHERE id = '" + id + "'");
        rs.next();
        diagnosis.setCodeNumber(rs.getString("code_number"));
        diagnosis.setDate(rs.getString("date_diagnosed"));
        diagnosis.setDateDischarged(rs.getString("date_discharge"));
        diagnosis.setDiagnosis(rs.getString("diagnosis"));

        //Capture fields from the hospital history section
        rs = st.executeQuery("SELECT * FROM hospital_history WHERE id = '" + id + "'");
        rs.next();
        hospitalHistory.setDateAdmitted(rs.getString("date_admitted"));
        hospitalHistory.setDateDischarged(rs.getString("date_discharge"));
        hospitalHistory.setDischargedTo(rs.getString("discharge_to"));
        hospitalHistory.setOutcomeOfCare(rs.getString("outcome"));
        hospitalHistory.setReferredBy(rs.getString("refby_physician"));
        hospitalHistory.setReferredTo(rs.getString("refto_physician"));

        //Capture fields from the operations section
        rs = st.executeQuery("SELECT * FROM operations WHERE id = '" + id + "'");
        rs.next();
        operations.setCodeNumber(rs.getString("operation_code_number"));
        operations.setDate(rs.getString("operation_date"));
        operations.setOpSurgeon(rs.getString("op_surgeon"));
        operations.setOperation(rs.getString("operation"));

        //Capture fields from the other information section
        rs = st.executeQuery("SELECT * FROM other_information WHERE id = '" + id + "'");
        rs.next();
        otherInformation.setEducationalLevel(rs.getString("Highest_Edu_level"));
        otherInformation.setTown(rs.getString("other_town"));

        //Capture fields from the NHIS information section
        rs = st.executeQuery("SELECT * FROM nhis_information WHERE id = '" + id + "'");
        rs.next();
        nhisInfo.setAllergies(rs.getString("allergies"));
        nhisInfo.setBloodGroup(rs.getString("blood_group"));
        nhisInfo.setEmployer(rs.getString("employer"));
        nhisInfo.setEmployerAddress(rs.getString("employers_address"));
        nhisInfo.setGenotype(rs.getString("genotype"));
        nhisInfo.setHMO(rs.getString("hmo"));
        nhisInfo.setHmoCode(rs.getString("hmo_code"));
        nhisInfo.setHmosIDNumber(rs.getString("hmos_id"));
        nhisInfo.setNHISNumber(rs.getString("nhis_number"));
        System.out.println("fields from dB successfully pushed to their different classes");
    }

    /**
     * 
     * @return
     */
    public Personal_Details getPersonalDetails() {
        return personalDetails;
    }

    /**
     * 
     * @return
     */
    public Next_Of_Kin getNextOfKin() {
        return nextOfKin;
    }

    /**
     * 
     * @return
     */
    public Diagnosis getDiagnosis() {
        return diagnosis;
    }

    /**
     * 
     * @return
     */
    public Hospital_History getHospitalHistory() {
        return hospitalHistory;
    }

    /**
     * 
     * @return
     */
    public Operations getOperations() {
        return operations;
    }

    /**
     * 
     * @return
     */
    public Other_Information getOtherInformation() {
        return otherInformation;
    }

    /**
     * 
     * @return
     */
    public NHIS_Information getNhisInfo() {
        return nhisInfo;
    }
    
    
    void loadDriver() {
        try {
            String url = "jdbc:mysql://localhost:3306/healthrecord";
            con = DriverManager.getConnection(url, "root", "");
            con.setAutoCommit(false);
            st = con.createStatement();

        } catch (SQLException ex) {
            System.out.println("Exception is " + ex);
        }
    }
}
