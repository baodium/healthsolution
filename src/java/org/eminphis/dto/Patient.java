package org.eminphis.dto;

/**
 * <u>e-MINPHIS</u><br>
 * A project of the Health Information Systems Unit of the<br>
 * Department of Computer Science and Engineering,<br>
 * Obafemi Awolowo University, Ile-Ife.<br>
 *
 *
 * <pre>
 * Class name: Patient.java
 * Version: 1.0
 * Author: Essiennta Emmanuel (colourfulemmanuel@gmail.com)
 *
 * <u>Description</u>
 * Encapsulates a patient's detailed information.
 *
 * </pre>
 *
 * @author Essiennta Emmanuel (colourfulemmanuel@gmail.com)
 * @version 1.0
 */
public class Patient{

    private long ID;
    private final Diagnosis diagnosis;
    private final HospitalHistory hospitalHistory;
    private final NextOfKin nextOfKin;
    private final NHISInformation nHISInformation;
    private final Operations operations;
    private final OtherInformation otherInformation;
    private final PersonalDetails personalDetails;

    public Patient(Diagnosis diagnosis,HospitalHistory hospitalHistory,NextOfKin nextOfKin,
            NHISInformation nHISInformation,Operations operations,OtherInformation otherInformation,
            PersonalDetails personalDetails){
        this.diagnosis=diagnosis;
        this.hospitalHistory=hospitalHistory;
        this.nextOfKin=nextOfKin;
        this.nHISInformation=nHISInformation;
        this.operations=operations;
        this.otherInformation=otherInformation;
        this.personalDetails=personalDetails;
    }

    public long getID(){
        return ID;
    }

    public void setID(long ID){
        this.ID=ID;
    }

    public Diagnosis getDiagnosis(){
        return diagnosis;
    }

    public HospitalHistory getHospitalHistory(){
        return hospitalHistory;
    }

    public NHISInformation getNHISInformation(){
        return nHISInformation;
    }

    public NextOfKin getNextOfKin(){
        return nextOfKin;
    }

    public Operations getOperations(){
        return operations;
    }

    public OtherInformation getOtherInformation(){
        return otherInformation;
    }

    public PersonalDetails getPersonalDetails(){
        return personalDetails;
    }
}
