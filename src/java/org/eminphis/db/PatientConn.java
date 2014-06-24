package org.eminphis.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.eminphis.Printer;
import static org.eminphis.db.DBManager.TABLE_COUNT;
import static org.eminphis.db.DBManager.getDBConnection;
import org.eminphis.dto.Patient;
import org.eminphis.dto.tableview.PersonalDetailsView;
import org.eminphis.entities.*;
import org.eminphis.exceptions.NoSuchColumnException;
import org.eminphis.exceptions.NoSuchPatientIDException;
import org.eminphis.exceptions.NoSuchPatientNHISNumberException;

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
public class PatientConn{

    private static PatientConn instance;
    private static PreparedStatement[] deleteFrom;//holds prepared statements for each of the table
    private static PreparedStatement[] insertInto;//holds prepared statements for each of the table
    private static PreparedStatement[] selectFrom$ID;//holds prepared statements for each of the table
    private static PreparedStatement selectFrom$NHIS;//holds prepared statements for each of the table
    private static PreparedStatement[] update;//holds prepared statements for each of the table
    private static PreparedStatement selectFromPersonalDetailsView;

    public static PatientConn getInstance(){
        if(instance==null)//lazy initialization
            instance=new PatientConn();
        return instance;
    }

    private PatientConn(){
    }

    void closeAllPatientResourcesAndNullifyInstance() throws SQLException{

        java.sql.SQLException firstException=null;
        for(int i=TABLE_COUNT-1;i>=0;i--){

            try{
                if(deleteFrom!=null){
                    deleteFrom[i].close();//Close all delete statements to patient tables
                    deleteFrom[i]=null;
                }
            }catch(java.sql.SQLException sqle){
                if(firstException==null)
                    firstException=sqle;
            }

            try{
                if(insertInto!=null){
                    insertInto[i].close();//Close all insert statements to patient tables
                    insertInto[i]=null;
                }
            }catch(java.sql.SQLException sqle){
                if(firstException==null)
                    firstException=sqle;
            }

            try{
                if(selectFrom$ID!=null){
                    selectFrom$ID[i].close();//Close all select statements to patient tables
                    selectFrom$ID[i]=null;
                }
            }catch(java.sql.SQLException sqle){
                if(firstException==null)
                    firstException=sqle;
            }

            try{
                if(update!=null){
                    update[i].close();//Close all update statements to patient tables
                    update[i]=null;
                }
            }catch(java.sql.SQLException sqle){
                if(firstException==null)
                    firstException=sqle;
            }
        }
        if(selectFrom$NHIS!=null){
            selectFrom$NHIS.close();
            selectFrom$NHIS=null;
        }
        if(selectFromPersonalDetailsView!=null){
            selectFromPersonalDetailsView.close();
            selectFromPersonalDetailsView=null;
        }
        deleteFrom=null;
        insertInto=null;
        selectFrom$ID=null;
        update=null;
        instance=null;
        if(firstException!=null)//An exception occured
            throw firstException;
    }

    /**
     * Ensures that delete statements have been initialized for all the patient tables.
     *
     * @throws SQLException if an error occurs while initializing the delete statements
     */
    private void ensureDeleteStatements() throws SQLException{
        if(deleteFrom!=null)
            return;

        /*
         * Initialize deletes for all the tables
         */
        deleteFrom=new PreparedStatement[TABLE_COUNT];

        deleteFrom[Diagnosis.getInstance().getIndex()]=getDBConnection().prepareStatement("DELETE FROM "
                +Diagnosis.getInstance().getName()+" WHERE ID=?");
        deleteFrom[HospitalHistory.getInstance().getIndex()]=getDBConnection().prepareStatement("DELETE FROM "
                +HospitalHistory.getInstance().getName()+" WHERE ID=?");
        deleteFrom[NHISInformation.getInstance().getIndex()]=getDBConnection().prepareStatement("DELETE FROM "
                +NHISInformation.getInstance().getName()+" WHERE ID=?");
        deleteFrom[NextOfKin.getInstance().getIndex()]=getDBConnection().prepareStatement("DELETE FROM "
                +NextOfKin.getInstance().getName()+" WHERE ID=?");
        deleteFrom[Operations.getInstance().getIndex()]=getDBConnection().prepareStatement("DELETE FROM "
                +Operations.getInstance().getName()+" WHERE ID=?");
        deleteFrom[OtherInformation.getInstance().getIndex()]=getDBConnection().prepareStatement("DELETE FROM "
                +OtherInformation.getInstance().getName()+" WHERE ID=?");
        deleteFrom[PersonalDetails.getInstance().getIndex()]=getDBConnection().prepareStatement("DELETE FROM "
                +PersonalDetails.getInstance().getName()+" WHERE ID=?");
    }

