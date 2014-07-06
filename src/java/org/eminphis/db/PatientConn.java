package org.eminphis.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.eminphis.ErrorLogger;
import org.eminphis.dto.Patient;
import org.eminphis.dto.patient.NextOfKin;
import org.eminphis.dto.patient.NhisInformation;
import org.eminphis.dto.patient.PersonalDetails;
import org.eminphis.dto.tableview.Matches;
import org.eminphis.dto.tableview.SearchPatientMatch;
import org.eminphis.exceptions.NoSuchHospitalNumberException;
import org.eminphis.exceptions.NoSuchNHISNumberException;

/**
 * <u>e-MINPHIS</u><br>
 * A project of the Health Information Systems Unit of the<br>
 * Department of Computer Science and Engineering,<br>
 * Obafemi Awolowo University, Ile-Ife.<br>
 *
 *
 * <pre>
 * Class name: PatientConn.java
 * Version: 1.0
 * Author: Essiennta Emmanuel (colourfulemmanuel@gmail.com)
 *
 * <u>Description</u>
 * The {@code PatientConn} class represents connections to all tables that hold patient information.
 *
 * </pre>
 *
 * @author Essiennta Emmanuel (colourfulemmanuel@gmail.com)
 * @version 1.0
 */
class PatientConn{

    private static PatientConn instance;

    private PatientConn(){
    }

    static PatientConn getInstance(){
        if(instance==null)
            instance=new PatientConn();
        return instance;
    }

    void deletePatient(long hospitalNumber) throws SQLException{
        try{//The operations in this try block should be atomic. They all succeed or all fail.
            {
                int deleteIndex=Conn.getInstance().ensureInit(Statement.DELETE,
                        "DELETE FROM Personal_Details_ WHERE hospital_number_=?");
                SqlStatement deleteStatement=Conn.getInstance().getStatement(Statement.DELETE,deleteIndex);
                deleteStatement.setLong(1,hospitalNumber);
                deleteStatement.executeUpdate();
            }
            {
                int deleteIndex=Conn.getInstance().ensureInit(Statement.DELETE,
                        "DELETE FROM Nhis_Information_ WHERE hospital_number_=?");
                SqlStatement deleteStatement=Conn.getInstance().getStatement(Statement.DELETE,deleteIndex);
                deleteStatement.setLong(1,hospitalNumber);
                deleteStatement.executeUpdate();
            }
            {
                int deleteIndex=Conn.getInstance().ensureInit(Statement.DELETE,
                        "DELETE FROM Next_Of_Kin_ WHERE hospital_number_=?");
                SqlStatement deleteStatement=Conn.getInstance().getStatement(Statement.DELETE,deleteIndex);
                deleteStatement.setLong(1,hospitalNumber);
                deleteStatement.executeUpdate();
            }
            DBManager.saveChanges();
        } catch(SQLException sqle){
            try{
                DBManager.undoChanges();
            } catch(SQLException sqle1){
                ErrorLogger.logError(sqle1);
            }
            throw sqle;
        }
    }

