package org.eminphis.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.eminphis.dto.Patient;
import org.eminphis.exceptions.NoSuchColumnException;

/**
 * <u>e-MINPHIS</u><br>
 * A project of the Health Information Systems Unit of the<br>
 * Department of Computer Science and Engineering,<br>
 * Obafemi Awolowo University, Ile-Ife.<br>
 *
 *
 * <pre>
 * Class name: DBManager.java
 * Version: 1.0
 * Author: Essiennta Emmanuel (colourfulemmanuel@gmail.com)
 *
 * <u>Description</u>
 *
 *
 * </pre>
 *
 * @author Essiennta Emmanuel (colourfulemmanuel@gmail.com)
 * @version 1.0
 */
class DBManager{

    private static String databaseURL="jdbc:mysql://localhost:3306/healthrecord";
    private static Connection databaseConnection;
    static final int TABLE_COUNT=7;

    static Connection getDBConnection() throws SQLException{
        if(databaseConnection==null){
            databaseConnection=DriverManager.getConnection(databaseURL,"root","a");
            databaseConnection.setAutoCommit(false);
        }
        return databaseConnection;
    }
    
    /**
     * Saves all the changes made so far.
     * @throws SQLException if an error occurs while performing the commit operation
     */
    public static void commitChanges() throws SQLException{
        databaseConnection.commit();
    }
    
    
    public static void closeDatabaseResources() throws SQLException{
        commitChanges();
        PatientConn.getInstance().closeAllPatientResourcesAndNullifyInstance();
        databaseConnection.close();
        databaseConnection=null;
    }

    /**
     * Deletes the patient with the specified ID from the database.
     *
     * @param patientID the patient's ID
     * @throws SQLException if an error occurs while performing the delete operation
     */
    public void deletePatient(int patientID) throws SQLException{
        PatientConn.getInstance().deletePatient(patientID);
    }

    /**
     * Inserts the patient with the specified patient object into the database.
     *
     * @param patientID the patient's object, encapsulating his information
     * @throws SQLException if an error occurs while performing the insert operation
     */
    public void insertPatient(Patient patient) throws SQLException,NoSuchColumnException{
        PatientConn.getInstance().insertPatient(patient);
    }

    /**
     * Retrieves the patient with the specified patient ID from the database.
     * The patient's ID field is also set before the method returns.
     *
     * @param patientID the patient's ID
     * @throws SQLException if an error occurs while performing the retrieve operation
     */
    public Patient retrievePatient(int patientID) throws SQLException,NoSuchColumnException{
        return PatientConn.getInstance().retrievePatient(patientID);
    }

    /**
     * Updates the patient with the specified patient object.
     *
     * @param patientID the patient's ID
     * @throws SQLException if an error occurs while performing the update operation
     */
    public void updatePatient(Patient patient) throws NoSuchColumnException,SQLException{
        PatientConn.getInstance().updatePatient(patient);
    }
}
