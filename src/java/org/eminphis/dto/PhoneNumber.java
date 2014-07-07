package org.eminphis.dto;

/**
 * <u>e-MINPHIS</u><br>
 * A project of the Health Information Systems Unit of the<br>
 * Department of Computer Science and Engineering,<br>
 * Obafemi Awolowo University, Ile-Ife.<br>
 *
 *
 * <pre>
 * Class name: PhoneNumber.java
 * Version: 1.0
 * Author: Essiennta Emmanuel (colourfulemmanuel@gmail.com)
 *
 * <u>Description</u>
 *
 * </pre>
 *
 * @author Essiennta Emmanuel (colourfulemmanuel@gmail.com)
 * @version 1.0
 */
public class PhoneNumber{

    private final long hospitalNumber;
    private final String phoneNumber;

    public PhoneNumber(long hospitalNumber,String phoneNumber){
        this.hospitalNumber=hospitalNumber;
        this.phoneNumber=phoneNumber;
    }

    public long getHospitalNumber(){
        return hospitalNumber;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }
}
