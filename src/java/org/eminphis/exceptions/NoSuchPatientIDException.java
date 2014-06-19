package org.eminphis.exceptions;

/**
 * <u>e-MINPHIS</u><br>
 * A project of the Health Information Systems Unit of the<br>
 * Department of Computer Science and Engineering,<br>
 * Obafemi Awolowo University, Ile-Ife.<br>
 *
 *
 * <pre>
 * Class name: NoSuchPatientIDException.java
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
public class NoSuchPatientIDException extends MINPHISException{

    private final long patientID;

    public NoSuchPatientIDException(String message,long patientID){
        super(message);
        this.patientID=patientID;
    }

    public NoSuchPatientIDException(long patientID){
        this("Patient ID "+patientID+" does not exist",patientID);
    }

    public long getPatientID(){
        return patientID;
    }
}
