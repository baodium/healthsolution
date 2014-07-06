package org.eminphis.exceptions;

/**
 * <u>e-MINPHIS</u><br>
 * A project of the Health Information Systems Unit of the<br>
 * Department of Computer Science and Engineering,<br>
 * Obafemi Awolowo University, Ile-Ife.<br>
 *
 *
 * <pre>
 Class name: NoSuchNHISNumberException.java
 Version: 1.0
 Author: Essiennta Emmanuel (colourfulemmanuel@gmail.com)

 <u>Description</u>
 * This exception is raised when an non-existent NHIS number is being queried from the database.
 *
 * </pre>
 *
 * @author Essiennta Emmanuel (colourfulemmanuel@gmail.com)
 * @version 1.0
 */
public class NoSuchNHISNumberException extends MINPHISException{

    private final long nhisNumber;

    public NoSuchNHISNumberException(String message,long nhisNumber){
        super(message);
        this.nhisNumber=nhisNumber;
    }

    public NoSuchNHISNumberException(long nhisNumber){
        this("Patient NHIS number "+nhisNumber+" does not exist",nhisNumber);
    }

    public long getNhisNumber(){
        return nhisNumber;
    }
}
