package org.eminphis.dto;

/**
 * <u>e-MINPHIS</u><br>
 * A project of the Health Information Systems Unit of the<br>
 * Department of Computer Science and Engineering,<br>
 * Obafemi Awolowo University, Ile-Ife.<br>
 *
 *
 * <pre>
 * Class name: Appointment.java
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
public class Appointment{

    private long id;
    private final long patientId;
    private final String dateOfBirth;
    private final String hospitalNumber;
    private final String appointmentType;
    private final String clinic;
    private final String appointmentDate;
    private final String consultantToSee;
    private final String reason;
    private final String referralSource;
    private final String tallyNumber;
    private final String clinicTime;

    public Appointment(long patientId,String dateOfBirth,String hospitalNumber,String appointmentType,String clinic,
            String appointmentDate,String consultantToSee,String reason,String referralSource,String tallyNumber,
            String clinicTime){
        this.patientId=patientId;
        this.dateOfBirth=dateOfBirth;
        this.hospitalNumber=hospitalNumber;
        this.appointmentType=appointmentType;
        this.clinic=clinic;
        this.appointmentDate=appointmentDate;
        this.consultantToSee=consultantToSee;
        this.reason=reason;
        this.referralSource=referralSource;
        this.tallyNumber=tallyNumber;
        this.clinicTime=clinicTime;
    }

    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id=id;
    }

    public long getPatientId(){
        return patientId;
    }

    public String getDateOfBirth(){
        return dateOfBirth;
    }

    public String getHospitalNumber(){
        return hospitalNumber;
    }

    public String getAppointmentType(){
        return appointmentType;
    }

    public String getClinic(){
        return clinic;
    }

    public String getAppointmentDate(){
        return appointmentDate;
    }

    public String getConsultantToSee(){
        return consultantToSee;
    }

    public String getReason(){
        return reason;
    }

    public String getReferralSource(){
        return referralSource;
    }

    public String getTallyNumber(){
        return tallyNumber;
    }

    public String getClinicTime(){
        return clinicTime;
    }
}
