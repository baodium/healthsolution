package org.eminphis.ui.manager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eminphis.dto.Patient;

/**
 * <u>e-MINPHIS</u><br>
 * A project of the Health Information Systems Unit of the<br>
 * Department of Computer Science and Engineering,<br>
 * Obafemi Awolowo University, Ile-Ife.<br>
 *
 *
 * <pre>
 * Class name: SearchManager.java
 * Version: 1.0
 * Author: Essiennta Emmanuel (colourfulemmanuel@gmail.com)
 *
 * <u>Description</u>
 * Responsible for retrieving the mode of search and presenting search results to the user.
 *
 * </pre>
 *
 * @author Essiennta Emmanuel (colourfulemmanuel@gmail.com)
 * @version 1.0
 */
public class SearchManager extends UIManager{

    public SearchManager(HttpServletRequest request,HttpServletResponse response){
        super(request,response);
    }

    /**
     * Displays information about the specified {@code patient}.
     *
     * @param patient the patient object capturing patient information
     */
    public void showPatientDetails(Patient patient) throws IOException,ServletException{
        request.setAttribute(Patient.class.getName(),patient);
        request.getRequestDispatcher("/searchPatient.jsp").forward(request,response);
    }
}
