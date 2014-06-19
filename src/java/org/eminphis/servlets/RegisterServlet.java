package org.eminphis.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eminphis.ErrorLogger;
import org.eminphis.Printer;
import org.eminphis.db.DBManager;
import org.eminphis.dto.Patient;
import org.eminphis.exceptions.NoSuchColumnException;
import org.eminphis.ui.FrontendManager;
import org.eminphis.ui.registrar.RegistrationHandler;

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

    private Exception exceptionIfAny;

    @Override
    protected void service(HttpServletRequest req,HttpServletResponse resp) throws ServletException,
            IOException{

        if(exceptionIfAny!=null){//Then there was an exception while initializing db connection
            FrontendManager.showDBInitErrorPage(req,resp,exceptionIfAny.getMessage());
            return;
        }
        super.service(req,resp);
    }

    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
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
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response)
            throws ServletException,IOException{
        response.setContentType("text/html;charset=UTF-8");

        RegistrationHandler registrationManager=new RegistrationHandler(request,response);
        Patient patient=registrationManager.getPatient();

        try{
            DBManager.insertPatient(patient);
            DBManager.commitChanges();
            registrationManager.showInsertSuccessPage();
        }catch(SQLException ex){
            ErrorLogger.logError(ex);
            registrationManager.showInsertErrorPage(ex.getMessage());
        }catch(NoSuchColumnException ex){
            ErrorLogger.logError(ex);
        }
    }

    @Override
    public void init() throws ServletException{
        Printer.println("started initializing");
        super.init();
        Printer.println("finished initializing");
        exceptionIfAny=initializeDatabaseConnection();
    }

    /**
     *
     * @return the exception message, if an exception occurs while initializing
     * database connections; otherwise, null is returned if there was no exception
     */
    private Exception initializeDatabaseConnection(){
        try{
            //initialize database connection
            DBManager.initialize();
            return null;
        }catch(Exception e){
            ErrorLogger.logError(e);
            return e;
        }
    }

    @Override
    public void destroy(){
        Printer.println("destroy() was called");
        commitAndCloseDBResources();
        super.destroy();
    }

    private void commitAndCloseDBResources(){
        try{
            //commit changes and close database resources
            DBManager.closeDatabaseResources();
        }catch(Exception e){
            ErrorLogger.logError(e);
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
