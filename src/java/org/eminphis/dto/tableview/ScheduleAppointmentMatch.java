package org.eminphis.dto.tableview;

/**
 * <u>e-MINPHIS</u><br>
 * A project of the Health Information Systems Unit of the<br>
 * Department of Computer Science and Engineering,<br>
 * Obafemi Awolowo University, Ile-Ife.<br>
 *
 *
 * <pre>
 * Class name: ScheduleAppointmentMatch.java
 * Version: 1.0
 * Author: Essiennta Emmanuel (colourfulemmanuel@gmail.com)
 * <u>Description</u>
 *
 * </pre>
 * <p>
 * @author Essiennta Emmanuel (colourfulemmanuel@gmail.com)
 * @version 1.0
 */
public class ScheduleAppointmentMatch implements Match{

    private final long ID;
    private final String surname;
    private final String firstName;
    private final String otherName;
    private final String dateOfBirth;
    private final String hospitalNumber;

    public ScheduleAppointmentMatch(long ID,String surname,String firstName,
            String otherName,String dateOfBirth,String hospitalNumber){
        this.ID=ID;
        this.surname=surname;
        this.firstName=firstName;
        this.otherName=otherName;
        this.dateOfBirth=dateOfBirth;
        this.hospitalNumber=hospitalNumber;
    }

    public long getID(){
        return ID;
    }

    public String getSurname(){
        return surname;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getOtherName(){
        return otherName;
    }

    public String getDateOfBirth(){
        return dateOfBirth;
    }

    public String getHospitalNumber(){
        return hospitalNumber;
    }

    @Override
    public String getRepresentation(){
        return surname+" "+firstName+" "+otherName;
    }
}
