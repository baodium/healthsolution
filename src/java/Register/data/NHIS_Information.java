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
public class NHIS_Information {
    private String NHISNumber;
    private String HMO;
    private String genotype;
    private String bloodGroup;
    private String hmoCode;
    private String hmosIDNumber;
    private String employer;
    private String employerAddress;
    private String allergies;

    /**
     * 
     * @return
     */
    public String getNHISNumber() {
        return NHISNumber;
    }

    /**
     * 
     * @param NHISNumber
     */
    public void setNHISNumber(String NHISNumber) {
        this.NHISNumber = NHISNumber;
    }

    /**
     * 
     * @return
     */
    public String getHMO() {
        return HMO;
    }

    /**
     * 
     * @param HMO
     */
    public void setHMO(String HMO) {
        this.HMO = HMO;
    }

    /**
     * 
     * @return
     */
    public String getGenotype() {
        return genotype;
    }

    /**
     * 
     * @param genotype
     */
    public void setGenotype(String genotype) {
        this.genotype = genotype;
    }

    /**
     * 
     * @return
     */
    public String getBloodGroup() {
        return bloodGroup;
    }

    /**
     * 
     * @param bloodGroup
     */
    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    /**
     * 
     * @return
     */
    public String getHmoCode() {
        return hmoCode;
    }

    /**
     * 
     * @param hmoCode
     */
    public void setHmoCode(String hmoCode) {
        this.hmoCode = hmoCode;
    }

    /**
     * 
     * @return
     */
    public String getHmosIDNumber() {
        return hmosIDNumber;
    }

    /**
     * 
     * @param hmosIDNumber
     */
    public void setHmosIDNumber(String hmosIDNumber) {
        this.hmosIDNumber = hmosIDNumber;
    }

    /**
     * 
     * @return
     */
    public String getEmployer() {
        return employer;
    }

    /**
     * 
     * @param employer
     */
    public void setEmployer(String employer) {
        this.employer = employer;
    }

    /**
     * 
     * @return
     */
    public String getEmployerAddress() {
        return employerAddress;
    }

    /**
     * 
     * @param employerAddress
     */
    public void setEmployerAddress(String employerAddress) {
        this.employerAddress = employerAddress;
    }

    /**
     * 
     * @return
     */
    public String getAllergies() {
        return allergies;
    }

    /**
     * 
     * @param allergies
     */
    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }
    public String toString(){
        return "NHIS_Information";
    }
}