    /**
     * Ensures that insert statements have been initialized for all the patient tables.
     *
     * @throws SQLException if an error occurs while initializing the insert statements
     * @throws NoSuchColumnException if a table entity reports that is has a column number that
     * actually doesn't exist in the table
     */
    private void ensureInsertStatements() throws SQLException,NoSuchColumnException{
        if(insertInto!=null)
            return;

        /*
         * Initialize inserts for all the tables
         */
        insertInto=new PreparedStatement[TABLE_COUNT];
        StringBuilder sb=new StringBuilder(512);
        StringBuilder placeHolders=new StringBuilder(512);

        int startIndex=2;//Starting at column 2 effectively skips the ID column.

        //generate the sequence of column names and placeholders for the PersonalDetails table
        //the PersonalDetails table is where the IDs are generated
        sb.append('(');
        placeHolders.append('(');
        for(int i=startIndex;i<=PersonalDetails.getInstance().getColumnCount();i++){
            if(i!=startIndex){
                sb.append(',');
                placeHolders.append(',');
            }
            sb.append(PersonalDetails.getInstance().getColumnName(i));
            placeHolders.append('?');
        }
        sb.append(')');
        placeHolders.append(')');
        insertInto[PersonalDetails.getInstance().getIndex()]=getDBConnection().prepareStatement("INSERT INTO "
                +PersonalDetails.getInstance().getName()+sb.toString()+"VALUES"+placeHolders.
                toString(),Statement.RETURN_GENERATED_KEYS);
        sb.delete(0,sb.length());
        placeHolders.delete(0,placeHolders.length());


        //From henceforth, the ID generated from the PersonalDetails table is used as primary key
        //into the other tables.
        startIndex=1;//Since the ID column is to be captured in succeeding insert statements.


        //generate the sequence of column names and placeholders for the Diagnosis table
        sb.append('(');
        placeHolders.append('(');
        for(int i=startIndex;i<=Diagnosis.getInstance().getColumnCount();i++){
            if(i!=startIndex){
                sb.append(',');
                placeHolders.append(',');
            }
            sb.append(Diagnosis.getInstance().getColumnName(i));
            placeHolders.append('?');
        }
        sb.append(')');
        placeHolders.append(')');
        insertInto[Diagnosis.getInstance().getIndex()]=getDBConnection().prepareStatement("INSERT INTO "
                +Diagnosis.getInstance().getName()+sb.toString()+"VALUES"+placeHolders.toString());
        sb.delete(0,sb.length());
        placeHolders.delete(0,placeHolders.length());

        //generate the sequence of column names and placeholders for the Diagnosis table
        sb.append('(');
        placeHolders.append('(');
        for(int i=startIndex;i<=HospitalHistory.getInstance().getColumnCount();i++){
            if(i!=startIndex){
                sb.append(',');
                placeHolders.append(',');
            }
            sb.append(HospitalHistory.getInstance().getColumnName(i));
            placeHolders.append('?');
        }
        sb.append(')');
        placeHolders.append(')');
        insertInto[HospitalHistory.getInstance().getIndex()]=getDBConnection().prepareStatement("INSERT INTO "
                +HospitalHistory.getInstance().getName()+sb.toString()+"VALUES"+placeHolders.
                toString());
        sb.delete(0,sb.length());
        placeHolders.delete(0,placeHolders.length());

        //generate the sequence of column names and placeholders for the Diagnosis table
        sb.append('(');
        placeHolders.append('(');
        for(int i=startIndex;i<=NHISInformation.getInstance().getColumnCount();i++){
            if(i!=startIndex){
                sb.append(',');
                placeHolders.append(',');
            }
            sb.append(NHISInformation.getInstance().getColumnName(i));
            placeHolders.append('?');
        }
        sb.append(')');
        placeHolders.append(')');
        insertInto[NHISInformation.getInstance().getIndex()]=getDBConnection().prepareStatement("INSERT INTO "
                +NHISInformation.getInstance().getName()+sb.toString()+"VALUES"+placeHolders.
                toString());
        sb.delete(0,sb.length());
        placeHolders.delete(0,placeHolders.length());

        //generate the sequence of column names and placeholders for the Diagnosis table
        sb.append('(');
        placeHolders.append('(');
        for(int i=startIndex;i<=NextOfKin.getInstance().getColumnCount();i++){
            if(i!=startIndex){
                sb.append(',');
                placeHolders.append(',');
            }
            sb.append(NextOfKin.getInstance().getColumnName(i));
            placeHolders.append('?');
        }
        sb.append(')');
        placeHolders.append(')');
        insertInto[NextOfKin.getInstance().getIndex()]=getDBConnection().prepareStatement("INSERT INTO "
                +NextOfKin.getInstance().getName()+sb.toString()+"VALUES"+placeHolders.toString());
        sb.delete(0,sb.length());
        placeHolders.delete(0,placeHolders.length());

        //generate the sequence of column names and placeholders for the Diagnosis table
        sb.append('(');
        placeHolders.append('(');
        for(int i=startIndex;i<=Operations.getInstance().getColumnCount();i++){
            if(i!=startIndex){
                sb.append(',');
                placeHolders.append(',');
            }
            sb.append(Operations.getInstance().getColumnName(i));
            placeHolders.append('?');
        }
        sb.append(')');
        placeHolders.append(')');
        insertInto[Operations.getInstance().getIndex()]=getDBConnection().prepareStatement("INSERT INTO "
                +Operations.getInstance().getName()+sb.toString()+"VALUES"+placeHolders.toString());
        sb.delete(0,sb.length());
        placeHolders.delete(0,placeHolders.length());

        //generate the sequence of column names and placeholders for the Diagnosis table
        sb.append('(');
        placeHolders.append('(');
        for(int i=startIndex;i<=OtherInformation.getInstance().getColumnCount();i++){
            if(i!=startIndex){
                sb.append(',');
                placeHolders.append(',');
            }
            sb.append(OtherInformation.getInstance().getColumnName(i));
            placeHolders.append('?');
        }
        sb.append(')');
        placeHolders.append(')');
        insertInto[OtherInformation.getInstance().getIndex()]=getDBConnection().prepareStatement("INSERT INTO "
                +OtherInformation.getInstance().getName()+sb.toString()+"VALUES"+placeHolders.
                toString());
        sb.delete(0,sb.length());
        placeHolders.delete(0,placeHolders.length());
    }

