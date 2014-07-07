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
import org.eminphis.dto.Group;
import org.eminphis.dto.Patient;
import org.eminphis.dto.tableview.Matches;
import org.eminphis.dto.tableview.ScheduleAppointmentMatch;
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

    private static final String databaseURL="jdbc:mysql://localhost:3306/eMINPHIS_DB";
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
    private void initialize(){
        if(databaseConnection==null)
            try{
                databaseConnection=DriverManager.getConnection(databaseURL,"root","a");
                databaseConnection.setAutoCommit(false);
            } catch(SQLException ex){
                ErrorLogger.logError(ex);
            }
    }

    private void closeDatabaseResources(){
        try{
            saveChanges();
        } catch(SQLException ex){
            ErrorLogger.logError(ex);
        }
        Conn.getInstance().closeResources();
        try{
            databaseConnection.close();
        } catch(SQLException ex){
            ErrorLogger.logError(ex);
        }
        databaseConnection=null;
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
    public static void updatePatient(Patient patient) throws SQLException{
        PatientConn.getInstance().updatePatient(patient);
    }

    /**
     * Retrieves patient matches by name.
     *
     * @param prefixOfName the prefix of the patient's surname
     * @return the matches
     * @throws SQLException
     */
    public static Matches<SearchPatientMatch> retrieveSearchPatientMatchesByName(String prefixOfName) throws
            SQLException{
        return PatientConn.getInstance().retrieveSearchPatientMatchesByName(prefixOfName+'%');
    }

    /**
     * Retrieves patient matches by number.
     * Currently supported numbers are hospital number and nhis number
     *
     * @param prefixOfNumber
     * @return the matches
     * @throws SQLException
     */
    public static Matches<SearchPatientMatch> retrieveSearchPatientMatchesByNumber(long prefixOfNumber) throws
            SQLException{
        return PatientConn.getInstance().retrieveSearchPatientMatchesByNumber(prefixOfNumber+"%");
    }

    /**
     * Retrieves patient matches by name.
     *
     * @param prefixOfName the prefix of the patient's surname
     * @return the matches
     * @throws SQLException
     */
    public static Matches<ScheduleAppointmentMatch> retrieveScheduleAppointmentMatchesByName(String prefixOfName) throws
            SQLException{
        return PatientConn.getInstance().retrieveScheduleAppointmentMatchesByName(prefixOfName+'%');
    }

    /**
     * Retrieves patient matches by number.
     * Currently supported numbers are hospital number and nhis number
     *
     * @param prefixOfNumber
     * @return the matches
     * @throws SQLException
     */
    public static Matches<ScheduleAppointmentMatch> retrieveScheduleAppointmentMatchesByNumber(long prefixOfNumber)
            throws
            SQLException{
        return PatientConn.getInstance().retrieveScheduleAppointmentMatchesByNumber(prefixOfNumber+"%");
    }

    public static void deleteAppointment(long appointmentId) throws SQLException{
        AppointmentConn.getInstance().deleteAppointment(appointmentId);
    }

    public static void insertAppointment(Appointment appointment) throws SQLException{
        AppointmentConn.getInstance().insertAppointment(appointment);
    }

    /**
     * Retrieves a list of appointment of the specified type with the specified value.
     *
     * @param mode  the mode. One of
     *              {@link Appointment#MODE_CLINIC}, {@link Appointment#MODE_CONSULTANT}, {@link Appointment#MODE_DATE},
     * @param value the value
     * @return a group of appointments that match the query
     * @throws SQLException the exception object
     */
    public static Group<Appointment> retrieveAppointment(int mode,String value) throws SQLException{
        return AppointmentConn.getInstance().retrieveAppointment(mode,value);
    }

    /**
     * Retrieves the unique appointment having this {@code appointmentId}
     *
     * @param appointmentId the appointmentId
     * @return the unique appointment having this {@code appointmentId}
     * @throws SQLException the exception object
     */
    public static void retrieveAppointment(long appointmentId) throws SQLException{
        AppointmentConn.getInstance().retrieveAppointment(appointmentId);
    }

    public static void updateAppointment(Appointment appointment) throws SQLException{
        AppointmentConn.getInstance().updateAppointment(appointment);
    }

    @Override
    public void contextInitialized(ServletContextEvent sce){
        Printer.println("contentInitialized()");
        initialize();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce){
        Printer.println("contextDestroyed()");
        closeDatabaseResources();
    }
}
