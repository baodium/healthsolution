package org.eminphis.dto.tableview;

import java.util.regex.Matcher;

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

    private static final java.util.regex.Pattern pattern=java.util.regex.Pattern.compile(
            "(.+) \\[NHIS ID:(\\d+), Hospital ID:(\\d+)\\]");

    private final long hospitalNumber;
    private final long nhisNumber;
    private final String surname;
    private final String firstName;
    private final String otherName;
    private final String dateOfBirth;

    public ScheduleAppointmentMatch(long hospitalNumber,long nhisNumber,String surname,String firstName,String otherName,
            String dateOfBirth){
        this.hospitalNumber=hospitalNumber;
        this.nhisNumber=nhisNumber;
        this.surname=surname;
        this.firstName=firstName;
        this.otherName=otherName;
        this.dateOfBirth=dateOfBirth;
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

    public String getDateOfBirth(){
        return dateOfBirth;
    }

    /**
     * Given the string returned by toString() of an object of
     * this type, this method retrieves the hospital number in the string.
     *
     * @param stringRepresentation the string returned by getRepresentation() of
     *                             an object of type {@link Match}
     * @return the hospital number
     */
    public static long retrieveHospitalNumber(String stringRepresentation){
        final Matcher matcher=pattern.matcher(stringRepresentation);
        if(matcher.matches())
            return Long.parseLong(matcher.group(3));
        throw new RuntimeException("corrupted query");
    }

    /**
     * Given the string returned by toString() of an object of
     * this type, this method retrieves the NHIS number in the string.
     *
     * @param stringRepresentation the string returned by getRepresentation() of
     *                             an object of type {@link Match}
     * @return the NHIS number
     */
    public static long retrieveNhisNumber(String stringRepresentation){
        final Matcher matcher=pattern.matcher(stringRepresentation);
        if(matcher.matches())
            return Long.parseLong(matcher.group(2));
        throw new RuntimeException("corrupted query");
    }

    /**
     * Given the string returned by toString() of an object of
     * this type, this method retrieves the full name in the string.
     *
     * @param stringRepresentation the string returned by getRepresentation() of
     *                             an object of type {@link Match}
     * @return the NHIS number
     */
    public static String retrieveFullName(String stringRepresentation){
        final Matcher matcher=pattern.matcher(stringRepresentation);
        if(matcher.matches())
            return matcher.group(1);
        throw new RuntimeException("corrupted query");
    }

    @Override
    public String getRepresentation(){
        return surname+" "+firstName+" "+otherName+" [NHIS ID:"+nhisNumber+", Hospital ID:"+hospitalNumber+"]";
    }
}
