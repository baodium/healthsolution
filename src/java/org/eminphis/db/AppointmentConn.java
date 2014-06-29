package org.eminphis.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.eminphis.dto.Appointment;

/**
 * <u>e-MINPHIS</u><br>
 * A project of the Health Information Systems Unit of the<br>
 * Department of Computer Science and Engineering,<br>
 * Obafemi Awolowo University, Ile-Ife.<br>
 *
 *
 * <pre>
 * Class name: AppointmentConn.java
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
class AppointmentConn{

    private AppointmentConn(){
    }

    private static AppointmentConn instance;

    static AppointmentConn getInstance(){
        if(instance==null)
            instance=new AppointmentConn();
        return instance;
    }

    void insertAppointment(Appointment appointment) throws SQLException{
        int insertIndex=Conn.getInstance().ensureInit(Statement.INSERT,
                "INSERT INTO Appointment_ (patient_i_d_,date_of_birth_,hospital_number_,appointment_type_,clinic_,appointment_date_,consultant_to_see_,reason_,referral_source_,tally_number_,clinic_time_) VALUES (?,?,?,?,?,?,?,?,?,?,?)");

        CustomStatement insertStatement=Conn.getInstance().
                getStatement(Statement.INSERT,insertIndex);
        int columnIndex=1;
        insertStatement.setLong(columnIndex++,appointment.getPatientID());
        insertStatement.setString(columnIndex++,appointment.getDateOfBirth());
        insertStatement.setString(columnIndex++,appointment.getHospitalNumber());
        insertStatement.setString(columnIndex++,appointment.getAppointmentType());
        insertStatement.setString(columnIndex++,appointment.getClinic());
        insertStatement.setString(columnIndex++,appointment.getAppointmentDate());
        insertStatement.setString(columnIndex++,appointment.getConsultantToSee());
        insertStatement.setString(columnIndex++,appointment.getReason());
        insertStatement.setString(columnIndex++,appointment.getReferralSource());
        insertStatement.setString(columnIndex++,appointment.getTallyNumber());
        insertStatement.setString(columnIndex++,appointment.getClinicTime());
        insertStatement.executeUpdate();
        ResultSet rs=insertStatement.getGeneratedKeys();
        rs.next();
        long primaryKey=rs.getLong(1);
        rs.close();
        appointment.setPrimaryKey(primaryKey);
    }

    Appointment retrieveAppointment(long primaryKey) throws SQLException{
        int retrieveIndex=Conn.getInstance().ensureInit(Statement.RETRIEVE,
                "SELECT patient_i_d_,date_of_birth_,hospital_number_,appointment_type_,clinic_,appointment_date_,consultant_to_see_,reason_,referral_source_,tally_number_,clinic_time_ FROM Appointment_ WHERE primaryKey=?");

        CustomStatement retrieveStatement=Conn.getInstance().getStatement(Statement.RETRIEVE,
                retrieveIndex);
        ResultSet rs=retrieveStatement.executeQuery();
        int columnIndex=1;
        long patientID=rs.getLong(columnIndex++);
        String dateOfBirth=rs.getString(columnIndex++);
        String hospitalNumber=rs.getString(columnIndex++);
        String appointmentType=rs.getString(columnIndex++);
        String clinic=rs.getString(columnIndex++);
        String appointmentDate=rs.getString(columnIndex++);
        String consultantToSee=rs.getString(columnIndex++);
        String reason=rs.getString(columnIndex++);
        String referralSource=rs.getString(columnIndex++);
        String tallyNumber=rs.getString(columnIndex++);
        String clinicTime=rs.getString(columnIndex++);
        rs.close();
        Appointment appointment
                =new Appointment(patientID,dateOfBirth,hospitalNumber,appointmentType,clinic,
                        appointmentDate,consultantToSee,reason,referralSource,tallyNumber,clinicTime);
        appointment.setPrimaryKey(primaryKey);
        return appointment;
    }
}
