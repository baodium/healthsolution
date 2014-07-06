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
import org.eminphis.dto.tableview.SearchPatientMatch;
import org.eminphis.exceptions.NoSuchColumnException;
import org.eminphis.exceptions.NoSuchHospitalNumberException;
import org.eminphis.ui.manager.SearchManager;

/**
 * <u>e-MINPHIS</u><br>
 * A project of the Health Information Systems Unit of the<br>
 * Department of Computer Science and Engineering,<br>
 * Obafemi Awolowo University, Ile-Ife.<br>
 *
 *
 * <pre>
 * Class name: SearchServlet.java
 * Version: 1.0
 * Author: Essiennta Emmanuel (colourfulemmanuel@gmail.com)
 *
 * <u>Description</u>
 * Responsible for coordinating the search for a patient.
 *
 * </pre>
 *
 * @author Essiennta Emmanuel (colourfulemmanuel@gmail.com)
 * @version 1.0
 */
public class SearchServlet extends HttpServlet{

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        Printer.println("doGet");

        //First of all retrieve the search handler
        SearchManager searchManager=new SearchManager(request,response);
        String query=searchManager.retrieveQuery();
        long patientID=SearchPatientMatch.Match.retrievePatientID(query);
        
        Patient patient=null;
        try{
            patient=DBManager.retrievePatientByHospitalNumber(patientID);
            searchManager.showPatientDetails(patient);
        }catch(NoSuchColumnException ex){
            ErrorLogger.logError(ex);
            searchManager.showErrorPage(ex);
        }catch(NoSuchHospitalNumberException ex){
            ErrorLogger.logError(ex);
            searchManager.showErrorPage(ex);
        }catch(SQLException ex){
            ErrorLogger.logError(ex);
            searchManager.showErrorPage(ex);
        }
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
        PrintWriter out=response.getWriter();
        Printer.println("doPost");
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
