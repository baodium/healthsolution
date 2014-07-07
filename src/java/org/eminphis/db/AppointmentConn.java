package org.eminphis.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.eminphis.dto.Appointment;
import org.eminphis.dto.Group;

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

    void deleteAppointment(long appointmentId) throws SQLException{
        int deleteIndex=Conn.getInstance().ensureInit(Statement.DELETE,
                "DELETE FROM Appointment_ WHERE appointment_id_=?");

        SqlStatement deleteStatement=Conn.getInstance().getStatement(Statement.DELETE,deleteIndex);
        deleteStatement.setLong(1,appointmentId);
        deleteStatement.executeUpdate();
        DBManager.saveChanges();
    }

    void insertAppointment(Appointment appointment) throws SQLException{
        int insertIndex=Conn.getInstance().ensureInit(Statement.INSERT,
                "INSERT INTO Appointment_ (hospital_number_,name_of_patient_,date_of_birth_,appointment_type_,clinic_,appointment_date_,consultant_to_see_,reason_,referral_source_,tally_number_,clinic_time_) VALUES (?,?,?,?,?,?,?,?,?,?,?)",
                true);

        SqlStatement insertStatement=Conn.getInstance().getStatement(Statement.INSERT,insertIndex);
        insertStatement.setLong(1,appointment.getHospitalNumber());
        insertStatement.setString(2,appointment.getNameOfPatient());
        insertStatement.setString(3,appointment.getDateOfBirth());
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
        long appointmentId=rs.getLong(1);
        rs.close();
        appointment.setAppointmentId(appointmentId);
        //Remember to call DBManager.saveChanges() after a successful atomic update
    }

    Group<Appointment> retrieveAppointment(int mode,String value) throws SQLException{
        if(mode!=Appointment.MODE_CLINIC&&mode!=Appointment.MODE_CONSULTANT&&mode!=Appointment.MODE_DATE)
            throw new RuntimeException("Unrecognized appointment retrieval mode");

        int retrieveIndex=Conn.getInstance().ensureInit(Statement.RETRIEVE,
                "SELECT appointment_id_,hospital_number_,name_of_patient_,date_of_birth_,appointment_type_,clinic_,appointment_date_,consultant_to_see_,reason_,referral_source_,tally_number_,clinic_time_ FROM Appointment_ WHERE "
                +(mode==Appointment.MODE_CLINIC?"clinic_":mode==Appointment.MODE_CONSULTANT?"consultant_to_see_"
                :"appointment_date_")+"=?");

        SqlStatement retrieveStatement=Conn.getInstance().getStatement(Statement.RETRIEVE,retrieveIndex);
        retrieveStatement.setString(1,value);
        ResultSet rs=retrieveStatement.executeQuery();
        Group<Appointment> appointments=new Group<Appointment>();
        while(rs.next()){
            long appointmentId=rs.getLong(1);
            long hospitalNumber=rs.getLong(2);
            String nameOfPatient=rs.getString(3);
            String dateOfBirth=rs.getString(4);
            String appointmentType=rs.getString(5);
            String clinic=rs.getString(6);
            String appointmentDate=rs.getString(7);
            String consultantToSee=rs.getString(8);
            String reason=rs.getString(9);
            String referralSource=rs.getString(10);
            String tallyNumber=rs.getString(11);
            String clinicTime=rs.getString(12);
            final Appointment appointment
                    =new Appointment(hospitalNumber,nameOfPatient,dateOfBirth,appointmentType,clinic,appointmentDate,
                            consultantToSee,reason,referralSource,tallyNumber,clinicTime);
            appointment.setAppointmentId(appointmentId);
            appointments.addElement(appointment);
        }
        rs.close();
        return appointments;
    }

    Appointment retrieveAppointment(long appointmentId) throws SQLException{
        int retrieveIndex=Conn.getInstance().ensureInit(Statement.RETRIEVE,
                "SELECT hospital_number_,name_of_patient_,date_of_birth_,appointment_type_,clinic_,appointment_date_,consultant_to_see_,reason_,referral_source_,tally_number_,clinic_time_ FROM Appointment_ WHERE appointment_id_=?");

        SqlStatement retrieveStatement=Conn.getInstance().getStatement(Statement.RETRIEVE,retrieveIndex);
        retrieveStatement.setLong(1,appointmentId);
        ResultSet rs=retrieveStatement.executeQuery();
        rs.next();
        long hospitalNumber=rs.getLong(1);
        String nameOfPatient=rs.getString(2);
        String dateOfBirth=rs.getString(3);
        String appointmentType=rs.getString(4);
        String clinic=rs.getString(5);
        String appointmentDate=rs.getString(6);
        String consultantToSee=rs.getString(7);
        String reason=rs.getString(8);
        String referralSource=rs.getString(9);
        String tallyNumber=rs.getString(10);
        String clinicTime=rs.getString(11);
        rs.close();
        Appointment appointment=new Appointment(hospitalNumber,nameOfPatient,dateOfBirth,appointmentType,clinic,
                appointmentDate,
                consultantToSee,reason,referralSource,tallyNumber,clinicTime);
        appointment.setAppointmentId(appointmentId);
        return appointment;
    }

    void updateAppointment(Appointment appointment) throws SQLException{
        int updateIndex=Conn.getInstance().ensureInit(Statement.UPDATE,
                "UPDATE Appointment_ SET hospital_number_=?,name_of_patient_=?,date_of_birth_=?,appointment_type_=?,clinic_=?,appointment_date_=?,consultant_to_see_=?,reason_=?,referral_source_=?,tally_number_=?,clinic_time_=? WHERE appointment_id_=?");

        SqlStatement updateStatement=Conn.getInstance().getStatement(Statement.UPDATE,updateIndex);
        updateStatement.setLong(1,appointment.getHospitalNumber());
        updateStatement.setString(2,appointment.getNameOfPatient());
        updateStatement.setString(3,appointment.getDateOfBirth());
        updateStatement.setString(4,appointment.getAppointmentType());
        updateStatement.setString(5,appointment.getClinic());
        updateStatement.setString(6,appointment.getAppointmentDate());
        updateStatement.setString(7,appointment.getConsultantToSee());
        updateStatement.setString(8,appointment.getReason());
        updateStatement.setString(9,appointment.getReferralSource());
        updateStatement.setString(10,appointment.getTallyNumber());
        updateStatement.setString(11,appointment.getClinicTime());
        updateStatement.setLong(12,appointment.getAppointmentId());
        updateStatement.executeUpdate();
        DBManager.saveChanges();
    }
}
