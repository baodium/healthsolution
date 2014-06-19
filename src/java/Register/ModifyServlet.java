/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Register;

import Register.data.Diagnosis;
import Register.data.Hospital_History;
import Register.data.NHIS_Information;
import Register.data.Next_Of_Kin;
import Register.data.Operations;
import Register.data.Other_Information;
import Register.data.Personal_Details;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author AZEEZ TAIWO
 */

public class ModifyServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
            /* TODO output your page here. You may use following sample code. */
           
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
         String patientID=request.getParameter("patient_id");
            System.out.println("patient id was "+patientID);
           
            
            
            ModifyAction modifyAction=null;
            try {
                modifyAction = new ModifyAction(patientID); //passing patientID to ModifyAction class for processing
            } catch (SQLException ex) {
                out.println("User Doesn't Exit");
                Logger.getLogger(ModifyServlet.class.getName()).log(Level.SEVERE, null, ex);
                return;
            }
    
            Personal_Details personalDetails = modifyAction.getPersonalDetails();
       System.out.println("servlet says date here is "+personalDetails.getDateOfRegistration());
//            System.out.println("grgr");
            request.setAttribute("date_of_reg",personalDetails.getDateOfRegistration());
            request.setAttribute("first_name",personalDetails.getFirstName());
            request.setAttribute("home_address",personalDetails.getHomeAddress());
            request.setAttribute("lga",personalDetails.getLGA());
            request.setAttribute("id_card_number",personalDetails.getNationalIDCardNumber());
            request.setAttribute("country",personalDetails.getNationality());
            request.setAttribute("other_name",personalDetails.getOtherName());
            request.setAttribute("phone_number",personalDetails.getPhoneNumber());
            request.setAttribute("state",personalDetails.getStateOfOrigin());
            request.setAttribute("surname",personalDetails.getSurname());
            request.setAttribute("town",personalDetails.getTown());
                   
            //Capture fields from the next of kin section
            Next_Of_Kin nextOfKin = modifyAction.getNextOfKin();
            request.setAttribute("next_of_kin_first_name",nextOfKin.getFirstName());
            request.setAttribute("nk_home_address",nextOfKin.getHomeAddress());
            request.setAttribute("nk_lga",nextOfKin.getLGA());
            request.setAttribute("nk_country",nextOfKin.getNationality());
            request.setAttribute("next_of_kin_other_name",nextOfKin.getOtherName());
            request.setAttribute("kin_number",nextOfKin.getPhoneNumber());
            request.setAttribute("relationship",nextOfKin.getRelationshipToNextOfKin());
            request.setAttribute("nk_state",nextOfKin.getState());
            request.setAttribute("next_of_kin_surname",nextOfKin.getSurname());
            request.setAttribute("nk_town",nextOfKin.getTown());
            
            //capture fields from the diagnosis section
            Diagnosis diagnosis= modifyAction.getDiagnosis();
            request.setAttribute("code_number",diagnosis.getCodeNumber());
            request.setAttribute("date_diagnosed",diagnosis.getDate());
            request.setAttribute("date_discharge",diagnosis.getDateDischarged());
            request.setAttribute("diagnosis",diagnosis.getDiagnosis());
            
            
            //Capture fields from the hospital history section
            Hospital_History hospitalHistory =modifyAction.getHospitalHistory();
            request.setAttribute("date_admitted",hospitalHistory.getDateAdmitted());
            request.setAttribute("date_discharge",hospitalHistory.getDateDischarged());
            request.setAttribute("discharge_to",hospitalHistory.getDischargedTo());
            request.setAttribute("outcome",hospitalHistory.getOutcomeOfCare());
            request.setAttribute("refby_physician",hospitalHistory.getReferredBy());
            request.setAttribute("refto_physician",hospitalHistory.getReferredTo());
            
            
            //Capture fields from the operations section
            Operations operations = modifyAction.getOperations();
            request.setAttribute("operation_code_number",operations.getCodeNumber());
            request.setAttribute("operation_date",operations.getDate());
            request.setAttribute("op_surgeon",operations.getOpSurgeon());
            request.setAttribute("operation",operations.getOperation());

            //Capture fields from the other information section
            Other_Information otherInformation = modifyAction.getOtherInformation();
            request.setAttribute("higher_level",otherInformation.getEducationalLevel());
            request.setAttribute("other_town",otherInformation.getTown());
            
            //Capture fields from the NHIS information section
            NHIS_Information nhisInfo = modifyAction.getNhisInfo();
            request.setAttribute("allergies",nhisInfo.getAllergies());
            request.setAttribute("blood_group",nhisInfo.getBloodGroup());
            request.setAttribute("employer",nhisInfo.getEmployer());
            request.setAttribute("employers_address",nhisInfo.getEmployerAddress());
            request.setAttribute("genotype",nhisInfo.getGenotype());
            request.setAttribute("hmo",nhisInfo.getHMO());
            request.setAttribute("hmo_code",nhisInfo.getHmoCode());
            request.setAttribute("hmo_id_no",nhisInfo.getHmosIDNumber());
//            request.setAttribute("nhis_number",nhisInfo.getNHISNumber());
//           
//            
//            request.getRequestDispatcher("modify.jsp").forward(request, response);
            request.getRequestDispatcher("/modify.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