    /**
     * Ensures that select statements have been initialized for all the patient tables.
     *
     * @throws SQLException if an error occurs while initializing the select statements
     * @throws NoSuchColumnException if a table entity reports that is has a column number that
     * actually doesn't exist in the table
     */
    private void ensureIDSelectStatements() throws SQLException,NoSuchColumnException{
        if(selectFrom$ID!=null)
            return;

        /*
         * Initialize selects for all the tables
         */
        selectFrom$ID=new PreparedStatement[TABLE_COUNT];
        StringBuilder sb=new StringBuilder(512);
        final int startIndex=2;//Starting at column 2 effectively skips the ID column.

        //generate the sequence of column names for the Diagnosis table
        sb.append(' ');
        for(int i=startIndex;i<=Diagnosis.getInstance().getColumnCount();i++){
            if(i!=startIndex)
                sb.append(',');
            sb.append(Diagnosis.getInstance().getColumnName(i));
        }
        sb.append(' ');
        selectFrom$ID[Diagnosis.getInstance().getIndex()]=getDBConnection().prepareStatement("SELECT"
                +sb.toString()+"FROM "+Diagnosis.getInstance().getName()+" WHERE ID=?");
        sb.delete(0,sb.length());

        //generate the sequence of column names for the HospitalHistory table
        sb.append(' ');
        for(int i=startIndex;i<=HospitalHistory.getInstance().getColumnCount();i++){
            if(i!=startIndex)
                sb.append(',');
            sb.append(HospitalHistory.getInstance().getColumnName(i));
        }
        sb.append(' ');
        selectFrom$ID[HospitalHistory.getInstance().getIndex()]=getDBConnection().prepareStatement("SELECT"
                +sb.toString()+"FROM "+HospitalHistory.getInstance().getName()+" WHERE ID=?");
        sb.delete(0,sb.length());

        //generate the sequence of column names for the NHISInformation table
        sb.append(' ');
        for(int i=startIndex;i<=NHISInformation.getInstance().getColumnCount();i++){
            if(i!=startIndex)
                sb.append(',');
            sb.append(NHISInformation.getInstance().getColumnName(i));
        }
        sb.append(' ');
        selectFrom$ID[NHISInformation.getInstance().getIndex()]=getDBConnection().prepareStatement("SELECT"
                +sb.toString()+"FROM "+NHISInformation.getInstance().getName()+" WHERE ID=?");
        sb.delete(0,sb.length());

        //generate the sequence of column names for the NextOfKin table
        sb.append(' ');
        for(int i=startIndex;i<=NextOfKin.getInstance().getColumnCount();i++){
            if(i!=startIndex)
                sb.append(',');
            sb.append(NextOfKin.getInstance().getColumnName(i));
        }
        sb.append(' ');
        selectFrom$ID[NextOfKin.getInstance().getIndex()]=getDBConnection().prepareStatement("SELECT"
                +sb.toString()+"FROM "+NextOfKin.getInstance().getName()+" WHERE ID=?");
        sb.delete(0,sb.length());

        //generate the sequence of column names for the Operations table
        sb.append(' ');
        for(int i=startIndex;i<=Operations.getInstance().getColumnCount();i++){
            if(i!=startIndex)
                sb.append(',');
            sb.append(Operations.getInstance().getColumnName(i));
        }
        sb.append(' ');
        selectFrom$ID[Operations.getInstance().getIndex()]=getDBConnection().prepareStatement("SELECT"
                +sb.toString()+"FROM "+Operations.getInstance().getName()+" WHERE ID=?");
        sb.delete(0,sb.length());

        //generate the sequence of column names for the OtherInformation table
        sb.append(' ');
        for(int i=startIndex;i<=OtherInformation.getInstance().getColumnCount();i++){
            if(i!=startIndex)
                sb.append(',');
            sb.append(OtherInformation.getInstance().getColumnName(i));
        }
        sb.append(' ');
        selectFrom$ID[OtherInformation.getInstance().getIndex()]=getDBConnection().prepareStatement("SELECT"
                +sb.toString()+"FROM "+OtherInformation.getInstance().getName()+" WHERE ID=?");
        sb.delete(0,sb.length());

        //generate the sequence of column names for the PersonalDetails table
        sb.append(' ');
        for(int i=startIndex;i<=PersonalDetails.getInstance().getColumnCount();i++){
            if(i!=startIndex)
                sb.append(',');
            sb.append(PersonalDetails.getInstance().getColumnName(i));
        }
        sb.append(' ');
        selectFrom$ID[PersonalDetails.getInstance().getIndex()]=getDBConnection().prepareStatement("SELECT"
                +sb.toString()+"FROM "+PersonalDetails.getInstance().getName()+" WHERE ID=?");
        sb.delete(0,sb.length());
    }

    /**
     * Ensures that the select statement to retrieve ID from NHIS number has been
     * initialized.
     *
     * @throws SQLException if an error occurs while initializing the select statements
     */
    private void ensureNHISSelectStatement() throws SQLException{
        if(selectFrom$NHIS!=null)
            return;

        /*
         * Initialize the select statement
         */
        selectFrom$NHIS=DBManager.getDBConnection().prepareStatement(
                "SELECT ID FROM N_H_I_S_Information_ WHERE n_h_i_s_number_ = ?");
    }

