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

    public static final int MODE_CONSULTANT=0;
    public static final int MODE_CLINIC=1;
    public static final int MODE_DATE=2;

    private long appointmentId;
    private final long hospitalNumber;//patient's hospital number
    private final String nameOfPatient;
    private final String dateOfBirth;
    private final String appointmentType;
    private final String clinic;
    private final String appointmentDate;
    private final String consultantToSee;
    private final String reason;
    private final String referralSource;
    private final String tallyNumber;
    private final String clinicTime;

    public Appointment(long hospitalNumber,String nameOfPatient,String dateOfBirth,String appointmentType,String clinic,
            String appointmentDate,String consultantToSee,String reason,String referralSource,String tallyNumber,
            String clinicTime){
        this.hospitalNumber=hospitalNumber;
        this.nameOfPatient=nameOfPatient;
        this.dateOfBirth=dateOfBirth;
        this.appointmentType=appointmentType;
        this.clinic=clinic;
        this.appointmentDate=appointmentDate;
        this.consultantToSee=consultantToSee;
        this.reason=reason;
        this.referralSource=referralSource;
        this.tallyNumber=tallyNumber;
        this.clinicTime=clinicTime;
    }

    public long getAppointmentId(){
        return appointmentId;
    }

    public void setAppointmentId(long appointmentId){
        this.appointmentId=appointmentId;
    }

    public long getHospitalNumber(){
        return hospitalNumber;
    }

    public String getNameOfPatient(){
        return nameOfPatient;
    }

    public String getDateOfBirth(){
        return dateOfBirth;
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
