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
 * Class name: Operations.java
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
public class Operations extends Entity{

    private static Operations instance;

    private Operations(){
    }

    public static Operations getInstance(){
        return instance==null?instance=new Operations():instance;
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public String getName(){
        return "Operations_";
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public String getColumnName(int columnIndex) throws NoSuchColumnException{
        switch(columnIndex){
            case 2:
                return "operation_date_";
            case 3:
                return "op_surgeon_";
            case 4:
                return "operation_";
            case 5:
                return "operation_code_number_";
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
        return 4;
    }
}
