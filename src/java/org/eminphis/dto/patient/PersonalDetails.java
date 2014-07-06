package org.eminphis.dto.patient;

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

    private long hospitalNumber;
    private final String surname;
    private final String firstName;
    private final String otherName;
    private final String sex;
    private final String maritalStatus;
    private final String maidenName;
    private final String phoneNumbers;//comma separated for now.
    private final String residentialAddress;
    private final String town;
    private final String nationality;
    private final String state;
    private final String lga;
    private final String dateOfRegistration;
    private final String nationalIdCardNumber;
    private final String highestLevelOfEducation;

    public PersonalDetails(String surname,String firstName,String otherName,String sex,String maritalStatus,
            String maidenName,String phoneNumbers,String residentialAddress,String town,String nationality,String state,
            String lga,String dateOfRegistration,String nationalIdCardNumber,String highestLevelOfEducation){
        this.surname=surname;
        this.firstName=firstName;
        this.otherName=otherName;
        this.sex=sex;
        this.maritalStatus=maritalStatus;
        this.maidenName=maidenName;
        this.phoneNumbers=phoneNumbers;
        this.residentialAddress=residentialAddress;
        this.town=town;
        this.nationality=nationality;
        this.state=state;
        this.lga=lga;
        this.dateOfRegistration=dateOfRegistration;
        this.nationalIdCardNumber=nationalIdCardNumber;
        this.highestLevelOfEducation=highestLevelOfEducation;
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

    public String getSex(){
        return sex;
    }

    public String getMaritalStatus(){
        return maritalStatus;
    }

    public String getMaidenName(){
        return maidenName;
    }

    public String getPhoneNumbers(){
        return phoneNumbers;
    }

    public String getResidentialAddress(){
        return residentialAddress;
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

    public String getLga(){
        return lga;
    }

    public String getDateOfRegistration(){
        return dateOfRegistration;
    }

    public String getNationalIdCardNumber(){
        return nationalIdCardNumber;
    }

    public String getHighestLevelOfEducation(){
        return highestLevelOfEducation;
    }
}
