package org.eminphis.servlets;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eminphis.ErrorLogger;
import org.eminphis.db.DBManager;
import org.eminphis.dto.Patient;
import org.eminphis.exceptions.NoSuchColumnException;
import org.eminphis.ui.FrontendManager;
import org.eminphis.ui.manager.RegistrationManager;

/**
 * <u>e-MINPHIS</u><br>
 * A project of the Health Information Systems Unit of the<br>
 * Department of Computer Science and Engineering,<br>
 * Obafemi Awolowo University, Ile-Ife.<br>
 *
 *
 * <pre>
 * Class name: RegisterServlet.java
 * Version: 1.0
 * Author: Essiennta Emmanuel (colourfulemmanuel@gmail.com)
 *
 * <u>Description</u>
 * Coordinates the registration of a new patient.
 *
 * </pre>
 *
 * @author Essiennta Emmanuel (colourfulemmanuel@gmail.com)
 * @version 1.0
 */
public class RegisterServlet extends HttpServlet{

    @Override
    protected void service(HttpServletRequest req,HttpServletResponse resp) throws ServletException,
            IOException{

        if(!DBManager.isConnectionEstablished()){//Then there was an exception while initializing db connection
            FrontendManager.showDBInitErrorPage(req,resp);
            return;
        }
        super.service(req,resp);
    }

    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response)
            throws ServletException,IOException{
        response.setContentType("text/html;charset=UTF-8");
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response)
            throws ServletException,IOException{
        response.setContentType("text/html;charset=UTF-8");

        RegistrationManager registrationManager=new RegistrationManager(request,response);
        Patient patient=registrationManager.getPatient();

        try{
            DBManager.insertPatient(patient);
            request.setAttribute("HOSPITAL_NUMBER",patient.getHospitalNumber());
            registrationManager.showSuccessPage();
        } catch(IOException ex){
            ErrorLogger.logError(ex);
            registrationManager.showErrorPage(ex);
        } catch(SQLException ex){
            ErrorLogger.logError(ex);
            registrationManager.showErrorPage(ex);
        } catch(NoSuchColumnException ex){
            ErrorLogger.logError(ex);
            registrationManager.showErrorPage(ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo(){
        return "Short description";
    }// </editor-fold>
}
