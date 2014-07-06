package org.eminphis.exceptions;

/**
 * <u>e-MINPHIS</u><br>
 * A project of the Health Information Systems Unit of the<br>
 * Department of Computer Science and Engineering,<br>
 * Obafemi Awolowo University, Ile-Ife.<br>
 *
 *
 * <pre>
 * Class name: NoSuchHospitalNumberException.java
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
public class NoSuchHospitalNumberException extends MINPHISException{

    private final long hospitalNumber;

    public NoSuchHospitalNumberException(String message,long hospitalNumber){
        super(message);
        this.hospitalNumber=hospitalNumber;
    }

    public NoSuchHospitalNumberException(long hospitalNumber){
        this("Hospital number "+hospitalNumber+" does not exist",hospitalNumber);
    }

    public long getHospitalNumber(){
        return hospitalNumber;
    }
}
