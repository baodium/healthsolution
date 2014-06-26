
package org.eminphis.exceptions;

/**
 * <u>e-MINPHIS</u><br>
 * A project of the Health Information Systems Unit of the<br>
 * Department of Computer Science and Engineering,<br>
 * Obafemi Awolowo University, Ile-Ife.<br>
 * 
 * 
 * <pre>
 * Class name: InvalidRequestException.java
 * Version: 1.0
 * Author: Essiennta Emmanuel (colourfulemmanuel@gmail.com)
 * 
 * <u>Description</u>
 * Exception class that is thrown when the user's request is not a valid one. i.e. the request is
 * not defined within the application or within that context.
 * 
 * </pre>
 * @author Essiennta Emmanuel (colourfulemmanuel@gmail.com)
 * @version 1.0
 */
public class InvalidRequestException extends MINPHISException{

    public InvalidRequestException(String message){
        super(message);
    }

    public InvalidRequestException(){
        this("Invalid request");
    }

}
