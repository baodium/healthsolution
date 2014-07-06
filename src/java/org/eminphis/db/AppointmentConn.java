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

    private static AppointmentConn instance;

    private AppointmentConn(){
    }

    static AppointmentConn getInstance(){
        if(instance==null)
            instance=new AppointmentConn();
        return instance;
    }

    void deleteAppointment(long id) throws SQLException{
        int deleteIndex=Conn.getInstance().ensureInit(Statement.DELETE,"DELETE FROM Appointment_ WHERE id_=?");

        SqlStatement deleteStatement=Conn.getInstance().getStatement(Statement.DELETE,deleteIndex);
        deleteStatement.setLong(1,id);
        deleteStatement.executeUpdate();
    }

    void insertAppointment(Appointment appointment) throws SQLException{
        int insertIndex=Conn.getInstance().ensureInit(Statement.INSERT,
                "INSERT INTO Appointment_ (patient_id_,date_of_birth_,hospital_number_,appointment_type_,clinic_,appointment_date_,consultant_to_see_,reason_,referral_source_,tally_number_,clinic_time_) VALUES (?,?,?,?,?,?,?,?,?,?,?)");

        SqlStatement insertStatement=Conn.getInstance().getStatement(Statement.INSERT,insertIndex);
        insertStatement.setLong(1,appointment.getPatientId());
        insertStatement.setString(2,appointment.getDateOfBirth());
        insertStatement.setString(3,appointment.getHospitalNumber());
        insertStatement.setString(4,appointment.getAppointmentType());
        insertStatement.setString(5,appointment.getClinic());
        insertStatement.setString(6,appointment.getAppointmentDate());
        insertStatement.setString(7,appointment.getConsultantToSee());
        insertStatement.setString(8,appointment.getReason());
        insertStatement.setString(9,appointment.getReferralSource());
        insertStatement.setString(10,appointment.getTallyNumber());
        insertStatement.setString(11,appointment.getClinicTime());
        insertStatement.executeUpdate();
        ResultSet rs=insertStatement.getGeneratedKeys();
        rs.next();
        long id=rs.getLong(1);
        rs.close();
        appointment.setId(id);
    }

    Appointment retrieveAppointment(long id) throws SQLException{
        int retrieveIndex=Conn.getInstance().ensureInit(Statement.RETRIEVE,
                "SELECT patient_id_,date_of_birth_,hospital_number_,appointment_type_,clinic_,appointment_date_,consultant_to_see_,reason_,referral_source_,tally_number_,clinic_time_ FROM Appointment_ WHERE id_=?");

        SqlStatement retrieveStatement=Conn.getInstance().getStatement(Statement.RETRIEVE,retrieveIndex);
        retrieveStatement.setLong(1,id);
        ResultSet rs=retrieveStatement.executeQuery();
        rs.next();
        long patientId=rs.getLong(1);
        String dateOfBirth=rs.getString(2);
        String hospitalNumber=rs.getString(3);
        String appointmentType=rs.getString(4);
        String clinic=rs.getString(5);
        String appointmentDate=rs.getString(6);
        String consultantToSee=rs.getString(7);
        String reason=rs.getString(8);
        String referralSource=rs.getString(9);
        String tallyNumber=rs.getString(10);
        String clinicTime=rs.getString(11);
        rs.close();
        Appointment appointment=new Appointment(patientId,dateOfBirth,hospitalNumber,appointmentType,clinic,
                appointmentDate,consultantToSee,reason,referralSource,tallyNumber,clinicTime);
        appointment.setId(id);
        return appointment;
    }

    void updateAppointment(Appointment appointment) throws SQLException{
        int updateIndex=Conn.getInstance().ensureInit(Statement.UPDATE,
                "UPDATE Appointment_ SET patient_id_=?,date_of_birth_=?,hospital_number_=?,appointment_type_=?,clinic_=?,appointment_date_=?,consultant_to_see_=?,reason_=?,referral_source_=?,tally_number_=?,clinic_time_=? WHERE id_=?");

        SqlStatement updateStatement=Conn.getInstance().getStatement(Statement.UPDATE,updateIndex);
        updateStatement.setLong(1,appointment.getPatientId());
        updateStatement.setString(2,appointment.getDateOfBirth());
        updateStatement.setString(3,appointment.getHospitalNumber());
        updateStatement.setString(4,appointment.getAppointmentType());
        updateStatement.setString(5,appointment.getClinic());
        updateStatement.setString(6,appointment.getAppointmentDate());
        updateStatement.setString(7,appointment.getConsultantToSee());
        updateStatement.setString(8,appointment.getReason());
        updateStatement.setString(9,appointment.getReferralSource());
        updateStatement.setString(10,appointment.getTallyNumber());
        updateStatement.setString(11,appointment.getClinicTime());
        updateStatement.setLong(12,appointment.getId());
        updateStatement.executeUpdate();
    }
}