    void insertPatient(Patient patient) throws SQLException{
        try{//The operations in this try block should be atomic. They all succeed or all fail.
            {
                int insertIndex=Conn.getInstance().ensureInit(Statement.INSERT,
                        "INSERT INTO Personal_Details_ (surname_,first_name_,other_name_,sex_,marital_status_,maiden_name_,phone_numbers_,residential_address_,town_,nationality_,state_,lga_,date_of_registration_,national_id_card_number_,highest_level_of_education_) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
                        true);

                PersonalDetails personalDetails=patient.getPersonalDetails();
                SqlStatement insertStatement=Conn.getInstance().getStatement(Statement.INSERT,insertIndex);
                insertStatement.setString(1,personalDetails.getSurname());
                insertStatement.setString(2,personalDetails.getFirstName());
                insertStatement.setString(3,personalDetails.getOtherName());
                insertStatement.setString(4,personalDetails.getSex());
                insertStatement.setString(5,personalDetails.getMaritalStatus());
                insertStatement.setString(6,personalDetails.getMaidenName());
                insertStatement.setString(7,personalDetails.getPhoneNumbers());
                insertStatement.setString(8,personalDetails.getResidentialAddress());
                insertStatement.setString(9,personalDetails.getTown());
                insertStatement.setString(10,personalDetails.getNationality());
                insertStatement.setString(11,personalDetails.getState());
                insertStatement.setString(12,personalDetails.getLga());
                insertStatement.setString(13,personalDetails.getDateOfRegistration());
                insertStatement.setString(14,personalDetails.getNationalIdCardNumber());
                insertStatement.setString(15,personalDetails.getHighestLevelOfEducation());
                insertStatement.executeUpdate();
                ResultSet rs=insertStatement.getGeneratedKeys();
                rs.next();
                long hospitalNumber=rs.getLong(1);
                rs.close();
                patient.setHospitalNumber(hospitalNumber);
            }
            {
                int insertIndex=Conn.getInstance().ensureInit(Statement.INSERT,
                        "INSERT INTO Nhis_Information_ (hospital_number_,nhis_number_,hmo_,hmo_code_,genotype_,blood_group_,hmo_id_,employer_,address_of_employer_,allergies_) VALUES (?,?,?,?,?,?,?,?,?,?)");

                NhisInformation nhisInformation=patient.getNhisInformation();
                SqlStatement insertStatement=Conn.getInstance().getStatement(Statement.INSERT,insertIndex);
                insertStatement.setLong(1,patient.getHospitalNumber());
                insertStatement.setLong(2,nhisInformation.getNhisNumber());
                insertStatement.setString(3,nhisInformation.getHmo());
                insertStatement.setString(4,nhisInformation.getHmoCode());
                insertStatement.setString(5,nhisInformation.getGenotype());
                insertStatement.setString(6,nhisInformation.getBloodGroup());
                insertStatement.setString(7,nhisInformation.getHmoId());
                insertStatement.setString(8,nhisInformation.getEmployer());
                insertStatement.setString(9,nhisInformation.getAddressOfEmployer());
                insertStatement.setString(10,nhisInformation.getAllergies());
                insertStatement.executeUpdate();
            }
            {
                int insertIndex=Conn.getInstance().ensureInit(Statement.INSERT,
                        "INSERT INTO Next_Of_Kin_ (hospital_number_,surname_,first_name_,other_name_,town_,nationality_,state_,lga_,relationship_to_next_of_kin_,phone_number_) VALUES (?,?,?,?,?,?,?,?,?,?)");

                NextOfKin nextOfKin=patient.getNextOfKin();
                SqlStatement insertStatement=Conn.getInstance().getStatement(Statement.INSERT,insertIndex);
                insertStatement.setLong(1,patient.getHospitalNumber());
                insertStatement.setString(2,nextOfKin.getSurname());
                insertStatement.setString(3,nextOfKin.getFirstName());
                insertStatement.setString(4,nextOfKin.getOtherName());
                insertStatement.setString(5,nextOfKin.getTown());
                insertStatement.setString(6,nextOfKin.getNationality());
                insertStatement.setString(7,nextOfKin.getState());
                insertStatement.setString(8,nextOfKin.getLga());
                insertStatement.setString(9,nextOfKin.getRelationshipToNextOfKin());
                insertStatement.setString(10,nextOfKin.getPhoneNumber());
                insertStatement.executeUpdate();
            }
            DBManager.saveChanges();
        } catch(SQLException sqle){
            try{
                DBManager.undoChanges();
            } catch(SQLException sqle1){
                ErrorLogger.logError(sqle1);
            }
            throw sqle;
        }
    }

