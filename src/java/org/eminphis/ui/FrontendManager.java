package org.eminphis.ui;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * <u>e-MINPHIS</u><br>
 * A project of the Health Information Systems Unit of the<br>
 * Department of Computer Science and Engineering,<br>
 * Obafemi Awolowo University, Ile-Ife.<br>
 *
 *
 * <pre>
 * Class name: FrontendManager.java
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
public class FrontendManager{

    /**
     * Displays an error page when the connection to the database was
     * not successful. Therefore no further database operations can be performed.
     * i.e. further database operations will yield errors.<br><br>
     * The registrar has to shutdown the application and try restarting it.
     *
     *
     * @param technicalMessage the message returned from the exception object.
     * Useful for the developer when trying to fix the error.
     */
    public static void showDBInitErrorPage(HttpServletRequest request,ServletResponse response) throws ServletException,IOException{
        request.getRequestDispatcher("/initerror.jsp").forward(request,response);
    }
}
