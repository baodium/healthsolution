
package org.eminphis.ui.manager;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <u>e-MINPHIS</u><br>
 * A project of the Health Information Systems Unit of the<br>
 * Department of Computer Science and Engineering,<br>
 * Obafemi Awolowo University, Ile-Ife.<br>
 * 
 * 
 * <pre>
 Class name: UIManager.java
 Version: 1.0
 Author: Essiennta Emmanuel (colourfulemmanuel@gmail.com)
 
 <u>Description</u>
 * 
 * 
 * </pre>
 * @author Essiennta Emmanuel (colourfulemmanuel@gmail.com)
 * @version 1.0
 */
public abstract class UIManager {

    protected HttpServletRequest request;
    protected HttpServletResponse response;

    /**
     *
     * @param request the request object
     * @param response the response object
     */
    public UIManager(HttpServletRequest request,HttpServletResponse response){
        this.request=request;
        this.response=response;
    }
    
    /**
     * Displays an error page when an error occurs while trying to insert
     * the new patient into the database.
     *
     * @param exception the exception object, useful when the developer needs to trace the error
     * Useful for the developer when trying to fix the error.
     * @throws java.io.IOException
     */
    public void showErrorPage(Exception exception) throws IOException{
        response.getWriter().println(exception);
    }
    
    /**
     * Shows this page if operation was successful
     * @throws java.io.IOException
     */
    public void showSuccessPage() throws IOException{
        response.getWriter().println("<h3>Operation was successful</h3>");
    }
    
}
