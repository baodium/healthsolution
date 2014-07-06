package org.eminphis.dto;

import org.eminphis.dto.patient.NextOfKin;
import org.eminphis.dto.patient.NhisInformation;
import org.eminphis.dto.patient.PersonalDetails;

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

    private long hospitalNumber;
    private final NextOfKin nextOfKin;
    private final NhisInformation nhisInformation;
    private final PersonalDetails personalDetails;

    /**
     * @param nextOfKin       the value of nextOfKin
     * @param nhisInformation the value of nhisInformation
     * @param personalDetails the value of personalDetails
     */
    public Patient(NextOfKin nextOfKin,NhisInformation nhisInformation,PersonalDetails personalDetails){
        this.nextOfKin=nextOfKin;
        this.nhisInformation=nhisInformation;
        this.personalDetails=personalDetails;
    }

    public long getHospitalNumber(){
        return hospitalNumber;
    }

    public void setHospitalNumber(long hospitalNumber){
        this.hospitalNumber=hospitalNumber;
    }

    public NextOfKin getNextOfKin(){
        return nextOfKin;
    }

    public NhisInformation getNhisInformation(){
        return nhisInformation;
    }

    public PersonalDetails getPersonalDetails(){
        return personalDetails;
    }
}
