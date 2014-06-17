package org.eminphis.dto;

/**
 * <u>e-MINPHIS</u><br>
 * A project of the Health Information Systems Unit of the<br>
 * Department of Computer Science and Engineering,<br>
 * Obafemi Awolowo University, Ile-Ife.<br>
 *
 *
 * <pre>
 * Class name: PersonalDetails.java
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
public class PersonalDetails{

    private final String surname;
    private final String firstName;
    private final String otherName;
    private final String phoneNumber;
    private final String homeAddress;
    private final String town;
    private final String nationality;
    private final String LGA;
    private final String dateOfRegistration;
    private final String nationalIDCardNumber;
    private final String stateOfOrigin;

    public PersonalDetails(String surname,String firstName,String otherName,String phoneNumber,
            String homeAddress,String town,String nationality,String LGA,String dateOfRegistration,
            String nationalIDCardNumber,String stateOfOrigin){
        this.surname=surname;
        this.firstName=firstName;
        this.otherName=otherName;
        this.phoneNumber=phoneNumber;
        this.homeAddress=homeAddress;
        this.town=town;
        this.nationality=nationality;
        this.LGA=LGA;
        this.dateOfRegistration=dateOfRegistration;
        this.nationalIDCardNumber=nationalIDCardNumber;
        this.stateOfOrigin=stateOfOrigin;
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

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public String getHomeAddress(){
        return homeAddress;
    }

    public String getTown(){
        return town;
    }

    public String getNationality(){
        return nationality;
    }

    public String getLGA(){
        return LGA;
    }

    public String getDateOfRegistration(){
        return dateOfRegistration;
    }

    public String getNationalIDCardNumber(){
        return nationalIDCardNumber;
    }

    public String getStateOfOrigin(){
        return stateOfOrigin;
    }
}
