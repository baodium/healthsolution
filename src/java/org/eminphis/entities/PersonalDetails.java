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
 * Class name: PersonalDetails.java
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
public class PersonalDetails extends Entity{

    private static PersonalDetails instance;

    private PersonalDetails(){
    }

    public static PersonalDetails getInstance(){
        return instance==null?instance=new PersonalDetails():instance;
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public String getName(){
        return "Personal_Details_";
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public String getColumnName(int columnIndex) throws NoSuchColumnException{
        switch(columnIndex){
            case 2:
                return "surname_";
            case 3:
                return "first_name_";
            case 4:
                return "other_name_";
            case 5:
                return "phone_number_";
            case 6:
                return "home_address_";
            case 7:
                return "town_";
            case 8:
                return "nationality_";
            case 9:
                return "l_g_a_";
            case 10:
                return "date_of_registration_";
            case 11:
                return "national_i_d_card_number_";
            case 12:
                return "state_of_origin_";
            default:
                return super.getColumnName(columnIndex);
        }
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public int getColumnCount(){
        return 12;
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public int getIndex(){
        return 6;
    }
}
