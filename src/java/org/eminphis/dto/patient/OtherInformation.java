package org.eminphis.dto.patient;

/**
 * <u>e-MINPHIS</u><br>
 * A project of the Health Information Systems Unit of the<br>
 * Department of Computer Science and Engineering,<br>
 * Obafemi Awolowo University, Ile-Ife.<br>
 *
 *
 * <pre>
 * Class name: OtherInformation.java
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
public class OtherInformation{

    private final String town;
    private final String educationalLevel;

    public OtherInformation(String town,String educationalLevel){
        this.town=town;
        this.educationalLevel=educationalLevel;
    }

    public String getTown(){
        return town;
    }

    public String getEducationalLevel(){
        return educationalLevel;
    }
}
