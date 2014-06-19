package org.eminphis.entities;

import org.eminphis.exceptions.NoSuchColumnException;

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
public class NHISInformation extends Entity{

    private static NHISInformation instance;

    private NHISInformation(){
    }

    public static NHISInformation getInstance(){
        return instance==null?instance=new NHISInformation():instance;
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public String getName(){
        return "NHIS_Information_";
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public String getColumnName(int columnIndex) throws NoSuchColumnException{
        switch(columnIndex){
            case 2:
                return "nhis_number_";
            case 3:
                return "hmo_";
            case 4:
                return "genotype_";
            case 5:
                return "blood_group_";
            case 6:
                return "hmo_code_";
            case 7:
                return "hmos_id_";
            case 8:
                return "employer_";
            case 9:
                return "employers_address_";
            case 10:
                return "allergies_";
            default:
                return super.getColumnName(columnIndex);
        }
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public int getColumnCount(){
        return 10;
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public int getIndex(){
        return 2;
    }
}
