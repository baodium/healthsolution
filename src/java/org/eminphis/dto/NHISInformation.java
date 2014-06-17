package org.eminphis.dto;

/**
 * <u>e-MINPHIS</u><br>
 * A project of the Health Information Systems Unit of the<br>
 * Department of Computer Science and Engineering,<br>
 * Obafemi Awolowo University, Ile-Ife.<br>
 *
 *
 * <pre>
 * Class name: NHISInformation.java
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
public class NHISInformation{

    private final String NHISNumber;
    private final String HMO;
    private final String genotype;
    private final String bloodGroup;
    private final String hmoCode;
    private final String hmosIDNumber;
    private final String employer;
    private final String employerAddress;
    private final String allergies;

    public NHISInformation(String NHISNumber,String HMO,String genotype,String bloodGroup,
            String hmoCode,String hmosIDNumber,String employer,String employerAddress,
            String allergies){
        this.NHISNumber=NHISNumber;
        this.HMO=HMO;
        this.genotype=genotype;
        this.bloodGroup=bloodGroup;
        this.hmoCode=hmoCode;
        this.hmosIDNumber=hmosIDNumber;
        this.employer=employer;
        this.employerAddress=employerAddress;
        this.allergies=allergies;
    }

    public String getNHISNumber(){
        return NHISNumber;
    }

    public String getHMO(){
        return HMO;
    }

    public String getGenotype(){
        return genotype;
    }

    public String getBloodGroup(){
        return bloodGroup;
    }

    public String getHmoCode(){
        return hmoCode;
    }

    public String getHmosIDNumber(){
        return hmosIDNumber;
    }

    public String getEmployer(){
        return employer;
    }

    public String getEmployerAddress(){
        return employerAddress;
    }

    public String getAllergies(){
        return allergies;
    }
}
