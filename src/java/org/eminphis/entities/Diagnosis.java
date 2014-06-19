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
 * @version 1.0
 */
public class Diagnosis extends Entity{

    private static Diagnosis instance;

    private Diagnosis(){
    }

    public static Diagnosis getInstance(){
        return instance==null?instance=new Diagnosis():instance;
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public String getName(){
        return "Diagnosis_";
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public String getColumnName(int columnIndex) throws NoSuchColumnException{
        switch(columnIndex){
            case 2:
                return "date_diagnosed_";
            case 3:
                return "date_discharged_";
            case 4:
                return "diagnosis_";
            case 5:
                return "code_number_";
            default:
                return super.getColumnName(columnIndex);
        }
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public int getColumnCount(){
        return 5;
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public int getIndex(){
        return 0;
    }
}
