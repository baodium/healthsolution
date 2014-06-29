package org.eminphis.dto.patient;

/**
 * <u>e-MINPHIS</u><br>
 * A project of the Health Information Systems Unit of the<br>
 * Department of Computer Science and Engineering,<br>
 * Obafemi Awolowo University, Ile-Ife.<br>
 *
 *
 * <pre>
 * Class name: HospitalHistory.java
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
public class HospitalHistory{

    private final String dateAdmitted;
    private final String referredBy;
    private final String dateDischarged;
    private final String referredTo;
    private final String dischargedTo;
    private final String outcomeOfCare;

    public HospitalHistory(String dateAdmitted,String referredBy,String dateDischarged,
            String referredTo,String dischargedTo,String outcomeOfCare){
        this.dateAdmitted=dateAdmitted;
        this.referredBy=referredBy;
        this.dateDischarged=dateDischarged;
        this.referredTo=referredTo;
        this.dischargedTo=dischargedTo;
        this.outcomeOfCare=outcomeOfCare;
    }

    public String getDateAdmitted(){
        return dateAdmitted;
    }

    public String getReferredBy(){
        return referredBy;
    }

    public String getDateDischarged(){
        return dateDischarged;
    }

    public String getReferredTo(){
        return referredTo;
    }

    public String getDischargedTo(){
        return dischargedTo;
    }

    public String getOutcomeOfCare(){
        return outcomeOfCare;
    }
}
