
package org.eminphis.dto.tableview;

/**
 * <u>e-MINPHIS</u><br>
 * A project of the Health Information Systems Unit of the<br>
 * Department of Computer Science and Engineering,<br>
 * Obafemi Awolowo University, Ile-Ife.<br>
 * 
 * 
 * <pre>
 * Class name: PatientDetailsViewScheduleAppointment.java
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
public class PatientDetailsViewScheduleAppointment {
    
    private final long ID;
    private final String surname;
    private final String firstName;
    private final String otherName;
    private final String dateOfBirth;
    private final String hospitalNumber;

    public PatientDetailsViewScheduleAppointment(long ID,String surname,String firstName,
            String otherName,String dateOfBirth,String hospitalNumber){
        this.ID=ID;
        this.surname=surname;
        this.firstName=firstName;
        this.otherName=otherName;
        this.dateOfBirth=dateOfBirth;
        this.hospitalNumber=hospitalNumber;
    }
}
