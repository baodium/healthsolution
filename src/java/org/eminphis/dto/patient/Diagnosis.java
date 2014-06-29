package org.eminphis.dto.patient;

/**
 * <u>e-MINPHIS</u><br>
 * A project of the Health Information Systems Unit of the<br>
 * Department of Computer Science and Engineering,<br>
 * Obafemi Awolowo University, Ile-Ife.<br>
 *
 *
 * <pre>
 * Class name: Diagnosis.java
 * Version: 1.0
 * Author: Essiennta Emmanuel (colourfulemmanuel@gmail.com)
 *
 * <u>Description</u>
 *
 *
 * </pre>
 *
 * @author Essiennta Emmanuel (colourfulemmanuel@gmail.com)
 * @version 1.0.
 */
public class Diagnosis{

    private final String dateDiagnosed;
    private final String dateDischarged;
    private final String diagnosis;
    private final String codeNumber;

    public Diagnosis(String dateDiagnosed,String dateDischarged,String diagnosis,String codeNumber){
        this.dateDiagnosed=dateDiagnosed;
        this.dateDischarged=dateDischarged;
        this.diagnosis=diagnosis;
        this.codeNumber=codeNumber;
    }

    public String getDateDiagnosed(){
        return dateDiagnosed;
    }

    public String getDateDischarged(){
        return dateDischarged;
    }

    public String getDiagnosis(){
        return diagnosis;
    }

    public String getCodeNumber(){
        return codeNumber;
    }
}