    Patient retrievePatientByHospitalNumber(long hospitalNumber) throws SQLException,NoSuchHospitalNumberException{
        PersonalDetails personalDetails;
        NextOfKin nextOfKin;
        NhisInformation nhisInformation;
        {
            int retrieveIndex=Conn.getInstance().ensureInit(Statement.RETRIEVE,
                    "SELECT surname_,first_name_,other_name_,sex_,marital_status_,maiden_name_,phone_numbers_,residential_address_,town_,nationality_,state_,lga_,date_of_registration_,national_id_card_number_,highest_level_of_education_ FROM Personal_Details_ WHERE hospital_number_=?");

            SqlStatement retrieveStatement=Conn.getInstance().getStatement(Statement.RETRIEVE,retrieveIndex);
            retrieveStatement.setLong(1,hospitalNumber);
            ResultSet rs=retrieveStatement.executeQuery();
            if(!rs.next())
                throw new NoSuchHospitalNumberException(hospitalNumber);
            String surname=rs.getString(1);
            String firstName=rs.getString(2);
            String otherName=rs.getString(3);
            String sex=rs.getString(4);
            String maritalStatus=rs.getString(5);
            String maidenName=rs.getString(6);
            String phoneNumbers=rs.getString(7);
            String residentialAddress=rs.getString(8);
            String town=rs.getString(9);
            String nationality=rs.getString(10);
            String state=rs.getString(11);
            String lga=rs.getString(12);
            String dateOfRegistration=rs.getString(13);
            String nationalIdCardNumber=rs.getString(14);
            String highestLevelOfEducation=rs.getString(15);
            rs.close();
            personalDetails=new PersonalDetails(surname,firstName,otherName,sex,maritalStatus,
                    maidenName,
                    phoneNumbers,residentialAddress,town,nationality,state,lga,dateOfRegistration,
                    nationalIdCardNumber,
                    highestLevelOfEducation);
        }
        {
            int retrieveIndex=Conn.getInstance().ensureInit(Statement.RETRIEVE,
                    "SELECT surname_,first_name_,other_name_,town_,nationality_,state_,lga_,relationship_to_next_of_kin_,phone_number_ FROM Next_Of_Kin_ WHERE hospital_number_=?");

            SqlStatement retrieveStatement=Conn.getInstance().getStatement(Statement.RETRIEVE,retrieveIndex);
            retrieveStatement.setLong(1,hospitalNumber);
            ResultSet rs=retrieveStatement.executeQuery();
            String surname=rs.getString(1);
            String firstName=rs.getString(2);
            String otherName=rs.getString(3);
            String town=rs.getString(4);
            String nationality=rs.getString(5);
            String state=rs.getString(6);
            String lga=rs.getString(7);
            String relationshipToNextOfKin=rs.getString(8);
            String phoneNumber=rs.getString(9);
            rs.close();
            nextOfKin=new NextOfKin(surname,firstName,otherName,town,nationality,state,lga,
                    relationshipToNextOfKin,phoneNumber);
        }
        {
            int retrieveIndex=Conn.getInstance().ensureInit(Statement.RETRIEVE,
                    "SELECT nhis_number_,hmo_,hmo_code_,genotype_,blood_group_,hmo_id_,employer_,address_of_employer_,allergies_ FROM Nhis_Information_ WHERE hospital_number_=?");

            SqlStatement retrieveStatement=Conn.getInstance().getStatement(Statement.RETRIEVE,retrieveIndex);
            retrieveStatement.setLong(1,hospitalNumber);
            ResultSet rs=retrieveStatement.executeQuery();
            long nhisNumber=rs.getLong(1);
            String hmo=rs.getString(2);
            String hmoCode=rs.getString(3);
            String genotype=rs.getString(4);
            String bloodGroup=rs.getString(5);
            String hmoId=rs.getString(6);
            String employer=rs.getString(7);
            String addressOfEmployer=rs.getString(8);
            String allergies=rs.getString(9);
            rs.close();
            nhisInformation=new NhisInformation(nhisNumber,hmo,hmoCode,genotype,bloodGroup,hmoId,
                    employer,addressOfEmployer,allergies);
        }

        Patient patient=new Patient(nextOfKin,nhisInformation,personalDetails);
        patient.setHospitalNumber(hospitalNumber);
        return patient;
    }

