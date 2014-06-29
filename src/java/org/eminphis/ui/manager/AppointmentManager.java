
package org.eminphis.ui.manager;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eminphis.dto.Appointment;

/**
 * <u>e-MINPHIS</u><br>
 * A project of the Health Information Systems Unit of the<br>
 * Department of Computer Science and Engineering,<br>
 * Obafemi Awolowo University, Ile-Ife.<br>
 * 
 * 
 * <pre>
 * Class name: AppointmentManager.java
 * Version: 1.0
 * Author: Essiennta Emmanuel (colourfulemmanuel@gmail.com)
 * 
 * <u>Description</u>
 * 
 * 
 * </pre>
 * @author Essiennta Emmanuel (colourfulemmanuel@gmail.com)
 * @version 1.0
 */
public class AppointmentManager extends UIManager{

    public AppointmentManager(HttpServletRequest request,HttpServletResponse response){
        super(request,response);
    }

    public Appointment retrieveAppointment(){
        return new Appointment(
                retrieveID(),
                request.getParameter("patient_dob"),
                request.getParameter("hospital_number"),
                request.getParameter("appointment_type"),
                request.getParameter("clinic"),
                request.getParameter("appointment_date"),
                request.getParameter("consultant_to_see"),
                request.getParameter("appointment_reason"),
                request.getParameter("appointment_referral"),
                request.getParameter("appointment_tally_number"),
                request.getParameter("appointment_time_name")
        );
    }

    private long retrieveID(){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
