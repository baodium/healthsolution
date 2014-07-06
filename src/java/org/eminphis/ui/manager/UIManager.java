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
 * Class name: UIManager.java
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
public abstract class UIManager{

    protected HttpServletRequest request;
    protected HttpServletResponse response;

    /**
     *
     * @param request  the request object
     * @param response the response object
     */
    public UIManager(HttpServletRequest request,HttpServletResponse response){
        this.request=request;
        this.response=response;
    }

    /**
     * Retrieves the text in the text field set aside for making queries.
     *
     * @return the content of the search text field.
     */
    public final String retrieveQuery(){
        return request.getParameter("search_query");
    }

    /**
     * Displays an error page when an error occurs while carrying out transaction on this patient.
     *
     * @param friendlyMessage user friendly message
     * @param exception       the exception object, useful when the administrator has to fix the error
     * @throws java.io.IOException
     */
    public final void showErrorPage(String friendlyMessage,Exception exception) throws IOException{
        response.getWriter().println(
                "<h2>"+friendlyMessage+"</h2>");
        response.getWriter().println(exception);
    }

    /**
     * Shows this page if operation was successful
     *
     * @throws java.io.IOException
     */
    public final void showSuccessPage(String successMessage) throws IOException{
        response.getWriter().println(successMessage);
    }

}
