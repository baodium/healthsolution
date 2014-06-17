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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;


/**
 *
 * @author AZEEZ TAIWO
 */
public class RegisterServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     */
    public RegisterServlet() {
        super();
    // TODO Auto-generated constructor stub
    }

    /**
     * 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Register</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Register at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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

        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        //System.out.println("Received request");
            //String connectionURL = "jdbc:mysql://127.0.0.1:3306/newData";// newData is the database  
        //Connection connection;  
        Connection conn = null;
        Statement st;
        try {
            //Capture Fields from the personal details section
            Personal_Details personalDetails=new Personal_Details();
            personalDetails.setDateOfRegistration(request.getParameter("date_of_reg"));
            personalDetails.setFirstName(request.getParameter("first_name"));
            personalDetails.setHomeAddress(request.getParameter("home_address"));
            personalDetails.setLGA(request.getParameter("lga"));
            personalDetails.setNationalIDCardNumber(request.getParameter("id_card_number"));
            personalDetails.setNationality(request.getParameter("country"));
            personalDetails.setOtherName(request.getParameter("other_name"));
            personalDetails.setPhoneNumber(request.getParameter("phone_number"));
            personalDetails.setStateOfOrigin(request.getParameter("state"));
            personalDetails.setSurname(request.getParameter("surname"));
            personalDetails.setTown(request.getParameter("town"));
            //Capture fields from the next of kin section
            Next_Of_Kin nextOfKin = new Next_Of_Kin();
            nextOfKin.setFirstName(request.getParameter("next_of_kin_first_name"));
            nextOfKin.setHomeAddress(request.getParameter("nk_home_address"));
            nextOfKin.setLGA(request.getParameter("nk_lga"));
            nextOfKin.setNationality(request.getParameter("nk_lga"));
            nextOfKin.setOtherName(request.getParameter("next_of_kin_other_name"));
            nextOfKin.setPhoneNumber(request.getParameter("kin_number"));
            nextOfKin.setRelationshipToNextOfKin(request.getParameter("relationship"));
            nextOfKin.setState(request.getParameter("nk_state"));
            nextOfKin.setSurname(request.getParameter("next_of_kin_surname"));
            nextOfKin.setTown(request.getParameter("nk_town"));
            
            //capture fields from the diagnosis section
            Diagnosis diagnosis= new Diagnosis();
            diagnosis.setCodeNumber(request.getParameter("code_number"));
            diagnosis.setDateDiagnosed(request.getParameter("date_diagnosed"));
            diagnosis.setDateDischarged(request.getParameter("date_discharge"));
            diagnosis.setDiagnosis(request.getParameter("diagnosis"));
            
            
            //Capture fields from the hospital history section
            Hospital_History hospitalHistory = new Hospital_History();
            hospitalHistory.setDateAdmitted(request.getParameter("date_admitted"));
            hospitalHistory.setDateDischarged(request.getParameter("date_discharge"));
            hospitalHistory.setDischargedTo(request.getParameter("discharge_to"));
            hospitalHistory.setOutcomeOfCare(request.getParameter("outcome"));
            hospitalHistory.setReferredBy(request.getParameter("refby_physician"));
            hospitalHistory.setReferredTo(request.getParameter("refto_physician"));
            
            
            
            //Capture fields from the operations section
            Operations operations = new Operations();
            operations.setCodeNumber(request.getParameter("operation_code_number"));
            operations.setDate(request.getParameter("operation_date"));
            operations.setOpSurgeon(request.getParameter("op_surgeon"));
            operations.setOperation(request.getParameter("operation"));

            //Capture fields from the other information section
            Other_Information otherInformation = new Other_Information();
            otherInformation.setEducationalLevel(request.getParameter("higher_level"));
            otherInformation.setTown(request.getParameter("other_town"));
            
            //Capture fields from the NHIS information section
            NHIS_Information nhisInfo = new NHIS_Information();
            nhisInfo.setAllergies(request.getParameter("allergies"));
            nhisInfo.setBloodGroup(request.getParameter("blood_group"));
            nhisInfo.setEmployer(request.getParameter("employer"));
            nhisInfo.setEmployerAddress(request.getParameter("employers_address"));
            nhisInfo.setGenotype(request.getParameter("genotype"));
            nhisInfo.setHMO(request.getParameter("hmo"));
            nhisInfo.setHmoCode(request.getParameter("hmo_code"));
            nhisInfo.setHmosIDNumber(request.getParameter("hmo_id_no"));
            nhisInfo.setNHISNumber(request.getParameter("nhis_number"));
            
            DbConnect database=new DbConnect();
            database.addData_patient(personalDetails, nextOfKin, hospitalHistory, diagnosis, operations, otherInformation, nhisInfo);
            database.closeDB();
           
            pw.println("<h2>Your information has been added to the database</h2>");
            pw.close();
            System.out.println("success");

        } catch (Exception e) {
            System.out.println("failure");
            e.printStackTrace();
        }

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
