
package org.eminphis;

import org.eminphis.exceptions.MINPHISException;

/**
 * <u>e-MINPHIS</u><br>
 * A project of the Health Information Systems Unit of the<br>
 * Department of Computer Science and Engineering,<br>
 * Obafemi Awolowo University, Ile-Ife.<br>
 * 
 * 
 * <pre>
 * Class name: ErrorLogger.java
 * Version: 1.0
 * Author: Essiennta Emmanuel (colourfulemmanuel@gmail.com)
 * 
 * <u>Description</u>
 * Serves as the sink for all error messages.
 * 
 * </pre>
 * @author Essiennta Emmanuel (colourfulemmanuel@gmail.com)
 * @version 1.0
 */
public class ErrorLogger {
    public static void logError(Exception e){
        if(e instanceof MINPHISException){
            System.out.println("MINPHISException>>>> "+e.getMessage());
        }
        e.printStackTrace();
    }
}
