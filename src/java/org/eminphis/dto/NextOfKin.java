package org.eminphis.dto;

/**
 * <u>e-MINPHIS</u><br>
 * A project of the Health Information Systems Unit of the<br>
 * Department of Computer Science and Engineering,<br>
 * Obafemi Awolowo University, Ile-Ife.<br>
 *
 *
 * <pre>
 * Class name: NextOfKin.java
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
public class NextOfKin{

    private final String surname;
    private final String firstName;
    private final String otherName;
    private final String HomeAddress;
    private final String town;
    private final String nationality;
    private final String state;
    private final String lGA;
    private final String relationshipToNextOfKin;
    private final String phoneNumber;

    public NextOfKin(String surname,String firstName,String otherName,String HomeAddress,
            String town,String nationality,String state,String lGA,String relationshipToNextOfKin,
            String phoneNumber){
        this.surname=surname;
        this.firstName=firstName;
        this.otherName=otherName;
        this.HomeAddress=HomeAddress;
        this.town=town;
        this.nationality=nationality;
        this.state=state;
        this.lGA=lGA;
        this.relationshipToNextOfKin=relationshipToNextOfKin;
        this.phoneNumber=phoneNumber;
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

    public String getHomeAddress(){
        return HomeAddress;
    }

    public String getTown(){
        return town;
    }

    public String getNationality(){
        return nationality;
    }

    public String getState(){
        return state;
    }

    public String getLGA(){
        return lGA;
    }

    public String getRelationshipToNextOfKin(){
        return relationshipToNextOfKin;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }
}
