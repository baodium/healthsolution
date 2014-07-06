package org.eminphis.dto.tableview;

/**
 * <u>e-MINPHIS</u><br>
 * A project of the Health Information Systems Unit of the<br>
 * Department of Computer Science and Engineering,<br>
 * Obafemi Awolowo University, Ile-Ife.<br>
 *
 *
 * <pre>
 * Class name: ScheduleAppointmentEncapsulator.java
 * Version: 1.0
 * Author: Essiennta Emmanuel (colourfulemmanuel@gmail.com)
 *
 * <u>Description</u>
 * Represents a vertical view of the Patient's table. Created to hold patient's ID number and
 * their full names.
 *
 *
 * </pre>
 *
 * @author Essiennta Emmanuel (colourfulemmanuel@gmail.com)
 * @version 1.0
 */
public class SearchPatientMatch implements Match{

    private final long hospitalNumber;
    private final long nhisNumber;
    private final String surname;
    private final String firstName;
    private final String otherName;

    public SearchPatientMatch(long hospitalNumber,long nhisNumber,String surname,String firstName,String otherName){
        this.hospitalNumber=hospitalNumber;
        this.nhisNumber=nhisNumber;
        this.surname=surname;
        this.firstName=firstName;
        this.otherName=otherName;
    }

    public long getHospitalNumber(){
        return hospitalNumber;
    }

    public long getNhisNumber(){
        return nhisNumber;
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

    /**
     * Given the string returned by toString() of an object of
     * this type, this method retrieves the ID in the string.
     *
     * @param stringRepresentation the string returned by toString() of
     *                             an object of type {@link Match}
     * @return the ID
     */
    public static long retrieveHospitalNumber(String stringRepresentation){
        int indexOfRightSquareBracket=stringRepresentation.length()-1;
        int indexOfLeftSquareBracket=indexOfRightSquareBracket;
        while(--indexOfLeftSquareBracket>=0&&Character.isDigit(stringRepresentation.charAt(
                indexOfLeftSquareBracket)));
//            assert stringRepresentation.charAt(indexOfLeftSquareBracket)=='[';
        return Integer.parseInt(stringRepresentation.substring(indexOfLeftSquareBracket+1,
                indexOfRightSquareBracket));
    }

    @Override
    public String getRepresentation(){
        return surname+" "+firstName+" "+otherName+" [NHIS ID:"+nhisNumber+", Hospital ID:"+hospitalNumber+"]";
    }
}