    /**
     * Ensures that update statements have been initialized for all the patient tables.
     *
     * @throws SQLException if an error occurs while initializing the update statements
     * @throws NoSuchColumnException if a table entity reports that is has a column number that
     * actually doesn't exist in the table
     */
    private void ensureUpdateStatements() throws NoSuchColumnException,SQLException{
        if(update!=null)
            return;

        /*
         * Initialize selects for all the tables
         */
        update=new PreparedStatement[TABLE_COUNT];
        StringBuilder sb=new StringBuilder(512);
        final int startIndex=2;//Starting at column 2 effectively skips the ID column.


        //generate the sequence of column names for the Diagnosis table
        sb.append(' ');
        for(int i=startIndex;i<=Diagnosis.getInstance().getColumnCount();i++){
            if(i!=startIndex)
                sb.append(',');
            sb.append(Diagnosis.getInstance().getColumnName(i));
            sb.append("=?");
        }
        sb.append(' ');
        update[Diagnosis.getInstance().getIndex()]=getDBConnection().prepareStatement("UPDATE "
                +Diagnosis.getInstance().getName()+" SET"+sb.toString()+"WHERE ID=?");
        sb.delete(0,sb.length());

        //generate the sequence of column names for the HospitalHistory table
        sb.append(' ');
        for(int i=startIndex;i<=HospitalHistory.getInstance().getColumnCount();i++){
            if(i!=startIndex)
                sb.append(',');
            sb.append(HospitalHistory.getInstance().getColumnName(i));
            sb.append("=?");
        }
        sb.append(' ');
        update[HospitalHistory.getInstance().getIndex()]=getDBConnection().prepareStatement("UPDATE "
                +HospitalHistory.getInstance().getName()+" SET"+sb.toString()+"WHERE ID=?");
        sb.delete(0,sb.length());

        //generate the sequence of column names for the NHISInformation table
        sb.append(' ');
        for(int i=startIndex;i<=NHISInformation.getInstance().getColumnCount();i++){
            if(i!=startIndex)
                sb.append(',');
            sb.append(NHISInformation.getInstance().getColumnName(i));
            sb.append("=?");
        }
        sb.append(' ');
        update[NHISInformation.getInstance().getIndex()]=getDBConnection().prepareStatement("UPDATE "
                +NHISInformation.getInstance().getName()+" SET"+sb.toString()+"WHERE ID=?");
        sb.delete(0,sb.length());

        //generate the sequence of column names for the NextOfKin table
        sb.append(' ');
        for(int i=startIndex;i<=NextOfKin.getInstance().getColumnCount();i++){
            if(i!=startIndex)
                sb.append(',');
            sb.append(NextOfKin.getInstance().getColumnName(i));
            sb.append("=?");
        }
        sb.append(' ');
        update[NextOfKin.getInstance().getIndex()]=getDBConnection().prepareStatement("UPDATE "
                +NextOfKin.getInstance().getName()+" SET"+sb.toString()+"WHERE ID=?");
        sb.delete(0,sb.length());

        //generate the sequence of column names for the Operations table
        sb.append(' ');
        for(int i=startIndex;i<=Operations.getInstance().getColumnCount();i++){
            if(i!=startIndex)
                sb.append(',');
            sb.append(Operations.getInstance().getColumnName(i));
            sb.append("=?");
        }
        sb.append(' ');
        update[Operations.getInstance().getIndex()]=getDBConnection().prepareStatement("UPDATE "
                +Operations.getInstance().getName()+" SET"+sb.toString()+"WHERE ID=?");
        sb.delete(0,sb.length());

        //generate the sequence of column names for the OtherInformation table
        sb.append(' ');
        for(int i=startIndex;i<=OtherInformation.getInstance().getColumnCount();i++){
            if(i!=startIndex)
                sb.append(',');
            sb.append(OtherInformation.getInstance().getColumnName(i));
            sb.append("=?");
        }
        sb.append(' ');
        update[OtherInformation.getInstance().getIndex()]=getDBConnection().prepareStatement("UPDATE "
                +OtherInformation.getInstance().getName()+" SET"+sb.toString()+"WHERE ID=?");
        sb.delete(0,sb.length());

        //generate the sequence of column names for the PersonalDetails table
        sb.append(' ');
        for(int i=startIndex;i<=PersonalDetails.getInstance().getColumnCount();i++){
            if(i!=startIndex)
                sb.append(',');
            sb.append(PersonalDetails.getInstance().getColumnName(i));
            sb.append("=?");
        }
        sb.append(' ');
        update[PersonalDetails.getInstance().getIndex()]=getDBConnection().prepareStatement("UPDATE "
                +PersonalDetails.getInstance().getName()+" SET"+sb.toString()+"WHERE ID=?");
        sb.delete(0,sb.length());
    }

    private void ensureSelectFromPersonalDetailsViewStatement() throws SQLException{
        if(selectFromPersonalDetailsView!=null)
            return;
        selectFromPersonalDetailsView=DBManager.getDBConnection().prepareStatement(
                "SELECT * FROM Personal_Details_View_ WHERE surname_ like ?");
    }

    /**
     * Deletes the patient with the specified ID from the database.
     *
     * @param patientID the patient's ID
     * @throws SQLException if an error occurs while performing the delete operation
     */
    void deletePatient(long patientID) throws SQLException{
        ensureDeleteStatements();

        //run through all the tables that encapsulate information about this patient and delete
        //them all

        deleteFrom[Diagnosis.getInstance().getIndex()].setLong(1,patientID);
        deleteFrom[Diagnosis.getInstance().getIndex()].executeUpdate();

        deleteFrom[HospitalHistory.getInstance().getIndex()].setLong(1,patientID);
        deleteFrom[HospitalHistory.getInstance().getIndex()].executeUpdate();

        deleteFrom[NHISInformation.getInstance().getIndex()].setLong(1,patientID);
        deleteFrom[NHISInformation.getInstance().getIndex()].executeUpdate();

        deleteFrom[NextOfKin.getInstance().getIndex()].setLong(1,patientID);
        deleteFrom[NextOfKin.getInstance().getIndex()].executeUpdate();

        deleteFrom[Operations.getInstance().getIndex()].setLong(1,patientID);
        deleteFrom[Operations.getInstance().getIndex()].executeUpdate();

        deleteFrom[OtherInformation.getInstance().getIndex()].setLong(1,patientID);
        deleteFrom[OtherInformation.getInstance().getIndex()].executeUpdate();

        deleteFrom[PersonalDetails.getInstance().getIndex()].setLong(1,patientID);
        deleteFrom[PersonalDetails.getInstance().getIndex()].executeUpdate();
    }

