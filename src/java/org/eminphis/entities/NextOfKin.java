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
 * Class name: NextOfKin.java
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
public class NextOfKin extends Entity{

    private static NextOfKin instance;

    private NextOfKin(){
    }

    public static NextOfKin getInstance(){
        return instance==null?instance=new NextOfKin():instance;
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public String getName(){
        return "Next_Of_Kin_";
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public String getColumnName(int columnIndex) throws NoSuchColumnException{
        switch(columnIndex){
            case 2:
                return "next_of_kin_surname_";
            case 3:
                return "next_of_kin_first_name_";
            case 4:
                return "next_of_kin_other_name_";
            case 5:
                return "nk_home_address_";
            case 6:
                return "nk_town_";
            case 7:
                return "nk_country_";
            case 8:
                return "nk_state_";
            case 9:
                return "nk_lga_";
            case 10:
                return "relationship_";
            case 11:
                return "kin_number_";
            default:
                return super.getColumnName(columnIndex);
        }
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public int getColumnCount(){
        return 11;
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public int getIndex(){
        return 3;
    }
}
