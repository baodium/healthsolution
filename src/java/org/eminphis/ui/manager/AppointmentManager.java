package org.eminphis.ui.manager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eminphis.dto.Appointment;
import org.eminphis.dto.Group;
import org.eminphis.dto.tableview.ScheduleAppointmentMatch;

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
 *
 * @author Essiennta Emmanuel (colourfulemmanuel@gmail.com)
 * @version 1.0
 */
public class AppointmentManager extends UIManager{

    private Integer mode;
    private String value;

    public AppointmentManager(HttpServletRequest request,HttpServletResponse response){
        super(request,response);
    }

    public Appointment retrieveAppointment(){
        return new Appointment(
                //                Long.parseLong(request.getParameter("hospital_number")),         PLUG THIS IN WHEN SELECTION EVENT HAS BEEN HANDLED.
                ScheduleAppointmentMatch.retrieveHospitalNumber(retrieveQuery()),
                ScheduleAppointmentMatch.retrieveFullName(retrieveQuery()),
                request.getParameter("patient_dob"),
                request.getParameter("appt_type"),
                request.getParameter("appt_clinic"),
                request.getParameter("appt_date"),
                request.getParameter("appt_consultant"),
                request.getParameter("appt_reason"),
                request.getParameter("appt_referral"),
                request.getParameter("appt_tally_num"),
                request.getParameter("clinic_time")
        );
    }

    public void setMode(Integer mode){
        this.mode=mode;
    }

    public void setValue(String value){
        this.value=value;
    }

    public void showAppointmentDetails(Group<Appointment> appointments) throws ServletException,IOException{
        request.setAttribute(Group.class.getName(),appointments);
        request.setAttribute("VIEW_SHOW",Boolean.TRUE);

        switch(mode){
            case Appointment.MODE_CLINIC:
                request.getRequestDispatcher("/viewClinicAppointment.jsp").forward(request,response);
                break;
            case Appointment.MODE_CONSULTANT:
                request.getRequestDispatcher("/viewConsultantAppointment.jsp").forward(request,response);
                break;
            case Appointment.MODE_DATE:
                request.getRequestDispatcher("/viewApptByDate.jsp").forward(request,response);
                break;
        }
        request.setAttribute("VIEW_SHOW",Boolean.FALSE);
    }
}