    /**
     * Inserts the patient with the specified patient object into the database.
     *
     * @param patientID the patient's object, encapsulating his information
     * @throws SQLException if an error occurs while performing the insert operation
     */
    void insertPatient(Patient patient) throws SQLException,NoSuchColumnException{
        ensureInsertStatements();

        int startIndex;

        //Deal with the PersonalDetails table
        startIndex=1;
        insertInto[PersonalDetails.getInstance().getIndex()].setString(startIndex++,patient.
                getPersonalDetails().getSurname());
        insertInto[PersonalDetails.getInstance().getIndex()].setString(startIndex++,patient.
                getPersonalDetails().getFirstName());
        insertInto[PersonalDetails.getInstance().getIndex()].setString(startIndex++,patient.
                getPersonalDetails().getOtherName());
        insertInto[PersonalDetails.getInstance().getIndex()].setString(startIndex++,patient.
                getPersonalDetails().getPhoneNumber());
        insertInto[PersonalDetails.getInstance().getIndex()].setString(startIndex++,patient.
                getPersonalDetails().getHomeAddress());
        insertInto[PersonalDetails.getInstance().getIndex()].setString(startIndex++,patient.
                getPersonalDetails().getTown());
        insertInto[PersonalDetails.getInstance().getIndex()].setString(startIndex++,patient.
                getPersonalDetails().getNationality());
        insertInto[PersonalDetails.getInstance().getIndex()].setString(startIndex++,patient.
                getPersonalDetails().getLGA());
        insertInto[PersonalDetails.getInstance().getIndex()].setString(startIndex++,patient.
                getPersonalDetails().getDateOfRegistration());
        insertInto[PersonalDetails.getInstance().getIndex()].setString(startIndex++,patient.
                getPersonalDetails().getNationalIDCardNumber());
        insertInto[PersonalDetails.getInstance().getIndex()].setString(startIndex++,patient.
                getPersonalDetails().getStateOfOrigin());
        insertInto[PersonalDetails.getInstance().getIndex()].executeUpdate();

        ResultSet generatedKeys=
                insertInto[PersonalDetails.getInstance().getIndex()].getGeneratedKeys();
        generatedKeys.next();

        long generatedID=generatedKeys.getLong(1);
        generatedKeys.close();

        patient.setID(generatedID);//set the patient's generated ID


        //Deal with the Diagnosis table
        startIndex=2;
        insertInto[Diagnosis.getInstance().getIndex()].setLong(1,generatedID);//set the unique ID
        insertInto[Diagnosis.getInstance().getIndex()].setString(startIndex++,patient.getDiagnosis().
                getDateDiagnosed());
        insertInto[Diagnosis.getInstance().getIndex()].setString(startIndex++,patient.getDiagnosis().
                getDateDischarged());
        insertInto[Diagnosis.getInstance().getIndex()].setString(startIndex++,patient.getDiagnosis().
                getDiagnosis());
        insertInto[Diagnosis.getInstance().getIndex()].setString(startIndex++,patient.getDiagnosis().
                getCodeNumber());
        insertInto[Diagnosis.getInstance().getIndex()].executeUpdate();

        //Deal with the HospitalHistory table
        startIndex=2;
        insertInto[HospitalHistory.getInstance().getIndex()].setLong(1,generatedID);//set the unique ID
        insertInto[HospitalHistory.getInstance().getIndex()].setString(startIndex++,patient.
                getHospitalHistory().getDateAdmitted());
        insertInto[HospitalHistory.getInstance().getIndex()].setString(startIndex++,patient.
                getHospitalHistory().getReferredBy());
        insertInto[HospitalHistory.getInstance().getIndex()].setString(startIndex++,patient.
                getHospitalHistory().getDateDischarged());
        insertInto[HospitalHistory.getInstance().getIndex()].setString(startIndex++,patient.
                getHospitalHistory().getReferredTo());
        insertInto[HospitalHistory.getInstance().getIndex()].setString(startIndex++,patient.
                getHospitalHistory().getDischargedTo());
        insertInto[HospitalHistory.getInstance().getIndex()].setString(startIndex++,patient.
                getHospitalHistory().getOutcomeOfCare());
        insertInto[HospitalHistory.getInstance().getIndex()].executeUpdate();

        //Deal with the NextOfKin table
        startIndex=2;
        insertInto[NextOfKin.getInstance().getIndex()].setLong(1,generatedID);//set the unique ID
        insertInto[NextOfKin.getInstance().getIndex()].setString(startIndex++,patient.getNextOfKin().
                getSurname());
        insertInto[NextOfKin.getInstance().getIndex()].setString(startIndex++,patient.getNextOfKin().
                getFirstName());
        insertInto[NextOfKin.getInstance().getIndex()].setString(startIndex++,patient.getNextOfKin().
                getOtherName());
        insertInto[NextOfKin.getInstance().getIndex()].setString(startIndex++,patient.getNextOfKin().
                getHomeAddress());
        insertInto[NextOfKin.getInstance().getIndex()].setString(startIndex++,patient.getNextOfKin().
                getTown());
        insertInto[NextOfKin.getInstance().getIndex()].setString(startIndex++,patient.getNextOfKin().
                getNationality());
        insertInto[NextOfKin.getInstance().getIndex()].setString(startIndex++,patient.getNextOfKin().
                getState());
        insertInto[NextOfKin.getInstance().getIndex()].setString(startIndex++,patient.getNextOfKin().
                getLGA());
        insertInto[NextOfKin.getInstance().getIndex()].setString(startIndex++,patient.getNextOfKin().
                getRelationshipToNextOfKin());
        insertInto[NextOfKin.getInstance().getIndex()].setString(startIndex++,patient.getNextOfKin().
                getPhoneNumber());
        insertInto[NextOfKin.getInstance().getIndex()].executeUpdate();

        //Deal with the NHISInformation table
        startIndex=2;
        insertInto[NHISInformation.getInstance().getIndex()].setLong(1,generatedID);//set the unique ID
        insertInto[NHISInformation.getInstance().getIndex()].setString(startIndex++,patient.
                getNHISInformation().getNHISNumber());
        insertInto[NHISInformation.getInstance().getIndex()].setString(startIndex++,patient.
                getNHISInformation().getHMO());
        insertInto[NHISInformation.getInstance().getIndex()].setString(startIndex++,patient.
                getNHISInformation().getGenotype());
        insertInto[NHISInformation.getInstance().getIndex()].setString(startIndex++,patient.
                getNHISInformation().getBloodGroup());
        insertInto[NHISInformation.getInstance().getIndex()].setString(startIndex++,patient.
                getNHISInformation().getHMOCode());
        insertInto[NHISInformation.getInstance().getIndex()].setString(startIndex++,patient.
                getNHISInformation().getHMOIDNumber());
        insertInto[NHISInformation.getInstance().getIndex()].setString(startIndex++,patient.
                getNHISInformation().getEmployer());
        insertInto[NHISInformation.getInstance().getIndex()].setString(startIndex++,patient.
                getNHISInformation().getEmployerAddress());
        insertInto[NHISInformation.getInstance().getIndex()].setString(startIndex++,patient.
                getNHISInformation().getAllergies());
        insertInto[NHISInformation.getInstance().getIndex()].executeUpdate();

        //Deal with the Operations table
        startIndex=2;
        insertInto[Operations.getInstance().getIndex()].setLong(1,generatedID);//set the unique ID
        insertInto[Operations.getInstance().getIndex()].setString(startIndex++,
                patient.getOperations().getDate());
        insertInto[Operations.getInstance().getIndex()].setString(startIndex++,
                patient.getOperations().getOpSurgeon());
        insertInto[Operations.getInstance().getIndex()].setString(startIndex++,
                patient.getOperations().getOperation());
        insertInto[Operations.getInstance().getIndex()].setString(startIndex++,
                patient.getOperations().getCodeNumber());
        insertInto[Operations.getInstance().getIndex()].executeUpdate();

        //Deal with the OtherInformation table
        startIndex=2;
        insertInto[OtherInformation.getInstance().getIndex()].setLong(1,generatedID);//set the unique ID
        insertInto[OtherInformation.getInstance().getIndex()].setString(startIndex++,patient.
                getOtherInformation().getTown());
        insertInto[OtherInformation.getInstance().getIndex()].setString(startIndex++,patient.
                getOtherInformation().getEducationalLevel());
        insertInto[OtherInformation.getInstance().getIndex()].executeUpdate();
    }

