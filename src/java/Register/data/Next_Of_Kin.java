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
public class Next_Of_Kin {
    private String surname;
    private String firstName;
    private String otherName;
    private String HomeAddress;
    private String town;
    private String nationality;
    private String state;
    private String LGA;
    private String relationshipToNextOfKin;
    private String phoneNumber;

    /**
     * 
     * @return
     */
    public String getSurname() {
        return surname;
    }

    /**
     * 
     * @param surname
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
     * @param firstName
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
     * @param otherName
     */
    public void setOtherName(String otherName) {
        this.otherName = otherName;
    }

    /**
     * 
     * @return
     */
    public String getHomeAddress() {
        return HomeAddress;
    }

    /**
     * 
     * @param HomeAddress
     */
    public void setHomeAddress(String HomeAddress) {
        this.HomeAddress = HomeAddress;
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
     * @param town
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
     * @param nationality
     */
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    /**
     * 
     * @return
     */
    public String getState() {
        return state;
    }

    /**
     * 
     * @param state
     */
    public void setState(String state) {
        this.state = state;
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
     * @param LGA
     */
    public void setLGA(String LGA) {
        this.LGA = LGA;
    }

    /**
     * 
     * @return
     */
    public String getRelationshipToNextOfKin() {
        return relationshipToNextOfKin;
    }

    /**
     * 
     * @param relationshipToNextOfKin
     */
    public void setRelationshipToNextOfKin(String relationshipToNextOfKin) {
        this.relationshipToNextOfKin = relationshipToNextOfKin;
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
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    @Override
    public String toString(){
        return "NextOfKin";
    }
}
