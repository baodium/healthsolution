package Register;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author AZEEZ TAIWO
 */
import Register.data.Diagnosis;
import Register.data.Hospital_History;
import Register.data.NHIS_Information;
import Register.data.Next_Of_Kin;
import Register.data.Operations;
import Register.data.Other_Information;
import Register.data.Personal_Details;
import java.sql.*;
import java.util.Vector;

/**
 * 
 * @author Essiennta Emmanuel <colourfulemmanuel@gmail.com>
 */
public class DbConnect {

    Connection con = null;
    Statement st;
    PreparedStatement ps;
    ResultSet rs;
    Vector<String> data = new Vector<String>();
    /**
     * 
     */
    public static String[] rowData;

    /**
     * 
     */
    public DbConnect() {
        loadDriver();
    }

    /**
     * 
     * @param personalDetails
     * @param nextOfKin
     * @param hospitalHistory
     * @param diagnosis
     * @param operations
     * @param otherInformation
     * @param nhisInfo
     * @throws SQLException
     */
    public void addData_patient(Personal_Details personalDetails, Next_Of_Kin nextOfKin,
            Hospital_History hospitalHistory, Diagnosis diagnosis, Operations operations,
            Other_Information otherInformation, NHIS_Information nhisInfo) throws SQLException {
        System.out.println("addPatient was called");
        final String query = "INSERT INTO " + diagnosis.getClass().getSimpleName() + " (date_diagnosed,date_discharge,"
                + "diagnosis, code_number) VALUES ('"
                + diagnosis.getDate() + "', '"
                + diagnosis.getDateDischarged() + "', '"
                + diagnosis.getDiagnosis() + "', '"
                + diagnosis.getCodeNumber() + "')";
        System.out.println("Query: " + query);
        System.out.println("Class Name is "+ diagnosis.getClass());
        st.execute(query);

        st.execute("INSERT INTO " + personalDetails.getClass().getSimpleName() + "(surname, first_name, other_name,"
                + "phone_number, home_address, town, country, stateOfOrigin, lga, date_of_reg, id_card_number) VALUES ('"
                + personalDetails.getSurname() + "', '"
                + personalDetails.getFirstName() + "', '"
                + personalDetails.getOtherName() + "', '"
                + personalDetails.getPhoneNumber() + "', '"
                + personalDetails.getHomeAddress() + "', '"
                + personalDetails.getTown() + "', '"
                + personalDetails.getNationality() + "', '"
                + personalDetails.getStateOfOrigin() + "', '"
                + personalDetails.getLGA() + "', '"
                + personalDetails.getDateOfRegistration() + "', '"
                + personalDetails.getNationalIDCardNumber() + "')");

        st.execute("INSERT INTO " + nextOfKin.getClass().getSimpleName() + "( next_of_kin_surname, next_of_kin_first_name,"
                + "next_of_kin_other_name, nk_home_address, nk_town, nk_country, nk_state, "
                + "nk_lga, relationship, kin_number) VALUES ('"
                + nextOfKin.getSurname() + "', '"
                + nextOfKin.getFirstName() + "', '"
                + nextOfKin.getOtherName() + "', '"
                + nextOfKin.getHomeAddress() + "', '"
                + nextOfKin.getTown() + "', '"
                + nextOfKin.getNationality() + "', '"
                + nextOfKin.getState() + "', '"
                + nextOfKin.getLGA() + "', '"
                + nextOfKin.getRelationshipToNextOfKin() + "', '"
                + nextOfKin.getPhoneNumber() + "')");

        st.execute("INSERT INTO " + hospitalHistory.getClass().getSimpleName() + "(date_admitted, refby_physician,"
                + "date_discharge, refto_physician, discharge_to, outcome) VALUES ('"
                + hospitalHistory.getDateAdmitted() + "', '"
                + hospitalHistory.getReferredBy() + "', '"
                + hospitalHistory.getDateDischarged() + "', '"
                + hospitalHistory.getReferredTo() + "', '"
                + hospitalHistory.getDischargedTo() + "', '"
                + hospitalHistory.getOutcomeOfCare() + "')");

        st.execute("INSERT INTO " + operations.getClass().getSimpleName() + "(operation_date, op_surgeon,"
                + "operation, operation_code_number) VALUES ('"
                + operations.getDate() + "', '"
                + operations.getOpSurgeon() + "', '"
                + operations.getOperation() + "', '"
                + operations.getCodeNumber() + "')");

        st.execute("INSERT INTO " + otherInformation.getClass().getSimpleName() + "( other_town, highest_edu_level)VALUES ('"
                + otherInformation.getTown() + "', '"
                + otherInformation.getEducationalLevel() + "')");

        st.execute("INSERT INTO " + nhisInfo.getClass().getSimpleName() + "(nhis_number, hmo, genotype, blood_group,"
                + "hmo_code, hmos_id, employer, employers_address, allergies) VALUES ('"
                + nhisInfo.getNHISNumber() + "', '"
                + nhisInfo.getHMO() + "', '"
                + nhisInfo.getGenotype() + "', '"
                + nhisInfo.getBloodGroup() + "', '"
                + nhisInfo.getHmoCode() + "', '"
                + nhisInfo.getHmosIDNumber() + "', '"
                + nhisInfo.getEmployer() + "', '"
                + nhisInfo.getEmployerAddress() + "', '"
                + nhisInfo.getAllergies() + "')");
        System.out.println("data Added");
    }

    void closeDB() {
        try {
            con.commit();
            System.out.println("data committed");
            st.close();
            ps.close();
//            rs.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println("Exception is " + ex);
        }
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