    /**
     * Retrieves the patient with the specified patient ID from the database.
     * The patient's ID field is also set before the method returns.
     *
     * @param patientID the patient's ID
     * @throws SQLException if an error occurs while performing the retrieve operation
     * @throws NoSuchPatientIDException if the specified {@code patientID} does not exist
     */
    Patient retrievePatient(final long patientID) throws SQLException,NoSuchColumnException,
            NoSuchPatientIDException{
        ensureIDSelectStatements();

        int startIndex;

        //Retrieve Diagnosis values
        selectFrom$ID[Diagnosis.getInstance().getIndex()].setLong(1,patientID);
        ResultSet diagnosisResultSet=
                selectFrom$ID[Diagnosis.getInstance().getIndex()].executeQuery();

        if(!diagnosisResultSet.next())
            throw new org.eminphis.exceptions.NoSuchPatientIDException(patientID);

        startIndex=1;
        org.eminphis.dto.Diagnosis diagnosis=
                new org.eminphis.dto.Diagnosis(
                diagnosisResultSet.getString(startIndex++),
                diagnosisResultSet.getString(startIndex++),
                diagnosisResultSet.getString(startIndex++),
                diagnosisResultSet.getString(startIndex++));
        diagnosisResultSet.close();

        //Retrieve HospitalHistory values
        selectFrom$ID[HospitalHistory.getInstance().getIndex()].setLong(1,patientID);
        ResultSet hospitalHistoryResultSet=
                selectFrom$ID[HospitalHistory.getInstance().getIndex()].executeQuery();
        hospitalHistoryResultSet.next();
        startIndex=1;
        org.eminphis.dto.HospitalHistory hospitalHistory=
                new org.eminphis.dto.HospitalHistory(
                hospitalHistoryResultSet.getString(startIndex++),
                hospitalHistoryResultSet.getString(startIndex++),
                hospitalHistoryResultSet.getString(startIndex++),
                hospitalHistoryResultSet.getString(startIndex++),
                hospitalHistoryResultSet.getString(startIndex++),
                hospitalHistoryResultSet.getString(startIndex++));
        hospitalHistoryResultSet.close();

        //Retrieve NextOfKin values
        selectFrom$ID[NextOfKin.getInstance().getIndex()].setLong(1,patientID);
        ResultSet nextOfKinResultSet=
                selectFrom$ID[NextOfKin.getInstance().getIndex()].executeQuery();
        nextOfKinResultSet.next();
        startIndex=1;
        org.eminphis.dto.NextOfKin nextOfKin=
                new org.eminphis.dto.NextOfKin(
                nextOfKinResultSet.getString(startIndex++),
                nextOfKinResultSet.getString(startIndex++),
                nextOfKinResultSet.getString(startIndex++),
                nextOfKinResultSet.getString(startIndex++),
                nextOfKinResultSet.getString(startIndex++),
                nextOfKinResultSet.getString(startIndex++),
                nextOfKinResultSet.getString(startIndex++),
                nextOfKinResultSet.getString(startIndex++),
                nextOfKinResultSet.getString(startIndex++),
                nextOfKinResultSet.getString(startIndex++));
        nextOfKinResultSet.close();

        //Retrieve NHISInformation values
        selectFrom$ID[NHISInformation.getInstance().getIndex()].setLong(1,patientID);
        ResultSet nHISInformationResultSet=
                selectFrom$ID[NHISInformation.getInstance().getIndex()].executeQuery();
        nHISInformationResultSet.next();
        startIndex=1;
        org.eminphis.dto.NHISInformation nHISInformation=
                new org.eminphis.dto.NHISInformation(
                nHISInformationResultSet.getString(startIndex++),
                nHISInformationResultSet.getString(startIndex++),
                nHISInformationResultSet.getString(startIndex++),
                nHISInformationResultSet.getString(startIndex++),
                nHISInformationResultSet.getString(startIndex++),
                nHISInformationResultSet.getString(startIndex++),
                nHISInformationResultSet.getString(startIndex++),
                nHISInformationResultSet.getString(startIndex++),
                nHISInformationResultSet.getString(startIndex++));
        nHISInformationResultSet.close();

        //Retrieve Operations values
        selectFrom$ID[Operations.getInstance().getIndex()].setLong(1,patientID);
        ResultSet operationsResultSet=
                selectFrom$ID[Operations.getInstance().getIndex()].executeQuery();
        operationsResultSet.next();
        startIndex=1;
        org.eminphis.dto.Operations operations=
                new org.eminphis.dto.Operations(
                operationsResultSet.getString(startIndex++),
                operationsResultSet.getString(startIndex++),
                operationsResultSet.getString(startIndex++),
                operationsResultSet.getString(startIndex++));
        operationsResultSet.close();

        //Retrieve OtherInformation values
        selectFrom$ID[OtherInformation.getInstance().getIndex()].setLong(1,patientID);
        ResultSet otherInformationResultSet=
                selectFrom$ID[OtherInformation.getInstance().getIndex()].executeQuery();
        otherInformationResultSet.next();
        startIndex=1;
        org.eminphis.dto.OtherInformation otherInformation=
                new org.eminphis.dto.OtherInformation(
                otherInformationResultSet.getString(startIndex++),
                otherInformationResultSet.getString(startIndex++));
        otherInformationResultSet.close();

        //Retrieve PersonalDetails values
        selectFrom$ID[PersonalDetails.getInstance().getIndex()].setLong(1,patientID);
        ResultSet personalDetailsResultSet=
                selectFrom$ID[PersonalDetails.getInstance().getIndex()].executeQuery();
        personalDetailsResultSet.next();
        startIndex=1;
        org.eminphis.dto.PersonalDetails personalDetails=
                new org.eminphis.dto.PersonalDetails(
                personalDetailsResultSet.getString(startIndex++),
                personalDetailsResultSet.getString(startIndex++),
                personalDetailsResultSet.getString(startIndex++),
                personalDetailsResultSet.getString(startIndex++),
                personalDetailsResultSet.getString(startIndex++),
                personalDetailsResultSet.getString(startIndex++),
                personalDetailsResultSet.getString(startIndex++),
                personalDetailsResultSet.getString(startIndex++),
                personalDetailsResultSet.getString(startIndex++),
                personalDetailsResultSet.getString(startIndex++),
                personalDetailsResultSet.getString(startIndex++));
        personalDetailsResultSet.close();


        return new org.eminphis.dto.Patient(diagnosis,hospitalHistory,nHISInformation,nextOfKin,
                operations,
                otherInformation,personalDetails){

            {
                setID(patientID);
            }
        };
    }

