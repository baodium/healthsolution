package org.eminphis.exceptions;

/**
 * <u>e-MINPHIS</u><br>
 * A project of the Health Information Systems Unit of the<br>
 * Department of Computer Science and Engineering,<br>
 * Obafemi Awolowo University, Ile-Ife.<br>
 *
 *
 * <pre>
 * Class name: NoSuchPatientNHISNumberException.java
 * Version: 1.0
 * Author: Essiennta Emmanuel (colourfulemmanuel@gmail.com)
 *
 * <u>Description</u>
 * This exception is raised when an non-existent NHIS number is being queried from the database.
 *
 * </pre>
 *
 * @author Essiennta Emmanuel (colourfulemmanuel@gmail.com)
 * @version 1.0
 */
public class NoSuchPatientNHISNumberException extends MINPHISException{

    private final String NHISNumber;

    public NoSuchPatientNHISNumberException(String message,String NHISNumber){
        super(message);
        this.NHISNumber=NHISNumber;
    }

    public NoSuchPatientNHISNumberException(String NHISNumber){
        this("Patient NHIS number "+NHISNumber+" does not exist",NHISNumber);
    }

    public String getNHISNumber(){
        return NHISNumber;
    }
}
