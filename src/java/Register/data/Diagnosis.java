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
public class Diagnosis {
    private String dateDiagnosed;
    private String dateDischarged;
    private String diagnosis;
    private String codeNumber;

    /**
     * 
     * @return
     */
    public String getDate() {
        return dateDiagnosed;
    }

    /**
     * 
     * @param dateDiagnosed
     */
    public void setDateDiagnosed(String dateDiagnosed) {
        this.dateDiagnosed = dateDiagnosed;
    }

    /**
     * 
     * @return
     */
    public String getDateDischarged() {
        return dateDischarged;
    }

    /**
     * 
     * @param dateDischarged
     */
    public void setDateDischarged(String dateDischarged) {
        this.dateDischarged = dateDischarged;
    }

    /**
     * 
     * @return
     */
    public String getDiagnosis() {
        return diagnosis;
    }

    /**
     * 
     * @param diagnosis
     */
    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    /**
     * 
     * @return
     */
    public String getCodeNumber() {
        return codeNumber;
    }

    /**
     * 
     * @param codeNumber
     */
    public void setCodeNumber(String codeNumber) {
        this.codeNumber = codeNumber;
    }
    public String toString(){
        return "Diagnosis";
    }
}
