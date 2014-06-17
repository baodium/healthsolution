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
public class OtherInformation extends Entity{

    private static OtherInformation instance;

    private OtherInformation(){
    }

    public static OtherInformation getInstance(){
        return instance==null?instance=new OtherInformation():instance;
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public String getName(){
        return "Other_Information_";
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public String getColumnName(int columnIndex) throws NoSuchColumnException{
        switch(columnIndex){
            case 2:
                return "other_town_";
            case 3:
                return "highest_edu_level_";
            default:
                return super.getColumnName(columnIndex);
        }
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public int getColumnCount(){
        return 3;
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public int getIndex(){
        return 5;
    }
}
