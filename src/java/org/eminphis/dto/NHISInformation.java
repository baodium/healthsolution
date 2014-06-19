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

    private final String nHISNumber;
    private final String hMO;
    private final String genotype;
    private final String bloodGroup;
    private final String hMOCode;
    private final String hMOIDNumber;
    private String employer;
    private final String employerAddress;
    private final String allergies;

    public NHISInformation(String nHISNumber,String hMO,String genotype,String bloodGroup,
            String hMOCode,String hMOIDNumber,String employer,String employerAddress,
            String allergies){
        this.nHISNumber=nHISNumber;
        this.hMO=hMO;
        this.genotype=genotype;
        this.bloodGroup=bloodGroup;
        this.hMOCode=hMOCode;
        this.hMOIDNumber=hMOIDNumber;
        this.employer=employer;
        this.employerAddress=employerAddress;
        this.allergies=allergies;
    }

    public String getNHISNumber(){
        return nHISNumber;
    }

    public String getHMO(){
        return hMO;
    }

    public String getGenotype(){
        return genotype;
    }

    public String getBloodGroup(){
        return bloodGroup;
    }

    public String getHMOCode(){
        return hMOCode;
    }

    public String getHMOIDNumber(){
        return hMOIDNumber;
    }

    public String getEmployer(){
        return employer;
    }
    
    public void setEmployer(String employer){
        this.employer=employer;
    }

    public String getEmployerAddress(){
        return employerAddress;
    }

    public String getAllergies(){
        return allergies;
    }
}
