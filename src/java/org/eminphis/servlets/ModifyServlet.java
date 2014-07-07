package org.eminphis.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eminphis.ErrorLogger;
import org.eminphis.db.DBManager;
import org.eminphis.dto.Patient;
import org.eminphis.dto.tableview.SearchPatientMatch;
import org.eminphis.exceptions.NoSuchColumnException;
import org.eminphis.exceptions.NoSuchHospitalNumberException;
import org.eminphis.ui.manager.ModifyManager;
import org.eminphis.ui.manager.RegistrationManager;

/**
 * <u>e-MINPHIS</u><br>
 * A project of the Health Information Systems Unit of the<br>
 * Department of Computer Science and Engineering,<br>
 * Obafemi Awolowo University, Ile-Ife.<br>
 *
 *
 * <pre>
 * Class name: ModifyServlet.java
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
public class ModifyServlet extends HttpServlet{

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
        PrintWriter out=response.getWriter();
        ModifyManager modifyManager=new ModifyManager(request,response);
        String query=modifyManager.retrieveQuery();
        long hospitalNumber=SearchPatientMatch.retrieveHospitalNumber(query);

        Patient patient=null;
        try{
            patient=DBManager.retrievePatientByHospitalNumber(hospitalNumber);
            modifyManager.showPatientDetails(patient);
        } catch(NoSuchColumnException ex){
            ErrorLogger.logError(ex);
            modifyManager.showErrorPage(
                    "An error occurred while fulfilling your request to retrieve this patient's details.",ex);
        } catch(NoSuchHospitalNumberException ex){
            ErrorLogger.logError(ex);
            modifyManager.showErrorPage(
                    "An error occurred while fulfilling your request to retrieve this patient's details.",ex);
        } catch(SQLException ex){
            ErrorLogger.logError(ex);
            modifyManager.showErrorPage(
                    "An error occurred while fulfilling your request to retrieve this patient's details.",ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
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
            DBManager.updatePatient(patient);
            registrationManager.showSuccessPage("Operation was successful");
        } catch(SQLException ex){
            ErrorLogger.logError(ex);
            registrationManager.showErrorPage(
                    "An error occurred while fulfilling your request to update this patient's details.",ex);
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
