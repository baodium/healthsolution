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
public class Other_Information {
    private String town;
    private String educationalLevel;

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
    public String getEducationalLevel() {
        return educationalLevel;
    }

    /**
     * 
     * @param educationalLevel
     */
    public void setEducationalLevel(String educationalLevel) {
        this.educationalLevel = educationalLevel;
    }
    public String toString(){
        return "OtherInformation";
    }
}
