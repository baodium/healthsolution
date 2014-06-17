
package org.eminphis.exceptions;

/**
 * <u>e-MINPHIS</u><br>
 * A project of the Health Information Systems Unit of the<br>
 * Department of Computer Science and Engineering,<br>
 * Obafemi Awolowo University, Ile-Ife.<br>
 * 
 * 
 * <pre>
 * Class name: MINPHISException.java
 * Version: 1.0
 * Author: Essiennta Emmanuel (colourfulemmanuel@gmail.com)
 * 
 * <u>Description</u>
 * Represents an exception that is specific to the implementation of this application.
 * 
 * </pre>
 * @author Essiennta Emmanuel (colourfulemmanuel@gmail.com)
 * @version 1.0
 */
public abstract class MINPHISException extends Exception{

    public MINPHISException(){
    }

    public MINPHISException(String message){
        super(message);
    }

    public MINPHISException(Throwable cause){
        super(cause);
    }

    public MINPHISException(String message,Throwable cause){
        super(message,cause);
    }
    
}
