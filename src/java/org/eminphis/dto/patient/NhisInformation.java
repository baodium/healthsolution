package org.eminphis.dto.patient;

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
public class NhisInformation{

    private long hospitalNumber;
    private final long nhisNumber;
    private final String hmo;
    private final String hmoCode;
    private final String genotype;
    private final String bloodGroup;
    private final String hmoId;
    private final String employer;
    private final String addressOfEmployer;
    private final String allergies;

    public NhisInformation(long nhisNumber,String hmo,String hmoCode,String genotype,String bloodGroup,String hmoId,
            String employer,String addressOfEmployer,String allergies){
        this.nhisNumber=nhisNumber;
        this.hmo=hmo;
        this.hmoCode=hmoCode;
        this.genotype=genotype;
        this.bloodGroup=bloodGroup;
        this.hmoId=hmoId;
        this.employer=employer;
        this.addressOfEmployer=addressOfEmployer;
        this.allergies=allergies;
    }

    public long getNhisNumber(){
        return nhisNumber;
    }

    public String getHmo(){
        return hmo;
    }

    public String getHmoCode(){
        return hmoCode;
    }

    public String getGenotype(){
        return genotype;
    }

    public String getBloodGroup(){
        return bloodGroup;
    }

    public String getHmoId(){
        return hmoId;
    }

    public String getEmployer(){
        return employer;
    }

    public String getAddressOfEmployer(){
        return addressOfEmployer;
    }

    public String getAllergies(){
        return allergies;
    }

}