    void updatePatient(Patient patient) throws SQLException{
        try{//The operations in this try block should be atomic. They all succeed or all fail.
            {
                int updateIndex=Conn.getInstance().ensureInit(Statement.UPDATE,
                        "UPDATE Personal_Details_ SET surname_=?,first_name_=?,other_name_=?,sex_=?,marital_status_=?,maiden_name_=?,phone_numbers_=?,residential_address_=?,town_=?,nationality_=?,state_=?,lga_=?,date_of_registration_=?,national_id_card_number_=?,highest_level_of_education_=? WHERE hospital_number_=?");

                PersonalDetails personalDetails=patient.getPersonalDetails();
                SqlStatement updateStatement=Conn.getInstance().getStatement(Statement.UPDATE,updateIndex);
                updateStatement.setString(1,personalDetails.getSurname());
                updateStatement.setString(2,personalDetails.getFirstName());
                updateStatement.setString(3,personalDetails.getOtherName());
                updateStatement.setString(4,personalDetails.getSex());
                updateStatement.setString(5,personalDetails.getMaritalStatus());
                updateStatement.setString(6,personalDetails.getMaidenName());
                updateStatement.setString(7,personalDetails.getPhoneNumbers());
                updateStatement.setString(8,personalDetails.getResidentialAddress());
                updateStatement.setString(9,personalDetails.getTown());
                updateStatement.setString(10,personalDetails.getNationality());
                updateStatement.setString(11,personalDetails.getState());
                updateStatement.setString(12,personalDetails.getLga());
                updateStatement.setString(13,personalDetails.getDateOfRegistration());
                updateStatement.setString(14,personalDetails.getNationalIdCardNumber());
                updateStatement.setString(15,personalDetails.getHighestLevelOfEducation());
                updateStatement.executeUpdate();
            }
            {
                int updateIndex=Conn.getInstance().ensureInit(Statement.UPDATE,
                        "UPDATE Next_Of_Kin_ SET surname_=?,first_name_=?,other_name_=?,town_=?,nationality_=?,state_=?,lga_=?,relationship_to_next_of_kin_=?,phone_number_=? WHERE hospital_number_=?");

                NextOfKin nextOfKin=patient.getNextOfKin();
                SqlStatement updateStatement=Conn.getInstance().getStatement(Statement.UPDATE,updateIndex);
                updateStatement.setString(1,nextOfKin.getSurname());
                updateStatement.setString(2,nextOfKin.getFirstName());
                updateStatement.setString(3,nextOfKin.getOtherName());
                updateStatement.setString(4,nextOfKin.getTown());
                updateStatement.setString(5,nextOfKin.getNationality());
                updateStatement.setString(6,nextOfKin.getState());
                updateStatement.setString(7,nextOfKin.getLga());
                updateStatement.setString(8,nextOfKin.getRelationshipToNextOfKin());
                updateStatement.setString(9,nextOfKin.getPhoneNumber());
                updateStatement.executeUpdate();
            }
            {
                int updateIndex=Conn.getInstance().ensureInit(Statement.UPDATE,
                        "UPDATE Nhis_Information_ SET nhis_number_=?,hmo_=?,hmo_code_=?,genotype_=?,blood_group_=?,hmo_id_=?,employer_=?,address_of_employer_=?,allergies_=? WHERE hospital_number_=?");

                NhisInformation nhisInformation=patient.getNhisInformation();
                SqlStatement updateStatement=Conn.getInstance().getStatement(Statement.UPDATE,updateIndex);
                updateStatement.setLong(1,nhisInformation.getNhisNumber());
                updateStatement.setString(2,nhisInformation.getHmo());
                updateStatement.setString(3,nhisInformation.getHmoCode());
                updateStatement.setString(4,nhisInformation.getGenotype());
                updateStatement.setString(5,nhisInformation.getBloodGroup());
                updateStatement.setString(6,nhisInformation.getHmoId());
                updateStatement.setString(7,nhisInformation.getEmployer());
                updateStatement.setString(8,nhisInformation.getAddressOfEmployer());
                updateStatement.setString(9,nhisInformation.getAllergies());
                updateStatement.executeUpdate();
            }
            DBManager.saveChanges();
        } catch(SQLException sqle){
            try{
                DBManager.undoChanges();
            } catch(SQLException sqle2){
                ErrorLogger.logError(sqle2);
            }
            throw sqle;
        }
    }

