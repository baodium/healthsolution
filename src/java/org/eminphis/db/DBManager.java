package org.eminphis.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import org.eminphis.ErrorLogger;
import org.eminphis.Printer;
import org.eminphis.dto.Appointment;
import org.eminphis.dto.Patient;
import org.eminphis.dto.tableview.PersonalDetailsView;
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
@WebListener
public class DBManager implements ServletContextListener{

    private static String databaseURL="jdbc:mysql://localhost:3306/eMINPHIS_DB";
    private static Connection databaseConnection;
    static final int TABLE_COUNT=7;

    static Connection getDBConnection() throws SQLException{
        return databaseConnection;
    }

    /**
     * Initializes the database resources.
     *
     * @throws SQLException
     */
    private static void initialize() throws SQLException{
        if(databaseConnection==null){
            databaseConnection=DriverManager.getConnection(databaseURL,"root","a");
            databaseConnection.setAutoCommit(false);
        }
    }

    /**
     * Saves all the changes made so far.
     *
     * @throws SQLException if an error occurs while performing the commit operation
     */
    public static void commitChanges() throws SQLException{
        databaseConnection.commit();
    }

    private static void closeDatabaseResources() throws SQLException{
        commitChanges();
        PatientConn.getInstance().closeAllPatientResourcesAndNullifyInstance();
        Conn.getInstance().closeAllStatements();
        databaseConnection.close();
        databaseConnection=null;
    }
    
    public static boolean isConnectionEstablished(){
        return databaseConnection!=null;
    }

    /**
     * Deletes the patient with the specified ID from the database.
     *
     * @param patientID the patient's ID
     * @throws SQLException if an error occurs while performing the delete operation
     */
    public static void deletePatient(long patientID) throws SQLException{
        PatientConn.getInstance().deletePatient(patientID);
    }

    /**
     * Inserts the patient with the specified patient object into the database.
     *
     * @param patient the patient's object, encapsulating his information
     * @throws SQLException if an error occurs while performing the insert operation
     * @throws NoSuchColumnException if a table entity reports that is has a column number that
     * actually doesn't exist in the table
     */
    public static void insertPatient(Patient patient) throws SQLException,NoSuchColumnException{
        PatientConn.getInstance().insertPatient(patient);
    }

    /**
     * Retrieves the patient with the specified patient ID from the database.
     * The patient's ID field is also set before the method returns.
     *
     * @param patientID the patient's ID
     * @return the patient object
     * @throws SQLException if an error occurs while performing the retrieve operation
     * @throws NoSuchColumnException if a table entity reports that is has a column number that
     * actually doesn't exist in the table
     */
    public static Patient retrievePatient(long patientID) throws SQLException,NoSuchColumnException,
            NoSuchPatientIDException{
        return PatientConn.getInstance().retrievePatient(patientID);
    }

    /**
     * Retrieves the patient with the specified NHIS number from the database.
     * The patient's NHIS number field is also set before the method returns.
     *
     * @param nHISNumber the patient's NHIS number
     * @return the patient object
     * @throws SQLException if an error occurs while performing the retrieve operation
     */
    public static Patient retrievePatient(String nHISNumber) throws SQLException,
            NoSuchColumnException,NoSuchPatientNHISNumberException,NoSuchPatientIDException{
        return PatientConn.getInstance().retrievePatient(nHISNumber);
    }

    /**
     * Updates the patient with the specified patient object.
     *
     * @param patientID the patient's ID
     * @throws SQLException if an error occurs while performing the update operation
     */
    public static void updatePatient(Patient patient) throws NoSuchColumnException,SQLException{
        PatientConn.getInstance().updatePatient(patient);
    }

    public static PersonalDetailsView retrievePersonalDetailsView(String prefixOfName) throws
            SQLException{
        return PatientConn.getInstance().retrievePersonalDetailsView(prefixOfName+'%');
    }

    public static void insertAppointment(Appointment appointment) throws SQLException{
        AppointmentConn.getInstance().insertAppointment(appointment);
    }

    @Override
    public void contextInitialized(ServletContextEvent sce){
        Printer.println("contentInitialized()");
        try{
            initialize();
        }catch(SQLException ex){
            ErrorLogger.logError(ex);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce){
        Printer.println("contextDestroyed()");
        try{
            closeDatabaseResources();
        }catch(SQLException ex){
            ErrorLogger.logError(ex);
        }
    }
}