    /**
     * Updates the patient with the specified patient object.
     *
     * @param patientID the patient's ID
     * @throws SQLException if an error occurs while performing the update operation
     */
    void updatePatient(Patient patient) throws NoSuchColumnException,SQLException{
        ensureUpdateStatements();
        int startIndex;


        //Deal with the Diagnosis table
        startIndex=1;
        update[Diagnosis.getInstance().getIndex()].setLong(Diagnosis.getInstance().getColumnCount(),
                patient.getID());//set the unique ID
        update[Diagnosis.getInstance().getIndex()].setString(startIndex++,patient.getDiagnosis().
                getDateDiagnosed());
        update[Diagnosis.getInstance().getIndex()].setString(startIndex++,patient.getDiagnosis().
                getDateDischarged());
        update[Diagnosis.getInstance().getIndex()].setString(startIndex++,patient.getDiagnosis().
                getDiagnosis());
        update[Diagnosis.getInstance().getIndex()].setString(startIndex++,patient.getDiagnosis().
                getCodeNumber());
        update[Diagnosis.getInstance().getIndex()].executeUpdate();

        //Deal with the HospitalHistory table
        startIndex=1;
        update[HospitalHistory.getInstance().getIndex()].setLong(HospitalHistory.getInstance().
                getColumnCount(),patient.getID());//set the unique ID
        update[HospitalHistory.getInstance().getIndex()].setString(startIndex++,patient.
                getHospitalHistory().getDateAdmitted());
        update[HospitalHistory.getInstance().getIndex()].setString(startIndex++,patient.
                getHospitalHistory().getReferredBy());
        update[HospitalHistory.getInstance().getIndex()].setString(startIndex++,patient.
                getHospitalHistory().getDateDischarged());
        update[HospitalHistory.getInstance().getIndex()].setString(startIndex++,patient.
                getHospitalHistory().getReferredTo());
        update[HospitalHistory.getInstance().getIndex()].setString(startIndex++,patient.
                getHospitalHistory().getDischargedTo());
        update[HospitalHistory.getInstance().getIndex()].setString(startIndex++,patient.
                getHospitalHistory().getOutcomeOfCare());
        update[HospitalHistory.getInstance().getIndex()].executeUpdate();

        //Deal with the NextOfKin table
        startIndex=1;
        update[NextOfKin.getInstance().getIndex()].setLong(NextOfKin.getInstance().getColumnCount(),
                patient.getID());//set the unique ID
        update[NextOfKin.getInstance().getIndex()].setString(startIndex++,patient.getNextOfKin().
                getSurname());
        update[NextOfKin.getInstance().getIndex()].setString(startIndex++,patient.getNextOfKin().
                getFirstName());
        update[NextOfKin.getInstance().getIndex()].setString(startIndex++,patient.getNextOfKin().
                getOtherName());
        update[NextOfKin.getInstance().getIndex()].setString(startIndex++,patient.getNextOfKin().
                getHomeAddress());
        update[NextOfKin.getInstance().getIndex()].setString(startIndex++,patient.getNextOfKin().
                getTown());
        update[NextOfKin.getInstance().getIndex()].setString(startIndex++,patient.getNextOfKin().
                getNationality());
        update[NextOfKin.getInstance().getIndex()].setString(startIndex++,patient.getNextOfKin().
                getState());
        update[NextOfKin.getInstance().getIndex()].setString(startIndex++,patient.getNextOfKin().
                getLGA());
        update[NextOfKin.getInstance().getIndex()].setString(startIndex++,patient.getNextOfKin().
                getRelationshipToNextOfKin());
        update[NextOfKin.getInstance().getIndex()].setString(startIndex++,patient.getNextOfKin().
                getPhoneNumber());
        update[NextOfKin.getInstance().getIndex()].executeUpdate();

        //Deal with the NHISInformation table
        startIndex=1;
        update[NHISInformation.getInstance().getIndex()].setLong(NHISInformation.getInstance().
                getColumnCount(),patient.getID());//set the unique ID
        update[NHISInformation.getInstance().getIndex()].setString(startIndex++,patient.
                getNHISInformation().getNHISNumber());
        update[NHISInformation.getInstance().getIndex()].setString(startIndex++,patient.
                getNHISInformation().getHMO());
        update[NHISInformation.getInstance().getIndex()].setString(startIndex++,patient.
                getNHISInformation().getGenotype());
        update[NHISInformation.getInstance().getIndex()].setString(startIndex++,patient.
                getNHISInformation().getBloodGroup());
        update[NHISInformation.getInstance().getIndex()].setString(startIndex++,patient.
                getNHISInformation().getHMOCode());
        update[NHISInformation.getInstance().getIndex()].setString(startIndex++,patient.
                getNHISInformation().getHMOIDNumber());
        update[NHISInformation.getInstance().getIndex()].setString(startIndex++,patient.
                getNHISInformation().getEmployer());
        update[NHISInformation.getInstance().getIndex()].setString(startIndex++,patient.
                getNHISInformation().getEmployerAddress());
        update[NHISInformation.getInstance().getIndex()].setString(startIndex++,patient.
                getNHISInformation().getAllergies());
        update[NHISInformation.getInstance().getIndex()].executeUpdate();

        //Deal with the Operations table
        startIndex=1;
        update[Operations.getInstance().getIndex()].setLong(
                Operations.getInstance().getColumnCount(),patient.getID());//set the unique ID
        update[Operations.getInstance().getIndex()].setString(startIndex++,
                patient.getOperations().getDate());
        update[Operations.getInstance().getIndex()].setString(startIndex++,
                patient.getOperations().getOpSurgeon());
        update[Operations.getInstance().getIndex()].setString(startIndex++,
                patient.getOperations().getOperation());
        update[Operations.getInstance().getIndex()].setString(startIndex++,
                patient.getOperations().getCodeNumber());
        update[Operations.getInstance().getIndex()].executeUpdate();

        //Deal with the OtherInformation table
        startIndex=1;
        update[OtherInformation.getInstance().getIndex()].setLong(OtherInformation.getInstance().
                getColumnCount(),patient.getID());//set the unique ID
        update[OtherInformation.getInstance().getIndex()].setString(startIndex++,patient.
                getOtherInformation().getTown());
        update[OtherInformation.getInstance().getIndex()].setString(startIndex++,patient.
                getOtherInformation().getEducationalLevel());
        update[OtherInformation.getInstance().getIndex()].executeUpdate();

        //Deal with the PersonalDetails table
        startIndex=1;
        update[PersonalDetails.getInstance().getIndex()].setLong(PersonalDetails.getInstance().
                getColumnCount(),patient.getID());//set the unique ID
        update[PersonalDetails.getInstance().getIndex()].setString(startIndex++,patient.
                getPersonalDetails().getSurname());
        update[PersonalDetails.getInstance().getIndex()].setString(startIndex++,patient.
                getPersonalDetails().getFirstName());
        update[PersonalDetails.getInstance().getIndex()].setString(startIndex++,patient.
                getPersonalDetails().getOtherName());
        update[PersonalDetails.getInstance().getIndex()].setString(startIndex++,patient.
                getPersonalDetails().getPhoneNumber());
        update[PersonalDetails.getInstance().getIndex()].setString(startIndex++,patient.
                getPersonalDetails().getHomeAddress());
        update[PersonalDetails.getInstance().getIndex()].setString(startIndex++,patient.
                getPersonalDetails().getTown());
        update[PersonalDetails.getInstance().getIndex()].setString(startIndex++,patient.
                getPersonalDetails().getNationality());
        update[PersonalDetails.getInstance().getIndex()].setString(startIndex++,patient.
                getPersonalDetails().getLGA());
        update[PersonalDetails.getInstance().getIndex()].setString(startIndex++,patient.
                getPersonalDetails().getDateOfRegistration());
        update[PersonalDetails.getInstance().getIndex()].setString(startIndex++,patient.
                getPersonalDetails().getNationalIDCardNumber());
        update[PersonalDetails.getInstance().getIndex()].setString(startIndex++,patient.
                getPersonalDetails().getStateOfOrigin());
        update[PersonalDetails.getInstance().getIndex()].executeUpdate();
    }

    PersonalDetailsView retrievePersonalDetailsView(String regex) throws SQLException{
        ensureSelectFromPersonalDetailsViewStatement();

        selectFromPersonalDetailsView.setString(1,regex);
        ResultSet rs=selectFromPersonalDetailsView.executeQuery();
        PersonalDetailsView personalDetailsView=new PersonalDetailsView();
        while(rs.next()){
            int i=1;
            personalDetailsView.addMatchedResult(
                    rs.getLong(i++),
                    rs.getString(i++),
                    rs.getString(i++),
                    rs.getString(i++));
        }
        rs.close();
        return personalDetailsView;
    }

    Patient retrievePatient(String NHISNumber) throws SQLException,NoSuchPatientNHISNumberException,
            NoSuchColumnException,NoSuchPatientIDException{
        ensureNHISSelectStatement();
        
        selectFrom$NHIS.setString(1,NHISNumber);
        ResultSet rs=selectFrom$NHIS.executeQuery();
        if(!rs.next())
            throw new org.eminphis.exceptions.NoSuchPatientNHISNumberException(NHISNumber);
        long ID=rs.getLong(1);
        rs.close();
        return retrievePatient(ID);
    }
}