    Patient retrievePatientByNhisNumber(long nhisNumber) throws SQLException,NoSuchNHISNumberException,
            NoSuchHospitalNumberException{
        int retrieveIndex=Conn.getInstance().ensureInit(Statement.RETRIEVE,
                "SELECT hospital_number_ FROM Personal_Details_ WHERE nhis_number_=?");

        SqlStatement retrieveStatement=Conn.getInstance().getStatement(Statement.RETRIEVE,retrieveIndex);
        retrieveStatement.setLong(1,nhisNumber);
        ResultSet rs=retrieveStatement.executeQuery();
        if(!rs.next())
            throw new NoSuchNHISNumberException(nhisNumber);
        long hospitalNumber=rs.getLong(1);
        rs.close();
        return retrievePatientByHospitalNumber(hospitalNumber);
    }

    Matches<SearchPatientMatch> retrieveSearchPatientMatchesByName(String prefixOfSurname) throws SQLException{
        int retrieveIndex=Conn.getInstance().ensureInit(Statement.RETRIEVE,
                "SELECT hospital_number_,nhis_number_,surname_,first_name_,other_name_ FROM Search_Patient_Match_ WHERE surname_ like ?");

        SqlStatement retrieveStatement=Conn.getInstance().getStatement(Statement.RETRIEVE,retrieveIndex);
        retrieveStatement.setString(1,prefixOfSurname);
        ResultSet rs=retrieveStatement.executeQuery();
        Matches<SearchPatientMatch> matches=new Matches<SearchPatientMatch>();
        while(rs.next()){
            long hospitalNumber=rs.getLong(1);
            long nhisNumber=rs.getLong(2);
            String surname=rs.getString(3);
            String firstName=rs.getString(4);
            String otherName=rs.getString(5);
            matches.addMatchedResult(new SearchPatientMatch(hospitalNumber,nhisNumber,surname,firstName,otherName));
        }
        rs.close();
        return matches;
    }

    Matches<SearchPatientMatch> retrieveSearchPatientMatchesByNumber(String prefixOfNumber) throws SQLException{
        int retrieveIndex=Conn.getInstance().ensureInit(Statement.RETRIEVE,
                "SELECT DISTINCT hospital_number_,nhis_number_,surname_,first_name_,other_name_ FROM Search_Patient_Match_ "
                +"WHERE nhis_number_ like ? OR hospital_number_ like ?");

        SqlStatement retrieveStatement=Conn.getInstance().getStatement(Statement.RETRIEVE,retrieveIndex);
        retrieveStatement.setString(1,prefixOfNumber);
        retrieveStatement.setString(2,prefixOfNumber);
        ResultSet rs=retrieveStatement.executeQuery();
        Matches<SearchPatientMatch> matches=new Matches<SearchPatientMatch>();
        while(rs.next()){
            long hospitalNumber=rs.getLong(1);
            long nhisNumber=rs.getLong(2);
            String surname=rs.getString(3);
            String firstName=rs.getString(4);
            String otherName=rs.getString(5);
            matches.addMatchedResult(new SearchPatientMatch(hospitalNumber,nhisNumber,surname,firstName,otherName));
        }
        rs.close();
        return matches;
    }
}
