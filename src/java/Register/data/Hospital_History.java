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
public class Hospital_History {
    private String dateAdmitted;
    private String referredBy;
    private String dateDischarged;
    private String referredTo;
    private String dischargedTo;
    private String outcomeOfCare;

    /**
     * 
     * @return
     */
    public String getDateAdmitted() {
        return dateAdmitted;
    }

    /**
     * 
     * @param dateAdmitted
     */
    public void setDateAdmitted(String dateAdmitted) {
        this.dateAdmitted = dateAdmitted;
    }

    /**
     * 
     * @return
     */
    public String getReferredBy() {
        return referredBy;
    }

    /**
     * 
     * @param referredBy
     */
    public void setReferredBy(String referredBy) {
        this.referredBy = referredBy;
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
    public String getReferredTo() {
        return referredTo;
    }

    /**
     * 
     * @param referredTo
     */
    public void setReferredTo(String referredTo) {
        this.referredTo = referredTo;
    }

    /**
     * 
     * @return
     */
    public String getDischargedTo() {
        return dischargedTo;
    }

    /**
     * 
     * @param dischargedTo
     */
    public void setDischargedTo(String dischargedTo) {
        this.dischargedTo = dischargedTo;
    }

    /**
     * 
     * @return
     */
    public String getOutcomeOfCare() {
        return outcomeOfCare;
    }

    /**
     * 
     * @param outcomeOfCare
     */
    public void setOutcomeOfCare(String outcomeOfCare) {
        this.outcomeOfCare = outcomeOfCare;
    }
    public String toString(){
        return "HospitalHistory";
    }
}
