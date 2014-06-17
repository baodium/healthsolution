/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Register.data;

/**
 *
 * @author AZEEZ TAIWO
 */
public class Personal_Details {
    private String surname;
    private String firstName;
    private String otherName;
    private String phoneNumber;
    private String homeAddress;
    private String town;
    private String nationality;
    private String LGA;
    private String dateOfRegistration;
    private String nationalIDCardNumber;
    private String stateOfOrigin;

    /**
     * 
     * @return
     */
    public String getSurname() {
        return surname;
    }

    /**
     * 
     * @param surname the value of surname
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * 
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * 
     * @param firstName the value of firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * 
     * @return
     */
    public String getOtherName() {
        return otherName;
    }

    /**
     * 
     * @param otherName the value of otherName
     */
    public void setOtherName(String otherName) {
        this.otherName = otherName;
    }

    /**
     * 
     * @return
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * 
     * @param phoneNumber the value of phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * 
     * @return
     */
    public String getHomeAddress() {
        return homeAddress;
    }

    /**
     * 
     * @param homeAddress the value of homeAddress
     */
    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    /**
     * 
     * @return
     */
    public String getTown() {
        return town;
    }

    /**
     * 
     * @param town the value of town
     */
    public void setTown(String town) {
        this.town = town;
    }

    /**
     * 
     * @return
     */
    public String getNationality() {
        return nationality;
    }

    /**
     * 
     * @param nationality the value of nationality
     */
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    /**
     * 
     * @return
     */
    public String getLGA() {
        return LGA;
    }

    /**
     * 
     * @param LGA the value of LGA
     */
    public void setLGA(String LGA) {
        this.LGA = LGA;
    }

    /**
     * 
     * @return
     */
    public String getDateOfRegistration() {
        return dateOfRegistration;
    }

    /**
     * 
     * @param dateOfRegistration the value of dateOfRegistration
     */
    public void setDateOfRegistration(String dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
    }

    /**
     * 
     * @return
     */
    public String getNationalIDCardNumber() {
        return nationalIDCardNumber;
    }

    /**
     * 
     * @param nationalIDCardNumber the value of nationalIDCardNumber
     */
    public void setNationalIDCardNumber(String nationalIDCardNumber) {
        this.nationalIDCardNumber = nationalIDCardNumber;
    }

    /**
     * 
     * @return
     */
    public String getStateOfOrigin() {
        return stateOfOrigin;
    }

    /**
     * @param stateOfOrigin
     */
    public void setStateOfOrigin(String stateOfOrigin) {
        this.stateOfOrigin = stateOfOrigin;
    }
    
    public String toString(){
        return "PersonalDetails";
    }
}
