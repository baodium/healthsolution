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
public class HospitalHistory extends Entity{

    private static HospitalHistory instance;

    private HospitalHistory(){
    }

    public static HospitalHistory getInstance(){
        return instance==null?instance=new HospitalHistory():instance;
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public String getName(){
        return "Hospital_History_";
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public String getColumnName(int columnIndex) throws NoSuchColumnException{
        switch(columnIndex){
            case 2:
                return "date_admitted_";
            case 3:
                return "refby_physician_";
            case 4:
                return "date_discharge_";
            case 5:
                return "refto_physician_";
            case 6:
                return "discharge_to_";
            case 7:
                return "outcome_";
            default:
                return super.getColumnName(columnIndex);
        }
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public int getColumnCount(){
        return 7;
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public int getIndex(){
        return 1;
    }
}
