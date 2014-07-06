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
import org.eminphis.dto.tableview.Matches;
import org.eminphis.dto.tableview.SearchPatientMatch;
import org.eminphis.exceptions.NoSuchColumnException;
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
    static void initialize() throws SQLException{
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
    static void saveChanges() throws SQLException{
        databaseConnection.commit();
    }

    /**
     * Rolls back to the last commit.
     *
     * @throws SQLException if an error occurs while performing the rollback operation
     */
    static void undoChanges() throws SQLException{
        databaseConnection.rollback();
    }

    static void closeDatabaseResources() throws SQLException{
        saveChanges();
        Conn.getInstance().closeResources();
        databaseConnection.close();
        databaseConnection=null;
    }

    public static boolean isConnectionEstablished(){
        return databaseConnection!=null;
    }

    /**
     * Deletes the patient with the specified ID from the database.
     *
     * @param id the patient's ID
     * @throws SQLException if an error occurs while performing the delete operation
     */
    public static void deletePatient(long id) throws SQLException{
        PatientConn.getInstance().deletePatient(id);
    }

    /**
     * Inserts the patient with the specified patient object into the database.
     *
     * @param patient the patient's object, encapsulating his information
     * @throws SQLException          if an error occurs while performing the insert operation
     * @throws NoSuchColumnException if a table entity reports that is has a column number that
     *                               actually doesn't exist in the table
     */
    public static void insertPatient(Patient patient) throws SQLException,NoSuchColumnException{
        PatientConn.getInstance().insertPatient(patient);
    }

    /**
     * Retrieves the patient with the specified hospital number from the database.
     * The patient's ID field is also set before the method returns.
     *
     * @param hospitalNumber the patient's hospital number
     * @return the patient object
     * @throws SQLException          if an error occurs while performing the retrieve operation
     * @throws NoSuchColumnException if a table entity reports that is has a column number that
     *                               actually doesn't exist in the table
     */
    public static Patient retrievePatientByHospitalNumber(long hospitalNumber) throws SQLException,NoSuchColumnException,
            NoSuchHospitalNumberException{
        return PatientConn.getInstance().retrievePatientByHospitalNumber(hospitalNumber);
    }

    /**
     * Retrieves the patient with the specified NHIS number from the database.
     * The patient's NHIS number field is also set before the method returns.
     *
     * @param nhisNumber the patient's Nhis number
     * @return the patient object
     * @throws SQLException if an error occurs while performing the retrieve operation
     */
    public static Patient retrievePatientByNhisNumber(long nhisNumber) throws SQLException,
            NoSuchColumnException,NoSuchNHISNumberException,NoSuchHospitalNumberException{
        return PatientConn.getInstance().retrievePatientByNhisNumber(nhisNumber);
    }

    /**
     * Updates the patient with the specified patient object.
     *
     * @param patient the patient object
     * @throws SQLException if an error occurs while performing the update operation
     */
    public static void updatePatient(Patient patient) throws NoSuchColumnException,SQLException{
        PatientConn.getInstance().updatePatient(patient);
    }

    public static Matches<SearchPatientMatch> retrieveSearchPatientMatchesByName(String prefixOfName) throws
            SQLException{
        return PatientConn.getInstance().retrieveSearchPatientMatchesByName(prefixOfName+'%');
    }

    /**
     * Retrieves patient matches by number.
     * Currently supported numbers are hospital number and nhis number
     *
     * @param prefixOfNumber
     * @return
     * @throws SQLException
     */
    public static Matches<SearchPatientMatch> retrieveSearchPatientMatchesByNumber(long prefixOfNumber) throws
            SQLException{
        return PatientConn.getInstance().retrieveSearchPatientMatchesByNumber(prefixOfNumber+"%");
    }

    public static void deleteAppointment(long id) throws SQLException{
        AppointmentConn.getInstance().deleteAppointment(id);
    }

    public static void insertAppointment(Appointment appointment) throws SQLException{
        AppointmentConn.getInstance().insertAppointment(appointment);
    }

    public static void updateAppointment(Appointment appointment) throws SQLException{
        AppointmentConn.getInstance().updateAppointment(appointment);
    }

    @Override
    public void contextInitialized(ServletContextEvent sce){
        Printer.println("contentInitialized()");
        try{
            initialize();
        } catch(SQLException ex){
            ErrorLogger.logError(ex);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce){
        Printer.println("contextDestroyed()");
        try{
            closeDatabaseResources();
        } catch(SQLException ex){
            ErrorLogger.logError(ex);
        }
    }
}
